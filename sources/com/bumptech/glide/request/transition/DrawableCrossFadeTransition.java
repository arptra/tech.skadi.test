package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    public final int f2726a;
    public final boolean b;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.f2726a = i;
        this.b = z;
    }

    /* renamed from: b */
    public boolean a(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable b2 = viewAdapter.b();
        if (b2 == null) {
            b2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{b2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.f2726a);
        viewAdapter.f(transitionDrawable);
        return true;
    }
}
