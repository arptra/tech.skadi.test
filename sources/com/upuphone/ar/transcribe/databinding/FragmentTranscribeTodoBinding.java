package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.view.TransLoadingView;

public final class FragmentTranscribeTodoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6039a;
    public final Group b;
    public final Group c;
    public final ImageView d;
    public final TransLoadingView e;
    public final MzButton f;
    public final RecyclerView g;
    public final ConstraintLayout h;
    public final TextView i;
    public final TextView j;

    public FragmentTranscribeTodoBinding(ConstraintLayout constraintLayout, Group group, Group group2, ImageView imageView, TransLoadingView transLoadingView, MzButton mzButton, RecyclerView recyclerView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.f6039a = constraintLayout;
        this.b = group;
        this.c = group2;
        this.d = imageView;
        this.e = transLoadingView;
        this.f = mzButton;
        this.g = recyclerView;
        this.h = constraintLayout2;
        this.i = textView;
        this.j = textView2;
    }

    public static FragmentTranscribeTodoBinding a(View view) {
        int i2 = R.id.gp_loading;
        Group group = (Group) ViewBindings.a(view, i2);
        if (group != null) {
            i2 = R.id.gp_todo_tip;
            Group group2 = (Group) ViewBindings.a(view, i2);
            if (group2 != null) {
                i2 = R.id.iv_todo_bg;
                ImageView imageView = (ImageView) ViewBindings.a(view, i2);
                if (imageView != null) {
                    i2 = R.id.loading_view;
                    TransLoadingView transLoadingView = (TransLoadingView) ViewBindings.a(view, i2);
                    if (transLoadingView != null) {
                        i2 = R.id.mbt_todo;
                        MzButton mzButton = (MzButton) ViewBindings.a(view, i2);
                        if (mzButton != null) {
                            i2 = R.id.rv_todo;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i2);
                            if (recyclerView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                i2 = R.id.tv_loading_tips;
                                TextView textView = (TextView) ViewBindings.a(view, i2);
                                if (textView != null) {
                                    i2 = R.id.tv_todo_tip;
                                    TextView textView2 = (TextView) ViewBindings.a(view, i2);
                                    if (textView2 != null) {
                                        return new FragmentTranscribeTodoBinding(constraintLayout, group, group2, imageView, transLoadingView, mzButton, recyclerView, constraintLayout, textView, textView2);
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

    public static FragmentTranscribeTodoBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentTranscribeTodoBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_transcribe_todo, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6039a;
    }
}
