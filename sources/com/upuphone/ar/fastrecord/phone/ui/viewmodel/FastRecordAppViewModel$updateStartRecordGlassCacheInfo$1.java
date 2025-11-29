package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordAppViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordAppViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,321:1\n1855#2,2:322\n*S KotlinDebug\n*F\n+ 1 FastRecordAppViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1\n*L\n135#1:322,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1", f = "FastRecordAppViewModel.kt", i = {1}, l = {131, 144}, m = "invokeSuspend", n = {"record"}, s = {"L$1"})
public final class FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordGlassCacheInfo $mRecordGlassStatus;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1(FastRecordAppViewModel fastRecordAppViewModel, RecordGlassCacheInfo recordGlassCacheInfo, Continuation<? super FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordAppViewModel;
        this.$mRecordGlassStatus = recordGlassCacheInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1(this.this$0, this.$mRecordGlassStatus, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: com.upuphone.ar.fastrecord.phone.db.RecordEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r11 = r17
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r11.label
            r13 = 0
            r14 = 2
            r1 = 1
            if (r0 == 0) goto L_0x002d
            if (r0 == r1) goto L_0x0027
            if (r0 != r14) goto L_0x001f
            java.lang.Object r0 = r11.L$1
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            java.lang.Object r1 = r11.L$0
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.ResultKt.throwOnFailure(r18)
            r15 = r1
            goto L_0x00d3
        L_0x001f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r18)
            r0 = r18
            goto L_0x0044
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r18)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r0 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r0 = r0.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r0 = r0.fastRecordDao()
            r11.label = r1
            r2 = 0
            java.lang.Object r0 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findAllDownloadingRecordEntity$default(r0, r2, r11, r1, r2)
            if (r0 != r12) goto L_0x0044
            return r12
        L_0x0044:
            java.util.List r0 = (java.util.List) r0
            java.lang.String r1 = "recordInfoList start"
            java.lang.String r2 = "FastRecordAppViewModel"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r2)
            if (r0 == 0) goto L_0x00e2
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0057
            goto L_0x00e2
        L_0x0057:
            int r1 = r0.size()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "recordInfoList size = "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r2)
            java.util.Iterator r0 = r0.iterator()
            r15 = r0
        L_0x0074:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x00e2
            java.lang.Object r0 = r15.next()
            r10 = r0
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r10 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r10
            long r0 = java.lang.System.currentTimeMillis()
            r10.setLastModified(r0)
            r10.setRecordStatus(r14)
            long r0 = r10.getTotalTime()
            r2 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0098
            r10.setTotalTime(r2)
        L_0x0098:
            r10.setDownloading(r13)
            r10.setFinishFileMerge(r13)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r0 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r0 = r0.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r0 = r0.fastRecordDao()
            long r1 = r10.getRecordId()
            int r3 = r10.getRecordStatus()
            long r4 = r10.getTotalTime()
            long r6 = r10.getLastModified()
            boolean r8 = r10.isDownloading()
            boolean r9 = r10.isFinishFileMerge()
            r11.L$0 = r15
            r11.L$1 = r10
            r11.label = r14
            r16 = r10
            r10 = r17
            java.lang.Object r0 = r0.updateRecordState(r1, r3, r4, r6, r8, r9, r10)
            if (r0 != r12) goto L_0x00d1
            return r12
        L_0x00d1:
            r0 = r16
        L_0x00d3:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil r1 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceMergeUtil.INSTANCE
            int r2 = r0.getType()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1$1$1 r3 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1$1$1
            r3.<init>(r0)
            r1.mergeVoice(r0, r2, r13, r3)
            goto L_0x0074
        L_0x00e2:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel r0 = r11.this$0
            androidx.lifecycle.MutableLiveData r0 = r0._recordGlassCacheInfo
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassCacheInfo r1 = r11.$mRecordGlassStatus
            r0.postValue(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
