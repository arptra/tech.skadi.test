package com.upuphone.xr.sapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.upuphone.xr.sapp.R;

public final class ActivityProtocolBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f6726a;
    public final TextView b;
    public final SwipeRefreshLayout c;
    public final ViewStub d;
    public final WebView e;

    public ActivityProtocolBinding(LinearLayout linearLayout, TextView textView, SwipeRefreshLayout swipeRefreshLayout, ViewStub viewStub, WebView webView) {
        this.f6726a = linearLayout;
        this.b = textView;
        this.c = swipeRefreshLayout;
        this.d = viewStub;
        this.e = webView;
    }

    public static ActivityProtocolBinding a(View view) {
        int i = R.id.back_title;
        TextView textView = (TextView) ViewBindings.a(view, i);
        if (textView != null) {
            i = R.id.refresh_layout;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.a(view, i);
            if (swipeRefreshLayout != null) {
                i = R.id.view_stub_load_fail;
                ViewStub viewStub = (ViewStub) ViewBindings.a(view, i);
                if (viewStub != null) {
                    i = R.id.web_view;
                    WebView webView = (WebView) ViewBindings.a(view, i);
                    if (webView != null) {
                        return new ActivityProtocolBinding((LinearLayout) view, textView, swipeRefreshLayout, viewStub, webView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityProtocolBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityProtocolBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_protocol, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f6726a;
    }
}
