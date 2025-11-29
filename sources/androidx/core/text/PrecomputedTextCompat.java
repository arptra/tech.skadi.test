package androidx.core.text;

import android.os.Trace;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat implements Spannable {
    public static final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Spannable f823a;
    public final Params b;
    public final int[] c;
    public final PrecomputedText d;

    @RequiresApi
    public static class Api28Impl {
        @DoNotInline
        public static Spannable a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    public static final class Params {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f824a;
        public final TextDirectionHeuristic b;
        public final int c;
        public final int d;
        public final PrecomputedText.Params e;

        public static class Builder {
        }

        public Params(PrecomputedText.Params params) {
            this.f824a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            this.e = params;
        }

        public boolean a(Params params) {
            if (this.c == params.b() && this.d == params.c() && this.f824a.getTextSize() == params.e().getTextSize() && this.f824a.getTextScaleX() == params.e().getTextScaleX() && this.f824a.getTextSkewX() == params.e().getTextSkewX() && this.f824a.getLetterSpacing() == params.e().getLetterSpacing() && TextUtils.equals(this.f824a.getFontFeatureSettings(), params.e().getFontFeatureSettings()) && this.f824a.getFlags() == params.e().getFlags() && this.f824a.getTextLocales().equals(params.e().getTextLocales())) {
                return this.f824a.getTypeface() == null ? params.e().getTypeface() == null : this.f824a.getTypeface().equals(params.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public TextDirectionHeuristic d() {
            return this.b;
        }

        public TextPaint e() {
            return this.f824a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (!a(params)) {
                return false;
            }
            return this.b == params.d();
        }

        public int hashCode() {
            return ObjectsCompat.b(Float.valueOf(this.f824a.getTextSize()), Float.valueOf(this.f824a.getTextScaleX()), Float.valueOf(this.f824a.getTextSkewX()), Float.valueOf(this.f824a.getLetterSpacing()), Integer.valueOf(this.f824a.getFlags()), this.f824a.getTextLocales(), this.f824a.getTypeface(), Boolean.valueOf(this.f824a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f824a.getTextSize());
            sb.append(", textScaleX=" + this.f824a.getTextScaleX());
            sb.append(", textSkewX=" + this.f824a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f824a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f824a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f824a.getTextLocales());
            sb.append(", typeface=" + this.f824a.getTypeface());
            sb.append(", variationSettings=" + this.f824a.getFontVariationSettings());
            sb.append(", textDir=" + this.b);
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }
    }

    public static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        public static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {

            /* renamed from: a  reason: collision with root package name */
            public Params f825a;
            public CharSequence b;

            /* renamed from: a */
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.a(this.b, this.f825a);
            }
        }
    }

    public PrecomputedTextCompat(CharSequence charSequence, Params params, int[] iArr) {
        this.f823a = new SpannableString(charSequence);
        this.b = params;
        this.c = iArr;
        this.d = null;
    }

    public static PrecomputedTextCompat a(CharSequence charSequence, Params params) {
        Preconditions.h(charSequence);
        Preconditions.h(params);
        try {
            Trace.beginSection("PrecomputedText");
            PrecomputedText.Params params2 = params.e;
            if (params2 != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = TextUtils.indexOf(charSequence, 10, i, length);
                i = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.e(), Integer.MAX_VALUE).setBreakStrategy(params.b()).setHyphenationFrequency(params.c()).setTextDirection(params.d()).build();
            PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(charSequence, params, iArr);
            Trace.endSection();
            return precomputedTextCompat;
        } finally {
            Trace.endSection();
        }
    }

    public PrecomputedText b() {
        Spannable spannable = this.f823a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i) {
        return this.f823a.charAt(i);
    }

    public int getSpanEnd(Object obj) {
        return this.f823a.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f823a.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f823a.getSpanStart(obj);
    }

    public Object[] getSpans(int i, int i2, Class cls) {
        return this.d.getSpans(i, i2, cls);
    }

    public int length() {
        return this.f823a.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f823a.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.d.removeSpan(obj);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.d.setSpan(obj, i, i2, i3);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f823a.subSequence(i, i2);
    }

    public String toString() {
        return this.f823a.toString();
    }

    public PrecomputedTextCompat(PrecomputedText precomputedText, Params params) {
        this.f823a = Api28Impl.a(precomputedText);
        this.b = params;
        this.c = null;
        this.d = precomputedText;
    }
}
