package com.xjsd.nbs.client.domain.enums;

import com.upuphone.xr.sapp.monitor.starry.cmd.CmdAction;

public enum DownloadOperate {
    START("START", "开始", 1),
    PAUSE("PAUSE", "暂停", 2),
    CONTINUE("CONTINUE", "继续", 3),
    CANCEL(CmdAction.CMD_DIALOG_CANCEL, "取消", 4);
    
    private final String code;
    private final String desc;
    private final int index;

    private DownloadOperate(String str, String str2, int i) {
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
