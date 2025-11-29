package com.upuphone.xr.sapp.ability;

import android.app.Activity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.UserGuideAuthResult;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PhoneSappAbility$requestPermission$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<Activity> $list;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneSappAbility$requestPermission$1$1(List<Activity> list) {
        super(0);
        this.$list = list;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(UserGuideAuthResult userGuideAuthResult) {
        Intrinsics.checkNotNullParameter(userGuideAuthResult, "result");
        ULog.f6446a.c("PhoneSappAbility", "user guide agree dismiss tips");
        if (userGuideAuthResult.a() == 1 && userGuideAuthResult.b()) {
            TipsManager.f7827a.d(TipsKey.TIPS_PRIVACY_AI);
        }
    }

    public final void invoke() {
        Activity activity;
        List<Activity> list = this.$list;
        if (list != null && (activity = (Activity) CollectionsKt.firstOrNull(list)) != null) {
            ContractEntry.f6691a.x(activity, 1, new a());
        }
    }
}
