package com.honey.account.a8;

import android.content.DialogInterface;
import com.upuphone.xr.sapp.TodoManageActivity;
import java.util.List;

public final /* synthetic */ class b0 implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodoManageActivity f4169a;
    public final /* synthetic */ List b;

    public /* synthetic */ b0(TodoManageActivity todoManageActivity, List list) {
        this.f4169a = todoManageActivity;
        this.b = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TodoManageActivity.X0(this.f4169a, this.b, dialogInterface, i);
    }
}
