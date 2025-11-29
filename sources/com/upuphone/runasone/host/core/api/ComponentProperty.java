package com.upuphone.runasone.host.core.api;

public class ComponentProperty {
    private int agreementType;
    private String commitInfo;
    private String json;
    private boolean supportTlv;
    private String version;

    public int getAgreementType() {
        return this.agreementType;
    }

    public String getCommitInfo() {
        return this.commitInfo;
    }

    public String getJson() {
        return this.json;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isSupportTlv() {
        return this.supportTlv;
    }

    public void setAgreementType(int i) {
        this.agreementType = i;
    }

    public void setCommitInfo(String str) {
        this.commitInfo = str;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public void setSupportTlv(boolean z) {
        this.supportTlv = z;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
