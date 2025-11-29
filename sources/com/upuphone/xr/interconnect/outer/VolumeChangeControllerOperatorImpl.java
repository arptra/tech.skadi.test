package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import android.util.Log;
import com.upuphone.xr.interconnect.api.VolumeChangeControllerOperator;
import com.upuphone.xr.interconnect.common.IVolumeChangeController;
import com.upuphone.xr.interconnect.listener.VolumeChange;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import java.util.List;

public class VolumeChangeControllerOperatorImpl implements VolumeChangeControllerOperator, SuperServiceStateListener {
    private static final String TAG = "VolumeChangeControllerOperatorImpl";
    private SuperServiceProvider mProvider;
    private List<VolumeChange> mVolumeChanges = new DeDuplicateArrayList();

    private void doRegisterVolumeChangeReceiver(VolumeChange volumeChange) {
        IVolumeChangeController volumeChangeController = this.mProvider.getVolumeChangeController();
        if (volumeChangeController != null) {
            try {
                volumeChangeController.registerVolumeChangeReceiver(volumeChange);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void dispatchVolumeChange(int i) {
        IVolumeChangeController volumeChangeController = this.mProvider.getVolumeChangeController();
        if (volumeChangeController != null) {
            try {
                volumeChangeController.dispatchVolumeChange(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceConnected() {
        for (VolumeChange doRegisterVolumeChangeReceiver : this.mVolumeChanges) {
            doRegisterVolumeChangeReceiver(doRegisterVolumeChangeReceiver);
        }
    }

    public void onServiceDied() {
    }

    public void registerVolumeChangeReceiver(VolumeChange volumeChange) {
        if (volumeChange == null) {
            Log.d(TAG, "registerVolumeChangeReceiver volumeChange is null");
            return;
        }
        this.mVolumeChanges.add(volumeChange);
        doRegisterVolumeChangeReceiver(volumeChange);
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public void unregisterVolumeChangeReceiver(VolumeChange volumeChange) {
        if (volumeChange == null) {
            Log.d(TAG, "unregisterVolumeChangeReceiver volumeChange is null");
            return;
        }
        this.mVolumeChanges.remove(volumeChange);
        IVolumeChangeController volumeChangeController = this.mProvider.getVolumeChangeController();
        if (volumeChangeController != null) {
            try {
                volumeChangeController.unregisterVolumeChangeReceiver(volumeChange);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
