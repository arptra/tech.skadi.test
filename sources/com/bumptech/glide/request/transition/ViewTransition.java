package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;

public class ViewTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ViewTransitionAnimationFactory f2733a;

    public interface ViewTransitionAnimationFactory {
        Animation a(Context context);
    }

    public ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.f2733a = viewTransitionAnimationFactory;
    }

    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.f2733a.a(view.getContext()));
        return false;
    }
}
