package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.ext.LogExt;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.TranslationManager$launchIoScope$1", f = "TranslationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslationManager$launchIoScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ String $name;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationManager$launchIoScope$1(Function0<Unit> function0, String str, Continuation<? super TranslationManager$launchIoScope$1> continuation) {
        super(2, continuation);
        this.$callback = function0;
        this.$name = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslationManager$launchIoScope$1(this.$callback, this.$name, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.$callback.invoke();
            } catch (Exception e) {
                String str = this.$name;
                String stackTraceToString = ExceptionsKt.stackTraceToString(e);
                LogExt.h("launchIoScope[" + str + "] error=" + stackTraceToString, "TranslationManager");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TranslationManager$launchIoScope$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
