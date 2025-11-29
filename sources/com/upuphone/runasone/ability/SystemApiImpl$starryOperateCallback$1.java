package com.upuphone.runasone.ability;

import com.upuphone.starrynet.api.IStarryOperateCallback;
import com.upuphone.starrynet.api.bean.StDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"com/upuphone/runasone/ability/SystemApiImpl$starryOperateCallback$1", "Lcom/upuphone/starrynet/api/IStarryOperateCallback;", "onBrEdrAudioDeviceChanged", "", "stDevice", "Lcom/upuphone/starrynet/api/bean/StDevice;", "onCallStateChanged", "phoneNum", "", "state", "", "onPullPhoneBookChanged", "core-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SystemApiImpl$starryOperateCallback$1 implements IStarryOperateCallback {
    public void onBrEdrAudioDeviceChanged(@NotNull StDevice stDevice) {
        Intrinsics.checkNotNullParameter(stDevice, "stDevice");
        SystemApiImpl.INSTANCE.activeDeviceChange(stDevice);
    }

    public void onCallStateChanged(@Nullable String str, int i) {
        SystemApiImpl.INSTANCE.callStateChanged(str, i);
    }

    public void onPullPhoneBookChanged(int i) {
        SystemApiImpl.INSTANCE.phoneBookChanged(i);
    }
}
