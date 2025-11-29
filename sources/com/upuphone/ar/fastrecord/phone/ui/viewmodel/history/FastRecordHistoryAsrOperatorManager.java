package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\tJ\u001a\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J$\u0010\u001b\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tJ\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J \u0010'\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\f0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager;", "", "()V", "MAX_ASR_TASK", "", "TAG", "", "cacheRecordState", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/AsrDuringProgress;", "callBackMap", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager$AsrCallbackInterface;", "waitRecordList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "workingTaskList", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperator;", "addAsrTask", "", "recordEntity", "mAsrCallbackInterface", "addAsrTaskCallback", "recordId", "getRecordState", "initSingleAsrOperator", "pcmPath", "initTwoAsrOperator", "pcmTwoPath", "isInWaitTaskList", "", "isInWorkingTaskList", "removeAsrTask", "removeAsrTaskCallback", "removeCallback", "removeWaitTask", "restart", "setEventFail", "setEventFinish", "setEventProgress", "totalTime", "curTime", "setEventStart", "setEventWait", "startWaitRecord", "AsrCallbackInterface", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordHistoryAsrOperatorManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryAsrOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,353:1\n1855#2,2:354\n1855#2,2:356\n1855#2,2:358\n1855#2,2:360\n*S KotlinDebug\n*F\n+ 1 FastRecordHistoryAsrOperatorManager.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager\n*L\n82#1:354,2\n95#1:356,2\n107#1:358,2\n117#1:360,2\n*E\n"})
public final class FastRecordHistoryAsrOperatorManager {
    @NotNull
    public static final FastRecordHistoryAsrOperatorManager INSTANCE = new FastRecordHistoryAsrOperatorManager();
    private static final int MAX_ASR_TASK = 3;
    @NotNull
    private static final String TAG = "FastRecordHistoryAsrOperatorManager";
    @NotNull
    private static final ConcurrentHashMap<Long, AsrDuringProgress> cacheRecordState = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public static final ConcurrentHashMap<Long, AsrCallbackInterface> callBackMap = new ConcurrentHashMap<>();
    @NotNull
    private static final CopyOnWriteArrayList<RecordEntity> waitRecordList = new CopyOnWriteArrayList<>();
    @NotNull
    private static final CopyOnWriteArrayList<FastRecordHistoryAsrOperator> workingTaskList = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperatorManager$AsrCallbackInterface;", "", "asrResultEmpty", "", "recordId", "", "asrResultFail", "errorCode", "", "asrResultFinish", "asrResultProgress", "totalTime", "curTime", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface AsrCallbackInterface {
        void asrResultEmpty(long j);

        void asrResultFail(long j, @NotNull String str);

        void asrResultFinish(long j);

        void asrResultProgress(long j, long j2, long j3);
    }

    private FastRecordHistoryAsrOperatorManager() {
    }

    private final void addAsrTask(RecordEntity recordEntity, AsrCallbackInterface asrCallbackInterface) {
        LogExt.logE("recordEntity info = " + recordEntity, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordHistoryAsrOperatorManager$addAsrTask$1(recordEntity, (Continuation<? super FastRecordHistoryAsrOperatorManager$addAsrTask$1>) null), 3, (Object) null);
        if (!isInWaitTaskList(recordEntity.getRecordId()) && !isInWorkingTaskList(recordEntity.getRecordId())) {
            if (!recordEntity.isTwoChannelType()) {
                initSingleAsrOperator(recordEntity.getCacheLastMergeAllScenePcmChannelPath(), recordEntity);
            } else {
                initTwoAsrOperator(recordEntity.getCacheLastUpMergePcmChannelPath(), recordEntity.getCacheLastDownMergePcmChannelPath(), recordEntity);
            }
            if (asrCallbackInterface != null) {
                callBackMap.put(Long.valueOf(recordEntity.getRecordId()), asrCallbackInterface);
            }
            setEventStart(recordEntity.getRecordId());
        } else if (asrCallbackInterface != null) {
            callBackMap.put(Long.valueOf(recordEntity.getRecordId()), asrCallbackInterface);
        }
    }

    private final void initSingleAsrOperator(String str, RecordEntity recordEntity) {
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = new FastRecordHistoryAsrOperator();
        fastRecordHistoryAsrOperator.initSingleAsr();
        fastRecordHistoryAsrOperator.setRecordInfo(recordEntity.getRecordId(), true);
        fastRecordHistoryAsrOperator.setFinishCallBack(FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$1.INSTANCE);
        fastRecordHistoryAsrOperator.setFailCallBack(FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$2.INSTANCE);
        fastRecordHistoryAsrOperator.setEmptyCallBack(FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$3.INSTANCE);
        fastRecordHistoryAsrOperator.setProgressCallback(new FastRecordHistoryAsrOperatorManager$initSingleAsrOperator$4());
        CopyOnWriteArrayList<FastRecordHistoryAsrOperator> copyOnWriteArrayList = workingTaskList;
        if (copyOnWriteArrayList.size() < 3) {
            copyOnWriteArrayList.add(fastRecordHistoryAsrOperator);
            if (str != null) {
                fastRecordHistoryAsrOperator.startSingleAsr(str, recordEntity.getRecordId());
                INSTANCE.setEventStart(recordEntity.getRecordId());
                return;
            }
            return;
        }
        waitRecordList.add(recordEntity);
        setEventWait(recordEntity.getRecordId());
    }

    private final void initTwoAsrOperator(String str, String str2, RecordEntity recordEntity) {
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = new FastRecordHistoryAsrOperator();
        fastRecordHistoryAsrOperator.initTwoSocketAsr();
        fastRecordHistoryAsrOperator.setRecordInfo(recordEntity.getRecordId(), false);
        fastRecordHistoryAsrOperator.setFinishCallBack(FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$1.INSTANCE);
        fastRecordHistoryAsrOperator.setFailCallBack(FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$2.INSTANCE);
        fastRecordHistoryAsrOperator.setEmptyCallBack(FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$3.INSTANCE);
        fastRecordHistoryAsrOperator.setProgressCallback(new FastRecordHistoryAsrOperatorManager$initTwoAsrOperator$4());
        CopyOnWriteArrayList<FastRecordHistoryAsrOperator> copyOnWriteArrayList = workingTaskList;
        if (copyOnWriteArrayList.size() < 3) {
            copyOnWriteArrayList.add(fastRecordHistoryAsrOperator);
            if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
                fastRecordHistoryAsrOperator.startTwoSocketAsr(str, str2, recordEntity.getRecordId());
                return;
            }
            return;
        }
        waitRecordList.add(recordEntity);
        setEventWait(recordEntity.getRecordId());
    }

    private final boolean isInWaitTaskList(long j) {
        for (RecordEntity recordId : waitRecordList) {
            if (j == recordId.getRecordId()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void removeAsrTask(long j) {
        FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator = null;
        for (FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator2 : workingTaskList) {
            if (j == fastRecordHistoryAsrOperator2.getRecordId()) {
                fastRecordHistoryAsrOperator = fastRecordHistoryAsrOperator2;
            }
        }
        if (fastRecordHistoryAsrOperator != null) {
            workingTaskList.remove(fastRecordHistoryAsrOperator);
        }
    }

    private final void removeWaitTask(long j) {
        RecordEntity recordEntity = null;
        for (RecordEntity recordEntity2 : waitRecordList) {
            if (j == recordEntity2.getRecordId()) {
                recordEntity = recordEntity2;
            }
        }
        if (recordEntity != null) {
            waitRecordList.remove(recordEntity);
        }
    }

    /* access modifiers changed from: private */
    public final void setEventFail(long j) {
        FastRecordAppViewModel appViewModel = FastRecordManager.Companion.getInstance().appViewModel();
        AsrDuringProgress asrDuringProgress = new AsrDuringProgress(0, 0, j, false, true, false, true, "");
        LogExt.logE("setEventFail data = " + asrDuringProgress, TAG);
        cacheRecordState.put(Long.valueOf(j), asrDuringProgress);
        appViewModel.addAsrProgress(asrDuringProgress);
    }

    /* access modifiers changed from: private */
    public final void setEventFinish(long j) {
        FastRecordAppViewModel appViewModel = FastRecordManager.Companion.getInstance().appViewModel();
        AsrDuringProgress asrDuringProgress = new AsrDuringProgress(0, 0, j, true, false, false, false, "");
        LogExt.logE("setEventFinish data = " + asrDuringProgress, TAG);
        cacheRecordState.put(Long.valueOf(j), asrDuringProgress);
        appViewModel.addAsrProgress(asrDuringProgress);
    }

    /* access modifiers changed from: private */
    public final void setEventProgress(long j, long j2, long j3) {
        FastRecordAppViewModel appViewModel = FastRecordManager.Companion.getInstance().appViewModel();
        AsrDuringProgress asrDuringProgress = new AsrDuringProgress(j2, j3, j, false, false, false, true, "");
        LogExt.logE("setEventProgress data = " + asrDuringProgress, TAG);
        cacheRecordState.put(Long.valueOf(j), asrDuringProgress);
        appViewModel.addAsrProgress(asrDuringProgress);
    }

    private final void setEventStart(long j) {
        FastRecordAppViewModel appViewModel = FastRecordManager.Companion.getInstance().appViewModel();
        AsrDuringProgress asrDuringProgress = new AsrDuringProgress(0, 0, j, false, false, false, true, "");
        LogExt.logE("setEventStart data = " + asrDuringProgress, TAG);
        cacheRecordState.put(Long.valueOf(j), asrDuringProgress);
        appViewModel.addAsrProgress(asrDuringProgress);
    }

    private final void setEventWait(long j) {
        FastRecordAppViewModel appViewModel = FastRecordManager.Companion.getInstance().appViewModel();
        AsrDuringProgress asrDuringProgress = new AsrDuringProgress(0, 0, j, false, false, true, false, "");
        LogExt.logE("setEventWait data = " + asrDuringProgress, TAG);
        cacheRecordState.put(Long.valueOf(j), asrDuringProgress);
        appViewModel.addAsrProgress(asrDuringProgress);
    }

    /* access modifiers changed from: private */
    public final void startWaitRecord() {
        CopyOnWriteArrayList<RecordEntity> copyOnWriteArrayList = waitRecordList;
        int size = copyOnWriteArrayList.size();
        LogExt.logW("startWaitRecord size = " + size, TAG);
        if (copyOnWriteArrayList.size() > 0) {
            RecordEntity remove = copyOnWriteArrayList.remove(0);
            Intrinsics.checkNotNull(remove);
            addAsrTask(remove, (AsrCallbackInterface) null);
        }
    }

    public final void addAsrTaskCallback(long j, @Nullable AsrCallbackInterface asrCallbackInterface) {
        if (asrCallbackInterface != null) {
            callBackMap.put(Long.valueOf(j), asrCallbackInterface);
        }
    }

    @Nullable
    public final AsrDuringProgress getRecordState(long j) {
        return cacheRecordState.get(Long.valueOf(j));
    }

    public final boolean isInWorkingTaskList(long j) {
        for (FastRecordHistoryAsrOperator recordId : workingTaskList) {
            if (j == recordId.getRecordId()) {
                return true;
            }
        }
        return false;
    }

    public final void removeAsrTaskCallback(long j, @Nullable AsrCallbackInterface asrCallbackInterface) {
        callBackMap.put(Long.valueOf(j), (Object) null);
    }

    public final void removeCallback(long j) {
        callBackMap.remove(Long.valueOf(j));
    }

    public final void restart(@NotNull RecordEntity recordEntity, @Nullable AsrCallbackInterface asrCallbackInterface) {
        Intrinsics.checkNotNullParameter(recordEntity, "recordEntity");
        removeAsrTask(recordEntity.getRecordId());
        removeCallback(recordEntity.getRecordId());
        removeWaitTask(recordEntity.getRecordId());
        addAsrTask(recordEntity, asrCallbackInterface);
    }
}
