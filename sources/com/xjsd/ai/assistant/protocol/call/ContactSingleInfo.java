package com.xjsd.ai.assistant.protocol.call;

import java.io.Serializable;

public class ContactSingleInfo implements Serializable {
    private String company;
    private String contactId;
    private String lookup;
    private String name;
    private String phoneNumber;

    public String getCompany() {
        return this.company;
    }

    public String getContactId() {
        return this.contactId;
    }

    public String getLookup() {
        return this.lookup;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setCompany(String str) {
        this.company = str;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public void setLookup(String str) {
        this.lookup = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }
}
