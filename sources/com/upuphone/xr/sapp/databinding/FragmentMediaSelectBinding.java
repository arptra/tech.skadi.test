package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.upuphone.xr.sapp.R;

public final class FragmentMediaSelectBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f6803a;
    public final TextView b;
    public final TextView c;
    public final RecyclerPreloadView d;
    public final RelativeLayout e;

    public FragmentMediaSelectBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, RecyclerPreloadView recyclerPreloadView, RelativeLayout relativeLayout2) {
        this.f6803a = relativeLayout;
        this.b = textView;
        this.c = textView2;
        this.d = recyclerPreloadView;
        this.e = relativeLayout2;
    }

    public static FragmentMediaSelectBinding a(View view) {
        int i = R.id.feedback_back_select;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.feedback_back_title;
            TextView textView2 = (TextView) ViewBindings.a(view, i);
            if (textView2 != null) {
                i = R.id.recycler;
                RecyclerPreloadView recyclerPreloadView = (RecyclerPreloadView) ViewBindings.a(view, i);
                if (recyclerPreloadView != null) {
                    i = R.id.titlebar_layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.a(view, i);
                    if (relativeLayout != null) {
                        return new FragmentMediaSelectBinding((RelativeLayout) view, textView, textView2, recyclerPreloadView, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMediaSelectBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_media_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f6803a;
    }
}
