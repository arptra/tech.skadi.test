package com.meizu.flyme.policy.sdk;

import android.content.Context;
import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;

public final /* synthetic */ class h implements PolicySdk.PolicySdkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3206a;
    public final /* synthetic */ String b;

    public /* synthetic */ h(Context context, String str) {
        this.f3206a = context;
        this.b = str;
    }

    public final void getResult(PolicySdkResultBean policySdkResultBean) {
        PolicyManager.m2setOnlinePolicyVersion$lambda2(this.f3206a, this.b, policySdkResultBean);
    }
}
