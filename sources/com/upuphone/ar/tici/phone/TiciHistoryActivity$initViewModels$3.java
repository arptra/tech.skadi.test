package com.upuphone.ar.tici.phone;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciHistoryActivity$initViewModels$3 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ TiciHistoryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHistoryActivity$initViewModels$3(TiciHistoryActivity ticiHistoryActivity) {
        super(1);
        this.this$0 = ticiHistoryActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Long l) {
        this.this$0.Y0().setImpatientTiciId(l);
    }
}
