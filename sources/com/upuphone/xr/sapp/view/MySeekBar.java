package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\u0018\u0000 F2\u00020\u0001:\u0002GHB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0011H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010+J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b-\u0010\u0017J\u001f\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b/\u00100R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00101R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u00101R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u00101R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u00105R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u00101R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00101R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002XD¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u00105¨\u0006I"}, d2 = {"Lcom/upuphone/xr/sapp/view/MySeekBar;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getThumbX", "()F", "getProgressFromProgressbarWidth", "()I", "getProgress", "mProgress", "", "setProgress", "(I)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/upuphone/xr/sapp/view/MySeekBar$ISeekBarListener;", "listener", "setOnProgressChangedListener", "(Lcom/upuphone/xr/sapp/view/MySeekBar$ISeekBarListener;)V", "c", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "d", "()V", "b", "e", "progressTmp", "a", "(ILandroid/view/MotionEvent;)V", "I", "colorStart", "colorEnd", "thumbColor", "F", "radiusXY", "progress", "f", "maxProgress", "Landroid/graphics/Paint;", "g", "Landroid/graphics/Paint;", "mBgPaint", "", "h", "D", "thresholdProgressRate", "i", "Lcom/upuphone/xr/sapp/view/MySeekBar$ISeekBarListener;", "j", "progressbarWidth", "k", "Companion", "ISeekBarListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MySeekBar extends View {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public int f7978a;
    public int b;
    public int c;
    public float d;
    public int e;
    public int f;
    public Paint g;
    public final double h;
    public ISeekBarListener i;
    public float j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/view/MySeekBar$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/view/MySeekBar$ISeekBarListener;", "", "", "progress", "", "actionUp", "", "a", "(IZ)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ISeekBarListener {
        void a(int i, boolean z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MySeekBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getProgressFromProgressbarWidth() {
        return (int) ((float) Math.rint((double) (((this.j - ((float) getHeight())) * ((float) this.f)) / ((float) (getWidth() - getHeight())))));
    }

    private final float getThumbX() {
        return this.j - ((float) (getHeight() / 2));
    }

    public final void a(int i2, MotionEvent motionEvent) {
        if (i2 == 0) {
            this.j = (float) getHeight();
        } else if (i2 == this.f) {
            this.j = (float) getWidth();
        }
    }

    public final void b() {
        this.j = ((float) getHeight()) + ((((float) ((getWidth() - getHeight()) * this.e)) * 1.0f) / ((float) this.f));
        invalidate();
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MySeekBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f7978a = obtainStyledAttributes.getColor(R.styleable.MySeekBar_seekbar_color_start, ContextCompat.getColor(getContext(), com.meizu.common.R.color.mz_seekbar_thumb_color));
        this.b = obtainStyledAttributes.getColor(R.styleable.MySeekBar_seekbar_color_end, ContextCompat.getColor(getContext(), com.meizu.common.R.color.mz_seekbar_thumb_color));
        this.c = obtainStyledAttributes.getColor(R.styleable.MySeekBar_thumb_color, ContextCompat.getColor(getContext(), R.color.white));
        this.e = obtainStyledAttributes.getInt(R.styleable.MySeekBar_seekbar_progress_value, 0);
        this.f = obtainStyledAttributes.getInteger(R.styleable.MySeekBar_seekbar_max_progress, 10);
        this.d = obtainStyledAttributes.getDimension(R.styleable.MySeekBar_seekbar_radius, 200.0f);
        obtainStyledAttributes.recycle();
        d();
    }

    public final void d() {
        Paint paint = new Paint();
        this.g = paint;
        Intrinsics.checkNotNull(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.g;
        Intrinsics.checkNotNull(paint2);
        paint2.setDither(true);
        Paint paint3 = this.g;
        Intrinsics.checkNotNull(paint3);
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = this.g;
        Intrinsics.checkNotNull(paint4);
        paint4.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void e(Canvas canvas) {
        LinearGradient linearGradient = new LinearGradient(2.0f, 0.0f, this.j - 2.0f, 0.0f, new int[]{ContextCompat.getColor(getContext(), com.meizu.common.R.color.mz_seekbar_thumb_color), ContextCompat.getColor(getContext(), com.meizu.common.R.color.mz_seekbar_thumb_color)}, (float[]) null, Shader.TileMode.CLAMP);
        Paint paint = this.g;
        if (paint != null) {
            paint.setShader(linearGradient);
        }
        RectF rectF = new RectF(2.0f, 0.0f, this.j - 2.0f, (float) getHeight());
        Paint paint2 = this.g;
        Intrinsics.checkNotNull(paint2);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        float f2 = this.d;
        Paint paint3 = this.g;
        Intrinsics.checkNotNull(paint3);
        canvas.drawRoundRect(rectF, f2, f2, paint3);
        Paint paint4 = this.g;
        Intrinsics.checkNotNull(paint4);
        paint4.setShader((Shader) null);
        Paint paint5 = this.g;
        Intrinsics.checkNotNull(paint5);
        paint5.setColor(-1);
        Paint paint6 = this.g;
        Intrinsics.checkNotNull(paint6);
        canvas.drawCircle(getThumbX(), (float) (getHeight() / 2), (float) StaticMethodUtilsKt.h(7.0f), paint6);
    }

    public final int getProgress() {
        return this.e;
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (Paint) null);
        e(canvas);
        canvas.restoreToCount(saveLayer);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        float x = motionEvent.getX();
        int height = getHeight();
        System.out.println("MySeekBar .... event = " + x + ",height = " + height);
        int action = motionEvent.getAction();
        if (action == 0) {
            float max = Math.max(motionEvent.getX(), (float) getHeight());
            this.j = max;
            this.j = Math.min(max, (float) getWidth());
            a(getProgressFromProgressbarWidth(), motionEvent);
        } else if (action == 1) {
            float max2 = Math.max(motionEvent.getX(), (float) getHeight());
            this.j = max2;
            this.j = Math.min(max2, (float) getWidth());
            int progressFromProgressbarWidth = getProgressFromProgressbarWidth();
            a(progressFromProgressbarWidth, motionEvent);
            ISeekBarListener iSeekBarListener = this.i;
            if (iSeekBarListener != null) {
                iSeekBarListener.a(progressFromProgressbarWidth, true);
            }
        } else if (action == 2) {
            float max3 = Math.max(motionEvent.getX(), (float) getHeight());
            this.j = max3;
            this.j = Math.min(max3, (float) getWidth());
            int progressFromProgressbarWidth2 = getProgressFromProgressbarWidth();
            a(progressFromProgressbarWidth2, motionEvent);
            ISeekBarListener iSeekBarListener2 = this.i;
            if (iSeekBarListener2 != null) {
                iSeekBarListener2.a(progressFromProgressbarWidth2, false);
            }
        }
        invalidate();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public final void setOnProgressChangedListener(@Nullable ISeekBarListener iSeekBarListener) {
        this.i = iSeekBarListener;
    }

    public final void setProgress(int i2) {
        this.e = i2;
        b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MySeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MySeekBar(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MySeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = 200.0f;
        this.e = 10;
        this.f = 10;
        this.h = 0.02d;
        this.j = (float) getHeight();
        c(context, attributeSet);
    }
}
