package com.sina.weibo.sdk;

import android.view.View;
import com.sina.weibo.sdk.web.WebActivity;

public final class j0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebActivity f9988a;

    public j0(WebActivity webActivity) {
        this.f9988a = webActivity;
    }

    public final void onClick(View view) {
        WebActivity webActivity = this.f9988a;
        webActivity.f9998a.setVisibility(8);
        webActivity.d.setVisibility(0);
        this.f9988a.d.reload();
    }
}
