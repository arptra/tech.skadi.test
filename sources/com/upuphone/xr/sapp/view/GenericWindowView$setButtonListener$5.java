package com.upuphone.xr.sapp.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/upuphone/xr/sapp/view/GenericWindowView$setButtonListener$5", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GenericWindowView$setButtonListener$5 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7965a;
    public final /* synthetic */ int b;

    public GenericWindowView$setButtonListener$5(GenericWindowView genericWindowView, int i) {
        this.f7965a = genericWindowView;
        this.b = i;
    }

    public void afterTextChanged(Editable editable) {
        if (editable == null || editable.length() == 0) {
            this.f7965a.d.f.setEnabled(false);
            GenericWindowView genericWindowView = this.f7965a;
            DrawableEditText drawableEditText = genericWindowView.d.w;
            Intrinsics.checkNotNullExpressionValue(drawableEditText, "editInput");
            genericWindowView.S(drawableEditText, false);
        } else if (editable.length() > 0) {
            this.f7965a.d.f.setEnabled(true);
            GenericWindowView genericWindowView2 = this.f7965a;
            DrawableEditText drawableEditText2 = genericWindowView2.d.w;
            Intrinsics.checkNotNullExpressionValue(drawableEditText2, "editInput");
            genericWindowView2.S(drawableEditText2, true);
            int i = this.b;
            if (i == 10001 || i == 10002) {
                this.f7965a.T(editable.toString(), 30);
            }
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("jesson", "s.toString() is: " + editable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("jesson", "onTextChanged is: " + charSequence);
    }
}
