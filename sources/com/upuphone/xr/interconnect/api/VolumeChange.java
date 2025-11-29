package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.api.VolumeChangeImpl;
import com.upuphone.xr.interconnect.common.IVolumeChange;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;

public interface VolumeChange extends BinderClientDiedCallback {
    void addClientRegister(VolumeChangeImpl.IClientRegister iClientRegister);

    void dispatchVolumeChange(int i);

    void registerMessageReceiver(IVolumeChange iVolumeChange);

    void removeClientRegister();

    void unregisterMessageReceiver(IVolumeChange iVolumeChange);
}
