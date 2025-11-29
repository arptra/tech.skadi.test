package com.upuphone.xr.interconnect.business.connect.behavior;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0010\u0018\u0000 \n2\u00020\u0001:\u0001\nB#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/behavior/DeviceTraits;", "", "hasHost", "", "isHostAlwaysRunning", "brEnabled", "(ZZZ)V", "getBrEnabled", "()Z", "getHasHost", "Companion", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DeviceTraits {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean brEnabled;
    private final boolean hasHost;
    private final boolean isHostAlwaysRunning;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/behavior/DeviceTraits$Companion;", "Lcom/upuphone/xr/interconnect/business/connect/behavior/DeviceTraits;", "()V", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion extends DeviceTraits {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
            super(false, false, false, 7, (DefaultConstructorMarker) null);
        }
    }

    public DeviceTraits() {
        this(false, false, false, 7, (DefaultConstructorMarker) null);
    }

    public final boolean getBrEnabled() {
        return this.brEnabled;
    }

    public final boolean getHasHost() {
        return this.hasHost;
    }

    public final boolean isHostAlwaysRunning() {
        return this.isHostAlwaysRunning;
    }

    public DeviceTraits(boolean z, boolean z2, boolean z3) {
        this.hasHost = z;
        this.isHostAlwaysRunning = z2;
        this.brEnabled = z3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceTraits(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? true : z3);
    }
}
