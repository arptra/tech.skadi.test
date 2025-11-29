package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity;
import com.upuphone.ar.fastrecord.phone.ext.FastRecordAppUtilsKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.ar.fastrecord.phone.utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 d2\u00020\u0001:\u0001dB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\"\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020*0/J&\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\u0002J0\u00104\u001a\u00020*2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120\f2\u0018\u0010.\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\f\u0012\u0004\u0012\u00020*0/H\u0002J\u000e\u00106\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u000e\u00107\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0018\u00108\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u00109\u001a\u00020\bJ\b\u0010:\u001a\u0004\u0018\u00010\u0005J\b\u0010;\u001a\u0004\u0018\u00010\nJ\u0006\u0010<\u001a\u00020=JI\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020@2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\n2\"\u0010.\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020C0Bj\b\u0012\u0004\u0012\u00020C`D\u0012\u0004\u0012\u00020*0/¢\u0006\u0002\u0010EJ\u0006\u0010F\u001a\u00020\nJ\"\u0010G\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020*0/J\u000e\u0010H\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0016\u0010I\u001a\u00020*2\u0006\u0010+\u001a\u00020,H@¢\u0006\u0002\u0010JJ\u0006\u0010K\u001a\u00020\bJ\u000e\u0010L\u001a\u00020\b2\u0006\u0010+\u001a\u00020,J\u0006\u0010M\u001a\u00020\bJ\u0006\u0010N\u001a\u00020\bJ\u0006\u0010O\u001a\u00020\bJ\u0006\u0010P\u001a\u00020\bJ\u0006\u0010Q\u001a\u00020\bJ \u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020\u00052\u0006\u0010A\u001a\u00020=2\b\b\u0002\u0010T\u001a\u00020\bJ\u000e\u0010U\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u000e\u0010V\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010W\u001a\u00020\bJ\u0006\u0010X\u001a\u00020\bJ\u0018\u0010Y\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u000e\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020\bJ\u000e\u0010\\\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u000e\u0010]\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u000e\u0010^\u001a\u00020*2\u0006\u0010_\u001a\u00020\nJ&\u0010`\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010N\u001a\u00020\b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020*0aJ\u000e\u0010b\u001a\u00020*2\u0006\u0010c\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mCurFastRecordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "_mCurIsFinishAiSummary", "Lcom/upuphone/ar/fastrecord/phone/utils/SingleLiveEvent;", "", "_mCurPageState", "", "_mCurRecordNormalContentTagEntityList", "", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "_mCurRecordNormalPersonTagEntityList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "_mCurRecordVoicePlayState", "_mCurRecordVoiceWordList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordVoiceWordEntity;", "curIsFinishAiSummary", "Landroidx/lifecycle/LiveData;", "getCurIsFinishAiSummary", "()Landroidx/lifecycle/LiveData;", "curPageState", "getCurPageState", "curRecordData", "getCurRecordData", "curRecordNormalContentTagList", "getCurRecordNormalContentTagList", "curRecordNormalPersonTagEntityList", "getCurRecordNormalPersonTagEntityList", "curRecordVoicePlayState", "getCurRecordVoicePlayState", "curRecordVoiceWordList", "getCurRecordVoiceWordList", "mRecordSummaryEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordSummaryEntity;", "mTodoList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "changeAiResultState", "", "recordId", "", "checkAllAsrWordIsEmpty", "callback", "Lkotlin/Function1;", "checkWordInfoState", "stringBuffer", "Ljava/lang/StringBuffer;", "notEmptyList", "delAllNotEmptyData", "wordList", "deleteAllAiData", "deleteRecord", "getAllRecordVoiceWord", "isAsrSocketResult", "getCurRecordEntity", "getCurRecordLastWavChannelPath", "getCurRecordType", "", "getFastRecordShareFilePath", "context", "Landroid/content/Context;", "type", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getPageState", "getRecord", "getSummaryAndTodoFromLocal", "getTodoAndSummaryData", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAiLanguageSupport", "isAiWorking", "isCanStartAiAsr", "isFinishAsr", "isHasAiData", "isOriginEmptyRecord", "isPlayIng", "mergeVoice", "record", "needShoWTip", "queryRecordInfo", "queryRecordNormalTagInfo", "recordTypeIsPhone", "recordTypeIsScene", "saveRecordTotalWorld", "setChangeVoiceState", "isChangeVoice", "setIsEmptyAsrState", "setNoFinishAsr", "setPageState", "state", "updateCurRecordLanguageType", "Lkotlin/Function0;", "updatePlayState", "isPlay", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordDetailRecordHistoryViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordDetailRecordHistoryViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,523:1\n1855#2,2:524\n*S KotlinDebug\n*F\n+ 1 FastRecordDetailRecordHistoryViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel\n*L\n457#1:524,2\n*E\n"})
public final class FastRecordDetailRecordHistoryViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EDIT_STATE = "edit_state";
    private static final int MAX_SHOW_FAST_RECORD_SIZE = 1000;
    @NotNull
    public static final String PLAY_STATE = "play_state";
    @NotNull
    private static final String TAG = "FastRecordDetailRecordHistoryViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<RecordEntity> _mCurFastRecordLiveData;
    @NotNull
    private SingleLiveEvent<Boolean> _mCurIsFinishAiSummary;
    @NotNull
    private MutableLiveData<String> _mCurPageState;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<List<RecordContentTagEntity>> _mCurRecordNormalContentTagEntityList;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<List<RecordPersonEntity>> _mCurRecordNormalPersonTagEntityList;
    @NotNull
    private MutableLiveData<Boolean> _mCurRecordVoicePlayState;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<List<RecordVoiceWordEntity>> _mCurRecordVoiceWordList;
    @NotNull
    private final LiveData<Boolean> curIsFinishAiSummary;
    @NotNull
    private final LiveData<String> curPageState;
    @NotNull
    private final LiveData<RecordEntity> curRecordData;
    @NotNull
    private final LiveData<List<RecordContentTagEntity>> curRecordNormalContentTagList;
    @NotNull
    private final LiveData<List<RecordPersonEntity>> curRecordNormalPersonTagEntityList;
    @NotNull
    private final LiveData<Boolean> curRecordVoicePlayState;
    @NotNull
    private final LiveData<List<RecordVoiceWordEntity>> curRecordVoiceWordList;
    @Nullable
    private RecordSummaryEntity mRecordSummaryEntity;
    @Nullable
    private List<RecordTodoItemEntity> mTodoList;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel$Companion;", "", "()V", "EDIT_STATE", "", "MAX_SHOW_FAST_RECORD_SIZE", "", "PLAY_STATE", "TAG", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordDetailRecordHistoryViewModel() {
        MutableLiveData<RecordEntity> mutableLiveData = new MutableLiveData<>();
        this._mCurFastRecordLiveData = mutableLiveData;
        this.curRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData);
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._mCurRecordVoicePlayState = mutableLiveData2;
        this.curRecordVoicePlayState = FastRecordAppUtilsKt.asLiveData(mutableLiveData2);
        SingleLiveEvent<List<RecordVoiceWordEntity>> singleLiveEvent = new SingleLiveEvent<>();
        this._mCurRecordVoiceWordList = singleLiveEvent;
        this.curRecordVoiceWordList = FastRecordAppUtilsKt.asLiveData(singleLiveEvent);
        SingleLiveEvent<List<RecordPersonEntity>> singleLiveEvent2 = new SingleLiveEvent<>();
        this._mCurRecordNormalPersonTagEntityList = singleLiveEvent2;
        this.curRecordNormalPersonTagEntityList = FastRecordAppUtilsKt.asLiveData(singleLiveEvent2);
        SingleLiveEvent<List<RecordContentTagEntity>> singleLiveEvent3 = new SingleLiveEvent<>();
        this._mCurRecordNormalContentTagEntityList = singleLiveEvent3;
        this.curRecordNormalContentTagList = FastRecordAppUtilsKt.asLiveData(singleLiveEvent3);
        SingleLiveEvent<Boolean> singleLiveEvent4 = new SingleLiveEvent<>();
        this._mCurIsFinishAiSummary = singleLiveEvent4;
        this.curIsFinishAiSummary = FastRecordAppUtilsKt.asLiveData(singleLiveEvent4);
        MutableLiveData<String> mutableLiveData3 = new MutableLiveData<>();
        this._mCurPageState = mutableLiveData3;
        this.curPageState = FastRecordAppUtilsKt.asLiveData(mutableLiveData3);
    }

    /* access modifiers changed from: private */
    public final void checkWordInfoState(long j, StringBuffer stringBuffer, List<RecordVoiceWordEntity> list) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1(list, j, this, stringBuffer, (Continuation<? super FastRecordDetailRecordHistoryViewModel$checkWordInfoState$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void delAllNotEmptyData(List<RecordVoiceWordEntity> list, Function1<? super List<RecordVoiceWordEntity>, Unit> function1) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (RecordVoiceWordEntity recordVoiceWordEntity : list) {
            recordVoiceWordEntity.setWordContentTemp(recordVoiceWordEntity.getWordContent());
            String wordContent = recordVoiceWordEntity.getWordContent();
            if (wordContent == null || wordContent.length() == 0) {
                arrayList.add(recordVoiceWordEntity);
            } else {
                LogExt.logE("delAllNotEmptyData is " + recordVoiceWordEntity, TAG);
                arrayList2.add(recordVoiceWordEntity);
            }
        }
        function1.invoke(arrayList2);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2(arrayList, (Continuation<? super FastRecordDetailRecordHistoryViewModel$delAllNotEmptyData$2>) null), 3, (Object) null);
    }

    public static /* synthetic */ void getAllRecordVoiceWord$default(FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        fastRecordDetailRecordHistoryViewModel.getAllRecordVoiceWord(j, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTodoAndSummaryData(long r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r15 = this;
            r0 = r15
            r1 = r18
            boolean r2 = r1 instanceof com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1 r2 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001b
        L_0x0016:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1 r2 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getTodoAndSummaryData$1
            r2.<init>(r15, r1)
        L_0x001b:
            java.lang.Object r1 = r2.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r11 = 2
            r12 = 1
            if (r3 == 0) goto L_0x0053
            if (r3 == r12) goto L_0x0042
            if (r3 != r11) goto L_0x003a
            long r3 = r2.J$0
            java.lang.Object r0 = r2.L$1
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r0 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel) r0
            java.lang.Object r2 = r2.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r2 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x009f
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0042:
            long r3 = r2.J$0
            java.lang.Object r0 = r2.L$1
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r0 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel) r0
            java.lang.Object r5 = r2.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r5 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r3 = r1
            r1 = r5
            goto L_0x0079
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r1)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r3 = r1.fastRecordSummaryDao()
            r2.L$0 = r0
            r2.L$1 = r0
            r13 = r16
            r2.J$0 = r13
            r2.label = r12
            r6 = 0
            r8 = 2
            r9 = 0
            r4 = r16
            r7 = r2
            java.lang.Object r1 = com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao.DefaultImpls.queryNoFinishByRecordId$default(r3, r4, r6, r7, r8, r9)
            if (r1 != r10) goto L_0x0077
            return r10
        L_0x0077:
            r3 = r1
            r1 = r0
        L_0x0079:
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r3 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r3
            r0.mRecordSummaryEntity = r3
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r0 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r0 = r0.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r3 = r0.fastRecordTodoItemDao()
            r2.L$0 = r1
            r2.L$1 = r1
            r2.J$0 = r13
            r2.label = r11
            r6 = 0
            r8 = 2
            r9 = 0
            r4 = r13
            r7 = r2
            java.lang.Object r0 = com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao.DefaultImpls.queryAllNoFinishByRecordId$default(r3, r4, r6, r7, r8, r9)
            if (r0 != r10) goto L_0x009b
            return r10
        L_0x009b:
            r2 = r1
            r3 = r13
            r1 = r0
            r0 = r2
        L_0x009f:
            java.util.List r1 = (java.util.List) r1
            r0.mTodoList = r1
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r0 = r2.mRecordSummaryEntity
            r1 = 0
            if (r0 == 0) goto L_0x00aa
            r0 = r12
            goto L_0x00ab
        L_0x00aa:
            r0 = r1
        L_0x00ab:
            java.util.List<com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity> r5 = r2.mTodoList
            if (r5 == 0) goto L_0x00b8
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00b6
            goto L_0x00b8
        L_0x00b6:
            r5 = r1
            goto L_0x00b9
        L_0x00b8:
            r5 = r12
        L_0x00b9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getTodoAndSummaryData recordId = "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " mRecordSummaryEntity != null = "
            r6.append(r3)
            r6.append(r0)
            java.lang.String r0 = ",mTodoList.isNullOrEmpty() = "
            r6.append(r0)
            r6.append(r5)
            java.lang.String r0 = r6.toString()
            java.lang.String r3 = "FastRecordDetailRecordHistoryViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r3)
            com.upuphone.ar.fastrecord.phone.utils.SingleLiveEvent<java.lang.Boolean> r0 = r2._mCurIsFinishAiSummary
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r3 = r2.mRecordSummaryEntity
            if (r3 != 0) goto L_0x00f0
            java.util.List<com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity> r2 = r2.mTodoList
            if (r2 == 0) goto L_0x00ef
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x00f0
        L_0x00ef:
            r12 = r1
        L_0x00f0:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            r0.postValue(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel.getTodoAndSummaryData(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void mergeVoice$default(FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, RecordEntity recordEntity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        fastRecordDetailRecordHistoryViewModel.mergeVoice(recordEntity, i, z);
    }

    /* access modifiers changed from: private */
    public final void saveRecordTotalWorld(long j, StringBuffer stringBuffer) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1(j, stringBuffer, this, (Continuation<? super FastRecordDetailRecordHistoryViewModel$saveRecordTotalWorld$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void updateCurRecordLanguageType$default(FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, long j, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        fastRecordDetailRecordHistoryViewModel.updateCurRecordLanguageType(j, z, function0);
    }

    public final void changeAiResultState(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$changeAiResultState$1(j, (Continuation<? super FastRecordDetailRecordHistoryViewModel$changeAiResultState$1>) null), 3, (Object) null);
    }

    public final void checkAllAsrWordIsEmpty(long j, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1(j, this, function1, (Continuation<? super FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1>) null), 3, (Object) null);
    }

    public final void deleteAllAiData(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$deleteAllAiData$1(j, (Continuation<? super FastRecordDetailRecordHistoryViewModel$deleteAllAiData$1>) null), 3, (Object) null);
    }

    public final void deleteRecord(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$deleteRecord$1(j, (Continuation<? super FastRecordDetailRecordHistoryViewModel$deleteRecord$1>) null), 3, (Object) null);
    }

    public final void getAllRecordVoiceWord(long j, boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1(z, j, this, (Continuation<? super FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<Boolean> getCurIsFinishAiSummary() {
        return this.curIsFinishAiSummary;
    }

    @NotNull
    public final LiveData<String> getCurPageState() {
        return this.curPageState;
    }

    @NotNull
    public final LiveData<RecordEntity> getCurRecordData() {
        return this.curRecordData;
    }

    @Nullable
    public final RecordEntity getCurRecordEntity() {
        return this._mCurFastRecordLiveData.getValue();
    }

    @Nullable
    public final String getCurRecordLastWavChannelPath() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value != null) {
            return value.getCacheLastWavChannelPath();
        }
        return null;
    }

    @NotNull
    public final LiveData<List<RecordContentTagEntity>> getCurRecordNormalContentTagList() {
        return this.curRecordNormalContentTagList;
    }

    @NotNull
    public final LiveData<List<RecordPersonEntity>> getCurRecordNormalPersonTagEntityList() {
        return this.curRecordNormalPersonTagEntityList;
    }

    public final int getCurRecordType() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value != null) {
            return value.getType();
        }
        return -1;
    }

    @NotNull
    public final LiveData<Boolean> getCurRecordVoicePlayState() {
        return this.curRecordVoicePlayState;
    }

    @NotNull
    public final LiveData<List<RecordVoiceWordEntity>> getCurRecordVoiceWordList() {
        return this.curRecordVoiceWordList;
    }

    public final void getFastRecordShareFilePath(@NotNull Context context, @Nullable Long l, @NotNull String str, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(function1, "callback");
        LogExt.logE("getFastRecordShareFilePath recordId =" + l + ",type = " + str, TAG);
        if (l != null) {
            Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1(str, this, context, l, function1, (Continuation<? super FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1>) null), 3, (Object) null);
        }
    }

    @NotNull
    public final String getPageState() {
        String value = this._mCurPageState.getValue();
        return value == null ? PLAY_STATE : value;
    }

    public final void getRecord(long j, @NotNull Function1<? super RecordEntity, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$getRecord$1(j, function1, (Continuation<? super FastRecordDetailRecordHistoryViewModel$getRecord$1>) null), 3, (Object) null);
    }

    public final void getSummaryAndTodoFromLocal(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1(this, j, (Continuation<? super FastRecordDetailRecordHistoryViewModel$getSummaryAndTodoFromLocal$1>) null), 3, (Object) null);
    }

    public final boolean isAiLanguageSupport() {
        String str;
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value == null || (str = value.getLanguageType()) == null) {
            str = "";
        }
        return RecordVoiceUtils.INSTANCE.aiLanguageSupport(str);
    }

    public final boolean isAiWorking(long j) {
        boolean isInWorkingTaskListForRecordId = FastRecordAiSummaryOperatorManager.INSTANCE.isInWorkingTaskListForRecordId(j);
        boolean isInWorkingTaskListForRecordId2 = FastRecordAiTodoOperatorManager.INSTANCE.isInWorkingTaskListForRecordId(j);
        LogExt.logW("isAiWorking isInSummaryManager = " + isInWorkingTaskListForRecordId + ",isInToDoManager = " + isInWorkingTaskListForRecordId2 + ",recordId= " + j, TAG);
        return isInWorkingTaskListForRecordId || isInWorkingTaskListForRecordId2;
    }

    public final boolean isCanStartAiAsr() {
        String str;
        String shortHandText;
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        Boolean valueOf = value != null ? Boolean.valueOf(value.isFinishAsr()) : null;
        LogExt.logE("isCanStartAiAsr isFinishAsr = " + valueOf, TAG);
        RecordEntity value2 = this._mCurFastRecordLiveData.getValue();
        String str2 = "";
        if (value2 == null || (str = value2.getShortHandText()) == null) {
            str = str2;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        LogExt.logE("isCanStartAiAsr shortHandText is empty = " + isEmpty, TAG);
        RecordEntity value3 = this._mCurFastRecordLiveData.getValue();
        if (value3 != null && value3.isFinishAsr()) {
            RecordEntity value4 = this._mCurFastRecordLiveData.getValue();
            if (!(value4 == null || (shortHandText = value4.getShortHandText()) == null)) {
                str2 = shortHandText;
            }
            if (!TextUtils.isEmpty(str2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isFinishAsr() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        return value != null && value.isFinishAsr();
    }

    public final boolean isHasAiData() {
        List<RecordTodoItemEntity> list;
        RecordEntity value = this.curRecordData.getValue();
        boolean isAiWorking = isAiWorking(value != null ? value.getRecordId() : 0);
        RecordEntity value2 = this.curRecordData.getValue();
        Long valueOf = value2 != null ? Long.valueOf(value2.getRecordId()) : null;
        boolean z = this.mRecordSummaryEntity != null;
        List<RecordTodoItemEntity> list2 = this.mTodoList;
        boolean z2 = list2 == null || list2.isEmpty();
        StringBuilder sb = new StringBuilder();
        sb.append("recordId =");
        sb.append(valueOf);
        sb.append(" mRecordSummaryEntity != null = ");
        sb.append(z);
        sb.append(",!mTodoList.isNullOrEmpty() = ");
        sb.append(!z2);
        sb.append(",isAiWorking = ");
        sb.append(isAiWorking);
        LogExt.logE(sb.toString(), TAG);
        return this.mRecordSummaryEntity != null || ((list = this.mTodoList) != null && !list.isEmpty()) || isAiWorking;
    }

    public final boolean isOriginEmptyRecord() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        return value != null && value.isEmptyRecord();
    }

    public final boolean isPlayIng() {
        Boolean value = this._mCurRecordVoicePlayState.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    public final void mergeVoice(@NotNull RecordEntity recordEntity, int i, boolean z) {
        Intrinsics.checkNotNullParameter(recordEntity, "record");
        RecordVoiceMergeUtil.INSTANCE.mergeVoice(recordEntity, i, z, new FastRecordDetailRecordHistoryViewModel$mergeVoice$1(this, recordEntity));
    }

    public final void queryRecordInfo(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1(j, this, (Continuation<? super FastRecordDetailRecordHistoryViewModel$queryRecordInfo$1>) null), 3, (Object) null);
    }

    public final void queryRecordNormalTagInfo(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1(j, this, (Continuation<? super FastRecordDetailRecordHistoryViewModel$queryRecordNormalTagInfo$1>) null), 3, (Object) null);
    }

    public final boolean recordTypeIsPhone() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        return value != null && value.getType() == 0;
    }

    public final boolean recordTypeIsScene() {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        return value != null && value.getType() == 1;
    }

    public final void setChangeVoiceState(boolean z) {
        RecordEntity value = this._mCurFastRecordLiveData.getValue();
        if (value != null) {
            value.setChangeVoice(z);
        }
    }

    public final void setIsEmptyAsrState(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$setIsEmptyAsrState$1(j, (Continuation<? super FastRecordDetailRecordHistoryViewModel$setIsEmptyAsrState$1>) null), 3, (Object) null);
    }

    public final void setNoFinishAsr(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$setNoFinishAsr$1(j, (Continuation<? super FastRecordDetailRecordHistoryViewModel$setNoFinishAsr$1>) null), 3, (Object) null);
    }

    public final void setPageState(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        this._mCurPageState.postValue(str);
    }

    public final void updateCurRecordLanguageType(long j, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1(j, z, this, function0, (Continuation<? super FastRecordDetailRecordHistoryViewModel$updateCurRecordLanguageType$1>) null), 3, (Object) null);
    }

    public final void updatePlayState(boolean z) {
        this._mCurRecordVoicePlayState.postValue(Boolean.valueOf(z));
    }
}
