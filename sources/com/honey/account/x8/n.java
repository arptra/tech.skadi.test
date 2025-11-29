package com.honey.account.x8;

import com.upuphone.xr.sapp.view.GenericWindowView;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7668a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Ref.BooleanRef d;

    public /* synthetic */ n(GenericWindowView genericWindowView, Ref.ObjectRef objectRef, int i, Ref.BooleanRef booleanRef) {
        this.f7668a = genericWindowView;
        this.b = objectRef;
        this.c = i;
        this.d = booleanRef;
    }

    public final void run() {
        GenericWindowView.R(this.f7668a, this.b, this.c, this.d);
    }
}
