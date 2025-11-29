package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent;", "", "()V", "stringify", "", "RequestUpdate", "SendMessage", "Start", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderDeviceEvent;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent$RequestUpdate;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent$SendMessage;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent$Start;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DataBinderEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent$RequestUpdate;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent;", "()V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestUpdate extends DataBinderEvent {
        @NotNull
        public static final RequestUpdate INSTANCE = new RequestUpdate();

        private RequestUpdate() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent$SendMessage;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent;", "()V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SendMessage extends DataBinderEvent {
        @NotNull
        public static final SendMessage INSTANCE = new SendMessage();

        private SendMessage() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent$Start;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderEvent;", "()V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Start extends DataBinderEvent {
        @NotNull
        public static final Start INSTANCE = new Start();

        private Start() {
            super((DefaultConstructorMarker) null);
        }
    }

    public /* synthetic */ DataBinderEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public String stringify() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.Any");
        return PrettyPrintExtKt.stringify(this);
    }

    private DataBinderEvent() {
    }
}
