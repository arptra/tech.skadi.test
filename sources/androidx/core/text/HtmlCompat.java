package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Html;
import android.text.Spanned;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@SuppressLint({"InlinedApi"})
public final class HtmlCompat {

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static Spanned a(String str, int i) {
            return Html.fromHtml(str, i);
        }

        @DoNotInline
        public static Spanned b(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i, imageGetter, tagHandler);
        }

        @DoNotInline
        public static String c(Spanned spanned, int i) {
            return Html.toHtml(spanned, i);
        }
    }

    public static Spanned a(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Api24Impl.b(str, i, imageGetter, tagHandler);
    }
}
