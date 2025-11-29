package com.xjsd.ai.assistant.phone;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$isKeyExists$1", f = "SuperLiteStateMonitor.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
public final class SuperLiteStateMonitor$isKeyExists$1 extends SuspendLambda implements Function3<FlowCollector<? super Preferences>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public SuperLiteStateMonitor$isKeyExists$1(Continuation<? super SuperLiteStateMonitor$isKeyExists$1> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (th instanceof IOException) {
                Preferences a2 = PreferencesFactory.a();
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(a2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Preferences> flowCollector, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
        SuperLiteStateMonitor$isKeyExists$1 superLiteStateMonitor$isKeyExists$1 = new SuperLiteStateMonitor$isKeyExists$1(continuation);
        superLiteStateMonitor$isKeyExists$1.L$0 = flowCollector;
        superLiteStateMonitor$isKeyExists$1.L$1 = th;
        return superLiteStateMonitor$isKeyExists$1.invokeSuspend(Unit.INSTANCE);
    }
}
