package com.upuphone.ar.transcribe.interconnect;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.entity.AIModelResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/transcribe/interconnect/TransInterConnectManager$requestAIState$1", "Lcom/upuphone/xr/interconnect/common/IAIModelResult$Stub;", "aiResult", "", "result", "Lcom/upuphone/xr/interconnect/entity/AIModelResult;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransInterConnectManager$requestAIState$1 extends IAIModelResult.Stub {
    final /* synthetic */ Function1<Boolean, Unit> $callBack;

    public TransInterConnectManager$requestAIState$1(Function1<? super Boolean, Unit> function1) {
        this.$callBack = function1;
    }

    public void aiResult(@Nullable AIModelResult aIModelResult) {
        Unit unit;
        if (aIModelResult != null) {
            Function1<Boolean, Unit> function1 = this.$callBack;
            int state = aIModelResult.getState();
            LogExt.g("requestAIState state=" + state, "TranscribeConnectManager");
            if (aIModelResult.getState() == Integer.parseInt("1")) {
                function1.invoke(Boolean.TRUE);
            } else {
                function1.invoke(Boolean.FALSE);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.$callBack.invoke(Boolean.TRUE);
        }
    }
}
