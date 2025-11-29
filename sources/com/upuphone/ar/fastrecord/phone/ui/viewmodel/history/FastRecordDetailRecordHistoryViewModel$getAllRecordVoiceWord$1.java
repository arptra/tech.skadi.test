package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

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

@SourceDebugExtension({"SMAP\nFastRecordDetailRecordHistoryViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordDetailRecordHistoryViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,523:1\n1855#2,2:524\n*S KotlinDebug\n*F\n+ 1 FastRecordDetailRecordHistoryViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1\n*L\n314#1:524,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {0, 0}, l = {320}, m = "invokeSuspend", n = {"voiceWordList", "stringBuffer"}, s = {"L$0", "L$1"})
public final class FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAsrSocketResult;
    final /* synthetic */ long $recordId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1(boolean z, long j, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Continuation<? super FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1> continuation) {
        super(2, continuation);
        this.$isAsrSocketResult = z;
        this.$recordId = j;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1(this.$isAsrSocketResult, this.$recordId, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cb  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            java.lang.String r3 = "FastRecordDetailRecordHistoryViewModel"
            if (r1 == 0) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r0 = r8.L$1
            java.lang.StringBuffer r0 = (java.lang.StringBuffer) r0
            java.lang.Object r1 = r8.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a8
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r8.$isAsrSocketResult
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "getAllRecordVoiceWordForPhone start isAsrSocketResult = "
            r1.append(r4)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r9, r3)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r9 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r9 = r9.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao r9 = r9.fastRecordVoiceWordDao()
            long r4 = r8.$recordId
            java.util.List r1 = r9.findFastRecordOrderByStartTime(r4)
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            if (r1 == 0) goto L_0x007e
            java.util.Iterator r4 = r1.iterator()
        L_0x0056:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x007e
            java.lang.Object r5 = r4.next()
            com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity r5 = (com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity) r5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "item info = "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r3)
            java.lang.String r5 = r5.getWordContent()
            r9.append(r5)
            goto L_0x0056
        L_0x007e:
            boolean r4 = r8.$isAsrSocketResult
            if (r4 == 0) goto L_0x00a9
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r4 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r4 = r4.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r4 = r4.fastRecordDao()
            long r5 = r8.$recordId
            if (r1 == 0) goto L_0x0099
            boolean r7 = r1.isEmpty()
            if (r7 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r7 = 0
            goto L_0x009a
        L_0x0099:
            r7 = r2
        L_0x009a:
            r8.L$0 = r1
            r8.L$1 = r9
            r8.label = r2
            java.lang.Object r2 = r4.updateRecordEmptyRecordState(r5, r7, r8)
            if (r2 != r0) goto L_0x00a7
            return r0
        L_0x00a7:
            r0 = r9
        L_0x00a8:
            r9 = r0
        L_0x00a9:
            if (r1 == 0) goto L_0x00b4
            int r0 = r1.size()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            goto L_0x00b5
        L_0x00b4:
            r0 = 0
        L_0x00b5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getAllRecordVoiceWordForPhone voiceWordList size = "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r3)
            if (r1 == 0) goto L_0x00dc
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r0 = r8.this$0
            long r4 = r8.$recordId
            java.lang.String r8 = "delAllNotEmptyData start"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r8, r3)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1$2$1 r8 = new com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1$2$1
            r8.<init>(r0, r4, r9)
            r0.delAllNotEmptyData(r1, r8)
        L_0x00dc:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$getAllRecordVoiceWord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
