package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

@RequiresApi
public abstract class EmojiSpan extends ReplacementSpan {

    /* renamed from: a  reason: collision with root package name */
    public final Paint.FontMetricsInt f1204a = new Paint.FontMetricsInt();
    public final EmojiMetadata b;
    public short c = -1;
    public short d = -1;
    public float e = 1.0f;

    public EmojiSpan(EmojiMetadata emojiMetadata) {
        Preconditions.i(emojiMetadata, "metadata cannot be null");
        this.b = emojiMetadata;
    }

    public final EmojiMetadata a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f1204a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f1204a;
        this.e = (((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f) / ((float) this.b.e());
        this.d = (short) ((int) (((float) this.b.e()) * this.e));
        short i3 = (short) ((int) (((float) this.b.i()) * this.e));
        this.c = i3;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f1204a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i3;
    }
}
