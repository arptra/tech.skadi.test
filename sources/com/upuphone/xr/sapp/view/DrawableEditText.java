package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 #2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\fR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/view/DrawableEditText;", "Lcom/upuphone/xr/sapp/view/SelectionWatcherEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/upuphone/xr/sapp/view/DrawableEditText$OnDrawableClickListener;", "listener", "", "setOnDrawableClickListener", "(Lcom/upuphone/xr/sapp/view/DrawableEditText$OnDrawableClickListener;)V", "touchDrawableLeft", "touchDrawableTop", "touchDrawableRight", "touchDrawableBottom", "Landroid/graphics/drawable/Drawable;", "b", "Landroid/graphics/drawable/Drawable;", "mDrawableLeft", "c", "mDrawableTop", "d", "mDrawableRight", "e", "mDrawableBottom", "f", "Lcom/upuphone/xr/sapp/view/DrawableEditText$OnDrawableClickListener;", "onDrawableClickListener", "g", "Companion", "OnDrawableClickListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DrawableEditText extends SelectionWatcherEditText {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public Drawable b;
    public Drawable c;
    public Drawable d;
    public Drawable e;
    public OnDrawableClickListener f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/view/DrawableEditText$Companion;", "", "()V", "CLICK_SCALE", "", "DRAWABLE_BOTTOM", "DRAWABLE_LEFT", "DRAWABLE_RIGHT", "DRAWABLE_TOP", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/view/DrawableEditText$OnDrawableClickListener;", "", "", "direction", "Lcom/upuphone/xr/sapp/view/DrawableEditText;", "editText", "", "a", "(ILcom/upuphone/xr/sapp/view/DrawableEditText;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnDrawableClickListener {
        void a(int i, DrawableEditText drawableEditText);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawableEditText(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (1 == motionEvent.getAction() && this.f != null) {
            this.b = getCompoundDrawables()[0];
            this.c = getCompoundDrawables()[1];
            this.d = getCompoundDrawables()[2];
            this.e = getCompoundDrawables()[3];
            if (touchDrawableLeft(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener = this.f;
                Intrinsics.checkNotNull(onDrawableClickListener);
                onDrawableClickListener.a(0, this);
            }
            if (touchDrawableTop(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener2 = this.f;
                Intrinsics.checkNotNull(onDrawableClickListener2);
                onDrawableClickListener2.a(1, this);
            }
            if (touchDrawableRight(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener3 = this.f;
                Intrinsics.checkNotNull(onDrawableClickListener3);
                onDrawableClickListener3.a(2, this);
            }
            if (touchDrawableBottom(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener4 = this.f;
                Intrinsics.checkNotNull(onDrawableClickListener4);
                onDrawableClickListener4.a(3, this);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnDrawableClickListener(@Nullable OnDrawableClickListener onDrawableClickListener) {
        this.f = onDrawableClickListener;
    }

    public final boolean touchDrawableBottom(MotionEvent motionEvent) {
        Drawable drawable = this.e;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.e;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingLeft = getCompoundPaddingLeft();
        double width = (((double) ((getWidth() - getCompoundPaddingRight()) - compoundPaddingLeft)) * 0.5d) + ((double) compoundPaddingLeft);
        double d2 = ((double) intrinsicWidth) * 0.5d;
        return new Rect((int) (width - d2), (getHeight() - getPaddingBottom()) - intrinsicHeight, (int) (width + d2), getHeight() - getPaddingBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public final boolean touchDrawableLeft(MotionEvent motionEvent) {
        Drawable drawable = this.b;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.b;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingTop = getCompoundPaddingTop();
        double height = (((double) ((getHeight() - getCompoundPaddingBottom()) - compoundPaddingTop)) * 0.5d) + ((double) compoundPaddingTop);
        double d2 = ((double) intrinsicHeight) * 0.5d;
        return new Rect(getPaddingLeft(), (int) (height - d2), getPaddingLeft() + intrinsicWidth, (int) (height + d2)).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public final boolean touchDrawableRight(MotionEvent motionEvent) {
        Drawable drawable = this.d;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.d;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingTop = getCompoundPaddingTop();
        double height = (((double) ((getHeight() - getCompoundPaddingBottom()) - compoundPaddingTop)) * 0.5d) + ((double) compoundPaddingTop);
        double d2 = ((double) intrinsicHeight) * 0.5d;
        return new Rect((getWidth() - getPaddingRight()) - intrinsicWidth, (int) (height - d2), getWidth() - getPaddingRight(), (int) (height + d2)).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public final boolean touchDrawableTop(MotionEvent motionEvent) {
        Drawable drawable = this.c;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.c;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingLeft = getCompoundPaddingLeft();
        double width = (((double) ((getWidth() - getCompoundPaddingRight()) - compoundPaddingLeft)) * 0.5d) + ((double) compoundPaddingLeft);
        double d2 = ((double) intrinsicWidth) * 0.5d;
        return new Rect((int) (width - d2), getPaddingTop(), (int) (width + d2), getPaddingTop() + intrinsicHeight).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }
}
