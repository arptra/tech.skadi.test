package com.upuphone.xr.sapp.unicron;

import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$getRingVersion$1", f = "UnicronUpdateHelper.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, s = {})
public final class UnicronUpdateHelper$getRingVersion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public UnicronUpdateHelper$getRingVersion$1(Continuation<? super UnicronUpdateHelper$getRingVersion$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronUpdateHelper$getRingVersion$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        UnicronInfo unicronInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
            unicronUpdateHelper.L("getRingVersion, start");
            if (GlassHelper.f7049a.y() == null) {
                unicronUpdateHelper.L("getRingVersion, connectedGlass is null");
                return Unit.INSTANCE;
            }
            UnicronHelper unicronHelper = UnicronHelper.f7834a;
            this.label = 1;
            obj = UnicronHelper.h(unicronHelper, 0, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                UnicronUpdateHelper unicronUpdateHelper2 = UnicronUpdateHelper.b;
                unicronUpdateHelper2.M("getRingVersion, getUnicronInfo-error: " + e);
                unicronInfo = null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        unicronInfo = (UnicronInfo) obj;
        UnicronUpdateHelper unicronUpdateHelper3 = UnicronUpdateHelper.b;
        unicronUpdateHelper3.L("getRingVersion, unicronInfo: " + unicronInfo);
        if (unicronInfo == null) {
            return Unit.INSTANCE;
        }
        ControlUtils.f7858a.f0(unicronInfo);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$getRingVersion$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
