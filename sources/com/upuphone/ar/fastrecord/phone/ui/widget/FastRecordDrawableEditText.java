package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDrawableEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDrawableBottom", "Landroid/graphics/drawable/Drawable;", "mDrawableLeft", "mDrawableRight", "mDrawableTop", "onDrawableClickListener", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDrawableEditText$OnDrawableClickListener;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setOnDrawableClickListener", "", "listener", "touchDrawableBottom", "touchDrawableLeft", "touchDrawableRight", "touchDrawableTop", "Companion", "OnDrawableClickListener", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDrawableEditText extends AppCompatEditText {
    public static final int CLICK_SCALE = 1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DRAWABLE_BOTTOM = 3;
    public static final int DRAWABLE_LEFT = 0;
    public static final int DRAWABLE_RIGHT = 2;
    public static final int DRAWABLE_TOP = 1;
    @Nullable
    private Drawable mDrawableBottom;
    @Nullable
    private Drawable mDrawableLeft;
    @Nullable
    private Drawable mDrawableRight;
    @Nullable
    private Drawable mDrawableTop;
    @Nullable
    private OnDrawableClickListener onDrawableClickListener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDrawableEditText$Companion;", "", "()V", "CLICK_SCALE", "", "DRAWABLE_BOTTOM", "DRAWABLE_LEFT", "DRAWABLE_RIGHT", "DRAWABLE_TOP", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDrawableEditText$OnDrawableClickListener;", "", "onDrawableClick", "", "direction", "", "editText", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDrawableEditText;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnDrawableClickListener {
        void onDrawableClick(int i, @NotNull FastRecordDrawableEditText fastRecordDrawableEditText);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDrawableEditText(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    private final boolean touchDrawableBottom(MotionEvent motionEvent) {
        Drawable drawable = this.mDrawableBottom;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.mDrawableBottom;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingLeft = getCompoundPaddingLeft();
        double width = (((double) ((getWidth() - getCompoundPaddingRight()) - compoundPaddingLeft)) * 0.5d) + ((double) compoundPaddingLeft);
        double d = ((double) intrinsicWidth) * 0.5d;
        return new Rect((int) (width - d), (getHeight() - getPaddingBottom()) - intrinsicHeight, (int) (width + d), getHeight() - getPaddingBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private final boolean touchDrawableLeft(MotionEvent motionEvent) {
        Drawable drawable = this.mDrawableLeft;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.mDrawableLeft;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingTop = getCompoundPaddingTop();
        double height = (((double) ((getHeight() - getCompoundPaddingBottom()) - compoundPaddingTop)) * 0.5d) + ((double) compoundPaddingTop);
        double d = ((double) intrinsicHeight) * 0.5d;
        return new Rect(getPaddingLeft(), (int) (height - d), getPaddingLeft() + intrinsicWidth, (int) (height + d)).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private final boolean touchDrawableRight(MotionEvent motionEvent) {
        Drawable drawable = this.mDrawableRight;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.mDrawableRight;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingTop = getCompoundPaddingTop();
        double height = (((double) ((getHeight() - getCompoundPaddingBottom()) - compoundPaddingTop)) * 0.5d) + ((double) compoundPaddingTop);
        double d = ((double) intrinsicHeight) * 0.5d;
        return new Rect((getWidth() - getPaddingRight()) - intrinsicWidth, (int) (height - d), getWidth() - getPaddingRight(), (int) (height + d)).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private final boolean touchDrawableTop(MotionEvent motionEvent) {
        Drawable drawable = this.mDrawableTop;
        if (drawable == null) {
            return false;
        }
        Intrinsics.checkNotNull(drawable);
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Drawable drawable2 = this.mDrawableTop;
        Intrinsics.checkNotNull(drawable2);
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int compoundPaddingLeft = getCompoundPaddingLeft();
        double width = (((double) ((getWidth() - getCompoundPaddingRight()) - compoundPaddingLeft)) * 0.5d) + ((double) compoundPaddingLeft);
        double d = ((double) intrinsicWidth) * 0.5d;
        return new Rect((int) (width - d), getPaddingTop(), (int) (width + d), getPaddingTop() + intrinsicHeight).contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (1 == motionEvent.getAction() && this.onDrawableClickListener != null) {
            this.mDrawableLeft = getCompoundDrawables()[0];
            this.mDrawableTop = getCompoundDrawables()[1];
            this.mDrawableRight = getCompoundDrawables()[2];
            this.mDrawableBottom = getCompoundDrawables()[3];
            if (touchDrawableLeft(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener2 = this.onDrawableClickListener;
                Intrinsics.checkNotNull(onDrawableClickListener2);
                onDrawableClickListener2.onDrawableClick(0, this);
            }
            if (touchDrawableTop(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener3 = this.onDrawableClickListener;
                Intrinsics.checkNotNull(onDrawableClickListener3);
                onDrawableClickListener3.onDrawableClick(1, this);
            }
            if (touchDrawableRight(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener4 = this.onDrawableClickListener;
                Intrinsics.checkNotNull(onDrawableClickListener4);
                onDrawableClickListener4.onDrawableClick(2, this);
            }
            if (touchDrawableBottom(motionEvent)) {
                OnDrawableClickListener onDrawableClickListener5 = this.onDrawableClickListener;
                Intrinsics.checkNotNull(onDrawableClickListener5);
                onDrawableClickListener5.onDrawableClick(3, this);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnDrawableClickListener(@Nullable OnDrawableClickListener onDrawableClickListener2) {
        this.onDrawableClickListener = onDrawableClickListener2;
    }
}
