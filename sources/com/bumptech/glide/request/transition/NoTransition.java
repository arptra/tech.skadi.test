package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public class NoTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    public static final NoTransition f2727a = new NoTransition();
    public static final TransitionFactory b = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        public Transition a(DataSource dataSource, boolean z) {
            return NoTransition.f2727a;
        }
    }

    public static Transition b() {
        return f2727a;
    }

    public static TransitionFactory c() {
        return b;
    }

    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
