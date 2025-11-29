package com.upuphone.ar.tici.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;
import com.upuphone.xr.sapp.widget.CommonNetErrorView;

public final class TiciFileTipsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f5862a;
    public final CommonNetErrorView b;
    public final TiciTitleBar c;
    public final WebView d;

    public TiciFileTipsBinding(ConstraintLayout constraintLayout, CommonNetErrorView commonNetErrorView, TiciTitleBar ticiTitleBar, WebView webView) {
        this.f5862a = constraintLayout;
        this.b = commonNetErrorView;
        this.c = ticiTitleBar;
        this.d = webView;
    }

    public static TiciFileTipsBinding a(View view) {
        int i = R.id.coommon_error;
        CommonNetErrorView commonNetErrorView = (CommonNetErrorView) ViewBindings.a(view, i);
        if (commonNetErrorView != null) {
            i = R.id.title_bar;
            TiciTitleBar ticiTitleBar = (TiciTitleBar) ViewBindings.a(view, i);
            if (ticiTitleBar != null) {
                i = R.id.web_view;
                WebView webView = (WebView) ViewBindings.a(view, i);
                if (webView != null) {
                    return new TiciFileTipsBinding((ConstraintLayout) view, commonNetErrorView, ticiTitleBar, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TiciFileTipsBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static TiciFileTipsBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.tici_file_tips, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f5862a;
    }
}
