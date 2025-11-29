package com.upuphone.ar.tici.phone.starrynet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/Function1;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseActionMsgListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ReceiveMsgHandler$handleMsg$1 extends Lambda implements Function1<Function1<? super BaseActionMsg, ? extends Unit>, Unit> {
    final /* synthetic */ BaseActionMsg $baseActionMsg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveMsgHandler$handleMsg$1(BaseActionMsg baseActionMsg) {
        super(1);
        this.$baseActionMsg = baseActionMsg;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function1<? super BaseActionMsg, Unit>) (Function1) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Function1<? super BaseActionMsg, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "$this$dispatchActionMsgListener");
        function1.invoke(this.$baseActionMsg);
    }
}
