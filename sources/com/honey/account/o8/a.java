package com.honey.account.o8;

import android.app.Activity;
import android.content.DialogInterface;
import com.upuphone.xr.sapp.monitor.schedule.lark.LarkSsoHelper;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LarkSsoHelper f7472a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ a(LarkSsoHelper larkSsoHelper, Activity activity) {
        this.f7472a = larkSsoHelper;
        this.b = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        LarkSsoHelper.i(this.f7472a, this.b, dialogInterface, i);
    }
}
