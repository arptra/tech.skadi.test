package com.upuphone.xr.sapp.vm;

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
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$wakeup$1", f = "WakeupRecordingViewmodel.kt", i = {}, l = {248, 254, 255, 258, 267}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordingViewmodel$wakeup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WakeupRecordingViewmodel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordingViewmodel$wakeup$1(WakeupRecordingViewmodel wakeupRecordingViewmodel, Continuation<? super WakeupRecordingViewmodel$wakeup$1> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordingViewmodel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordingViewmodel$wakeup$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d9 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 == r6) goto L_0x0031
            if (r1 == r5) goto L_0x002d
            if (r1 == r4) goto L_0x0029
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x010a
        L_0x001c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00da
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x009b
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0090
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0049
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            kotlinx.coroutines.Job r8 = r8.g
            if (r8 == 0) goto L_0x0049
            r7.label = r6
            java.lang.Object r8 = kotlinx.coroutines.JobKt.f(r8, r7)
            if (r8 != r0) goto L_0x0049
            return r0
        L_0x0049:
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            r1 = 0
            r8.g = r1
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            r8.a0()
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            r8.R()
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            int r8 = r8.f
            java.util.List r1 = com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel.u
            int r1 = r1.size()
            if (r8 >= r1) goto L_0x00e4
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            java.lang.String r1 = "vuid"
            java.lang.String r2 = r8.l
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            java.util.Map r1 = kotlin.collections.MapsKt.mapOf(r1)
            java.lang.String r2 = "VoiceWake-up_Voiceprint_Record"
            r8.K(r2, r1)
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r8 = r8.b
            com.upuphone.xr.sapp.vm.RecordState$Success r1 = com.upuphone.xr.sapp.vm.RecordState.Success.f8004a
            r7.label = r5
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x0090
            return r0
        L_0x0090:
            r7.label = r4
            r1 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r1, r7)
            if (r8 != r0) goto L_0x009b
            return r0
        L_0x009b:
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            int r1 = r8.f
            int r1 = r1 + r6
            r8.f = r1
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            r1 = 0
            r8.h = r1
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r8 = r8.b
            com.upuphone.xr.sapp.vm.RecordState$Start r1 = new com.upuphone.xr.sapp.vm.RecordState$Start
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r2 = r7.this$0
            int r2 = r2.f
            java.util.List r4 = com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel.u
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r5 = r7.this$0
            int r5 = r5.f
            int r5 = r5 - r6
            java.lang.Object r4 = r4.get(r5)
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$WordSpeed r4 = (com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel.WordSpeed) r4
            java.lang.String r4 = r4.b()
            r1.<init>(r2, r4)
            r7.label = r3
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x00da
            return r0
        L_0x00da:
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r7 = r7.this$0
            java.lang.String r8 = r7.O()
            r7.P(r8)
            goto L_0x015b
        L_0x00e4:
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            android.media.AudioManager r8 = r8.m
            if (r8 == 0) goto L_0x00f9
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r1 = r7.this$0
            android.media.AudioFocusRequest r1 = r1.e
            int r8 = r8.abandonAudioFocusRequest(r1)
            kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
        L_0x00f9:
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r8 = r8.b
            com.upuphone.xr.sapp.vm.RecordState$Finished r1 = com.upuphone.xr.sapp.vm.RecordState.Finished.f8001a
            r7.label = r2
            java.lang.Object r8 = r8.emit(r1, r7)
            if (r8 != r0) goto L_0x010a
            return r0
        L_0x010a:
            com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage r8 = com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage.INSTANCE
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r0 = r7.this$0
            float[] r0 = r0.k
            r8.save(r0)
            com.upuphone.xr.sapp.utils.ControlUtils r8 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r8.r0(r6)
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r0 = r7.this$0
            float[] r0 = r0.k
            java.lang.String r0 = java.util.Arrays.toString(r0)
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "embedded result: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "WakeupRecordingViewmodel"
            r8.a(r1, r0)
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r8 = r7.this$0
            r8.U()
            android.content.Context r0 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel r7 = r7.this$0
            java.lang.String r2 = r7.l
            r4 = 8
            r5 = 0
            java.lang.String r1 = "wakeup_record_id"
            r3 = 0
            com.upuphone.ai.ttsengine.base.utils.SpUtils.d(r0, r1, r2, r3, r4, r5)
        L_0x015b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel$wakeup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordingViewmodel$wakeup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
