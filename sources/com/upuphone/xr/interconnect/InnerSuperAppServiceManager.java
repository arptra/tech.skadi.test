package com.upuphone.xr.interconnect;

import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.inner.OperatorManagerCreator;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.collection.Buckets;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nJ\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/interconnect/InnerSuperAppServiceManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "()V", "instances", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "getInstances", "()Ljava/util/concurrent/ConcurrentHashMap;", "<set-?>", "Lcom/upuphone/xr/interconnect/inner/OperatorManagerCreator;", "operatorManagerCreator", "getOperatorManagerCreator", "()Lcom/upuphone/xr/interconnect/inner/OperatorManagerCreator;", "requests", "Lcom/upuphone/xr/interconnect/util/collection/Buckets;", "Lcom/upuphone/xr/interconnect/OperatorManagerCreateCallback;", "inject", "", "creator", "request", "appId", "callback", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InnerSuperAppServiceManager extends PetaStepSerializer {
    @NotNull
    private final ConcurrentHashMap<String, OperatorManager> instances = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    @Nullable
    public OperatorManagerCreator operatorManagerCreator;
    /* access modifiers changed from: private */
    @NotNull
    public final Buckets<String, OperatorManagerCreateCallback> requests = new Buckets<>();

    public InnerSuperAppServiceManager() {
        super(AnonymousClass1.INSTANCE, "sAS");
    }

    @NotNull
    public final ConcurrentHashMap<String, OperatorManager> getInstances() {
        return this.instances;
    }

    @Nullable
    public final OperatorManagerCreator getOperatorManagerCreator() {
        return this.operatorManagerCreator;
    }

    public final void inject(@NotNull OperatorManagerCreator operatorManagerCreator2) {
        Intrinsics.checkNotNullParameter(operatorManagerCreator2, "creator");
        serialize("creator ready", new InnerSuperAppServiceManager$inject$1(this, operatorManagerCreator2));
    }

    public final void request(@NotNull String str, @NotNull OperatorManagerCreateCallback operatorManagerCreateCallback) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(operatorManagerCreateCallback, "callback");
        serialize("callback addition", new InnerSuperAppServiceManager$request$1(this, str, operatorManagerCreateCallback));
    }
}
