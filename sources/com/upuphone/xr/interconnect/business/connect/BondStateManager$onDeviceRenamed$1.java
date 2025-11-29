package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nBondStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BondStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/BondStateManager$onDeviceRenamed$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1855#2,2:83\n*S KotlinDebug\n*F\n+ 1 BondStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/BondStateManager$onDeviceRenamed$1\n*L\n43#1:83,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class BondStateManager$onDeviceRenamed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $newName;
    final /* synthetic */ BondStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BondStateManager$onDeviceRenamed$1(BondStateManager bondStateManager, String str, String str2) {
        super(0);
        this.this$0 = bondStateManager;
        this.$deviceId = str;
        this.$newName = str2;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        String str2 = this.$newName;
        ILog.d(access$getTag, "#" + str + " is renamed to " + str2 + ".");
        StarryNetDevice starryNetDevice = this.this$0.getBoundGlassDeviceMap().get(this.$deviceId);
        if (starryNetDevice != null) {
            String str3 = this.$newName;
            BondStateManager bondStateManager = this.this$0;
            starryNetDevice.setDeviceName(str3);
            for (BondStateListener onBound : bondStateManager.getListeners()) {
                onBound.onBound(starryNetDevice);
            }
        }
    }
}
