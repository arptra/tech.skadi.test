package com.upuphone.xr.interconnect.outer;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.xr.interconnect.api.DataBinderOperator;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import com.upuphone.xr.interconnect.api.InfoOperator;
import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.api.info.DeviceInfoOperator;
import com.upuphone.xr.interconnect.api.info.InfoEndpoint;
import com.upuphone.xr.interconnect.api.info.InfoMapOperator;
import com.upuphone.xr.interconnect.api.info.PeerInfoOperator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/InfoOperatorImpl;", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "dataBinderOperatorGetter", "Lkotlin/Function0;", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "(Lkotlin/jvm/functions/Function0;)V", "dataBinderSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "getDataBinderSlice", "()Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "dataBinderSlice$delegate", "Lkotlin/Lazy;", "device", "Lcom/upuphone/xr/interconnect/api/info/InfoMapOperator;", "Lcom/upuphone/xr/interconnect/api/info/DeviceInfoOperator;", "getDevice", "()Lcom/upuphone/xr/interconnect/api/info/InfoMapOperator;", "peer", "Lcom/upuphone/xr/interconnect/api/info/PeerInfoOperator;", "getPeer", "()Lcom/upuphone/xr/interconnect/api/info/PeerInfoOperator;", "DeviceInfoMapOperator", "InnerDeviceOperator", "InnerPeerInfoOperator", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InfoOperatorImpl implements InfoOperator {
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<DataBinderOperator> dataBinderOperatorGetter;
    @NotNull
    private final Lazy dataBinderSlice$delegate = LazyKt.lazy(new InfoOperatorImpl$dataBinderSlice$2(this));
    @NotNull
    private final InfoMapOperator<DeviceInfoOperator> device = new DeviceInfoMapOperator();
    @NotNull
    private final PeerInfoOperator peer = new InnerPeerInfoOperator(getDataBinderSlice());

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/InfoOperatorImpl$DeviceInfoMapOperator;", "Lcom/upuphone/xr/interconnect/api/info/InfoMapOperator;", "Lcom/upuphone/xr/interconnect/api/info/DeviceInfoOperator;", "(Lcom/upuphone/xr/interconnect/outer/InfoOperatorImpl;)V", "get", "key", "", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class DeviceInfoMapOperator implements InfoMapOperator<DeviceInfoOperator> {
        public DeviceInfoMapOperator() {
        }

        @NotNull
        public DeviceInfoOperator get(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            return new InnerDeviceOperator(InfoOperatorImpl.this, str);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/InfoOperatorImpl$InnerDeviceOperator;", "Lcom/upuphone/xr/interconnect/api/info/DeviceInfoOperator;", "deviceId", "", "(Lcom/upuphone/xr/interconnect/outer/InfoOperatorImpl;Ljava/lang/String;)V", "connectionLevel", "Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "Lcom/upuphone/xr/interconnect/api/connection/ConnectionLevel;", "getConnectionLevel", "()Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "ipv4Address", "getIpv4Address", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class InnerDeviceOperator implements DeviceInfoOperator {
        @NotNull
        private final InfoEndpoint<ConnectionLevel> connectionLevel;
        /* access modifiers changed from: private */
        @NotNull
        public final String deviceId;
        @NotNull
        private final InfoEndpoint<String> ipv4Address;
        final /* synthetic */ InfoOperatorImpl this$0;

        public InnerDeviceOperator(@NotNull InfoOperatorImpl infoOperatorImpl, String str) {
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            this.this$0 = infoOperatorImpl;
            this.deviceId = str;
            this.connectionLevel = new InfoOperatorImpl$InnerDeviceOperator$connectionLevel$1(infoOperatorImpl, this);
            this.ipv4Address = new InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1(infoOperatorImpl, this);
        }

        @NotNull
        public InfoEndpoint<ConnectionLevel> getConnectionLevel() {
            return this.connectionLevel;
        }

        @NotNull
        public InfoEndpoint<String> getIpv4Address() {
            return this.ipv4Address;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/interconnect/outer/InfoOperatorImpl$InnerPeerInfoOperator;", "Lcom/upuphone/xr/interconnect/api/info/PeerInfoOperator;", "dataBinderSlice", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "(Lcom/upuphone/xr/interconnect/api/DataBinderSlice;)V", "version", "Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "", "getVersion", "()Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InnerPeerInfoOperator implements PeerInfoOperator {
        @NotNull
        private final InfoEndpoint<Integer> version;

        public InnerPeerInfoOperator(@NotNull DataBinderSlice dataBinderSlice) {
            Intrinsics.checkNotNullParameter(dataBinderSlice, "dataBinderSlice");
            this.version = new InfoOperatorImpl$InnerPeerInfoOperator$version$1(dataBinderSlice);
        }

        @NotNull
        public InfoEndpoint<Integer> getVersion() {
            return this.version;
        }
    }

    public InfoOperatorImpl(@NotNull Function0<? extends DataBinderOperator> function0) {
        Intrinsics.checkNotNullParameter(function0, "dataBinderOperatorGetter");
        this.dataBinderOperatorGetter = function0;
    }

    /* access modifiers changed from: private */
    public final DataBinderSlice getDataBinderSlice() {
        return (DataBinderSlice) this.dataBinderSlice$delegate.getValue();
    }

    @NotNull
    public InfoMapOperator<DeviceInfoOperator> getDevice() {
        return this.device;
    }

    @NotNull
    public PeerInfoOperator getPeer() {
        return this.peer;
    }
}
