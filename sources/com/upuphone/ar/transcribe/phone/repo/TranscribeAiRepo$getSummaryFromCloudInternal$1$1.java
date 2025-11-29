package com.upuphone.ar.transcribe.phone.repo;

import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.AiSummaryEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.xjsd.xr.sapp.asr.callback.SmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/ar/transcribe/phone/repo/TranscribeAiRepo$getSummaryFromCloudInternal$1$1", "Lcom/xjsd/xr/sapp/asr/callback/SmartExCallback;", "onSummary", "", "summary", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "onSummarySensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeAiRepo$getSummaryFromCloudInternal$1$1 extends SmartExCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeAiRepo f6123a;
    public final /* synthetic */ String b;
    public final /* synthetic */ TranscribeBean c;

    public TranscribeAiRepo$getSummaryFromCloudInternal$1$1(TranscribeAiRepo transcribeAiRepo, String str, TranscribeBean transcribeBean) {
        this.f6123a = transcribeAiRepo;
        this.b = str;
        this.c = transcribeBean;
    }

    public void onSummary(SmartExSummary smartExSummary) {
        LogExt.d("cloud summary: " + smartExSummary, "TranscribeAiRepo");
        this.f6123a.e.remove(this.b);
        if (smartExSummary != null && smartExSummary.getBaseStatus() == 0) {
            AiSummaryEntity aiSummaryEntity = new AiSummaryEntity(0, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, 255, (DefaultConstructorMarker) null);
            TranscribeBean transcribeBean = this.c;
            TranscribeAiRepo transcribeAiRepo = this.f6123a;
            String str = this.b;
            String account = transcribeBean.getAccount();
            String str2 = "";
            if (account == null) {
                account = str2;
            }
            aiSummaryEntity.setAccountId(account);
            String recognizeId = transcribeBean.getRecognizeId();
            if (recognizeId != null) {
                str2 = recognizeId;
            }
            aiSummaryEntity.setRecognizeId(str2);
            aiSummaryEntity.setSummary(smartExSummary.getSummary());
            aiSummaryEntity.setRequestId(smartExSummary.getRequestId());
            aiSummaryEntity.setReported(0);
            aiSummaryEntity.setSrc(aiSummaryEntity.getSummary());
            aiSummaryEntity.setId(((Number) BuildersKt__BuildersKt.b((CoroutineContext) null, new TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1(transcribeAiRepo, aiSummaryEntity, (Continuation<? super TranscribeAiRepo$getSummaryFromCloudInternal$1$1$onSummary$1$1>) null), 1, (Object) null)).longValue());
            OnDataLoadListener onDataLoadListener = (OnDataLoadListener) transcribeAiRepo.c.remove(str);
            if (onDataLoadListener != null) {
                onDataLoadListener.a(aiSummaryEntity);
            }
        } else if (smartExSummary != null) {
            OnDataLoadListener onDataLoadListener2 = (OnDataLoadListener) this.f6123a.c.remove(this.b);
            if (onDataLoadListener2 != null) {
                onDataLoadListener2.a(new AiResponseSummary(smartExSummary.getSummary(), smartExSummary.getVersionCode(), smartExSummary.getBaseStatus(), smartExSummary.getRequestId()));
            }
        } else {
            OnDataLoadListener onDataLoadListener3 = (OnDataLoadListener) this.f6123a.c.remove(this.b);
            if (onDataLoadListener3 != null) {
                onDataLoadListener3.a((Object) null);
            }
        }
    }

    public void onSummarySensitive(SensitivePayload sensitivePayload) {
        LogExt.d("cloud sensitive: " + sensitivePayload, "TranscribeAiRepo");
        this.f6123a.e.remove(this.b);
        OnDataLoadListener onDataLoadListener = (OnDataLoadListener) this.f6123a.c.remove(this.b);
        if (onDataLoadListener != null) {
            onDataLoadListener.a(sensitivePayload != null ? new AiResponseSensitive(sensitivePayload.getRequestId(), sensitivePayload.getRequestStatus(), sensitivePayload.getRiskDescription(), sensitivePayload.getRiskLevel()) : null);
        }
    }
}
