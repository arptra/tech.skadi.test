package sdk.meizu.account.factor.authentication.sdk.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatButton;
import sdk.meizu.account.factor.authentication.sdk.common.animator.MzPressAnimationBuilder;

public class MzButton extends AppCompatButton {
    private MzPressAnimationBuilder mMzPressAnimationBuilder;

    public MzButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setupPressAnim() {
        MzPressAnimationBuilder mzPressAnimationBuilder = new MzPressAnimationBuilder(this);
        this.mMzPressAnimationBuilder = mzPressAnimationBuilder;
        mzPressAnimationBuilder.pressAnimationInit();
        this.mMzPressAnimationBuilder.setToAlpha(1.0f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mMzPressAnimationBuilder.pressAnimationStart();
            } else if (action == 1 || action == 3) {
                this.mMzPressAnimationBuilder.pressAnimationReverse();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public MzButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MzButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setupPressAnim();
    }
}
