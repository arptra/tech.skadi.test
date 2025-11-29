package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {
    public static ColorStateList a(Context context, int i) {
        return ContextCompat.getColorStateList(context, i);
    }

    public static Drawable b(Context context, int i) {
        return ResourceManagerInternal.g().i(context, i);
    }
}
