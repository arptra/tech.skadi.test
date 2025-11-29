package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi
@RestrictTo
public final class TypefaceEmojiSpan extends EmojiSpan {
    public static Paint f;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    public static Paint c() {
        if (f == null) {
            TextPaint textPaint = new TextPaint();
            f = textPaint;
            textPaint.setColor(EmojiCompat.b().c());
            f.setStyle(Paint.Style.FILL);
        }
        return f;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        if (EmojiCompat.b().i()) {
            canvas.drawRect(f2, (float) i3, f2 + ((float) b()), (float) i5, c());
        }
        a().a(canvas, f2, (float) i4, paint);
    }
}
