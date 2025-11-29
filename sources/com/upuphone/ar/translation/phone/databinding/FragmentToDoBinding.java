package com.upuphone.ar.translation.phone.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;

public final class FragmentToDoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6247a;
    public final Group b;
    public final Group c;
    public final ImageView d;
    public final LinearLayout e;
    public final TranslatorLoadingView f;
    public final MzButton g;
    public final RecyclerView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;

    public FragmentToDoBinding(ConstraintLayout constraintLayout, Group group, Group group2, ImageView imageView, LinearLayout linearLayout, TranslatorLoadingView translatorLoadingView, MzButton mzButton, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f6247a = constraintLayout;
        this.b = group;
        this.c = group2;
        this.d = imageView;
        this.e = linearLayout;
        this.f = translatorLoadingView;
        this.g = mzButton;
        this.h = recyclerView;
        this.i = textView;
        this.j = textView2;
        this.k = textView3;
        this.l = textView4;
    }

    public static FragmentToDoBinding a(View view) {
        int i2 = R.id.gp_todo_list;
        Group group = (Group) ViewBindings.a(view, i2);
        if (group != null) {
            i2 = R.id.gp_todo_tip;
            Group group2 = (Group) ViewBindings.a(view, i2);
            if (group2 != null) {
                i2 = R.id.iv_todo_bg;
                ImageView imageView = (ImageView) ViewBindings.a(view, i2);
                if (imageView != null) {
                    i2 = R.id.ll_outer_ai_mark;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i2);
                    if (linearLayout != null) {
                        i2 = R.id.loading_view;
                        TranslatorLoadingView translatorLoadingView = (TranslatorLoadingView) ViewBindings.a(view, i2);
                        if (translatorLoadingView != null) {
                            i2 = R.id.mbt_todo;
                            MzButton mzButton = (MzButton) ViewBindings.a(view, i2);
                            if (mzButton != null) {
                                i2 = R.id.rv_todo;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i2);
                                if (recyclerView != null) {
                                    i2 = R.id.tv_loading_background;
                                    TextView textView = (TextView) ViewBindings.a(view, i2);
                                    if (textView != null) {
                                        i2 = R.id.tv_outer_ai_mark;
                                        TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                        if (textView2 != null) {
                                            i2 = R.id.tv_outer_reported;
                                            TextView textView3 = (TextView) ViewBindings.a(view, i2);
                                            if (textView3 != null) {
                                                i2 = R.id.tv_todo_tip;
                                                TextView textView4 = (TextView) ViewBindings.a(view, i2);
                                                if (textView4 != null) {
                                                    return new FragmentToDoBinding((ConstraintLayout) view, group, group2, imageView, linearLayout, translatorLoadingView, mzButton, recyclerView, textView, textView2, textView3, textView4);
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

    public static FragmentToDoBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentToDoBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_to_do, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6247a;
    }
}
