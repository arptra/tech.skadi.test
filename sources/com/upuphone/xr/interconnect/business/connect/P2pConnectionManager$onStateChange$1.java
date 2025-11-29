package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.common.IP2pStateListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nP2pConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 P2pConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/P2pConnectionManager$onStateChange$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1855#2,2:96\n1855#2,2:98\n*S KotlinDebug\n*F\n+ 1 P2pConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/P2pConnectionManager$onStateChange$1\n*L\n54#1:96,2\n67#1:98,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class P2pConnectionManager$onStateChange$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $connected;
    final /* synthetic */ StarryDevice $device;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ P2pConnectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P2pConnectionManager$onStateChange$1(String str, P2pConnectionManager p2pConnectionManager, boolean z, StarryDevice starryDevice) {
        super(0);
        this.$deviceId = str;
        this.this$0 = p2pConnectionManager;
        this.$connected = z;
        this.$device = starryDevice;
    }

    public final void invoke() {
        if (!Intrinsics.areEqual((Object) this.$deviceId, (Object) this.this$0.selectedDeviceId)) {
            String access$getTag = this.this$0.getTag();
            String str = this.$deviceId;
            ILog.i(access$getTag, "Dropping device connected update because device " + str + " is not the connected one.");
            return;
        }
        String access$getTag2 = this.this$0.getTag();
        boolean access$isConnected$p = this.this$0.isConnected;
        boolean z = this.$connected;
        ILog.d(access$getTag2, "Connected state update from " + access$isConnected$p + " to " + z + ".");
        boolean access$isConnected$p2 = this.this$0.isConnected;
        boolean z2 = this.$connected;
        if (access$isConnected$p2 != z2) {
            this.this$0.isConnected = z2;
            if (!this.this$0.p2pAcquireCallbackList.isEmpty()) {
                String access$getTag3 = this.this$0.getTag();
                int size = this.this$0.p2pAcquireCallbackList.size();
                boolean z3 = this.$connected;
                ILog.d(access$getTag3, "Informing " + size + " callbacks about connected: " + z3 + ".");
                Set<IP2pAcquireCallback> access$getP2pAcquireCallbackList$p = this.this$0.p2pAcquireCallbackList;
                boolean z4 = this.$connected;
                P2pConnectionManager p2pConnectionManager = this.this$0;
                for (IP2pAcquireCallback iP2pAcquireCallback : access$getP2pAcquireCallbackList$p) {
                    if (z4) {
                        Job unused = BuildersKt__Builders_commonKt.d(p2pConnectionManager.mainScope, (CoroutineContext) null, (CoroutineStart) null, new P2pConnectionManager$onStateChange$1$1$1(iP2pAcquireCallback, (Continuation<? super P2pConnectionManager$onStateChange$1$1$1>) null), 3, (Object) null);
                    } else {
                        Job unused2 = BuildersKt__Builders_commonKt.d(p2pConnectionManager.mainScope, (CoroutineContext) null, (CoroutineStart) null, new P2pConnectionManager$onStateChange$1$1$2(iP2pAcquireCallback, (Continuation<? super P2pConnectionManager$onStateChange$1$1$2>) null), 3, (Object) null);
                    }
                }
                this.this$0.p2pAcquireSet.clear();
                this.this$0.p2pAcquireCallbackList.clear();
                this.this$0.p2pAcquireCallbackListMap.clear();
            }
            if (!this.this$0.p2pStateListeners.isEmpty()) {
                String access$getTag4 = this.this$0.getTag();
                int size2 = this.this$0.p2pStateListeners.size();
                boolean z5 = this.$connected;
                ILog.d(access$getTag4, "Informing " + size2 + " listeners about connected: " + z5 + ".");
                Set<IP2pStateListener> access$getP2pStateListeners$p = this.this$0.p2pStateListeners;
                P2pConnectionManager p2pConnectionManager2 = this.this$0;
                boolean z6 = this.$connected;
                for (IP2pStateListener p2pConnectionManager$onStateChange$1$2$1 : access$getP2pStateListeners$p) {
                    Job unused3 = BuildersKt__Builders_commonKt.d(p2pConnectionManager2.mainScope, (CoroutineContext) null, (CoroutineStart) null, new P2pConnectionManager$onStateChange$1$2$1(p2pConnectionManager$onStateChange$1$2$1, p2pConnectionManager2, z6, (Continuation<? super P2pConnectionManager$onStateChange$1$2$1>) null), 3, (Object) null);
                }
            }
            if (!this.$connected) {
                this.this$0.selectedDeviceId = null;
                this.this$0.getInfoSlice().unset("device", this.$deviceId, "ipv4Address");
            } else if (this.$device.getAddress() != null) {
                String address = this.$device.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                this.this$0.getInfoSlice().set(new String[]{"device", this.$deviceId, "ipv4Address"}, address);
            } else {
                this.this$0.getInfoSlice().unset("device", this.$deviceId, "ipv4Address");
            }
        }
    }
}
