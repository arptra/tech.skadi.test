package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.TiciApp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciMessageHelper$waitForMsgId$2$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ TiciMessageHelper$waitForMsgId$2$1$msgListener$1 $msgListener;
    final /* synthetic */ String $replyAction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMessageHelper$waitForMsgId$2$1$1(String str, TiciMessageHelper$waitForMsgId$2$1$msgListener$1 ticiMessageHelper$waitForMsgId$2$1$msgListener$1) {
        super(1);
        this.$replyAction = str;
        this.$msgListener = ticiMessageHelper$waitForMsgId$2$1$msgListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        TiciApp.b.q().getReceiveMsgHandler().s(this.$replyAction, this.$msgListener);
    }
}
