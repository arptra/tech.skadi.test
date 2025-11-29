package com.upuphone.xr.interconnect.outer;

import androidx.annotation.CallSuper;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005¢\u0006\u0002\u0010\u0006J4\u0010\f\u001a\u0002H\r\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u0002H\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\r0\u0010¢\u0006\u0002\b\u0011H\u0004¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0017J\b\u0010\u0015\u001a\u00020\u0014H\u0017J.\u0010\u0016\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0001\u0010\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\r0\u0010¢\u0006\u0002\b\u0011H\u0004¢\u0006\u0002\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00018\u00002\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/BaseOperatorImpl;", "R", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/outer/SuperServiceStateListener;", "remoteProxyGetter", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "remoteProxy", "getRemoteProxy", "()Ljava/lang/Object;", "Ljava/lang/Object;", "fallbackRemoteProxyCall", "T", "defaultValue", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onServiceConnected", "", "onServiceDied", "safeRemoteProxyCall", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseOperatorImpl<R> extends PetaStepSerializer implements SuperServiceStateListener {
    /* access modifiers changed from: private */
    @Nullable
    public volatile R remoteProxy;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<R> remoteProxyGetter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseOperatorImpl(@NotNull Function0<? extends R> function0) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(function0, "remoteProxyGetter");
        this.remoteProxyGetter = function0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r1 = com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt.safeRemoteCall(r1, r2, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T fallbackRemoteProxyCall(T r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super R, ? extends T> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            R r1 = r1.remoteProxy
            if (r1 == 0) goto L_0x0011
            java.lang.Object r1 = com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt.safeRemoteCall(r1, r2, r3)
            if (r1 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r2 = r1
        L_0x0011:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.outer.BaseOperatorImpl.fallbackRemoteProxyCall(java.lang.Object, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @Nullable
    public final R getRemoteProxy() {
        return this.remoteProxy;
    }

    @CallSuper
    public void onServiceConnected() {
        serialize("connect to service", new BaseOperatorImpl$onServiceConnected$1(this));
    }

    @CallSuper
    public void onServiceDied() {
        serialize("reset service status", new BaseOperatorImpl$onServiceDied$1(this));
    }

    @Nullable
    public final <T> T safeRemoteProxyCall(@NotNull Function1<? super R, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        R r = this.remoteProxy;
        if (r != null) {
            return RemoteInterfaceExtKt.safeRemoteCall(r, function1);
        }
        return null;
    }
}
