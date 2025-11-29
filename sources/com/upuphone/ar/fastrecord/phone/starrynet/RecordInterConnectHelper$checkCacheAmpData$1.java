package com.upuphone.ar.fastrecord.phone.starrynet;

import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$checkCacheAmpData$1", f = "RecordInterConnectHelper.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
public final class RecordInterConnectHelper$checkCacheAmpData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecordGlassStatus $mRecordGlassStatus;
    int label;
    final /* synthetic */ RecordInterConnectHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordInterConnectHelper$checkCacheAmpData$1(RecordInterConnectHelper recordInterConnectHelper, RecordGlassStatus recordGlassStatus, Continuation<? super RecordInterConnectHelper$checkCacheAmpData$1> continuation) {
        super(2, continuation);
        this.this$0 = recordInterConnectHelper;
        this.$mRecordGlassStatus = recordGlassStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordInterConnectHelper$checkCacheAmpData$1(this.this$0, this.$mRecordGlassStatus, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b8, code lost:
        r6 = r0.getDetailAmpData();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x002b
        L_0x000f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r11)
            com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper r11 = r10.this$0
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r1 = r10.$mRecordGlassStatus
            long r3 = r1.getId()
            r10.label = r2
            java.lang.Object r11 = r11.setRecordIngTime(r3, r10)
            if (r11 != r0) goto L_0x002b
            return r0
        L_0x002b:
            com.upuphone.ar.fastrecord.phone.ui.widget.RecordItemSoundVisualizerView$Companion r11 = com.upuphone.ar.fastrecord.phone.ui.widget.RecordItemSoundVisualizerView.Companion
            java.util.concurrent.CopyOnWriteArrayList r0 = r11.getItemAmplitudeBeanToList()
            com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView$Companion r1 = com.upuphone.ar.fastrecord.phone.ui.widget.RecordIngDetailSoundVisualizerView.Companion
            java.util.concurrent.CopyOnWriteArrayList r2 = r1.getDetailAmplitudeBeanToList()
            boolean r3 = r0.isEmpty()
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r4 = r10.$mRecordGlassStatus
            long r4 = r4.getId()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "checkCacheAmpData itemMemoryCache isEmpty = "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = ",id = "
            r6.append(r3)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r5 = "FastRecordInterConnectHelper"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r4, r5)
            boolean r4 = r2.isEmpty()
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r6 = r10.$mRecordGlassStatus
            long r6 = r6.getId()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "checkCacheAmpData detailMemoryCache isEmpty = "
            r8.append(r9)
            r8.append(r4)
            r8.append(r3)
            r8.append(r6)
            java.lang.String r3 = r8.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r3, r5)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x008f
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x011b
        L_0x008f:
            com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil r0 = com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil.INSTANCE
            com.upuphone.ar.fastrecord.phone.bean.CacheAmplitudeInfo r2 = r0.getRecordAmplitudeForItem()
            com.upuphone.ar.fastrecord.phone.bean.CacheAmplitudeInfo r0 = r0.getRecordAmplitudeForDetail()
            r3 = 0
            if (r2 == 0) goto L_0x00b5
            long r6 = r2.getRecordId()
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r4 = r10.$mRecordGlassStatus
            long r8 = r4.getId()
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x00b5
            java.util.concurrent.CopyOnWriteArrayList r4 = r11.getItemAmplitudeBeanToList()
            java.util.LinkedList r6 = r2.getDetailAmpData()
            r4.addAll(r3, r6)
        L_0x00b5:
            r4 = 0
            if (r0 == 0) goto L_0x00c7
            java.util.LinkedList r6 = r0.getDetailAmpData()
            if (r6 == 0) goto L_0x00c7
            int r6 = r6.size()
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            goto L_0x00c8
        L_0x00c7:
            r6 = r4
        L_0x00c8:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "checkCacheAmpData ampDetailList size = "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r5)
            if (r0 == 0) goto L_0x00f7
            long r6 = r0.getRecordId()
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r8 = r10.$mRecordGlassStatus
            long r8 = r8.getId()
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x00f7
            java.util.concurrent.CopyOnWriteArrayList r6 = r1.getDetailAmplitudeBeanToList()
            java.util.LinkedList r0 = r0.getDetailAmpData()
            r6.addAll(r3, r0)
        L_0x00f7:
            if (r2 == 0) goto L_0x0107
            java.util.LinkedList r0 = r2.getDetailAmpData()
            if (r0 == 0) goto L_0x0107
            int r0 = r0.size()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
        L_0x0107:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "checkCacheAmpData ampItemList size = "
            r0.append(r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r5)
        L_0x011b:
            java.util.concurrent.CopyOnWriteArrayList r0 = r1.getDetailAmplitudeBeanToList()
            int r0 = r0.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkCacheAmpData detail size = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r5)
            java.util.concurrent.CopyOnWriteArrayList r11 = r11.getItemAmplitudeBeanToList()
            int r11 = r11.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkCacheAmpData item size = "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r11, r5)
            com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper r11 = r10.this$0
            com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordGlassStatus r10 = r10.$mRecordGlassStatus
            r11.updateState(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper$checkCacheAmpData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordInterConnectHelper$checkCacheAmpData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
