package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.xr.sapp.view.CustomRadioButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0004;<=>B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0015\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\n2\b\b\u0001\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J#\u0010%\u001a\u00020\n2\b\b\u0001\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u001f\u0010(\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0018H\u0002¢\u0006\u0004\b(\u0010\u001bR\u0018\u0010+\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00105\u001a\u000602R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00109\u001a\u000606R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006?"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomRadioGroup;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "listener", "", "setOnHierarchyChangeListener", "(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V", "onFinishInflate", "()V", "Landroid/view/View;", "child", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "id", "", "needNotify", "l", "(IZ)V", "getCheckedRadioButtonId", "()I", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup$OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lcom/upuphone/xr/sapp/view/CustomRadioGroup$OnCheckedChangeListener;)V", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "m", "viewId", "checked", "o", "a", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup$OnCheckedChangeListener;", "mOnCheckedChangeListener", "b", "Z", "mProtectFromCheckedChange", "c", "I", "mCheckedId", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup$PassThroughHierarchyChangeListener;", "d", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup$PassThroughHierarchyChangeListener;", "mPassThroughListener", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup$CheckedStateTracker;", "e", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup$CheckedStateTracker;", "mChildOnCheckedChangeListener", "f", "CheckedStateTracker", "Companion", "OnCheckedChangeListener", "PassThroughHierarchyChangeListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class CustomRadioGroup extends ConstraintLayout {
    public static final Companion f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public OnCheckedChangeListener f7945a;
    public boolean b;
    public int c = -1;
    public PassThroughHierarchyChangeListener d;
    public CheckedStateTracker e = new CheckedStateTracker();

    @SourceDebugExtension({"SMAP\nCustomRadioGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomRadioGroup.kt\ncom/upuphone/xr/sapp/view/CustomRadioGroup$CheckedStateTracker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,231:1\n1#2:232\n*E\n"})
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomRadioGroup$CheckedStateTracker;", "Lcom/upuphone/xr/sapp/view/CustomRadioButton$OnCheckedChangeListener;", "<init>", "(Lcom/upuphone/xr/sapp/view/CustomRadioGroup;)V", "Landroid/view/View;", "buttonView", "", "isChecked", "", "a", "(Landroid/view/View;Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class CheckedStateTracker implements CustomRadioButton.OnCheckedChangeListener {
        public CheckedStateTracker() {
        }

        public void a(View view, boolean z) {
            if (z && !CustomRadioGroup.this.b) {
                CustomRadioGroup.this.b = true;
                if (CustomRadioGroup.this.c != -1) {
                    CustomRadioGroup customRadioGroup = CustomRadioGroup.this;
                    customRadioGroup.o(customRadioGroup.c, false);
                }
                CustomRadioGroup.this.b = false;
                if (view != null) {
                    CustomRadioGroup.n(CustomRadioGroup.this, view.getId(), false, 2, (Object) null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomRadioGroup$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomRadioGroup$OnCheckedChangeListener;", "", "Lcom/upuphone/xr/sapp/view/CustomRadioGroup;", "group", "", "checkedId", "", "a", "(Lcom/upuphone/xr/sapp/view/CustomRadioGroup;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnCheckedChangeListener {
        void a(CustomRadioGroup customRadioGroup, int i);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000b\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/view/CustomRadioGroup$PassThroughHierarchyChangeListener;", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "<init>", "(Lcom/upuphone/xr/sapp/view/CustomRadioGroup;)V", "Landroid/view/View;", "parent", "child", "", "onChildViewAdded", "(Landroid/view/View;Landroid/view/View;)V", "onChildViewRemoved", "a", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "getMOnHierarchyChangeListener", "()Landroid/view/ViewGroup$OnHierarchyChangeListener;", "(Landroid/view/ViewGroup$OnHierarchyChangeListener;)V", "mOnHierarchyChangeListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f7947a;

        public PassThroughHierarchyChangeListener() {
        }

        public final void a(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
            this.f7947a = onHierarchyChangeListener;
        }

        public void onChildViewAdded(View view, View view2) {
            Intrinsics.checkNotNullParameter(view, "parent");
            Intrinsics.checkNotNullParameter(view2, "child");
            if (view == CustomRadioGroup.this && (view2 instanceof CustomRadioButton)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((CustomRadioButton) view2).setOnCheckedChangeWidgetListener(CustomRadioGroup.this.e);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f7947a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            Intrinsics.checkNotNullParameter(view, "parent");
            Intrinsics.checkNotNullParameter(view2, "child");
            if (view == CustomRadioGroup.this && (view2 instanceof CustomRadioButton)) {
                ((CustomRadioButton) view2).setOnCheckedChangeWidgetListener((CustomRadioButton.OnCheckedChangeListener) null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f7947a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomRadioGroup(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.d = passThroughHierarchyChangeListener;
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
    }

    public static /* synthetic */ void n(CustomRadioGroup customRadioGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        customRadioGroup.m(i, z);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof CustomRadioButton) {
            CustomRadioButton customRadioButton = (CustomRadioButton) view;
            if (customRadioButton.j()) {
                this.b = true;
                int i2 = this.c;
                if (i2 != -1) {
                    o(i2, false);
                }
                this.b = false;
                this.c = customRadioButton.getId();
            }
        }
        super.addView(view, i, layoutParams);
    }

    @IdRes
    public final int getCheckedRadioButtonId() {
        return this.c;
    }

    public final void l(int i, boolean z) {
        if (i == -1 || i != this.c) {
            int i2 = this.c;
            if (i2 != -1) {
                o(i2, false);
            }
            if (i != -1) {
                o(i, true);
            }
            m(i, z);
        }
    }

    public final void m(int i, boolean z) {
        OnCheckedChangeListener onCheckedChangeListener;
        this.c = i;
        if (z && (onCheckedChangeListener = this.f7945a) != null) {
            onCheckedChangeListener.a(this, i);
        }
    }

    public final void o(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof CustomRadioButton)) {
            ((CustomRadioButton) findViewById).setChecked(z);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.c;
        if (i != -1) {
            this.b = true;
            o(i, true);
            this.b = false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setOnCheckedChangeListener(@NotNull OnCheckedChangeListener onCheckedChangeListener) {
        Intrinsics.checkNotNullParameter(onCheckedChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f7945a = onCheckedChangeListener;
    }

    public void setOnHierarchyChangeListener(@NotNull ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        Intrinsics.checkNotNullParameter(onHierarchyChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.a(onHierarchyChangeListener);
    }
}
