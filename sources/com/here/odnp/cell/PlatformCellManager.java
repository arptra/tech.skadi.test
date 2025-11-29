package com.here.odnp.cell;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.here.odnp.cell.ICellManager;
import com.here.odnp.util.Log;
import com.here.odnp.util.MasterThread;
import com.here.posclient.CellMeasurement;

public abstract class PlatformCellManager implements ICellManager {
    private static final String TAG = "odnp.cell.PlatformCellManager";
    protected final ConnectivityManager mConnectivityManager;
    protected final Context mContext;
    private long mCurrentCellularStatus;
    private final DchTracker mDchTracker = new DchTracker();
    protected final Handler mHandler;
    protected volatile ICellManager.ICellListener mListener;
    private final BroadcastReceiver mScreenStateReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Log.v(PlatformCellManager.TAG, "ScreenStateReceiver.onReceive: %s", intent);
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                PlatformCellManager.this.onScreenOff();
            } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                PlatformCellManager.this.onScreenOn();
            }
        }
    };
    protected ServiceState mStoredServiceState;
    @NonNull
    protected final TelephonyManager mTelephonyManager;

    public static class DchTracker {
        final Tracker mCallTracker;
        final Tracker mDataTracker;
        private volatile boolean mScreenOn;

        public static class Tracker {
            Long mStarted;
            final String mTrackerName = "";

            public Tracker(String str) {
            }

            public synchronized boolean isActive() {
                return this.mStarted != null;
            }

            public synchronized void startTracking() {
                if (!isActive()) {
                    Long valueOf = Long.valueOf(SystemClock.elapsedRealtime());
                    this.mStarted = valueOf;
                    Log.v(PlatformCellManager.TAG, "startTracking: %s at: %d", this.mTrackerName, valueOf);
                }
            }

            public synchronized void stopTracking() {
                this.mStarted = null;
            }
        }

        private DchTracker() {
            this.mScreenOn = false;
            this.mCallTracker = new Tracker("Call.DCH");
            this.mDataTracker = new Tracker("Data.DCH");
        }

        public boolean isDchModeOn(@NonNull PlatformCellManager platformCellManager) {
            return this.mCallTracker.isActive() || this.mDataTracker.isActive() || !this.mScreenOn;
        }

        public void reset() {
            this.mCallTracker.stopTracking();
            this.mDataTracker.stopTracking();
            this.mScreenOn = false;
        }

        public void setScreen(boolean z) {
            this.mScreenOn = z;
        }

        public void startCallTracking() {
            this.mCallTracker.startTracking();
        }

        public void startDataTracking() {
            this.mDataTracker.startTracking();
        }

        public void stopCallTracking() {
            this.mCallTracker.stopTracking();
        }

        public void stopDataTracking() {
            this.mDataTracker.stopTracking();
        }
    }

    public PlatformCellManager(Context context) {
        this.mContext = context;
        this.mHandler = new Handler(MasterThread.getInstance().getLooper());
        this.mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static ICellManager create(Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            Log.v(TAG, "create: PlatformCellManagerApi31", new Object[0]);
            return new PlatformCellManagerApi31(context);
        }
        Log.v(TAG, "create: PlatformCellManagerApi29", new Object[0]);
        return new PlatformCellManagerApi29(context);
    }

    private static boolean isCallActive(int i) {
        return i == 1 || i == 2;
    }

    private static boolean isDataActive(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    private boolean isNrAvailable(ServiceState serviceState) {
        boolean contains = serviceState.toString().contains("isNrAvailable = true");
        Log.v(TAG, "isNrAvailable: %s", Boolean.valueOf(contains));
        return contains;
    }

    /* access modifiers changed from: private */
    public void onScreenOff() {
        boolean isDchModeOn = this.mDchTracker.isDchModeOn(this);
        this.mDchTracker.setScreen(false);
        if (isDchModeOn != this.mDchTracker.isDchModeOn(this)) {
            pushCellularStatus(this.mStoredServiceState);
        }
    }

    /* access modifiers changed from: private */
    public void onScreenOn() {
        boolean isDchModeOn = this.mDchTracker.isDchModeOn(this);
        this.mDchTracker.setScreen(true);
        if (isDchModeOn != this.mDchTracker.isDchModeOn(this)) {
            pushCellularStatus(this.mStoredServiceState);
        }
    }

    /* access modifiers changed from: private */
    public void registerScreenEvents() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.mContext.registerReceiver(this.mScreenStateReceiver, intentFilter);
        setScreen(((PowerManager) this.mContext.getSystemService("power")).isInteractive());
    }

    private void setScreen(boolean z) {
        if (z) {
            onScreenOn();
        } else {
            onScreenOff();
        }
    }

    /* access modifiers changed from: private */
    public void unregisterScreenEvents() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "unregisterScreenEvents: Could not unregister screen state receiver", new Object[0]);
        }
    }

    public synchronized void close() {
        if (this.mListener != null) {
            this.mListener = null;
            Log.v(TAG, "close: queuing", new Object[0]);
            this.mHandler.post(new Runnable() {
                public void run() {
                    Log.v(PlatformCellManager.TAG, "close: executing", new Object[0]);
                    PlatformCellManager.this.unregisterEventListener();
                    PlatformCellManager.this.unregisterScreenEvents();
                    PlatformCellManager.this.cancelCellScan();
                }
            });
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public CellMeasurement.RANType getNetworkType() {
        if (Build.VERSION.SDK_INT > 29) {
            return CellMeasurement.RANType.UNKNOWN;
        }
        int phoneType = this.mTelephonyManager.getPhoneType();
        int networkType = this.mTelephonyManager.getNetworkType();
        Log.v(TAG, "getNetworkType: PhoneType: %d NetworkType: %d", Integer.valueOf(phoneType), Integer.valueOf(networkType));
        if (phoneType == 1 || phoneType == 0) {
            if (!(networkType == 1 || networkType == 2)) {
                if (networkType != 3) {
                    if (networkType != 13) {
                        if (networkType != 15) {
                            if (networkType != 16) {
                                switch (networkType) {
                                    case 8:
                                    case 9:
                                    case 10:
                                        break;
                                }
                            }
                        }
                    } else {
                        return CellMeasurement.RANType.EUTRA;
                    }
                }
                return CellMeasurement.RANType.UTRAFDD;
            }
            return CellMeasurement.RANType.GERAN;
        }
        return ((phoneType == 2 || phoneType == 0) && (networkType == 4 || networkType == 5 || networkType == 6 || networkType == 7 || networkType == 12 || networkType == 14)) ? CellMeasurement.RANType.CDMA : CellMeasurement.RANType.UNKNOWN;
    }

    public synchronized void open(ICellManager.ICellListener iCellListener) {
        Log.v(TAG, "open: queuing", new Object[0]);
        if (iCellListener != null) {
            close();
            this.mListener = iCellListener;
            this.mHandler.post(new Runnable() {
                public void run() {
                    Log.v(PlatformCellManager.TAG, "open: executing", new Object[0]);
                    PlatformCellManager.this.registerEventListener();
                    PlatformCellManager.this.registerScreenEvents();
                    if (Build.VERSION.SDK_INT < 31) {
                        PlatformCellManager platformCellManager = PlatformCellManager.this;
                        platformCellManager.updateCallState(platformCellManager.mTelephonyManager.getCallState());
                    }
                    PlatformCellManager platformCellManager2 = PlatformCellManager.this;
                    platformCellManager2.updateDataActivityState(platformCellManager2.mTelephonyManager.getDataActivity());
                }
            });
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void pushCellMeasurement(com.here.posclient.CellMeasurement r4, boolean r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.here.odnp.cell.ICellManager$ICellListener r0 = r3.mListener     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            java.lang.Object[] r0 = new java.lang.Object[]{r4}     // Catch:{ all -> 0x001a }
            java.lang.String r1 = "odnp.cell.PlatformCellManager"
            java.lang.String r2 = "pushCellMeasurement: %s"
            com.here.odnp.util.Log.v(r1, r2, r0)     // Catch:{ all -> 0x001a }
            if (r4 == 0) goto L_0x001c
            com.here.odnp.cell.ICellManager$ICellListener r5 = r3.mListener     // Catch:{ all -> 0x001a }
            r5.onCellMeasurementChanged(r4)     // Catch:{ all -> 0x001a }
            goto L_0x0023
        L_0x001a:
            r4 = move-exception
            goto L_0x0025
        L_0x001c:
            if (r5 == 0) goto L_0x0023
            com.here.odnp.cell.ICellManager$ICellListener r4 = r3.mListener     // Catch:{ all -> 0x001a }
            r4.onCellScanFailed()     // Catch:{ all -> 0x001a }
        L_0x0023:
            monitor-exit(r3)
            return
        L_0x0025:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.cell.PlatformCellManager.pushCellMeasurement(com.here.posclient.CellMeasurement, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void pushCellularStatus(android.telephony.ServiceState r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.mStoredServiceState = r6     // Catch:{ all -> 0x0024 }
            com.here.odnp.cell.ICellManager$ICellListener r0 = r5.mListener     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0067
            if (r6 != 0) goto L_0x000a
            goto L_0x0067
        L_0x000a:
            com.here.posclient.CellularStatus r0 = new com.here.posclient.CellularStatus     // Catch:{ all -> 0x0024 }
            r0.<init>()     // Catch:{ all -> 0x0024 }
            r1 = 0
            r0.interfaceIndex = r1     // Catch:{ all -> 0x0024 }
            int r1 = r6.getState()     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x002b
            boolean r1 = r6.getRoaming()     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0026
            r1 = 4
            r0.status = r1     // Catch:{ all -> 0x0024 }
            goto L_0x002f
        L_0x0024:
            r6 = move-exception
            goto L_0x0069
        L_0x0026:
            r1 = 3
            r0.status = r1     // Catch:{ all -> 0x0024 }
            goto L_0x002f
        L_0x002b:
            r1 = 1
            r0.status = r1     // Catch:{ all -> 0x0024 }
        L_0x002f:
            com.here.odnp.cell.PlatformCellManager$DchTracker r1 = r5.mDchTracker     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.isDchModeOn(r5)     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x003e
            long r1 = r0.status     // Catch:{ all -> 0x0024 }
            r3 = 4096(0x1000, double:2.0237E-320)
            long r1 = r1 | r3
            r0.status = r1     // Catch:{ all -> 0x0024 }
        L_0x003e:
            boolean r6 = r5.isNrAvailable(r6)     // Catch:{ all -> 0x0024 }
            if (r6 == 0) goto L_0x004b
            long r1 = r0.status     // Catch:{ all -> 0x0024 }
            r3 = 8192(0x2000, double:4.0474E-320)
            long r1 = r1 | r3
            r0.status = r1     // Catch:{ all -> 0x0024 }
        L_0x004b:
            long r1 = r5.mCurrentCellularStatus     // Catch:{ all -> 0x0024 }
            long r3 = r0.status     // Catch:{ all -> 0x0024 }
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0065
            r5.mCurrentCellularStatus = r3     // Catch:{ all -> 0x0024 }
            java.lang.Object[] r6 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "odnp.cell.PlatformCellManager"
            java.lang.String r2 = "pushCellularStatus: %s"
            com.here.odnp.util.Log.v(r1, r2, r6)     // Catch:{ all -> 0x0024 }
            com.here.odnp.cell.ICellManager$ICellListener r6 = r5.mListener     // Catch:{ all -> 0x0024 }
            r6.onCellularStatusChanged(r0)     // Catch:{ all -> 0x0024 }
        L_0x0065:
            monitor-exit(r5)
            return
        L_0x0067:
            monitor-exit(r5)
            return
        L_0x0069:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.cell.PlatformCellManager.pushCellularStatus(android.telephony.ServiceState):void");
    }

    public abstract void registerEventListener();

    public abstract void unregisterEventListener();

    public void updateCallState(int i) {
        boolean isDchModeOn = this.mDchTracker.isDchModeOn(this);
        if (!isCallActive(i) || getNetworkType() != CellMeasurement.RANType.UTRAFDD) {
            this.mDchTracker.stopCallTracking();
        } else {
            this.mDchTracker.startCallTracking();
        }
        if (isDchModeOn != this.mDchTracker.isDchModeOn(this)) {
            pushCellularStatus(this.mStoredServiceState);
        }
    }

    public void updateDataActivityState(int i) {
        boolean isDchModeOn = this.mDchTracker.isDchModeOn(this);
        if (!isDataActive(i) || getNetworkType() != CellMeasurement.RANType.UTRAFDD) {
            this.mDchTracker.stopDataTracking();
        } else {
            this.mDchTracker.startDataTracking();
        }
        if (isDchModeOn != this.mDchTracker.isDchModeOn(this)) {
            pushCellularStatus(this.mStoredServiceState);
        }
    }
}
