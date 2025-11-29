package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "version", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordConnectManager$initForCallback$1$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ RecordConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordConnectManager$initForCallback$1$2(RecordConnectManager recordConnectManager) {
        super(1);
        this.this$0 = recordConnectManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Integer num) {
        LogExt.logI("眼镜版本号 version=" + num, "FastRecordInterConnectHelper");
        this.this$0.mGlassVersion = num != null ? num.intValue() : 0;
    }
}
