package com.upuphone.xr.sapp.utils;

import androidx.lifecycle.MutableLiveData;
import com.upuphone.xr.sapp.entity.AppUpdateInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.AppUpdateHelper$refreshUpdateBadge$1", f = "AppUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppUpdateHelper$refreshUpdateBadge$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AppUpdateHelper$refreshUpdateBadge$1(Continuation<? super AppUpdateHelper$refreshUpdateBadge$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppUpdateHelper$refreshUpdateBadge$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Boolean bool;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData j = AppUpdateHelper.h;
            AppUpdateInfo d = AppUpdateHelper.d;
            boolean z = false;
            if (d != null) {
                if (d.getExistsUpdate() && !Intrinsics.areEqual((Object) AppUpdateHelper.f7841a.A(), (Object) d.getLatestVersion())) {
                    z = true;
                }
                bool = Boxing.boxBoolean(z);
            } else {
                bool = Boxing.boxBoolean(false);
            }
            j.setValue(bool);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AppUpdateHelper$refreshUpdateBadge$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
