package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

public class TooltipCompat {

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        public static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(View view, CharSequence charSequence) {
        Api26Impl.a(view, charSequence);
    }
}
