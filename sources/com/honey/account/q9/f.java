package com.honey.account.q9;

import android.view.View;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetConnectDialog f7503a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(StarryNetConnectDialog starryNetConnectDialog, int i) {
        this.f7503a = starryNetConnectDialog;
        this.b = i;
    }

    public final void onClick(View view) {
        StarryNetConnectDialog.u(this.f7503a, this.b, view);
    }
}
