package com.meizu.flyme.policy.sdk;

import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class l implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f3210a;

    public /* synthetic */ l(PolicySdk.PolicySdkCallback policySdkCallback) {
        this.f3210a = policySdkCallback;
    }

    public final Object invoke(Object obj) {
        return this.f3210a.getResult((PolicySdkResultBean) obj);
    }
}
