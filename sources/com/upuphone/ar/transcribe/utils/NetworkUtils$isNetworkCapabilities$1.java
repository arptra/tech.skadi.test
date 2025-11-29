package com.upuphone.ar.transcribe.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.utils.NetworkUtils$isNetworkCapabilities$1", f = "NetworkUtils.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class NetworkUtils$isNetworkCapabilities$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkUtils$isNetworkCapabilities$1(Context context, Function1<? super Boolean, Unit> function1, Continuation<? super NetworkUtils$isNetworkCapabilities$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NetworkUtils$isNetworkCapabilities$1 networkUtils$isNetworkCapabilities$1 = new NetworkUtils$isNetworkCapabilities$1(this.$context, this.$callback, continuation);
        networkUtils$isNetworkCapabilities$1.L$0 = obj;
        return networkUtils$isNetworkCapabilities$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object systemService = this.$context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            z = false;
            if (networkCapabilities != null) {
                boolean hasCapability = networkCapabilities.hasCapability(12);
                boolean hasCapability2 = networkCapabilities.hasCapability(16);
                LogExt.g("isNetworkCapabilities 网络连接=" + hasCapability + ", 网络可用=" + hasCapability2, "NetworkUtils");
                if (!hasCapability) {
                    z2 = false;
                } else if (!hasCapability2) {
                    NetworkUtils networkUtils = NetworkUtils.f6189a;
                    this.label = 1;
                    obj = networkUtils.a(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                z = z2;
            }
            LogExt.g("isNetworkCapabilities isAccessible=" + z, "NetworkUtils");
            this.$callback.invoke(Boxing.boxBoolean(z));
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z2 = ((Boolean) obj).booleanValue();
        LogExt.g("isNetworkCapabilities 请求互联网=" + z2, "NetworkUtils");
        z = z2;
        LogExt.g("isNetworkCapabilities isAccessible=" + z, "NetworkUtils");
        this.$callback.invoke(Boxing.boxBoolean(z));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NetworkUtils$isNetworkCapabilities$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
