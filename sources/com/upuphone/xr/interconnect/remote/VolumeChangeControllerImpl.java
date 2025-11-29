package com.upuphone.xr.interconnect.remote;

import android.os.RemoteException;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.VolumeChange;
import com.upuphone.xr.interconnect.common.IVolumeChange;
import com.upuphone.xr.interconnect.common.IVolumeChangeController;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;

public class VolumeChangeControllerImpl extends IVolumeChangeController.Stub {
    private static final String TAG = "VolumeChangeControllerImpl";
    private VolumeChange mVolumeChange;

    public VolumeChangeControllerImpl() {
        VolumeChange volumeChange = InterconnectManager.getInstance().getVolumeChange();
        this.mVolumeChange = volumeChange;
        IpcClientManager.INSTANCE.addListener(volumeChange);
    }

    public void dispatchVolumeChange(int i) throws RemoteException {
        this.mVolumeChange.dispatchVolumeChange(i);
    }

    public void registerVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException {
        this.mVolumeChange.registerMessageReceiver(iVolumeChange);
    }

    public void unregisterVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException {
        this.mVolumeChange.unregisterMessageReceiver(iVolumeChange);
    }
}
