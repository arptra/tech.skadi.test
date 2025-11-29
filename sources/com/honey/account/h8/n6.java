package com.honey.account.h8;

import android.view.View;
import com.luck.picture.lib.entity.LocalMedia;
import com.upuphone.xr.sapp.fragment.MediaShowListFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class n6 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4697a;
    public final /* synthetic */ LocalMedia b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ Ref.ObjectRef d;

    public /* synthetic */ n6(Ref.ObjectRef objectRef, LocalMedia localMedia, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        this.f4697a = objectRef;
        this.b = localMedia;
        this.c = objectRef2;
        this.d = objectRef3;
    }

    public final void onClick(View view) {
        MediaShowListFragment.MediaShowAdapter.k(this.f4697a, this.b, this.c, this.d, view);
    }
}
