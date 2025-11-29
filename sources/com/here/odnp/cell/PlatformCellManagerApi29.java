package com.here.odnp.cell;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.here.odnp.cell.ICellManager;
import com.here.odnp.util.Log;
import com.here.posclient.CellInfoParser;
import java.util.List;

@SuppressLint({"MissingPermission"})
@TargetApi(29)
public class PlatformCellManagerApi29 extends PlatformCellManager {
    private static final String TAG = "odnp.cell.PlatformCellManagerApi29";
    private final ExplicitCellInfoListener mExplicitCellInfoListener = new ExplicitCellInfoListener();
    /* access modifiers changed from: private */
    public final Runnable mExplicitCellReportTask = new Runnable() {
        public void run() {
            if (PlatformCellManagerApi29.this.mScanRequested) {
                PlatformCellManagerApi29 platformCellManagerApi29 = PlatformCellManagerApi29.this;
                platformCellManagerApi29.pushCellularStatus(platformCellManagerApi29.mStoredServiceState);
                PlatformCellManagerApi29.this.pushCellInfo(true);
                boolean unused = PlatformCellManagerApi29.this.mScanRequested = false;
            }
        }
    };
    private final ImplicitCellInfoListener mImplicitCellInfoListener = new ImplicitCellInfoListener();
    /* access modifiers changed from: private */
    public final Runnable mImplicitCellReportTask = new Runnable() {
        public void run() {
            PlatformCellManagerApi29 platformCellManagerApi29 = PlatformCellManagerApi29.this;
            platformCellManagerApi29.pushCellularStatus(platformCellManagerApi29.mStoredServiceState);
            PlatformCellManagerApi29.this.pushCellInfo(false);
        }
    };
    private PhoneStateListener mPhoneStateListener;
    /* access modifiers changed from: private */
    public boolean mScanRequested;

    public class ExplicitCellInfoListener extends TelephonyManager.CellInfoCallback {
        private ExplicitCellInfoListener() {
        }

        public void onCellInfo(@NonNull List<CellInfo> list) {
            if (PlatformCellManagerApi29.this.mListener != null) {
                PlatformCellManagerApi29 platformCellManagerApi29 = PlatformCellManagerApi29.this;
                platformCellManagerApi29.mHandler.post(platformCellManagerApi29.mExplicitCellReportTask);
            }
        }

        public void onError(int i, Throwable th) {
            if (PlatformCellManagerApi29.this.mListener != null) {
                PlatformCellManagerApi29 platformCellManagerApi29 = PlatformCellManagerApi29.this;
                platformCellManagerApi29.mHandler.post(platformCellManagerApi29.mExplicitCellReportTask);
            }
        }
    }

    public class ImplicitCellInfoListener extends TelephonyManager.CellInfoCallback {
        private ImplicitCellInfoListener() {
        }

        public void onCellInfo(@NonNull List<CellInfo> list) {
            if (PlatformCellManagerApi29.this.mListener != null) {
                PlatformCellManagerApi29 platformCellManagerApi29 = PlatformCellManagerApi29.this;
                platformCellManagerApi29.mHandler.post(platformCellManagerApi29.mImplicitCellReportTask);
            }
        }

        public void onError(int i, Throwable th) {
            ICellManager.ICellListener iCellListener = PlatformCellManagerApi29.this.mListener;
        }
    }

    public class PhoneStateListenerApi18 extends PhoneStateListener {
        private PhoneStateListenerApi18() {
        }

        public void onCallStateChanged(int i, String str) {
            Log.v(PlatformCellManagerApi29.TAG, "PhoneStateListenerApi18.onCallStateChanged: state: %d", Integer.valueOf(i));
            PlatformCellManagerApi29.this.updateCallState(i);
        }

        public void onCellInfoChanged(List<CellInfo> list) {
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            Log.v(PlatformCellManagerApi29.TAG, "PhoneStateListenerApi18.onCellLocationChanged: %s", cellLocation);
            PlatformCellManagerApi29.this.requestCellUpdate(false);
        }

        public void onDataActivity(int i) {
            PlatformCellManagerApi29.this.updateDataActivityState(i);
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            Log.v(PlatformCellManagerApi29.TAG, "PhoneStateListenerApi18.onServiceStateChanged: %s", serviceState);
            PlatformCellManagerApi29.this.pushCellularStatus(serviceState);
        }
    }

    public PlatformCellManagerApi29(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public void pushCellInfo(boolean z) {
        Log.v(TAG, "pushCellInfo: explicit: %b", Boolean.valueOf(z));
        pushCellMeasurement(CellInfoParser.createCellMeasurement(this.mTelephonyManager.getAllCellInfo()), z);
    }

    /* access modifiers changed from: private */
    public void requestCellUpdate(boolean z) {
        Log.v(TAG, "requestCellUpdate: explicit: %b", Boolean.valueOf(z));
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
        } else if (this.mTelephonyManager.getPhoneCount() > 0) {
            Log.v(TAG, "isCellSupported: true (phone count)", new Object[0]);
            return true;
        } else {
            Log.v(TAG, "isCellSupported: false", new Object[0]);
            return false;
        }
    }

    public void registerEventListener() {
        if (this.mPhoneStateListener == null) {
            this.mPhoneStateListener = new PhoneStateListenerApi18();
        }
        this.mTelephonyManager.listen(this.mPhoneStateListener, 1201);
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
        PhoneStateListener phoneStateListener = this.mPhoneStateListener;
        if (phoneStateListener != null) {
            this.mTelephonyManager.listen(phoneStateListener, 0);
            this.mPhoneStateListener = null;
        }
    }
}
