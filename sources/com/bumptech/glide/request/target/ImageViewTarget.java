package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    public Animatable i;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    public Drawable b() {
        return ((ImageView) this.b).getDrawable();
    }

    public void d(Drawable drawable) {
        super.d(drawable);
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
        s((Object) null);
        f(drawable);
    }

    public void e(Object obj, Transition transition) {
        if (transition == null || !transition.a(obj, this)) {
            s(obj);
        } else {
            q(obj);
        }
    }

    public void f(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    public void g(Drawable drawable) {
        super.g(drawable);
        s((Object) null);
        f(drawable);
    }

    public void i(Drawable drawable) {
        super.i(drawable);
        s((Object) null);
        f(drawable);
    }

    public void onStart() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void onStop() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final void q(Object obj) {
        if (obj instanceof Animatable) {
            Animatable animatable = (Animatable) obj;
            this.i = animatable;
            animatable.start();
            return;
        }
        this.i = null;
    }

    public abstract void r(Object obj);

    public final void s(Object obj) {
        r(obj);
        q(obj);
    }
}
