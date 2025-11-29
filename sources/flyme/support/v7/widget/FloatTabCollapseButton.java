package flyme.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.animation.PathInterpolatorCompat;
import flyme.support.v7.appcompat.R;
import flyme.support.v7.view.ActionBarPolicy;

public class FloatTabCollapseButton extends TabCollapseButton {
    private static final int ANIMATION_DURATION = 350;
    private static final Interpolator ANIMATION_INTERPOLATOR_TRANSLATION = PathInterpolatorCompat.a(0.18f, 0.236f, 0.1f, 1.0f);
    private static final int TRANSLATION_LENGTH_DP = 8;
    private int mHeight;
    private final float mTranslationLength;

    public FloatTabCollapseButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public ViewPropertyAnimatorCompatSet createCollapseAnimation(boolean z) {
        return super.createCollapseAnimation(z);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.mzFloatTabContainerCollapseButtonStyle);
    }

    public FloatTabCollapseButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHeight = ActionBarPolicy.get(context).getTabContainerHeight();
        setVisibility(8);
        this.mTranslationLength = getResources().getDisplayMetrics().density * 8.0f;
        setBackgroundDrawable((Drawable) null);
    }
}
