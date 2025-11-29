package com.xjsd.nbs.client.domain.enums;

public enum CategoryLevel {
    FIRST("FIRST", "一级分类", 1),
    SECOND("SECOND", "二级分类", 2),
    THIRD("THIRD", "三级分类", 3);
    
    private final String code;
    private final String desc;
    private final int index;

    private CategoryLevel(String str, String str2, int i) {
        this.code = str;
        this.desc = str2;
        this.index = i;
    }

    public static CategoryLevel matchIndex(int i) {
        for (CategoryLevel categoryLevel : values()) {
            if (categoryLevel.getIndex() == i) {
                return categoryLevel;
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

    public int getIndex() {
        return this.index;
    }
}
