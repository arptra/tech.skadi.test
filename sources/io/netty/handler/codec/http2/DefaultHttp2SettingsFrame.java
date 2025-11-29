package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class DefaultHttp2SettingsFrame implements Http2SettingsFrame {
    private final Http2Settings settings;

    public DefaultHttp2SettingsFrame(Http2Settings http2Settings) {
        this.settings = (Http2Settings) ObjectUtil.checkNotNull(http2Settings, "settings");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2SettingsFrame)) {
            return false;
        }
        return this.settings.equals(((Http2SettingsFrame) obj).settings());
    }

    public int hashCode() {
        return this.settings.hashCode();
    }

    public String name() {
        return "SETTINGS";
    }

    public Http2Settings settings() {
        return this.settings;
    }

    public String toString() {
        return StringUtil.simpleClassName((Object) this) + "(settings=" + this.settings + ')';
    }
}
