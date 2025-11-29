package com.honey.account.z8;

import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TextView f7721a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ NestedScrollView c;

    public /* synthetic */ h(TextView textView, Ref.IntRef intRef, NestedScrollView nestedScrollView) {
        this.f7721a = textView;
        this.b = intRef;
        this.c = nestedScrollView;
    }

    public final void run() {
        RoleVprintViewModel.P(this.f7721a, this.b, this.c);
    }
}
