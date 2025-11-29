package com.here.odnp.cell;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import com.here.odnp.util.Log;
import com.here.posclient.CellInfoParser;
import java.util.List;

@SuppressLint({"MissingPermission"})
@TargetApi(24)
public class PlatformCellManagerApi24 extends PlatformCellManager {
    private static final String TAG = "odnp.cell.PlatformCellManagerApi24";
    private final Runnable mCellScanTask = new Runnable() {
        public void run() {
            PlatformCellManagerApi24 platformCellManagerApi24 = PlatformCellManagerApi24.this;
            platformCellManagerApi24.pushCellularStatus(platformCellManagerApi24.mStoredServiceState);
            PlatformCellManagerApi24.this.pushCellInfo(true);
        }
    };
    private PhoneStateListener mPhoneStateListener;

    public class PhoneStateListenerApi18 extends PhoneStateListener {
        private PhoneStateListenerApi18() {
        }

        public void onCallStateChanged(int i, String str) {
            Log.v(PlatformCellManagerApi24.TAG, "onCallStateChanged: state: %d", Integer.valueOf(i));
            PlatformCellManagerApi24.this.updateCallState(i);
        }

        public void onCellInfoChanged(List<CellInfo> list) {
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            Log.v(PlatformCellManagerApi24.TAG, "onCellLocationChanged: %s", cellLocation);
            PlatformCellManagerApi24.this.pushCellInfo(false);
        }

        public void onDataActivity(int i) {
            PlatformCellManagerApi24.this.updateDataActivityState(i);
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            Log.v(PlatformCellManagerApi24.TAG, "onServiceStateChanged: %s", serviceState);
            PlatformCellManagerApi24.this.pushCellularStatus(serviceState);
            PlatformCellManagerApi24.this.pushCellInfo(false);
        }
    }

    public PlatformCellManagerApi24(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public void pushCellInfo(boolean z) {
        Log.v(TAG, "pushCellInfo: explicit: %b", Boolean.valueOf(z));
        pushCellMeasurement(CellInfoParser.createCellMeasurement(this.mTelephonyManager.getAllCellInfo()), z);
    }

    public synchronized void cancelCellScan() {
        if (this.mListener != null) {
            this.mHandler.removeCallbacks(this.mCellScanTask);
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
        Log.v(TAG, "startCellScan", new Object[0]);
        if (this.mListener == null) {
            return false;
        }
        if (!isCellSupported()) {
            return false;
        }
        cancelCellScan();
        return this.mHandler.post(this.mCellScanTask);
    }

    public void unregisterEventListener() {
        PhoneStateListener phoneStateListener = this.mPhoneStateListener;
        if (phoneStateListener != null) {
            this.mTelephonyManager.listen(phoneStateListener, 0);
            this.mPhoneStateListener = null;
        }
    }
}
