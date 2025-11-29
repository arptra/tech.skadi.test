package com.honey.account.h8;

import android.view.View;
import com.luck.picture.lib.entity.LocalMedia;
import com.upuphone.xr.sapp.fragment.MediaShowListFragment;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class l6 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4674a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ MediaShowListFragment.MediaShowAdapter d;
    public final /* synthetic */ LocalMedia e;

    public /* synthetic */ l6(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, MediaShowListFragment.MediaShowAdapter mediaShowAdapter, LocalMedia localMedia) {
        this.f4674a = objectRef;
        this.b = objectRef2;
        this.c = objectRef3;
        this.d = mediaShowAdapter;
        this.e = localMedia;
    }

    public final void onClick(View view) {
        MediaShowListFragment.MediaShowAdapter.i(this.f4674a, this.b, this.c, this.d, this.e, view);
    }
}
