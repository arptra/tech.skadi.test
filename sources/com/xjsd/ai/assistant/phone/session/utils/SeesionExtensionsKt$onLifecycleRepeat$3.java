package com.xjsd.ai.assistant.phone.session.utils;

import androidx.lifecycle.Lifecycle;
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

@SourceDebugExtension({"SMAP\nSeesionExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SeesionExtensions.kt\ncom/xjsd/ai/assistant/phone/session/utils/SeesionExtensionsKt$onLifecycleRepeat$3\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,135:1\n314#2,11:136\n*S KotlinDebug\n*F\n+ 1 SeesionExtensions.kt\ncom/xjsd/ai/assistant/phone/session/utils/SeesionExtensionsKt$onLifecycleRepeat$3\n*L\n39#1:136,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt$onLifecycleRepeat$3", f = "SeesionExtensions.kt", i = {0, 0, 0}, l = {136}, m = "invokeSuspend", n = {"$this$coroutineScope", "launchedJob", "observer"}, s = {"L$0", "L$1", "L$2"})
public final class SeesionExtensionsKt$onLifecycleRepeat$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_onLifecycleRepeat;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeesionExtensionsKt$onLifecycleRepeat$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super SeesionExtensionsKt$onLifecycleRepeat$3> continuation) {
        super(2, continuation);
        this.$this_onLifecycleRepeat = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SeesionExtensionsKt$onLifecycleRepeat$3 seesionExtensionsKt$onLifecycleRepeat$3 = new SeesionExtensionsKt$onLifecycleRepeat$3(this.$this_onLifecycleRepeat, this.$state, this.$block, continuation);
        seesionExtensionsKt$onLifecycleRepeat$3.L$0 = obj;
        return seesionExtensionsKt$onLifecycleRepeat$3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f3, code lost:
        if (r0 != null) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f5, code lost:
        r1.$this_onLifecycleRepeat.d(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x012d, code lost:
        if (r0 != null) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0132, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0158  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            java.lang.String r3 = "final, lifecycle instance: "
            java.lang.String r4 = "LifecycleRepeat"
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r6) goto L_0x0037
            java.lang.Object r0 = r1.L$5
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            java.lang.Object r0 = r1.L$4
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            java.lang.Object r0 = r1.L$3
            androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
            java.lang.Object r0 = r1.L$2
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r1.L$1
            r7 = r0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r0 = r1.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ Exception -> 0x0034 }
            goto L_0x00d0
        L_0x0031:
            r0 = move-exception
            goto L_0x0133
        L_0x0034:
            r0 = move-exception
            goto L_0x0105
        L_0x0037:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r1.L$0
            r11 = r2
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            androidx.lifecycle.Lifecycle r2 = r1.$this_onLifecycleRepeat
            androidx.lifecycle.Lifecycle$State r2 = r2.b()
            androidx.lifecycle.Lifecycle$State r7 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r2 != r7) goto L_0x0054
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0054:
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            androidx.lifecycle.Lifecycle$State r7 = r1.$state     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            androidx.lifecycle.Lifecycle r14 = r1.$this_onLifecycleRepeat     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r13 = r1.$block     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r1.L$0 = r11     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r1.L$1 = r2     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r1.L$2 = r15     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r1.L$3 = r7     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r1.L$4 = r14     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r1.L$5 = r13     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r1.label = r6     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            kotlinx.coroutines.CancellableContinuationImpl r12 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            kotlin.coroutines.Continuation r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r19)     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r12.<init>(r8, r6)     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r12.x()     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            androidx.lifecycle.Lifecycle$Event$Companion r8 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            androidx.lifecycle.Lifecycle$Event r9 = r8.d(r7)     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            androidx.lifecycle.Lifecycle$Event r16 = r8.a(r7)     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r7 = 0
            kotlinx.coroutines.sync.Mutex r17 = kotlinx.coroutines.sync.MutexKt.b(r7, r6, r5)     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt$onLifecycleRepeat$3$1$1 r10 = new com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt$onLifecycleRepeat$3$1$1     // Catch:{ Exception -> 0x0100, all -> 0x00fb }
            r7 = r10
            r8 = r9
            r9 = r14
            r5 = r10
            r10 = r2
            r18 = r12
            r12 = r16
            r16 = r13
            r13 = r17
            r6 = r14
            r14 = r16
            r20 = r2
            r2 = r15
            r15 = r18
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r2.element = r5     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.String r7 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r7)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r10 = r5
            androidx.lifecycle.LifecycleEventObserver r10 = (androidx.lifecycle.LifecycleEventObserver) r10     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            r6.a(r10)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.Object r5 = r18.u()     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            if (r5 != r6) goto L_0x00cb
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r19)     // Catch:{ Exception -> 0x00c7, all -> 0x00c2 }
            goto L_0x00cb
        L_0x00c2:
            r0 = move-exception
        L_0x00c3:
            r7 = r20
            goto L_0x0133
        L_0x00c7:
            r0 = move-exception
        L_0x00c8:
            r7 = r20
            goto L_0x0105
        L_0x00cb:
            if (r5 != r0) goto L_0x00ce
            return r0
        L_0x00ce:
            r7 = r20
        L_0x00d0:
            androidx.lifecycle.Lifecycle r0 = r1.$this_onLifecycleRepeat
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.xjsd.ai.assistant.log.ILog.a(r4, r0)
            T r0 = r7.element
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            if (r0 == 0) goto L_0x00ef
            r3 = 0
            r4 = 1
            kotlinx.coroutines.Job.DefaultImpls.a(r0, r3, r4, r3)
        L_0x00ef:
            T r0 = r2.element
            androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
            if (r0 == 0) goto L_0x0130
        L_0x00f5:
            androidx.lifecycle.Lifecycle r1 = r1.$this_onLifecycleRepeat
            r1.d(r0)
            goto L_0x0130
        L_0x00fb:
            r0 = move-exception
            r20 = r2
            r2 = r15
            goto L_0x00c3
        L_0x0100:
            r0 = move-exception
            r20 = r2
            r2 = r15
            goto L_0x00c8
        L_0x0105:
            java.lang.String r5 = "exception occurred"
            com.xjsd.ai.assistant.log.ILog.h(r4, r5, r0)     // Catch:{ all -> 0x0031 }
            androidx.lifecycle.Lifecycle r0 = r1.$this_onLifecycleRepeat
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.xjsd.ai.assistant.log.ILog.a(r4, r0)
            T r0 = r7.element
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            if (r0 == 0) goto L_0x0129
            r3 = 0
            r4 = 1
            kotlinx.coroutines.Job.DefaultImpls.a(r0, r3, r4, r3)
        L_0x0129:
            T r0 = r2.element
            androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
            if (r0 == 0) goto L_0x0130
            goto L_0x00f5
        L_0x0130:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0133:
            androidx.lifecycle.Lifecycle r5 = r1.$this_onLifecycleRepeat
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            r6.append(r5)
            java.lang.String r3 = r6.toString()
            com.xjsd.ai.assistant.log.ILog.a(r4, r3)
            T r3 = r7.element
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
            if (r3 == 0) goto L_0x0152
            r4 = 0
            r5 = 1
            kotlinx.coroutines.Job.DefaultImpls.a(r3, r4, r5, r4)
        L_0x0152:
            T r2 = r2.element
            androidx.lifecycle.LifecycleEventObserver r2 = (androidx.lifecycle.LifecycleEventObserver) r2
            if (r2 == 0) goto L_0x015d
            androidx.lifecycle.Lifecycle r1 = r1.$this_onLifecycleRepeat
            r1.d(r2)
        L_0x015d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.phone.session.utils.SeesionExtensionsKt$onLifecycleRepeat$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SeesionExtensionsKt$onLifecycleRepeat$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
