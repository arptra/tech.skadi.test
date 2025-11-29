package com.xjsd.ai.assistant.protocol.call;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public class PhoneBusinessData {
    public static final int CALL_BLUETOOTH = 6;
    public static final int CALL_FAIL = 5;
    public static final int PHONE_CONTACT_LIST = 1;
    public static final int PHONE_NUMBER_LIST = 2;
    public static final int PHONE_SIM_LIST = 3;
    public static final int REPLY_PHONE_CALL = 4;
    private String cardType;
    private String contactName;
    private List<ContactSingleInfo> contactSingleInfo;
    private String failType;
    private boolean isMultipleWheel;
    private String phoneNumber;
    private List<SimCardBean> simCardBean;
    private int type;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface PhoneBusinessType {
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getContactName() {
        return this.contactName;
    }

    public List<ContactSingleInfo> getContactSingleInfo() {
        return this.contactSingleInfo;
    }

    public String getFailType() {
        return this.failType;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public List<SimCardBean> getSimCardBean() {
        return this.simCardBean;
    }

    public int getType() {
        return this.type;
    }

    public boolean isMultipleWheel() {
        return this.isMultipleWheel;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setContactName(String str) {
        this.contactName = str;
    }

    public void setContactSingleInfo(List<ContactSingleInfo> list) {
        this.contactSingleInfo = list;
    }

    public void setFailType(String str) {
        this.failType = str;
    }

    public void setMultipleWheel(boolean z) {
        this.isMultipleWheel = z;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setSimCardBean(List<SimCardBean> list) {
        this.simCardBean = list;
    }

    public void setType(int i) {
        this.type = i;
    }
}
