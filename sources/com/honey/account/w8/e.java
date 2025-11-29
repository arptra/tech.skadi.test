package com.honey.account.w8;

import android.widget.ImageView;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import java.util.List;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f7644a;
    public final /* synthetic */ CustomFrameAnimation.MyFrame b;
    public final /* synthetic */ CustomFrameAnimation c;
    public final /* synthetic */ List d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ CustomFrameAnimation.IAnimState f;

    public /* synthetic */ e(ImageView imageView, CustomFrameAnimation.MyFrame myFrame, CustomFrameAnimation customFrameAnimation, List list, boolean z, CustomFrameAnimation.IAnimState iAnimState) {
        this.f7644a = imageView;
        this.b = myFrame;
        this.c = customFrameAnimation;
        this.d = list;
        this.e = z;
        this.f = iAnimState;
    }

    public final void run() {
        CustomFrameAnimation.o(this.f7644a, this.b, this.c, this.d, this.e, this.f);
    }
}
