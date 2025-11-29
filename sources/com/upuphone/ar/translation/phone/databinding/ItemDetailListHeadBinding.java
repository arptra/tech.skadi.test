package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;

public final class ItemDetailListHeadBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6249a;
    public final ClipboardEditText b;
    public final TextView c;

    public ItemDetailListHeadBinding(ConstraintLayout constraintLayout, ClipboardEditText clipboardEditText, TextView textView) {
        this.f6249a = constraintLayout;
        this.b = clipboardEditText;
        this.c = textView;
    }

    public static ItemDetailListHeadBinding a(View view) {
        int i = R.id.et_record_title;
        ClipboardEditText clipboardEditText = (ClipboardEditText) ViewBindings.a(view, i);
        if (clipboardEditText != null) {
            i = R.id.tv_record_subtitle;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                return new ItemDetailListHeadBinding((ConstraintLayout) view, clipboardEditText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemDetailListHeadBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemDetailListHeadBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_detail_list_head, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6249a;
    }
}
