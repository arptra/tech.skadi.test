package com.upuphone.runasone.ability;

public enum EnumAbility {
    RELAY("abilityRelay"),
    RELAY_BYPASS("abilityRelayBypass"),
    RELAY_AIR("abilityAir"),
    CAST("abilityCast"),
    SHARE("abilityShare"),
    RELAY_AUDIO(Constant.ABILITY_RELAY_AUDIO),
    SYSTEM_API("systemApi"),
    VIRTUAL_DEVICE("virtualDevice"),
    MEDIA(Constant.ABILITY_MEDIA),
    HTTP(Constant.ABILITY_HTTP),
    ICCOA("abilityIccoa"),
    ICCOASOURCE(Constant.ABILITY_ICCOASOURCE),
    ICCOASINK(Constant.ABILITY_ICCOASINK),
    HICARSINK(Constant.ABILITY_HICAR_SINK);
    
    private String name;

    private EnumAbility(String str) {
        this.name = str;
    }

    public static EnumAbility parse(String str) {
        for (EnumAbility enumAbility : values()) {
            if (enumAbility.name.equalsIgnoreCase(str)) {
                return enumAbility;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
