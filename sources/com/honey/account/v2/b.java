package com.honey.account.v2;

import android.view.View;
import com.meizu.flyme.policy.sdk.activity.PolicyWebViewActivity;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PolicyWebViewActivity f3128a;

    public /* synthetic */ b(PolicyWebViewActivity policyWebViewActivity) {
        this.f3128a = policyWebViewActivity;
    }

    public final void onClick(View view) {
        PolicyWebViewActivity.m5showNetWorkErrorView$lambda4(this.f3128a, view);
    }
}
