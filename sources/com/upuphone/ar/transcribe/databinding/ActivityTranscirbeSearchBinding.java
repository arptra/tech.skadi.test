package com.upuphone.ar.transcribe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.transcribe.R;

public final class ActivityTranscirbeSearchBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f6031a;
    public final Group b;
    public final TextView c;
    public final ImageView d;
    public final TextView e;
    public final RecyclerView f;
    public final EditText g;

    public ActivityTranscirbeSearchBinding(ConstraintLayout constraintLayout, Group group, TextView textView, ImageView imageView, TextView textView2, RecyclerView recyclerView, EditText editText) {
        this.f6031a = constraintLayout;
        this.b = group;
        this.c = textView;
        this.d = imageView;
        this.e = textView2;
        this.f = recyclerView;
        this.g = editText;
    }

    public static ActivityTranscirbeSearchBinding a(View view) {
        int i = R.id.empty_container;
        Group group = (Group) ViewBindings.a(view, i);
        if (group != null) {
            i = R.id.search_cancel_tv;
            TextView textView = (TextView) ViewBindings.a(view, i);
            if (textView != null) {
                i = R.id.search_empty_icon;
                ImageView imageView = (ImageView) ViewBindings.a(view, i);
                if (imageView != null) {
                    i = R.id.search_empty_tips;
                    TextView textView2 = (TextView) ViewBindings.a(view, i);
                    if (textView2 != null) {
                        i = R.id.search_list;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i);
                        if (recyclerView != null) {
                            i = R.id.search_tv;
                            EditText editText = (EditText) ViewBindings.a(view, i);
                            if (editText != null) {
                                return new ActivityTranscirbeSearchBinding((ConstraintLayout) view, group, textView, imageView, textView2, recyclerView, editText);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityTranscirbeSearchBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTranscirbeSearchBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_transcirbe_search, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f6031a;
    }
}
