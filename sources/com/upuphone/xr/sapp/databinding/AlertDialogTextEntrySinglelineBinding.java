package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzEditInputView;
import com.upuphone.xr.sapp.R;

public final class AlertDialogTextEntrySinglelineBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6732a;
    public final MzEditInputView b;

    public AlertDialogTextEntrySinglelineBinding(LinearLayout linearLayout, MzEditInputView mzEditInputView) {
        this.f6732a = linearLayout;
        this.b = mzEditInputView;
    }

    public static AlertDialogTextEntrySinglelineBinding a(View view) {
        int i = R.id.input_view;
        MzEditInputView mzEditInputView = (MzEditInputView) ViewBindings.a(view, i);
        if (mzEditInputView != null) {
            return new AlertDialogTextEntrySinglelineBinding((LinearLayout) view, mzEditInputView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AlertDialogTextEntrySinglelineBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static AlertDialogTextEntrySinglelineBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.alert_dialog_text_entry_singleline, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6732a;
    }
}
