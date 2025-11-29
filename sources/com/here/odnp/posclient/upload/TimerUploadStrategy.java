package com.here.odnp.posclient.upload;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.here.odnp.adaptations.BatteryManager;
import com.here.odnp.net.IConnectivityManager;
import com.here.odnp.net.PlatformConnectivityManager;
import com.here.odnp.posclient.PosClientManager;
import com.here.odnp.util.Log;
import com.here.posclient.INetworkManager;
import com.here.posclient.PosClientLib;
import com.here.posclient.Status;
import com.here.posclient.upload.UploadListener;
import com.here.posclient.upload.UploadOptions;
import java.util.concurrent.TimeUnit;

public class TimerUploadStrategy implements IUploadScheduler, UploadListener {
    private static final long DEFAULT_BACKOFF_DELAY_MS = TimeUnit.SECONDS.toMillis(30);
    private static final long MAX_BACKOFF_DELAY_MS = TimeUnit.MINUTES.toMillis(16);
    private static final String TAG = "odnp.posclient.upload.TimerUploadStrategy";
    private static volatile TimerUploadStrategy mSchedulerInstance;
    /* access modifiers changed from: private */
    public volatile int mBatteryLevel = -1;
    private final BatteryManager mBatteryManager;
    /* access modifiers changed from: private */
    public volatile boolean mConnectionAvailable;
    private final PlatformConnectivityManager mConnectivityManager;
    private volatile boolean mDataAvailable;
    private volatile long mElapsedUploadAt;
    private volatile int mFailCount;
    /* access modifiers changed from: private */
    public final Object mFailCountLock = new Object();
    private final Handler mHandler = new Handler();
    private final PosClientManager mPosManager;
    /* access modifiers changed from: private */
    public volatile boolean mTaskScheduled;
    /* access modifiers changed from: private */
    public final Object mTaskScheduledLock = new Object();
    private volatile IUploadSession mUploadSession;
    private final Object mUploadSessionLock = new Object();
    private final Runnable mUploadTask = new Runnable() {
        public void run() {
            boolean z;
            synchronized (TimerUploadStrategy.this.mTaskScheduledLock) {
                try {
                    z = false;
                    Log.d(TimerUploadStrategy.TAG, "Runnable: run: task scheduled: " + Boolean.toString(TimerUploadStrategy.this.mTaskScheduled), new Object[0]);
                    if (TimerUploadStrategy.this.mTaskScheduled) {
                        boolean unused = TimerUploadStrategy.this.mTaskScheduled = false;
                        z = true;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (z && !TimerUploadStrategy.this.onStartUpload()) {
                synchronized (TimerUploadStrategy.this.mFailCountLock) {
                    TimerUploadStrategy.access$404(TimerUploadStrategy.this);
                }
                TimerUploadStrategy.this.onScheduleUpload();
            }
        }
    };

    /* renamed from: com.here.odnp.posclient.upload.TimerUploadStrategy$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$here$posclient$INetworkManager$Connection$Type;
        static final /* synthetic */ int[] $SwitchMap$com$here$posclient$PosClientLib$ConnectionChangeAction;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                com.here.posclient.INetworkManager$Connection$Type[] r0 = com.here.posclient.INetworkManager.Connection.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$posclient$INetworkManager$Connection$Type = r0
                r1 = 1
                com.here.posclient.INetworkManager$Connection$Type r2 = com.here.posclient.INetworkManager.Connection.Type.MOBILE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$here$posclient$INetworkManager$Connection$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.posclient.INetworkManager$Connection$Type r3 = com.here.posclient.INetworkManager.Connection.Type.WIFI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.here.posclient.PosClientLib$ConnectionChangeAction[] r2 = com.here.posclient.PosClientLib.ConnectionChangeAction.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$here$posclient$PosClientLib$ConnectionChangeAction = r2
                com.here.posclient.PosClientLib$ConnectionChangeAction r3 = com.here.posclient.PosClientLib.ConnectionChangeAction.CONNECTION_CHANGED     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$here$posclient$PosClientLib$ConnectionChangeAction     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.here.posclient.PosClientLib$ConnectionChangeAction r2 = com.here.posclient.PosClientLib.ConnectionChangeAction.CONNECTION_CONNECTED     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$here$posclient$PosClientLib$ConnectionChangeAction     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.here.posclient.PosClientLib$ConnectionChangeAction r1 = com.here.posclient.PosClientLib.ConnectionChangeAction.CONNECTION_DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.posclient.upload.TimerUploadStrategy.AnonymousClass4.<clinit>():void");
        }
    }

    private TimerUploadStrategy(PosClientManager posClientManager) {
        this.mPosManager = posClientManager;
        this.mBatteryManager = new BatteryManager(posClientManager.getContext(), new BatteryManager.IListener() {
            public void onBatteryLevelChanged(int i) {
                int unused = TimerUploadStrategy.this.mBatteryLevel = i;
            }
        });
        PlatformConnectivityManager platformConnectivityManager = new PlatformConnectivityManager(posClientManager.getContext());
        this.mConnectivityManager = platformConnectivityManager;
        platformConnectivityManager.open(new IConnectivityManager.IConnectivityListener() {
            public void onConnectionStateChanged(PosClientLib.ConnectionChangeAction connectionChangeAction, INetworkManager.Connection connection) {
                int i = AnonymousClass4.$SwitchMap$com$here$posclient$PosClientLib$ConnectionChangeAction[connectionChangeAction.ordinal()];
                if (i == 1 || i == 2) {
                    boolean unused = TimerUploadStrategy.this.mConnectionAvailable = !connection.isRoaming;
                    if (TimerUploadStrategy.this.mConnectionAvailable) {
                        Log.d(TimerUploadStrategy.TAG, "onConnectionStateChanged: connected", new Object[0]);
                        TimerUploadStrategy.this.onScheduleUpload();
                        return;
                    }
                    Log.v(TimerUploadStrategy.TAG, "onConnectionStateChanged: connected, but roaming", new Object[0]);
                    TimerUploadStrategy.this.cancelUpload();
                } else if (i == 3) {
                    boolean unused2 = TimerUploadStrategy.this.mConnectionAvailable = false;
                    TimerUploadStrategy.this.cancelUpload();
                }
            }
        });
        this.mUploadSession = posClientManager.createUploadSession();
        this.mUploadSession.subscribe(this);
    }

    public static /* synthetic */ int access$404(TimerUploadStrategy timerUploadStrategy) {
        int i = timerUploadStrategy.mFailCount + 1;
        timerUploadStrategy.mFailCount = i;
        return i;
    }

    /* access modifiers changed from: private */
    public void cancelUpload() {
        onUnscheduledUpload();
        synchronized (this.mUploadSessionLock) {
            try {
                if (this.mUploadSession != null) {
                    Log.v(TAG, "cancelUpload", new Object[0]);
                    this.mUploadSession.cancelUpload();
                    synchronized (this.mFailCountLock) {
                        this.mFailCount = 0;
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private void closeSession() {
        synchronized (this.mUploadSessionLock) {
            try {
                if (this.mUploadSession != null) {
                    Log.v(TAG, "closeSession", new Object[0]);
                    this.mUploadSession.unsubscribe(this);
                    this.mUploadSession.close();
                    this.mUploadSession = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private long getBackoffDelay() {
        long min;
        long max = Math.max(0, this.mElapsedUploadAt - SystemClock.elapsedRealtime());
        synchronized (this.mFailCountLock) {
            min = max + Math.min(MAX_BACKOFF_DELAY_MS, ((long) (this.mFailCount * this.mFailCount)) * DEFAULT_BACKOFF_DELAY_MS);
        }
        return min;
    }

    private UploadOptions getUploadOptions() {
        UploadOptions uploadOptions = new UploadOptions();
        this.mBatteryManager.start();
        if (this.mBatteryLevel != -1) {
            uploadOptions.setBatteryLevel(this.mBatteryLevel);
        }
        this.mBatteryManager.stop();
        INetworkManager.Connection dataConnection = this.mConnectivityManager.getDataConnection();
        if (dataConnection == null) {
            return uploadOptions;
        }
        int i = AnonymousClass4.$SwitchMap$com$here$posclient$INetworkManager$Connection$Type[dataConnection.type.ordinal()];
        if (i == 1) {
            uploadOptions.setConnectionType(UploadOptions.ConnectionType.MOBILE);
        } else if (i != 2) {
            uploadOptions.setConnectionType(UploadOptions.ConnectionType.UNSPECIFIED);
        } else {
            uploadOptions.setConnectionType(UploadOptions.ConnectionType.WIFI);
        }
        return uploadOptions;
    }

    public static synchronized IUploadScheduler getUploadScheduler(PosClientManager posClientManager) {
        TimerUploadStrategy timerUploadStrategy;
        synchronized (TimerUploadStrategy.class) {
            try {
                if (mSchedulerInstance == null) {
                    mSchedulerInstance = new TimerUploadStrategy(posClientManager);
                    Log.v(TAG, "getUploadScheduler: TimerUploadStrategy created", new Object[0]);
                }
                timerUploadStrategy = mSchedulerInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return timerUploadStrategy;
    }

    private static synchronized void nullifyScheduler() {
        synchronized (TimerUploadStrategy.class) {
            mSchedulerInstance = null;
        }
    }

    /* access modifiers changed from: private */
    public void onScheduleUpload() {
        synchronized (this.mTaskScheduledLock) {
            try {
                if (this.mTaskScheduled) {
                    Log.v(TAG, "onScheduleUpload: already scheduled, ignored", new Object[0]);
                } else if (!this.mDataAvailable) {
                    Log.v(TAG, "onScheduleUpload: no data, ignored", new Object[0]);
                } else if (!this.mConnectionAvailable) {
                    Log.v(TAG, "onScheduleUpload: no connection, ignored", new Object[0]);
                } else {
                    this.mHandler.removeCallbacks(this.mUploadTask);
                    long backoffDelay = getBackoffDelay();
                    Log.v(TAG, "onScheduleUpload: next upload after %d seconds", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(backoffDelay)));
                    this.mTaskScheduled = this.mHandler.postDelayed(this.mUploadTask, backoffDelay);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean onStartUpload() {
        synchronized (this.mUploadSessionLock) {
            try {
                if (this.mUploadSession == null) {
                    return false;
                }
                UploadOptions uploadOptions = getUploadOptions();
                if (uploadOptions.connectionType == UploadOptions.ConnectionType.UNSPECIFIED) {
                    return false;
                }
                Status upload = this.mUploadSession.upload(uploadOptions);
                Log.v(TAG, "startUpload: status %s", upload.name());
                return Status.Ok == upload;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void onUnscheduledUpload() {
        synchronized (this.mTaskScheduledLock) {
            this.mHandler.removeCallbacks(this.mUploadTask);
            this.mTaskScheduled = false;
        }
    }

    public void close() {
        cancelUpload();
        closeSession();
        this.mConnectivityManager.close();
        synchronized (TimerUploadStrategy.class) {
            nullifyScheduler();
        }
    }

    public void dataUploaded(@NonNull Context context) {
    }

    public void onUploadDataAvailable(int i) {
        Log.v(TAG, "onUploadDataAvailable: %ds", Integer.valueOf(i));
        onUnscheduledUpload();
        this.mElapsedUploadAt = SystemClock.elapsedRealtime() + TimeUnit.SECONDS.toMillis((long) i);
        this.mDataAvailable = true;
        onScheduleUpload();
    }

    public void onUploadFailed() {
        Log.v(TAG, "onUploadFailed", new Object[0]);
        synchronized (this.mFailCountLock) {
            this.mFailCount++;
        }
        onScheduleUpload();
    }

    public void onUploaded() {
        Log.v(TAG, "onUploaded", new Object[0]);
        synchronized (this.mFailCountLock) {
            this.mFailCount = 0;
        }
        this.mDataAvailable = false;
    }

    public void schedule(@NonNull Context context, int i) {
        onUploadDataAvailable(i);
    }
}
