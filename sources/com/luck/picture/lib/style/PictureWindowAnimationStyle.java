package com.luck.picture.lib.style;

import com.luck.picture.lib.R;

public class PictureWindowAnimationStyle {

    /* renamed from: a  reason: collision with root package name */
    public int f9456a;
    public int b;
    public int c;
    public int d;

    public PictureWindowAnimationStyle(int i, int i2) {
        this.f9456a = i;
        this.b = i2;
        this.c = i;
        this.d = i2;
    }

    public static PictureWindowAnimationStyle a() {
        return new PictureWindowAnimationStyle(R.anim.ps_anim_enter, R.anim.ps_anim_exit);
    }
}
