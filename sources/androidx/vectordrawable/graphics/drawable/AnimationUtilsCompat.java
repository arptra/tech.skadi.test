package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;

@RestrictTo
public class AnimationUtilsCompat {
    public static Interpolator a(Context context, int i) {
        return AnimationUtils.loadInterpolator(context, i);
    }
}
