package com.honey.account.r8;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.upuphone.xr.sapp.receiver.StarryDeviceNameChangeReceiver;
import com.upuphone.xr.sapp.vm.DeviceControlModel;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryDeviceNameChangeReceiver f7520a;
    public final /* synthetic */ DeviceControlModel b;

    public /* synthetic */ a(StarryDeviceNameChangeReceiver starryDeviceNameChangeReceiver, DeviceControlModel deviceControlModel) {
        this.f7520a = starryDeviceNameChangeReceiver;
        this.b = deviceControlModel;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        StarryDeviceNameChangeReceiver.c(this.f7520a, this.b, lifecycleOwner, event);
    }
}
