package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/AppDataTrackEvent;", "", "()V", "APP_AUDITORY_ASSISTANCE", "", "APP_CLICK", "PAIR_DEVICES", "STANDBY_COMPONENT_CLICK", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AppDataTrackEvent {
    @NotNull
    public static final String APP_AUDITORY_ASSISTANCE = "app_auditory_assistance";
    @NotNull
    public static final String APP_CLICK = "app_click";
    @NotNull
    public static final AppDataTrackEvent INSTANCE = new AppDataTrackEvent();
    @NotNull
    public static final String PAIR_DEVICES = "pair_devices";
    @NotNull
    public static final String STANDBY_COMPONENT_CLICK = "standby";

    private AppDataTrackEvent() {
    }
}
