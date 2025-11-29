package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.Util;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public TransitionFactory f2431a = NoTransition.c();

    /* renamed from: b */
    public final TransitionOptions clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final TransitionFactory c() {
        return this.f2431a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionOptions) {
            return Util.e(this.f2431a, ((TransitionOptions) obj).f2431a);
        }
        return false;
    }

    public int hashCode() {
        TransitionFactory transitionFactory = this.f2431a;
        if (transitionFactory != null) {
            return transitionFactory.hashCode();
        }
        return 0;
    }
}
