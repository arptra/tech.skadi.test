package com.honey.account.x2;

import android.view.View;
import com.meizu.flyme.policy.sdk.widget.PolicySDKLoadDataView;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f3141a;
    public final /* synthetic */ long b;
    public final /* synthetic */ View.OnClickListener c;

    public /* synthetic */ b(Ref.ObjectRef objectRef, long j, View.OnClickListener onClickListener) {
        this.f3141a = objectRef;
        this.b = j;
        this.c = onClickListener;
    }

    public final void onClick(View view) {
        PolicySDKLoadDataView.m10setDebounceClickListener$lambda1(this.f3141a, this.b, this.c, view);
    }
}
