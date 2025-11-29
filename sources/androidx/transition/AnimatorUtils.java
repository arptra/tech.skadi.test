package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class AnimatorUtils {

    public interface AnimatorPauseListenerCompat {
    }

    public static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public static void b(Animator animator) {
        animator.pause();
    }

    public static void c(Animator animator) {
        animator.resume();
    }
}
