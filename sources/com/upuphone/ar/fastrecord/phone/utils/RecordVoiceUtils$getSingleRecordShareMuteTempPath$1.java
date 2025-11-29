package com.upuphone.ar.fastrecord.phone.utils;

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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getSingleRecordShareMuteTempPath$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1189:1\n1855#2,2:1190\n1#3:1192\n*S KotlinDebug\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getSingleRecordShareMuteTempPath$1\n*L\n569#1:1190,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareMuteTempPath$1", f = "RecordVoiceUtils.kt", i = {0, 1, 1}, l = {560, 563, 605}, m = "invokeSuspend", n = {"voiceWordList", "voiceWordList", "mRecordSummaryEntity"}, s = {"L$0", "L$0", "L$1"})
public final class RecordVoiceUtils$getSingleRecordShareMuteTempPath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ long $createTime;
    final /* synthetic */ long $recordId;
    final /* synthetic */ String $recordTitle;
    final /* synthetic */ String $wavPath;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getSingleRecordShareMuteTempPath$1(long j, Context context, String str, long j2, String str2, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super RecordVoiceUtils$getSingleRecordShareMuteTempPath$1> continuation) {
        super(2, continuation);
        this.$recordId = j;
        this.$context = context;
        this.$recordTitle = str;
        this.$createTime = j2;
        this.$wavPath = str2;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$getSingleRecordShareMuteTempPath$1(this.$recordId, this.$context, this.$recordTitle, this.$createTime, this.$wavPath, this.$callback, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01a6, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01a7, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01aa, code lost:
        throw r15;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01a0 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x01a1
        L_0x0016:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x001e:
            java.lang.Object r1 = r14.L$1
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r1 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r1
            java.lang.Object r3 = r14.L$0
            java.util.List r3 = (java.util.List) r3
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0081
        L_0x002a:
            java.lang.Object r1 = r14.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x005e
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r15)
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r15 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r15.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordVoiceWordDao r1 = r1.fastRecordVoiceWordDao()
            long r5 = r14.$recordId
            java.util.List r1 = r1.findFastRecordOrderByStartTime(r5)
            com.upuphone.ar.fastrecord.phone.FastRecordManager r15 = r15.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao r5 = r15.fastRecordSummaryDao()
            long r6 = r14.$recordId
            r14.L$0 = r1
            r14.label = r4
            r8 = 0
            r10 = 2
            r11 = 0
            r9 = r14
            java.lang.Object r15 = com.upuphone.ar.fastrecord.phone.db.FastRecordSummaryDao.DefaultImpls.queryNoFinishByRecordId$default(r5, r6, r8, r9, r10, r11)
            if (r15 != r0) goto L_0x005e
            return r0
        L_0x005e:
            com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity r15 = (com.upuphone.ar.fastrecord.phone.db.RecordSummaryEntity) r15
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r4 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r4 = r4.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao r5 = r4.fastRecordTodoItemDao()
            long r6 = r14.$recordId
            r14.L$0 = r1
            r14.L$1 = r15
            r14.label = r3
            r8 = 0
            r10 = 2
            r11 = 0
            r9 = r14
            java.lang.Object r3 = com.upuphone.ar.fastrecord.phone.db.FastRecordTodoItemDao.DefaultImpls.queryAllNoFinishByRecordId$default(r5, r6, r8, r9, r10, r11)
            if (r3 != r0) goto L_0x007d
            return r0
        L_0x007d:
            r13 = r1
            r1 = r15
            r15 = r3
            r3 = r13
        L_0x0081:
            java.util.List r15 = (java.util.List) r15
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r5 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            java.lang.String r1 = r5.getSummaryShareText(r1)
            r4.append(r1)
            java.lang.String r1 = "\n"
            r4.append(r1)
            java.lang.String r15 = r5.getTodoShareText(r15)
            r4.append(r15)
            r4.append(r1)
            java.lang.String r15 = "FastRecord_VoiceUtils"
            if (r3 == 0) goto L_0x00d0
            java.util.Iterator r1 = r3.iterator()
        L_0x00a8:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00d0
            java.lang.Object r3 = r1.next()
            com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity r3 = (com.upuphone.ar.fastrecord.phone.db.RecordVoiceWordEntity) r3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "item info = "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r5, r15)
            java.lang.String r3 = r3.getWordContent()
            r4.append(r3)
            goto L_0x00a8
        L_0x00d0:
            com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils r1 = com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils.INSTANCE
            android.content.Context r3 = r14.$context
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r5 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            java.lang.String r6 = r14.$recordTitle
            long r7 = r14.$createTime
            java.lang.String r6 = r5.getFileShareName(r6, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = ".txt"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.io.File r9 = r1.getTempShareFile(r3, r6)
            boolean r3 = r9.exists()
            if (r3 == 0) goto L_0x00fc
            r9.delete()
        L_0x00fc:
            r9.createNewFile()
            java.io.BufferedWriter r3 = new java.io.BufferedWriter
            java.io.FileWriter r6 = new java.io.FileWriter
            r6.<init>(r9)
            r3.<init>(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r3.write(r4)     // Catch:{ all -> 0x01a4 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01a4 }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            java.lang.String r3 = r9.getPath()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "last file share word path = "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r3, r15)
            android.content.Context r3 = r14.$context
            java.lang.String r6 = r14.$recordTitle
            long r7 = r14.$createTime
            java.lang.String r5 = r5.getFileShareName(r6, r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = ".wav"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.io.File r10 = r1.getTempShareFile(r3, r5)
            java.lang.String r3 = r14.$wavPath
            java.lang.String r5 = r10.getPath()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "copyDataPathToCachePath wavPath path = "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = ",  shareTempFile path = "
            r6.append(r3)
            r6.append(r5)
            java.lang.String r3 = r6.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r3, r15)
            java.lang.String r15 = r14.$wavPath
            if (r15 == 0) goto L_0x0185
            java.lang.String r3 = r10.getPath()
            java.lang.String r5 = "getPath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            r1.copyFile(r15, r3)
        L_0x0185:
            kotlinx.coroutines.MainCoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareMuteTempPath$1$4 r1 = new com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareMuteTempPath$1$4
            android.content.Context r8 = r14.$context
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r11 = r14.$callback
            r12 = 0
            r7 = r1
            r7.<init>(r8, r9, r10, r11, r12)
            r14.L$0 = r4
            r14.L$1 = r4
            r14.label = r2
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r15, r1, r14)
            if (r14 != r0) goto L_0x01a1
            return r0
        L_0x01a1:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x01a4:
            r14 = move-exception
            throw r14     // Catch:{ all -> 0x01a6 }
        L_0x01a6:
            r15 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareMuteTempPath$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$getSingleRecordShareMuteTempPath$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
