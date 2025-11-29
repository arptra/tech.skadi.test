package com.upuphone.ar.tici.phone;

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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$resumeTiciIfPossible$1", f = "TiciAppViewModel.kt", i = {}, l = {619, 623}, m = "invokeSuspend", n = {}, s = {})
public final class TiciAppViewModel$resumeTiciIfPossible$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $ticiId;
    int label;
    final /* synthetic */ TiciAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$resumeTiciIfPossible$1(long j, TiciAppViewModel ticiAppViewModel, Continuation<? super TiciAppViewModel$resumeTiciIfPossible$1> continuation) {
        super(2, continuation);
        this.$ticiId = j;
        this.this$0 = ticiAppViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$resumeTiciIfPossible$1(this.$ticiId, this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ec  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 0
            r9 = 2
            r2 = 1
            java.lang.String r10 = "TiciAppViewModel"
            if (r1 == 0) goto L_0x002f
            if (r1 == r2) goto L_0x002b
            if (r1 != r9) goto L_0x0023
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Exception -> 0x0020 }
            r1 = r22
            kotlin.Result r1 = (kotlin.Result) r1     // Catch:{ Exception -> 0x0020 }
            java.lang.Object r1 = r1.m29unboximpl()     // Catch:{ Exception -> 0x0020 }
            goto L_0x00a0
        L_0x0020:
            r0 = move-exception
            goto L_0x00f4
        L_0x0023:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x008a
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r22)
            com.upuphone.ar.tici.phone.TiciApp r1 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r3 = r1.q()
            com.upuphone.xr.interconnect.entity.StarryNetDevice r3 = r3.getConnectXrDevice()
            if (r3 == 0) goto L_0x0040
            r3 = r2
            goto L_0x0041
        L_0x0040:
            r3 = 0
        L_0x0041:
            long r4 = r0.$ticiId
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r11 = "resumeTiciIfPossible, ticiId: "
            r6.append(r11)
            r6.append(r4)
            java.lang.String r4 = ", connected: "
            r6.append(r4)
            r6.append(r3)
            java.lang.String r4 = r6.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r4, r10)
            if (r3 == 0) goto L_0x0078
            com.upuphone.ar.tici.phone.TiciAppViewModel r11 = r0.this$0
            long r12 = r0.$ticiId
            com.upuphone.ar.tici.phone.data.OpenTiciFrom r14 = com.upuphone.ar.tici.phone.data.OpenTiciFrom.RunningTiciEdit
            r19 = 52
            r20 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.upuphone.ar.tici.phone.TiciAppViewModel.N0(r11, r12, r14, r15, r16, r17, r18, r19, r20)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0078:
            java.lang.String r3 = "resumeTiciIfPossible, waitUntilConnected"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r3, r10)
            com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager r1 = r1.q()
            r0.label = r2
            java.lang.Object r1 = r1.waitUntilConnected(r0)
            if (r1 != r7) goto L_0x008a
            return r7
        L_0x008a:
            java.lang.String r1 = "resumeTiciIfPossible, checkTiciState start"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r10)
            com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper r1 = com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.f5973a     // Catch:{ Exception -> 0x0020 }
            r0.label = r9     // Catch:{ Exception -> 0x0020 }
            r2 = 0
            r5 = 1
            r6 = 0
            r4 = r21
            java.lang.Object r1 = com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper.c(r1, r2, r4, r5, r6)     // Catch:{ Exception -> 0x0020 }
            if (r1 != r7) goto L_0x00a0
            return r7
        L_0x00a0:
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ Exception -> 0x0020 }
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r1 = (com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply) r1     // Catch:{ Exception -> 0x0020 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "resumeTiciIfPossible, checkTiciState result: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r2, r10)
            java.lang.String r1 = r1.getFileKey()
            if (r1 == 0) goto L_0x00c3
            java.lang.Long r8 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r1)
        L_0x00c3:
            long r1 = r0.$ticiId
            if (r8 != 0) goto L_0x00c8
            goto L_0x00ec
        L_0x00c8:
            long r3 = r8.longValue()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00ec
            java.lang.String r1 = "resumeTiciIfPossible, startTici"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r1, r10)
            com.upuphone.ar.tici.phone.TiciAppViewModel r11 = r0.this$0
            long r12 = r8.longValue()
            com.upuphone.ar.tici.phone.data.OpenTiciFrom r14 = com.upuphone.ar.tici.phone.data.OpenTiciFrom.RunningTiciEdit
            r19 = 52
            r20 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.upuphone.ar.tici.phone.TiciAppViewModel.N0(r11, r12, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x00f1
        L_0x00ec:
            java.lang.String r0 = "resumeTiciIfPossible, id not match"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r0, r10)
        L_0x00f1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00f4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "resumeTiciIfPossible, checkTiciState error: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r0, r10, r8, r9, r8)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciAppViewModel$resumeTiciIfPossible$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$resumeTiciIfPossible$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
