package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.view.GravityCompat;

public final class RoundedBitmapDrawableFactory {

    public static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        public void d(int i, int i2, int i3, Rect rect, Rect rect2) {
            GravityCompat.a(i, i2, i3, rect, rect2, 0);
        }
    }

    public static RoundedBitmapDrawable a(Resources resources, Bitmap bitmap) {
        return new RoundedBitmapDrawable21(resources, bitmap);
    }

    public static RoundedBitmapDrawable b(Resources resources, String str) {
        RoundedBitmapDrawable a2 = a(resources, BitmapFactory.decodeFile(str));
        if (a2.b() == null) {
            Log.w("RoundedBitmapDrawableFa", "RoundedBitmapDrawable cannot decode " + str);
        }
        return a2;
    }
}
