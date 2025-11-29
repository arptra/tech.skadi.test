package com.upuphone.runasone.relay.api;

import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.ArrayData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J*\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\nH&J>\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0011H&J\"\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\nH&J*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\nH&¨\u0006\u0014"}, d2 = {"Lcom/upuphone/runasone/relay/api/ApiRelayBypassMsg;", "", "removeRelayListener", "", "serviceUuid", "", "characterUuid", "removeRelayListenerByCallback", "callBackTag", "callBack", "Lcom/upuphone/runasone/relay/api/BypassCallback;", "sendMessage", "deviceId", "msgType", "", "msg", "Lcom/upuphone/runasone/ArrayData;", "Lcom/upuphone/runasone/relay/api/SendRelayMessageCallBack;", "setRelayListener", "setRelayListenerByCallback", "relay-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Hub
public interface ApiRelayBypassMsg {
    void removeRelayListener(@NotNull String str, @NotNull String str2);

    void removeRelayListenerByCallback(@NotNull String str, @NotNull String str2, @NotNull String str3, @Callback @NotNull BypassCallback bypassCallback);

    void sendMessage(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull @Parcelable ArrayData arrayData, @Callback @Nullable SendRelayMessageCallBack sendRelayMessageCallBack);

    void setRelayListener(@NotNull String str, @NotNull String str2, @Callback @NotNull BypassCallback bypassCallback);

    void setRelayListenerByCallback(@NotNull String str, @NotNull String str2, @NotNull String str3, @Callback @NotNull BypassCallback bypassCallback);
}
