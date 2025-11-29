package com.upuphone.runasone.channel.bean.auth;

import java.util.concurrent.CopyOnWriteArrayList;

public class AuthBean {
    private CopyOnWriteArrayList<String> ability;
    private AbilityAttributes abilityAttributes;
    private int agreementType;
    private String coreCommit;
    private String deviceId;
    private String deviceName;
    private String session;
    private boolean supportTlv;
    private boolean supportVirtual = false;
    private String version;
    private int weight;

    public CopyOnWriteArrayList<String> getAbility() {
        return this.ability;
    }

    public AbilityAttributes getAbilityAttributes() {
        return this.abilityAttributes;
    }

    public int getAgreementType() {
        return this.agreementType;
    }

    public String getCoreCommit() {
        return this.coreCommit;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getSession() {
        return this.session;
    }

    public String getVersion() {
        return this.version;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean isSupportTlv() {
        return this.supportTlv;
    }

    public void setAbility(CopyOnWriteArrayList<String> copyOnWriteArrayList) {
        this.ability = copyOnWriteArrayList;
    }

    public void setAbilityAttributes(AbilityAttributes abilityAttributes2) {
        this.abilityAttributes = abilityAttributes2;
    }

    public void setAgreementType(int i) {
        this.agreementType = i;
    }

    public void setCoreCommit(String str) {
        this.coreCommit = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public void setSupportTlv(boolean z) {
        this.supportTlv = z;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setWeight(int i) {
        this.weight = i;
    }
}
