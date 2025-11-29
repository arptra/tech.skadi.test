package com.xjsd.ai.assistant.protocol.stks;

import com.xjsd.ai.assistant.stks.dto.STKSDto;
import java.util.List;

public class StksHotWordTransInfo {
    private List<STKSDto> data;
    private String packageName;

    public List<STKSDto> getData() {
        return this.data;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setData(List<STKSDto> list) {
        this.data = list;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
