package com.upuphone.xr.sapp.dialog;

import com.upuphone.xr.sapp.databinding.DialogEditScheduleBinding;
import com.upuphone.xr.sapp.view.DrawableEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/dialog/EditScheduleDialog$initView$2$1", "Lcom/upuphone/xr/sapp/view/DrawableEditText$OnDrawableClickListener;", "", "direction", "Lcom/upuphone/xr/sapp/view/DrawableEditText;", "editText", "", "a", "(ILcom/upuphone/xr/sapp/view/DrawableEditText;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class EditScheduleDialog$initView$2$1 implements DrawableEditText.OnDrawableClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditScheduleDialog f6935a;

    public EditScheduleDialog$initView$2$1(EditScheduleDialog editScheduleDialog) {
        this.f6935a = editScheduleDialog;
    }

    public void a(int i, DrawableEditText drawableEditText) {
        Intrinsics.checkNotNullParameter(drawableEditText, "editText");
        DialogEditScheduleBinding l0 = this.f6935a.f6934a;
        if (l0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            l0 = null;
        }
        l0.b.setText("");
    }
}
