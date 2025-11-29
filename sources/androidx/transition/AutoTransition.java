package androidx.transition;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        M();
    }

    public final void M() {
        J(1);
        x(new Fade(2)).x(new ChangeBounds()).x(new Fade(1));
    }
}
