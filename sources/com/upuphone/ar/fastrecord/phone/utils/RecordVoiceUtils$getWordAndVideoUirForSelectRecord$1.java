package com.upuphone.ar.fastrecord.phone.utils;

import android.content.Context;
import android.net.Uri;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import java.util.ArrayList;
import java.util.List;
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

@SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1189:1\n1855#2:1190\n1856#2:1192\n1855#2,2:1193\n1855#2,2:1195\n1#3:1191\n*S KotlinDebug\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1\n*L\n248#1:1190\n248#1:1192\n256#1:1193,2\n312#1:1195,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1", f = "RecordVoiceUtils.kt", i = {0, 0, 1, 1, 1, 1}, l = {250, 289, 315}, m = "invokeSuspend", n = {"uriList", "recordIdListNew", "uriList", "hashWordNameMap", "hashVideoNameMap", "wordFileName"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$5"})
public final class RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<RecordEntity> $recordList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1(List<RecordEntity> list, Context context, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1> continuation) {
        super(2, continuation);
        this.$recordList = list;
        this.$context = context;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1(this.$recordList, this.$context, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01b1 A[LOOP:0: B:44:0x01ab->B:46:0x01b1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f1 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r7 = r19
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            java.lang.String r9 = "com.upuphone.ar.shorthand.phone.fileprovider"
            r10 = 3
            r11 = 2
            r12 = 1
            java.lang.String r13 = "FastRecord_VoiceUtils"
            if (r0 == 0) goto L_0x005b
            if (r0 == r12) goto L_0x0046
            if (r0 == r11) goto L_0x0024
            if (r0 != r10) goto L_0x001c
            kotlin.ResultKt.throwOnFailure(r20)
            goto L_0x01f2
        L_0x001c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0024:
            java.lang.Object r0 = r7.L$5
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r7.L$4
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r7.L$3
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r3 = r7.L$2
            java.util.HashMap r3 = (java.util.HashMap) r3
            java.lang.Object r4 = r7.L$1
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.lang.Object r5 = r7.L$0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            kotlin.ResultKt.throwOnFailure(r20)
            r6 = r1
            r1 = r8
            r8 = r0
            r0 = r20
            goto L_0x018a
        L_0x0046:
            java.lang.Object r0 = r7.L$2
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r1 = r7.L$1
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.Object r2 = r7.L$0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            kotlin.ResultKt.throwOnFailure(r20)
            r14 = r0
            r15 = r1
            r6 = r2
            r0 = r20
            goto L_0x00c3
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r20)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r1 = r7.$recordList
            int r1 = r1.size()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getRecordWordAndVideoUirList recordList size = "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r1, r13)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r2 = r7.$recordList
            java.util.Iterator r2 = r2.iterator()
            r6 = r0
            r15 = r1
            r14 = r2
        L_0x008b:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x00cb
            java.lang.Object r0 = r14.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r1 = r1.fastRecordDao()
            long r2 = r0.getRecordId()
            r7.L$0 = r6
            r7.L$1 = r15
            r7.L$2 = r14
            r7.label = r12
            r4 = 0
            r5 = 2
            r16 = 0
            r0 = r1
            r1 = r2
            r3 = r4
            r4 = r19
            r17 = r6
            r6 = r16
            java.lang.Object r0 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r0, r1, r3, r4, r5, r6)
            if (r0 != r8) goto L_0x00c1
            return r8
        L_0x00c1:
            r6 = r17
        L_0x00c3:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            if (r0 == 0) goto L_0x008b
            r15.add(r0)
            goto L_0x008b
        L_0x00cb:
            r17 = r6
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.Context r2 = r7.$context
            java.util.Iterator r3 = r15.iterator()
            r15 = r0
            r14 = r1
            r12 = r2
            r6 = r3
            r5 = r17
        L_0x00e3:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x01a5
            java.lang.Object r0 = r6.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            java.lang.String r1 = r0.getCacheLastWavChannelPath()
            if (r1 == 0) goto L_0x019f
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r2 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            long r3 = r0.getCreateTime()
            java.lang.String r16 = r0.getShortHandTitle()
            java.lang.String r17 = ""
            if (r16 != 0) goto L_0x0106
            r10 = r17
            goto L_0x0108
        L_0x0106:
            r10 = r16
        L_0x0108:
            java.lang.String r3 = r2.getFileShareName(r10, r3)
            com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils r4 = com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils.INSTANCE
            java.lang.String r10 = ".wav"
            java.lang.String r3 = r2.getFileNameAndHashMap(r14, r3, r10)
            java.io.File r3 = r4.getTempShareFile(r12, r3)
            java.lang.String r10 = r3.getPath()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r18 = r8
            java.lang.String r8 = "copyDataPathToCachePath wavPath path = "
            r11.append(r8)
            r11.append(r1)
            java.lang.String r8 = ",  shareTempFile path = "
            r11.append(r8)
            r11.append(r10)
            java.lang.String r8 = r11.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r8, r13)
            java.lang.String r8 = r3.getPath()
            java.lang.String r10 = "getPath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            r4.copyFile(r1, r8)
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r12, r9, r3)
            r5.add(r1)
            long r3 = r0.getCreateTime()
            java.lang.String r1 = r0.getShortHandTitle()
            if (r1 != 0) goto L_0x0159
            r1 = r17
        L_0x0159:
            java.lang.String r8 = r2.getFileShareName(r1, r3)
            long r3 = r0.getRecordId()
            java.lang.String r0 = ".txt"
            java.lang.String r10 = r2.getFileNameAndHashMap(r15, r8, r0)
            r7.L$0 = r5
            r7.L$1 = r15
            r7.L$2 = r14
            r7.L$3 = r12
            r7.L$4 = r6
            r7.L$5 = r8
            r11 = 2
            r7.label = r11
            r0 = r2
            r1 = r12
            r2 = r3
            r4 = r10
            r10 = r5
            r5 = r19
            java.lang.Object r0 = r0.getRecordWordShareFile(r1, r2, r4, r5)
            r1 = r18
            if (r0 != r1) goto L_0x0186
            return r1
        L_0x0186:
            r5 = r10
            r2 = r12
            r3 = r14
            r4 = r15
        L_0x018a:
            java.io.File r0 = (java.io.File) r0
            if (r0 == 0) goto L_0x0196
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r2, r9, r0)
            r5.add(r0)
            goto L_0x019b
        L_0x0196:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r0 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            r0.subNameHashMap(r4, r8)
        L_0x019b:
            r12 = r2
            r14 = r3
            r15 = r4
            goto L_0x01a1
        L_0x019f:
            r10 = r5
            r1 = r8
        L_0x01a1:
            r8 = r1
            r10 = 3
            goto L_0x00e3
        L_0x01a5:
            r10 = r5
            r1 = r8
            java.util.Iterator r0 = r10.iterator()
        L_0x01ab:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01d0
            java.lang.Object r2 = r0.next()
            android.net.Uri r2 = (android.net.Uri) r2
            java.lang.String r2 = r2.getPath()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getRecordWordAndVideoUirList url = "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r2, r13)
            goto L_0x01ab
        L_0x01d0:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1$4 r2 = new com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1$4
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r3 = r7.$callback
            r4 = 0
            r2.<init>(r3, r10, r4)
            r7.L$0 = r4
            r7.L$1 = r4
            r7.L$2 = r4
            r7.L$3 = r4
            r7.L$4 = r4
            r7.L$5 = r4
            r3 = 3
            r7.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r2, r7)
            if (r0 != r1) goto L_0x01f2
            return r1
        L_0x01f2:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$getWordAndVideoUirForSelectRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
