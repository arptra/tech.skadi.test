package com.honey.account.w8;

import android.view.View;
import androidx.navigation.NavController;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7646a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ NavController c;

    public /* synthetic */ g(View view, Function1 function1, NavController navController) {
        this.f7646a = view;
        this.b = function1;
        this.c = navController;
    }

    public final void onClick(View view) {
        GlobalExtKt.m(this.f7646a, this.b, this.c, view);
    }
}
