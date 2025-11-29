package com.upuphone.xr.interconnect.business.messenger;

import com.upuphone.starrynetsdk.ability.relay.RelayListener;
import com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/MessageRxProcessor;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/starrynetsdk/ability/relay/RelayListener;", "peerDeviceStatusManager", "Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;", "(Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;)V", "onRelay", "", "deviceId", "", "uniteCode", "data", "", "onRemoteError", "code", "", "onRemoteStarted", "onRemoteStopped", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MessageRxProcessor extends PetaStepSerializer implements RelayListener {
    /* access modifiers changed from: private */
    @NotNull
    public final PeerDeviceStatusManager peerDeviceStatusManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageRxProcessor(@NotNull PeerDeviceStatusManager peerDeviceStatusManager2) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(peerDeviceStatusManager2, "peerDeviceStatusManager");
        this.peerDeviceStatusManager = peerDeviceStatusManager2;
    }

    public void onRelay(@Nullable String str, @Nullable String str2, @Nullable byte[] bArr) {
        serialize("message rx", new MessageRxProcessor$onRelay$1(this, str, str2, bArr));
    }

    public void onRemoteError(@Nullable String str, @Nullable String str2, int i) {
    }

    public void onRemoteStarted(@Nullable String str, @Nullable String str2) {
    }

    public void onRemoteStopped(@Nullable String str, @Nullable String str2) {
    }
}
