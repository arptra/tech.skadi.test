package com.xjsd.ai.assistant.skill.call;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneCallFlowForSpringOldStrategy f8674a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(PhoneCallFlowForSpringOldStrategy phoneCallFlowForSpringOldStrategy, int i, String str) {
        this.f8674a = phoneCallFlowForSpringOldStrategy;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        PhoneCallFlowForSpringOldStrategy$chooseChannelToDialFlow$callAction$1.invoke$lambda$0(this.f8674a, this.b, this.c);
    }
}
