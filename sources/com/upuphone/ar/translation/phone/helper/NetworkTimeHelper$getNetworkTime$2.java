package com.upuphone.ar.translation.phone.helper;

import android.os.SystemClock;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NetworkTime;
import com.upuphone.star.httplib.HttpResult;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.NetworkTimeHelper$getNetworkTime$2", f = "NetworkTimeHelper.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class NetworkTimeHelper$getNetworkTime$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Long, Long, Unit> $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NetworkTimeHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkTimeHelper$getNetworkTime$2(Function2<? super Long, ? super Long, Unit> function2, NetworkTimeHelper networkTimeHelper, Continuation<? super NetworkTimeHelper$getNetworkTime$2> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.this$0 = networkTimeHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NetworkTimeHelper$getNetworkTime$2 networkTimeHelper$getNetworkTime$2 = new NetworkTimeHelper$getNetworkTime$2(this.$callback, this.this$0, continuation);
        networkTimeHelper$getNetworkTime$2.L$0 = obj;
        return networkTimeHelper$getNetworkTime$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (TranslatorConstants.isIntlVersion()) {
                LogExt.j("getNetworkTime is intlVersion, not load network time", "NetworkTimeHelper");
                this.$callback.invoke(Boxing.boxLong(0), Boxing.boxLong(0));
                return Unit.INSTANCE;
            } else if (this.this$0.c != 0) {
                long b = this.this$0.c + (SystemClock.elapsedRealtime() - this.this$0.b);
                long j = b / 1000;
                LogExt.j("getNetworkTime local [milliseconds=" + b + ", seconds=" + j + "]", "NetworkTimeHelper");
                this.$callback.invoke(Boxing.boxLong(b), Boxing.boxLong(j));
                return Unit.INSTANCE;
            } else {
                String str = SdkContext.f6675a.c().a().getKmUrl() + "/auth/sys/time";
                LogExt.j("getNetworkTime requestUrl=" + str, "NetworkTimeHelper");
                HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("WR-Client-Id", "IKSoISndT"));
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = HttpUtils.f6479a.l(str + "?appid=IKSoISndT", hashMapOf, NetworkTime.class, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkTime networkTime = (NetworkTime) ((HttpResult) obj).b();
        Unit unit = null;
        if (networkTime != null) {
            NetworkTimeHelper networkTimeHelper = this.this$0;
            Function2<Long, Long, Unit> function2 = this.$callback;
            LogExt.j("getNetworkTime server=" + networkTime, "NetworkTimeHelper");
            NetworkTime.Data data = networkTime.getData();
            if (data != null) {
                networkTimeHelper.b = SystemClock.elapsedRealtime();
                networkTimeHelper.c = data.getNowTime();
                long b2 = networkTimeHelper.c + (SystemClock.elapsedRealtime() - networkTimeHelper.b);
                long j2 = b2 / 1000;
                LogExt.j("getNetworkTime server [milliseconds=" + b2 + ", seconds=" + j2 + "]", "NetworkTimeHelper");
                function2.invoke(Boxing.boxLong(b2), Boxing.boxLong(j2));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                function2.invoke(Boxing.boxLong(0), Boxing.boxLong(0));
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Function2<Long, Long, Unit> function22 = this.$callback;
            LogExt.j("getNetworkTime NetworkTime is null", "NetworkTimeHelper");
            function22.invoke(Boxing.boxLong(0), Boxing.boxLong(0));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NetworkTimeHelper$getNetworkTime$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
