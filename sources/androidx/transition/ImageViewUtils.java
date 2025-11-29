package androidx.transition;

import android.graphics.Matrix;
import android.widget.ImageView;

class ImageViewUtils {
    public static void a(ImageView imageView, Matrix matrix) {
        imageView.animateTransform(matrix);
    }
}
