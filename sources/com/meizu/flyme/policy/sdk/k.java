package com.meizu.flyme.policy.sdk;

import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class k implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PolicySdk.PolicySdkCallback f3209a;

    public /* synthetic */ k(PolicySdk.PolicySdkCallback policySdkCallback) {
        this.f3209a = policySdkCallback;
    }

    public final Object invoke(Object obj) {
        return this.f3209a.getResult((PolicySdkResultBean) obj);
    }
}
