package androidx.transition;

import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
class ViewUtilsApi22 extends ViewUtilsApi21 {
    public static boolean j = true;

    public void f(View view, int i, int i2, int i3, int i4) {
        if (j) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                j = false;
            }
        }
    }
}
