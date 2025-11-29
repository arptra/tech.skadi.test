package com.upuphone.xr.interconnect.business.databinder;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\b\n\u000b\f\r\u000e\u000f\u0010\u0011B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0001\b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent;", "deviceId", "", "(Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "stringifyPrefix", "getStringifyPrefix", "stringify", "HandleOperation", "HandleRequest", "ServiceDown", "ServiceUp", "Subscribe", "SubscribeInner", "Unsubscribe", "UnsubscribeInner", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$HandleOperation;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$HandleRequest;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$ServiceDown;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$ServiceUp;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$Subscribe;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$SubscribeInner;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$Unsubscribe;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$UnsubscribeInner;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DataBinderDeviceEvent extends DataBinderEvent {
    @NotNull
    private final String deviceId;
    @NotNull
    private final String stringifyPrefix;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$HandleOperation;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "operation", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "(Ljava/lang/String;Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;)V", "getOperation", "()Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "stringify", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class HandleOperation extends DataBinderDeviceEvent {
        @NotNull
        private final DataBinderOperation operation;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HandleOperation(@NotNull String str, @NotNull DataBinderOperation dataBinderOperation) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(dataBinderOperation, "operation");
            this.operation = dataBinderOperation;
        }

        @NotNull
        public final DataBinderOperation getOperation() {
            return this.operation;
        }

        @NotNull
        public String stringify() {
            String stringifyPrefix = getStringifyPrefix();
            String stringify = this.operation.stringify();
            return stringifyPrefix + "HandleOperation(" + stringify + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$HandleRequest;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "(Ljava/lang/String;)V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class HandleRequest extends DataBinderDeviceEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HandleRequest(@NotNull String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$ServiceDown;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "(Ljava/lang/String;)V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ServiceDown extends DataBinderDeviceEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ServiceDown(@NotNull String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$ServiceUp;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "(Ljava/lang/String;)V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ServiceUp extends DataBinderDeviceEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ServiceUp(@NotNull String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$Subscribe;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "name", "listener", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;)V", "getListener", "()Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;", "getName", "()Ljava/lang/String;", "stringify", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Subscribe extends DataBinderDeviceEvent {
        @NotNull
        private final DataBinderItemUpdateListener listener;
        @NotNull
        private final String name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Subscribe(@NotNull String str, @NotNull String str2, @NotNull DataBinderItemUpdateListener dataBinderItemUpdateListener) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(dataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.name = str2;
            this.listener = dataBinderItemUpdateListener;
        }

        @NotNull
        public final DataBinderItemUpdateListener getListener() {
            return this.listener;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public String stringify() {
            String stringifyPrefix = getStringifyPrefix();
            String str = this.name;
            String stringify = PrettyPrintExtKt.stringify(this.listener);
            return stringifyPrefix + "Subscribe(" + str + ", " + stringify + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$SubscribeInner;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "name", "listener", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;)V", "getListener", "()Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "getName", "()Ljava/lang/String;", "stringify", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SubscribeInner extends DataBinderDeviceEvent {
        @NotNull
        private final IDataBinderItemUpdateListener listener;
        @NotNull
        private final String name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SubscribeInner(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.name = str2;
            this.listener = iDataBinderItemUpdateListener;
        }

        @NotNull
        public final IDataBinderItemUpdateListener getListener() {
            return this.listener;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public String stringify() {
            String stringifyPrefix = getStringifyPrefix();
            String str = this.name;
            String stringify = PrettyPrintExtKt.stringify(this.listener);
            return stringifyPrefix + "Subscribe(" + str + ", " + stringify + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$Unsubscribe;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "name", "listener", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;)V", "getListener", "()Lcom/upuphone/xr/interconnect/business/databinder/DataBinderItemUpdateListener;", "getName", "()Ljava/lang/String;", "stringify", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Unsubscribe extends DataBinderDeviceEvent {
        @NotNull
        private final DataBinderItemUpdateListener listener;
        @NotNull
        private final String name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unsubscribe(@NotNull String str, @NotNull String str2, @NotNull DataBinderItemUpdateListener dataBinderItemUpdateListener) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(dataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.name = str2;
            this.listener = dataBinderItemUpdateListener;
        }

        @NotNull
        public final DataBinderItemUpdateListener getListener() {
            return this.listener;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public String stringify() {
            String stringifyPrefix = getStringifyPrefix();
            String str = this.name;
            String stringify = PrettyPrintExtKt.stringify(this.listener);
            return stringifyPrefix + "Unsubscribe(" + str + ", " + stringify + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent$UnsubscribeInner;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "deviceId", "", "name", "listener", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;)V", "getListener", "()Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "getName", "()Ljava/lang/String;", "stringify", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnsubscribeInner extends DataBinderDeviceEvent {
        @NotNull
        private final IDataBinderItemUpdateListener listener;
        @NotNull
        private final String name;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnsubscribeInner(@NotNull String str, @NotNull String str2, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.name = str2;
            this.listener = iDataBinderItemUpdateListener;
        }

        @NotNull
        public final IDataBinderItemUpdateListener getListener() {
            return this.listener;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public String stringify() {
            String stringifyPrefix = getStringifyPrefix();
            String str = this.name;
            String stringify = PrettyPrintExtKt.stringify(this.listener);
            return stringifyPrefix + "Unsubscribe(" + str + ", " + stringify + ")";
        }
    }

    public /* synthetic */ DataBinderDeviceEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getStringifyPrefix() {
        return this.stringifyPrefix;
    }

    @NotNull
    public String stringify() {
        String str = this.stringifyPrefix;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.Any");
        String stringify = PrettyPrintExtKt.stringify(this);
        return str + stringify;
    }

    private DataBinderDeviceEvent(String str) {
        super((DefaultConstructorMarker) null);
        this.deviceId = str;
        this.stringifyPrefix = str + "::";
    }
}
