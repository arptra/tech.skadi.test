package com.honey.account.ba;

import com.xjsd.ai.assistant.common.stks.IntentFuncManager;
import java.util.function.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntentFuncManager f7152a;
    public final /* synthetic */ String b;

    public /* synthetic */ c(IntentFuncManager intentFuncManager, String str) {
        this.f7152a = intentFuncManager;
        this.b = str;
    }

    public final void accept(Object obj) {
        this.f7152a.d(this.b, (String) obj);
    }
}
