package com.upuphone.ar.fastrecord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordBottomCommandLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5580a;
    public final ImageView b;

    public FastRecordBottomCommandLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.f5580a = constraintLayout;
        this.b = imageView;
    }

    public static FastRecordBottomCommandLayoutBinding a(View view) {
        int i = R.id.iv_start_rec;
        ImageView imageView = (ImageView) ViewBindings.a(view, i);
        if (imageView != null) {
            return new FastRecordBottomCommandLayoutBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5580a;
    }
}
