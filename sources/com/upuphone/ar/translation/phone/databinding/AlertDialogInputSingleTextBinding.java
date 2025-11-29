package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.translation.phone.R;

public final class AlertDialogInputSingleTextBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6242a;
    public final EditText b;
    public final ImageView c;
    public final View d;

    public AlertDialogInputSingleTextBinding(ConstraintLayout constraintLayout, EditText editText, ImageView imageView, View view) {
        this.f6242a = constraintLayout;
        this.b = editText;
        this.c = imageView;
        this.d = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.upuphone.ar.translation.phone.R.id.v_input_bg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.translation.phone.databinding.AlertDialogInputSingleTextBinding a(android.view.View r4) {
        /*
            int r0 = com.upuphone.ar.translation.phone.R.id.et_input_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r4, r0)
            android.widget.EditText r1 = (android.widget.EditText) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.upuphone.ar.translation.phone.R.id.iv_input_del
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r4, r0)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            if (r2 == 0) goto L_0x0024
            int r0 = com.upuphone.ar.translation.phone.R.id.v_input_bg
            android.view.View r3 = androidx.viewbinding.ViewBindings.a(r4, r0)
            if (r3 == 0) goto L_0x0024
            com.upuphone.ar.translation.phone.databinding.AlertDialogInputSingleTextBinding r0 = new com.upuphone.ar.translation.phone.databinding.AlertDialogInputSingleTextBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0024:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.databinding.AlertDialogInputSingleTextBinding.a(android.view.View):com.upuphone.ar.translation.phone.databinding.AlertDialogInputSingleTextBinding");
    }

    public static AlertDialogInputSingleTextBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static AlertDialogInputSingleTextBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.alert_dialog_input_single_text, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6242a;
    }
}
