package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordPersonHistoryDao;
import com.upuphone.ar.fastrecord.phone.db.RecordHistoryPersonEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordTagViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordHistoryPersonList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,875:1\n1855#2,2:876\n1855#2,2:878\n*S KotlinDebug\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordHistoryPersonList$1\n*L\n314#1:876,2\n327#1:878,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$queryRecordHistoryPersonList$1", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTagViewModel$queryRecordHistoryPersonList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstTime;
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagViewModel$queryRecordHistoryPersonList$1(long j, boolean z, FastRecordTagViewModel fastRecordTagViewModel, Continuation<? super FastRecordTagViewModel$queryRecordHistoryPersonList$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$isFirstTime = z;
        this.this$0 = fastRecordTagViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTagViewModel$queryRecordHistoryPersonList$1(this.$recordId, this.$isFirstTime, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.$recordId;
            boolean z = this.$isFirstTime;
            LogExt.logE("queryRecordHistoryPersonList recordId = " + j + ",isFirstTime = " + z, "FastRecordTagViewModel");
            if (this.$recordId > 0) {
                List findAllRecordPersonEntity$default = FastRecordPersonHistoryDao.DefaultImpls.findAllRecordPersonEntity$default(FastRecordManager.Companion.getInstance().fastRecordPersonHistoryDao(), (String) null, 1, (Object) null);
                long j2 = this.$recordId;
                LogExt.logE("queryRecordHistoryPersonList findAllHistoryPersonWithOutSelf recordId = " + j2 + ",personEntityList = " + findAllRecordPersonEntity$default, "FastRecordTagViewModel");
                if (findAllRecordPersonEntity$default != null) {
                    FastRecordTagViewModel fastRecordTagViewModel = this.this$0;
                    boolean z2 = this.$isFirstTime;
                    ArrayList<RecordHistoryPersonEntity> arrayList = new ArrayList<>();
                    Iterator it = findAllRecordPersonEntity$default.iterator();
                    while (true) {
                        str = "";
                        if (!it.hasNext()) {
                            break;
                        }
                        RecordHistoryPersonEntity recordHistoryPersonEntity = (RecordHistoryPersonEntity) it.next();
                        String personName = recordHistoryPersonEntity.getPersonName();
                        if (personName != null) {
                            str = personName;
                        }
                        if (!fastRecordTagViewModel.isContainerInNormalPerson(str)) {
                            arrayList.add(recordHistoryPersonEntity);
                        }
                    }
                    LogExt.logE("queryRecordHistoryContentList lastHistoryList = " + arrayList, "FastRecordTagViewModel");
                    fastRecordTagViewModel._mCurRecordPersonHistoryTagList.postValue(fastRecordTagViewModel.selectDataNotInNeedDelHistoryPerson(arrayList));
                    if (z2) {
                        LogExt.logE("start personHistoryTagOrigin start", "FastRecordTagViewModel");
                        fastRecordTagViewModel.personHistoryTagOrigin = str;
                        for (RecordHistoryPersonEntity personName2 : arrayList) {
                            String access$getPersonHistoryTagOrigin$p = fastRecordTagViewModel.personHistoryTagOrigin;
                            String personName3 = personName2.getPersonName();
                            fastRecordTagViewModel.personHistoryTagOrigin = access$getPersonHistoryTagOrigin$p + personName3;
                        }
                        String access$getPersonHistoryTagOrigin$p2 = fastRecordTagViewModel.personHistoryTagOrigin;
                        LogExt.logE("start personHistoryTagOrigin value data = " + access$getPersonHistoryTagOrigin$p2, "FastRecordTagViewModel");
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTagViewModel$queryRecordHistoryPersonList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
