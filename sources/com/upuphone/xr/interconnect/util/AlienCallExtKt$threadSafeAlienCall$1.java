package com.upuphone.xr.interconnect.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAlienCallExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt$threadSafeAlienCall$1\n+ 2 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt\n*L\n1#1,46:1\n34#2,11:47\n*S KotlinDebug\n*F\n+ 1 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt$threadSafeAlienCall$1\n*L\n17#1:47,11\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "com.upuphone.xr.interconnect.util.AlienCallExtKt$threadSafeAlienCall$1", f = "AlienCallExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlienCallExtKt$threadSafeAlienCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<I, Unit> $action;
    final /* synthetic */ Function1<String, Unit> $loge;
    final /* synthetic */ Function1<String, Unit> $logv;
    final /* synthetic */ Function1<String, Unit> $logw;
    final /* synthetic */ I $this_threadSafeAlienCall;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlienCallExtKt$threadSafeAlienCall$1(I i, Function1<? super String, Unit> function1, Function1<? super String, Unit> function12, Function1<? super String, Unit> function13, Function1<? super I, Unit> function14, Continuation<? super AlienCallExtKt$threadSafeAlienCall$1> continuation) {
        super(2, continuation);
        this.$this_threadSafeAlienCall = i;
        this.$logv = function1;
        this.$logw = function12;
        this.$loge = function13;
        this.$action = function14;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AlienCallExtKt$threadSafeAlienCall$1(this.$this_threadSafeAlienCall, this.$logv, this.$logw, this.$loge, this.$action, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            I i = this.$this_threadSafeAlienCall;
            Function1<String, Unit> function1 = this.$logv;
            Function1<String, Unit> function12 = this.$logw;
            Function1<String, Unit> function13 = this.$loge;
            try {
                this.$action.invoke(i);
            } catch (RuntimeException e) {
                function12.invoke("Alien call failed because of: " + e.getLocalizedMessage() + '.');
            } catch (Throwable th) {
                function1.invoke("Alien code invoked.");
                throw th;
            }
            function1.invoke("Alien code invoked.");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        I i = this.$this_threadSafeAlienCall;
        Function1<String, Unit> function1 = this.$logv;
        Function1<String, Unit> function12 = this.$logw;
        Function1<String, Unit> function13 = this.$loge;
        try {
            this.$action.invoke(i);
        } catch (RuntimeException e) {
            function12.invoke("Alien call failed because of: " + e.getLocalizedMessage() + '.');
        } catch (Throwable th) {
            function1.invoke("Alien code invoked.");
            throw th;
        }
        function1.invoke("Alien code invoked.");
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AlienCallExtKt$threadSafeAlienCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
