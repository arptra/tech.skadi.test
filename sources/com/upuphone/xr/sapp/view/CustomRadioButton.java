package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.star.core.log.ULog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u00012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001f\u0010 J!\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\f¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00020\b¢\u0006\u0004\b'\u0010\u0018R\"\u0010,\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010%\"\u0004\b+\u0010\u0016R\u0018\u0010/\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010.¨\u00063"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomRadioButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "i", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/upuphone/xr/sapp/view/CustomRadioButton$OnCheckedChangeListener;", "listener", "setOnCheckedChangeListener", "(Lcom/upuphone/xr/sapp/view/CustomRadioButton$OnCheckedChangeListener;)V", "setOnCheckedChangeWidgetListener", "checked", "setChecked", "(Z)V", "onFinishInflate", "()V", "selected", "setSelected", "", "v1", "v2", "", "g", "(Ljava/lang/String;Ljava/lang/String;)I", "", "h", "(Ljava/lang/String;Ljava/lang/String;)[I", "j", "()Z", "performClick", "k", "a", "Z", "getMChecked", "setMChecked", "mChecked", "b", "Lcom/upuphone/xr/sapp/view/CustomRadioButton$OnCheckedChangeListener;", "mOnCheckedChangeListener", "c", "mOnCheckedChangeWidgetListener", "OnCheckedChangeListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CustomRadioButton extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7944a;
    public OnCheckedChangeListener b;
    public OnCheckedChangeListener c;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomRadioButton$OnCheckedChangeListener;", "", "Landroid/view/View;", "buttonView", "", "isChecked", "", "a", "(Landroid/view/View;Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnCheckedChangeListener {
        void a(View view, boolean z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomRadioButton(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        i(context, attributeSet);
    }

    private final void i(Context context, AttributeSet attributeSet) {
        int g = g("attr", "radioButtonStyle");
        int[] h = h("styleable", "CompoundButton");
        TypedArray obtainStyledAttributes = h != null ? context.obtainStyledAttributes(attributeSet, h, g, 0) : null;
        if (obtainStyledAttributes != null && obtainStyledAttributes.hasValue(g("styleable", "CompoundButton_checked"))) {
            setChecked(obtainStyledAttributes.getBoolean(g("styleable", "CompoundButton_checked"), false));
        }
    }

    public final int g(String str, String str2) {
        int i;
        Intrinsics.checkNotNullParameter(str, "v1");
        try {
            Field declaredField = Class.forName("com.android.internal.R$" + str).getDeclaredField(str2);
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            Object obj = declaredField.get((Object) null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            i = ((Integer) obj).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            i = 0;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("MINE", "getInternalR:" + i);
            return i;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            i = 0;
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.o("MINE", "getInternalR:" + i);
            return i;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            i = 0;
            ULog.Delegate delegate22 = ULog.f6446a;
            delegate22.o("MINE", "getInternalR:" + i);
            return i;
        }
        ULog.Delegate delegate222 = ULog.f6446a;
        delegate222.o("MINE", "getInternalR:" + i);
        return i;
    }

    public final boolean getMChecked() {
        return this.f7944a;
    }

    public final int[] h(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "v1");
        int[] iArr = new int[0];
        try {
            Field declaredField = Class.forName("com.android.internal.R$" + str).getDeclaredField(str2);
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            Object obj = declaredField.get((Object) null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
            iArr = (int[]) obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("MINE", "getInternalRS:" + iArr);
        return iArr;
    }

    public final boolean j() {
        return this.f7944a;
    }

    public final void k() {
        if (!j()) {
            setChecked(!this.f7944a);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        setSelected(this.f7944a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("MINE", "MotionEvent:" + motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                return super.onTouchEvent(motionEvent);
            }
            performClick();
        }
        return true;
    }

    public boolean performClick() {
        k();
        boolean performClick = super.performClick();
        if (!performClick) {
            playSoundEffect(0);
        }
        return performClick;
    }

    public final void setChecked(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("MINE", "setChecked:" + z);
        if (this.f7944a != z) {
            this.f7944a = z;
            setSelected(z);
            refreshDrawableState();
            OnCheckedChangeListener onCheckedChangeListener = this.b;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.a(this, this.f7944a);
            }
            OnCheckedChangeListener onCheckedChangeListener2 = this.c;
            if (onCheckedChangeListener2 != null) {
                onCheckedChangeListener2.a(this, this.f7944a);
            }
        }
    }

    public final void setMChecked(boolean z) {
        this.f7944a = z;
    }

    public final void setOnCheckedChangeListener(@NotNull OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = onCheckedChangeListener;
    }

    public final void setOnCheckedChangeWidgetListener(@Nullable OnCheckedChangeListener onCheckedChangeListener) {
        this.c = onCheckedChangeListener;
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            childAt.setSelected(z);
        }
    }
}
