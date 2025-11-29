package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;

public final class BubbleWidgetLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5860a;
    public final TextView b;
    public final ImageView c;
    public final ImageView d;

    public BubbleWidgetLayoutBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2) {
        this.f5860a = constraintLayout;
        this.b = textView;
        this.c = imageView;
        this.d = imageView2;
    }

    public static BubbleWidgetLayoutBinding a(View view) {
        int i = R.id.bubble_content;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.bubble_line;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.close_btn;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
                if (imageView2 != null) {
                    return new BubbleWidgetLayoutBinding((ConstraintLayout) view, textView, imageView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static BubbleWidgetLayoutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bubble_widget_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5860a;
    }
}
