package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordDetailRecordHistoryViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordDetailRecordHistoryViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,523:1\n1855#2,2:524\n*S KotlinDebug\n*F\n+ 1 FastRecordDetailRecordHistoryViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1\n*L\n258#1:524,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {0, 1}, l = {270, 275}, m = "invokeSuspend", n = {"isEmptyAsrWord", "isEmptyAsrWord"}, s = {"L$0", "L$0"})
public final class FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ long $recordId;
    Object L$0;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1(long j, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1(this.$recordId, this.this$0, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x011b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 0
            java.lang.String r4 = "FastRecordDetailRecordHistoryViewModel"
            r5 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r5) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r0 = r12.L$0
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x010c
        L_0x001a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0022:
            java.lang.Object r1 = r12.L$0
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00f0
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r13 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r13 = r13.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao r13 = r13.fastRecordVoiceWordDao()
            long r6 = r12.$recordId
            java.util.List r13 = r13.findFastRecordOrderByStartTime(r6)
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            r1.element = r5
            long r6 = r12.$recordId
            r8 = 0
            if (r13 == 0) goto L_0x0053
            int r9 = r13.size()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            goto L_0x0054
        L_0x0053:
            r9 = r8
        L_0x0054:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "checkAllAsrWordIsEmpty recordId = "
            r10.append(r11)
            r10.append(r6)
            java.lang.String r6 = ", voiceWordList size = "
            r10.append(r6)
            r10.append(r9)
            java.lang.String r6 = r10.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r4)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r13 == 0) goto L_0x00bc
            java.util.Iterator r13 = r13.iterator()
        L_0x007b:
            boolean r7 = r13.hasNext()
            if (r7 == 0) goto L_0x00bc
            java.lang.Object r7 = r13.next()
            com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity r7 = (com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity) r7
            java.lang.String r9 = r7.getWordContent()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "checkAllAsrWordIsEmpty wordContent = "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r9, r4)
            java.lang.String r9 = r7.getWordContent()
            if (r9 == 0) goto L_0x00ae
            java.lang.CharSequence r9 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r9)
            java.lang.String r9 = r9.toString()
            goto L_0x00af
        L_0x00ae:
            r9 = r8
        L_0x00af:
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00b8
            r1.element = r3
            goto L_0x007b
        L_0x00b8:
            r6.add(r7)
            goto L_0x007b
        L_0x00bc:
            int r13 = r6.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "checkAllAsrWordIsEmpty needDelWordList size = "
            r7.append(r8)
            r7.append(r13)
            java.lang.String r13 = r7.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r13, r4)
            boolean r13 = r6.isEmpty()
            r13 = r13 ^ r5
            if (r13 == 0) goto L_0x00f0
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r13 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r13 = r13.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao r13 = r13.fastRecordVoiceWordDao()
            r12.L$0 = r1
            r12.label = r5
            java.lang.Object r13 = r13.deleteItems(r6, r12)
            if (r13 != r0) goto L_0x00f0
            return r0
        L_0x00f0:
            boolean r13 = r1.element
            if (r13 == 0) goto L_0x013a
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r13 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r13 = r13.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r13 = r13.fastRecordDao()
            long r5 = r12.$recordId
            r12.L$0 = r1
            r12.label = r2
            java.lang.Object r13 = r13.updateRecordFinishAsrState(r5, r3, r12)
            if (r13 != r0) goto L_0x010b
            return r0
        L_0x010b:
            r0 = r1
        L_0x010c:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r13 = r12.this$0
            androidx.lifecycle.MutableLiveData r13 = r13._mCurFastRecordLiveData
            java.lang.Object r13 = r13.getValue()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r13 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r13
            if (r13 != 0) goto L_0x011b
            goto L_0x011e
        L_0x011b:
            r13.setFinishAsr(r3)
        L_0x011e:
            long r1 = r12.$recordId
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r3 = "isEmptyAsrWord is true recordId = "
            r13.append(r3)
            r13.append(r1)
            java.lang.String r1 = ",isFinishAsr = false"
            r13.append(r1)
            java.lang.String r13 = r13.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r13, r4)
            r1 = r0
        L_0x013a:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r12 = r12.$callback
            boolean r13 = r1.element
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            r12.invoke(r13)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$checkAllAsrWordIsEmpty$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
