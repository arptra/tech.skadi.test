package com.upuphone.xr.sapp.monitor.notification;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.AccountInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "account", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SuperNotificationManager$initManager$1 extends Lambda implements Function1<AccountInfo, Unit> {
    public static final SuperNotificationManager$initManager$1 INSTANCE = new SuperNotificationManager$initManager$1();

    public SuperNotificationManager$initManager$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AccountInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable AccountInfo accountInfo) {
        ULog.Delegate delegate = ULog.f6446a;
        String id = accountInfo != null ? accountInfo.getId() : null;
        delegate.a("SuperNotificationManager", "user account change:" + id);
        SuperNotificationManager.f7749a.x();
    }
}
