package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PayloadLoggingKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MessageRxProcessor$onRelay$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $uniteCode;
    final /* synthetic */ MessageRxProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageRxProcessor$onRelay$1(MessageRxProcessor messageRxProcessor, String str, String str2, byte[] bArr) {
        super(0);
        this.this$0 = messageRxProcessor;
        this.$deviceId = str;
        this.$uniteCode = str2;
        this.$data = bArr;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        String str = this.$deviceId;
        String str2 = this.$uniteCode;
        byte[] bArr = this.$data;
        String samplePrint = bArr != null ? PayloadLoggingKt.samplePrint(bArr) : null;
        ILog.d(access$getTag, "Parsing message from " + str + "/" + str2 + ": " + samplePrint + ".");
        if (this.$deviceId != null && this.$data != null) {
            boolean isAirPro = InterconnectManager.getInstance().getStarryNetDeviceInfoManager().isAirPro();
            String access$getTag2 = this.this$0.getTag();
            ILog.w(access$getTag2, "onRelay handleMessage isPro = " + isAirPro);
            this.this$0.peerDeviceStatusManager.handleMessage(this.$deviceId, this.$uniteCode, this.$data, isAirPro ? MessageRxProcessorKt.messageConsumerMapFroPro : MessageRxProcessorKt.messageConsumerMap);
        }
    }
}
