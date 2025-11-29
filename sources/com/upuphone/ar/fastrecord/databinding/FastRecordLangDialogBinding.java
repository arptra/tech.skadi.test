package com.upuphone.ar.fastrecord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.ScrollTextView;
import com.upuphone.ar.fastrecord.R;

public final class FastRecordLangDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f5602a;
    public final View b;
    public final ScrollTextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public FastRecordLangDialogBinding(LinearLayout linearLayout, View view, ScrollTextView scrollTextView, TextView textView, TextView textView2, TextView textView3) {
        this.f5602a = linearLayout;
        this.b = view;
        this.c = scrollTextView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static FastRecordLangDialogBinding a(View view) {
        int i = R.id.dialogBottom;
        View a2 = ViewBindings.a(view, i);
        if (a2 != null) {
            i = R.id.st_lang;
            ScrollTextView scrollTextView = (ScrollTextView) ViewBindings.a(view, i);
            if (scrollTextView != null) {
                i = R.id.tv_cancel;
                TextView textView = (TextView) ViewBindings.a(view, i);
                if (textView != null) {
                    i = R.id.tv_ok;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_title;
                        TextView textView3 = (TextView) ViewBindings.a(view, i);
                        if (textView3 != null) {
                            return new FastRecordLangDialogBinding((LinearLayout) view, a2, scrollTextView, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FastRecordLangDialogBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FastRecordLangDialogBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fast_record_lang_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f5602a;
    }
}
