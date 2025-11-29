package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.FastRecordTagHistoryDao;
import com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity;
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

@SourceDebugExtension({"SMAP\nFastRecordTagViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordHistoryContentList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,875:1\n1855#2,2:876\n1855#2,2:878\n*S KotlinDebug\n*F\n+ 1 FastRecordTagViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel$queryRecordHistoryContentList$1\n*L\n279#1:876,2\n291#1:878,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel$queryRecordHistoryContentList$1", f = "FastRecordTagViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordTagViewModel$queryRecordHistoryContentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFirstTime;
    final /* synthetic */ long $recordId;
    int label;
    final /* synthetic */ FastRecordTagViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordTagViewModel$queryRecordHistoryContentList$1(long j, FastRecordTagViewModel fastRecordTagViewModel, boolean z, Continuation<? super FastRecordTagViewModel$queryRecordHistoryContentList$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = fastRecordTagViewModel;
        this.$isFirstTime = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordTagViewModel$queryRecordHistoryContentList$1(this.$recordId, this.this$0, this.$isFirstTime, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$recordId > 0) {
                List findAllTagData$default = FastRecordTagHistoryDao.DefaultImpls.findAllTagData$default(FastRecordManager.Companion.getInstance().fastRecordTagHistoryDao(), (String) null, 1, (Object) null);
                long j = this.$recordId;
                LogExt.logE("queryRecordHistoryContentList findAllHistoryTagWithOutSelf recordId = " + j + ",tagEntityList = " + findAllTagData$default, "FastRecordTagViewModel");
                if (findAllTagData$default != null) {
                    FastRecordTagViewModel fastRecordTagViewModel = this.this$0;
                    boolean z = this.$isFirstTime;
                    ArrayList<RecordContentHistoryTagEntity> arrayList = new ArrayList<>();
                    Iterator it = findAllTagData$default.iterator();
                    while (true) {
                        str = "";
                        if (!it.hasNext()) {
                            break;
                        }
                        RecordContentHistoryTagEntity recordContentHistoryTagEntity = (RecordContentHistoryTagEntity) it.next();
                        String contentName = recordContentHistoryTagEntity.getContentName();
                        if (contentName != null) {
                            str = contentName;
                        }
                        if (!fastRecordTagViewModel.isContainerInNormalTag(str)) {
                            arrayList.add(recordContentHistoryTagEntity);
                        }
                    }
                    LogExt.logE("queryRecordHistoryContentList lastContentTagHistoryList = " + arrayList, "FastRecordTagViewModel");
                    fastRecordTagViewModel._mCurRecordContentHistoryTagEntityList.postValue(fastRecordTagViewModel.selectDataNotInNeedDelHistoryTag(arrayList));
                    if (z) {
                        LogExt.logE("start contentHistoryTagOrigin value", "FastRecordTagViewModel");
                        fastRecordTagViewModel.contentHistoryTagOrigin = str;
                        for (RecordContentHistoryTagEntity contentName2 : arrayList) {
                            String access$getContentHistoryTagOrigin$p = fastRecordTagViewModel.contentHistoryTagOrigin;
                            String contentName3 = contentName2.getContentName();
                            fastRecordTagViewModel.contentHistoryTagOrigin = access$getContentHistoryTagOrigin$p + contentName3;
                        }
                        String access$getContentHistoryTagOrigin$p2 = fastRecordTagViewModel.contentHistoryTagOrigin;
                        LogExt.logE("start contentHistoryTagOrigin value data = " + access$getContentHistoryTagOrigin$p2, "FastRecordTagViewModel");
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordTagViewModel$queryRecordHistoryContentList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
