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

@SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getRecordListWordUirList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1189:1\n1855#2,2:1190\n*S KotlinDebug\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getRecordListWordUirList$1\n*L\n159#1:1190,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordListWordUirList$1", f = "RecordVoiceUtils.kt", i = {0, 0, 0}, l = {166, 188}, m = "invokeSuspend", n = {"uriList", "hashWordNameMap", "wordFileName"}, s = {"L$0", "L$1", "L$4"})
public final class RecordVoiceUtils$getRecordListWordUirList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<RecordEntity> $recordList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getRecordListWordUirList$1(List<RecordEntity> list, Context context, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super RecordVoiceUtils$getRecordListWordUirList$1> continuation) {
        super(2, continuation);
        this.$recordList = list;
        this.$context = context;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$getRecordListWordUirList$1(this.$recordList, this.$context, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b6  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00db
        L_0x0013:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x001b:
            java.lang.Object r1 = r14.L$4
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r14.L$3
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r14.L$2
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Object r6 = r14.L$1
            java.util.HashMap r6 = (java.util.HashMap) r6
            java.lang.Object r7 = r14.L$0
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            kotlin.ResultKt.throwOnFailure(r15)
            r12 = r1
            r1 = r6
            r11 = r7
            goto L_0x008e
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.List<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r4 = r14.$recordList
            android.content.Context r5 = r14.$context
            java.util.Iterator r4 = r4.iterator()
            r11 = r15
        L_0x004c:
            r15 = r5
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00bc
            java.lang.Object r5 = r4.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r5 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r5
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r6 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            long r7 = r5.getCreateTime()
            java.lang.String r9 = r5.getShortHandTitle()
            if (r9 != 0) goto L_0x0067
            java.lang.String r9 = ""
        L_0x0067:
            java.lang.String r12 = r6.getFileShareName(r9, r7)
            long r7 = r5.getRecordId()
            java.lang.String r5 = ".txt"
            java.lang.String r9 = r6.getFileNameAndHashMap(r1, r12, r5)
            r14.L$0 = r11
            r14.L$1 = r1
            r14.L$2 = r15
            r14.L$3 = r4
            r14.L$4 = r12
            r14.label = r3
            r5 = r6
            r6 = r15
            r10 = r14
            java.lang.Object r5 = r5.getRecordWordShareFile(r6, r7, r9, r10)
            if (r5 != r0) goto L_0x008b
            return r0
        L_0x008b:
            r13 = r5
            r5 = r15
            r15 = r13
        L_0x008e:
            java.io.File r15 = (java.io.File) r15
            if (r15 == 0) goto L_0x00b6
            java.lang.String r6 = "com.upuphone.ar.shorthand.phone.fileprovider"
            android.net.Uri r15 = androidx.core.content.FileProvider.getUriForFile(r5, r6, r15)
            java.lang.String r6 = r15.getPath()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "getRecordListWordUirList uri path = "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FastRecord_VoiceUtils"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r6, r7)
            r11.add(r15)
            goto L_0x004c
        L_0x00b6:
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r15 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            r15.subNameHashMap(r1, r12)
            goto L_0x004c
        L_0x00bc:
            kotlinx.coroutines.MainCoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordListWordUirList$1$2 r1 = new com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordListWordUirList$1$2
            kotlin.jvm.functions.Function1<java.util.ArrayList<android.net.Uri>, kotlin.Unit> r3 = r14.$callback
            r4 = 0
            r1.<init>(r3, r11, r4)
            r14.L$0 = r4
            r14.L$1 = r4
            r14.L$2 = r4
            r14.L$3 = r4
            r14.L$4 = r4
            r14.label = r2
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r15, r1, r14)
            if (r14 != r0) goto L_0x00db
            return r0
        L_0x00db:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getRecordListWordUirList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$getRecordListWordUirList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
