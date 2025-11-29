package com.xjsd.nbs.client.domain.enums;

public enum DownloadStatus {
    START("START", "开始", 1),
    DOWNLOADING("DOWNLOADING", "下载中", 2),
    PAUSE("PAUSE", "暂停", 3),
    END("END", "结束", 4),
    ERROR("ERROR", "异常", 5);
    
    private final String code;
    private final String desc;
    private final int index;

    private DownloadStatus(String str, String str2, int i) {
        this.code = str;
        this.desc = str2;
        this.index = i;
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
