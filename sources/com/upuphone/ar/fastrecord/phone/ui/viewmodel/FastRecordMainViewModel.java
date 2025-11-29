package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagDao;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.FastRecordAppUtilsKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment;
import com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\bJ\u0014\u0010'\u001a\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0)J\u0006\u0010*\u001a\u00020%J\u0014\u0010+\u001a\u00020%2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0-J&\u0010.\u001a\u00020%2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH@¢\u0006\u0002\u00100J\"\u00101\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%04J\u0014\u00105\u001a\u00020%2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0-J\u0010\u00106\u001a\u00020%2\u0006\u0010&\u001a\u00020\bH\u0002J(\u00107\u001a\u00020\f2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u00109\u001a\u00020\bH\u0002J\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tJ\u0006\u0010;\u001a\u00020\fJ\u0006\u0010<\u001a\u00020\u0018J\u0006\u0010=\u001a\u00020\fJ6\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u00182&\u0010,\u001a\"\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u0004\u0012\u00020%04J:\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00182\"\u0010D\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020E0\u0007j\b\u0012\u0004\u0012\u00020E`\t\u0012\u0004\u0012\u00020%04J \u0010F\u001a\u0012\u0012\u0004\u0012\u00020G0\u0007j\b\u0012\u0004\u0012\u00020G`\t2\u0006\u00102\u001a\u000203H\u0002J\u0006\u0010H\u001a\u00020%J\u000e\u0010I\u001a\u00020%2\u0006\u0010C\u001a\u00020\fJ\u0006\u0010J\u001a\u00020\u0005J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\bH\u0002J\u000e\u0010L\u001a\u00020\u00052\u0006\u00109\u001a\u00020\bJ \u0010M\u001a\u00020\u00052\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010)2\u0006\u00109\u001a\u00020\bH\u0002J\u0006\u0010O\u001a\u00020%J\u000e\u0010P\u001a\u00020%2\u0006\u0010&\u001a\u00020\bJ&\u0010Q\u001a\u00020%2\u0016\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH@¢\u0006\u0002\u00100J\u0006\u0010S\u001a\u00020%J\u0006\u0010T\u001a\u00020%J\u000e\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020\u0018J\u000e\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020\fJ\b\u0010Y\u001a\u00020%H\u0002J$\u0010Z\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u0010[\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0-J$\u0010\\\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u0010]\u001a\u00020\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0-R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0004X\u000e¢\u0006\u0002\n\u0000R'\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R'\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t0\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_clearSelectStatus", "Landroidx/lifecycle/MutableLiveData;", "", "_mAllFastRecordLiveData", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "Lkotlin/collections/ArrayList;", "_mChooseRecordEntityList", "_mPageStatus", "", "_mPhoneFastRecordLiveData", "_mSceneFastRecordLiveData", "allFastRecordData", "Landroidx/lifecycle/LiveData;", "getAllFastRecordData", "()Landroidx/lifecycle/LiveData;", "mChooseRecordEntityList", "getMChooseRecordEntityList", "mClearSelectStatus", "getMClearSelectStatus", "mCurPage", "", "mPageStatus", "getMPageStatus", "mergeVideoForShareJob", "Lkotlinx/coroutines/Job;", "phoneFastRecordData", "getPhoneFastRecordData", "sceneFastRecordData", "getSceneFastRecordData", "scope", "Lkotlinx/coroutines/CoroutineScope;", "shareJob", "addSelectEntity", "", "recordEntity", "addSelectListEntity", "newDataList", "", "cancelShareJob", "checkAndMergeFastRecordVideoFile", "callBack", "Lkotlin/Function0;", "checkFastRecordVideoState", "recordIdListNew", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIsNewRecordItem", "recordId", "", "Lkotlin/Function1;", "delRecord", "deleteFileData", "findIndexInList", "recordList", "data", "getChooseRecordEntityList", "getChooseRecordEntityListSize", "getCurPage", "getCurPageItemSize", "getCurRecordList", "recordType", "getFastRecordShareFilePath", "context", "Landroid/content/Context;", "type", "callback", "Landroid/net/Uri;", "getTagInfo", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "initFragmentAllData", "initFragmentDataByType", "isChoosePageState", "isFinishState", "isInChooseRecordEntityList", "isInRecordList", "list", "reQueryFastRecordList", "removeSelectEntity", "resetRecordStatus", "allRecordList", "selectAllItemStatus", "setClearSelectStatus", "setCurPage", "curPage", "setPageModeStatus", "value", "updateRecordForDel", "updateRecordIsNewRecordItemState", "state", "updateRecordName", "title", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,565:1\n1855#2,2:566\n1855#2,2:568\n1855#2,2:570\n1864#2,3:572\n1855#2:575\n1856#2:577\n1855#2,2:578\n1#3:576\n*S KotlinDebug\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel\n*L\n85#1:566,2\n188#1:568,2\n272#1:570,2\n317#1:572,3\n455#1:575\n455#1:577\n534#1:578,2\n*E\n"})
public final class FastRecordMainViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGE_CHOOSE_STATUS = 1;
    public static final int PAGE_NORMAL_STATUS = 2;
    @NotNull
    public static final String RECORD_TYPE_ALL = "main";
    @NotNull
    public static final String RECORD_TYPE_PHONE = "phone";
    @NotNull
    public static final String RECORD_TYPE_SCENE = "scene";
    @NotNull
    private static final String TAG = "FastRecordMainViewModel";
    @NotNull
    private MutableLiveData<Boolean> _clearSelectStatus;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<ArrayList<RecordEntity>> _mAllFastRecordLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<ArrayList<RecordEntity>> _mChooseRecordEntityList;
    @NotNull
    private MutableLiveData<Integer> _mPageStatus;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<ArrayList<RecordEntity>> _mPhoneFastRecordLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<ArrayList<RecordEntity>> _mSceneFastRecordLiveData;
    @NotNull
    private final LiveData<ArrayList<RecordEntity>> allFastRecordData;
    @NotNull
    private final LiveData<ArrayList<RecordEntity>> mChooseRecordEntityList;
    @NotNull
    private final LiveData<Boolean> mClearSelectStatus;
    @NotNull
    private String mCurPage = RECORD_TYPE_ALL;
    @NotNull
    private final LiveData<Integer> mPageStatus;
    @Nullable
    private Job mergeVideoForShareJob;
    @NotNull
    private final LiveData<ArrayList<RecordEntity>> phoneFastRecordData;
    @NotNull
    private final LiveData<ArrayList<RecordEntity>> sceneFastRecordData;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());
    @Nullable
    private Job shareJob;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$Companion;", "", "()V", "PAGE_CHOOSE_STATUS", "", "PAGE_NORMAL_STATUS", "RECORD_TYPE_ALL", "", "RECORD_TYPE_PHONE", "RECORD_TYPE_SCENE", "TAG", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordMainViewModel() {
        MutableLiveData<ArrayList<RecordEntity>> mutableLiveData = new MutableLiveData<>();
        this._mAllFastRecordLiveData = mutableLiveData;
        this.allFastRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData);
        MutableLiveData<ArrayList<RecordEntity>> mutableLiveData2 = new MutableLiveData<>();
        this._mSceneFastRecordLiveData = mutableLiveData2;
        this.sceneFastRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData2);
        MutableLiveData<ArrayList<RecordEntity>> mutableLiveData3 = new MutableLiveData<>();
        this._mPhoneFastRecordLiveData = mutableLiveData3;
        this.phoneFastRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData3);
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>();
        this._mPageStatus = mutableLiveData4;
        this.mPageStatus = FastRecordAppUtilsKt.asLiveData(mutableLiveData4);
        MutableLiveData<ArrayList<RecordEntity>> mutableLiveData5 = new MutableLiveData<>();
        this._mChooseRecordEntityList = mutableLiveData5;
        this.mChooseRecordEntityList = FastRecordAppUtilsKt.asLiveData(mutableLiveData5);
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._clearSelectStatus = mutableLiveData6;
        this.mClearSelectStatus = FastRecordAppUtilsKt.asLiveData(mutableLiveData6);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkFastRecordVideoState(java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkFastRecordVideoState$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkFastRecordVideoState$1 r0 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkFastRecordVideoState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkFastRecordVideoState$1 r0 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$checkFastRecordVideoState$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0030
        L_0x0028:
            java.lang.Object r9 = r0.L$0
            java.util.Iterator r9 = (java.util.Iterator) r9
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0040
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.Iterator r8 = r9.iterator()
            r9 = r8
        L_0x0040:
            boolean r8 = r9.hasNext()
            if (r8 == 0) goto L_0x00ba
            java.lang.Object r8 = r9.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r8 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r8
            java.lang.String r1 = "checkFastRecordVideoState check video "
            java.lang.String r4 = "FastRecordMainViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r4)
            java.lang.String r1 = r8.getCacheLastWavChannelPath()
            if (r1 == 0) goto L_0x00a8
            int r5 = r1.length()
            if (r5 != 0) goto L_0x0060
            goto L_0x00a8
        L_0x0060:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "checkFastRecordVideoState wavPath is "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r7 = " "
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r5, r4)
            java.io.File r5 = new java.io.File
            r5.<init>(r1)
            boolean r5 = r5.exists()
            if (r5 != 0) goto L_0x0040
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = " is not exists "
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r4)
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil r1 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil.INSTANCE
            r0.L$0 = r9
            r0.label = r2
            java.lang.Object r8 = r1.mergeVoiceForShareFile(r8, r0)
            if (r8 != r10) goto L_0x0040
            return r10
        L_0x00a8:
            java.lang.String r1 = "checkFastRecordVideoState wavPath is null "
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r4)
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil r1 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil.INSTANCE
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r8 = r1.mergeVoiceForShareFile(r8, r0)
            if (r8 != r10) goto L_0x0040
            return r10
        L_0x00ba:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel.checkFastRecordVideoState(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void deleteFileData(RecordEntity recordEntity) {
        try {
            RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
            recordFileUtils.delete(recordEntity.getCacheLastMergeAllScenePcmChannelPath());
            recordFileUtils.delete(recordEntity.getCacheLastUpMergePcmChannelPath());
            recordFileUtils.delete(recordEntity.getCacheLastDownMergePcmChannelPath());
            recordFileUtils.delete(recordEntity.getCacheLastUpMergeWavChannelPath());
            recordFileUtils.delete(recordEntity.getCacheLastDownMergeWavChannelPath());
            recordFileUtils.delete(recordEntity.getCacheLastWavChannelPath());
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("deleteFileData error = " + message, TAG);
        }
    }

    private final int findIndexInList(ArrayList<RecordEntity> arrayList, RecordEntity recordEntity) {
        int i = 0;
        for (T next : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((RecordEntity) next).getRecordId() == recordEntity.getRecordId()) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final ArrayList<RecordContentTagEntity> getTagInfo(long j) {
        ArrayList<RecordContentTagEntity> arrayList = new ArrayList<>();
        List findNormalTagEntityByRecord$default = FastRecordTagDao.DefaultImpls.findNormalTagEntityByRecord$default(FastRecordManager.Companion.getInstance().fastRecordTagDao(), j, (String) null, 2, (Object) null);
        if (findNormalTagEntityByRecord$default != null) {
            arrayList.addAll(findNormalTagEntityByRecord$default);
        }
        return arrayList;
    }

    private final boolean isFinishState(RecordEntity recordEntity) {
        return recordEntity.getRecordStatus() == 2 || recordEntity.getRecordStatus() == 5;
    }

    /* access modifiers changed from: private */
    public final boolean isInRecordList(List<RecordEntity> list, RecordEntity recordEntity) {
        if (list == null) {
            return false;
        }
        for (RecordEntity recordId : list) {
            if (recordId.getRecordId() == recordEntity.getRecordId()) {
                long recordId2 = recordEntity.getRecordId();
                LogExt.logE("getCurRecordList isInRecordList record = " + recordId2, TAG);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object resetRecordStatus(java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$resetRecordStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$resetRecordStatus$1 r0 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$resetRecordStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$resetRecordStatus$1 r0 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$resetRecordStatus$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r12 = r0.L$1
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r0.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel r13 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0043
        L_0x0031:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.Iterator r13 = r13.iterator()
            r11 = r13
            r13 = r12
            r12 = r11
        L_0x0043:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x00cb
            java.lang.Object r14 = r12.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r14 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r14
            boolean r2 = r13.isFinishState(r14)
            if (r2 != 0) goto L_0x0043
            int r2 = r14.getRecordStatus()
            long r4 = r14.getRecordId()
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r6 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r7 = r6.getInstance()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r7 = r7.appViewModel()
            long r7 = r7.getRecordIngId()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "state = "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r2 = ",cur id = "
            r9.append(r2)
            r9.append(r4)
            java.lang.String r2 = ",recording id = "
            r9.append(r2)
            r9.append(r7)
            java.lang.String r2 = r9.toString()
            java.lang.String r4 = "FastRecordMainViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r2, r4)
            com.upuphone.ar.fastrecord.phone.FastRecordManager r2 = r6.getInstance()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r2 = r2.appViewModel()
            long r7 = r2.getRecordIngId()
            long r9 = r14.getRecordId()
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0043
            java.lang.String r2 = "set to STOP_REC_NO_CACHE"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r2, r4)
            r2 = 2
            r14.setRecordStatus(r2)
            com.upuphone.ar.fastrecord.phone.FastRecordManager r2 = r6.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r2 = r2.fastRecordDao()
            long r4 = r14.getRecordId()
            int r14 = r14.getRecordStatus()
            r0.L$0 = r13
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r14 = r2.updateRecordStatus(r4, r14, r0)
            if (r14 != r1) goto L_0x0043
            return r1
        L_0x00cb:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel.resetRecordStatus(java.util.ArrayList, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: com.upuphone.ar.fastrecord.phone.db.RecordEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: com.upuphone.ar.fastrecord.phone.db.RecordEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: com.upuphone.ar.fastrecord.phone.db.RecordEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: com.upuphone.ar.fastrecord.phone.db.RecordEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateRecordForDel() {
        /*
            r12 = this;
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity>> r0 = r12._mChooseRecordEntityList
            java.lang.Object r0 = r0.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 == 0) goto L_0x013e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity>> r2 = r12._mAllFastRecordLiveData
            java.lang.Object r2 = r2.getValue()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            if (r2 != 0) goto L_0x001f
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            goto L_0x0022
        L_0x001f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
        L_0x0022:
            r1.addAll(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity>> r3 = r12._mSceneFastRecordLiveData
            java.lang.Object r3 = r3.getValue()
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            if (r3 != 0) goto L_0x003a
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            goto L_0x003d
        L_0x003a:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
        L_0x003d:
            r2.addAll(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity>> r4 = r12._mPhoneFastRecordLiveData
            java.lang.Object r4 = r4.getValue()
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 != 0) goto L_0x0055
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            goto L_0x0058
        L_0x0055:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
        L_0x0058:
            r3.addAll(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x005f:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00e5
            java.lang.Object r4 = r0.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r4 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r4
            java.util.Iterator r5 = r1.iterator()
        L_0x006f:
            boolean r6 = r5.hasNext()
            r7 = 0
            if (r6 == 0) goto L_0x008a
            java.lang.Object r6 = r5.next()
            r8 = r6
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r8 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r8
            long r8 = r8.getRecordId()
            long r10 = r4.getRecordId()
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x006f
            goto L_0x008b
        L_0x008a:
            r6 = r7
        L_0x008b:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r6 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r6
            java.util.Collection r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r1)
            r5.remove(r6)
            java.util.Iterator r5 = r2.iterator()
        L_0x0098:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00b2
            java.lang.Object r6 = r5.next()
            r8 = r6
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r8 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r8
            long r8 = r8.getRecordId()
            long r10 = r4.getRecordId()
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x0098
            goto L_0x00b3
        L_0x00b2:
            r6 = r7
        L_0x00b3:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r6 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r6
            java.util.Collection r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r2)
            r5.remove(r6)
            java.util.Iterator r5 = r3.iterator()
        L_0x00c0:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00da
            java.lang.Object r6 = r5.next()
            r8 = r6
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r8 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r8
            long r8 = r8.getRecordId()
            long r10 = r4.getRecordId()
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x00c0
            r7 = r6
        L_0x00da:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r7 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r7
            java.util.Collection r4 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r3)
            r4.remove(r7)
            goto L_0x005f
        L_0x00e5:
            int r0 = r1.size()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "allRecordData.size = "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r4 = "FastRecordMainViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r4)
            int r0 = r2.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "sceneRecordData.size = "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r4)
            int r0 = r3.size()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "phoneRecordData.size = "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r4)
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity>> r0 = r12._mAllFastRecordLiveData
            r0.postValue(r1)
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity>> r0 = r12._mSceneFastRecordLiveData
            r0.postValue(r2)
            androidx.lifecycle.MutableLiveData<java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity>> r12 = r12._mPhoneFastRecordLiveData
            r12.postValue(r3)
        L_0x013e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel.updateRecordForDel():void");
    }

    public final void addSelectEntity(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "recordEntity");
        long recordId = recordEntity.getRecordId();
        String shortHandTitle = recordEntity.getShortHandTitle();
        LogExt.logW("addSelectEntity recordEntity id = " + recordId + ",title = " + shortHandTitle, TAG);
        ArrayList value = this.mChooseRecordEntityList.getValue();
        if (value == null) {
            value = new ArrayList();
        }
        int findIndexInList = findIndexInList(value, recordEntity);
        LogExt.logW("addSelectEntity index = " + findIndexInList, TAG);
        if (findIndexInList < 0) {
            value.add(recordEntity);
        }
        this._mChooseRecordEntityList.postValue(value);
    }

    public final void addSelectListEntity(@NotNull List<RecordEntity> list) {
        Intrinsics.checkNotNullParameter(list, "newDataList");
        ArrayList value = this.mChooseRecordEntityList.getValue();
        if (value == null) {
            value = new ArrayList();
        }
        value.clear();
        value.addAll(list);
        this._mChooseRecordEntityList.postValue(value);
    }

    public final void cancelShareJob() {
        LogExt.logE("cancelShareJob start", TAG);
        Job job = this.shareJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.shareJob = null;
        Job job2 = this.mergeVideoForShareJob;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
        }
        this.mergeVideoForShareJob = null;
    }

    public final void checkAndMergeFastRecordVideoFile(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callBack");
        this.mergeVideoForShareJob = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1(getChooseRecordEntityList(), this, function0, (Continuation<? super FastRecordMainViewModel$checkAndMergeFastRecordVideoFile$1>) null), 3, (Object) null);
    }

    public final void checkIsNewRecordItem(long j, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$checkIsNewRecordItem$1(j, function1, (Continuation<? super FastRecordMainViewModel$checkIsNewRecordItem$1>) null), 3, (Object) null);
    }

    public final void delRecord(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callBack");
        updateRecordForDel();
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$delRecord$1(this, function0, (Continuation<? super FastRecordMainViewModel$delRecord$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<ArrayList<RecordEntity>> getAllFastRecordData() {
        return this.allFastRecordData;
    }

    @NotNull
    public final ArrayList<RecordEntity> getChooseRecordEntityList() {
        ArrayList<RecordEntity> value = this._mChooseRecordEntityList.getValue();
        return value == null ? new ArrayList<>() : value;
    }

    public final int getChooseRecordEntityListSize() {
        ArrayList value = this._mChooseRecordEntityList.getValue();
        if (value == null) {
            value = new ArrayList();
        }
        return value.size();
    }

    @NotNull
    public final String getCurPage() {
        return this.mCurPage;
    }

    public final int getCurPageItemSize() {
        ArrayList value;
        ArrayList value2;
        ArrayList value3;
        String str = this.mCurPage;
        int hashCode = str.hashCode();
        if (hashCode != 3343801) {
            if (hashCode != 106642798) {
                if (hashCode == 109254796 && str.equals(RECORD_TYPE_SCENE) && (value3 = this._mSceneFastRecordLiveData.getValue()) != null) {
                    return value3.size();
                }
                return 0;
            } else if (str.equals("phone") && (value2 = this._mPhoneFastRecordLiveData.getValue()) != null) {
                return value2.size();
            } else {
                return 0;
            }
        } else if (str.equals(RECORD_TYPE_ALL) && (value = this._mAllFastRecordLiveData.getValue()) != null) {
            return value.size();
        } else {
            return 0;
        }
    }

    public final void getCurRecordList(@NotNull String str, @NotNull Function1<? super ArrayList<RecordEntity>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, FastRecordFragment.RECORD_TYPE);
        Intrinsics.checkNotNullParameter(function1, "callBack");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$getCurRecordList$1(str, this, function1, (Continuation<? super FastRecordMainViewModel$getCurRecordList$1>) null), 3, (Object) null);
    }

    public final void getFastRecordShareFilePath(@NotNull Context context, @NotNull String str, @NotNull Function1<? super ArrayList<Uri>, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ArrayList<RecordEntity> chooseRecordEntityList = getChooseRecordEntityList();
        int size = chooseRecordEntityList.size();
        LogExt.logE("getFastRecordShareFilePath type = " + str + " ,list size = " + size, TAG);
        this.shareJob = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$getFastRecordShareFilePath$1(chooseRecordEntityList, str, context, function1, (Continuation<? super FastRecordMainViewModel$getFastRecordShareFilePath$1>) null), 3, (Object) null);
    }

    @NotNull
    public final LiveData<ArrayList<RecordEntity>> getMChooseRecordEntityList() {
        return this.mChooseRecordEntityList;
    }

    @NotNull
    public final LiveData<Boolean> getMClearSelectStatus() {
        return this.mClearSelectStatus;
    }

    @NotNull
    public final LiveData<Integer> getMPageStatus() {
        return this.mPageStatus;
    }

    @NotNull
    public final LiveData<ArrayList<RecordEntity>> getPhoneFastRecordData() {
        return this.phoneFastRecordData;
    }

    @NotNull
    public final LiveData<ArrayList<RecordEntity>> getSceneFastRecordData() {
        return this.sceneFastRecordData;
    }

    public final void initFragmentAllData() {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$initFragmentAllData$1(this, (Continuation<? super FastRecordMainViewModel$initFragmentAllData$1>) null), 3, (Object) null);
    }

    public final void initFragmentDataByType(int i) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$initFragmentDataByType$1(i, this, (Continuation<? super FastRecordMainViewModel$initFragmentDataByType$1>) null), 3, (Object) null);
    }

    public final boolean isChoosePageState() {
        Integer value = this._mPageStatus.getValue();
        return value != null && 1 == value.intValue();
    }

    public final boolean isInChooseRecordEntityList(@NotNull RecordEntity recordEntity) {
        ArrayList value;
        ArrayList<RecordEntity> value2;
        Intrinsics.checkNotNullParameter(recordEntity, "data");
        if (this._mChooseRecordEntityList.getValue() != null && (((value = this._mChooseRecordEntityList.getValue()) == null || !value.isEmpty()) && (value2 = this._mChooseRecordEntityList.getValue()) != null)) {
            for (RecordEntity recordId : value2) {
                if (recordId.getRecordId() == recordEntity.getRecordId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void reQueryFastRecordList() {
        String str = this.mCurPage;
        LogExt.logW("initFastRecordList mCurPage= " + str, TAG);
        initFragmentAllData();
        initFragmentDataByType(1);
        initFragmentDataByType(0);
    }

    public final void removeSelectEntity(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "recordEntity");
        ArrayList value = this.mChooseRecordEntityList.getValue();
        if (value == null || value.size() <= 0) {
            this._mChooseRecordEntityList.postValue(new ArrayList());
            return;
        }
        int findIndexInList = findIndexInList(value, recordEntity);
        if (findIndexInList >= 0) {
            value.remove(findIndexInList);
        }
        int size = value.size();
        LogExt.logW("removeSelectEntity findIndex = " + findIndexInList + ",size = " + size, TAG);
        MutableLiveData<ArrayList<RecordEntity>> mutableLiveData = this._mChooseRecordEntityList;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(CollectionsKt.toSet(value));
        mutableLiveData.postValue(arrayList);
    }

    public final void selectAllItemStatus() {
        this._clearSelectStatus.postValue(Boolean.FALSE);
    }

    public final void setClearSelectStatus() {
        this._clearSelectStatus.postValue(Boolean.TRUE);
        this._mChooseRecordEntityList.postValue(new ArrayList());
    }

    public final void setCurPage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "curPage");
        this.mCurPage = str;
    }

    public final void setPageModeStatus(int i) {
        LogExt.logI("setPageModeStatus value = " + i, TAG);
        this._mPageStatus.postValue(Integer.valueOf(i));
    }

    public final void updateRecordIsNewRecordItemState(long j, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callBack");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$updateRecordIsNewRecordItemState$1(j, z, function0, (Continuation<? super FastRecordMainViewModel$updateRecordIsNewRecordItemState$1>) null), 3, (Object) null);
    }

    public final void updateRecordName(long j, @NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "callBack");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainViewModel$updateRecordName$1(j, str, function0, (Continuation<? super FastRecordMainViewModel$updateRecordName$1>) null), 3, (Object) null);
    }
}
