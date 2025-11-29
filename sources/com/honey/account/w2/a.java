package com.honey.account.w2;

import android.content.Context;
import com.meizu.flyme.policy.sdk.PolicySdk;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import com.meizu.flyme.policy.sdk.util.PolicySdkFileUtils;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements PolicySdk.PolicySdkCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3134a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ Ref.ObjectRef d;

    public /* synthetic */ a(Context context, String str, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.f3134a = context;
        this.b = str;
        this.c = objectRef;
        this.d = objectRef2;
    }

    public final void getResult(PolicySdkResultBean policySdkResultBean) {
        PolicySdkFileUtils.Companion.m8saveOtherAreaPolicyByUrl$lambda0(this.f3134a, this.b, this.c, this.d, policySdkResultBean);
    }
}
