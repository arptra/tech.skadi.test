package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
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

@SourceDebugExtension({"SMAP\nTiciAppViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciAppViewModel.kt\ncom/upuphone/ar/tici/phone/TiciAppViewModel$startTici$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,677:1\n1#2:678\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$startTici$2", f = "TiciAppViewModel.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4}, l = {314, 331, 350, 363, 368}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "currentPage", "highlightIndex", "$this$launch", "currentPage", "highlightIndex", "currentPage", "ticiContentPart", "highlightIndex", "currentPage", "ticiContentPart", "prevParagraphItemList", "highlightIndex"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0"})
public final class TiciAppViewModel$startTici$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OpenTiciFrom $from;
    final /* synthetic */ boolean $restart;
    final /* synthetic */ boolean $restartIfReachLast;
    final /* synthetic */ long $sendContentDelay;
    final /* synthetic */ Integer $targetIndex;
    final /* synthetic */ Integer $targetPage;
    final /* synthetic */ TiciEntity $ticiEntity;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$startTici$2(TiciAppViewModel ticiAppViewModel, TiciEntity ticiEntity, boolean z, Integer num, Integer num2, boolean z2, OpenTiciFrom openTiciFrom, long j, Continuation<? super TiciAppViewModel$startTici$2> continuation) {
        super(2, continuation);
        this.this$0 = ticiAppViewModel;
        this.$ticiEntity = ticiEntity;
        this.$restart = z;
        this.$targetPage = num;
        this.$targetIndex = num2;
        this.$restartIfReachLast = z2;
        this.$from = openTiciFrom;
        this.$sendContentDelay = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TiciAppViewModel$startTici$2 ticiAppViewModel$startTici$2 = new TiciAppViewModel$startTici$2(this.this$0, this.$ticiEntity, this.$restart, this.$targetPage, this.$targetIndex, this.$restartIfReachLast, this.$from, this.$sendContentDelay, continuation);
        ticiAppViewModel$startTici$2.L$0 = obj;
        return ticiAppViewModel$startTici$2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0167 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0258 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0269 A[LOOP:0: B:75:0x0263->B:77:0x0269, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0283 A[LOOP:1: B:79:0x027d->B:81:0x0283, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x029c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r26) {
        /*
            r25 = this;
            r0 = r25
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = ", page: "
            java.lang.String r4 = "startTici, can`t find ticiContentPart for id: "
            java.lang.String r5 = "startTici, id: "
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = 1
            java.lang.String r10 = "TiciAppViewModel"
            r11 = 2
            r12 = 0
            r13 = 0
            if (r2 == 0) goto L_0x0080
            if (r2 == r9) goto L_0x0076
            if (r2 == r11) goto L_0x0065
            if (r2 == r8) goto L_0x0052
            if (r2 == r7) goto L_0x0040
            if (r2 != r6) goto L_0x0038
            int r1 = r0.I$0
            java.lang.Object r2 = r0.L$2
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r3 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r3
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.ResultKt.throwOnFailure(r26)
            r5 = r26
            goto L_0x025c
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            int r2 = r0.I$0
            java.lang.Object r3 = r0.L$1
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r3 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r3
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.ResultKt.throwOnFailure(r26)
            r6 = r3
            r3 = r26
            goto L_0x0237
        L_0x0052:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r5 = (kotlin.jvm.internal.Ref.IntRef) r5
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.ResultKt.throwOnFailure(r26)
            r6 = r5
            r5 = r2
            r2 = r26
            goto L_0x01dc
        L_0x0065:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r5 = (kotlin.jvm.internal.Ref.IntRef) r5
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r26)
            r6 = r26
            goto L_0x016d
        L_0x0076:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r26)
            r6 = r26
            goto L_0x00e8
        L_0x0080:
            kotlin.ResultKt.throwOnFailure(r26)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.upuphone.ar.tici.phone.TiciAppViewModel r14 = r0.this$0
            boolean r14 = r14.V()
            if (r14 != 0) goto L_0x011f
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r14 = r0.$ticiEntity
            long r14 = r14.getFileSize()
            r16 = 204800(0x32000, double:1.011846E-318)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x00d1
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = r0.$ticiEntity
            long r1 = r1.getId()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r0 = r0.$ticiEntity
            long r3 = r0.getFileSize()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r1)
            java.lang.String r1 = ", fileSize("
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = ") over size"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r10, r13, r11, r13)
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b
            int r1 = com.upuphone.ar.tici.R.string.tici_file_over_size_200k_toast
            r0.x(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00d1:
            com.upuphone.ar.tici.phone.TiciApp r14 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r14 = r14.w()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r15 = r0.$ticiEntity
            long r6 = r15.getId()
            r0.L$0 = r2
            r0.label = r9
            java.lang.Object r6 = r14.e(r6, r0)
            if (r6 != r1) goto L_0x00e8
            return r1
        L_0x00e8:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r6 <= r9) goto L_0x011f
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r0 = r0.$ticiEntity
            long r0 = r0.getId()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r0 = ", ticiContentPartCount("
            r2.append(r0)
            r2.append(r6)
            java.lang.String r0 = ") over limit"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r10, r13, r11, r13)
            com.upuphone.ar.tici.phone.TiciApp r0 = com.upuphone.ar.tici.phone.TiciApp.b
            int r1 = com.upuphone.ar.tici.R.string.tici_file_over_size_200k_toast
            r0.x(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x011f:
            r9 = r2
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            boolean r5 = r0.$restart
            if (r5 == 0) goto L_0x012b
            r5 = r12
            goto L_0x013a
        L_0x012b:
            java.lang.Integer r5 = r0.$targetPage
            if (r5 == 0) goto L_0x0134
            int r5 = r5.intValue()
            goto L_0x013a
        L_0x0134:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r5 = r0.$ticiEntity
            int r5 = r5.getCurrentPage()
        L_0x013a:
            r2.element = r5
            java.lang.Integer r5 = r0.$targetIndex
            if (r5 == 0) goto L_0x0145
            int r5 = r5.intValue()
            goto L_0x014b
        L_0x0145:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r5 = r0.$ticiEntity
            int r5 = r5.getIndex()
        L_0x014b:
            com.upuphone.ar.tici.phone.TiciApp r6 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r6 = r6.w()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r7 = r0.$ticiEntity
            long r14 = r7.getId()
            int r7 = r2.element
            r0.L$0 = r9
            r0.L$1 = r2
            r0.I$0 = r5
            r0.label = r11
            java.lang.Object r6 = r6.b(r14, r7, r0)
            if (r6 != r1) goto L_0x0168
            return r1
        L_0x0168:
            r24 = r5
            r5 = r2
            r2 = r24
        L_0x016d:
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r6 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r6
            if (r6 != 0) goto L_0x0194
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r0 = r0.$ticiEntity
            long r0 = r0.getId()
            int r2 = r5.element
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r0)
            r5.append(r3)
            r5.append(r2)
            java.lang.String r0 = r5.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r10, r13, r11, r13)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0194:
            boolean r7 = r0.$restart
            if (r7 == 0) goto L_0x019c
            r5.element = r12
            r2 = r12
            goto L_0x0209
        L_0x019c:
            boolean r7 = r0.$restartIfReachLast
            if (r7 == 0) goto L_0x0209
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r7 = r0.$ticiEntity
            int r14 = r5.element
            boolean r7 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.d(r7, r14)
            if (r7 == 0) goto L_0x0209
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r7 = r0.$ticiEntity
            int r7 = r7.getIndex()
            boolean r7 = com.upuphone.ar.tici.phone.db.entity.TiciContentPartKt.a(r6, r7)
            if (r7 == 0) goto L_0x0209
            java.lang.String r2 = "startTici, isLastPage and isReachLast, set highlightIndex to 0"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r2, r10, r13, r11, r13)
            r5.element = r12
            com.upuphone.ar.tici.phone.TiciApp r2 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r2 = r2.w()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r6 = r0.$ticiEntity
            long r6 = r6.getId()
            int r14 = r5.element
            r0.L$0 = r9
            r0.L$1 = r5
            r0.I$0 = r12
            r0.label = r8
            java.lang.Object r2 = r2.b(r6, r14, r0)
            if (r2 != r1) goto L_0x01da
            return r1
        L_0x01da:
            r6 = r5
            r5 = r12
        L_0x01dc:
            com.upuphone.ar.tici.phone.db.entity.TiciContentPart r2 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r2
            if (r2 != 0) goto L_0x0203
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r0 = r0.$ticiEntity
            long r0 = r0.getId()
            int r2 = r6.element
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r0)
            r5.append(r3)
            r5.append(r2)
            java.lang.String r0 = r5.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r10, r13, r11, r13)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0203:
            r24 = r6
            r6 = r2
            r2 = r5
            r5 = r24
        L_0x0209:
            com.upuphone.ar.tici.phone.TiciAppViewModel r3 = r0.this$0
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r4 = r0.$ticiEntity
            r3.H0(r4)
            com.upuphone.ar.tici.phone.TiciAppViewModel r3 = r0.this$0
            boolean r3 = r3.V()
            if (r3 == 0) goto L_0x029c
            com.upuphone.ar.tici.phone.TiciApp r3 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r3 = r3.w()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r4 = r0.$ticiEntity
            long r7 = r4.getId()
            int r4 = r5.element
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r2
            r9 = 4
            r0.label = r9
            java.lang.Object r3 = r3.j(r7, r4, r0)
            if (r3 != r1) goto L_0x0236
            return r1
        L_0x0236:
            r4 = r5
        L_0x0237:
            java.util.List r3 = (java.util.List) r3
            com.upuphone.ar.tici.phone.TiciApp r5 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r5 = r5.w()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r7 = r0.$ticiEntity
            long r7 = r7.getId()
            int r9 = r4.element
            r0.L$0 = r4
            r0.L$1 = r6
            r0.L$2 = r3
            r0.I$0 = r2
            r10 = 5
            r0.label = r10
            java.lang.Object r5 = r5.o(r7, r9, r0)
            if (r5 != r1) goto L_0x0259
            return r1
        L_0x0259:
            r1 = r2
            r2 = r3
            r3 = r6
        L_0x025c:
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r2 = r2.iterator()
            r6 = r12
        L_0x0263:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0279
            java.lang.Object r7 = r2.next()
            java.lang.String r7 = (java.lang.String) r7
            java.util.List r7 = com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyKt.d(r7)
            int r7 = r7.size()
            int r6 = r6 + r7
            goto L_0x0263
        L_0x0279:
            java.util.Iterator r2 = r5.iterator()
        L_0x027d:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0293
            java.lang.Object r5 = r2.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.List r5 = com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyKt.d(r5)
            int r5 = r5.size()
            int r12 = r12 + r5
            goto L_0x027d
        L_0x0293:
            r17 = r1
            r15 = r3
            r5 = r4
            r19 = r6
            r20 = r12
            goto L_0x02a3
        L_0x029c:
            r17 = r2
            r15 = r6
            r19 = r12
            r20 = r19
        L_0x02a3:
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r13 = r1.q()
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r14 = r0.$ticiEntity
            int r2 = r5.element
            com.upuphone.ar.tici.phone.TiciAppViewModel r3 = r0.this$0
            boolean r18 = r3.V()
            com.upuphone.ar.tici.phone.data.OpenTiciFrom r3 = r0.$from
            long r4 = r0.$sendContentDelay
            r16 = r2
            r21 = r3
            r22 = r4
            r13.sendOpenAppMsg(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            int r2 = com.upuphone.ar.tici.phone.utils.SpUtilKt.j()
            int r3 = com.upuphone.ar.tici.phone.utils.SpUtilKt.h()
            com.upuphone.ar.tici.phone.utils.TiciDataTrack r4 = com.upuphone.ar.tici.phone.utils.TiciDataTrack.f6001a
            java.lang.String r5 = "mode"
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r5, r2)
            android.content.Context r1 = r1.a()
            int r1 = r4.b(r1)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.String r2 = "notice"
            kotlin.Pair r7 = kotlin.TuplesKt.to(r2, r1)
            java.lang.String r1 = "display"
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r1, r2)
            com.upuphone.ar.tici.phone.data.OpenTiciFrom r1 = r0.$from
            int r1 = r1.getValue()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            java.lang.String r2 = "page"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r2, r1)
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r1 = r0.$ticiEntity
            long r1 = r1.getFileSize()
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)
            java.lang.String r2 = "byte_size"
            kotlin.Pair r10 = kotlin.TuplesKt.to(r2, r1)
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r0 = r0.$ticiEntity
            int r0 = r0.getTotalTextLength()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            java.lang.String r1 = "string_size"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r1, r0)
            kotlin.Pair[] r0 = new kotlin.Pair[]{r6, r7, r8, r9, r10, r11}
            java.util.Map r0 = kotlin.collections.MapsKt.mapOf(r0)
            java.lang.String r1 = "app_prompt"
            r4.c(r1, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciAppViewModel$startTici$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$startTici$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
