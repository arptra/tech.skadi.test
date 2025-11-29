package com.honey.account.q9;

import android.widget.CompoundButton;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog;

public final /* synthetic */ class i implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetConnectDialog f7506a;

    public /* synthetic */ i(StarryNetConnectDialog starryNetConnectDialog) {
        this.f7506a = starryNetConnectDialog;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        StarryNetConnectDialog.x(this.f7506a, compoundButton, z);
    }
}
