package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordPersonDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagDao;
import com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordHistoryPersonEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.ext.FastRecordAppUtilsKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 n2\u00020\u0001:\u0001nB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\"J(\u0010/\u001a\u00020,2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\n2\u0006\u00101\u001a\u00020\"H\u0002J(\u00102\u001a\u00020,2\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n2\u0006\u00101\u001a\u00020\"H\u0002J\u001e\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\"J \u00106\u001a\u00020,2\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nH\u0002J \u00108\u001a\u00020,2\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J \u00109\u001a\u00020,2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nH\u0002J \u0010;\u001a\u00020,2\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\nH\u0002J\u0006\u0010<\u001a\u00020,J\u000e\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020\tJ\u000e\u0010?\u001a\u00020,2\u0006\u0010>\u001a\u00020\u000eJ\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010AJ\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020CJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020FJ\u0010\u0010H\u001a\u00020F2\u0006\u0010-\u001a\u00020\u0012H\u0002J\u0010\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020\u0012H\u0002J\u0010\u0010K\u001a\u00020F2\u0006\u0010-\u001a\u00020\u0012H\u0002J\u0010\u0010L\u001a\u00020F2\u0006\u0010>\u001a\u00020\u000eH\u0002J\u0010\u0010M\u001a\u00020F2\u0006\u0010>\u001a\u00020\tH\u0002J\u001a\u0010N\u001a\u00020,2\u0006\u00101\u001a\u00020\"2\b\b\u0002\u0010O\u001a\u00020FH\u0002J\u001a\u0010P\u001a\u00020,2\u0006\u00101\u001a\u00020\"2\b\b\u0002\u0010O\u001a\u00020FH\u0002J\u000e\u0010Q\u001a\u00020,2\u0006\u00101\u001a\u00020\"J \u0010R\u001a\u00020,2\u0006\u00101\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00122\b\b\u0002\u0010O\u001a\u00020FJ\u0018\u0010S\u001a\u00020,2\u0006\u00101\u001a\u00020\"2\b\b\u0002\u0010T\u001a\u00020FJ \u0010U\u001a\u00020,2\u0016\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nH\u0002J \u0010W\u001a\u00020,2\u0016\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u000e\u0010X\u001a\u00020,2\u0006\u0010>\u001a\u00020\fJ\u000e\u0010Y\u001a\u00020,2\u0006\u0010>\u001a\u00020\u0010J\u0012\u0010Z\u001a\u00020,2\b\b\u0002\u0010[\u001a\u00020FH\u0002J\u001c\u0010\\\u001a\u00020,2\u0006\u0010]\u001a\u00020\u00122\f\u0010^\u001a\b\u0012\u0004\u0012\u00020,0_J$\u0010`\u001a\u00020,2\u0006\u0010a\u001a\u00020F2\u0006\u0010b\u001a\u00020F2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020,0_J\u0012\u0010c\u001a\u00020,2\b\b\u0002\u0010[\u001a\u00020FH\u0002J$\u0010d\u001a\u00020,2\u0006\u0010e\u001a\u00020\u00122\f\u0010^\u001a\b\u0012\u0004\u0012\u00020,0_2\u0006\u0010f\u001a\u00020\u0012J\b\u0010g\u001a\u00020,H\u0002J\u0010\u0010h\u001a\u00020,2\u0006\u0010f\u001a\u00020\u0012H\u0002J0\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\n2\u0016\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nH\u0002J0\u0010k\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010j\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u0015\u0010l\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010mR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n0\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\n0\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\n0\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\n0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u0019\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\n0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R+\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\n0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R+\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\n0\u0016¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0004\n\u0002\u0010#R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\bj\b\u0012\u0004\u0012\u00020\u000e`\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00100\bj\b\u0012\u0004\u0012\u00020\u0010`\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mCurFastRecordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "_mCurRecordContentHistoryTagEntityList", "Lcom/upuphone/ar/fastrecord/phone/utils/SingleLiveEvent;", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentHistoryTagEntity;", "Lkotlin/collections/ArrayList;", "_mCurRecordContentNormalTagEntityList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "_mCurRecordPersonHistoryTagList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordHistoryPersonEntity;", "_mCurRecordPersonNormalTagEntityList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "contentHistoryTagOrigin", "", "contentTagOrigin", "contentTagOriginList", "curRecordContentHistoryTagList", "Landroidx/lifecycle/LiveData;", "getCurRecordContentHistoryTagList", "()Landroidx/lifecycle/LiveData;", "curRecordContentNormalTagList", "getCurRecordContentNormalTagList", "curRecordData", "getCurRecordData", "curRecordPersonHistoryTagList", "getCurRecordPersonHistoryTagList", "curRecordPersonNormalTagEntityList", "getCurRecordPersonNormalTagEntityList", "mRecordId", "", "Ljava/lang/Long;", "needDelHistoryPersonList", "needDelHistoryTagList", "personHistoryTagOrigin", "personTagOrigin", "personTagOriginList", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addContentTag", "", "content", "createTime", "addInputPersonEntity", "mRecordPersonEntityList", "recordId", "addInputTypeContentTagEntity", "mRecordContentTagEntityList", "addPersonTag", "personType", "changeHistoryPersonEntityListValue", "contentTempHistoryList", "changeHistoryTagEntityListValue", "changeNormalTagEntityListValue", "contentTempList", "changePersonEntityListValue", "clearNeedDeleteData", "delHistoryContentTag", "data", "delPersonHistoryTag", "getPersonHistoryTagList", "", "getRealContentTagSize", "", "getRealPersonTagSize", "hasContentIsChange", "", "hasPersonIsChange", "isContainerInNormalOrgTag", "isContainerInNormalPerson", "personName", "isContainerInNormalTag", "isInDeleteHistoryPersonList", "isInDeleteHistoryTagList", "queryRecordHistoryContentList", "isFirstTime", "queryRecordHistoryPersonList", "queryRecordInfo", "queryRecordPersonTagInfo", "queryRecordTagInfo", "firstTime", "realDeleteHistoryPerson", "needDeleteList", "realDeleteTagHistory", "removeContentTag", "removePersonTag", "saveAllChangedNormalTagToHistory", "needResetHistory", "saveAllContentTagData", "inputContentTagValue", "callBack", "Lkotlin/Function0;", "saveAllHistoryDataForGiveUpChange", "isContentTag", "isPersonTag", "saveAllNormalPersonToHistory", "saveAllPersonData", "inputPersonTagValue", "curPersonType", "saveNormalContentTag", "saveNormalPersonTag", "selectDataNotInNeedDelHistoryPerson", "needCheckList", "selectDataNotInNeedDelHistoryTag", "setRecordId", "(Ljava/lang/Long;)V", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordTagViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,875:1\n1855#2,2:876\n1855#2,2:878\n1855#2,2:880\n1855#2,2:883\n1855#2,2:885\n1855#2,2:887\n1855#2,2:889\n1855#2,2:891\n1855#2,2:893\n1855#2,2:895\n1855#2,2:897\n1855#2,2:899\n1855#2,2:901\n1855#2,2:903\n1855#2,2:905\n1855#2,2:907\n1855#2,2:909\n1855#2:911\n1855#2,2:912\n1856#2:914\n1855#2,2:915\n1855#2:917\n1855#2,2:918\n1856#2:920\n1855#2,2:921\n1855#2,2:923\n1855#2,2:925\n1855#2,2:927\n1855#2,2:929\n1855#2,2:931\n1855#2,2:933\n1#3:882\n*S KotlinDebug\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel\n*L\n136#1:876,2\n148#1:878,2\n206#1:880,2\n217#1:883,2\n253#1:885,2\n262#1:887,2\n363#1:889,2\n373#1:891,2\n386#1:893,2\n409#1:895,2\n422#1:897,2\n432#1:899,2\n457#1:901,2\n486#1:903,2\n506#1:905,2\n516#1:907,2\n545#1:909,2\n571#1:911\n575#1:912,2\n571#1:914\n597#1:915,2\n624#1:917\n627#1:918,2\n624#1:920\n651#1:921,2\n713#1:923,2\n726#1:925,2\n751#1:927,2\n783#1:929,2\n823#1:931,2\n852#1:933,2\n*E\n"})
public final class FastRecordTagViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_SIZE = 10;
    @NotNull
    private static final String TAG = "FastRecordTagViewModel";
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<RecordEntity> _mCurFastRecordLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<ArrayList<RecordContentHistoryTagEntity>> _mCurRecordContentHistoryTagEntityList;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<ArrayList<RecordContentTagEntity>> _mCurRecordContentNormalTagEntityList;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<ArrayList<RecordHistoryPersonEntity>> _mCurRecordPersonHistoryTagList;
    /* access modifiers changed from: private */
    @NotNull
    public SingleLiveEvent<ArrayList<RecordPersonEntity>> _mCurRecordPersonNormalTagEntityList;
    /* access modifiers changed from: private */
    @NotNull
    public String contentHistoryTagOrigin = "";
    /* access modifiers changed from: private */
    @NotNull
    public String contentTagOrigin = "";
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<RecordContentTagEntity> contentTagOriginList = new ArrayList<>();
    @NotNull
    private final LiveData<ArrayList<RecordContentHistoryTagEntity>> curRecordContentHistoryTagList;
    @NotNull
    private final LiveData<ArrayList<RecordContentTagEntity>> curRecordContentNormalTagList;
    @NotNull
    private final LiveData<RecordEntity> curRecordData;
    @NotNull
    private final LiveData<ArrayList<RecordHistoryPersonEntity>> curRecordPersonHistoryTagList;
    @NotNull
    private final LiveData<ArrayList<RecordPersonEntity>> curRecordPersonNormalTagEntityList;
    @Nullable
    private Long mRecordId;
    /* access modifiers changed from: private */
    @NotNull
    public final ArrayList<RecordHistoryPersonEntity> needDelHistoryPersonList;
    /* access modifiers changed from: private */
    @NotNull
    public final ArrayList<RecordContentHistoryTagEntity> needDelHistoryTagList;
    /* access modifiers changed from: private */
    @NotNull
    public String personHistoryTagOrigin = "";
    /* access modifiers changed from: private */
    @NotNull
    public String personTagOrigin = "";
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<RecordPersonEntity> personTagOriginList = new ArrayList<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$Companion;", "", "()V", "MAX_SIZE", "", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordTagViewModel() {
        MutableLiveData<RecordEntity> mutableLiveData = new MutableLiveData<>();
        this._mCurFastRecordLiveData = mutableLiveData;
        this.curRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData);
        SingleLiveEvent<ArrayList<RecordHistoryPersonEntity>> singleLiveEvent = new SingleLiveEvent<>();
        this._mCurRecordPersonHistoryTagList = singleLiveEvent;
        this.curRecordPersonHistoryTagList = FastRecordAppUtilsKt.asLiveData(singleLiveEvent);
        SingleLiveEvent<ArrayList<RecordPersonEntity>> singleLiveEvent2 = new SingleLiveEvent<>();
        this._mCurRecordPersonNormalTagEntityList = singleLiveEvent2;
        this.curRecordPersonNormalTagEntityList = FastRecordAppUtilsKt.asLiveData(singleLiveEvent2);
        SingleLiveEvent<ArrayList<RecordContentHistoryTagEntity>> singleLiveEvent3 = new SingleLiveEvent<>();
        this._mCurRecordContentHistoryTagEntityList = singleLiveEvent3;
        this.curRecordContentHistoryTagList = FastRecordAppUtilsKt.asLiveData(singleLiveEvent3);
        SingleLiveEvent<ArrayList<RecordContentTagEntity>> singleLiveEvent4 = new SingleLiveEvent<>();
        this._mCurRecordContentNormalTagEntityList = singleLiveEvent4;
        this.curRecordContentNormalTagList = FastRecordAppUtilsKt.asLiveData(singleLiveEvent4);
        this.needDelHistoryTagList = new ArrayList<>();
        this.needDelHistoryPersonList = new ArrayList<>();
    }

    /* access modifiers changed from: private */
    public final void addInputPersonEntity(ArrayList<RecordPersonEntity> arrayList, long j) {
        ArrayList<RecordPersonEntity> arrayList2 = arrayList;
        arrayList.add(new RecordPersonEntity(0, j, "", "", LongCompanionObject.MAX_VALUE, true, (String) null, 64, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final void addInputTypeContentTagEntity(ArrayList<RecordContentTagEntity> arrayList, long j) {
        arrayList.add(new RecordContentTagEntity(0, j, "", LongCompanionObject.MAX_VALUE, true, (String) null, 32, (DefaultConstructorMarker) null));
    }

    private final void changeHistoryPersonEntityListValue(ArrayList<RecordHistoryPersonEntity> arrayList) {
        String name = Thread.currentThread().getName();
        LogExt.logE("changeHistoryPersonEntityListValue curThread = " + name, TAG);
        this._mCurRecordPersonHistoryTagList.setValue(arrayList);
        this._mCurRecordPersonHistoryTagList.postValue(arrayList);
    }

    private final void changeHistoryTagEntityListValue(ArrayList<RecordContentHistoryTagEntity> arrayList) {
        String name = Thread.currentThread().getName();
        LogExt.logE("changeHistoryTagEntityListValue curThread = " + name, TAG);
        this._mCurRecordContentHistoryTagEntityList.setValue(arrayList);
        this._mCurRecordContentHistoryTagEntityList.postValue(arrayList);
    }

    private final void changeNormalTagEntityListValue(ArrayList<RecordContentTagEntity> arrayList) {
        String name = Thread.currentThread().getName();
        LogExt.logE("changeNormalTagEntityListValue curThread = " + name, TAG);
        this._mCurRecordContentNormalTagEntityList.setValue(arrayList);
        this._mCurRecordContentNormalTagEntityList.postValue(arrayList);
    }

    private final void changePersonEntityListValue(ArrayList<RecordPersonEntity> arrayList) {
        String name = Thread.currentThread().getName();
        LogExt.logE("changePersonEntityListValue curThread = " + name, TAG);
        this._mCurRecordPersonNormalTagEntityList.setValue(arrayList);
        this._mCurRecordPersonNormalTagEntityList.postValue(arrayList);
    }

    private final boolean isContainerInNormalOrgTag(String str) {
        for (RecordContentTagEntity contentName : this.contentTagOriginList) {
            if (Intrinsics.areEqual((Object) contentName.getContentName(), (Object) str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isContainerInNormalPerson(String str) {
        for (RecordPersonEntity personName : this.personTagOriginList) {
            if (Intrinsics.areEqual((Object) personName.getPersonName(), (Object) str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isContainerInNormalTag(String str) {
        for (RecordContentTagEntity contentName : this.contentTagOriginList) {
            if (Intrinsics.areEqual((Object) contentName.getContentName(), (Object) str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isInDeleteHistoryPersonList(RecordHistoryPersonEntity recordHistoryPersonEntity) {
        if (this.needDelHistoryPersonList.isEmpty()) {
            return false;
        }
        for (RecordHistoryPersonEntity personName : this.needDelHistoryPersonList) {
            if (Intrinsics.areEqual((Object) personName.getPersonName(), (Object) recordHistoryPersonEntity.getPersonName())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isInDeleteHistoryTagList(RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
        if (this.needDelHistoryTagList.isEmpty()) {
            return false;
        }
        for (RecordContentHistoryTagEntity contentName : this.needDelHistoryTagList) {
            if (Intrinsics.areEqual((Object) contentName.getContentName(), (Object) recordContentHistoryTagEntity.getContentName())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void queryRecordHistoryContentList(long j, boolean z) {
        ArrayList<RecordContentTagEntity> arrayList = this.contentTagOriginList;
        LogExt.logE("queryRecordHistoryContentList new 2 recordId = " + j + ",data = " + arrayList, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTagViewModel$queryRecordHistoryContentList$1(j, this, z, (Continuation<? super FastRecordTagViewModel$queryRecordHistoryContentList$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void queryRecordHistoryContentList$default(FastRecordTagViewModel fastRecordTagViewModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        fastRecordTagViewModel.queryRecordHistoryContentList(j, z);
    }

    /* access modifiers changed from: private */
    public final void queryRecordHistoryPersonList(long j, boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTagViewModel$queryRecordHistoryPersonList$1(j, z, this, (Continuation<? super FastRecordTagViewModel$queryRecordHistoryPersonList$1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void queryRecordHistoryPersonList$default(FastRecordTagViewModel fastRecordTagViewModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        fastRecordTagViewModel.queryRecordHistoryPersonList(j, z);
    }

    public static /* synthetic */ void queryRecordPersonTagInfo$default(FastRecordTagViewModel fastRecordTagViewModel, long j, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        fastRecordTagViewModel.queryRecordPersonTagInfo(j, str, z);
    }

    public static /* synthetic */ void queryRecordTagInfo$default(FastRecordTagViewModel fastRecordTagViewModel, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        fastRecordTagViewModel.queryRecordTagInfo(j, z);
    }

    /* access modifiers changed from: private */
    public final void realDeleteHistoryPerson(ArrayList<RecordHistoryPersonEntity> arrayList) {
        for (RecordHistoryPersonEntity recordHistoryPersonEntity : arrayList) {
            FastRecordManager.Companion companion = FastRecordManager.Companion;
            companion.getInstance().fastRecordPersonHistoryDao().delete(recordHistoryPersonEntity);
            FastRecordPersonDao fastRecordPersonDao = companion.getInstance().fastRecordPersonDao();
            String personName = recordHistoryPersonEntity.getPersonName();
            if (personName == null) {
                personName = "";
            }
            FastRecordPersonDao.DefaultImpls.deleteAllNormalTagByPersonName$default(fastRecordPersonDao, (String) null, personName, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void realDeleteTagHistory(ArrayList<RecordContentHistoryTagEntity> arrayList) {
        for (RecordContentHistoryTagEntity recordContentHistoryTagEntity : arrayList) {
            FastRecordManager.Companion companion = FastRecordManager.Companion;
            companion.getInstance().fastRecordTagHistoryDao().delete(recordContentHistoryTagEntity);
            FastRecordTagDao fastRecordTagDao = companion.getInstance().fastRecordTagDao();
            String contentName = recordContentHistoryTagEntity.getContentName();
            if (contentName == null) {
                contentName = "";
            }
            FastRecordTagDao.DefaultImpls.deleteAllNormalTagByContentName$default(fastRecordTagDao, (String) null, contentName, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void saveAllChangedNormalTagToHistory(boolean z) {
        ArrayList<RecordContentHistoryTagEntity> arrayList = new ArrayList<>();
        ArrayList value = this._mCurRecordContentHistoryTagEntityList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        if (z) {
            int size = this.needDelHistoryTagList.size();
            LogExt.logE("saveAllChangedNormalTagToHistory needResetHistory needDelHistoryTagList size = " + size, TAG);
            arrayList.addAll(CollectionsKt.toSet(this.needDelHistoryTagList));
        }
        ArrayList<RecordContentTagEntity> value2 = this._mCurRecordContentNormalTagEntityList.getValue();
        LogExt.logE("saveAllChangedNormalTagToHistory newAddTag content = " + value2, TAG);
        ArrayList<RecordContentTagEntity> arrayList2 = new ArrayList<>();
        ArrayList value3 = this._mCurRecordContentNormalTagEntityList.getValue();
        if (value3 != null) {
            arrayList2.addAll(value3);
        }
        for (RecordContentTagEntity recordContentTagEntity : arrayList2) {
            ArrayList arrayList3 = new ArrayList();
            for (RecordContentHistoryTagEntity recordContentHistoryTagEntity : arrayList) {
                String contentName = recordContentHistoryTagEntity.getContentName();
                if (!(contentName == null || contentName.length() == 0 || !Intrinsics.areEqual((Object) recordContentHistoryTagEntity.getContentName(), (Object) recordContentTagEntity.getContentName()))) {
                    arrayList3.add(recordContentHistoryTagEntity);
                }
            }
            arrayList.removeAll(CollectionsKt.toSet(arrayList3));
            arrayList.add(new RecordContentHistoryTagEntity(0, recordContentTagEntity.getContentName(), recordContentTagEntity.getCreateTime(), (String) null, 9, (DefaultConstructorMarker) null));
        }
        CollectionsKt.sort(arrayList);
        FastRecordManager.Companion.getInstance().fastRecordTagHistoryDao().deleteAllData();
        int size2 = arrayList.size();
        LogExt.logE("saveAllChangedNormalTagToHistory curRecordContentHistoryList = " + arrayList + ",size = " + size2, TAG);
        for (RecordContentHistoryTagEntity recordContentHistoryTagEntity2 : arrayList) {
            String contentName2 = recordContentHistoryTagEntity2.getContentName();
            if (!(contentName2 == null || contentName2.length() == 0)) {
                FastRecordManager.Companion.getInstance().fastRecordTagHistoryDao().insert(recordContentHistoryTagEntity2);
            }
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5(this, arrayList, (Continuation<? super FastRecordTagViewModel$saveAllChangedNormalTagToHistory$5>) null), 3, (Object) null);
    }

    public static /* synthetic */ void saveAllChangedNormalTagToHistory$default(FastRecordTagViewModel fastRecordTagViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        fastRecordTagViewModel.saveAllChangedNormalTagToHistory(z);
    }

    /* access modifiers changed from: private */
    public final void saveAllNormalPersonToHistory(boolean z) {
        ArrayList<RecordHistoryPersonEntity> arrayList = new ArrayList<>();
        ArrayList value = this._mCurRecordPersonHistoryTagList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        if (z) {
            int size = this.needDelHistoryPersonList.size();
            LogExt.logE("saveAllChangedNormalTagToHistory needResetHistory needDelHistoryPersonList size = " + size, TAG);
            arrayList.addAll(CollectionsKt.toSet(this.needDelHistoryPersonList));
        }
        ArrayList<RecordPersonEntity> value2 = this._mCurRecordPersonNormalTagEntityList.getValue();
        LogExt.logE("saveAllNormalPersonToHistory value  = " + value2, TAG);
        ArrayList<RecordPersonEntity> arrayList2 = new ArrayList<>();
        ArrayList value3 = this._mCurRecordPersonNormalTagEntityList.getValue();
        if (value3 != null) {
            arrayList2.addAll(value3);
        }
        for (RecordPersonEntity recordPersonEntity : arrayList2) {
            ArrayList arrayList3 = new ArrayList();
            for (RecordHistoryPersonEntity recordHistoryPersonEntity : arrayList) {
                String personName = recordHistoryPersonEntity.getPersonName();
                if (!(personName == null || personName.length() == 0 || !Intrinsics.areEqual((Object) recordHistoryPersonEntity.getPersonName(), (Object) recordPersonEntity.getPersonName()))) {
                    arrayList3.add(recordHistoryPersonEntity);
                }
            }
            arrayList.removeAll(CollectionsKt.toSet(arrayList3));
            arrayList.add(new RecordHistoryPersonEntity(0, recordPersonEntity.getPersonName(), recordPersonEntity.getCreateTime(), (String) null, 9, (DefaultConstructorMarker) null));
        }
        CollectionsKt.sort(arrayList);
        FastRecordManager.Companion.getInstance().fastRecordPersonHistoryDao().deleteAllData();
        int size2 = arrayList.size();
        LogExt.logE("saveAllNormalPersonToHistory curRecordContentHistoryList = " + arrayList + ",size = " + size2, TAG);
        for (RecordHistoryPersonEntity recordHistoryPersonEntity2 : arrayList) {
            String personName2 = recordHistoryPersonEntity2.getPersonName();
            if (!(personName2 == null || personName2.length() == 0)) {
                FastRecordManager.Companion.getInstance().fastRecordPersonHistoryDao().insert(recordHistoryPersonEntity2);
            }
        }
        this._mCurRecordPersonHistoryTagList.postValue(arrayList);
    }

    public static /* synthetic */ void saveAllNormalPersonToHistory$default(FastRecordTagViewModel fastRecordTagViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        fastRecordTagViewModel.saveAllNormalPersonToHistory(z);
    }

    /* access modifiers changed from: private */
    public final void saveNormalContentTag() {
        ArrayList<RecordContentTagEntity> value = this._mCurRecordContentNormalTagEntityList.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        Long l = this.mRecordId;
        if (l != null) {
            FastRecordManager.Companion.getInstance().fastRecordTagDao().deleteAllNormalTag(l.longValue());
        }
        for (RecordContentTagEntity recordContentTagEntity : value) {
            String contentName = recordContentTagEntity.getContentName();
            LogExt.logE("saveNormalContentTag content name = " + contentName, TAG);
            String contentName2 = recordContentTagEntity.getContentName();
            if (!(contentName2 == null || contentName2.length() == 0)) {
                FastRecordManager.Companion.getInstance().fastRecordTagDao().insert(recordContentTagEntity);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void saveNormalPersonTag(String str) {
        Long l = this.mRecordId;
        if (l != null) {
            FastRecordManager.Companion.getInstance().fastRecordPersonDao().deleteAllNormalTag(l.longValue(), str);
        }
        ArrayList<RecordPersonEntity> arrayList = new ArrayList<>();
        ArrayList value = this._mCurRecordPersonNormalTagEntityList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        for (RecordPersonEntity recordPersonEntity : arrayList) {
            String personName = recordPersonEntity.getPersonName();
            if (!(personName == null || personName.length() == 0)) {
                FastRecordManager.Companion.getInstance().fastRecordPersonDao().insert(recordPersonEntity);
            }
        }
    }

    /* access modifiers changed from: private */
    public final ArrayList<RecordHistoryPersonEntity> selectDataNotInNeedDelHistoryPerson(ArrayList<RecordHistoryPersonEntity> arrayList) {
        ArrayList<RecordHistoryPersonEntity> arrayList2 = new ArrayList<>();
        for (RecordHistoryPersonEntity recordHistoryPersonEntity : arrayList) {
            if (!isInDeleteHistoryPersonList(recordHistoryPersonEntity)) {
                String personName = recordHistoryPersonEntity.getPersonName();
                LogExt.logE("selectDataInNeedDelHistoryPerson name = " + personName + " is not in delete list", TAG);
                arrayList2.add(recordHistoryPersonEntity);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public final ArrayList<RecordContentHistoryTagEntity> selectDataNotInNeedDelHistoryTag(ArrayList<RecordContentHistoryTagEntity> arrayList) {
        ArrayList<RecordContentHistoryTagEntity> arrayList2 = new ArrayList<>();
        for (RecordContentHistoryTagEntity recordContentHistoryTagEntity : arrayList) {
            if (!isInDeleteHistoryTagList(recordContentHistoryTagEntity)) {
                String contentName = recordContentHistoryTagEntity.getContentName();
                LogExt.logE("selectDataInNeedDelHistoryTag name = " + contentName + " is not in delete list", TAG);
                arrayList2.add(recordContentHistoryTagEntity);
            }
        }
        return arrayList2;
    }

    public final void addContentTag(@NotNull String str, long j) {
        String contentName;
        String contentName2;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "content");
        LogExt.logE("addContentTag content=" + str2 + ",createTime=" + j, TAG);
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (TextUtils.isEmpty(obj)) {
            LogExt.logE("addContentTag isEmpty return", TAG);
            this._mCurRecordContentNormalTagEntityList.postValue(this._mCurRecordContentNormalTagEntityList.getValue());
            return;
        }
        ArrayList value = this._mCurRecordContentNormalTagEntityList.getValue();
        if (value != null) {
            ArrayList<RecordContentTagEntity> arrayList = new ArrayList<>();
            arrayList.addAll(value);
            ArrayList arrayList2 = new ArrayList();
            for (RecordContentTagEntity recordContentTagEntity : arrayList) {
                if (Intrinsics.areEqual((Object) recordContentTagEntity.getContentName(), (Object) obj) || (contentName2 = recordContentTagEntity.getContentName()) == null || contentName2.length() == 0) {
                    arrayList2.add(recordContentTagEntity);
                }
            }
            arrayList.removeAll(CollectionsKt.toSet(arrayList2));
            Long l = this.mRecordId;
            if (l != null) {
                long longValue = l.longValue();
                arrayList.add(new RecordContentTagEntity(0, longValue, obj, j, false, (String) null, 33, (DefaultConstructorMarker) null));
                addInputTypeContentTagEntity(arrayList, longValue);
            }
            changeNormalTagEntityListValue(arrayList);
        }
        ArrayList<RecordContentHistoryTagEntity> arrayList3 = new ArrayList<>();
        ArrayList value2 = this._mCurRecordContentHistoryTagEntityList.getValue();
        if (value2 != null) {
            arrayList3.addAll(value2);
        }
        ArrayList arrayList4 = new ArrayList();
        for (RecordContentHistoryTagEntity recordContentHistoryTagEntity : arrayList3) {
            if (Intrinsics.areEqual((Object) recordContentHistoryTagEntity.getContentName(), (Object) obj) || (contentName = recordContentHistoryTagEntity.getContentName()) == null || contentName.length() == 0) {
                arrayList4.add(recordContentHistoryTagEntity);
            }
        }
        arrayList3.removeAll(CollectionsKt.toSet(arrayList4));
        CollectionsKt.sort(arrayList3);
        changeHistoryTagEntityListValue(arrayList3);
    }

    public final void addPersonTag(@NotNull String str, @NotNull String str2, long j) {
        String str3;
        String personName;
        ArrayList arrayList;
        String personName2;
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "content");
        Intrinsics.checkNotNullParameter(str2, "personType");
        LogExt.logE("addPersonTag content=" + str4 + ",createTime=" + j, TAG);
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (TextUtils.isEmpty(obj)) {
            LogExt.logE("addPersonTag isEmpty return", TAG);
            this._mCurRecordPersonNormalTagEntityList.postValue(this._mCurRecordPersonNormalTagEntityList.getValue());
            return;
        }
        ArrayList value = this._mCurRecordPersonNormalTagEntityList.getValue();
        if (value != null) {
            ArrayList<RecordPersonEntity> arrayList2 = new ArrayList<>();
            arrayList2.addAll(value);
            ArrayList arrayList3 = new ArrayList();
            for (RecordPersonEntity recordPersonEntity : arrayList2) {
                if (Intrinsics.areEqual((Object) recordPersonEntity.getPersonName(), (Object) obj) || (personName2 = recordPersonEntity.getPersonName()) == null || personName2.length() == 0) {
                    arrayList3.add(recordPersonEntity);
                }
            }
            arrayList2.removeAll(CollectionsKt.toSet(arrayList3));
            Long l = this.mRecordId;
            if (l != null) {
                long longValue = l.longValue();
                str3 = obj;
                arrayList = arrayList2;
                arrayList.add(new RecordPersonEntity(0, longValue, obj, str2, j, false, (String) null, 65, (DefaultConstructorMarker) null));
                addInputPersonEntity(arrayList, longValue);
            } else {
                str3 = obj;
                arrayList = arrayList2;
            }
            changePersonEntityListValue(arrayList);
        } else {
            str3 = obj;
        }
        ArrayList value2 = this._mCurRecordPersonHistoryTagList.getValue();
        if (value2 != null) {
            ArrayList<RecordHistoryPersonEntity> arrayList4 = new ArrayList<>();
            arrayList4.addAll(value2);
            ArrayList arrayList5 = new ArrayList();
            for (RecordHistoryPersonEntity recordHistoryPersonEntity : arrayList4) {
                String str5 = str3;
                if (Intrinsics.areEqual((Object) recordHistoryPersonEntity.getPersonName(), (Object) str5) || (personName = recordHistoryPersonEntity.getPersonName()) == null || personName.length() == 0) {
                    arrayList5.add(recordHistoryPersonEntity);
                }
                str3 = str5;
            }
            arrayList4.removeAll(CollectionsKt.toSet(arrayList5));
            CollectionsKt.sort(arrayList4);
            changeHistoryPersonEntityListValue(arrayList4);
        }
    }

    public final void clearNeedDeleteData() {
        this.needDelHistoryPersonList.clear();
        this.needDelHistoryTagList.clear();
    }

    public final void delHistoryContentTag(@NotNull RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
        Intrinsics.checkNotNullParameter(recordContentHistoryTagEntity, "data");
        this.needDelHistoryTagList.add(recordContentHistoryTagEntity);
        ArrayList arrayList = new ArrayList();
        ArrayList value = this._mCurRecordContentHistoryTagEntityList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        arrayList.remove(recordContentHistoryTagEntity);
        this._mCurRecordContentHistoryTagEntityList.postValue(arrayList);
    }

    public final void delPersonHistoryTag(@NotNull RecordHistoryPersonEntity recordHistoryPersonEntity) {
        Intrinsics.checkNotNullParameter(recordHistoryPersonEntity, "data");
        this.needDelHistoryPersonList.add(recordHistoryPersonEntity);
        ArrayList arrayList = new ArrayList();
        ArrayList value = this._mCurRecordPersonHistoryTagList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        arrayList.remove(recordHistoryPersonEntity);
        this._mCurRecordPersonHistoryTagList.postValue(arrayList);
    }

    @NotNull
    public final LiveData<ArrayList<RecordContentHistoryTagEntity>> getCurRecordContentHistoryTagList() {
        return this.curRecordContentHistoryTagList;
    }

    @NotNull
    public final LiveData<ArrayList<RecordContentTagEntity>> getCurRecordContentNormalTagList() {
        return this.curRecordContentNormalTagList;
    }

    @NotNull
    public final LiveData<RecordEntity> getCurRecordData() {
        return this.curRecordData;
    }

    @NotNull
    public final LiveData<ArrayList<RecordHistoryPersonEntity>> getCurRecordPersonHistoryTagList() {
        return this.curRecordPersonHistoryTagList;
    }

    @NotNull
    public final LiveData<ArrayList<RecordPersonEntity>> getCurRecordPersonNormalTagEntityList() {
        return this.curRecordPersonNormalTagEntityList;
    }

    @Nullable
    public final List<RecordHistoryPersonEntity> getPersonHistoryTagList() {
        return this._mCurRecordPersonHistoryTagList.getValue();
    }

    public final int getRealContentTagSize() {
        ArrayList arrayList = new ArrayList();
        ArrayList<RecordContentTagEntity> value = this._mCurRecordContentNormalTagEntityList.getValue();
        if (value != null) {
            for (RecordContentTagEntity recordContentTagEntity : value) {
                if (!recordContentTagEntity.isNewEditBean()) {
                    arrayList.add(recordContentTagEntity);
                }
            }
        }
        return arrayList.size();
    }

    public final int getRealPersonTagSize() {
        ArrayList arrayList = new ArrayList();
        ArrayList<RecordPersonEntity> arrayList2 = new ArrayList<>();
        ArrayList value = this._mCurRecordPersonNormalTagEntityList.getValue();
        if (value != null) {
            arrayList2.addAll(value);
        }
        for (RecordPersonEntity recordPersonEntity : arrayList2) {
            if (!recordPersonEntity.isNewEditBean()) {
                arrayList.add(recordPersonEntity);
            }
        }
        return arrayList.size();
    }

    public final boolean hasContentIsChange() {
        StringBuilder sb = new StringBuilder();
        ArrayList<RecordContentTagEntity> value = this._mCurRecordContentNormalTagEntityList.getValue();
        if (value != null) {
            for (RecordContentTagEntity recordContentTagEntity : value) {
                LogExt.logE("hasContentIsChange name = " + recordContentTagEntity.getContentName(), TAG);
                String contentName = recordContentTagEntity.getContentName();
                if (!(contentName == null || contentName.length() == 0)) {
                    sb.append(recordContentTagEntity.getContentName());
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        LogExt.logE(" hasContentIsChange cur value = " + StringsKt.trim((CharSequence) sb2).toString() + ",contentTagOrigin = " + this.contentTagOrigin, TAG);
        StringBuilder sb3 = new StringBuilder();
        ArrayList<RecordContentHistoryTagEntity> value2 = this._mCurRecordContentHistoryTagEntityList.getValue();
        if (value2 != null) {
            for (RecordContentHistoryTagEntity recordContentHistoryTagEntity : value2) {
                String contentName2 = recordContentHistoryTagEntity.getContentName();
                if (!(contentName2 == null || contentName2.length() == 0)) {
                    sb3.append(recordContentHistoryTagEntity.getContentName());
                }
            }
        }
        String sb4 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
        boolean z = !Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) sb4).toString(), (Object) StringsKt.trim((CharSequence) this.contentTagOrigin).toString());
        String sb5 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "toString(...)");
        boolean z2 = !Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) sb5).toString(), (Object) StringsKt.trim((CharSequence) this.contentHistoryTagOrigin).toString());
        String sb6 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "toString(...)");
        String obj = StringsKt.trim((CharSequence) sb6).toString();
        String sb7 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "toString(...)");
        LogExt.logE(" hasContentIsChange cur value = " + obj + ",sbHistoryInfo = " + StringsKt.trim((CharSequence) sb7).toString() + ",contentHistoryTagOrigin = " + this.contentHistoryTagOrigin + ",contentTagOrigin = " + this.contentTagOrigin + ",contentChange = " + z + ",contentHistoryChange = " + z2, TAG);
        return z || z2;
    }

    public final boolean hasPersonIsChange() {
        StringBuilder sb = new StringBuilder();
        ArrayList<RecordPersonEntity> arrayList = new ArrayList<>();
        ArrayList value = this._mCurRecordPersonNormalTagEntityList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        for (RecordPersonEntity recordPersonEntity : arrayList) {
            LogExt.logE("hasPersonIsChange name = " + recordPersonEntity.getPersonName(), TAG);
            String personName = recordPersonEntity.getPersonName();
            if (!(personName == null || personName.length() == 0)) {
                sb.append(recordPersonEntity.getPersonName());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        ArrayList<RecordHistoryPersonEntity> arrayList2 = new ArrayList<>();
        ArrayList value2 = this._mCurRecordPersonHistoryTagList.getValue();
        if (value2 != null) {
            arrayList2.addAll(value2);
        }
        for (RecordHistoryPersonEntity recordHistoryPersonEntity : arrayList2) {
            LogExt.logE("hasPersonIsChange history name = " + recordHistoryPersonEntity.getPersonName(), TAG);
            String personName2 = recordHistoryPersonEntity.getPersonName();
            if (!(personName2 == null || personName2.length() == 0)) {
                sb2.append(recordHistoryPersonEntity.getPersonName());
            }
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        boolean z = !Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) sb3).toString(), (Object) StringsKt.trim((CharSequence) this.personTagOrigin).toString());
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
        boolean z2 = !Intrinsics.areEqual((Object) StringsKt.trim((CharSequence) sb4).toString(), (Object) StringsKt.trim((CharSequence) this.personHistoryTagOrigin).toString());
        String sb5 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "toString(...)");
        String obj = StringsKt.trim((CharSequence) sb5).toString();
        String sb6 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "toString(...)");
        LogExt.logE(" hasPersonIsChange cur value = " + obj + ",sbNormalHistoryInfo = " + StringsKt.trim((CharSequence) sb6).toString() + ",personHistoryTagOrigin = " + this.personHistoryTagOrigin + ",personTagOrigin = " + this.personTagOrigin + ",personNormalChange = " + z + ",personHistoryChange = " + z2, TAG);
        return z || z2;
    }

    public final void queryRecordInfo(long j) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTagViewModel$queryRecordInfo$1(j, this, (Continuation<? super FastRecordTagViewModel$queryRecordInfo$1>) null), 3, (Object) null);
    }

    public final void queryRecordPersonTagInfo(long j, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "personType");
        LogExt.logE("queryRecordNormalPersonTagInfo recordId = " + j + ",personType = " + str, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTagViewModel$queryRecordPersonTagInfo$1(j, str, z, this, (Continuation<? super FastRecordTagViewModel$queryRecordPersonTagInfo$1>) null), 3, (Object) null);
    }

    public final void queryRecordTagInfo(long j, boolean z) {
        LogExt.logE("queryRecordNormalContentTagInfo recordId = " + j + ",firstTime = " + z, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTagViewModel$queryRecordTagInfo$1(j, this, z, (Continuation<? super FastRecordTagViewModel$queryRecordTagInfo$1>) null), 3, (Object) null);
    }

    public final void removeContentTag(@NotNull RecordContentTagEntity recordContentTagEntity) {
        Intrinsics.checkNotNullParameter(recordContentTagEntity, "data");
        ArrayList arrayList = new ArrayList();
        ArrayList value = this._mCurRecordContentNormalTagEntityList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        if (arrayList.contains(recordContentTagEntity)) {
            arrayList.remove(recordContentTagEntity);
        }
        this._mCurRecordContentNormalTagEntityList.postValue(arrayList);
        ArrayList<RecordContentHistoryTagEntity> arrayList2 = new ArrayList<>();
        ArrayList value2 = this._mCurRecordContentHistoryTagEntityList.getValue();
        if (value2 != null) {
            arrayList2.addAll(value2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (RecordContentHistoryTagEntity recordContentHistoryTagEntity : arrayList2) {
            String contentName = recordContentHistoryTagEntity.getContentName();
            if (!(contentName == null || contentName.length() == 0 || !Intrinsics.areEqual((Object) recordContentHistoryTagEntity.getContentName(), (Object) recordContentTagEntity.getContentName()))) {
                arrayList3.add(recordContentHistoryTagEntity);
            }
        }
        arrayList2.removeAll(CollectionsKt.toSet(arrayList3));
        arrayList2.add(new RecordContentHistoryTagEntity(0, recordContentTagEntity.getContentName(), recordContentTagEntity.getCreateTime(), (String) null, 9, (DefaultConstructorMarker) null));
        CollectionsKt.sort(arrayList2);
        this._mCurRecordContentHistoryTagEntityList.postValue(arrayList2);
    }

    public final void removePersonTag(@NotNull RecordPersonEntity recordPersonEntity) {
        Intrinsics.checkNotNullParameter(recordPersonEntity, "data");
        ArrayList arrayList = new ArrayList();
        ArrayList value = this._mCurRecordPersonNormalTagEntityList.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        if (arrayList.contains(recordPersonEntity)) {
            arrayList.remove(recordPersonEntity);
        }
        this._mCurRecordPersonNormalTagEntityList.postValue(arrayList);
        ArrayList<RecordHistoryPersonEntity> arrayList2 = new ArrayList<>();
        ArrayList value2 = this._mCurRecordPersonHistoryTagList.getValue();
        if (value2 != null) {
            arrayList2.addAll(value2);
        }
        ArrayList arrayList3 = new ArrayList();
        for (RecordHistoryPersonEntity recordHistoryPersonEntity : arrayList2) {
            String personName = recordHistoryPersonEntity.getPersonName();
            if (!(personName == null || personName.length() == 0 || !Intrinsics.areEqual((Object) recordHistoryPersonEntity.getPersonName(), (Object) recordPersonEntity.getPersonName()))) {
                arrayList3.add(recordHistoryPersonEntity);
            }
        }
        arrayList2.removeAll(CollectionsKt.toSet(arrayList3));
        arrayList2.add(new RecordHistoryPersonEntity(0, recordPersonEntity.getPersonName(), recordPersonEntity.getCreateTime(), (String) null, 9, (DefaultConstructorMarker) null));
        CollectionsKt.sort(arrayList2);
        this._mCurRecordPersonHistoryTagList.postValue(arrayList2);
    }

    public final void saveAllContentTagData(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "inputContentTagValue");
        Intrinsics.checkNotNullParameter(function0, "callBack");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new FastRecordTagViewModel$saveAllContentTagData$1(str, this, function0, (Continuation<? super FastRecordTagViewModel$saveAllContentTagData$1>) null), 2, (Object) null);
    }

    public final void saveAllHistoryDataForGiveUpChange(boolean z, boolean z2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callBack");
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1(z, z2, this, function0, (Continuation<? super FastRecordTagViewModel$saveAllHistoryDataForGiveUpChange$1>) null), 3, (Object) null);
    }

    public final void saveAllPersonData(@NotNull String str, @NotNull Function0<Unit> function0, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "inputPersonTagValue");
        Intrinsics.checkNotNullParameter(function0, "callBack");
        Intrinsics.checkNotNullParameter(str2, "curPersonType");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new FastRecordTagViewModel$saveAllPersonData$1(str, this, str2, function0, (Continuation<? super FastRecordTagViewModel$saveAllPersonData$1>) null), 2, (Object) null);
    }

    public final void setRecordId(@Nullable Long l) {
        this.mRecordId = l;
    }
}
