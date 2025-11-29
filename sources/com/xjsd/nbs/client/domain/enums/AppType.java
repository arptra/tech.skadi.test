package com.xjsd.nbs.client.domain.enums;

public enum AppType {
    SYSTEM("SYSTEM", "系统应用", 1L),
    THIRD("THIRD", "三方应用", 2L);
    
    private final String code;
    private final String desc;
    private final Long index;

    private AppType(String str, String str2, Long l) {
        this.code = str;
        this.desc = str2;
        this.index = l;
    }

    public static AppType getAppType(Long l) {
        if (l == null) {
            return null;
        }
        for (AppType appType : values()) {
            if (l.equals(appType.getIndex())) {
                return appType;
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public Long getIndex() {
        return this.index;
    }
}
