package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassResponseCode;", "", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public interface GlassResponseCode {
    public static final int CODE_FAIL = 1;
    public static final int CODE_ILLEGAL_ARGUMENT = 2;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED = 4;
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassResponseCode$Companion;", "", "()V", "CODE_FAIL", "", "CODE_ILLEGAL_ARGUMENT", "CODE_SUCCESS", "CODE_UNSUPPORTED", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CODE_FAIL = 1;
        public static final int CODE_ILLEGAL_ARGUMENT = 2;
        public static final int CODE_SUCCESS = 0;
        public static final int CODE_UNSUPPORTED = 4;

        private Companion() {
        }
    }
}
