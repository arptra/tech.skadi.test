package com.honey.account.x9;

import com.xjsd.ai.assistant.asr.AsrAbilityImpl;
import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsrAbilityImpl f7682a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public /* synthetic */ b(AsrAbilityImpl asrAbilityImpl, String str, List list) {
        this.f7682a = asrAbilityImpl;
        this.b = str;
        this.c = list;
    }

    public final Object call() {
        return this.f7682a.lambda$startRecognize$0(this.b, this.c);
    }
}
