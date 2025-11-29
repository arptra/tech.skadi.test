package com.flyme.xjfms.ums.sign.jdk.enums;

import java.util.HashMap;
import java.util.Map;

public enum SignVersionEnum {
    MD5("1", "mdb5"),
    HMACSHA256("2", "HmacSHA256");
    
    private static Map<String, SignVersionEnum> codeLookUp;
    private final String code;
    private final String name;

    static {
        int i;
        codeLookUp = new HashMap();
        for (SignVersionEnum signVersionEnum : values()) {
            codeLookUp.put(signVersionEnum.code, signVersionEnum);
        }
    }

    private SignVersionEnum(String str, String str2) {
        this.code = str;
        this.name = str2;
    }

    public static SignVersionEnum findByValue(String str) {
        return codeLookUp.get(str);
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
