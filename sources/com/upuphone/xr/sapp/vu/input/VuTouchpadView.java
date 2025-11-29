package com.upuphone.xr.sapp.vu.input;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.honey.account.d9.k;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.vu.ArSpaceService;
import com.upuphone.xr.sapp.vu.input.EventRecordOuterClass;
import com.upuphone.xr.sapp.vu.input.InputEventOuterClass;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\\\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001gB'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\u001f\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010\u0014J\u001f\u0010\"\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010$J'\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH\u0002¢\u0006\u0004\b(\u0010)J!\u0010-\u001a\u00020\u00122\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020\rH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00122\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0012H\u0002¢\u0006\u0004\b3\u0010\u0014J\u0017\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020/H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b7\u0010\u001bJ\u0017\u00108\u001a\u00020\r2\u0006\u00104\u001a\u00020/H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020/H\u0016¢\u0006\u0004\b:\u00109J\u0017\u0010;\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020/H\u0016¢\u0006\u0004\b;\u00102J\u0017\u0010<\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020/H\u0016¢\u0006\u0004\b<\u00109J1\u0010A\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010/2\u0006\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\u000bH\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020/H\u0016¢\u0006\u0004\bC\u00102J1\u0010F\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010/2\u0006\u0010>\u001a\u00020/2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0016¢\u0006\u0004\bF\u0010BJ\r\u0010G\u001a\u00020\u0012¢\u0006\u0004\bG\u0010\u0014J\r\u0010H\u001a\u00020\u0012¢\u0006\u0004\bH\u0010\u0014J\r\u0010I\u001a\u00020\u0012¢\u0006\u0004\bI\u0010\u0014R\u0016\u0010L\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010OR\u0016\u0010S\u001a\u00020Q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010RR\u0016\u0010U\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010TR\u0016\u0010V\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010TR\u0016\u0010W\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010KR\u0014\u0010Z\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010YR\u0016\u0010[\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010TR\u0014\u0010^\u001a\u00020\\8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010]R\u0016\u0010a\u001a\u00020_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010`R\u001b\u0010f\u001a\u00020b8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010c\u001a\u0004\bd\u0010e¨\u0006h"}, d2 = {"Lcom/upuphone/xr/sapp/vu/input/VuTouchpadView;", "Landroid/view/View;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "distance", "", "k", "(F)Z", "scale", "j", "", "l", "()V", "m", "i", "e", "Landroid/graphics/Canvas;", "canvas", "g", "(Landroid/graphics/Canvas;)V", "y", "h", "(Landroid/graphics/Canvas;F)V", "x", "w", "(FF)V", "v", "u", "(F)V", "direction", "forceX", "forceY", "o", "(IFF)V", "", "byteArray", "delay", "r", "([BZ)V", "Landroid/view/MotionEvent;", "ev", "f", "(Landroid/view/MotionEvent;)V", "d", "event", "c", "(Landroid/view/MotionEvent;)F", "onDraw", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDown", "onShowPress", "onSingleTapUp", "e1", "e2", "distanceX", "distanceY", "onScroll", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z", "onLongPress", "velocityX", "velocityY", "onFling", "p", "q", "n", "a", "F", "pointGap", "b", "pointSize", "I", "pointColor", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "Z", "isTouchStart", "isScaleStart", "scaleStartDistance", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "gestureDetector", "performClick", "com/upuphone/xr/sapp/vu/input/VuTouchpadView$handler$1", "Lcom/upuphone/xr/sapp/vu/input/VuTouchpadView$handler$1;", "handler", "", "J", "downTime", "Landroid/os/Vibrator;", "Lkotlin/Lazy;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuTouchpadView extends View implements GestureDetector.OnGestureListener {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public float f8078a;
    public float b;
    public int c;
    public Paint d;
    public boolean e;
    public boolean f;
    public float g;
    public final GestureDetector h;
    public boolean i;
    public final VuTouchpadView$handler$1 j;
    public long k;
    public final Lazy l;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/vu/input/VuTouchpadView$Companion;", "", "()V", "DIRECTION_DOWN", "", "DIRECTION_LEFT", "DIRECTION_RIGHT", "DIRECTION_UP", "FLING_MAX_VELOCITY", "LONG_PRESS_DURATION", "MSG_LONG_PRESS", "SCROLL_MAX", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VuTouchpadView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Vibrator getVibrator() {
        Object value = this.l.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Vibrator) value;
    }

    public static /* synthetic */ void s(VuTouchpadView vuTouchpadView, byte[] bArr, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        vuTouchpadView.r(bArr, z);
    }

    public static final void t(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$byteArray");
        ArSpaceService a2 = ArSpaceService.j.a();
        if (a2 != null) {
            a2.w("input", bArr);
        }
    }

    public final float c(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public final void d() {
        this.j.removeMessages(100);
    }

    public final void e() {
        this.h.onTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
        if (this.e) {
            m();
        }
    }

    public final void f(MotionEvent motionEvent) {
        this.j.removeMessages(100);
        VuTouchpadView$handler$1 vuTouchpadView$handler$1 = this.j;
        vuTouchpadView$handler$1.sendMessageAtTime(vuTouchpadView$handler$1.obtainMessage(100), motionEvent.getDownTime() + ((long) 300));
    }

    public final void g(Canvas canvas) {
        float f2 = this.b + this.f8078a;
        int height = ((int) (((float) ((getHeight() - getPaddingTop()) - getPaddingBottom())) / f2)) + 1;
        for (int i2 = 0; i2 < height; i2++) {
            h(canvas, ((float) getPaddingTop()) + (((float) i2) * f2));
        }
    }

    public final void h(Canvas canvas, float f2) {
        float f3 = this.b + this.f8078a;
        float width = (float) ((getWidth() - getPaddingStart()) - getPaddingEnd());
        int i2 = (int) (width / f3);
        float f4 = width - (((float) i2) * f3);
        float f5 = this.b;
        if (f4 >= f5) {
            i2++;
            f4 -= f5;
        }
        float paddingStart = ((float) getPaddingStart()) + (f4 / ((float) 2));
        for (int i3 = 0; i3 < i2; i3++) {
            float f6 = paddingStart + (((float) i3) * f3);
            float f7 = this.b;
            canvas.drawOval(f6, f2, f6 + f7, f2 + f7, this.d);
        }
    }

    public final void i() {
        n();
    }

    public final boolean j(float f2) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuTouchpadView", "onScale: " + f2);
        u(f2);
        return true;
    }

    public final boolean k(float f2) {
        ULog.f6446a.g("VuTouchpadView", "onScaleBegin");
        this.g = f2;
        return this.f;
    }

    public final void l() {
        ULog.f6446a.g("VuTouchpadView", "onScaleEnd");
        u(0.0f);
    }

    public final void m() {
        ULog.f6446a.g("VuTouchpadView", "onTouchEnd");
        this.e = false;
        d();
        x();
    }

    public final void n() {
        getVibrator().cancel();
        getVibrator().vibrate(VibrationEffect.createOneShot(50, 200));
    }

    public final void o(int i2, float f2, float f3) {
        ULog.f6446a.g("VuTouchpadView", "sendFling: " + i2 + ", " + f2 + ", " + f3);
        float f4 = 1.0f;
        if (i2 == 0 || i2 == 1) {
            if (i2 != 0) {
                f4 = -1.0f;
            }
            byte[] byteArray = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setTrackpadY(f4).setTrackpadForce(f3).build()).build().toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            s(this, byteArray, false, 2, (Object) null);
        } else if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
                f4 = -1.0f;
            }
            byte[] byteArray2 = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setTrackpadX(f4).setTrackpadForce(f2).build()).build().toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray2, "toByteArray(...)");
            s(this, byteArray2, false, 2, (Object) null);
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.f6446a.g("VuTouchpadView", "onDown");
        this.e = true;
        this.k = motionEvent.getDownTime();
        f(motionEvent);
        float f2 = (float) 2;
        w(((motionEvent.getX() - (((float) getWidth()) / 2.0f)) * f2) / ((float) getWidth()), (f2 * (motionEvent.getY() - (((float) getHeight()) / 2.0f))) / ((float) getHeight()));
        return true;
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        g(canvas);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuTouchpadView", "onFling: " + f2 + ", " + f3);
        boolean z = Math.abs(f2) > Math.abs(f3);
        float f4 = (float) 15000;
        float coerceAtMost = RangesKt.coerceAtMost(Math.abs(f2) / f4, 1.0f);
        float coerceAtMost2 = RangesKt.coerceAtMost(Math.abs(f3) / f4, 1.0f);
        if (z) {
            if (f2 > 0.0f) {
                o(3, coerceAtMost, coerceAtMost2);
            } else {
                o(2, coerceAtMost, coerceAtMost2);
            }
        } else if (f3 > 0.0f) {
            o(1, coerceAtMost, coerceAtMost2);
        } else {
            o(0, coerceAtMost, coerceAtMost2);
        }
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.f6446a.g("VuTouchpadView", "onLongPress");
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = this.e;
        delegate.g("VuTouchpadView", "onScroll: started: " + z + ", " + f2 + ", " + f3);
        if (!this.e) {
            return false;
        }
        float f4 = (float) 2;
        v(RangesKt.coerceIn(((motionEvent2.getX() - (((float) getWidth()) / 2.0f)) * f4) / ((float) getWidth()), -1.0f, 1.0f), RangesKt.coerceIn((f4 * (motionEvent2.getY() - (((float) getHeight()) / 2.0f))) / ((float) getHeight()), -1.0f, 1.0f));
        d();
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.f6446a.g("VuTouchpadView", "onShowPress");
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        ULog.f6446a.g("VuTouchpadView", "onSingleTapUp");
        this.i = true;
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction() & 255;
        if (action == 5 && motionEvent.getPointerCount() > 1) {
            ULog.f6446a.g("VuTouchpadView", "onTouchEvent: ACTION_POINTER_DOWN");
            this.f = true;
            e();
            k(c(motionEvent));
            return true;
        } else if ((action == 1 || action == 6 || action == 3) && this.f) {
            ULog.f6446a.g("VuTouchpadView", "onTouchEvent: ACTION_UP");
            this.f = false;
            l();
            return true;
        } else if (!this.f || motionEvent.getPointerCount() <= 1) {
            this.h.onTouchEvent(motionEvent);
            if (action == 1 && this.e) {
                m();
            }
            return true;
        } else {
            j(c(motionEvent) / this.g);
            return true;
        }
    }

    public final void p() {
        byte[] byteArray = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setSelectClick(true).build()).build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        s(this, byteArray, false, 2, (Object) null);
    }

    public final void q() {
        byte[] byteArray = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setSelectClick(false).build()).build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        s(this, byteArray, false, 2, (Object) null);
    }

    public final void r(byte[] bArr, boolean z) {
        if (z) {
            postDelayed(new k(bArr), 50);
            return;
        }
        ArSpaceService a2 = ArSpaceService.j.a();
        if (a2 != null) {
            a2.w("input", bArr);
        }
    }

    public final void u(float f2) {
        byte[] byteArray = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setTriggerValue(f2).build()).build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        s(this, byteArray, false, 2, (Object) null);
    }

    public final void v(float f2, float f3) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuTouchpadView", "sendScroll: " + f2 + ", " + f3);
        byte[] byteArray = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setTrackpadX(f2).setTrackpadY(f3).setTrackpadTouch(true).build()).build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        s(this, byteArray, false, 2, (Object) null);
    }

    public final void w(float f2, float f3) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuTouchpadView", "sendTouchDown x: " + f2 + ", y: " + f3);
        byte[] byteArray = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setTrackpadTouch(true).setTrackpadX(f2).setTrackpadY(f3).build()).build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        s(this, byteArray, false, 2, (Object) null);
    }

    public final void x() {
        ULog.f6446a.g("VuTouchpadView", "sendTouchUp");
        EventRecordOuterClass.EventRecord build = EventRecordOuterClass.EventRecord.newBuilder().setLeftInputEvent(InputEventOuterClass.InputEvent.newBuilder().setTimestamp(SystemClock.elapsedRealtimeNanos()).setActive(true).setTrackpadClick(this.i).build()).build();
        this.i = false;
        byte[] byteArray = build.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        r(byteArray, true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VuTouchpadView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VuTouchpadView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VuTouchpadView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.d = new Paint();
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.h = gestureDetector;
        this.j = new VuTouchpadView$handler$1(this, Looper.getMainLooper());
        this.l = LazyKt.lazy(new VuTouchpadView$vibrator$2(context));
        this.d.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TouchpadView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f8078a = obtainStyledAttributes.getDimension(R.styleable.TouchpadView_pointGap, 48.0f);
        this.b = obtainStyledAttributes.getDimension(R.styleable.TouchpadView_pointSize, 9.0f);
        this.c = obtainStyledAttributes.getColor(R.styleable.TouchpadView_pointColor, -1);
        obtainStyledAttributes.recycle();
        this.d.setColor(this.c);
        gestureDetector.setIsLongpressEnabled(false);
    }
}
