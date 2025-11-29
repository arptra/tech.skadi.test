package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateErrorCode;", "", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
public @interface GlassUpdateErrorCode {
    public static final int CODE_ENABLE_P2P_FAIL = 113;
    public static final int CODE_GLASS_IS_UPDATING = 1;
    public static final int CODE_GLASS_LOW_POWER = 105;
    public static final int CODE_GLASS_LOW_STORAGE = 106;
    public static final int CODE_GLASS_NOT_CONNECTED = 101;
    public static final int CODE_SEND_MSG_FAIL = 115;
    public static final int CODE_SEND_MSG_GET_GLASS_INFO_FAIL = 103;
    public static final int CODE_SEND_MSG_GET_GLASS_INFO_TIMEOUT = 104;
    public static final int CODE_SEND_MSG_OPEN_GLASS_OTA_FAIL = 110;
    public static final int CODE_SEND_MSG_OPEN_GLASS_OTA_TIMEOUT = 111;
    public static final int CODE_SEND_MSG_SHOW_UPDATE_DIALOG_ON_GLASS_FAIL = 107;
    public static final int CODE_SEND_MSG_SHOW_UPDATE_DIALOG_ON_GLASS_TIMEOUT = 108;
    public static final int CODE_SEND_MSG_TIMEOUT = 116;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_TRANSFER_DISCONNECTED_BLUETOOTH_OFF = 120;
    public static final int CODE_TRANSFER_DISCONNECTED_CONNECT_TIMEOUT = 121;
    public static final int CODE_TRANSFER_DISCONNECTED_DISCONNECT_BY_GLASS = 122;
    public static final int CODE_TRANSFER_DISCONNECTED_DISCONNECT_BY_PHONE = 123;
    public static final int CODE_TRANSFER_DISCONNECTED_WITH_REASON = 124;
    public static final int CODE_TRANSFER_FAIL = 114;
    public static final int CODE_UPDATE_FILE_NOT_EXIST = 109;
    public static final int CODE_WRONG_UPDATE_INFO = 112;
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateErrorCode$Companion;", "", "()V", "CODE_ENABLE_P2P_FAIL", "", "CODE_GLASS_IS_UPDATING", "CODE_GLASS_LOW_POWER", "CODE_GLASS_LOW_STORAGE", "CODE_GLASS_NOT_CONNECTED", "CODE_SEND_MSG_FAIL", "CODE_SEND_MSG_GET_GLASS_INFO_FAIL", "CODE_SEND_MSG_GET_GLASS_INFO_TIMEOUT", "CODE_SEND_MSG_OPEN_GLASS_OTA_FAIL", "CODE_SEND_MSG_OPEN_GLASS_OTA_TIMEOUT", "CODE_SEND_MSG_SHOW_UPDATE_DIALOG_ON_GLASS_FAIL", "CODE_SEND_MSG_SHOW_UPDATE_DIALOG_ON_GLASS_TIMEOUT", "CODE_SEND_MSG_TIMEOUT", "CODE_SUCCESS", "CODE_TRANSFER_DISCONNECTED_BLUETOOTH_OFF", "CODE_TRANSFER_DISCONNECTED_CONNECT_TIMEOUT", "CODE_TRANSFER_DISCONNECTED_DISCONNECT_BY_GLASS", "CODE_TRANSFER_DISCONNECTED_DISCONNECT_BY_PHONE", "CODE_TRANSFER_DISCONNECTED_WITH_REASON", "CODE_TRANSFER_FAIL", "CODE_UPDATE_FILE_NOT_EXIST", "CODE_WRONG_UPDATE_INFO", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CODE_ENABLE_P2P_FAIL = 113;
        public static final int CODE_GLASS_IS_UPDATING = 1;
        public static final int CODE_GLASS_LOW_POWER = 105;
        public static final int CODE_GLASS_LOW_STORAGE = 106;
        public static final int CODE_GLASS_NOT_CONNECTED = 101;
        public static final int CODE_SEND_MSG_FAIL = 115;
        public static final int CODE_SEND_MSG_GET_GLASS_INFO_FAIL = 103;
        public static final int CODE_SEND_MSG_GET_GLASS_INFO_TIMEOUT = 104;
        public static final int CODE_SEND_MSG_OPEN_GLASS_OTA_FAIL = 110;
        public static final int CODE_SEND_MSG_OPEN_GLASS_OTA_TIMEOUT = 111;
        public static final int CODE_SEND_MSG_SHOW_UPDATE_DIALOG_ON_GLASS_FAIL = 107;
        public static final int CODE_SEND_MSG_SHOW_UPDATE_DIALOG_ON_GLASS_TIMEOUT = 108;
        public static final int CODE_SEND_MSG_TIMEOUT = 116;
        public static final int CODE_SUCCESS = 0;
        public static final int CODE_TRANSFER_DISCONNECTED_BLUETOOTH_OFF = 120;
        public static final int CODE_TRANSFER_DISCONNECTED_CONNECT_TIMEOUT = 121;
        public static final int CODE_TRANSFER_DISCONNECTED_DISCONNECT_BY_GLASS = 122;
        public static final int CODE_TRANSFER_DISCONNECTED_DISCONNECT_BY_PHONE = 123;
        public static final int CODE_TRANSFER_DISCONNECTED_WITH_REASON = 124;
        public static final int CODE_TRANSFER_FAIL = 114;
        public static final int CODE_UPDATE_FILE_NOT_EXIST = 109;
        public static final int CODE_WRONG_UPDATE_INFO = 112;

        private Companion() {
        }
    }
}
