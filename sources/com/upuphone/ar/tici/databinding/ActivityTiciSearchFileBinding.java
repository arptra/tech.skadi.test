package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;

public final class ActivityTiciSearchFileBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5859a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final EditText e;
    public final RecyclerView f;
    public final ImageView g;
    public final ImageView h;
    public final LinearLayout i;
    public final ConstraintLayout j;
    public final LinearLayout k;
    public final LinearLayout l;
    public final TextView m;

    public ActivityTiciSearchFileBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, EditText editText, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView4) {
        this.f5859a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = editText;
        this.f = recyclerView;
        this.g = imageView;
        this.h = imageView2;
        this.i = linearLayout;
        this.j = constraintLayout2;
        this.k = linearLayout2;
        this.l = linearLayout3;
        this.m = textView4;
    }

    public static ActivityTiciSearchFileBinding a(View view) {
        View view2 = view;
        int i2 = R.id.btn_file_all;
        TextView textView = (TextView) ViewBindings.a(view2, i2);
        if (textView != null) {
            i2 = R.id.btn_file_txt;
            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
            if (textView2 != null) {
                i2 = R.id.btn_file_word;
                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                if (textView3 != null) {
                    i2 = R.id.et_search;
                    EditText editText = (EditText) ViewBindings.a(view2, i2);
                    if (editText != null) {
                        i2 = R.id.files_recyclerview;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view2, i2);
                        if (recyclerView != null) {
                            i2 = R.id.iv_search;
                            ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
                            if (imageView != null) {
                                i2 = R.id.iv_search_delete;
                                ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
                                if (imageView2 != null) {
                                    i2 = R.id.lay_no_search_result;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                                    if (linearLayout != null) {
                                        i2 = R.id.lay_search;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                        if (constraintLayout != null) {
                                            i2 = R.id.lay_search_btn_group;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                                            if (linearLayout2 != null) {
                                                i2 = R.id.lay_search_input;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.a(view2, i2);
                                                if (linearLayout3 != null) {
                                                    i2 = R.id.tv_cancel;
                                                    TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                                    if (textView4 != null) {
                                                        return new ActivityTiciSearchFileBinding((ConstraintLayout) view2, textView, textView2, textView3, editText, recyclerView, imageView, imageView2, linearLayout, constraintLayout, linearLayout2, linearLayout3, textView4);
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

    public static ActivityTiciSearchFileBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTiciSearchFileBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_tici_search_file, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5859a;
    }
}
