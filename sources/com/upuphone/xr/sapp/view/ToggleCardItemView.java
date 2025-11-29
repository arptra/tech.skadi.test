package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.util.AttributeSet;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/view/ToggleCardItemView;", "Lcom/upuphone/xr/sapp/view/CardItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setStartIconState", "", "state", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ToggleCardItemView extends CardItemView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleCardItemView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    public void setStartIconState(boolean z) {
        super.setStartIconState(z);
        if (z) {
            getBinding().j.setText(GlobalExtKt.h(R.string.permission_setted));
        } else {
            getBinding().j.setText(GlobalExtKt.h(R.string.goto_set_permission));
        }
    }
}
