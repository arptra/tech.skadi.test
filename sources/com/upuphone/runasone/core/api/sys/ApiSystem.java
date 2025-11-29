package com.upuphone.runasone.core.api.sys;

import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.runasone.device.StarryDevice;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0015"}, d2 = {"Lcom/upuphone/runasone/core/api/sys/ApiSystem;", "", "dial", "", "number", "", "getAudioPlayDevice", "Lcom/upuphone/runasone/device/StarryDevice;", "getCallState", "", "getListBrDevice", "", "operateAction", "type", "action", "registerCallBack", "callBack", "Lcom/upuphone/runasone/core/api/sys/SystemCallBack;", "switchAudioPlayDevice", "device", "unRegisterCallBack", "core-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Hub
public interface ApiSystem {
    void dial(@NotNull String str);

    @Nullable
    StarryDevice getAudioPlayDevice();

    int getCallState();

    @NotNull
    List<StarryDevice> getListBrDevice();

    void operateAction(int i, int i2);

    void registerCallBack(@Callback @NotNull SystemCallBack systemCallBack);

    int switchAudioPlayDevice(@NotNull StarryDevice starryDevice);

    void unRegisterCallBack(@NotNull SystemCallBack systemCallBack);
}
