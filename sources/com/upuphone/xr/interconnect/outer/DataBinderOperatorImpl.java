package com.upuphone.xr.interconnect.outer;

import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.api.DataBinderOperator;
import com.upuphone.xr.interconnect.common.IDataBinderClient;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.databinder.DataBinderOperatorItemUpdateListenerManager;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.util.RemoteInterfaceExtKt;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u001d\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000b2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\rH\u0002J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J \u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0012\u0010\u0006\u001a\u00060\u0007R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/DataBinderOperatorImpl;", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "Lcom/upuphone/xr/interconnect/outer/SuperServiceStateListener;", "provider", "Lcom/upuphone/xr/interconnect/outer/SuperServiceProvider;", "(Lcom/upuphone/xr/interconnect/outer/SuperServiceProvider;)V", "client", "Lcom/upuphone/xr/interconnect/outer/DataBinderOperatorImpl$DataBinderClient;", "listenerManager", "Lcom/upuphone/xr/interconnect/databinder/DataBinderOperatorItemUpdateListenerManager;", "logTag", "", "get", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "deviceId", "name", "list", "", "logd", "", "text", "onServiceConnected", "onServiceDied", "set", "value", "subscribe", "listener", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "unset", "unsubscribe", "DataBinderClient", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorImpl extends DataBinderOperator implements SuperServiceStateListener {
    /* access modifiers changed from: private */
    @NotNull
    public final DataBinderClient client = new DataBinderClient();
    /* access modifiers changed from: private */
    @NotNull
    public final DataBinderOperatorItemUpdateListenerManager listenerManager;
    @NotNull
    private final String logTag;
    /* access modifiers changed from: private */
    @NotNull
    public final SuperServiceProvider provider;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/DataBinderOperatorImpl$DataBinderClient;", "Lcom/upuphone/xr/interconnect/common/IDataBinderClient$Stub;", "(Lcom/upuphone/xr/interconnect/outer/DataBinderOperatorImpl;)V", "updateDeviceList", "", "deviceIdList", "", "", "([Ljava/lang/String;)V", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DataBinderClient extends IDataBinderClient.Stub {
        public DataBinderClient() {
        }

        public void updateDeviceList(@NotNull String[] strArr) {
            Intrinsics.checkNotNullParameter(strArr, "deviceIdList");
            DataBinderOperatorImpl.this.listenerManager.updateDeviceList(strArr);
        }
    }

    public DataBinderOperatorImpl(@NotNull SuperServiceProvider superServiceProvider) {
        Intrinsics.checkNotNullParameter(superServiceProvider, "provider");
        this.provider = superServiceProvider;
        String stringify = PrettyPrintExtKt.stringify(this, "DataBinderOperator");
        this.logTag = stringify;
        this.listenerManager = new DataBinderOperatorItemUpdateListenerManager(stringify, new DataBinderOperatorImpl$listenerManager$1(this));
    }

    /* access modifiers changed from: private */
    public final void logd(String str) {
        Log.d(this.logTag, str);
    }

    @Nullable
    public DataBinderValue<?> get(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        IDataBinderServer dataBinder = this.provider.getDataBinder();
        if (dataBinder != null) {
            return (DataBinderValue) RemoteInterfaceExtKt.safeRemoteCall(dataBinder, (Function1<? super String, Unit>) new DataBinderOperatorImpl$get$1(this), new DataBinderOperatorImpl$get$2(str, str2));
        }
        return null;
    }

    @Nullable
    public List<String> list(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        IDataBinderServer dataBinder = this.provider.getDataBinder();
        if (dataBinder != null) {
            return (List) RemoteInterfaceExtKt.safeRemoteCall(dataBinder, (Function1<? super String, Unit>) new DataBinderOperatorImpl$list$1(this), new DataBinderOperatorImpl$list$2(str));
        }
        return null;
    }

    public void onServiceConnected() {
        IDataBinderServer dataBinder = this.provider.getDataBinder();
        if (dataBinder != null) {
            Unit unit = (Unit) RemoteInterfaceExtKt.safeRemoteCall(dataBinder, (Function1<? super String, Unit>) new DataBinderOperatorImpl$onServiceConnected$1(this), new DataBinderOperatorImpl$onServiceConnected$2(this));
        }
        this.listenerManager.registerSubscribers();
    }

    public void onServiceDied() {
    }

    public void set(@NotNull String str, @NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(dataBinderValue, AccountConstantKt.RESPONSE_VALUE);
        IDataBinderServer dataBinder = this.provider.getDataBinder();
        if (dataBinder != null) {
            Unit unit = (Unit) RemoteInterfaceExtKt.safeRemoteCall(dataBinder, (Function1<? super String, Unit>) new DataBinderOperatorImpl$set$1(this), new DataBinderOperatorImpl$set$2(str, dataBinderValue));
        }
    }

    public void subscribe(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listenerManager.subscribe(str, str2, iDataBinderItemUpdateListener);
    }

    public void unset(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        IDataBinderServer dataBinder = this.provider.getDataBinder();
        if (dataBinder != null) {
            Unit unit = (Unit) RemoteInterfaceExtKt.safeRemoteCall(dataBinder, (Function1<? super String, Unit>) new DataBinderOperatorImpl$unset$1(this), new DataBinderOperatorImpl$unset$2(str));
        }
    }

    public void unsubscribe(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listenerManager.unsubscribe(str, str2, iDataBinderItemUpdateListener);
    }
}
