package com.upuphone.ai.ttsengine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TtsSdk$init$1 extends Lambda implements Function1<Integer, Unit> {
    public static final TtsSdk$init$1 INSTANCE = new TtsSdk$init$1();

    public TtsSdk$init$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i == -3 || i == -2 || i == -1) {
            TtsSdk.b.c("call stop because loss audio focus", new Object[0]);
            TtsSdk.f5490a.t(2, 2);
        }
    }
}
