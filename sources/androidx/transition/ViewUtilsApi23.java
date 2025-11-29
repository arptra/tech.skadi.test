package androidx.transition;

import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
class ViewUtilsApi23 extends ViewUtilsApi22 {
    public static boolean k = true;

    public void h(View view, int i) {
        if (k) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                k = false;
            }
        }
    }
}
