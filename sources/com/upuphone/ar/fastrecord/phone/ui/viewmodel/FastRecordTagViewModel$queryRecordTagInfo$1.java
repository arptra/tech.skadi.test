package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagDao;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
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

@SourceDebugExtension({"SMAP\nFastRecordTagViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordTagInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,875:1\n1855#2,2:876\n*S KotlinDebug\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordTagInfo$1\n*L\n93#1:876,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$queryRecordTagInfo$1", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTagViewModel$queryRecordTagInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $firstTime;
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagViewModel$queryRecordTagInfo$1(long j, FastRecordTagViewModel fastRecordTagViewModel, boolean z, Continuation<? super FastRecordTagViewModel$queryRecordTagInfo$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = fastRecordTagViewModel;
        this.$firstTime = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTagViewModel$queryRecordTagInfo$1(this.$recordId, this.this$0, this.$firstTime, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$recordId > 0) {
                List<RecordContentTagEntity> findNormalTagEntityByRecord$default = FastRecordTagDao.DefaultImpls.findNormalTagEntityByRecord$default(FastRecordManager.Companion.getInstance().fastRecordTagDao(), this.$recordId, (String) null, 2, (Object) null);
                ArrayList arrayList = new ArrayList();
                if (findNormalTagEntityByRecord$default != null) {
                    boolean z = this.$firstTime;
                    FastRecordTagViewModel fastRecordTagViewModel = this.this$0;
                    arrayList.addAll(findNormalTagEntityByRecord$default);
                    if (z) {
                        LogExt.logE("start contentTagOrigin value", "FastRecordTagViewModel");
                        fastRecordTagViewModel.contentTagOrigin = "";
                        for (RecordContentTagEntity recordContentTagEntity : findNormalTagEntityByRecord$default) {
                            String access$getContentTagOrigin$p = fastRecordTagViewModel.contentTagOrigin;
                            String contentName = recordContentTagEntity.getContentName();
                            fastRecordTagViewModel.contentTagOrigin = access$getContentTagOrigin$p + contentName;
                            fastRecordTagViewModel.contentTagOriginList.add(recordContentTagEntity);
                        }
                        String access$getContentTagOrigin$p2 = fastRecordTagViewModel.contentTagOrigin;
                        LogExt.logE("start contentTagOrigin value data " + access$getContentTagOrigin$p2, "FastRecordTagViewModel");
                    }
                }
                this.this$0.addInputTypeContentTagEntity(arrayList, this.$recordId);
                long j = this.$recordId;
                LogExt.logE("queryRecordNormalContentTagInfo 111 recordId = " + j + ",mRecordContentTagEntityList = " + arrayList, "FastRecordTagViewModel");
                this.this$0._mCurRecordContentNormalTagEntityList.postValue(arrayList);
                this.this$0.queryRecordHistoryContentList(this.$recordId, this.$firstTime);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTagViewModel$queryRecordTagInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
