package com.honey.account.q9;

import android.view.View;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetConnectDialog f7504a;
    public final /* synthetic */ int b;

    public /* synthetic */ g(StarryNetConnectDialog starryNetConnectDialog, int i) {
        this.f7504a = starryNetConnectDialog;
        this.b = i;
    }

    public final void onClick(View view) {
        StarryNetConnectDialog.v(this.f7504a, this.b, view);
    }
}
