package androidx.transition;

import android.view.ViewGroup;

public abstract class TransitionPropagation {
    public abstract void a(TransitionValues transitionValues);

    public abstract String[] b();

    public abstract long c(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2);
}
