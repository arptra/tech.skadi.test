package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.RequiresApi;

@RequiresApi
class ViewUtilsApi29 extends ViewUtilsApi23 {
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    public void e(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    public void g(View view, float f) {
        view.setTransitionAlpha(f);
    }

    public void h(View view, int i) {
        view.setTransitionVisibility(i);
    }

    public void i(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    public void j(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
