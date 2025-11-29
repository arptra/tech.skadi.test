package com.xjsd.ai.assistant.skill.call.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactBean implements Serializable {
    private String company;
    private String contactId;
    private String lookup;
    private List<PhoneNumberBean> mPhoneNumberBean;
    private String name;

    public ContactBean() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ContactBean) && !TextUtils.isEmpty(this.contactId)) {
            String str = ((ContactBean) obj).contactId;
            if (!TextUtils.isEmpty(str) && this.contactId.equals(str)) {
                return true;
            }
        }
        return super.equals(obj);
    }

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

    public List<PhoneNumberBean> getPhoneNumber() {
        return this.mPhoneNumberBean;
    }

    public int hashCode() {
        String str = this.contactId;
        return str != null ? str.hashCode() : super.hashCode();
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

    public void setPhoneNumber(List<PhoneNumberBean> list) {
        this.mPhoneNumberBean = list;
    }

    public String toString() {
        return "Contact{name='" + this.name + '\'' + ", phoneNumber=" + this.mPhoneNumberBean + ", company='" + this.company + '\'' + ", lookup='" + this.lookup + '\'' + ", contactId='" + this.contactId + '\'' + '}';
    }

    public ContactBean(ContactBean contactBean) {
        this.name = contactBean.name;
        this.company = contactBean.company;
        this.lookup = contactBean.lookup;
        this.contactId = contactBean.contactId;
        this.mPhoneNumberBean = new ArrayList(contactBean.mPhoneNumberBean);
    }
}
