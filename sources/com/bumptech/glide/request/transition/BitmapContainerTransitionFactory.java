package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    public final TransitionFactory f2723a;

    public final class BitmapGlideAnimation implements Transition<R> {

        /* renamed from: a  reason: collision with root package name */
        public final Transition f2724a;

        public BitmapGlideAnimation(Transition transition) {
            this.f2724a = transition;
        }

        public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
            return this.f2724a.a(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerTransitionFactory.this.b(obj)), viewAdapter);
        }
    }

    public Transition a(DataSource dataSource, boolean z) {
        return new BitmapGlideAnimation(this.f2723a.a(dataSource, z));
    }

    public abstract Bitmap b(Object obj);
}
