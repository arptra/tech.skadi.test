package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.upuphone.xr.sapp.utils.DimensExtKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/view/RingView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "", "needShow", "setNeedShowOuter", "(Z)V", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "paint", "", "b", "F", "strokeWidth", "c", "strokeInterval", "", "d", "I", "getColor", "()I", "setColor", "(I)V", "color", "e", "Z", "needShowOuter", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RingView extends View {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f7980a;
    public float b;
    public float c;
    public int d;
    public boolean e;

    @JvmOverloads
    public RingView(@Nullable Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
    }

    public final int getColor() {
        return this.d;
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.f7980a.setStyle(Paint.Style.FILL);
        this.f7980a.setColor(this.d);
        float width = (float) (getWidth() / 2);
        float f = (float) 5;
        canvas.drawCircle(width, width, ((width - this.c) - this.b) - f, this.f7980a);
        if (this.e) {
            this.f7980a.setStyle(Paint.Style.STROKE);
            this.f7980a.setStrokeWidth(this.b);
            canvas.drawCircle(width, width, width - f, this.f7980a);
        }
        super.onDraw(canvas);
    }

    public final void setColor(int i) {
        this.d = i;
    }

    public final void setNeedShowOuter(boolean z) {
        this.e = z;
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RingView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmOverloads
    public RingView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f7980a = paint;
        this.b = (float) DimensExtKt.b(2);
        this.c = (float) DimensExtKt.b(2);
        this.d = Color.parseColor("#91d439");
        paint.setAntiAlias(true);
    }
}
