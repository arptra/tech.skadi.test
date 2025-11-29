package com.xjsd.ai.assistant.protocol;

import com.alibaba.fastjson.JSONObject;
import com.xjsd.ai.assistant.core.bean.SessionData;
import com.xjsd.ai.assistant.protocol.vui.Header;
import com.xjsd.ai.assistant.protocol.vui.MetaData;
import com.xjsd.ai.assistant.protocol.vui.Utterance;

public class VuiModel extends SessionData {
    private Header header;
    private MetaData metadata;
    private JSONObject payload;
    private int source = 0;
    private Utterance utterance;

    public Header getHeader() {
        return this.header;
    }

    public MetaData getMetadata() {
        return this.metadata;
    }

    public JSONObject getPayload() {
        return this.payload;
    }

    public int getSource() {
        return this.source;
    }

    public Utterance getUtterance() {
        return this.utterance;
    }

    public boolean isFreeChat() {
        Header header2 = this.header;
        return header2 != null && VuiModelType.FREE_CHAT.equals(header2.getName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = r2.payload;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isReject() {
        /*
            r2 = this;
            com.xjsd.ai.assistant.protocol.vui.Header r0 = r2.header
            if (r0 == 0) goto L_0x0029
            java.lang.String r1 = "error"
            java.lang.String r0 = r0.getNamespace()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0029
            com.alibaba.fastjson.JSONObject r0 = r2.payload
            if (r0 == 0) goto L_0x0029
            java.lang.String r1 = "code"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0029
            com.alibaba.fastjson.JSONObject r2 = r2.payload
            int r2 = r2.getIntValue(r1)
            r0 = 5001(0x1389, float:7.008E-42)
            if (r2 == r0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r2 = 1
            return r2
        L_0x0029:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjsd.ai.assistant.protocol.VuiModel.isReject():boolean");
    }

    public void setHeader(Header header2) {
        this.header = header2;
    }

    public void setMetadata(MetaData metaData) {
        this.metadata = metaData;
    }

    public void setPayload(JSONObject jSONObject) {
        this.payload = jSONObject;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setUtterance(Utterance utterance2) {
        this.utterance = utterance2;
    }

    public String toString() {
        return "VuiModel{header=" + this.header + ", metadata=" + this.metadata + ", utterance=" + this.utterance + ", payload=" + this.payload + ", source=" + this.source + '}';
    }
}
