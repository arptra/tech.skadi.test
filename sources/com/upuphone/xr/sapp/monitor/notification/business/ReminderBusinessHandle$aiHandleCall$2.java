package com.upuphone.xr.sapp.monitor.notification.business;

import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.monitor.notification.algorithm.AiHandleDataCall;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/AiHandleDataCall;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ReminderBusinessHandle$aiHandleCall$2 extends Lambda implements Function0<AiHandleDataCall> {
    public static final ReminderBusinessHandle$aiHandleCall$2 INSTANCE = new ReminderBusinessHandle$aiHandleCall$2();

    public ReminderBusinessHandle$aiHandleCall$2() {
        super(0);
    }

    @NotNull
    public final AiHandleDataCall invoke() {
        return new AiHandleDataCall(SdkContext.f6675a.c().getContext());
    }
}
