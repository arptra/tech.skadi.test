package com.xjsd.ai.assistant.connect;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.xjsd.ai.assistant.annotation.AbilityKey;
import com.xjsd.ai.assistant.core.Ability;

@AbilityKey("interconnect")
public interface InterconnectAbility extends Ability {
    Boolean bluetoothScoState();

    OperatorManager getOperatorManager();

    void init(Context context, @Nullable String str, @InitModel int i);

    /* bridge */ /* synthetic */ boolean isProxyInstance() {
        return super.isProxyInstance();
    }

    /* bridge */ /* synthetic */ void register() {
        super.register();
    }

    void registerOnDeviceStateChangeListener(@NonNull OnDeviceStateChangeListener onDeviceStateChangeListener);

    void registerOnReceiveRemoteMsgListener(@NonNull OnReceiveRemoteMsgListener onReceiveRemoteMsgListener);

    void send(@NonNull StarryNetMessage starryNetMessage, @Nullable SendMsgCallback sendMsgCallback);

    void send(@NonNull String str, @Nullable SendMsgCallback sendMsgCallback);

    void send(@NonNull byte[] bArr, @Nullable SendMsgCallback sendMsgCallback);

    void unregisterOnDeviceStateChangeListener(@NonNull OnDeviceStateChangeListener onDeviceStateChangeListener);

    void unregisterOnReceiveRemoteMsgListener(@NonNull OnReceiveRemoteMsgListener onReceiveRemoteMsgListener);
}
