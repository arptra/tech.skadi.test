package com.honey.account.t9;

import android.content.DialogInterface;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.xjmz.myvu.modules.main.connect.ConnectProcess;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetDevice f7618a;
    public final /* synthetic */ ConnectProcess b;

    public /* synthetic */ a(StarryNetDevice starryNetDevice, ConnectProcess connectProcess) {
        this.f7618a = starryNetDevice;
        this.b = connectProcess;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ConnectProcess.m(this.f7618a, this.b, dialogInterface, i);
    }
}
