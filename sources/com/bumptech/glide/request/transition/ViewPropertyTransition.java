package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;

public class ViewPropertyTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    public final Animator f2732a;

    public interface Animator {
        void a(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.f2732a = animator;
    }

    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() == null) {
            return false;
        }
        this.f2732a.a(viewAdapter.getView());
        return false;
    }
}
