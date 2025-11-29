package com.upuphone.starrynetsdk.ability.relay;

import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.relay.api.BypassCallback;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.starrynetsdk.ability.relay.BypassAbility;
import com.upuphone.starrynetsdk.api.SNSLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/upuphone/starrynetsdk/ability/relay/BypassAbility$Companion$bypassCallback$1", "Lcom/upuphone/runasone/relay/api/BypassCallback;", "onReceiveMessage", "", "deviceId", "", "serviceUuid", "characterUuid", "msgType", "", "msg", "Lcom/upuphone/runasone/ArrayData;", "relay-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BypassAbility$Companion$bypassCallback$1 implements BypassCallback {
    public void onReceiveMessage(@NotNull String str, @Nullable String str2, @Nullable String str3, int i, @NotNull ArrayData arrayData) {
        BypassListener listener;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(arrayData, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        SNSLog.e("BypassAbility", "onReceiveMessage deviceId=" + str + "  serviceUuid=" + str2 + " characterUuid=" + str3 + ' ' + i + "=msgType");
        BypassAbility.Callback access$getCallback$cp = BypassAbility.callback;
        if (access$getCallback$cp != null && (listener = access$getCallback$cp.getListener()) != null) {
            byte[] data = arrayData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "msg.data");
            listener.onMessage(str, str2, str3, data, i);
        }
    }
}
