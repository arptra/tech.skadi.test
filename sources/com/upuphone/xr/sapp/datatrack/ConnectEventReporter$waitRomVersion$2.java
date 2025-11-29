package com.upuphone.xr.sapp.datatrack;

import com.upuphone.xr.sapp.utils.ControlUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$2", f = "ConnectEventReporter.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class ConnectEventReporter$waitRomVersion$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public ConnectEventReporter$waitRomVersion$2(Continuation<? super ConnectEventReporter$waitRomVersion$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ConnectEventReporter$waitRomVersion$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            do {
                ControlUtils controlUtils = ControlUtils.f7858a;
                String romVersion = controlUtils.g().getRomVersion();
                if (romVersion == null || StringsKt.isBlank(romVersion)) {
                    this.label = 1;
                } else {
                    String romVersion2 = controlUtils.g().getRomVersion();
                    return romVersion2 == null ? "" : romVersion2;
                }
            } while (DelayKt.b(500, this) != coroutine_suspended);
            return coroutine_suspended;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((ConnectEventReporter$waitRomVersion$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
