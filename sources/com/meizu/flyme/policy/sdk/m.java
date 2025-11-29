package com.meizu.flyme.policy.sdk;

import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class m implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f3211a;

    public /* synthetic */ m(PolicySdk.PolicySdkCallback policySdkCallback) {
        this.f3211a = policySdkCallback;
    }

    public final Object invoke(Object obj) {
        return PolicySdk.lambda$getPolicy$5(this.f3211a, (PolicySdkResultBean) obj);
    }
}
