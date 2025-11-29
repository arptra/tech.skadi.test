package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.ScrollTextView;
import com.upuphone.ar.translation.phone.R;

public final class TranslationLangDialogBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6270a;
    public final View b;
    public final ImageView c;
    public final LinearLayout d;
    public final ScrollTextView e;
    public final ScrollTextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;

    public TranslationLangDialogBinding(LinearLayout linearLayout, View view, ImageView imageView, LinearLayout linearLayout2, ScrollTextView scrollTextView, ScrollTextView scrollTextView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f6270a = linearLayout;
        this.b = view;
        this.c = imageView;
        this.d = linearLayout2;
        this.e = scrollTextView;
        this.f = scrollTextView2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = textView5;
        this.l = textView6;
        this.m = textView7;
    }

    public static TranslationLangDialogBinding a(View view) {
        int i2 = R.id.dialogBottom;
        View a2 = ViewBindings.a(view, i2);
        if (a2 != null) {
            i2 = R.id.iv_arrow;
            ImageView imageView = (ImageView) ViewBindings.a(view, i2);
            if (imageView != null) {
                i2 = R.id.ll_setting_content;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                if (linearLayout != null) {
                    i2 = R.id.st_dst_lang;
                    ScrollTextView scrollTextView = (ScrollTextView) ViewBindings.a(view, i2);
                    if (scrollTextView != null) {
                        i2 = R.id.st_src_lang;
                        ScrollTextView scrollTextView2 = (ScrollTextView) ViewBindings.a(view, i2);
                        if (scrollTextView2 != null) {
                            i2 = R.id.tv_cancel;
                            TextView textView = (TextView) ViewBindings.a(view, i2);
                            if (textView != null) {
                                i2 = R.id.tv_dst;
                                TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                if (textView2 != null) {
                                    i2 = R.id.tv_dst_hint;
                                    TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                    if (textView3 != null) {
                                        i2 = R.id.tv_ok;
                                        TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                        if (textView4 != null) {
                                            i2 = R.id.tv_src;
                                            TextView textView5 = (TextView) ViewBindings.a(view, i2);
                                            if (textView5 != null) {
                                                i2 = R.id.tv_src_hint;
                                                TextView textView6 = (TextView) ViewBindings.a(view, i2);
                                                if (textView6 != null) {
                                                    i2 = R.id.tv_title;
                                                    TextView textView7 = (TextView) ViewBindings.a(view, i2);
                                                    if (textView7 != null) {
                                                        return new TranslationLangDialogBinding((LinearLayout) view, a2, imageView, linearLayout, scrollTextView, scrollTextView2, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static TranslationLangDialogBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static TranslationLangDialogBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.translation_lang_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6270a;
    }
}
