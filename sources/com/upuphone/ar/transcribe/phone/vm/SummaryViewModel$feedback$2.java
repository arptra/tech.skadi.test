package com.upuphone.ar.transcribe.phone.vm;

import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import com.upuphone.xr.audio.record.ai.feedback.ReportCallback;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/ar/transcribe/phone/vm/SummaryViewModel$feedback$2", "Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;", "onFail", "", "result", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackResponse;", "onSuccess", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SummaryViewModel$feedback$2 implements ReportCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryViewModel f6146a;

    public SummaryViewModel$feedback$2(SummaryViewModel summaryViewModel) {
        this.f6146a = summaryViewModel;
    }

    public void onFail(AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.e("feed back failed: " + aiFeedBackResponse, "SummaryViewModel");
    }

    public void onSuccess(AiFeedBackResponse aiFeedBackResponse) {
        Intrinsics.checkNotNullParameter(aiFeedBackResponse, "result");
        LogExt.d("feed back success: " + aiFeedBackResponse, "SummaryViewModel");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this.f6146a), (CoroutineContext) null, (CoroutineStart) null, new SummaryViewModel$feedback$2$onSuccess$1(this.f6146a, (Continuation<? super SummaryViewModel$feedback$2$onSuccess$1>) null), 3, (Object) null);
    }
}
