package com.honey.account.w8;

import android.widget.ImageView;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f7643a;
    public final /* synthetic */ CustomFrameAnimation.MyFrame b;

    public /* synthetic */ d(ImageView imageView, CustomFrameAnimation.MyFrame myFrame) {
        this.f7643a = imageView;
        this.b = myFrame;
    }

    public final void run() {
        CustomFrameAnimation.n(this.f7643a, this.b);
    }
}
