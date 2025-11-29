package com.upuphone.xr.interconnect.business.databinder;

import android.os.SystemClock;
import com.upuphone.xr.interconnect.common.IDataBinder;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataBinderMessageQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBinderMessageQueue.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderMessageQueue$doSend$3$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,88:1\n13309#2,2:89\n*S KotlinDebug\n*F\n+ 1 DataBinderMessageQueue.kt\ncom/upuphone/xr/interconnect/business/databinder/DataBinderMessageQueue$doSend$3$1\n*L\n75#1:89,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/interconnect/business/databinder/DataBinderMessageQueue$doSend$3$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "msgId", "", "errorCode", "", "onSuccess", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DataBinderMessageQueue$doSend$3$1 extends SendMessageListener {
    final /* synthetic */ Continuation<Unit> $continuation;
    final /* synthetic */ HashMap<String, DataBinderOperation> $pendingOperationMap;
    final /* synthetic */ DataBinderOperation[] $sendBatch;
    final /* synthetic */ DataBinderMessageQueue this$0;

    public DataBinderMessageQueue$doSend$3$1(DataBinderMessageQueue dataBinderMessageQueue, Continuation<? super Unit> continuation, DataBinderOperation[] dataBinderOperationArr, HashMap<String, DataBinderOperation> hashMap) {
        this.this$0 = dataBinderMessageQueue;
        this.$continuation = continuation;
        this.$sendBatch = dataBinderOperationArr;
        this.$pendingOperationMap = hashMap;
    }

    public void onFail(@Nullable String str, int i) {
        ILog.d(IDataBinder.TAG, "Message not sent due to error " + i + ": " + str + ".");
        DataBinderOperation[] dataBinderOperationArr = this.$sendBatch;
        HashMap<String, DataBinderOperation> hashMap = this.$pendingOperationMap;
        for (DataBinderOperation dataBinderOperation : dataBinderOperationArr) {
            if (dataBinderOperation != null) {
                hashMap.put(dataBinderOperation.getName(), dataBinderOperation);
            }
        }
        this.this$0.sendScheduler.markSendTime(SystemClock.uptimeMillis() + 600);
        Continuation<Unit> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
    }

    public void onSuccess(@Nullable String str) {
        ILog.d(IDataBinder.TAG, "Message successfully sent.");
        MessageQueueSendScheduler.markSendTime$default(this.this$0.sendScheduler, 0, 1, (Object) null);
        Continuation<Unit> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
    }
}
