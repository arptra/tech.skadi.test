package com.upuphone.ar.fastrecord.phone.ui.viewmodel.search;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.honey.account.z3.a;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordPersonDao;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagDao;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.ext.FastRecordAppUtilsKt;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.runasone.relay.api.IntentKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0005j\b\u0012\u0004\u0012\u00020\u0010`\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0005j\b\u0012\u0004\u0012\u00020\u0014`\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0002J(\u0010\u0019\u001a\u00020\u00162\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0005j\b\u0012\u0004\u0012\u00020\u0010`\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010#\u001a\u00020\u001e2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J(\u0010%\u001a\u00020\u00162\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0005j\b\u0012\u0004\u0012\u00020\u0014`\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R$\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R'\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/search/FastRecordSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_mCurFastRecordLiveData", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "Lkotlin/collections/ArrayList;", "allRecordList", "curRecordData", "Landroidx/lifecycle/LiveData;", "getCurRecordData", "()Landroidx/lifecycle/LiveData;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getPersonInfo", "Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "recordId", "", "getTagInfo", "Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "isRecordIsInList", "", "recordList", "", "personContainsKey", "tagBeanList", "key", "", "queryAllRecordInfo", "", "callback", "Lkotlin/Function0;", "queryRecordInfo", "queryRecordInfoNoNeedCheckShowContent", "sortRecordData", "tempQueryValue", "tagContainsKey", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordSearchViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSearchViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/search/FastRecordSearchViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,255:1\n1855#2,2:256\n1855#2,2:258\n1855#2:260\n1855#2,2:261\n1856#2:263\n1855#2,2:264\n1855#2,2:266\n1855#2,2:268\n1855#2,2:270\n*S KotlinDebug\n*F\n+ 1 FastRecordSearchViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/search/FastRecordSearchViewModel\n*L\n68#1:256,2\n91#1:258,2\n94#1:260\n101#1:261,2\n94#1:263\n141#1:264,2\n167#1:266,2\n181#1:268,2\n196#1:270,2\n*E\n"})
public final class FastRecordSearchViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_FIRST_EXIST_POSITION = 8;
    @NotNull
    private static final String TAG = "FastRecordSearchViewModel";
    @NotNull
    private MutableLiveData<ArrayList<RecordEntity>> _mCurFastRecordLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final ArrayList<RecordEntity> allRecordList;
    @NotNull
    private final LiveData<ArrayList<RecordEntity>> curRecordData;
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.a(Dispatchers.b());

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/search/FastRecordSearchViewModel$Companion;", "", "()V", "MAX_FIRST_EXIST_POSITION", "", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordSearchViewModel() {
        MutableLiveData<ArrayList<RecordEntity>> mutableLiveData = new MutableLiveData<>();
        this._mCurFastRecordLiveData = mutableLiveData;
        this.curRecordData = FastRecordAppUtilsKt.asLiveData(mutableLiveData);
        this.allRecordList = new ArrayList<>();
    }

    /* access modifiers changed from: private */
    public final ArrayList<RecordPersonEntity> getPersonInfo(long j) {
        ArrayList<RecordPersonEntity> arrayList = new ArrayList<>();
        List findAllNormalPersonByRecord$default = FastRecordPersonDao.DefaultImpls.findAllNormalPersonByRecord$default(FastRecordManager.Companion.getInstance().fastRecordPersonDao(), j, (String) null, 2, (Object) null);
        if (findAllNormalPersonByRecord$default != null) {
            LogExt.logE("findAllNormalPersonByRecord info = " + findAllNormalPersonByRecord$default, TAG);
            arrayList.addAll(findAllNormalPersonByRecord$default);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ArrayList<RecordContentTagEntity> getTagInfo(long j) {
        ArrayList<RecordContentTagEntity> arrayList = new ArrayList<>();
        List findNormalTagEntityByRecord$default = FastRecordTagDao.DefaultImpls.findNormalTagEntityByRecord$default(FastRecordManager.Companion.getInstance().fastRecordTagDao(), j, (String) null, 2, (Object) null);
        if (findNormalTagEntityByRecord$default != null) {
            LogExt.logE("findTagEntityByRecord info = " + findNormalTagEntityByRecord$default, TAG);
            arrayList.addAll(findNormalTagEntityByRecord$default);
        }
        return arrayList;
    }

    private final boolean isRecordIsInList(long j, List<RecordEntity> list) {
        for (RecordEntity recordId : list) {
            if (recordId.getRecordId() == j) {
                return true;
            }
        }
        return false;
    }

    private final boolean personContainsKey(ArrayList<RecordPersonEntity> arrayList, String str) {
        boolean z;
        LogExt.logE("personContainsKey  key = " + str + ",tagBeanList = " + arrayList, TAG);
        Iterator<T> it = arrayList.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            String personName = ((RecordPersonEntity) it.next()).getPersonName();
            if (personName != null) {
                z = true;
                if (StringsKt.contains$default((CharSequence) personName, (CharSequence) str, false, 2, (Object) null)) {
                    break;
                }
            }
        }
        return z;
    }

    public static /* synthetic */ void queryAllRecordInfo$default(FastRecordSearchViewModel fastRecordSearchViewModel, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        fastRecordSearchViewModel.queryAllRecordInfo(function0);
    }

    private final void sortRecordData(ArrayList<RecordEntity> arrayList) {
        for (RecordEntity recordEntity : arrayList) {
            long recordId = recordEntity.getRecordId();
            String shortHandTitle = recordEntity.getShortHandTitle();
            long searchWeight = recordEntity.getSearchWeight();
            long createTime = recordEntity.getCreateTime();
            LogExt.logE("sortRecordData record id = " + recordId + ",title =" + shortHandTitle + " weight = " + searchWeight + ",time = " + createTime, TAG);
        }
        CollectionsKt.sortWith(arrayList, new a(FastRecordSearchViewModel$sortRecordData$2.INSTANCE));
        this._mCurFastRecordLiveData.postValue(arrayList);
    }

    /* access modifiers changed from: private */
    public static final int sortRecordData$lambda$7(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final boolean tagContainsKey(ArrayList<RecordContentTagEntity> arrayList, String str) {
        boolean z;
        LogExt.logE("tagContainsKey key = " + str + ",tagBeanList = " + arrayList, TAG);
        Iterator<T> it = arrayList.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            String contentName = ((RecordContentTagEntity) it.next()).getContentName();
            if (contentName != null) {
                z = true;
                if (StringsKt.contains$default((CharSequence) contentName, (CharSequence) str, false, 2, (Object) null)) {
                    break;
                }
            }
        }
        return z;
    }

    @NotNull
    public final LiveData<ArrayList<RecordEntity>> getCurRecordData() {
        return this.curRecordData;
    }

    public final void queryAllRecordInfo(@Nullable Function0<Unit> function0) {
        Job unused = BuildersKt__Builders_commonKt.d(this.scope, (CoroutineContext) null, (CoroutineStart) null, new FastRecordSearchViewModel$queryAllRecordInfo$1(this, function0, (Continuation<? super FastRecordSearchViewModel$queryAllRecordInfo$1>) null), 3, (Object) null);
    }

    public final void queryRecordInfo(@NotNull String str) {
        Iterator<T> it;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, IntentKey.ACTIVITY.ACTION_KEY);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            LogExt.logE("TextUtils.isEmpty(key)", TAG);
            return;
        }
        Iterator<T> it2 = this.allRecordList.iterator();
        while (it2.hasNext()) {
            RecordEntity recordEntity = (RecordEntity) it2.next();
            recordEntity.setSearchShowTitle("");
            recordEntity.setSearchKeyWord("");
            recordEntity.setSearchShowContent("");
            recordEntity.setSearchIndexTitle(-1);
            recordEntity.setSearchIndexContent(-1);
            String shortHandTitle = recordEntity.getShortHandTitle();
            if (shortHandTitle == null || !StringsKt.contains$default((CharSequence) shortHandTitle, (CharSequence) str2, false, 2, (Object) null)) {
                it = it2;
                String shortHandText = recordEntity.getShortHandText();
                if (shortHandText != null && StringsKt.contains$default((CharSequence) shortHandText, (CharSequence) str2, false, 2, (Object) null)) {
                    String shortHandText2 = recordEntity.getShortHandText();
                    if (shortHandText2 != null) {
                        String str3 = shortHandText2;
                        int indexOf$default = StringsKt.indexOf$default((CharSequence) shortHandText2, str, 0, false, 6, (Object) null);
                        if (indexOf$default > 8) {
                            String substring = str3.substring(indexOf$default - 8, str3.length());
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                            recordEntity.setSearchShowContent(substring);
                            indexOf$default -= 8;
                        } else {
                            recordEntity.setSearchShowContent(str3);
                        }
                        recordEntity.setSearchIndexContent(indexOf$default);
                    }
                    recordEntity.setSearchShowTitle(recordEntity.getShortHandTitle());
                    recordEntity.setSearchKeyWord(str2);
                    LogExt.logE("shortHandText contains key searchShowContent = " + recordEntity.getSearchShowContent() + ", searchIndexContent = " + recordEntity.getSearchIndexContent() + ", searchShowTitle = " + recordEntity.getSearchShowTitle() + ",searchKeyWord = " + recordEntity.getSearchKeyWord(), TAG);
                    arrayList.add(recordEntity);
                }
            } else {
                String shortHandTitle2 = recordEntity.getShortHandTitle();
                if (shortHandTitle2 != null) {
                    LogExt.logE("shortHandTitle contains key", TAG);
                    String str4 = shortHandTitle2;
                    it = it2;
                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) shortHandTitle2, str, 0, false, 6, (Object) null);
                    LogExt.logE("shortHandTitle contains key findIndex = " + indexOf$default2, TAG);
                    if (indexOf$default2 > 8) {
                        String substring2 = str4.substring(indexOf$default2 - 8, str4.length());
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        recordEntity.setSearchShowTitle(substring2);
                        indexOf$default2 -= 8;
                    } else {
                        recordEntity.setSearchShowTitle(str4);
                    }
                    recordEntity.setSearchIndexTitle(indexOf$default2);
                } else {
                    it = it2;
                }
                recordEntity.setSearchShowContent(recordEntity.getShortHandText());
                recordEntity.setSearchKeyWord(str2);
                LogExt.logE("shortHandText contains key searchShowContent = " + recordEntity.getSearchShowContent() + ", searchIndexTitle = " + recordEntity.getSearchIndexTitle() + ", searchShowTitle = " + recordEntity.getSearchShowTitle() + ",searchKeyWord = " + recordEntity.getSearchKeyWord(), TAG);
                arrayList.add(recordEntity);
            }
            it2 = it;
        }
        this._mCurFastRecordLiveData.postValue(arrayList);
    }

    public final void queryRecordInfoNoNeedCheckShowContent(@NotNull String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, IntentKey.ACTIVITY.ACTION_KEY);
        LogExt.logE("queryRecordInfoNoNeedCheckShowContent key = " + str2, TAG);
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            LogExt.logE("TextUtils.isEmpty(key)", TAG);
            return;
        }
        List<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
        for (RecordEntity searchWeight : this.allRecordList) {
            searchWeight.setSearchWeight(0);
        }
        for (String str3 : split$default) {
            String replace$default = StringsKt.replace$default(str3, " ", "", false, 4, (Object) null);
            if (StringsKt.trim((CharSequence) replace$default).toString().length() == 0) {
                LogExt.logE("searchValue is empty", TAG);
            } else {
                LogExt.logE("queryRecordInfoNoNeedCheckShowContent data = " + str3 + ",searchValue = " + replace$default, TAG);
                for (RecordEntity recordEntity : this.allRecordList) {
                    recordEntity.setSearchWeight(recordEntity.getSearchWeight() + 1);
                    String shortHandTitle = recordEntity.getShortHandTitle();
                    if (shortHandTitle != null && StringsKt.contains$default((CharSequence) shortHandTitle, (CharSequence) replace$default, false, 2, (Object) null)) {
                        String shortHandTitle2 = recordEntity.getShortHandTitle();
                        LogExt.logE("queryRecordInfoNoNeedCheckShowContent it.shortHandTitle = " + shortHandTitle2 + ",contains key", TAG);
                        if (!isRecordIsInList(recordEntity.getRecordId(), arrayList)) {
                            arrayList.add(recordEntity);
                        }
                    }
                    String shortHandText = recordEntity.getShortHandText();
                    if (shortHandText != null && StringsKt.contains$default((CharSequence) shortHandText, (CharSequence) replace$default, false, 2, (Object) null)) {
                        String shortHandText2 = recordEntity.getShortHandText();
                        LogExt.logE("queryRecordInfoNoNeedCheckShowContent it.shortHandText = " + shortHandText2 + ",contains key", TAG);
                        recordEntity.setSearchWeight(recordEntity.getSearchWeight() + 1);
                        if (!isRecordIsInList(recordEntity.getRecordId(), arrayList)) {
                            arrayList.add(recordEntity);
                        }
                    }
                    if (tagContainsKey(recordEntity.getTagBeanList(), replace$default)) {
                        recordEntity.setSearchWeight(recordEntity.getSearchWeight() + 1);
                        ArrayList<RecordContentTagEntity> tagBeanList = recordEntity.getTagBeanList();
                        LogExt.logE("queryRecordInfoNoNeedCheckShowContent it.tagBeanList = " + tagBeanList + ",contains key", TAG);
                        if (!isRecordIsInList(recordEntity.getRecordId(), arrayList)) {
                            arrayList.add(recordEntity);
                        }
                    }
                    if (personContainsKey(recordEntity.getPersonBeanList(), replace$default)) {
                        recordEntity.setSearchWeight(recordEntity.getSearchWeight() + 1);
                        ArrayList<RecordPersonEntity> personBeanList = recordEntity.getPersonBeanList();
                        LogExt.logE("queryRecordInfoNoNeedCheckShowContent it.personBeanList = " + personBeanList + ",contains key", TAG);
                        if (!isRecordIsInList(recordEntity.getRecordId(), arrayList)) {
                            arrayList.add(recordEntity);
                        }
                    }
                }
            }
        }
        sortRecordData(arrayList);
    }
}
