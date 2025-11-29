package com.upuphone.starrynet.core.ble.channel;

import com.upuphone.starrynet.core.ble.utils.UUIDUtils;
import java.util.UUID;

public class ChannelTag {
    private String bleMac;
    private UUID character;

    public ChannelTag(String str, UUID uuid) {
        this.bleMac = str;
        this.character = uuid;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelTag)) {
            return false;
        }
        ChannelTag channelTag = (ChannelTag) obj;
        if (!this.bleMac.equals(channelTag.bleMac)) {
            return false;
        }
        return this.character.equals(channelTag.character);
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public UUID getCharacter() {
        return this.character;
    }

    public int hashCode() {
        return (this.bleMac.hashCode() * 31) + this.character.hashCode();
    }

    public String toString() {
        return "ChannelTag{bleMac='" + this.bleMac + '\'' + ", character=" + UUIDUtils.getShortUUID(this.character) + '}';
    }
}
