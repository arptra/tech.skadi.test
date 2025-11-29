package com.upuphone.xr.interconnect.ipc;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rJ\"\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u001bR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/interconnect/ipc/IpcClientManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "()V", "appIdToClientMap", "Ljava/util/HashMap;", "", "Lcom/upuphone/xr/interconnect/remote/BinderClient;", "Lkotlin/collections/HashMap;", "listeners", "Ljava/util/HashSet;", "Lcom/upuphone/xr/interconnect/remote/BinderClientDiedCallback;", "Lkotlin/collections/HashSet;", "pidToAppIdMap", "", "add", "", "pid", "appId", "addListener", "listener", "get", "(Ljava/lang/String;)Ljava/lang/Integer;", "notifyClientDied", "client", "remove", "useAppId", "action", "Lkotlin/Function1;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIpcClientManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IpcClientManager.kt\ncom/upuphone/xr/interconnect/ipc/IpcClientManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n1855#2,2:45\n*S KotlinDebug\n*F\n+ 1 IpcClientManager.kt\ncom/upuphone/xr/interconnect/ipc/IpcClientManager\n*L\n22#1:45,2\n*E\n"})
public final class IpcClientManager extends PetaStepSerializer {
    @NotNull
    public static final IpcClientManager INSTANCE = new IpcClientManager();
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<String, BinderClient> appIdToClientMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public static final HashSet<BinderClientDiedCallback> listeners = new HashSet<>();
    /* access modifiers changed from: private */
    @NotNull
    public static final HashMap<Integer, String> pidToAppIdMap = new HashMap<>();

    private IpcClientManager() {
        super(AnonymousClass1.INSTANCE, "iPCcET");
    }

    /* access modifiers changed from: private */
    public final void notifyClientDied(BinderClient binderClient) {
        for (BinderClientDiedCallback onClientDied : listeners) {
            onClientDied.onClientDied(binderClient);
        }
    }

    public final void add(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        serialize("adding", new IpcClientManager$add$1(i, str));
    }

    public final void addListener(@NotNull BinderClientDiedCallback binderClientDiedCallback) {
        Intrinsics.checkNotNullParameter(binderClientDiedCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        serialize("subscription", new IpcClientManager$addListener$1(binderClientDiedCallback));
    }

    @Nullable
    public final Integer get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        BinderClient binderClient = appIdToClientMap.get(str);
        if (binderClient != null) {
            return Integer.valueOf(binderClient.getId());
        }
        return null;
    }

    public final void remove(int i) {
        serialize("removal", new IpcClientManager$remove$1(i));
    }

    public final void useAppId(int i, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        serialize("app id usage", new IpcClientManager$useAppId$1(i, function1));
    }
}
