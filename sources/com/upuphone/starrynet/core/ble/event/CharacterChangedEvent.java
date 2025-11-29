package com.upuphone.starrynet.core.ble.event;

import java.util.UUID;

public class CharacterChangedEvent {
    private UUID character;
    private String mac;
    private UUID service;
    private byte[] value;

    public CharacterChangedEvent(String str, UUID uuid, UUID uuid2, byte[] bArr) {
        this.mac = str;
        this.service = uuid;
        this.character = uuid2;
        this.value = bArr;
    }

    public UUID getCharacter() {
        return this.character;
    }

    public String getMac() {
        return this.mac;
    }

    public UUID getService() {
        return this.service;
    }

    public byte[] getValue() {
        return this.value;
    }
}
