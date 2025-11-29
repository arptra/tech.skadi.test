package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/tici/phone/starrynet/TiciMessageHelper$sendTiciContentMsgV2$2$1$listener$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "p0", "", "p1", "", "onSuccess", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciMessageHelper$sendTiciContentMsgV2$2$1$listener$1 extends SendMessageListener {
    final /* synthetic */ CancellableContinuation<Result<Boolean>> $cont;

    public TiciMessageHelper$sendTiciContentMsgV2$2$1$listener$1(CancellableContinuation<? super Result<Boolean>> cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    public void onFail(@Nullable String str, int i) {
        CommonExtKt.e("sendTiciContentMsgV2, fail, " + str + ", " + i, "TiciMessageHelper");
        if (this.$cont.isActive()) {
            CancellableContinuation<Result<Boolean>> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Result.m19boximpl(Result.m20constructorimpl(ResultKt.createFailure(new SendMsgException(str, Integer.valueOf(i)))))));
        }
    }

    public void onSuccess(@Nullable String str) {
        CommonExtKt.e("sendTiciContentMsgV2, success, " + str, "TiciMessageHelper");
        if (this.$cont.isActive()) {
            CancellableContinuation<Result<Boolean>> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m20constructorimpl(Result.m19boximpl(Result.m20constructorimpl(Boolean.TRUE))));
        }
    }
}
