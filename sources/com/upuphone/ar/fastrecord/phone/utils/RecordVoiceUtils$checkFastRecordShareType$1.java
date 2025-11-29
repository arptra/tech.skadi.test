package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$checkFastRecordShareType$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1189:1\n1855#2:1190\n1856#2:1192\n1855#2,2:1193\n1#3:1191\n*S KotlinDebug\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$checkFastRecordShareType$1\n*L\n96#1:1190\n96#1:1192\n103#1:1193,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkFastRecordShareType$1", f = "RecordVoiceUtils.kt", i = {0, 1}, l = {98, 101, 110}, m = "invokeSuspend", n = {"recordIdListNew", "recordIdListNew"}, s = {"L$0", "L$0"})
public final class RecordVoiceUtils$checkFastRecordShareType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $callback;
    final /* synthetic */ Ref.BooleanRef $isHasAudio;
    final /* synthetic */ Ref.BooleanRef $isHasWord;
    final /* synthetic */ ArrayList<RecordEntity> $recordIdList;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$checkFastRecordShareType$1(ArrayList<RecordEntity> arrayList, Ref.BooleanRef booleanRef, Ref.BooleanRef booleanRef2, Function1<? super Integer, Unit> function1, Continuation<? super RecordVoiceUtils$checkFastRecordShareType$1> continuation) {
        super(2, continuation);
        this.$recordIdList = arrayList;
        this.$isHasWord = booleanRef;
        this.$isHasAudio = booleanRef2;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$checkFastRecordShareType$1(this.$recordIdList, this.$isHasWord, this.$isHasAudio, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0124 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            r8 = 3
            r9 = 2
            r10 = 1
            if (r0 == 0) goto L_0x003c
            if (r0 == r10) goto L_0x002d
            if (r0 == r9) goto L_0x001e
            if (r0 != r8) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0125
        L_0x0016:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x001e:
            java.lang.Object r0 = r13.L$1
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            java.lang.Object r1 = r13.L$0
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r12 = r1
            r1 = r14
            goto L_0x0093
        L_0x002d:
            java.lang.Object r0 = r13.L$1
            java.util.Iterator r0 = (java.util.Iterator) r0
            java.lang.Object r1 = r13.L$0
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r11 = r0
            r12 = r1
            r0 = r14
            goto L_0x007a
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r14)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r1 = r13.$recordIdList
            java.util.Iterator r1 = r1.iterator()
            r12 = r0
            r11 = r1
        L_0x004c:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0082
            java.lang.Object r0 = r11.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            com.upuphone.ar.fastrecord.phone.FastRecordManager$Companion r1 = com.upuphone.ar.fastrecord.phone.FastRecordManager.Companion
            com.upuphone.ar.fastrecord.phone.FastRecordManager r1 = r1.getInstance()
            com.upuphone.ar.fastrecord.phone.db.FastRecordDao r1 = r1.fastRecordDao()
            long r2 = r0.getRecordId()
            r13.L$0 = r12
            r13.L$1 = r11
            r13.label = r10
            r4 = 0
            r5 = 2
            r6 = 0
            r0 = r1
            r1 = r2
            r3 = r4
            r4 = r13
            java.lang.Object r0 = com.upuphone.ar.fastrecord.phone.db.FastRecordDao.DefaultImpls.findRecordEntityById$default(r0, r1, r3, r4, r5, r6)
            if (r0 != r7) goto L_0x007a
            return r7
        L_0x007a:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r0
            if (r0 == 0) goto L_0x004c
            r12.add(r0)
            goto L_0x004c
        L_0x0082:
            kotlin.jvm.internal.Ref$BooleanRef r0 = r13.$isHasWord
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils r1 = com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils.INSTANCE
            r13.L$0 = r12
            r13.L$1 = r0
            r13.label = r9
            java.lang.Object r1 = r1.checkWordState(r12, r13)
            if (r1 != r7) goto L_0x0093
            return r7
        L_0x0093:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.element = r1
            int r0 = r12.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "checkFastRecordShareType recordIdListNew size = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "FastRecord_VoiceUtils"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r0, r1)
            kotlin.jvm.internal.Ref$BooleanRef r0 = r13.$isHasAudio
            java.util.Iterator r2 = r12.iterator()
        L_0x00bb:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0108
            java.lang.Object r3 = r2.next()
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r3 = (com.upuphone.ar.fastrecord.phone.db.RecordEntity) r3
            java.lang.String r4 = r3.getCacheLastWavChannelPath()
            if (r4 == 0) goto L_0x00d6
            int r4 = r4.length()
            if (r4 != 0) goto L_0x00d4
            goto L_0x00d6
        L_0x00d4:
            r4 = 0
            goto L_0x00d7
        L_0x00d6:
            r4 = r10
        L_0x00d7:
            r4 = r4 ^ r10
            java.lang.String r5 = r3.getShortHandTitle()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "checkFastRecordShareType cacheLastWavChannelPath value = "
            r6.append(r9)
            r6.append(r4)
            java.lang.String r4 = ",,title = "
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r4, r1)
            java.lang.String r3 = r3.getCacheLastWavChannelPath()
            if (r3 == 0) goto L_0x00bb
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0105
            goto L_0x00bb
        L_0x0105:
            r0.element = r10
            goto L_0x00bb
        L_0x0108:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkFastRecordShareType$1$3 r1 = new com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkFastRecordShareType$1$3
            kotlin.jvm.internal.Ref$BooleanRef r2 = r13.$isHasWord
            kotlin.jvm.internal.Ref$BooleanRef r3 = r13.$isHasAudio
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> r4 = r13.$callback
            r5 = 0
            r1.<init>(r2, r3, r4, r5)
            r13.L$0 = r5
            r13.L$1 = r5
            r13.label = r8
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r1, r13)
            if (r0 != r7) goto L_0x0125
            return r7
        L_0x0125:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$checkFastRecordShareType$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$checkFastRecordShareType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
