package flyme.support.v7.anim;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class FlymeXYSpring {
    private SpringAnimation springAnimationX;
    private SpringAnimation springAnimationY;

    public FlymeXYSpring(View view, float f, float f2, DynamicAnimation.OnAnimationEndListener onAnimationEndListener, boolean z) {
        SpringAnimation y = new SpringAnimation(view, DynamicAnimation.p).y(createSpringForce(f, f2));
        this.springAnimationX = y;
        y.b(onAnimationEndListener);
        if (!z) {
            this.springAnimationY = new SpringAnimation(view, DynamicAnimation.q).y(createSpringForce(f, f2));
        }
    }

    private SpringForce createSpringForce(float f, float f2) {
        SpringForce springForce = new SpringForce();
        springForce.d(f);
        springForce.f(f2);
        return springForce;
    }

    private void startSpring(SpringAnimation springAnimation, float f, float f2) {
        if (springAnimation != null) {
            stopSpring(springAnimation);
            springAnimation.n(f);
            if (springAnimation.v() != null) {
                springAnimation.v().e(f2);
            }
            springAnimation.q();
        }
    }

    private void stopSpring(SpringAnimation springAnimation) {
        if (springAnimation != null && springAnimation.h()) {
            springAnimation.d();
        }
    }

    public void start(float f, float f2, DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!(onAnimationUpdateListener == null || this.springAnimationX == null)) {
            stop();
            this.springAnimationX.c(onAnimationUpdateListener);
        }
        startSpring(this.springAnimationX, f, f2);
        startSpring(this.springAnimationY, f, f2);
    }

    public void stop() {
        stopSpring(this.springAnimationX);
        stopSpring(this.springAnimationY);
    }
}
