package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;

@SourceDebugExtension({"SMAP\nBaseConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onBindStateChangeForGlass$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1855#2,2:195\n1855#2,2:197\n1855#2,2:199\n1855#2,2:201\n*S KotlinDebug\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onBindStateChangeForGlass$1\n*L\n171#1:195,2\n176#1:197,2\n181#1:199,2\n187#1:201,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BaseConnectionManager$onBindStateChangeForGlass$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ int $newState;
    final /* synthetic */ BaseConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseConnectionManager$onBindStateChangeForGlass$1(StarryDevice starryDevice, BaseConnectionManager baseConnectionManager, int i) {
        super(0);
        this.$device = starryDevice;
        this.this$0 = baseConnectionManager;
        this.$newState = i;
    }

    public final void invoke() {
        String id = this.$device.getId();
        if (id == null) {
            ILog.w(this.this$0.getTag(), "Dropping null-id-device when handling bind state change.for glass");
            return;
        }
        String access$getTag = this.this$0.getTag();
        String num = Integer.toString(this.$newState, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        ILog.i(access$getTag, "#" + id + " bind state is changed to " + num + ".for glass");
        if (this.$newState == 4) {
            String access$getTag2 = this.this$0.getTag();
            int i = this.$newState;
            ILog.i(access$getTag2, "DeviceConnectUtil DEVICE_BOND_STATE_BONDED setDeviceId id = " + id + ",state = " + i + " for glass");
            XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
            xrSdkBondDeviceUtil.setDeviceId(id);
            xrSdkBondDeviceUtil.checkConnectTimeOutStatus();
        }
        int i2 = this.$newState;
        if (i2 == 0) {
            if (this.this$0.getBleBoundGlassDeviceIds().remove(id)) {
                Set<BaseConnectionListener> access$getListeners = this.this$0.getListeners();
                StarryDevice starryDevice = this.$device;
                BaseConnectionManager baseConnectionManager = this.this$0;
                for (BaseConnectionListener onGlassBleUnbound : access$getListeners) {
                    onGlassBleUnbound.onGlassBleUnbound(id, starryDevice, baseConnectionManager.getBrBoundGlassDeviceIds().contains(id));
                }
            }
            this.this$0.processBrUnbindingForGlass(id, this.$device, false);
        } else if (i2 == 16) {
            BaseConnectionManager baseConnectionManager2 = this.this$0;
            baseConnectionManager2.processBrUnbindingForGlass(id, this.$device, baseConnectionManager2.getBleBoundGlassDeviceIds().contains(id));
        } else if (i2 != 48) {
            if (i2 == 3) {
                Set<BaseConnectionListener> access$getListeners2 = this.this$0.getListeners();
                StarryDevice starryDevice2 = this.$device;
                for (BaseConnectionListener onGlassBleBinding : access$getListeners2) {
                    onGlassBleBinding.onGlassBleBinding(id, starryDevice2);
                }
            } else if (i2 == 4 && !this.this$0.getBleBoundGlassDeviceIds().contains(id)) {
                this.this$0.getBleBoundGlassDeviceIds().add(id);
                Set<BaseConnectionListener> access$getListeners3 = this.this$0.getListeners();
                StarryDevice starryDevice3 = this.$device;
                BaseConnectionManager baseConnectionManager3 = this.this$0;
                for (BaseConnectionListener onGlassBleBound : access$getListeners3) {
                    onGlassBleBound.onGlassBleBound(id, starryDevice3, baseConnectionManager3.getBrBoundGlassDeviceIds().contains(id));
                }
            }
        } else if (!this.this$0.getBrBoundGlassDeviceIds().contains(id)) {
            this.this$0.getBrBoundGlassDeviceIds().add(id);
            Set<BaseConnectionListener> access$getListeners4 = this.this$0.getListeners();
            StarryDevice starryDevice4 = this.$device;
            BaseConnectionManager baseConnectionManager4 = this.this$0;
            for (BaseConnectionListener onGlassBrBound : access$getListeners4) {
                onGlassBrBound.onGlassBrBound(id, starryDevice4, baseConnectionManager4.getBleBoundGlassDeviceIds().contains(id));
            }
        }
    }
}
