package com.upuphone.runasone.relay.api;

import com.upuphone.hub.annotation.Hub;
import com.upuphone.hub.annotation.Parcelable;
import com.upuphone.runasone.ArrayData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/upuphone/runasone/relay/api/BypassCallback;", "", "onReceiveMessage", "", "deviceId", "", "serviceUuid", "characterUuid", "msgType", "", "msg", "Lcom/upuphone/runasone/ArrayData;", "relay-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Hub
public interface BypassCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onReceiveMessage$default(BypassCallback bypassCallback, String str, String str2, String str3, int i, ArrayData arrayData, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i = 0;
                }
                bypassCallback.onReceiveMessage(str, str2, str3, i, arrayData);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onReceiveMessage");
        }
    }

    void onReceiveMessage(@NotNull String str, @Nullable String str2, @Nullable String str3, int i, @NotNull @Parcelable ArrayData arrayData);
}
