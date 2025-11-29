package com.upuphone.xr.sapp.unicron;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.utils.ControlUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$refreshUnicronInfo$1", f = "UnicronUpdateHelper.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
public final class UnicronUpdateHelper$refreshUnicronInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bluetooth;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnicronUpdateHelper$refreshUnicronInfo$1(String str, Continuation<? super UnicronUpdateHelper$refreshUnicronInfo$1> continuation) {
        super(2, continuation);
        this.$bluetooth = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronUpdateHelper$refreshUnicronInfo$1(this.$bluetooth, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(1000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UnicronInfo q = ControlUtils.f7858a.q();
        String replace$default = StringsKt.replace$default(this.$bluetooth, AccountConstantKt.CODE_SEPARTOR, "", false, 4, (Object) null);
        if (q == null || !Intrinsics.areEqual((Object) q.getDeviceId(), (Object) replace$default)) {
            UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
            unicronUpdateHelper.L("refreshUnicronInfo, deviceId: " + replace$default + ", unicronInfo: " + q);
            unicronUpdateHelper.I();
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$refreshUnicronInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
