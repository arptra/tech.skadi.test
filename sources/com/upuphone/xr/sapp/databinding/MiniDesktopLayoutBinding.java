package com.upuphone.xr.sapp.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class MiniDesktopLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6879a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;

    public MiniDesktopLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8) {
        this.f6879a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = imageView6;
        this.h = imageView7;
        this.i = imageView8;
    }

    public static MiniDesktopLayoutBinding a(View view) {
        int i2 = R.id.arguide;
        ImageView imageView = (ImageView) ViewBindings.a(view, i2);
        if (imageView != null) {
            i2 = R.id.douyin;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i2);
            if (imageView2 != null) {
                i2 = R.id.mini_novice_guide;
                ImageView imageView3 = (ImageView) ViewBindings.a(view, i2);
                if (imageView3 != null) {
                    i2 = R.id.musicplayer;
                    ImageView imageView4 = (ImageView) ViewBindings.a(view, i2);
                    if (imageView4 != null) {
                        i2 = R.id.quickworker;
                        ImageView imageView5 = (ImageView) ViewBindings.a(view, i2);
                        if (imageView5 != null) {
                            i2 = R.id.setting;
                            ImageView imageView6 = (ImageView) ViewBindings.a(view, i2);
                            if (imageView6 != null) {
                                i2 = R.id.translator;
                                ImageView imageView7 = (ImageView) ViewBindings.a(view, i2);
                                if (imageView7 != null) {
                                    i2 = R.id.vientiane;
                                    ImageView imageView8 = (ImageView) ViewBindings.a(view, i2);
                                    if (imageView8 != null) {
                                        return new MiniDesktopLayoutBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6879a;
    }
}
