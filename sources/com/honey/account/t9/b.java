package com.honey.account.t9;

import android.content.DialogInterface;
import com.xjmz.myvu.modules.main.connect.ConnectProcess;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectProcess f7619a;

    public /* synthetic */ b(ConnectProcess connectProcess) {
        this.f7619a = connectProcess;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ConnectProcess.n(this.f7619a, dialogInterface, i);
    }
}
