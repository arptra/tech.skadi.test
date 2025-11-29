package com.upuphone.starrynetsdk.ability.relay;

import com.upuphone.runasone.relay.api.SendRelayMessageCallBack;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/upuphone/starrynetsdk/ability/relay/BypassAbility$sendMessage$1", "Lcom/upuphone/runasone/relay/api/SendRelayMessageCallBack;", "onError", "", "code", "", "msg", "", "onSuccess", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BypassAbility$sendMessage$1 implements SendRelayMessageCallBack {
    final /* synthetic */ BypassSendListener $sendListener;

    public BypassAbility$sendMessage$1(BypassSendListener bypassSendListener) {
        this.$sendListener = bypassSendListener;
    }

    public void onError(int i, @Nullable String str) {
        BypassSendListener bypassSendListener = this.$sendListener;
        if (bypassSendListener != null) {
            bypassSendListener.onFail(i);
        }
    }

    public void onSuccess() {
        BypassSendListener bypassSendListener = this.$sendListener;
        if (bypassSendListener != null) {
            bypassSendListener.onSuccess();
        }
    }
}
