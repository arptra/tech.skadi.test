package io.netty.handler.codec.http.websocketx;

import com.upuphone.ar.translation.statemachine.annotation.MSG;
import io.netty.util.internal.ObjectUtil;

public final class WebSocketCloseStatus implements Comparable<WebSocketCloseStatus> {
    public static final WebSocketCloseStatus ABNORMAL_CLOSURE = new WebSocketCloseStatus(1006, "Abnormal closure", false);
    public static final WebSocketCloseStatus BAD_GATEWAY = new WebSocketCloseStatus(1014, "Bad Gateway");
    public static final WebSocketCloseStatus EMPTY = new WebSocketCloseStatus(1005, "Empty", false);
    public static final WebSocketCloseStatus ENDPOINT_UNAVAILABLE = new WebSocketCloseStatus(1001, "Endpoint unavailable");
    public static final WebSocketCloseStatus INTERNAL_SERVER_ERROR = new WebSocketCloseStatus(1011, "Internal server error");
    public static final WebSocketCloseStatus INVALID_MESSAGE_TYPE = new WebSocketCloseStatus(1003, "Invalid message type");
    public static final WebSocketCloseStatus INVALID_PAYLOAD_DATA = new WebSocketCloseStatus(1007, "Invalid payload data");
    public static final WebSocketCloseStatus MANDATORY_EXTENSION = new WebSocketCloseStatus(1010, "Mandatory extension");
    public static final WebSocketCloseStatus MESSAGE_TOO_BIG = new WebSocketCloseStatus(1009, "Message too big");
    public static final WebSocketCloseStatus NORMAL_CLOSURE = new WebSocketCloseStatus(1000, "Bye");
    public static final WebSocketCloseStatus POLICY_VIOLATION = new WebSocketCloseStatus(1008, "Policy violation");
    public static final WebSocketCloseStatus PROTOCOL_ERROR = new WebSocketCloseStatus(1002, "Protocol error");
    public static final WebSocketCloseStatus SERVICE_RESTART = new WebSocketCloseStatus(MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT, "Service Restart");
    public static final WebSocketCloseStatus TLS_HANDSHAKE_FAILED = new WebSocketCloseStatus(1015, "TLS handshake failed", false);
    public static final WebSocketCloseStatus TRY_AGAIN_LATER = new WebSocketCloseStatus(MSG.MSG_GLASS_SCREEN_STATE, "Try Again Later");
    private final String reasonText;
    private final int statusCode;
    private String text;

    public WebSocketCloseStatus(int i, String str) {
        this(i, str, true);
    }

    public static boolean isValidStatusCode(int i) {
        return i < 0 || (1000 <= i && i <= 1003) || ((1007 <= i && i <= 1014) || 3000 <= i);
    }

    public static WebSocketCloseStatus valueOf(int i) {
        switch (i) {
            case 1000:
                return NORMAL_CLOSURE;
            case 1001:
                return ENDPOINT_UNAVAILABLE;
            case 1002:
                return PROTOCOL_ERROR;
            case 1003:
                return INVALID_MESSAGE_TYPE;
            case 1005:
                return EMPTY;
            case 1006:
                return ABNORMAL_CLOSURE;
            case 1007:
                return INVALID_PAYLOAD_DATA;
            case 1008:
                return POLICY_VIOLATION;
            case 1009:
                return MESSAGE_TOO_BIG;
            case 1010:
                return MANDATORY_EXTENSION;
            case 1011:
                return INTERNAL_SERVER_ERROR;
            case MSG.MSG_TELEPHONE_TRANS_LANGUAGE_NOT_SUPPORT /*1012*/:
                return SERVICE_RESTART;
            case MSG.MSG_GLASS_SCREEN_STATE /*1013*/:
                return TRY_AGAIN_LATER;
            case 1014:
                return BAD_GATEWAY;
            case 1015:
                return TLS_HANDSHAKE_FAILED;
            default:
                return new WebSocketCloseStatus(i, "Close status #" + i);
        }
    }

    public int code() {
        return this.statusCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WebSocketCloseStatus.class != obj.getClass()) {
            return false;
        }
        return this.statusCode == ((WebSocketCloseStatus) obj).statusCode;
    }

    public int hashCode() {
        return this.statusCode;
    }

    public String reasonText() {
        return this.reasonText;
    }

    public String toString() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        String str2 = code() + " " + reasonText();
        this.text = str2;
        return str2;
    }

    public WebSocketCloseStatus(int i, String str, boolean z) {
        if (!z || isValidStatusCode(i)) {
            this.statusCode = i;
            this.reasonText = (String) ObjectUtil.checkNotNull(str, "reasonText");
            return;
        }
        throw new IllegalArgumentException("WebSocket close status code does NOT comply with RFC-6455: " + i);
    }

    public int compareTo(WebSocketCloseStatus webSocketCloseStatus) {
        return code() - webSocketCloseStatus.code();
    }
}
