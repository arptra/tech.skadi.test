package com.xjsd.ai.assistant.flutter.nlp;

import android.os.RemoteException;
import com.alibaba.fastjson.JSON;
import com.upuphone.xr.interconnect.entity.PoiResult;
import com.upuphone.xr.interconnect.listener.NaviPoiCallback;
import com.xjsd.ai.assistant.log.ILog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xjsd/ai/assistant/flutter/nlp/NavNlpPreprocessor$searchPoi$2$1", "Lcom/upuphone/xr/interconnect/listener/NaviPoiCallback;", "poiCallback", "", "pois", "", "Lcom/upuphone/xr/interconnect/entity/PoiResult;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NavNlpPreprocessor$searchPoi$2$1 extends NaviPoiCallback {
    final /* synthetic */ CancellableContinuation<List<? extends PoiResult>> $it;

    public NavNlpPreprocessor$searchPoi$2$1(CancellableContinuation<? super List<? extends PoiResult>> cancellableContinuation) {
        this.$it = cancellableContinuation;
    }

    public void poiCallback(@NotNull List<? extends PoiResult> list) throws RemoteException {
        Intrinsics.checkNotNullParameter(list, "pois");
        String jSONString = JSON.toJSONString(list);
        ILog.j("NavNlpPreprocessor", "search poi->" + jSONString);
        this.$it.resumeWith(Result.m20constructorimpl(list));
    }
}
