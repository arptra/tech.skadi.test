package com.upuphone.starrynet.common;

import com.upuphone.starrynet.common.ReLog;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReLog.ReLogBean f6526a;

    public /* synthetic */ a(ReLog.ReLogBean reLogBean) {
        this.f6526a = reLogBean;
    }

    public final void run() {
        ReLog.lambda$outputLogIfNeed$0(this.f6526a);
    }
}
