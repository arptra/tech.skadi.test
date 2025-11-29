package com.honey.account.d8;

import com.upuphone.xr.interconnect.business.databinder.DataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.sapp.audio.ArAudioFocusManager;

public final /* synthetic */ class b implements DataBinderItemUpdateListener {
    public final void onUpdate(DataBinderValue dataBinderValue) {
        ArAudioFocusManager.g(dataBinderValue);
    }
}
