package com.honey.account.b6;

import com.upuphone.runasone.core.api.sys.SysCallData;
import com.upuphone.runasone.core.api.sys.SystemCallBackAdapter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SystemCallBackAdapter f4188a;
    public final /* synthetic */ SysCallData b;

    public /* synthetic */ a(SystemCallBackAdapter systemCallBackAdapter, SysCallData sysCallData) {
        this.f4188a = systemCallBackAdapter;
        this.b = sysCallData;
    }

    public final void run() {
        this.f4188a.lambda$adapt$0(this.b);
    }
}
