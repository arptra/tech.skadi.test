package com.upuphone.ar.transcribe.phone.activity;

import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.ar.transcribe.phone.bean.OperateMessage;
import com.upuphone.ar.transcribe.phone.bean.TransStateEvent;
import com.upuphone.ar.transcribe.phone.listener.UiUpdateCallback;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\tH\u0016¨\u0006\n"}, d2 = {"com/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$initViews$3", "Lcom/upuphone/ar/transcribe/phone/listener/UiUpdateCallback;", "notifyTranslateState", "", "transStateEvent", "Lcom/upuphone/ar/transcribe/phone/bean/TransStateEvent;", "notifyVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/transcribe/phone/bean/OperateMessage;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeRecordFragment$initViews$3 implements UiUpdateCallback {
    final /* synthetic */ TranscribeRecordFragment this$0;

    public TranscribeRecordFragment$initViews$3(TranscribeRecordFragment transcribeRecordFragment) {
        this.this$0 = transcribeRecordFragment;
    }

    public void notifyTranslateState(@NotNull TransStateEvent transStateEvent) {
        Intrinsics.checkNotNullParameter(transStateEvent, "transStateEvent");
    }

    public <T> void notifyVariousMsg(@NotNull OperateMessage<T> operateMessage) {
        Intrinsics.checkNotNullParameter(operateMessage, "operateMessage");
        if (7 == operateMessage.getType()) {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.this$0), Dispatchers.b(), (CoroutineStart) null, new TranscribeRecordFragment$initViews$3$notifyVariousMsg$1((Continuation<? super TranscribeRecordFragment$initViews$3$notifyVariousMsg$1>) null), 2, (Object) null);
        }
    }
}
