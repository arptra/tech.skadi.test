package com.upuphone.xr.sapp.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;

@Keep
public class ConfigDataBean implements Parcelable {
    public static final Parcelable.Creator<ConfigDataBean> CREATOR = new Parcelable.Creator<ConfigDataBean>() {
        public ConfigDataBean createFromParcel(Parcel parcel) {
            return new ConfigDataBean(parcel);
        }

        public ConfigDataBean[] newArray(int i) {
            return new ConfigDataBean[i];
        }
    };
    private ArrayList<ConfigCategoryBean> attributeCategoryConfigList;
    private int attributeCategoryStatus;
    private String attributeCategoryTitle;
    private String autoReplyContent;
    private String buttonDesc;
    private int contactStatus;
    private String contactTips;
    private String contactTitle;
    private String contentTips;
    private String contentTitle;
    private String feedBackPageId;
    private int happenTimeStatus;
    private String pageTitle;
    private ArrayList<ConfigCategoryBean> questionCategoryConfigList;
    private String questionCategoryTitle;
    private int uploadSwitch;

    public ConfigDataBean(Parcel parcel) {
        this.feedBackPageId = parcel.readString();
        this.pageTitle = parcel.readString();
        this.questionCategoryTitle = parcel.readString();
        this.contentTitle = parcel.readString();
        this.contentTips = parcel.readString();
        this.contactStatus = parcel.readInt();
        this.contactTitle = parcel.readString();
        this.contactTips = parcel.readString();
        this.attributeCategoryStatus = parcel.readInt();
        this.attributeCategoryTitle = parcel.readString();
        this.uploadSwitch = parcel.readInt();
        this.happenTimeStatus = parcel.readInt();
        this.buttonDesc = parcel.readString();
        this.autoReplyContent = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<ConfigCategoryBean> getAttributeCategoryConfigList() {
        return this.attributeCategoryConfigList;
    }

    public int getAttributeCategoryStatus() {
        return this.attributeCategoryStatus;
    }

    public String getAttributeCategoryTitle() {
        return this.attributeCategoryTitle;
    }

    public String getAutoReplyContent() {
        return this.autoReplyContent;
    }

    public String getButtonDesc() {
        return this.buttonDesc;
    }

    public int getContactStatus() {
        return this.contactStatus;
    }

    public String getContactTips() {
        return this.contactTips;
    }

    public String getContactTitle() {
        return this.contactTitle;
    }

    public String getContentTips() {
        return this.contentTips;
    }

    public String getContentTitle() {
        return this.contentTitle;
    }

    public String getFeedBackPageId() {
        return this.feedBackPageId;
    }

    public int getHappenTimeStatus() {
        return this.happenTimeStatus;
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public ArrayList<ConfigCategoryBean> getQuestionCategoryConfigList() {
        return this.questionCategoryConfigList;
    }

    public String getQuestionCategoryTitle() {
        return this.questionCategoryTitle;
    }

    public int getUploadSwitch() {
        return this.uploadSwitch;
    }

    public void setAttributeCategoryConfigList(ArrayList<ConfigCategoryBean> arrayList) {
        this.attributeCategoryConfigList = arrayList;
    }

    public void setAttributeCategoryStatus(int i) {
        this.attributeCategoryStatus = i;
    }

    public void setAttributeCategoryTitle(String str) {
        this.attributeCategoryTitle = str;
    }

    public void setAutoReplyContent(String str) {
        this.autoReplyContent = str;
    }

    public void setButtonDesc(String str) {
        this.buttonDesc = str;
    }

    public void setContactStatus(int i) {
        this.contactStatus = i;
    }

    public void setContactTips(String str) {
        this.contactTips = str;
    }

    public void setContactTitle(String str) {
        this.contactTitle = str;
    }

    public void setContentTips(String str) {
        this.contentTips = str;
    }

    public void setContentTitle(String str) {
        this.contentTitle = str;
    }

    public void setFeedBackPageId(String str) {
        this.feedBackPageId = str;
    }

    public void setHappenTimeStatus(int i) {
        this.happenTimeStatus = i;
    }

    public void setPageTitle(String str) {
        this.pageTitle = str;
    }

    public void setQuestionCategoryConfigList(ArrayList<ConfigCategoryBean> arrayList) {
        this.questionCategoryConfigList = arrayList;
    }

    public void setQuestionCategoryTitle(String str) {
        this.questionCategoryTitle = str;
    }

    public void setUploadSwitch(int i) {
        this.uploadSwitch = i;
    }

    public String toString() {
        return "ConfigDataBean{feedBackPageId='" + this.feedBackPageId + '\'' + ", pageTitle='" + this.pageTitle + '\'' + ", questionCategoryTitle='" + this.questionCategoryTitle + '\'' + ", questionCategoryConfigList=" + this.questionCategoryConfigList + ", contentTitle='" + this.contentTitle + '\'' + ", contentTips='" + this.contentTips + '\'' + ", contactStatus=" + this.contactStatus + ", contactTitle='" + this.contactTitle + '\'' + ", contactTips='" + this.contactTips + '\'' + ", attributeCategoryStatus=" + this.attributeCategoryStatus + ", attributeCategoryTitle='" + this.attributeCategoryTitle + '\'' + ", attributeCategoryConfigList=" + this.attributeCategoryConfigList + ", uploadSwitch=" + this.uploadSwitch + ", happenTimeStatus=" + this.happenTimeStatus + ", buttonDesc='" + this.buttonDesc + '\'' + ", autoReplyContent='" + this.autoReplyContent + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.feedBackPageId);
        parcel.writeString(this.pageTitle);
        parcel.writeString(this.questionCategoryTitle);
        parcel.writeString(this.contentTitle);
        parcel.writeString(this.contentTips);
        parcel.writeInt(this.contactStatus);
        parcel.writeString(this.contactTitle);
        parcel.writeString(this.contactTips);
        parcel.writeInt(this.attributeCategoryStatus);
        parcel.writeString(this.attributeCategoryTitle);
        parcel.writeInt(this.uploadSwitch);
        parcel.writeInt(this.happenTimeStatus);
        parcel.writeString(this.buttonDesc);
        parcel.writeString(this.autoReplyContent);
    }
}
