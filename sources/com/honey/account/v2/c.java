package com.honey.account.v2;

import com.meizu.flyme.policy.sdk.activity.PolicyWebViewActivity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PolicyWebViewActivity f3129a;
    public final /* synthetic */ String b;

    public /* synthetic */ c(PolicyWebViewActivity policyWebViewActivity, String str) {
        this.f3129a = policyWebViewActivity;
        this.b = str;
    }

    public final void run() {
        PolicyWebViewActivity.m7webViewLoadData$lambda8(this.f3129a, this.b);
    }
}
