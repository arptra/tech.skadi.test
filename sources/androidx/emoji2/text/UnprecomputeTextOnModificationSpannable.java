package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.annotation.RequiresApi;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

class UnprecomputeTextOnModificationSpannable implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1215a = false;
    public Spannable b;

    @RequiresApi
    public static class CharSequenceHelper_API24 {
        public static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        public static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    public static class PrecomputedTextDetector {
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    @RequiresApi
    public static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    public UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.b = spannable;
    }

    public static PrecomputedTextDetector c() {
        return new PrecomputedTextDetector_28();
    }

    public final void a() {
        Spannable spannable = this.b;
        if (!this.f1215a && c().a(spannable)) {
            this.b = new SpannableString(spannable);
        }
        this.f1215a = true;
    }

    public Spannable b() {
        return this.b;
    }

    public char charAt(int i) {
        return this.b.charAt(i);
    }

    public IntStream chars() {
        return CharSequenceHelper_API24.a(this.b);
    }

    public IntStream codePoints() {
        return CharSequenceHelper_API24.b(this.b);
    }

    public int getSpanEnd(Object obj) {
        return this.b.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.b.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.b.getSpanStart(obj);
    }

    public Object[] getSpans(int i, int i2, Class cls) {
        return this.b.getSpans(i, i2, cls);
    }

    public int length() {
        return this.b.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.b.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        a();
        this.b.removeSpan(obj);
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        a();
        this.b.setSpan(obj, i, i2, i3);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.b.subSequence(i, i2);
    }

    public String toString() {
        return this.b.toString();
    }

    public UnprecomputeTextOnModificationSpannable(CharSequence charSequence) {
        this.b = new SpannableString(charSequence);
    }
}
