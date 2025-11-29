package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class ActivityTodoManageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6729a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final RecyclerView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final LinearLayout k;
    public final ConstraintLayout l;
    public final ConstraintLayout m;
    public final LinearLayout n;
    public final FrameLayout o;

    public ActivityTodoManageBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, FrameLayout frameLayout) {
        this.f6729a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = imageView3;
        this.e = recyclerView;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = textView5;
        this.k = linearLayout;
        this.l = constraintLayout2;
        this.m = constraintLayout3;
        this.n = linearLayout2;
        this.o = frameLayout;
    }

    public static ActivityTodoManageBinding a(View view) {
        View view2 = view;
        int i2 = R.id.iv_back;
        ImageView imageView = (ImageView) ViewBindings.a(view2, i2);
        if (imageView != null) {
            i2 = R.id.iv_more;
            ImageView imageView2 = (ImageView) ViewBindings.a(view2, i2);
            if (imageView2 != null) {
                i2 = R.id.iv_todo_guide;
                ImageView imageView3 = (ImageView) ViewBindings.a(view2, i2);
                if (imageView3 != null) {
                    i2 = R.id.rv_todo_list;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view2, i2);
                    if (recyclerView != null) {
                        i2 = R.id.tv_select_all;
                        TextView textView = (TextView) ViewBindings.a(view2, i2);
                        if (textView != null) {
                            i2 = R.id.tv_select_cancel;
                            TextView textView2 = (TextView) ViewBindings.a(view2, i2);
                            if (textView2 != null) {
                                i2 = R.id.tv_select_tip;
                                TextView textView3 = (TextView) ViewBindings.a(view2, i2);
                                if (textView3 != null) {
                                    i2 = R.id.tv_title;
                                    TextView textView4 = (TextView) ViewBindings.a(view2, i2);
                                    if (textView4 != null) {
                                        i2 = R.id.tv_todo_guide;
                                        TextView textView5 = (TextView) ViewBindings.a(view2, i2);
                                        if (textView5 != null) {
                                            i2 = R.id.view_delete;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view2, i2);
                                            if (linearLayout != null) {
                                                i2 = R.id.view_empty;
                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                if (constraintLayout != null) {
                                                    i2 = R.id.view_select;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.a(view2, i2);
                                                    if (constraintLayout2 != null) {
                                                        i2 = R.id.view_title;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view2, i2);
                                                        if (linearLayout2 != null) {
                                                            i2 = R.id.view_title_bar;
                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view2, i2);
                                                            if (frameLayout != null) {
                                                                return new ActivityTodoManageBinding((ConstraintLayout) view2, imageView, imageView2, imageView3, recyclerView, textView, textView2, textView3, textView4, textView5, linearLayout, constraintLayout, constraintLayout2, linearLayout2, frameLayout);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    public static ActivityTodoManageBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTodoManageBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_todo_manage, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6729a;
    }
}
