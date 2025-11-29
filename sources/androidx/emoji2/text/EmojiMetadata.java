package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi
@AnyThread
@RestrictTo
public class EmojiMetadata {
    public static final ThreadLocal d = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final int f1201a;
    public final MetadataRepo b;
    public volatile int c = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    public EmojiMetadata(MetadataRepo metadataRepo, int i) {
        this.b = metadataRepo;
        this.f1201a = i;
    }

    public void a(Canvas canvas, float f, float f2, Paint paint) {
        Typeface g = this.b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g);
        Canvas canvas2 = canvas;
        canvas2.drawText(this.b.c(), this.f1201a * 2, 2, f, f2, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i) {
        return g().i(i);
    }

    public int c() {
        return g().j();
    }

    public int d() {
        return this.c;
    }

    public short e() {
        return g().l();
    }

    public int f() {
        return g().m();
    }

    public final MetadataItem g() {
        ThreadLocal threadLocal = d;
        MetadataItem metadataItem = (MetadataItem) threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.b.d().k(metadataItem, this.f1201a);
        return metadataItem;
    }

    public short h() {
        return g().n();
    }

    public short i() {
        return g().o();
    }

    public boolean j() {
        return g().k();
    }

    public void k(boolean z) {
        this.c = z ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int c2 = c();
        for (int i = 0; i < c2; i++) {
            sb.append(Integer.toHexString(b(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
