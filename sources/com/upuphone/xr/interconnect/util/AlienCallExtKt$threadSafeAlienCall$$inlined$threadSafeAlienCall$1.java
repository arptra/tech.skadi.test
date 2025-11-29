package com.upuphone.xr.interconnect.util;

import android.util.Log;
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

@SourceDebugExtension({"SMAP\nAlienCallExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt$threadSafeAlienCall$1\n+ 2 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt\n*L\n1#1,46:1\n34#2,10:47\n25#2:57\n44#2:58\n26#2:59\n25#2,3:60\n*S KotlinDebug\n*F\n+ 1 AlienCallExt.kt\ncom/upuphone/xr/interconnect/util/AlienCallExtKt$threadSafeAlienCall$1\n*L\n17#1:47,10\n17#1:58\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¨\u0006\u0004"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;", "com/upuphone/xr/interconnect/util/AlienCallExtKt$threadSafeAlienCall$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.util.AlienCallExtKt$threadSafeAlienCall$$inlined$threadSafeAlienCall$1", f = "AlienCallExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlienCallExtKt$threadSafeAlienCall$$inlined$threadSafeAlienCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $action;
    final /* synthetic */ String $logTag$inlined;
    final /* synthetic */ String $logTag$inlined$1;
    final /* synthetic */ String $logTag$inlined$2;
    final /* synthetic */ Object $this_threadSafeAlienCall;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlienCallExtKt$threadSafeAlienCall$$inlined$threadSafeAlienCall$1(Object obj, Function1 function1, Continuation continuation, String str, String str2, String str3) {
        super(2, continuation);
        this.$this_threadSafeAlienCall = obj;
        this.$action = function1;
        this.$logTag$inlined = str;
        this.$logTag$inlined$1 = str2;
        this.$logTag$inlined$2 = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AlienCallExtKt$threadSafeAlienCall$$inlined$threadSafeAlienCall$1(this.$this_threadSafeAlienCall, this.$action, continuation, this.$logTag$inlined, this.$logTag$inlined$1, this.$logTag$inlined$2);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.$action.invoke(this.$this_threadSafeAlienCall);
                Log.v(this.$logTag$inlined, "Alien code invoked.");
            } catch (RuntimeException e) {
                Log.w(this.$logTag$inlined$1, "Alien call failed because of: " + e.getLocalizedMessage() + '.');
                Log.v(this.$logTag$inlined, "Alien code invoked.");
                return Unit.INSTANCE;
            } catch (Throwable th) {
                Log.v(this.$logTag$inlined, "Alien code invoked.");
                throw th;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AlienCallExtKt$threadSafeAlienCall$$inlined$threadSafeAlienCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
