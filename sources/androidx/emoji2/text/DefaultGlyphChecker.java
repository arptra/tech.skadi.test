package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.annotation.AnyThread;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

@AnyThread
@RestrictTo
class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    public static final ThreadLocal b = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f1192a;

    public DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.f1192a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    public static StringBuilder b() {
        ThreadLocal threadLocal = b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    public boolean a(CharSequence charSequence, int i, int i2, int i3) {
        StringBuilder b2 = b();
        b2.setLength(0);
        while (i < i2) {
            b2.append(charSequence.charAt(i));
            i++;
        }
        return PaintCompat.a(this.f1192a, b2.toString());
    }
}
