package com.honey.account.v;

import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentManager;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f3125a;

    public /* synthetic */ j(FragmentManager fragmentManager) {
        this.f3125a = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f3125a.g1((PictureInPictureModeChangedInfo) obj);
    }
}
