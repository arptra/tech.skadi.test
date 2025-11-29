package com.xjsd.ai.assistant.skill.call;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneCallFlowForSpringStrategy f8675a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ c(PhoneCallFlowForSpringStrategy phoneCallFlowForSpringStrategy, int i, String str) {
        this.f8675a = phoneCallFlowForSpringStrategy;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        PhoneCallFlowForSpringStrategy$chooseChannelToDialFlow$1$callAction$1.invoke$lambda$0(this.f8675a, this.b, this.c);
    }
}
