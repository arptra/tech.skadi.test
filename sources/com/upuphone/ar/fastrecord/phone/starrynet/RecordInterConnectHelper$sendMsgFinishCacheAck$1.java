package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/fastrecord/phone/starrynet/RecordInterConnectHelper$sendMsgFinishCacheAck$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "msg", "", "code", "", "onSuccess", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordInterConnectHelper$sendMsgFinishCacheAck$1 extends SendMessageListener {
    final /* synthetic */ long $msgId;
    final /* synthetic */ boolean $needRetry;
    final /* synthetic */ long $sendSize;
    final /* synthetic */ RecordInterConnectHelper this$0;

    public RecordInterConnectHelper$sendMsgFinishCacheAck$1(boolean z, RecordInterConnectHelper recordInterConnectHelper, long j, long j2) {
        this.$needRetry = z;
        this.this$0 = recordInterConnectHelper;
        this.$msgId = j;
        this.$sendSize = j2;
    }

    public void onFail(@Nullable String str, int i) {
        if (str == null) {
            str = "";
        }
        LogExt.logE("sendMsgFinishCacheAck error msg = " + str + ",code = " + i, "FastRecordInterConnectHelper");
        if (this.$needRetry) {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1(this.this$0, this.$msgId, this.$sendSize, (Continuation<? super RecordInterConnectHelper$sendMsgFinishCacheAck$1$onFail$1>) null), 3, (Object) null);
        }
    }

    public void onSuccess(@Nullable String str) {
        if (str == null) {
            str = "";
        }
        LogExt.logE("sendMsgFinishCacheAck onSuccess msg = " + str, "FastRecordInterConnectHelper");
    }
}
