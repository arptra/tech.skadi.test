package com.honey.account.q9;

import android.view.View;
import com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetConnectDialog f7502a;
    public final /* synthetic */ int b;

    public /* synthetic */ e(StarryNetConnectDialog starryNetConnectDialog, int i) {
        this.f7502a = starryNetConnectDialog;
        this.b = i;
    }

    public final void onClick(View view) {
        StarryNetConnectDialog.t(this.f7502a, this.b, view);
    }
}
