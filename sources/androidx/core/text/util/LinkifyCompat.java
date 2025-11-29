package androidx.core.text.util;

import android.text.Spannable;
import android.text.util.Linkify;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Comparator;
import java.util.regex.Pattern;

public final class LinkifyCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f832a = new String[0];
    public static final Comparator b = new a();

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static void a(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
        }

        @DoNotInline
        public static boolean b(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
    }

    public static class LinkSpec {

        /* renamed from: a  reason: collision with root package name */
        public int f833a;
        public int b;
    }

    @RestrictTo
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    public static /* synthetic */ int b(LinkSpec linkSpec, LinkSpec linkSpec2) {
        int i = linkSpec.f833a;
        int i2 = linkSpec2.f833a;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return Integer.compare(linkSpec2.b, linkSpec.b);
    }
}
