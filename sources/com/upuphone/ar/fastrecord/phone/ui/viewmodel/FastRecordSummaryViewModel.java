package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.datatrack.FastRecordDataTrackManager;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
import com.upuphone.ar.fastrecord.phone.ext.FastRecordAppUtilsKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.ar.fastrecord.phone.utils.SingleLiveEvent;
import com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest;
import com.xjsd.xr.sapp.asr.SmartExtractionHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\rJ\b\u00100\u001a\u0004\u0018\u00010\u000bJ\u0006\u00101\u001a\u00020,J\u0006\u00102\u001a\u00020\rJ\u000e\u00103\u001a\u00020,2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020\bJ\u0006\u00109\u001a\u00020\bJ\b\u0010:\u001a\u00020,H\u0014J\u000e\u0010;\u001a\u00020,2\u0006\u00104\u001a\u000205J\b\u0010<\u001a\u00020,H\u0002J\u0006\u0010=\u001a\u00020,J\u0010\u0010>\u001a\u00020,2\b\u0010?\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010@\u001a\u00020,J,\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u001c2\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\r2\b\u0010E\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010F\u001a\u00020,J\u0010\u0010G\u001a\u00020,2\b\u0010C\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0014R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0014R\u0019\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0014¨\u0006I"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordSummaryViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mCurFastRecordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "_mCurIsFinishAiSummary", "Lcom/upuphone/ar/fastrecord/phone/utils/SingleLiveEvent;", "", "_mSummaryEditModeLiveData", "_mSummaryLiveData", "Lcom/upuphone/ar/fastrecord/phone/db/RecordSummaryEntity;", "_mSummaryLockedLiveData", "", "_mSummaryResult", "", "_mSummarySensitiveLiveData", "curIsFinishAiSummary", "Landroidx/lifecycle/LiveData;", "getCurIsFinishAiSummary", "()Landroidx/lifecycle/LiveData;", "curRecordData", "getCurRecordData", "mSmartExtractionHelper", "Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper;", "mSummaryResult", "getMSummaryResult", "requestBean", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "getRequestBean", "()Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "setRequestBean", "(Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "summaryEditModeLiveData", "getSummaryEditModeLiveData", "summaryLiveData", "getSummaryLiveData", "summaryLockedLiveData", "getSummaryLockedLiveData", "summarySensitiveLiveData", "getSummarySensitiveLiveData", "editModeNotify", "", "getFeedBackBean", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackRequest;", "getRecordId", "getSummaryData", "getSummaryFromLocal", "getSummaryShareText", "getTodoAndSummaryData", "recordId", "", "insertSummary", "summaryEntity", "isAsrLanguageSupport", "isNotEmptySummaryData", "onCleared", "queryRecordInfo", "reportAiDataTrack", "requestSummaryInfo", "setSummaryRequestBean", "summaryRequestBean", "startAiSummaryTask", "summaryBeanToEntity", "summaryReqBean", "summary", "versionCode", "requestId", "updateReportStateSuccess", "updateSummary", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSummaryViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SUMMARY_RESULT_NETWORK_EMPTY = 1;
    public static final int SUMMARY_RESULT_NETWORK_FAIL = 2;
    public static final int SUMMARY_RESULT_SUCCESS = 0;
    @NotNull
    private static final String TAG = "SummaryViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<RecordEntity> _mCurFastRecordLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<Boolean> _mCurIsFinishAiSummary;
    @NotNull
    private MutableLiveData<Boolean> _mSummaryEditModeLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<RecordSummaryEntity> _mSummaryLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<String> _mSummaryLockedLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<Integer> _mSummaryResult;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<String> _mSummarySensitiveLiveData;
    @NotNull
    private final LiveData<Boolean> curIsFinishAiSummary;
    @NotNull
    private final LiveData<RecordEntity> curRecordData;
    @Nullable
    private SmartExtractionHelper mSmartExtractionHelper;
    @NotNull
    private final LiveData<Integer> mSummaryResult;
    @Nullable
    private SummaryRequestBean requestBean;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());
    @NotNull
    private final LiveData<Boolean> summaryEditModeLiveData;
    @NotNull
    private final LiveData<RecordSummaryEntity> summaryLiveData;
    @NotNull
    private final LiveData<String> summaryLockedLiveData;
    @NotNull
    private final LiveData<String> summarySensitiveLiveData;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordSummaryViewModel$Companion;", "", "()V", "SUMMARY_RESULT_NETWORK_EMPTY", "", "SUMMARY_RESULT_NETWORK_FAIL", "SUMMARY_RESULT_SUCCESS", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordSummaryViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._mSummaryResult = mutableLiveData;
        this.mSummaryResult = mutableLiveData;
        MutableLiveData<RecordSummaryEntity> mutableLiveData2 = new MutableLiveData<>();
        this._mSummaryLiveData = mutableLiveData2;
        this.summaryLiveData = mutableLiveData2;
        MutableLiveData<RecordEntity> mutableLiveData3 = new MutableLiveData<>();
        this._mCurFastRecordLiveData = mutableLiveData3;
        this.curRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData3);
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        this._mSummarySensitiveLiveData = mutableLiveData4;
        this.summarySensitiveLiveData = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        this._mSummaryLockedLiveData = mutableLiveData5;
        this.summaryLockedLiveData = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._mSummaryEditModeLiveData = mutableLiveData6;
        this.summaryEditModeLiveData = mutableLiveData6;
        SingleLiveEvent<Boolean> singleLiveEvent = new SingleLiveEvent<>();
        this._mCurIsFinishAiSummary = singleLiveEvent;
        this.curIsFinishAiSummary = FastRecordAppUtilsKt.asLiveData(singleLiveEvent);
    }

    private final void reportAiDataTrack() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value != null) {
            long originTextSize = value.getOriginTextSize();
            long recordId = value.getRecordId();
            LogExt.logE("reportAiDataTrack record id = " + recordId + ",textLength = " + originTextSize, TAG);
            SummaryRequestBean summaryRequestBean = this.requestBean;
            String recognizeId = summaryRequestBean != null ? summaryRequestBean.getRecognizeId() : null;
            if (recognizeId == null) {
                recognizeId = "";
            } else {
                Intrinsics.checkNotNull(recognizeId);
            }
            FastRecordDataTrackManager.reportAIExtractionDataTrack(originTextSize, recognizeId);
        }
    }

    private final RecordSummaryEntity summaryBeanToEntity(SummaryRequestBean summaryRequestBean, String str, String str2, String str3) {
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
        LogExt.logE("summaryBeanToEntity summaryReqBean = " + summaryRequestBean2 + ",summary = " + str + ",versionCode = " + str4 + ",summaryEntity = " + recordSummaryEntity3, TAG);
        return recordSummaryEntity3;
    }

    public final void editModeNotify() {
        this._mSummaryEditModeLiveData.postValue(Boolean.TRUE);
    }

    @NotNull
    public final LiveData<Boolean> getCurIsFinishAiSummary() {
        return this.curIsFinishAiSummary;
    }

    @NotNull
    public final LiveData<RecordEntity> getCurRecordData() {
        return this.curRecordData;
    }

    @NotNull
    public final AiFeedBackRequest getFeedBackBean() {
        String str;
        String recordId = getRecordId();
        String summaryShareText = getSummaryShareText();
        RecordSummaryEntity summaryData = getSummaryData();
        if (summaryData == null || (str = summaryData.getRequestId()) == null) {
            str = "";
        }
        return new AiFeedBackRequest(1, recordId, summaryShareText, str);
    }

    @NotNull
    public final LiveData<Integer> getMSummaryResult() {
        return this.mSummaryResult;
    }

    @NotNull
    public final String getRecordId() {
        Object obj;
        SummaryRequestBean summaryRequestBean = this.requestBean;
        if (summaryRequestBean == null || (obj = summaryRequestBean.getRecordId()) == null) {
            obj = "";
        }
        return obj.toString();
    }

    @Nullable
    public final SummaryRequestBean getRequestBean() {
        return this.requestBean;
    }

    @Nullable
    public final RecordSummaryEntity getSummaryData() {
        return this._mSummaryLiveData.getValue();
    }

    @NotNull
    public final LiveData<Boolean> getSummaryEditModeLiveData() {
        return this.summaryEditModeLiveData;
    }

    public final void getSummaryFromLocal() {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryViewModel$getSummaryFromLocal$1(this, (Continuation<? super FastRecordSummaryViewModel$getSummaryFromLocal$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<RecordSummaryEntity> getSummaryLiveData() {
        return this.summaryLiveData;
    }

    @NotNull
    public final LiveData<String> getSummaryLockedLiveData() {
        return this.summaryLockedLiveData;
    }

    @NotNull
    public final LiveData<String> getSummarySensitiveLiveData() {
        return this.summarySensitiveLiveData;
    }

    @NotNull
    public final String getSummaryShareText() {
        StringBuilder sb = new StringBuilder();
        boolean z = getSummaryData() != null;
        RecordSummaryEntity summaryData = getSummaryData();
        String contentTemp = summaryData != null ? summaryData.getContentTemp() : null;
        LogExt.logE("getSummaryShareText data is null  " + z + ", contentTemp = " + contentTemp, TAG);
        RecordSummaryEntity summaryData2 = getSummaryData();
        if (summaryData2 != null && !TextUtils.isEmpty(summaryData2.getContentTemp())) {
            String string = FastRecordManager.Companion.getInstance().appContext().getString(R.string.fast_record_summary_total_type);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            sb.append(StringUtils.LF);
            sb.append(string);
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(StringUtils.LF);
            sb.append(summaryData2.getContentTemp());
            sb.append(StringUtils.LF);
        }
        LogExt.logE("getSummaryShareText  sb.toString()=" + sb, TAG);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void getTodoAndSummaryData(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryViewModel$getTodoAndSummaryData$1(j, this, (Continuation<? super FastRecordSummaryViewModel$getTodoAndSummaryData$1>) null), 3, (Object) null);
    }

    public final void insertSummary(@NotNull RecordSummaryEntity recordSummaryEntity) {
        Intrinsics.checkNotNullParameter(recordSummaryEntity, "summaryEntity");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryViewModel$insertSummary$1(recordSummaryEntity, this, (Continuation<? super FastRecordSummaryViewModel$insertSummary$1>) null), 3, (Object) null);
    }

    public final boolean isAsrLanguageSupport() {
        String str;
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value == null || (str = value.getLanguageType()) == null) {
            str = "";
        }
        return RecordVoiceUtils.INSTANCE.aiLanguageSupport(str);
    }

    public final boolean isNotEmptySummaryData() {
        if (getSummaryData() != null) {
            RecordSummaryEntity summaryData = getSummaryData();
            String content = summaryData != null ? summaryData.getContent() : null;
            return (content == null || content.length() == 0) ? false : true;
        }
    }

    public void onCleared() {
        super.onCleared();
        SmartExtractionHelper smartExtractionHelper = this.mSmartExtractionHelper;
        if (smartExtractionHelper != null) {
            smartExtractionHelper.release();
        }
    }

    public final void queryRecordInfo(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryViewModel$queryRecordInfo$1(j, this, (Continuation<? super FastRecordSummaryViewModel$queryRecordInfo$1>) null), 3, (Object) null);
    }

    public final void requestSummaryInfo() {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryViewModel$requestSummaryInfo$1(this, (Continuation<? super FastRecordSummaryViewModel$requestSummaryInfo$1>) null), 3, (Object) null);
    }

    public final void setRequestBean(@Nullable SummaryRequestBean summaryRequestBean) {
        this.requestBean = summaryRequestBean;
    }

    public final void setSummaryRequestBean(@Nullable SummaryRequestBean summaryRequestBean) {
        this.requestBean = summaryRequestBean;
    }

    public final void startAiSummaryTask() {
        reportAiDataTrack();
        SummaryRequestBean summaryRequestBean = this.requestBean;
        LogExt.logE("startTask requestBean = " + summaryRequestBean, TAG);
        SummaryRequestBean summaryRequestBean2 = this.requestBean;
        if (summaryRequestBean2 != null) {
            FastRecordAiSummaryOperatorManager.INSTANCE.restart(summaryRequestBean2, new FastRecordSummaryViewModel$startAiSummaryTask$1$1(summaryRequestBean2, this));
        }
    }

    public final void updateReportStateSuccess() {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryViewModel$updateReportStateSuccess$1(this, (Continuation<? super FastRecordSummaryViewModel$updateReportStateSuccess$1>) null), 3, (Object) null);
    }

    public final void updateSummary(@Nullable String str) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSummaryViewModel$updateSummary$1(this, str, (Continuation<? super FastRecordSummaryViewModel$updateSummary$1>) null), 3, (Object) null);
    }
}
