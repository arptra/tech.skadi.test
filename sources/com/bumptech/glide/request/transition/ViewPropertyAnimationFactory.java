package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ViewPropertyTransition.Animator f2731a;
    public ViewPropertyTransition b;

    public Transition a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE || !z) {
            return NoTransition.b();
        }
        if (this.b == null) {
            this.b = new ViewPropertyTransition(this.f2731a);
        }
        return this.b;
    }
}
