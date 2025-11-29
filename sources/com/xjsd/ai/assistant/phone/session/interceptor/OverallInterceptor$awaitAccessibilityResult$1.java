package com.xjsd.ai.assistant.phone.session.interceptor;

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
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$awaitAccessibilityResult$1", f = "OverallInterceptor.kt", i = {1}, l = {830, 852, 857}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
public final class OverallInterceptor$awaitAccessibilityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ boolean $isOfflineJob;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$awaitAccessibilityResult$1(OverallInterceptor overallInterceptor, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, boolean z, Continuation<? super OverallInterceptor$awaitAccessibilityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = overallInterceptor;
        this.$block = function2;
        this.$isOfflineJob = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        OverallInterceptor$awaitAccessibilityResult$1 overallInterceptor$awaitAccessibilityResult$1 = new OverallInterceptor$awaitAccessibilityResult$1(this.this$0, this.$block, this.$isOfflineJob, continuation);
        overallInterceptor$awaitAccessibilityResult$1.L$0 = obj;
        return overallInterceptor$awaitAccessibilityResult$1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fd  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 0
            java.lang.String r6 = "OverallInterceptor"
            r7 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r7) goto L_0x002b
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0121
        L_0x001a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0022:
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d5
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x007c
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            r1 = r15
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r15 = r14.this$0
            java.lang.Boolean r15 = r15.o
            if (r15 == 0) goto L_0x007f
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r15 = r14.this$0
            java.lang.Boolean r15 = r15.o
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "awaitAccessibilityResult: 眼镜端已返回无障碍结果->"
            r2.append(r3)
            r2.append(r15)
            java.lang.String r15 = r2.toString()
            com.xjsd.ai.assistant.log.ILog.a(r6, r15)
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r15 = r14.this$0
            java.lang.Boolean r15 = r15.o
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r2)
            if (r15 == 0) goto L_0x0071
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r14 = r14.this$0
            r14.a0(r7)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0071:
            kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r15 = r14.$block
            r14.label = r7
            java.lang.Object r14 = r15.invoke(r1, r14)
            if (r14 != r0) goto L_0x007c
            return r0
        L_0x007c:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x007f:
            long r8 = java.lang.System.currentTimeMillis()
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r15 = r14.this$0
            long r10 = r15.n
            long r8 = r8 - r10
            r10 = 5000(0x1388, double:2.4703E-320)
            long r10 = r10 - r8
            r8 = 0
            int r15 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r15 >= 0) goto L_0x0095
            r10 = 100
        L_0x0095:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r8 = "awaitAccessibilityResult: 启动接收无障碍结果，超时时间->"
            r15.append(r8)
            r15.append(r10)
            java.lang.String r15 = r15.toString()
            com.xjsd.ai.assistant.log.ILog.a(r6, r15)
            com.xjsd.ai.assistant.phone.helper.VersionUtil r15 = com.xjsd.ai.assistant.phone.helper.VersionUtil.f8566a
            java.lang.String r8 = r15.a()
            boolean r15 = r15.b(r8)
            if (r15 == 0) goto L_0x00c7
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$awaitAccessibilityResult$1$job$1 r15 = new com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$awaitAccessibilityResult$1$job$1
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r8 = r14.this$0
            r15.<init>(r10, r8, r5)
            r12 = 3
            r13 = 0
            r9 = 0
            r10 = 0
            r8 = r1
            r11 = r15
            kotlinx.coroutines.Deferred r15 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r8, r9, r10, r11, r12, r13)
            goto L_0x00c8
        L_0x00c7:
            r15 = r5
        L_0x00c8:
            if (r15 == 0) goto L_0x00de
            r14.L$0 = r1
            r14.label = r4
            java.lang.Object r15 = r15.c(r14)
            if (r15 != r0) goto L_0x00d5
            return r0
        L_0x00d5:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 != r7) goto L_0x00de
            r2 = r7
        L_0x00de:
            if (r2 == 0) goto L_0x00fd
            boolean r15 = r14.$isOfflineJob
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "命中可见即可说，流程终止，是否离线任务->"
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            com.xjsd.ai.assistant.log.ILog.a(r6, r15)
            com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor r14 = r14.this$0
            r14.a0(r7)
            goto L_0x0121
        L_0x00fd:
            boolean r15 = r14.$isOfflineJob
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "未命中可见即可说，流程继续，是否是离线任务->"
            r2.append(r4)
            r2.append(r15)
            java.lang.String r15 = r2.toString()
            com.xjsd.ai.assistant.log.ILog.a(r6, r15)
            kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r15 = r14.$block
            r14.L$0 = r5
            r14.label = r3
            java.lang.Object r14 = r15.invoke(r1, r14)
            if (r14 != r0) goto L_0x0121
            return r0
        L_0x0121:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$awaitAccessibilityResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OverallInterceptor$awaitAccessibilityResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
