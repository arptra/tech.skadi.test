package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassScreenShotErrorCode;", "", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
public @interface GlassScreenShotErrorCode {
    public static final int CODE_ERROR_OTHER = 999;
    public static final int CODE_GLASS_DISCONNECT = -1;
    public static final int CODE_GLASS_LOW_MEM = 203;
    public static final int CODE_GLASS_SCENCE_ERROR = 202;
    public static final int CODE_GLASS_SCREEN_OFF = 201;
    public static final int CODE_GLASS_SHOOTING = 204;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_TRANSFER_START_SUCCESS = 200;
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassScreenShotErrorCode$Companion;", "", "()V", "CODE_ERROR_OTHER", "", "CODE_GLASS_DISCONNECT", "CODE_GLASS_LOW_MEM", "CODE_GLASS_SCENCE_ERROR", "CODE_GLASS_SCREEN_OFF", "CODE_GLASS_SHOOTING", "CODE_SUCCESS", "CODE_TRANSFER_START_SUCCESS", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CODE_ERROR_OTHER = 999;
        public static final int CODE_GLASS_DISCONNECT = -1;
        public static final int CODE_GLASS_LOW_MEM = 203;
        public static final int CODE_GLASS_SCENCE_ERROR = 202;
        public static final int CODE_GLASS_SCREEN_OFF = 201;
        public static final int CODE_GLASS_SHOOTING = 204;
        public static final int CODE_SUCCESS = 0;
        public static final int CODE_TRANSFER_START_SUCCESS = 200;

        private Companion() {
        }
    }
}
