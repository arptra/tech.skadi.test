package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.upuphone.ar.translation.phone.R;

public final class ShareTransRecordMarkBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6260a;
    public final ImageView b;
    public final View c;

    public ShareTransRecordMarkBinding(ConstraintLayout constraintLayout, ImageView imageView, View view) {
        this.f6260a = constraintLayout;
        this.b = imageView;
        this.c = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.upuphone.ar.translation.phone.R.id.v_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.upuphone.ar.translation.phone.databinding.ShareTransRecordMarkBinding a(android.view.View r3) {
        /*
            int r0 = com.upuphone.ar.translation.phone.R.id.iv_share_mark
            android.view.View r1 = androidx.viewbinding.ViewBindings.a(r3, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x001a
            int r0 = com.upuphone.ar.translation.phone.R.id.v_divider
            android.view.View r2 = androidx.viewbinding.ViewBindings.a(r3, r0)
            if (r2 == 0) goto L_0x001a
            com.upuphone.ar.translation.phone.databinding.ShareTransRecordMarkBinding r0 = new com.upuphone.ar.translation.phone.databinding.ShareTransRecordMarkBinding
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r0.<init>(r3, r1, r2)
            return r0
        L_0x001a:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.databinding.ShareTransRecordMarkBinding.a(android.view.View):com.upuphone.ar.translation.phone.databinding.ShareTransRecordMarkBinding");
    }

    public static ShareTransRecordMarkBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ShareTransRecordMarkBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.share_trans_record_mark, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6260a;
    }
}
