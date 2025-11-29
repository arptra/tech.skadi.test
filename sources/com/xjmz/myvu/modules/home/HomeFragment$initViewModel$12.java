package com.xjmz.myvu.modules.home;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class HomeFragment$initViewModel$12 extends Lambda implements Function1<Boolean, Unit> {
    public static final HomeFragment$initViewModel$12 INSTANCE = new HomeFragment$initViewModel$12();

    public HomeFragment$initViewModel$12() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Boolean bool) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "aiStateChange: " + bool + " remove TIPS_PRIVACY_AI");
        TipsManager.f7827a.d(TipsKey.TIPS_PRIVACY_AI);
    }
}
