package com.honey.account.pa;

import com.xjsd.ai.assistant.skill.navigation.process.NavigateProcessor;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class b implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavigateProcessor f7493a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ b(NavigateProcessor navigateProcessor, String str, String str2, String str3, boolean z) {
        this.f7493a = navigateProcessor;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    public final Object invoke() {
        return this.f7493a.g(this.b, this.c, this.d, this.e);
    }
}
