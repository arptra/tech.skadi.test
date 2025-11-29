package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.xjsd.xr.sapp.asr.SmartExtractionHelper;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import com.xjsd.xr.sapp.asr.dao.SmartExtractionConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u001c\u001a\u00020\u00072\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\b\u0010!\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0019R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperator;", "", "()V", "aiResultFailCallback", "Lkotlin/Function2;", "", "", "", "getAiResultFailCallback", "()Lkotlin/jvm/functions/Function2;", "setAiResultFailCallback", "(Lkotlin/jvm/functions/Function2;)V", "aiResultSuccessCallback", "Lkotlin/Function1;", "getAiResultSuccessCallback", "()Lkotlin/jvm/functions/Function1;", "setAiResultSuccessCallback", "(Lkotlin/jvm/functions/Function1;)V", "aiSensitiveFailCallback", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "getAiSensitiveFailCallback", "setAiSensitiveFailCallback", "mSmartExtractionHelper", "Lcom/xjsd/xr/sapp/asr/SmartExtractionHelper;", "mTodoRequestBean", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "commandTodoList", "todoBeanList", "Ljava/util/ArrayList;", "Lcom/xjsd/xr/sapp/asr/dao/SmartExTodo$ToDo;", "Lkotlin/collections/ArrayList;", "requestId", "getRecognizeId", "getRecordId", "", "startAiCommand", "requestBean", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAiTodoOperator {
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
    public SummaryRequestBean mTodoRequestBean;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperator$Companion;", "", "()V", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void commandTodoList(@NotNull ArrayList<SmartExTodo.ToDo> arrayList, @Nullable String str) {
        Intrinsics.checkNotNullParameter(arrayList, "todoBeanList");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordAiTodoOperator$commandTodoList$1(this, arrayList, str, (Continuation<? super FastRecordAiTodoOperator$commandTodoList$1>) null), 3, (Object) null);
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
        SummaryRequestBean summaryRequestBean = this.mTodoRequestBean;
        String recognizeId = summaryRequestBean != null ? summaryRequestBean.getRecognizeId() : null;
        return recognizeId == null ? "" : recognizeId;
    }

    public final long getRecordId() {
        SummaryRequestBean summaryRequestBean = this.mTodoRequestBean;
        Long recordId = summaryRequestBean != null ? summaryRequestBean.getRecordId() : null;
        if (recordId == null) {
            return 0;
        }
        return recordId.longValue();
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
        this.mTodoRequestBean = summaryRequestBean;
        SmartExtractionHelper smartExtractionHelper = new SmartExtractionHelper(RecordConstants.APP_NAME);
        smartExtractionHelper.registerCallback(new FastRecordAiTodoOperator$startAiCommand$1$1(this));
        this.mSmartExtractionHelper = smartExtractionHelper;
        if (summaryRequestBean != null) {
            String recognizeId = summaryRequestBean.getRecognizeId();
            Intrinsics.checkNotNullExpressionValue(recognizeId, "getRecognizeId(...)");
            smartExtractionHelper.getTodo(new SmartExtractionConfig(recognizeId, 0));
        }
    }
}
