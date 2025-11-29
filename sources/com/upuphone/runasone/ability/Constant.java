package com.upuphone.runasone.ability;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String ABILITY_AIR = "abilityAir";
    public static final String ABILITY_CAST = "abilityCast";
    public static final String ABILITY_HICAR_SINK = "abilityHicarSink";
    public static final String ABILITY_HTTP = "abilityHttp";
    public static final String ABILITY_ICCOA = "abilityIccoa";
    public static final String ABILITY_ICCOASINK = "abilityIccoaSink";
    public static final String ABILITY_ICCOASOURCE = "abilityIccoaSource";
    public static final String ABILITY_MEDIA = "abilityMedia";
    public static final String ABILITY_RELAY = "abilityRelay";
    public static final String ABILITY_RELAY_AUDIO = "abilityRelayAudio";
    public static final String ABILITY_RELAY_BYPASS = "abilityRelayBypass";
    public static final String ABILITY_SHARE = "abilityShare";
    public static final Map<String, Byte> ABILITY_TO_MAPPING;
    public static final byte AIR_MAPPING = 3;
    public static final byte CAST_MAPPING = 4;
    public static final Map<Byte, String> MAPPING_TO_ABILITY;
    public static final byte MEDIA_MAPPING = 8;
    public static final byte RELAY_AUDIO_MAPPING = 6;
    public static final byte RELAY_BYPASS_MAPPING = 2;
    public static final byte RELAY_MAPPING = 1;
    public static final byte SHARE_MAPPING = 5;
    public static final String SYSTEM_API = "systemApi";
    public static final byte SYSTEM_MAPPING = 7;
    public static final String VIRTUAL_DEVICE = "virtualDevice";

    static {
        HashMap hashMap = new HashMap();
        MAPPING_TO_ABILITY = hashMap;
        hashMap.put((byte) 1, "abilityRelay");
        hashMap.put((byte) 2, "abilityRelayBypass");
        hashMap.put((byte) 3, "abilityAir");
        hashMap.put((byte) 4, "abilityCast");
        hashMap.put((byte) 5, "abilityShare");
        hashMap.put((byte) 6, ABILITY_RELAY_AUDIO);
        hashMap.put((byte) 7, "systemApi");
        hashMap.put((byte) 8, ABILITY_MEDIA);
        HashMap hashMap2 = new HashMap();
        ABILITY_TO_MAPPING = hashMap2;
        hashMap2.put("abilityRelay", (byte) 1);
        hashMap2.put("abilityRelayBypass", (byte) 2);
        hashMap2.put("abilityAir", (byte) 3);
        hashMap2.put("abilityCast", (byte) 4);
        hashMap2.put("abilityShare", (byte) 5);
        hashMap2.put(ABILITY_RELAY_AUDIO, (byte) 6);
        hashMap2.put("systemApi", 7);
        hashMap2.put(ABILITY_MEDIA, (byte) 8);
    }
}
