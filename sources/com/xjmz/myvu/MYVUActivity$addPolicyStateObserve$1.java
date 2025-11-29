package com.xjmz.myvu;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.entity.ResPolicyData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/ResPolicyData;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$addPolicyStateObserve$1 extends Lambda implements Function1<ResPolicyData, Unit> {
    public static final MYVUActivity$addPolicyStateObserve$1 INSTANCE = new MYVUActivity$addPolicyStateObserve$1();

    public MYVUActivity$addPolicyStateObserve$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ResPolicyData) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ResPolicyData resPolicyData) {
        ResPolicyData.Data data;
        if (resPolicyData != null && (data = resPolicyData.getData()) != null && data.getState() == 1) {
            String pp = resPolicyData.getData().getPp();
            if (Intrinsics.areEqual((Object) pp, (Object) "myvu_pp")) {
                ULog.f6446a.a("MYVUActivity", "addPolicyStateObserve::VALUE_MYVU_PP");
                MainApplication.k.f().p();
            } else if (Intrinsics.areEqual((Object) pp, (Object) "glass_pp")) {
                ULog.f6446a.a("MYVUActivity", "addPolicyStateObserve::VALUE_GLASS_PP");
            }
        }
    }
}
