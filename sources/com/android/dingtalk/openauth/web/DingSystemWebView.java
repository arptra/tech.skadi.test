package com.android.dingtalk.openauth.web;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DingSystemWebView extends WebView {
    public DingSystemWebView(Context context) {
        super(context);
    }

    public void destroy() {
        try {
            setVisibility(8);
            stopLoading();
            WebSettings settings = getSettings();
            settings.setSupportZoom(false);
            settings.setDisplayZoomControls(false);
            settings.setRenderPriority(WebSettings.RenderPriority.LOW);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            removeAllViews();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.destroy();
    }

    public DingSystemWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DingSystemWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public DingSystemWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
