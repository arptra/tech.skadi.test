package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.TiciApp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciMessageHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMessageHelper.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$waitForReplyMsg$2$1$1\n*L\n1#1,364:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 176)
public final class TiciMessageHelper$waitForReplyMsg$2$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ TiciMessageHelper$waitForReplyMsg$2$1$msgListener$1 $msgListener;
    final /* synthetic */ String $replyAction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMessageHelper$waitForReplyMsg$2$1$1(String str, TiciMessageHelper$waitForReplyMsg$2$1$msgListener$1 ticiMessageHelper$waitForReplyMsg$2$1$msgListener$1) {
        super(1);
        this.$replyAction = str;
        this.$msgListener = ticiMessageHelper$waitForReplyMsg$2$1$msgListener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        TiciApp.b.q().getReceiveMsgHandler().s(this.$replyAction, this.$msgListener);
    }
}
