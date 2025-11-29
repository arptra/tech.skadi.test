package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PayloadLoggingKt;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$handleMessage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map<Integer, Function2<byte[], String, Unit>> $consumerMap;
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $uniteCode;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$handleMessage$1(PeerDeviceStatusManager peerDeviceStatusManager, String str, String str2, byte[] bArr, Map<Integer, ? extends Function2<? super byte[], ? super String, Unit>> map) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$deviceId = str;
        this.$uniteCode = str2;
        this.$data = bArr;
        this.$consumerMap = map;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        String str2 = this.$uniteCode;
        int length = this.$data.length;
        ILog.d(access$getTag, "#" + str + "/" + str2 + " sent " + length + "B message.");
        String access$getTag2 = this.this$0.getTag();
        String readableSamplePrint = PayloadLoggingKt.readableSamplePrint(this.$data, 100);
        StringBuilder sb = new StringBuilder();
        sb.append("Content: ");
        sb.append(readableSamplePrint);
        ILog.v(access$getTag2, sb.toString());
        Integer num = (Integer) this.this$0.versionMap.get(this.$deviceId);
        Unit unit = null;
        if (this.$data[0] == 32) {
            Job access$getCheckVersionSendJob$p = this.this$0.checkVersionSendJob;
            if (access$getCheckVersionSendJob$p != null) {
                PeerDeviceStatusManager peerDeviceStatusManager = this.this$0;
                ILog.w(peerDeviceStatusManager.getTag(), "job is not null cancel");
                Job.DefaultImpls.a(access$getCheckVersionSendJob$p, (CancellationException) null, 1, (Object) null);
                peerDeviceStatusManager.checkVersionSendJob = null;
            }
            int access$parseConnectMessage = this.this$0.parseConnectMessage(this.$data);
            if (access$parseConnectMessage > 0) {
                String access$getTag3 = this.this$0.getTag();
                String str3 = this.$deviceId;
                ILog.d(access$getTag3, "#" + str3 + " version confirmed to be " + access$parseConnectMessage + ".");
                this.this$0.hostStatusManager.cancelHostStartJob(this.$deviceId);
                this.this$0.versionMap.put(this.$deviceId, Integer.valueOf(access$parseConnectMessage));
                if (access$parseConnectMessage < PeerDeviceStatusManager.Companion.getSelfVersion()) {
                    this.this$0.versionSendManager.launchVersionSendJob(this.$deviceId, access$parseConnectMessage);
                } else if (this.this$0.isVersionSent(this.$deviceId)) {
                    if (this.$consumerMap.containsKey(Integer.valueOf(access$parseConnectMessage))) {
                        this.this$0.startCommunication(this.$deviceId);
                    }
                }
            } else {
                String access$getTag4 = this.this$0.getTag();
                String str4 = this.$deviceId;
                ILog.e(access$getTag4, "#" + str4 + " connect message not parsable.");
            }
        } else if (num == null) {
            String access$getTag5 = this.this$0.getTag();
            String str5 = this.$deviceId;
            ILog.d(access$getTag5, "#" + str5 + " version receivedVersion is null");
        } else {
            String access$getTag6 = this.this$0.getTag();
            String str6 = this.$deviceId;
            ILog.d(access$getTag6, "#" + str6 + " normal msg receivedVersion = " + num);
            if (!this.this$0.isVersionSent(this.$deviceId)) {
                String access$getTag7 = this.this$0.getTag();
                String str7 = this.$deviceId;
                ILog.d(access$getTag7, "#" + str7 + " has yet to reply to our version, but we can assume it has arrived.");
                this.this$0.confirmVersionSent(this.$deviceId, num.intValue());
            }
            Function2 function2 = this.$consumerMap.get(num);
            if (function2 != null) {
                function2.invoke(this.$data, this.this$0.getTag());
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                String access$getTag8 = this.this$0.getTag();
                ILog.w(access$getTag8, "Dropping message of unknown version " + num);
            }
            if (!this.this$0.isDeviceNegotiated(this.$deviceId)) {
                this.this$0.startCommunication(this.$deviceId);
            }
        }
    }
}
