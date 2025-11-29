package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordDao;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordMainViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$initFragmentAllData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,565:1\n1855#2,2:566\n1#3:568\n*S KotlinDebug\n*F\n+ 1 FastRecordMainViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel$initFragmentAllData$1\n*L\n506#1:566,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel$initFragmentAllData$1", f = "FastRecordMainViewModel.kt", i = {1}, l = {501, 527}, m = "invokeSuspend", n = {"allRecordList"}, s = {"L$1"})
public final class FastRecordMainViewModel$initFragmentAllData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainViewModel$initFragmentAllData$1(FastRecordMainViewModel fastRecordMainViewModel, Continuation<? super FastRecordMainViewModel$initFragmentAllData$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordMainViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordMainViewModel$initFragmentAllData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FastRecordMainViewModel fastRecordMainViewModel;
        ArrayList arrayList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LogExt.logI("initFragmentAllData start ", "FastRecordMainViewModel");
            FastRecordDao fastRecordDao = FastRecordManager.Companion.getInstance().fastRecordDao();
            this.label = 1;
            obj = FastRecordDao.DefaultImpls.getRecordEntityByCreateTime$default(fastRecordDao, (String) null, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            arrayList = (ArrayList) this.L$1;
            fastRecordMainViewModel = (FastRecordMainViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            fastRecordMainViewModel._mAllFastRecordLiveData.postValue(arrayList);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<RecordEntity> list = (List) obj;
        if (list != null) {
            FastRecordMainViewModel fastRecordMainViewModel2 = this.this$0;
            int size = list.size();
            LogExt.logI("initFragmentAllData start recordData size = " + size, "FastRecordMainViewModel");
            ArrayList arrayList2 = new ArrayList();
            for (RecordEntity recordEntity : list) {
                long recordId = recordEntity.getRecordId();
                String shortHandTitle = recordEntity.getShortHandTitle();
                LogExt.logW("initFragmentAllData recordData value = " + recordId + ",title = " + shortHandTitle, "FastRecordMainViewModel");
                if (recordEntity.isDownloading()) {
                    arrayList2.add(recordEntity);
                } else {
                    if (recordEntity.getTotalTime() < 1000) {
                        recordEntity.setTotalTime(1000);
                    }
                    recordEntity.setTagBeanList(fastRecordMainViewModel2.getTagInfo(recordEntity.getRecordId()));
                }
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(list);
            new ArrayList().addAll(arrayList3);
            int size2 = arrayList2.size();
            LogExt.logW("downingRecord size = " + size2, "FastRecordMainViewModel");
            arrayList3.removeAll(CollectionsKt.toSet(arrayList2));
            this.L$0 = fastRecordMainViewModel2;
            this.L$1 = arrayList3;
            this.label = 2;
            if (fastRecordMainViewModel2.resetRecordStatus(arrayList3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            fastRecordMainViewModel = fastRecordMainViewModel2;
            arrayList = arrayList3;
            fastRecordMainViewModel._mAllFastRecordLiveData.postValue(arrayList);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordMainViewModel$initFragmentAllData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
