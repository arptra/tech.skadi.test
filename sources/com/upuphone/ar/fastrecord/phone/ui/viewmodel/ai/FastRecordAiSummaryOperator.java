package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.xjsd.xr.sapp.asr.SmartExtractionHelper;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExtractionConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0019J,\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiSummaryOperator;", "", "()V", "aiResultFailCallback", "Lkotlin/Function2;", "", "", "", "getAiResultFailCallback", "()Lkotlin/jvm/functions/Function2;", "setAiResultFailCallback", "(Lkotlin/jvm/functions/Function2;)V", "aiResultSuccessCallback", "Lkotlin/Function1;", "getAiResultSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setAiResultSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "aiSensitiveFailCallback", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "getAiSensitiveFailCallback", "setAiSensitiveFailCallback", "mSmartExtractionHelper", "Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper;", "mSummaryRequestBean", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "recognizeId", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getRecognizeId", "getRecordId", "", "insertSummary", "summaryEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordSummaryEntity;", "startAiCommand", "requestBean", "summaryBeanToEntity", "summaryReqBean", "summary", "versionCode", "requestId", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiSummaryOperator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "FastRecordAiTodoOperator";
    @Nullable
    private Function2<? super String, ? super Integer, Unit> aiResultFailCallback;
    @Nullable
    private Function1<? super String, Unit> aiResultSuccessCallback;
    @Nullable
    private Function2<? super String, ? super SensitivePayload, Unit> aiSensitiveFailCallback;
    @Nullable
    private SmartExtractionHelper mSmartExtractionHelper;
    /* access modifiers changed from: private */
    @Nullable
    public SummaryRequestBean mSummaryRequestBean;
    @NotNull
    private final String recognizeId = "";
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiSummaryOperator$Companion;", "", "()V", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final RecordSummaryEntity summaryBeanToEntity(SummaryRequestBean summaryRequestBean, String str, String str2, String str3) {
        SummaryRequestBean summaryRequestBean2 = summaryRequestBean;
        String str4 = str2;
        RecordSummaryEntity recordSummaryEntity = r2;
        RecordSummaryEntity recordSummaryEntity2 = new RecordSummaryEntity(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, false, false, false, 32767, (DefaultConstructorMarker) null);
        String str5 = "";
        RecordSummaryEntity recordSummaryEntity3 = recordSummaryEntity;
        recordSummaryEntity3.setFileName(str5);
        recordSummaryEntity3.setContent(StringsKt.trim((CharSequence) str).toString());
        recordSummaryEntity3.setContentTemp(StringsKt.trim((CharSequence) str).toString());
        recordSummaryEntity3.setVersionCode(str4);
        Long l = null;
        String appName = summaryRequestBean2 != null ? summaryRequestBean.getAppName() : null;
        if (appName == null) {
            appName = str5;
        }
        recordSummaryEntity3.setAppName(appName);
        recordSummaryEntity3.setRecognizeId(summaryRequestBean2 != null ? summaryRequestBean.getRecognizeId() : null);
        String accountId = summaryRequestBean2 != null ? summaryRequestBean.getAccountId() : null;
        if (accountId == null) {
            accountId = str5;
        }
        recordSummaryEntity3.setAccountId(accountId);
        recordSummaryEntity3.setRequestId(str3 == null ? str5 : str3);
        String traceId = summaryRequestBean2 != null ? summaryRequestBean.getTraceId() : null;
        if (traceId != null) {
            str5 = traceId;
        }
        recordSummaryEntity3.setTraceId(str5);
        if (summaryRequestBean2 != null) {
            l = summaryRequestBean.getRecordId();
        }
        recordSummaryEntity3.setRecordId(l == null ? 0 : l.longValue());
        recordSummaryEntity3.setReport(false);
        recordSummaryEntity3.setFinishDel(false);
        LogExt.logE("summaryBeanToEntity summaryReqBean = " + summaryRequestBean2 + ",summary = " + str + ",versionCode = " + str4 + ",summaryEntity = " + recordSummaryEntity3, "FastRecordAiTodoOperator");
        return recordSummaryEntity3;
    }

    @Nullable
    public final Function2<String, Integer, Unit> getAiResultFailCallback() {
        return this.aiResultFailCallback;
    }

    @Nullable
    public final Function1<String, Unit> getAiResultSuccessCallback() {
        return this.aiResultSuccessCallback;
    }

    @Nullable
    public final Function2<String, SensitivePayload, Unit> getAiSensitiveFailCallback() {
        return this.aiSensitiveFailCallback;
    }

    @NotNull
    public final String getRecognizeId() {
        SummaryRequestBean summaryRequestBean = this.mSummaryRequestBean;
        String recognizeId2 = summaryRequestBean != null ? summaryRequestBean.getRecognizeId() : null;
        return recognizeId2 == null ? "" : recognizeId2;
    }

    public final long getRecordId() {
        SummaryRequestBean summaryRequestBean = this.mSummaryRequestBean;
        Long recordId = summaryRequestBean != null ? summaryRequestBean.getRecordId() : null;
        if (recordId == null) {
            return 0;
        }
        return recordId.longValue();
    }

    public final void insertSummary(@NotNull RecordSummaryEntity recordSummaryEntity) {
        Intrinsics.checkNotNullParameter(recordSummaryEntity, "summaryEntity");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordAiSummaryOperator$insertSummary$1(recordSummaryEntity, this, (Continuation<? super FastRecordAiSummaryOperator$insertSummary$1>) null), 3, (Object) null);
    }

    public final void setAiResultFailCallback(@Nullable Function2<? super String, ? super Integer, Unit> function2) {
        this.aiResultFailCallback = function2;
    }

    public final void setAiResultSuccessCallback(@Nullable Function1<? super String, Unit> function1) {
        this.aiResultSuccessCallback = function1;
    }

    public final void setAiSensitiveFailCallback(@Nullable Function2<? super String, ? super SensitivePayload, Unit> function2) {
        this.aiSensitiveFailCallback = function2;
    }

    public final void startAiCommand(@Nullable SummaryRequestBean summaryRequestBean) {
        this.mSummaryRequestBean = summaryRequestBean;
        SmartExtractionHelper smartExtractionHelper = new SmartExtractionHelper(RecordConstants.APP_NAME);
        smartExtractionHelper.registerCallback(new FastRecordAiSummaryOperator$startAiCommand$1$1(this, summaryRequestBean));
        this.mSmartExtractionHelper = smartExtractionHelper;
        if (summaryRequestBean != null) {
            String recognizeId2 = summaryRequestBean.getRecognizeId();
            Intrinsics.checkNotNullExpressionValue(recognizeId2, "getRecognizeId(...)");
            smartExtractionHelper.getSummary(new SmartExtractionConfig(recognizeId2, 0));
        }
    }
}
