package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ViewTransition.ViewTransitionAnimationFactory f2728a;
    public Transition b;

    public static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f2729a;

        public Animation a(Context context) {
            return this.f2729a;
        }
    }

    public static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* renamed from: a  reason: collision with root package name */
        public final int f2730a;

        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f2730a);
        }
    }

    public Transition a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.b();
        }
        if (this.b == null) {
            this.b = new ViewTransition(this.f2728a);
        }
        return this.b;
    }
}
