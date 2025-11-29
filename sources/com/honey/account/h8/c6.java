package com.honey.account.h8;

import com.luck.picture.lib.interfaces.OnQueryDataSourceListener;
import com.upuphone.xr.sapp.fragment.MediaSelectFragment;
import java.util.List;

public final /* synthetic */ class c6 implements OnQueryDataSourceListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaSelectFragment f4559a;
    public final /* synthetic */ MediaSelectFragment.GridAdapter b;

    public /* synthetic */ c6(MediaSelectFragment mediaSelectFragment, MediaSelectFragment.GridAdapter gridAdapter) {
        this.f4559a = mediaSelectFragment;
        this.b = gridAdapter;
    }

    public final void a(List list) {
        MediaSelectFragment.J0(this.f4559a, this.b, list);
    }
}
