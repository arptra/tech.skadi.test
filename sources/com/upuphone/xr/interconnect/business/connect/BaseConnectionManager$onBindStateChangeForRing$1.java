package com.upuphone.xr.interconnect.business.connect;

import android.content.Context;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nBaseConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onBindStateChangeForRing$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1855#2,2:195\n1855#2,2:197\n*S KotlinDebug\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager$onBindStateChangeForRing$1\n*L\n139#1:195,2\n146#1:197,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BaseConnectionManager$onBindStateChangeForRing$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ int $newState;
    final /* synthetic */ BaseConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseConnectionManager$onBindStateChangeForRing$1(StarryDevice starryDevice, BaseConnectionManager baseConnectionManager, int i) {
        super(0);
        this.$device = starryDevice;
        this.this$0 = baseConnectionManager;
        this.$newState = i;
    }

    public final void invoke() {
        String id = this.$device.getId();
        if (id == null) {
            ILog.w(this.this$0.getTag(), "Dropping null-id-device when handling bind state change. for glass");
            return;
        }
        String access$getTag = this.this$0.getTag();
        int i = this.$newState;
        ILog.i(access$getTag, "#" + id + " bind state is changed to " + i + ". for ring");
        int i2 = this.$newState;
        if (i2 == 0) {
            this.this$0.getBoundRingDeviceIds().remove(id);
            ULog.f6446a.c("PetaStepSerializer", "clear boned ring device");
            XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
            Context context = InterconnectManager.getInstance().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            xrSdkBondDeviceUtil.clearBondedRingDeviceFromSp(context);
            Set<BaseConnectionListener> access$getListeners = this.this$0.getListeners();
            StarryDevice starryDevice = this.$device;
            for (BaseConnectionListener onRingUnbound : access$getListeners) {
                onRingUnbound.onRingUnbound(id, starryDevice);
            }
        } else if (i2 != 4) {
            ILog.w(this.this$0.getTag(), "onBindStateChangeForRing else");
        } else {
            this.this$0.getBoundRingDeviceIds().add(id);
            StarryNetDevice wrapForConnection = StarryDeviceExt.wrapForConnection(this.$device);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("PetaStepSerializer", "save boned ring device = " + wrapForConnection);
            XrSdkBondDeviceUtil xrSdkBondDeviceUtil2 = XrSdkBondDeviceUtil.INSTANCE;
            Context context2 = InterconnectManager.getInstance().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            xrSdkBondDeviceUtil2.saveBondedRingDeviceFromSp(context2, wrapForConnection);
            Set<BaseConnectionListener> access$getListeners2 = this.this$0.getListeners();
            StarryDevice starryDevice2 = this.$device;
            for (BaseConnectionListener onRingBound : access$getListeners2) {
                onRingBound.onRingBound(id, starryDevice2);
            }
        }
    }
}
