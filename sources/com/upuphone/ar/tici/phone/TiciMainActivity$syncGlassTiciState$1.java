package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciMainActivity$syncGlassTiciState$1", f = "TiciMainActivity.kt", i = {0}, l = {658}, m = "invokeSuspend", n = {"glassTiciId"}, s = {"J$0"})
public final class TiciMainActivity$syncGlassTiciState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckTiciStateReply $ticiState;
    long J$0;
    int label;
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$syncGlassTiciState$1(CheckTiciStateReply checkTiciStateReply, TiciMainActivity ticiMainActivity, Continuation<? super TiciMainActivity$syncGlassTiciState$1> continuation) {
        super(2, continuation);
        this.$ticiState = checkTiciStateReply;
        this.this$0 = ticiMainActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciMainActivity$syncGlassTiciState$1(this.$ticiState, this.this$0, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        r10 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r10);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            java.lang.String r3 = "TiciMainActivity"
            if (r1 == 0) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            long r0 = r9.J$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c3
        L_0x0014:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r10 = r9.$ticiState
            java.lang.String r10 = r10.getFileKey()
            if (r10 == 0) goto L_0x0032
            java.lang.Long r10 = com.upuphone.ar.tici.phone.db.entity.TiciEntityKt.b(r10)
            if (r10 == 0) goto L_0x0032
            long r4 = r10.longValue()
            goto L_0x0034
        L_0x0032:
            r4 = 0
        L_0x0034:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "syncGlassTiciState, glassTiciId: "
            r10.append(r1)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r10, r3)
            com.upuphone.ar.tici.phone.TiciMainActivity r10 = r9.this$0
            com.upuphone.ar.tici.phone.TiciAppViewModel r10 = r10.d
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r1 = r9.$ticiState
            boolean r1 = r1.isRunning()
            r10.G0(r1)
            com.upuphone.ar.tici.phone.TiciMainActivity r10 = r9.this$0
            com.upuphone.ar.tici.phone.TiciAppViewModel r10 = r10.d
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r1 = r9.$ticiState
            boolean r1 = r1.isAutoTiciPlaying()
            r10.F0(r1)
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r10 = r9.$ticiState
            int r10 = r10.getParagraphIndex()
            if (r10 <= 0) goto L_0x008f
            com.upuphone.ar.tici.phone.TiciApp r10 = com.upuphone.ar.tici.phone.TiciApp.b
            boolean r10 = r10.n()
            if (r10 != 0) goto L_0x008f
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r10 = r9.$ticiState
            java.lang.Integer r10 = r10.getCurrentPage()
            if (r10 == 0) goto L_0x0083
            int r10 = r10.intValue()
            goto L_0x0084
        L_0x0083:
            r10 = 0
        L_0x0084:
            com.upuphone.ar.tici.phone.TiciMainActivity r1 = r9.this$0
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r6 = r9.$ticiState
            int r6 = r6.getParagraphIndex()
            r1.m1(r10, r6)
        L_0x008f:
            com.upuphone.ar.tici.phone.TiciMainActivity r10 = r9.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r10 = r10.d1()
            com.airbnb.lottie.LottieAnimationView r10 = r10.j
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r1 = r9.$ticiState
            float r1 = r1.getAutoTiciProgress()
            r10.setProgress(r1)
            com.upuphone.ar.tici.phone.TiciMainActivity r10 = r9.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r10 = r10.d1()
            com.airbnb.lottie.LottieAnimationView r10 = r10.k
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r1 = r9.$ticiState
            float r1 = r1.getAutoTiciProgress()
            r10.setProgress(r1)
            com.upuphone.ar.tici.phone.TiciApp r10 = com.upuphone.ar.tici.phone.TiciApp.b
            com.upuphone.ar.tici.phone.db.TiciDao r10 = r10.w()
            r9.J$0 = r4
            r9.label = r2
            java.lang.Object r10 = r10.q(r4, r9)
            if (r10 != r0) goto L_0x00c2
            return r0
        L_0x00c2:
            r0 = r4
        L_0x00c3:
            com.upuphone.ar.tici.phone.db.entity.TiciEntity r10 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r10
            com.upuphone.ar.tici.phone.TiciMainActivity r2 = r9.this$0
            com.upuphone.ar.tici.phone.TiciAppViewModel r2 = r2.d
            r2.I0(r10)
            com.upuphone.ar.tici.phone.TiciMainActivity r2 = r9.this$0
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r2 = r2.e1()
            com.upuphone.ar.tici.phone.data.TiciInfo r2 = r2.r()
            r4 = 0
            if (r2 == 0) goto L_0x00e4
            long r5 = com.upuphone.ar.tici.phone.data.TiciInfoKt.b(r2)
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            goto L_0x00e5
        L_0x00e4:
            r2 = r4
        L_0x00e5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "syncGlassTiciState, currentId: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r5, r3)
            if (r10 == 0) goto L_0x0130
            long r5 = r10.getId()
            if (r2 != 0) goto L_0x0102
            goto L_0x010a
        L_0x0102:
            long r7 = r2.longValue()
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x0130
        L_0x010a:
            java.lang.String r10 = "syncGlassTiciState, refresh ticiEntity"
            r2 = 2
            com.upuphone.ar.tici.phone.utils.CommonExtKt.d(r10, r3, r4, r2, r4)
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r10 = r9.$ticiState
            boolean r10 = r10.isRunning()
            if (r10 == 0) goto L_0x0130
            com.upuphone.ar.tici.phone.TiciMainActivity r10 = r9.this$0
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel r2 = r10.e1()
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply r9 = r9.$ticiState
            java.lang.Integer r4 = r9.getCurrentPage()
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel.F(r2, r3, r4, r5, r6, r7, r8)
        L_0x0130:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciMainActivity$syncGlassTiciState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciMainActivity$syncGlassTiciState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
