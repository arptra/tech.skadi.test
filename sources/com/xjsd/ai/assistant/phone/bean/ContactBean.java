package com.xjsd.ai.assistant.phone.bean;

public class ContactBean {
    private String firstName;
    private String fullName;
    private String id;
    private String lastName;
    private String middleName;
    private String nickName;

    public String getFirstName() {
        return this.firstName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setMiddleName(String str) {
        this.middleName = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String toString() {
        return "ContactDto{id='" + this.id + '\'' + ", fullName='" + this.fullName + '\'' + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", middleName='" + this.middleName + '\'' + ", nickName='" + this.nickName + '\'' + '}';
    }
}
