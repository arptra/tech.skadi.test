package com.upuphone.ar.tici.phone.starrynet;

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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager$sendTiciContentPart$1", f = "TiciStarryMsgManager.kt", i = {0, 0, 0}, l = {394}, m = "invokeSuspend", n = {"offsetSize", "totalSendByteSize", "it"}, s = {"L$0", "L$1", "I$3"})
public final class TiciStarryMsgManager$sendTiciContentPart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentPage;
    final /* synthetic */ String $fileKey;
    final /* synthetic */ String $sourceText;
    final /* synthetic */ int $totalPart;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciStarryMsgManager$sendTiciContentPart$1(int i, String str, String str2, int i2, Continuation<? super TiciStarryMsgManager$sendTiciContentPart$1> continuation) {
        super(2, continuation);
        this.$totalPart = i;
        this.$sourceText = str;
        this.$fileKey = str2;
        this.$currentPage = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciStarryMsgManager$sendTiciContentPart$1(this.$totalPart, this.$sourceText, this.$fileKey, this.$currentPage, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0173  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            java.lang.String r9 = "sendTiciContentPart, part: "
            r10 = 1
            java.lang.String r11 = "TiciStarryMsgManager"
            if (r1 == 0) goto L_0x004e
            if (r1 != r10) goto L_0x0046
            int r1 = r0.I$3
            int r2 = r0.I$2
            int r3 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.Ref$IntRef r7 = (kotlin.jvm.internal.Ref.IntRef) r7
            java.lang.Object r12 = r0.L$0
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref.IntRef) r12
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Exception -> 0x0042 }
            r13 = r22
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r13 = r13.m29unboximpl()     // Catch:{ Exception -> 0x0042 }
            r10 = r2
            r2 = r8
            r19 = r9
            r15 = r12
            r20 = r6
            r6 = r3
            r3 = r5
            r5 = r4
            r4 = r20
            goto L_0x0149
        L_0x0042:
            r0 = move-exception
            r12 = r9
            goto L_0x018a
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r22)
            int r1 = r0.$totalPart
            java.lang.String r2 = r0.$sourceText
            int r2 = r2.length()
            java.lang.String r3 = r0.$sourceText
            int r3 = com.upuphone.ar.tici.phone.utils.StringExtKt.a(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "sendTiciContentPart, totalPart: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = ", sourceTextLength: "
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = ", sourceByteSize: "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = r4.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r11)
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            int r3 = r0.$totalPart
            java.lang.String r4 = r0.$sourceText
            java.lang.String r5 = r0.$fileKey
            int r6 = r0.$currentPage
            r7 = 0
            r20 = r5
            r5 = r3
            r3 = r20
        L_0x009b:
            if (r7 >= r5) goto L_0x01a9
            int r12 = r4.length()
            int r13 = r1.element
            int r12 = r12 - r13
            r13 = 10240(0x2800, float:1.4349E-41)
            int r12 = java.lang.Math.min(r13, r12)
            int r13 = r1.element
            int r12 = r12 + r13
            java.lang.String r15 = r4.substring(r13, r12)
            java.lang.String r14 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r14)
            r1.element = r12
            int r14 = com.upuphone.ar.tici.phone.utils.StringExtKt.a(r15)
            int r10 = r2.element
            int r10 = r10 + r14
            r2.element = r10
            r18 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r9)
            r8.append(r7)
            r19 = r9
            java.lang.String r9 = ", start: "
            r8.append(r9)
            r8.append(r13)
            java.lang.String r9 = ", end: "
            r8.append(r9)
            r8.append(r12)
            java.lang.String r9 = ", contentByteSize: "
            r8.append(r9)
            r8.append(r14)
            java.lang.String r9 = ", totalSendByteSize: "
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r8, r11)
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper r8 = com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.f5973a     // Catch:{ Exception -> 0x0187 }
            com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg r9 = new com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg     // Catch:{ Exception -> 0x0187 }
            java.util.UUID r10 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r13 = r10.toString()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r10 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r10)     // Catch:{ Exception -> 0x0187 }
            r12 = r9
            r14 = r3
            r16 = r7
            r17 = r6
            r12.<init>(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0187 }
            r0.L$0 = r1     // Catch:{ Exception -> 0x0187 }
            r0.L$1 = r2     // Catch:{ Exception -> 0x0187 }
            r0.L$2 = r4     // Catch:{ Exception -> 0x0187 }
            r0.L$3 = r3     // Catch:{ Exception -> 0x0187 }
            r0.I$0 = r5     // Catch:{ Exception -> 0x0187 }
            r0.I$1 = r6     // Catch:{ Exception -> 0x0187 }
            r0.I$2 = r7     // Catch:{ Exception -> 0x0187 }
            r0.I$3 = r7     // Catch:{ Exception -> 0x0187 }
            r10 = 1
            r0.label = r10     // Catch:{ Exception -> 0x0187 }
            r12 = 0
            r10 = 2
            r14 = 0
            r15 = r1
            r1 = r8
            r8 = r2
            r2 = r9
            r16 = r3
            r9 = r4
            r3 = r12
            r12 = r5
            r5 = r21
            r13 = r6
            r6 = r10
            r10 = r7
            r7 = r14
            java.lang.Object r1 = com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.i(r1, r2, r3, r5, r6, r7)     // Catch:{ Exception -> 0x0182 }
            r2 = r18
            if (r1 != r2) goto L_0x0141
            return r2
        L_0x0141:
            r7 = r8
            r4 = r9
            r5 = r12
            r6 = r13
            r3 = r16
            r13 = r1
            r1 = r10
        L_0x0149:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ Exception -> 0x017e }
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ Exception -> 0x017e }
            boolean r8 = r13.booleanValue()     // Catch:{ Exception -> 0x017e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r12 = r19
            r9.append(r12)
            r9.append(r1)
            java.lang.String r1 = ", success: "
            r9.append(r1)
            r9.append(r8)
            java.lang.String r1 = r9.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r11)
            if (r8 != 0) goto L_0x0173
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0173:
            r8 = 1
            int r1 = r10 + 1
            r10 = r8
            r9 = r12
            r8 = r2
            r2 = r7
            r7 = r1
            r1 = r15
            goto L_0x009b
        L_0x017e:
            r0 = move-exception
            r12 = r19
            goto L_0x018a
        L_0x0182:
            r0 = move-exception
        L_0x0183:
            r12 = r19
            r1 = r10
            goto L_0x018a
        L_0x0187:
            r0 = move-exception
            r10 = r7
            goto L_0x0183
        L_0x018a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r12)
            r2.append(r1)
            java.lang.String r1 = ", error: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1 = 2
            r2 = 0
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r11, r2, r1, r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01a9:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager$sendTiciContentPart$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciStarryMsgManager$sendTiciContentPart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
