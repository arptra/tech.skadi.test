package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1", f = "FastRecordDetailRecordHistoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ Long $recordId;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ FastRecordDetailRecordHistoryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1(String str, FastRecordDetailRecordHistoryViewModel fastRecordDetailRecordHistoryViewModel, Context context, Long l, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.this$0 = fastRecordDetailRecordHistoryViewModel;
        this.$context = context;
        this.$recordId = l;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1(this.$type, this.this$0, this.$context, this.$recordId, this.$callback, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        r14 = r14.getShortHandTitle();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r14.label
            if (r0 != 0) goto L_0x00e9
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.String r15 = r14.$type
            int r0 = r15.hashCode()
            r1 = -1970031442(0xffffffff8a93b4ae, float:-1.4223549E-32)
            r2 = 0
            java.lang.String r4 = ""
            if (r0 == r1) goto L_0x00aa
            r1 = -1787870358(0xffffffff956f436a, float:-4.8318846E-26)
            if (r0 == r1) goto L_0x0071
            r1 = 409478171(0x1868241b, float:3.0003526E-24)
            if (r0 == r1) goto L_0x0025
            goto L_0x00e6
        L_0x0025:
            java.lang.String r0 = "share_video"
            boolean r15 = r15.equals(r0)
            if (r15 != 0) goto L_0x002f
            goto L_0x00e6
        L_0x002f:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r15 = r14.this$0
            androidx.lifecycle.LiveData r15 = r15.getCurRecordData()
            java.lang.Object r15 = r15.getValue()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r15 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r15
            if (r15 == 0) goto L_0x00e6
            java.lang.String r7 = r15.getCacheLastWavChannelPath()
            if (r7 == 0) goto L_0x00e6
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r15 = r14.this$0
            android.content.Context r6 = r14.$context
            java.lang.Long r0 = r14.$recordId
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r13 = r14.$callback
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r5 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r14 = r15.getCurRecordEntity()
            if (r14 == 0) goto L_0x005c
            java.lang.String r14 = r14.getShortHandTitle()
            if (r14 != 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r8 = r14
            goto L_0x005d
        L_0x005c:
            r8 = r4
        L_0x005d:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r14 = r15.getCurRecordEntity()
            if (r14 == 0) goto L_0x0067
            long r2 = r14.getCreateTime()
        L_0x0067:
            r11 = r2
            long r9 = r0.longValue()
            r5.getSingleRecordShareVideoPath(r6, r7, r8, r9, r11, r13)
            goto L_0x00e6
        L_0x0071:
            java.lang.String r0 = "share_word"
            boolean r15 = r15.equals(r0)
            if (r15 != 0) goto L_0x007b
            goto L_0x00e6
        L_0x007b:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r5 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            android.content.Context r6 = r14.$context
            java.lang.Long r15 = r14.$recordId
            long r7 = r15.longValue()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r15 = r14.this$0
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r15 = r15.getCurRecordEntity()
            if (r15 == 0) goto L_0x0096
            java.lang.String r15 = r15.getShortHandTitle()
            if (r15 != 0) goto L_0x0094
            goto L_0x0096
        L_0x0094:
            r9 = r15
            goto L_0x0097
        L_0x0096:
            r9 = r4
        L_0x0097:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r15 = r14.this$0
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r15 = r15.getCurRecordEntity()
            if (r15 == 0) goto L_0x00a3
            long r2 = r15.getCreateTime()
        L_0x00a3:
            r10 = r2
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r12 = r14.$callback
            r5.getSingleRecordShareWordPath(r6, r7, r9, r10, r12)
            goto L_0x00e6
        L_0x00aa:
            java.lang.String r0 = "share_video_word"
            boolean r15 = r15.equals(r0)
            if (r15 == 0) goto L_0x00e6
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r5 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r15 = r14.this$0
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r15 = r15.getCurRecordEntity()
            if (r15 == 0) goto L_0x00c5
            java.lang.String r15 = r15.getShortHandTitle()
            if (r15 != 0) goto L_0x00c3
            goto L_0x00c5
        L_0x00c3:
            r10 = r15
            goto L_0x00c6
        L_0x00c5:
            r10 = r4
        L_0x00c6:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r15 = r14.this$0
            java.lang.String r9 = r15.getCurRecordLastWavChannelPath()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel r15 = r14.this$0
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r15 = r15.getCurRecordEntity()
            if (r15 == 0) goto L_0x00d8
            long r2 = r15.getCreateTime()
        L_0x00d8:
            r11 = r2
            android.content.Context r6 = r14.$context
            java.lang.Long r15 = r14.$recordId
            long r7 = r15.longValue()
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r13 = r14.$callback
            r5.getSingleRecordShareMuteTempPath(r6, r7, r9, r10, r11, r13)
        L_0x00e6:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00e9:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordDetailRecordHistoryViewModel$getFastRecordShareFilePath$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
