package com.upuphone.starrynetsdk.ability.audio;

import com.upuphone.hub.Hub;
import com.upuphone.runasone.core.api.sys.ApiSystemProxy;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/upuphone/starrynetsdk/ability/audio/BaseAudioAbility;", "Lcom/upuphone/starrynetsdk/api/Ability;", "()V", "api", "Lcom/upuphone/runasone/core/api/sys/ApiSystemProxy;", "getApi", "()Lcom/upuphone/runasone/core/api/sys/ApiSystemProxy;", "listenerManager", "Lcom/upuphone/starrynetsdk/ability/audio/AudioListenerManager;", "getListenerManager", "()Lcom/upuphone/starrynetsdk/ability/audio/AudioListenerManager;", "onInstalled", "", "hub", "Lcom/upuphone/hub/Hub;", "core-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseAudioAbility extends Ability {
    @NotNull
    private final ApiSystemProxy api = new ApiSystemProxy();
    @NotNull
    private final AudioListenerManager listenerManager;

    public BaseAudioAbility() {
        AudioListenerManager instance = AudioListenerManager.getInstance();
        Intrinsics.checkNotNull(instance);
        this.listenerManager = instance;
        Camp.getInstance().addSentry(this);
    }

    @NotNull
    public final ApiSystemProxy getApi() {
        return this.api;
    }

    @NotNull
    public final AudioListenerManager getListenerManager() {
        return this.listenerManager;
    }

    public void onInstalled(@NotNull Hub hub) {
        Intrinsics.checkNotNullParameter(hub, "hub");
        super.onInstalled(hub);
        this.api.setHub(hub);
    }
}
