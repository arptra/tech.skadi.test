package com.honey.account.q9;

import android.view.View;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetConnectDialog f7505a;
    public final /* synthetic */ int b;

    public /* synthetic */ h(StarryNetConnectDialog starryNetConnectDialog, int i) {
        this.f7505a = starryNetConnectDialog;
        this.b = i;
    }

    public final void onClick(View view) {
        StarryNetConnectDialog.w(this.f7505a, this.b, view);
    }
}
