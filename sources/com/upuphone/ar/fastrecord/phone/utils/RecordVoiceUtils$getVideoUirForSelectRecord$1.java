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

@SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getVideoUirForSelectRecord$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1189:1\n1855#2:1190\n1856#2:1192\n1855#2,2:1193\n1#3:1191\n*S KotlinDebug\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getVideoUirForSelectRecord$1\n*L\n335#1:1190\n335#1:1192\n341#1:1193,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getVideoUirForSelectRecord$1", f = "RecordVoiceUtils.kt", i = {0, 0}, l = {337, 364}, m = "invokeSuspend", n = {"audioFilePathArray", "recordIdListNew"}, s = {"L$0", "L$1"})
public final class RecordVoiceUtils$getVideoUirForSelectRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<RecordEntity> $recordList;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getVideoUirForSelectRecord$1(List<RecordEntity> list, Context context, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super RecordVoiceUtils$getVideoUirForSelectRecord$1> continuation) {
        super(2, continuation);
        this.$recordList = list;
        this.$context = context;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$getVideoUirForSelectRecord$1(this.$recordList, this.$context, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            r8 = 2
            r9 = 1
            if (r0 == 0) goto L_0x002f
            if (r0 == r9) goto L_0x001b
            if (r0 != r8) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0107
        L_0x0013:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x001b:
            java.lang.Object r0 = r13.L$2
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r1 = r13.L$1
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.Object r2 = r13.L$0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r10 = r0
            r11 = r1
            r12 = r2
            r0 = r14
            goto L_0x0075
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r2 = r13.$recordList
            java.util.Iterator r2 = r2.iterator()
            r12 = r0
            r11 = r1
            r10 = r2
        L_0x0045:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x007d
            java.lang.Object r0 = r10.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r1 = r1.fastRecordDao()
            long r2 = r0.getRecordId()
            r13.L$0 = r12
            r13.L$1 = r11
            r13.L$2 = r10
            r13.label = r9
            r4 = 0
            r5 = 2
            r6 = 0
            r0 = r1
            r1 = r2
            r3 = r4
            r4 = r13
            java.lang.Object r0 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r0, r1, r3, r4, r5, r6)
            if (r0 != r7) goto L_0x0075
            return r7
        L_0x0075:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            if (r0 == 0) goto L_0x0045
            r11.add(r0)
            goto L_0x0045
        L_0x007d:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.content.Context r1 = r13.$context
            java.util.Iterator r2 = r11.iterator()
        L_0x0088:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00ea
            java.lang.Object r3 = r2.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r3 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r3
            java.lang.String r4 = r3.getCacheLastWavChannelPath()
            if (r4 == 0) goto L_0x0088
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r5 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            long r9 = r3.getCreateTime()
            java.lang.String r3 = r3.getShortHandTitle()
            if (r3 != 0) goto L_0x00a8
            java.lang.String r3 = ""
        L_0x00a8:
            java.lang.String r3 = r5.getFileShareName(r3, r9)
            com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils r6 = com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils.INSTANCE
            java.lang.String r9 = ".wav"
            java.lang.String r3 = r5.getFileNameAndHashMap(r0, r3, r9)
            java.io.File r3 = r6.getTempShareFile(r1, r3)
            java.lang.String r5 = r3.getPath()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "copyDataPathToCachePath wavPath path = "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = ",  shareTempFile path = "
            r9.append(r10)
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            java.lang.String r9 = "FastRecord_VoiceUtils"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r5, r9)
            java.lang.String r5 = r3.getPath()
            java.lang.String r9 = "getPath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r6.copyFile(r4, r5)
            r12.add(r3)
            goto L_0x0088
        L_0x00ea:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getVideoUirForSelectRecord$1$3 r1 = new com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getVideoUirForSelectRecord$1$3
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r2 = r13.$callback
            android.content.Context r3 = r13.$context
            r4 = 0
            r1.<init>(r12, r2, r3, r4)
            r13.L$0 = r4
            r13.L$1 = r4
            r13.L$2 = r4
            r13.label = r8
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r1, r13)
            if (r0 != r7) goto L_0x0107
            return r7
        L_0x0107:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getVideoUirForSelectRecord$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$getVideoUirForSelectRecord$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
