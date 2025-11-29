package com.upuphone.ar.translation.phone.helper;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\f\u001a\u00020\n28\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/NetworkTimeHelper;", "", "<init>", "()V", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "milliseconds", "seconds", "", "callback", "f", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlin/Lazy;", "e", "()Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "b", "J", "mGetStartTime", "c", "mNetworkTime", "d", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NetworkTimeHelper {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6300a = LazyKt.lazy(NetworkTimeHelper$mIoScope$2.INSTANCE);
    public long b;
    public long c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/translation/phone/helper/NetworkTimeHelper$Companion;", "", "()V", "APP_ID_KEY", "", "APP_ID_VALUE", "HEADER_CLIENT_ID", "NETWORK_TIME_URL", "TAG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static /* synthetic */ void g(NetworkTimeHelper networkTimeHelper, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = NetworkTimeHelper$getNetworkTime$1.INSTANCE;
        }
        networkTimeHelper.f(function2);
    }

    public final CoroutineScope e() {
        return (CoroutineScope) this.f6300a.getValue();
    }

    public final void f(Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(e(), (CoroutineContext) null, (CoroutineStart) null, new NetworkTimeHelper$getNetworkTime$2(function2, this, (Continuation<? super NetworkTimeHelper$getNetworkTime$2>) null), 3, (Object) null);
    }
}
