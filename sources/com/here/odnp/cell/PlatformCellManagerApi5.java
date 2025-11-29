package com.here.odnp.cell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.alibaba.fastjson.asm.Opcodes;
import com.here.odnp.util.Log;
import com.here.posclient.CellLocationParser;
import com.here.posclient.CellMeasurement;

@SuppressLint({"MissingPermission"})
public class PlatformCellManagerApi5 extends PlatformCellManager {
    private static final String TAG = "odnp.cell.PlatformCellManagerApi5";
    private final Runnable mCellScanTask = new Runnable() {
        public void run() {
            PlatformCellManagerApi5 platformCellManagerApi5 = PlatformCellManagerApi5.this;
            platformCellManagerApi5.pushCellularStatus(platformCellManagerApi5.mStoredServiceState);
            PlatformCellManagerApi5 platformCellManagerApi52 = PlatformCellManagerApi5.this;
            platformCellManagerApi52.pushCellLocation(platformCellManagerApi52.mTelephonyManager.getCellLocation(), true);
        }
    };
    private PhoneStateListener mPhoneStateListener;

    public class PhoneStateListenerApi5 extends PhoneStateListener {
        private PhoneStateListenerApi5() {
        }

        public void onCallStateChanged(int i, String str) {
            Log.v(PlatformCellManagerApi5.TAG, "onCallStateChanged: state: %d", Integer.valueOf(i));
            PlatformCellManagerApi5.this.updateCallState(i);
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            Log.v(PlatformCellManagerApi5.TAG, "onCellLocationChanged: %s", cellLocation);
            PlatformCellManagerApi5.this.pushCellLocation(cellLocation, false);
        }

        public void onDataActivity(int i) {
            PlatformCellManagerApi5 platformCellManagerApi5 = PlatformCellManagerApi5.this;
            platformCellManagerApi5.updateDataActivityState(platformCellManagerApi5.mTelephonyManager.getDataActivity());
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            Log.v(PlatformCellManagerApi5.TAG, "onServiceStateChanged: %s", serviceState);
            PlatformCellManagerApi5.this.pushCellularStatus(serviceState);
            PlatformCellManagerApi5 platformCellManagerApi5 = PlatformCellManagerApi5.this;
            platformCellManagerApi5.pushCellLocation(platformCellManagerApi5.mTelephonyManager.getCellLocation(), false);
        }
    }

    public PlatformCellManagerApi5(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public void pushCellLocation(CellLocation cellLocation, boolean z) {
        CellMeasurement cellMeasurement;
        if (cellLocation != null) {
            if (cellLocation instanceof GsmCellLocation) {
                cellMeasurement = CellLocationParser.createCellMeasurement(getNetworkType(), this.mTelephonyManager.getNetworkOperator(), (GsmCellLocation) cellLocation);
            } else if (cellLocation instanceof CdmaCellLocation) {
                cellMeasurement = CellLocationParser.createCellMeasurement((CdmaCellLocation) cellLocation);
            } else {
                Log.w(TAG, "pushCellLocation: Ignoring unsupported cell location: %s", cellLocation.getClass().getName());
            }
            pushCellMeasurement(cellMeasurement, z);
        }
        cellMeasurement = null;
        pushCellMeasurement(cellMeasurement, z);
    }

    public synchronized void cancelCellScan() {
        if (this.mListener != null) {
            this.mHandler.removeCallbacks(this.mCellScanTask);
        }
    }

    public boolean isCellNeighborSupported() {
        return false;
    }

    public boolean isCellSupported() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            Log.v(TAG, "isCellSupported: true (telephony)", new Object[0]);
            return true;
        } else if (this.mConnectivityManager.getNetworkInfo(0) == null) {
            return false;
        } else {
            Log.v(TAG, "isCellSupported: true (network info)", new Object[0]);
            return true;
        }
    }

    public void registerEventListener() {
        if (this.mPhoneStateListener == null) {
            this.mPhoneStateListener = new PhoneStateListenerApi5();
        }
        this.mTelephonyManager.listen(this.mPhoneStateListener, Opcodes.RETURN);
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
