package com.meizu.flyme.policy.sdk;

import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class n implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f3212a;

    public /* synthetic */ n(PolicySdk.PolicySdkCallback policySdkCallback) {
        this.f3212a = policySdkCallback;
    }

    public final Object invoke(Object obj) {
        return this.f3212a.getResult((PolicySdkResultBean) obj);
    }
}
