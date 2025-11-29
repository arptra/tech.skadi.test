package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordPersonDao;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.ArrayList;
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

@SourceDebugExtension({"SMAP\nFastRecordTagViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordPersonTagInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,875:1\n1855#2,2:876\n*S KotlinDebug\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordPersonTagInfo$1\n*L\n187#1:876,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$queryRecordPersonTagInfo$1", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTagViewModel$queryRecordPersonTagInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstTime;
    final /* synthetic */ String $personType;
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagViewModel$queryRecordPersonTagInfo$1(long j, String str, boolean z, FastRecordTagViewModel fastRecordTagViewModel, Continuation<? super FastRecordTagViewModel$queryRecordPersonTagInfo$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$personType = str;
        this.$isFirstTime = z;
        this.this$0 = fastRecordTagViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTagViewModel$queryRecordPersonTagInfo$1(this.$recordId, this.$personType, this.$isFirstTime, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$recordId > 0) {
                List<RecordPersonEntity> findNormalPersonByRecord$default = FastRecordPersonDao.DefaultImpls.findNormalPersonByRecord$default(FastRecordManager.Companion.getInstance().fastRecordPersonDao(), this.$recordId, this.$personType, (String) null, 4, (Object) null);
                long j = this.$recordId;
                LogExt.logE("queryRecordNormalPersonTagInfo recordId = " + j + ",personEntityList = " + findNormalPersonByRecord$default, "FastRecordTagViewModel");
                ArrayList arrayList = new ArrayList();
                if (this.$isFirstTime) {
                    this.this$0.personTagOriginList.clear();
                }
                if (findNormalPersonByRecord$default != null) {
                    boolean z = this.$isFirstTime;
                    FastRecordTagViewModel fastRecordTagViewModel = this.this$0;
                    arrayList.addAll(findNormalPersonByRecord$default);
                    if (z) {
                        fastRecordTagViewModel.personTagOrigin = "";
                        for (RecordPersonEntity recordPersonEntity : findNormalPersonByRecord$default) {
                            String access$getPersonTagOrigin$p = fastRecordTagViewModel.personTagOrigin;
                            String personName = recordPersonEntity.getPersonName();
                            fastRecordTagViewModel.personTagOrigin = access$getPersonTagOrigin$p + personName;
                            fastRecordTagViewModel.personTagOriginList.add(recordPersonEntity);
                        }
                    }
                }
                this.this$0.addInputPersonEntity(arrayList, this.$recordId);
                this.this$0._mCurRecordPersonNormalTagEntityList.postValue(arrayList);
                this.this$0.queryRecordHistoryPersonList(this.$recordId, this.$isFirstTime);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTagViewModel$queryRecordPersonTagInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
