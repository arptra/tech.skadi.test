package com.xjsd.ai.assistant.skill.call;

import com.xjsd.ai.assistant.skill.call.util.CallType;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneCallFlowFor618Strategy f8673a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ CallType d;

    public /* synthetic */ a(PhoneCallFlowFor618Strategy phoneCallFlowFor618Strategy, int i, String str, CallType callType) {
        this.f8673a = phoneCallFlowFor618Strategy;
        this.b = i;
        this.c = str;
        this.d = callType;
    }

    public final void run() {
        PhoneCallFlowFor618Strategy$chooseChannelToDialFlow$callAction$1.invoke$lambda$0(this.f8673a, this.b, this.c, this.d);
    }
}
