package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0002rsB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014¢\u0006\u0004\b#\u0010$J7\u0010*\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0007H\u0014¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0015H\u0016¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00152\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J!\u0010:\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0015H\u0002¢\u0006\u0004\b<\u00105J\u0017\u0010=\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b=\u0010\u001bJ\u0017\u0010>\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b>\u0010\u001bJ\u0017\u0010?\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b?\u0010\u001bJ\u0017\u0010@\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b@\u0010\u001bJ\u000f\u0010A\u001a\u00020\u0015H\u0002¢\u0006\u0004\bA\u00105J\u001f\u0010C\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0010H\u0002¢\u0006\u0004\bC\u0010DJ)\u0010I\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0010H\u0002¢\u0006\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010KR\u0016\u0010M\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010KR\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010NR\u0016\u0010P\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010NR\u0016\u0010R\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010QR\u0016\u0010S\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010NR\u0016\u0010T\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010NR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010VR\u0016\u0010X\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010NR\u0016\u0010[\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010KR\u0016\u0010_\u001a\u00020\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010NR\u0014\u0010a\u001a\u00020\u000b8\u0002XD¢\u0006\u0006\n\u0004\b`\u0010QR\u0016\u0010c\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010KR\u0014\u0010e\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010NR\u0014\u0010g\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010NR\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010o¨\u0006t"}, d2 = {"Lcom/upuphone/xr/sapp/view/SuperSeekBar;", "Landroid/view/View;", "Ljava/lang/Runnable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getProgressRate", "()D", "getProgressFromProgressRate", "()I", "", "getProgressHeight", "()F", "getProgress", "mProgress", "", "setProgress", "(I)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "Lcom/upuphone/xr/sapp/view/SuperSeekBar$ISuperSeekBarListener;", "listener", "setOnProgressChangedListener", "(Lcom/upuphone/xr/sapp/view/SuperSeekBar$ISuperSeekBarListener;)V", "run", "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "b", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "c", "d", "f", "g", "e", "a", "spValue", "i", "(Landroid/content/Context;F)I", "Landroid/graphics/Bitmap;", "bitmapOrg", "newWidth", "newHeight", "h", "(Landroid/graphics/Bitmap;FF)Landroid/graphics/Bitmap;", "I", "bgColor", "progressColor", "F", "progress", "maxProgress", "D", "progressRate", "downY", "moveDistance", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mBgPaint", "radiusXY", "j", "Z", "showText", "k", "textHeight", "l", "textSize", "m", "thresholdProgressRate", "n", "textColor", "o", "strokeWidth", "p", "padding", "q", "Lcom/upuphone/xr/sapp/view/SuperSeekBar$ISuperSeekBarListener;", "r", "Landroid/graphics/drawable/Drawable;", "mIcon", "Landroid/os/Handler;", "s", "Landroid/os/Handler;", "mTimeHandler", "t", "Companion", "ISuperSeekBarListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SuperSeekBar extends View implements Runnable {
    public static final Companion t = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public int f7992a;
    public int b;
    public float c;
    public float d;
    public double e;
    public float f;
    public float g;
    public Paint h;
    public float i;
    public boolean j;
    public int k;
    public float l;
    public final double m;
    public int n;
    public final float o;
    public final float p;
    public ISuperSeekBarListener q;
    public Drawable r;
    public final Handler s;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/view/SuperSeekBar$Companion;", "", "()V", "DISMISS_TIME", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/view/SuperSeekBar$ISuperSeekBarListener;", "", "", "visibility", "", "b", "(I)V", "progress", "", "actionUp", "a", "(IZ)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ISuperSeekBarListener {
        void a(int i, boolean z);

        void b(int i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuperSeekBar(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getProgressFromProgressRate() {
        double ceil;
        float f2 = (float) 1;
        float f3 = this.d - f2;
        if (f3 <= 3.0f) {
            ceil = ((double) f3) * this.e;
        } else {
            double d2 = this.e;
            double d3 = this.m;
            if (d2 > ((double) 1) - d3) {
                return (int) (f3 + f2);
            }
            if (d2 < d3) {
                return 0;
            }
            ceil = Math.ceil(((double) f3) * d2);
        }
        return (int) ceil;
    }

    private final float getProgressHeight() {
        return ((float) getHeight()) - (((float) 2) * this.p);
    }

    private final double getProgressRate() {
        double d2 = ((double) this.c) / ((double) (this.d - ((float) 1)));
        double d3 = this.m;
        if (d2 > ((double) 1) - d3) {
            return 1.0d;
        }
        if (d2 < d3) {
            return 0.0d;
        }
        return d2;
    }

    public final void a() {
        double progressHeight = ((((double) getProgressHeight()) * this.e) + ((double) this.g)) / ((double) getProgressHeight());
        this.e = progressHeight;
        if (progressHeight >= 1.0d) {
            this.e = 1.0d;
        }
        if (this.e <= 0.0d) {
            this.e = 0.0d;
        }
    }

    public final void b(Context context, AttributeSet attributeSet) {
        this.l = (float) i(context, this.l);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SuperSeekBar);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f7992a = obtainStyledAttributes.getColor(R.styleable.SuperSeekBar_seekbar_bgColor, ContextCompat.getColor(getContext(), R.color.s_bg_color));
        this.b = obtainStyledAttributes.getColor(R.styleable.SuperSeekBar_seekbar_progressColor, ContextCompat.getColor(getContext(), R.color.s_progress_color));
        this.c = obtainStyledAttributes.getFloat(R.styleable.SuperSeekBar_seekbar_progress, 10.0f);
        this.d = obtainStyledAttributes.getFloat(R.styleable.SuperSeekBar_seekbar_maxProgress, 100.0f);
        this.i = obtainStyledAttributes.getDimension(R.styleable.SuperSeekBar_seekbar_radiusXY, 200.0f);
        this.j = obtainStyledAttributes.getBoolean(R.styleable.SuperSeekBar_seekbar_showText, false);
        this.n = obtainStyledAttributes.getColor(R.styleable.SuperSeekBar_seekbar_setTextColor, ContextCompat.getColor(getContext(), R.color.white));
        this.k = obtainStyledAttributes.getInt(R.styleable.SuperSeekBar_seekbar_setTextHeight, -1);
        this.l = obtainStyledAttributes.getDimension(R.styleable.SuperSeekBar_seekbar_setTextSize, 15.0f);
        obtainStyledAttributes.recycle();
        c();
    }

    public final void c() {
        this.e = getProgressRate();
        Paint paint = new Paint();
        this.h = paint;
        Intrinsics.checkNotNull(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.h;
        Intrinsics.checkNotNull(paint2);
        paint2.setDither(true);
        Paint paint3 = this.h;
        Intrinsics.checkNotNull(paint3);
        paint3.setColor(this.f7992a);
        Paint paint4 = this.h;
        Intrinsics.checkNotNull(paint4);
        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint5 = this.h;
        Intrinsics.checkNotNull(paint5);
        paint5.setStrokeWidth(this.o);
        Paint paint6 = this.h;
        Intrinsics.checkNotNull(paint6);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        Paint paint7 = this.h;
        Intrinsics.checkNotNull(paint7);
        paint7.setTextSize(this.l);
    }

    public final void d(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f2 = this.p;
        RectF rectF = new RectF(f2, f2, ((float) width) - f2, ((float) height) - f2);
        Paint paint = this.h;
        Intrinsics.checkNotNull(paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.h;
        Intrinsics.checkNotNull(paint2);
        paint2.setColor(this.b);
        Paint paint3 = this.h;
        Intrinsics.checkNotNull(paint3);
        paint3.setStrokeWidth(this.o);
        float f3 = this.i;
        Paint paint4 = this.h;
        Intrinsics.checkNotNull(paint4);
        canvas.drawRoundRect(rectF, f3, f3, paint4);
        Paint paint5 = this.h;
        Intrinsics.checkNotNull(paint5);
        paint5.setStyle(Paint.Style.FILL);
        Paint paint6 = this.h;
        Intrinsics.checkNotNull(paint6);
        paint6.setColor(this.f7992a);
        Paint paint7 = this.h;
        Intrinsics.checkNotNull(paint7);
        paint7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float f4 = this.i;
        Paint paint8 = this.h;
        Intrinsics.checkNotNull(paint8);
        canvas.drawRoundRect(rectF, f4, f4, paint8);
        Paint paint9 = this.h;
        Intrinsics.checkNotNull(paint9);
        paint9.setXfermode((Xfermode) null);
    }

    public final void e(Canvas canvas) {
        Drawable drawable = this.r;
        if (drawable != null) {
            float width = ((float) (getWidth() / 2)) - this.p;
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNull(bitmap);
            Bitmap h2 = h(bitmap, width, width);
            Intrinsics.checkNotNull(h2);
            canvas.drawBitmap(h2, ((float) (getWidth() / 2)) - (width / ((float) 2)), (float) (getHeight() - (getHeight() / 3)), this.h);
        }
    }

    public final void f(Canvas canvas) {
        Paint paint = this.h;
        Intrinsics.checkNotNull(paint);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.h;
        Intrinsics.checkNotNull(paint2);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float width = ((float) getWidth()) - this.o;
        Paint paint3 = this.h;
        Intrinsics.checkNotNull(paint3);
        paint3.setColor(this.b);
        ULog.Delegate delegate = ULog.f6446a;
        double d2 = this.e;
        delegate.a("SuperSeekBar", "22progressRate = " + d2);
        double d3 = (double) 1;
        float progressHeight = (float) (((double) this.p) + ((d3 - this.e) * ((double) getProgressHeight())));
        double d4 = this.e;
        double d5 = this.m;
        if (d4 > d3 - d5) {
            progressHeight = this.p;
        } else if (d4 < d5) {
            progressHeight = this.p + getProgressHeight();
        }
        float f2 = progressHeight;
        Paint paint4 = this.h;
        Intrinsics.checkNotNull(paint4);
        canvas.drawRect(10.0f, f2, width, ((float) getHeight()) - this.p, paint4);
        Paint paint5 = this.h;
        Intrinsics.checkNotNull(paint5);
        paint5.setXfermode((Xfermode) null);
    }

    public final void g(Canvas canvas) {
        if (this.j) {
            Paint paint = this.h;
            Intrinsics.checkNotNull(paint);
            paint.setStyle(Paint.Style.FILL);
            StringBuilder sb = new StringBuilder();
            sb.append((int) (this.e * ((double) 100)));
            String sb2 = sb.toString();
            Paint paint2 = this.h;
            Intrinsics.checkNotNull(paint2);
            paint2.setColor(this.n);
            Paint paint3 = this.h;
            Intrinsics.checkNotNull(paint3);
            float width = ((float) (canvas.getWidth() >> 1)) - (paint3.measureText(sb2) / ((float) 2));
            int i2 = this.k;
            float floatValue = ((Float) (i2 >= 0 ? Integer.valueOf(i2) : Float.valueOf(((float) getHeight()) / 6.0f))).floatValue();
            Paint paint4 = this.h;
            Intrinsics.checkNotNull(paint4);
            canvas.drawText(sb2, width, floatValue, paint4);
        }
    }

    public final int getProgress() {
        return (int) this.c;
    }

    public final Bitmap h(Bitmap bitmap, float f2, float f3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2 / ((float) width), f3 / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public final int i(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (Paint) null);
        d(canvas);
        f(canvas);
        g(canvas);
        e(canvas);
        canvas.restoreToCount(saveLayer);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.s.removeCallbacks(this);
            this.f = motionEvent.getY();
        } else if (action == 1) {
            this.s.postDelayed(this, AssistantConstants.TIMEOUT_VAD_MUTE);
            ISuperSeekBarListener iSuperSeekBarListener = this.q;
            Intrinsics.checkNotNull(iSuperSeekBarListener);
            iSuperSeekBarListener.a(getProgressFromProgressRate(), true);
        } else if (action == 2) {
            this.g = this.f - motionEvent.getY();
            a();
            this.f = motionEvent.getY();
            ISuperSeekBarListener iSuperSeekBarListener2 = this.q;
            if (iSuperSeekBarListener2 != null) {
                Intrinsics.checkNotNull(iSuperSeekBarListener2);
                iSuperSeekBarListener2.a(getProgressFromProgressRate(), false);
            }
        }
        invalidate();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void onVisibilityChanged(View view, int i2) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onVisibilityChanged(view, i2);
        ULog.Delegate delegate = ULog.f6446a;
        int id = view.getId();
        delegate.a("SuperSeekBar", "super seekbar onVisibilityChanged visibility is: " + i2 + " changedView is: " + id);
        if (view.getId() > 0) {
            if (i2 == 0) {
                this.s.removeCallbacks(this);
                this.s.postDelayed(this, AssistantConstants.TIMEOUT_VAD_MUTE);
            } else {
                this.s.removeCallbacks(this, Long.valueOf(AssistantConstants.TIMEOUT_VAD_MUTE));
            }
            ISuperSeekBarListener iSuperSeekBarListener = this.q;
            if (iSuperSeekBarListener != null) {
                Intrinsics.checkNotNull(iSuperSeekBarListener);
                iSuperSeekBarListener.b(i2);
            }
        }
    }

    public void run() {
        setVisibility(8);
    }

    public final void setIcon(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.r = drawable;
    }

    public final void setOnProgressChangedListener(@Nullable ISuperSeekBarListener iSuperSeekBarListener) {
        this.q = iSuperSeekBarListener;
    }

    public final void setProgress(int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        float f2 = this.c;
        delegate.a("SuperSeekBar", "setProgress  " + f2);
        this.c = (float) i2;
        this.e = getProgressRate();
        invalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuperSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuperSeekBar(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuperSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = 10.0f;
        this.d = 100.0f;
        this.i = 200.0f;
        this.j = true;
        this.k = -1;
        this.l = 15.0f;
        this.m = 0.02d;
        this.n = -1;
        this.o = (float) StaticMethodUtilsKt.h(1.0f);
        this.p = (float) StaticMethodUtilsKt.h(10.0f);
        b(context, attributeSet);
        this.s = new Handler(Looper.getMainLooper());
    }
}
