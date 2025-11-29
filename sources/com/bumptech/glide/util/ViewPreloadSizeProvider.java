package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {

    /* renamed from: a  reason: collision with root package name */
    public int[] f2751a;
    public SizeViewTarget b;

    public static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        public void e(Object obj, Transition transition) {
        }

        public void i(Drawable drawable) {
        }

        public void l(Drawable drawable) {
        }
    }

    public int[] a(Object obj, int i, int i2) {
        int[] iArr = this.f2751a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public void d(int i, int i2) {
        this.f2751a = new int[]{i, i2};
        this.b = null;
    }
}
