package com.honey.account.na;

import com.xjsd.ai.assistant.phone.vui.translate.TranslateManager;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7469a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(String str, String str2, String str3) {
        this.f7469a = str;
        this.b = str2;
        this.c = str3;
    }

    public final Object invoke() {
        return TranslateManager.i(this.f7469a, this.b, this.c);
    }
}
