package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/view/SelectionWatcherEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selStart", "selEnd", "", "onSelectionChanged", "(II)V", "Lcom/upuphone/xr/sapp/view/SelectionWatcherEditText$OnSelectionChangedListener;", "a", "Lcom/upuphone/xr/sapp/view/SelectionWatcherEditText$OnSelectionChangedListener;", "getOnSelectionChangedListener", "()Lcom/upuphone/xr/sapp/view/SelectionWatcherEditText$OnSelectionChangedListener;", "setOnSelectionChangedListener", "(Lcom/upuphone/xr/sapp/view/SelectionWatcherEditText$OnSelectionChangedListener;)V", "onSelectionChangedListener", "OnSelectionChangedListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public class SelectionWatcherEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    public OnSelectionChangedListener f7984a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/view/SelectionWatcherEditText$OnSelectionChangedListener;", "", "", "selStart", "selEnd", "", "a", "(II)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnSelectionChangedListener {
        void a(int i, int i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectionWatcherEditText(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Nullable
    public final OnSelectionChangedListener getOnSelectionChangedListener() {
        return this.f7984a;
    }

    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        OnSelectionChangedListener onSelectionChangedListener = this.f7984a;
        if (onSelectionChangedListener != null) {
            onSelectionChangedListener.a(i, i2);
        }
    }

    public final void setOnSelectionChangedListener(@Nullable OnSelectionChangedListener onSelectionChangedListener) {
        this.f7984a = onSelectionChangedListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectionWatcherEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectionWatcherEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SelectionWatcherEditText(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
