package com.upuphone.xr.interconnect.business.databinder;

import android.os.Binder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IDataBinderClient;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.remote.BinderClient;
import com.upuphone.xr.interconnect.remote.BinderClientDiedCallback;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u001f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u001d\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00072\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J \u0010\u0016\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderServer;", "Lcom/upuphone/xr/interconnect/common/IDataBinderServer$Stub;", "Lcom/upuphone/xr/interconnect/remote/BinderClientDiedCallback;", "()V", "clientManager", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderServer$ClientManager;", "tag", "", "get", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "deviceId", "name", "list", "", "onClientDied", "", "client", "Lcom/upuphone/xr/interconnect/remote/BinderClient;", "register", "Lcom/upuphone/xr/interconnect/common/IDataBinderClient;", "set", "value", "subscribe", "listener", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "unset", "unsubscribe", "ClientManager", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DataBinderServer extends IDataBinderServer.Stub implements BinderClientDiedCallback {
    @NotNull
    private final ClientManager clientManager;
    @NotNull
    private final String tag;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderServer$ClientManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "logTag", "", "(Ljava/lang/String;)V", "clientMap", "", "", "Lcom/upuphone/xr/interconnect/common/IDataBinderClient;", "register", "", "pid", "client", "unregister", "updateDeviceList", "deviceList", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClientManager extends PetaStepSerializer {
        /* access modifiers changed from: private */
        @NotNull
        public final Map<Integer, IDataBinderClient> clientMap = new LinkedHashMap();

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClientManager(@NotNull String str) {
            super(AnonymousClass1.INSTANCE, str);
            Intrinsics.checkNotNullParameter(str, "logTag");
        }

        public final void register(int i, @NotNull IDataBinderClient iDataBinderClient) {
            Intrinsics.checkNotNullParameter(iDataBinderClient, "client");
            serialize("client registration", new DataBinderServer$ClientManager$register$1(this, i, iDataBinderClient));
        }

        public final void unregister(int i) {
            serialize("client removal", new DataBinderServer$ClientManager$unregister$1(this, i));
        }

        public final void updateDeviceList(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "deviceList");
            serialize("device list broadcasting", new DataBinderServer$ClientManager$updateDeviceList$1(this, list));
        }
    }

    public DataBinderServer() {
        String stringify = PrettyPrintExtKt.stringify(this, "DataBinderServer");
        this.tag = stringify;
        this.clientManager = new ClientManager(stringify);
    }

    @Nullable
    public DataBinderValue<?> get(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        return InterconnectManager.getInstance().getDataBinderManager().get(str, str2);
    }

    @Nullable
    public List<String> list(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return InterconnectManager.getInstance().getDataBinderManager().list(str);
    }

    public void onClientDied(@NotNull BinderClient binderClient) {
        Intrinsics.checkNotNullParameter(binderClient, "client");
        this.clientManager.unregister(binderClient.getId());
        InterconnectManager.getInstance().getDataBinderManager().getItemSubscribeManager$SharedImpl_intlRelease().unsubscribeAll(binderClient.getId());
    }

    public void register(@NotNull IDataBinderClient iDataBinderClient) {
        Intrinsics.checkNotNullParameter(iDataBinderClient, "client");
        this.clientManager.register(Binder.getCallingPid(), iDataBinderClient);
    }

    public void set(@NotNull String str, @NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(dataBinderValue, AccountConstantKt.RESPONSE_VALUE);
        InterconnectManager.getInstance().getDataBinderManager().set(str, dataBinderValue);
    }

    public void subscribe(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        int callingPid = Binder.getCallingPid();
        String str3 = this.tag;
        ILog.d(str3, "Client " + callingPid + " subscribing on " + str + "/" + str2 + " with " + iDataBinderItemUpdateListener + ".");
        InterconnectManager.getInstance().getDataBinderManager().getItemSubscribeManager$SharedImpl_intlRelease().subscribe(callingPid, str, str2, iDataBinderItemUpdateListener);
    }

    public void unset(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        InterconnectManager.getInstance().getDataBinderManager().unset(str);
    }

    public void unsubscribe(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        int callingPid = Binder.getCallingPid();
        String str3 = this.tag;
        ILog.d(str3, "Client " + callingPid + " unsubscribing on " + str + "/" + str2 + ".");
        InterconnectManager.getInstance().getDataBinderManager().getItemSubscribeManager$SharedImpl_intlRelease().unsubscribe(Binder.getCallingPid(), str, str2);
    }
}
