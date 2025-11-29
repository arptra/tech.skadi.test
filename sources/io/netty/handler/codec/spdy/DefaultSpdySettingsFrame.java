package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DefaultSpdySettingsFrame implements SpdySettingsFrame {
    private boolean clear;
    private final Map<Integer, Setting> settingsMap = new TreeMap();

    public static final class Setting {
        private boolean persist;
        private boolean persisted;
        private int value;

        public Setting(int i, boolean z, boolean z2) {
            this.value = i;
            this.persist = z;
            this.persisted = z2;
        }

        public int getValue() {
            return this.value;
        }

        public boolean isPersist() {
            return this.persist;
        }

        public boolean isPersisted() {
            return this.persisted;
        }

        public void setPersist(boolean z) {
            this.persist = z;
        }

        public void setPersisted(boolean z) {
            this.persisted = z;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    private void appendSettings(StringBuilder sb) {
        for (Map.Entry next : getSettings()) {
            Setting setting = (Setting) next.getValue();
            sb.append("--> ");
            sb.append(next.getKey());
            sb.append(':');
            sb.append(setting.getValue());
            sb.append(" (persist value: ");
            sb.append(setting.isPersist());
            sb.append("; persisted: ");
            sb.append(setting.isPersisted());
            sb.append(')');
            sb.append(StringUtil.NEWLINE);
        }
    }

    private Set<Map.Entry<Integer, Setting>> getSettings() {
        return this.settingsMap.entrySet();
    }

    public boolean clearPreviouslyPersistedSettings() {
        return this.clear;
    }

    public int getValue(int i) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        if (setting != null) {
            return setting.getValue();
        }
        return -1;
    }

    public Set<Integer> ids() {
        return this.settingsMap.keySet();
    }

    public boolean isPersistValue(int i) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        return setting != null && setting.isPersist();
    }

    public boolean isPersisted(int i) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        return setting != null && setting.isPersisted();
    }

    public boolean isSet(int i) {
        return this.settingsMap.containsKey(Integer.valueOf(i));
    }

    public SpdySettingsFrame removeValue(int i) {
        this.settingsMap.remove(Integer.valueOf(i));
        return this;
    }

    public SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z) {
        this.clear = z;
        return this;
    }

    public SpdySettingsFrame setPersistValue(int i, boolean z) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        if (setting != null) {
            setting.setPersist(z);
        }
        return this;
    }

    public SpdySettingsFrame setPersisted(int i, boolean z) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i));
        if (setting != null) {
            setting.setPersisted(z);
        }
        return this;
    }

    public SpdySettingsFrame setValue(int i, int i2) {
        return setValue(i, i2, false, false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName((Object) this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        appendSettings(sb);
        sb.setLength(sb.length() - str.length());
        return sb.toString();
    }

    public SpdySettingsFrame setValue(int i, int i2, boolean z, boolean z2) {
        if (i < 0 || i > 16777215) {
            throw new IllegalArgumentException("Setting ID is not valid: " + i);
        }
        Integer valueOf = Integer.valueOf(i);
        Setting setting = this.settingsMap.get(valueOf);
        if (setting != null) {
            setting.setValue(i2);
            setting.setPersist(z);
            setting.setPersisted(z2);
        } else {
            this.settingsMap.put(valueOf, new Setting(i2, z, z2));
        }
        return this;
    }
}
