package com.here.odnp.cell;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.cell.ICellManager;
import com.here.odnp.util.Log;
import com.here.posclient.CellInfoParser;
import com.here.services.util.HereServicesUtil;
import java.util.List;

@SuppressLint({"MissingPermission"})
@TargetApi(31)
public class PlatformCellManagerApi31 extends PlatformCellManager {
    private static final int GC_AFTER_NUM_REQUESTS = 30;
    private static final String TAG = "odnp.cell.PlatformCellManagerApi31";
    private final ExplicitCellInfoListener mExplicitCellInfoListener = new ExplicitCellInfoListener();
    /* access modifiers changed from: private */
    public final Runnable mExplicitCellReportTask = new Runnable() {
        public void run() {
            if (PlatformCellManagerApi31.this.mScanRequested) {
                PlatformCellManagerApi31 platformCellManagerApi31 = PlatformCellManagerApi31.this;
                platformCellManagerApi31.pushCellularStatus(platformCellManagerApi31.mStoredServiceState);
                PlatformCellManagerApi31.this.pushCellInfo(true);
                boolean unused = PlatformCellManagerApi31.this.mScanRequested = false;
            }
        }
    };
    private final ImplicitCellInfoListener mImplicitCellInfoListener = new ImplicitCellInfoListener();
    /* access modifiers changed from: private */
    public final Runnable mImplicitCellReportTask = new Runnable() {
        public void run() {
            PlatformCellManagerApi31 platformCellManagerApi31 = PlatformCellManagerApi31.this;
            platformCellManagerApi31.pushCellularStatus(platformCellManagerApi31.mStoredServiceState);
            PlatformCellManagerApi31.this.pushCellInfo(false);
        }
    };
    private final boolean mIsRunningInNlpContext;
    private int mRequestCount;
    /* access modifiers changed from: private */
    public boolean mScanRequested;
    private TelephonyCallback mTelephonyCallback;

    public class ExplicitCellInfoListener extends TelephonyManager.CellInfoCallback {
        private ExplicitCellInfoListener() {
        }

        public void onCellInfo(@NonNull List<CellInfo> list) {
            if (PlatformCellManagerApi31.this.mListener != null) {
                PlatformCellManagerApi31 platformCellManagerApi31 = PlatformCellManagerApi31.this;
                platformCellManagerApi31.mHandler.post(platformCellManagerApi31.mExplicitCellReportTask);
            }
        }

        public void onError(int i, Throwable th) {
            if (PlatformCellManagerApi31.this.mListener != null) {
                PlatformCellManagerApi31 platformCellManagerApi31 = PlatformCellManagerApi31.this;
                platformCellManagerApi31.mHandler.post(platformCellManagerApi31.mExplicitCellReportTask);
            }
        }
    }

    public class ImplicitCellInfoListener extends TelephonyManager.CellInfoCallback {
        private ImplicitCellInfoListener() {
        }

        public void onCellInfo(@NonNull List<CellInfo> list) {
            if (PlatformCellManagerApi31.this.mListener != null) {
                PlatformCellManagerApi31 platformCellManagerApi31 = PlatformCellManagerApi31.this;
                platformCellManagerApi31.mHandler.post(platformCellManagerApi31.mImplicitCellReportTask);
            }
        }

        public void onError(int i, Throwable th) {
            ICellManager.ICellListener iCellListener = PlatformCellManagerApi31.this.mListener;
        }
    }

    public class TelephonyCallbackApi31 extends TelephonyCallback implements TelephonyCallback.CellLocationListener, TelephonyCallback.DataActivityListener, TelephonyCallback.ServiceStateListener {
        private TelephonyCallbackApi31() {
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            Log.v(PlatformCellManagerApi31.TAG, "TelephonyCallbackApi31.onCellLocationChanged: %s", cellLocation);
            PlatformCellManagerApi31.this.requestCellUpdate(false);
        }

        public void onDataActivity(int i) {
            PlatformCellManagerApi31.this.updateDataActivityState(i);
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            Log.v(PlatformCellManagerApi31.TAG, "TelephonyCallbackApi31.onServiceStateChanged: %s", serviceState);
            PlatformCellManagerApi31.this.pushCellularStatus(serviceState);
        }
    }

    public PlatformCellManagerApi31(Context context) {
        super(context);
        this.mIsRunningInNlpContext = HereServicesUtil.isRunningInNlpContext(context);
    }

    /* access modifiers changed from: private */
    public void pushCellInfo(boolean z) {
        Log.v(TAG, "pushCellInfo: explicit: %b", Boolean.valueOf(z));
        pushCellMeasurement(CellInfoParser.createCellMeasurement(this.mTelephonyManager.getAllCellInfo()), z);
    }

    /* access modifiers changed from: private */
    @SuppressFBWarnings(justification = "Required for NLP", value = {"DM_GC"})
    public void requestCellUpdate(boolean z) {
        Log.v(TAG, "requestCellUpdate: explicit: %b", Boolean.valueOf(z));
        if (this.mIsRunningInNlpContext) {
            int i = this.mRequestCount + 1;
            this.mRequestCount = i;
            if (i > 30) {
                Log.v(TAG, "requestCellUpdate: triggering gc", new Object[0]);
                this.mRequestCount = 0;
                Runtime.getRuntime().gc();
            }
        }
        this.mTelephonyManager.requestCellInfoUpdate(this.mContext.getMainExecutor(), z ? this.mExplicitCellInfoListener : this.mImplicitCellInfoListener);
    }

    public synchronized void cancelCellScan() {
        if (this.mListener != null) {
            this.mScanRequested = false;
            this.mHandler.removeCallbacks(this.mExplicitCellReportTask);
        }
    }

    public boolean isCellNeighborSupported() {
        return true;
    }

    public boolean isCellSupported() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            Log.v(TAG, "isCellSupported: true (telephony)", new Object[0]);
            return true;
        } else if (this.mTelephonyManager.getSupportedModemCount() > 0) {
            Log.v(TAG, "isCellSupported: true (phone count)", new Object[0]);
            return true;
        } else {
            Log.v(TAG, "isCellSupported: false", new Object[0]);
            return false;
        }
    }

    public void registerEventListener() {
        if (this.mTelephonyCallback == null) {
            this.mTelephonyCallback = new TelephonyCallbackApi31();
        }
        this.mTelephonyManager.registerTelephonyCallback(this.mContext.getMainExecutor(), this.mTelephonyCallback);
    }

    public synchronized boolean startCellScan() {
        if (this.mListener == null) {
            Log.v(TAG, "startCellScan: Skipping since there's no listener", new Object[0]);
            return false;
        } else if (!isCellSupported()) {
            Log.v(TAG, "startCellScan: Skipping since device does not support", new Object[0]);
            return false;
        } else {
            cancelCellScan();
            Log.v(TAG, "startCellScan", new Object[0]);
            this.mScanRequested = true;
            requestCellUpdate(true);
            return true;
        }
    }

    public void unregisterEventListener() {
        TelephonyCallback telephonyCallback = this.mTelephonyCallback;
        if (telephonyCallback != null) {
            this.mTelephonyManager.unregisterTelephonyCallback(telephonyCallback);
            this.mTelephonyCallback = null;
        }
    }
}
