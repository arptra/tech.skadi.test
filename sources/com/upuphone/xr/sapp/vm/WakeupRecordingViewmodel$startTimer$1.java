package com.upuphone.xr.sapp.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startTimer$1", f = "WakeupRecordingViewmodel.kt", i = {0}, l = {199}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class WakeupRecordingViewmodel$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WakeupRecordingViewmodel this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startTimer$1$1", f = "WakeupRecordingViewmodel.kt", i = {}, l = {201, 208, 210, 211, 212}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startTimer$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(wakeupRecordingViewmodel, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00d1 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0100 A[RETURN] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x0037
                if (r1 == r6) goto L_0x0033
                if (r1 == r5) goto L_0x002e
                if (r1 == r4) goto L_0x0029
                if (r1 == r3) goto L_0x0024
                if (r1 != r2) goto L_0x001c
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x0101
            L_0x001c:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L_0x0024:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x00d2
            L_0x0029:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x00c7
            L_0x002e:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x0106
            L_0x0033:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x0045
            L_0x0037:
                kotlin.ResultKt.throwOnFailure(r10)
                r9.label = r6
                r7 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r7, r9)
                if (r10 != r0) goto L_0x0045
                return r0
            L_0x0045:
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                r1 = 0
                byte[] r1 = new byte[r1]
                r10.j = r1
                com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
                java.lang.String r1 = "WakeupRecordingViewmodel"
                java.lang.String r7 = "wakeup recognize timeout"
                r10.a(r1, r7)
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                java.lang.String r1 = "vuid"
                java.lang.String r7 = r10.l
                kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r7)
                java.lang.String r7 = "type"
                java.lang.String r8 = "1"
                kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
                kotlin.Pair[] r1 = new kotlin.Pair[]{r1, r7}
                java.util.Map r1 = kotlin.collections.MapsKt.mapOf(r1)
                java.lang.String r7 = "VoiceWake-up_Voiceprint_Fail"
                r10.K(r7, r1)
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                int r1 = r10.h
                int r1 = r1 + r6
                r10.h = r1
                int r10 = r10.h
                r1 = 6
                if (r10 <= r1) goto L_0x00b6
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                r10.a0()
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                android.media.AudioManager r10 = r10.m
                if (r10 == 0) goto L_0x00a5
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r1 = r7
                android.media.AudioFocusRequest r1 = r1.e
                int r10 = r10.abandonAudioFocusRequest(r1)
                kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            L_0x00a5:
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                kotlinx.coroutines.flow.MutableSharedFlow r10 = r10.b
                com.upuphone.xr.sapp.vm.RecordState$Failed r1 = com.upuphone.xr.sapp.vm.RecordState.Failed.f8000a
                r9.label = r5
                java.lang.Object r9 = r10.emit(r1, r9)
                if (r9 != r0) goto L_0x0106
                return r0
            L_0x00b6:
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                kotlinx.coroutines.flow.MutableSharedFlow r10 = r10.b
                com.upuphone.xr.sapp.vm.RecordState$Warning r1 = com.upuphone.xr.sapp.vm.RecordState.Warning.f8006a
                r9.label = r4
                java.lang.Object r10 = r10.emit(r1, r9)
                if (r10 != r0) goto L_0x00c7
                return r0
            L_0x00c7:
                r9.label = r3
                r3 = 1500(0x5dc, double:7.41E-321)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r3, r9)
                if (r10 != r0) goto L_0x00d2
                return r0
            L_0x00d2:
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r10 = r7
                kotlinx.coroutines.flow.MutableSharedFlow r10 = r10.b
                com.upuphone.xr.sapp.vm.RecordState$Start r1 = new com.upuphone.xr.sapp.vm.RecordState$Start
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r3 = r7
                int r3 = r3.f
                java.util.List r4 = com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel.u
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r5 = r7
                int r5 = r5.f
                int r5 = r5 - r6
                java.lang.Object r4 = r4.get(r5)
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$WordSpeed r4 = (com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel.WordSpeed) r4
                java.lang.String r4 = r4.b()
                r1.<init>(r3, r4)
                r9.label = r2
                java.lang.Object r10 = r10.emit(r1, r9)
                if (r10 != r0) goto L_0x0101
                return r0
            L_0x0101:
                com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r9 = r7
                r9.Y()
            L_0x0106:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$startTimer$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordingViewmodel$startTimer$1(WakeupRecordingViewmodel wakeupRecordingViewmodel, Continuation<? super WakeupRecordingViewmodel$startTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordingViewmodel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WakeupRecordingViewmodel$startTimer$1 wakeupRecordingViewmodel$startTimer$1 = new WakeupRecordingViewmodel$startTimer$1(this.this$0, continuation);
        wakeupRecordingViewmodel$startTimer$1.L$0 = obj;
        return wakeupRecordingViewmodel$startTimer$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            Job n = this.this$0.g;
            if (n != null) {
                this.L$0 = coroutineScope3;
                this.label = 1;
                if (JobKt.f(n, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope2 = coroutineScope3;
            } else {
                coroutineScope = coroutineScope3;
                final WakeupRecordingViewmodel wakeupRecordingViewmodel = this.this$0;
                wakeupRecordingViewmodel.g = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        coroutineScope = coroutineScope2;
        final WakeupRecordingViewmodel wakeupRecordingViewmodel2 = this.this$0;
        wakeupRecordingViewmodel2.g = BuildersKt__Builders_commonKt.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordingViewmodel$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
