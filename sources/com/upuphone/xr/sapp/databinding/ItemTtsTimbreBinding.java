package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class ItemTtsTimbreBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6856a;
    public final CheckBox b;
    public final ImageView c;
    public final ImageView d;
    public final TextView e;
    public final TextView f;

    public ItemTtsTimbreBinding(ConstraintLayout constraintLayout, CheckBox checkBox, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.f6856a = constraintLayout;
        this.b = checkBox;
        this.c = imageView;
        this.d = imageView2;
        this.e = textView;
        this.f = textView2;
    }

    public static ItemTtsTimbreBinding a(View view) {
        int i = R.id.cb_state;
        CheckBox checkBox = (CheckBox) ViewBindings.a(view, i);
        if (checkBox != null) {
            i = R.id.iv_logo;
            ImageView imageView = (ImageView) ViewBindings.a(view, i);
            if (imageView != null) {
                i = R.id.iv_play;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i);
                if (imageView2 != null) {
                    i = R.id.tv_subtitle;
                    TextView textView = (TextView) ViewBindings.a(view, i);
                    if (textView != null) {
                        i = R.id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.a(view, i);
                        if (textView2 != null) {
                            return new ItemTtsTimbreBinding((ConstraintLayout) view, checkBox, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemTtsTimbreBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_tts_timbre, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6856a;
    }
}
