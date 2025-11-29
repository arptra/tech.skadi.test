package com.xjsd.ai.assistant.cloud;

import androidx.annotation.Keep;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import java.util.List;

@Keep
public class InitCloudParams {
    List<EndToEndServiceData> initData;
    String traceId;

    public List<EndToEndServiceData> getInitData() {
        return this.initData;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setInitData(List<EndToEndServiceData> list) {
        this.initData = list;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
