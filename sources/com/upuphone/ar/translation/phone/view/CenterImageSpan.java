package com.upuphone.ar.translation.phone.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJY\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/CenterImageSpan;", "Landroid/text/style/ImageSpan;", "Landroid/content/Context;", "context", "", "resourceId", "", "isViewRtl", "<init>", "(Landroid/content/Context;IZ)V", "Landroid/graphics/Canvas;", "canvas", "", "text", "start", "end", "", "x", "top", "y", "bottom", "Landroid/graphics/Paint;", "paint", "", "draw", "(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V", "a", "Z", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CenterImageSpan extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f6320a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CenterImageSpan(Context context, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, (i2 & 4) != 0 ? false : z);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.save();
            canvas.translate(f, (float) (((((fontMetricsInt.descent + i4) + i4) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2)));
            if (this.f6320a) {
                canvas.scale(-1.0f, 1.0f, drawable.getBounds().exactCenterX(), drawable.getBounds().exactCenterY());
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CenterImageSpan(Context context, int i, boolean z) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6320a = z;
    }
}
