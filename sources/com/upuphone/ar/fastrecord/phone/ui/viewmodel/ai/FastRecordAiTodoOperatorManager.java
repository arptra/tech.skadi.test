package com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0006J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010'\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager;", "", "()V", "MAX_ASR_TASK", "", "TAG", "", "_recordAiTodFinishData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "callBackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager$AiTodoCallbackInterface;", "recordAiTodoDataChange", "Landroidx/lifecycle/LiveData;", "getRecordAiTodoDataChange", "()Landroidx/lifecycle/LiveData;", "waitTaskList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "workingTaskList", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperator;", "addAiTodoOperatorTask", "", "mSummaryRequestBean", "callback", "isInWaitTaskList", "", "recognizeId", "isInWorkingTaskList", "isInWorkingTaskListForRecordId", "recordId", "removeCallback", "removeWaitTask", "removeWorkingTask", "restart", "startAiTodoOperator", "startWaitTask", "AiTodoCallbackInterface", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordAiTodoOperatorManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordAiTodoOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1855#2,2:169\n1855#2,2:171\n1855#2,2:173\n1855#2,2:175\n1855#2,2:177\n*S KotlinDebug\n*F\n+ 1 FastRecordAiTodoOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager\n*L\n31#1:169,2\n44#1:171,2\n55#1:173,2\n66#1:175,2\n77#1:177,2\n*E\n"})
public final class FastRecordAiTodoOperatorManager {
    @NotNull
    public static final FastRecordAiTodoOperatorManager INSTANCE = new FastRecordAiTodoOperatorManager();
    private static final int MAX_ASR_TASK = 10;
    @NotNull
    private static final String TAG = "FastRecordAiTodoOperatorManager";
    /* access modifiers changed from: private */
    @NotNull
    public static final MutableLiveData<ArrayList<Long>> _recordAiTodFinishData;
    /* access modifiers changed from: private */
    @NotNull
    public static final ConcurrentHashMap<String, AiTodoCallbackInterface> callBackMap = new ConcurrentHashMap<>();
    @NotNull
    private static final LiveData<ArrayList<Long>> recordAiTodoDataChange;
    @NotNull
    private static final CopyOnWriteArrayList<SummaryRequestBean> waitTaskList = new CopyOnWriteArrayList<>();
    @NotNull
    private static final CopyOnWriteArrayList<FastRecordAiTodoOperator> workingTaskList = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/ai/FastRecordAiTodoOperatorManager$AiTodoCallbackInterface;", "", "onGetToDoFail", "", "recognizeId", "", "code", "", "onGetToDoSuccess", "onTodoSensitive", "sensitive", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AiTodoCallbackInterface {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onGetToDoFail(@NotNull AiTodoCallbackInterface aiTodoCallbackInterface, @NotNull String str, int i) {
                Intrinsics.checkNotNullParameter(str, "recognizeId");
            }

            public static void onGetToDoSuccess(@NotNull AiTodoCallbackInterface aiTodoCallbackInterface, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "recognizeId");
            }

            public static void onTodoSensitive(@NotNull AiTodoCallbackInterface aiTodoCallbackInterface, @NotNull String str, @Nullable SensitivePayload sensitivePayload) {
                Intrinsics.checkNotNullParameter(str, "recognizeId");
            }
        }

        void onGetToDoFail(@NotNull String str, int i);

        void onGetToDoSuccess(@NotNull String str);

        void onTodoSensitive(@NotNull String str, @Nullable SensitivePayload sensitivePayload);
    }

    static {
        MutableLiveData<ArrayList<Long>> mutableLiveData = new MutableLiveData<>();
        _recordAiTodFinishData = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<java.util.ArrayList<kotlin.Long>?{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Long>? }>");
        recordAiTodoDataChange = mutableLiveData;
    }

    private FastRecordAiTodoOperatorManager() {
    }

    private final void addAiTodoOperatorTask(SummaryRequestBean summaryRequestBean, AiTodoCallbackInterface aiTodoCallbackInterface) {
        LogExt.logE("recordEntity SummaryRequestBean  = " + summaryRequestBean, TAG);
        String recognizeId = summaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNull(recognizeId);
        if (!isInWaitTaskList(recognizeId) && !isInWorkingTaskList(recognizeId)) {
            startAiTodoOperator(summaryRequestBean, aiTodoCallbackInterface);
            if (aiTodoCallbackInterface != null) {
                callBackMap.put(recognizeId, aiTodoCallbackInterface);
            }
        } else if (aiTodoCallbackInterface != null) {
            callBackMap.put(recognizeId, aiTodoCallbackInterface);
        }
    }

    private final boolean isInWaitTaskList(String str) {
        for (SummaryRequestBean recognizeId : waitTaskList) {
            if (Intrinsics.areEqual((Object) str, (Object) recognizeId.getRecognizeId())) {
                return true;
            }
        }
        return false;
    }

    private final void removeWaitTask(String str) {
        SummaryRequestBean summaryRequestBean = null;
        for (SummaryRequestBean summaryRequestBean2 : waitTaskList) {
            if (Intrinsics.areEqual((Object) str, (Object) summaryRequestBean2.getRecognizeId())) {
                summaryRequestBean = summaryRequestBean2;
            }
        }
        if (summaryRequestBean != null) {
            waitTaskList.remove(summaryRequestBean);
        }
    }

    /* access modifiers changed from: private */
    public final void removeWorkingTask(String str) {
        FastRecordAiTodoOperator fastRecordAiTodoOperator = null;
        for (FastRecordAiTodoOperator fastRecordAiTodoOperator2 : workingTaskList) {
            if (Intrinsics.areEqual((Object) str, (Object) fastRecordAiTodoOperator2.getRecognizeId())) {
                fastRecordAiTodoOperator = fastRecordAiTodoOperator2;
            }
        }
        if (fastRecordAiTodoOperator != null) {
            workingTaskList.remove(fastRecordAiTodoOperator);
        }
    }

    private final void startAiTodoOperator(SummaryRequestBean summaryRequestBean, AiTodoCallbackInterface aiTodoCallbackInterface) {
        FastRecordAiTodoOperator fastRecordAiTodoOperator = new FastRecordAiTodoOperator();
        fastRecordAiTodoOperator.setAiSensitiveFailCallback(new FastRecordAiTodoOperatorManager$startAiTodoOperator$1(summaryRequestBean));
        fastRecordAiTodoOperator.setAiResultSuccessCallback(new FastRecordAiTodoOperatorManager$startAiTodoOperator$2(summaryRequestBean));
        fastRecordAiTodoOperator.setAiResultFailCallback(new FastRecordAiTodoOperatorManager$startAiTodoOperator$3(summaryRequestBean));
        fastRecordAiTodoOperator.startAiCommand(summaryRequestBean);
        CopyOnWriteArrayList<FastRecordAiTodoOperator> copyOnWriteArrayList = workingTaskList;
        if (copyOnWriteArrayList.size() < 10) {
            copyOnWriteArrayList.add(fastRecordAiTodoOperator);
        } else {
            waitTaskList.add(summaryRequestBean);
        }
    }

    /* access modifiers changed from: private */
    public final void startWaitTask() {
        CopyOnWriteArrayList<SummaryRequestBean> copyOnWriteArrayList = waitTaskList;
        int size = copyOnWriteArrayList.size();
        LogExt.logW("startWaitRecord size = " + size, TAG);
        if (copyOnWriteArrayList.size() > 0) {
            SummaryRequestBean remove = copyOnWriteArrayList.remove(0);
            Intrinsics.checkNotNull(remove);
            addAiTodoOperatorTask(remove, (AiTodoCallbackInterface) null);
        }
    }

    @NotNull
    public final LiveData<ArrayList<Long>> getRecordAiTodoDataChange() {
        return recordAiTodoDataChange;
    }

    public final boolean isInWorkingTaskList(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        for (FastRecordAiTodoOperator fastRecordAiTodoOperator : workingTaskList) {
            String recognizeId = fastRecordAiTodoOperator.getRecognizeId();
            LogExt.logW("isInWorkingTaskList value = " + recognizeId, TAG);
            if (Intrinsics.areEqual((Object) str, (Object) fastRecordAiTodoOperator.getRecognizeId())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInWorkingTaskListForRecordId(long j) {
        for (FastRecordAiTodoOperator fastRecordAiTodoOperator : workingTaskList) {
            long recordId = fastRecordAiTodoOperator.getRecordId();
            LogExt.logW("isInWorkingTaskList value = " + recordId, TAG);
            if (j == fastRecordAiTodoOperator.getRecordId()) {
                return true;
            }
        }
        return false;
    }

    public final void removeCallback(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        callBackMap.remove(str);
    }

    public final void restart(@NotNull SummaryRequestBean summaryRequestBean, @Nullable AiTodoCallbackInterface aiTodoCallbackInterface) {
        Intrinsics.checkNotNullParameter(summaryRequestBean, "mSummaryRequestBean");
        String recognizeId = summaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId, "getRecognizeId(...)");
        removeWorkingTask(recognizeId);
        String recognizeId2 = summaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId2, "getRecognizeId(...)");
        removeCallback(recognizeId2);
        String recognizeId3 = summaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId3, "getRecognizeId(...)");
        removeWaitTask(recognizeId3);
        addAiTodoOperatorTask(summaryRequestBean, aiTodoCallbackInterface);
    }
}
