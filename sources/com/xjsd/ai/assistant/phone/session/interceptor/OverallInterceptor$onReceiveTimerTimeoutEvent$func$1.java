package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.WakeupControlDelegate;
import com.xjsd.ai.assistant.phone.helper.VrStateSynchronizer;
import com.xjsd.ai.assistant.protocol.wakeup.WakeupControl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class OverallInterceptor$onReceiveTimerTimeoutEvent$func$1 extends Lambda implements Function0<Unit> {
    public static final OverallInterceptor$onReceiveTimerTimeoutEvent$func$1 INSTANCE = new OverallInterceptor$onReceiveTimerTimeoutEvent$func$1();

    public OverallInterceptor$onReceiveTimerTimeoutEvent$func$1() {
        super(0);
    }

    public final void invoke() {
        VrStateSynchronizer.b(0);
        WakeupControlDelegate.g.i(new WakeupControl(0));
    }
}
