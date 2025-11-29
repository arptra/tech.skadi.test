package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class AccountInfo implements Parcelable {
    public static final Parcelable.Creator<AccountInfo> CREATOR = new Parcelable.Creator<AccountInfo>() {
        public AccountInfo createFromParcel(Parcel parcel) {
            return new AccountInfo(parcel);
        }

        public AccountInfo[] newArray(int i) {
            return new AccountInfo[i];
        }
    };
    public String backgroundColor;
    public String backgroundImage;
    public String bakIcon;
    public int code;
    public Boolean defaultIcon;
    public String email;

    /* renamed from: flyme  reason: collision with root package name */
    public String f6570flyme;
    public String icon;
    public String id;
    public int indexStatus;
    public String message;
    public String mzUid;
    public String nickname;
    public String phone;
    public String qmImage;
    public Boolean qmStatus;

    public AccountInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    public String getBakIcon() {
        return this.bakIcon;
    }

    public int getCode() {
        return this.code;
    }

    public Boolean getDefaultIcon() {
        return this.defaultIcon;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFlyme() {
        return this.f6570flyme;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public int getIndexStatus() {
        return this.indexStatus;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMzUid() {
        return this.mzUid;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getQmImage() {
        return this.qmImage;
    }

    public Boolean getQmStatus() {
        return this.qmStatus;
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readString();
        this.mzUid = parcel.readString();
        this.backgroundColor = parcel.readString();
        this.backgroundImage = parcel.readString();
        this.bakIcon = parcel.readString();
        this.email = parcel.readString();
        this.f6570flyme = parcel.readString();
        this.icon = parcel.readString();
        this.message = parcel.readString();
        this.nickname = parcel.readString();
        this.phone = parcel.readString();
        this.qmImage = parcel.readString();
        this.defaultIcon = Boolean.valueOf(parcel.readBoolean());
        this.qmStatus = Boolean.valueOf(parcel.readBoolean());
        this.indexStatus = parcel.readInt();
        this.code = parcel.readInt();
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public void setBackgroundImage(String str) {
        this.backgroundImage = str;
    }

    public void setBakIcon(String str) {
        this.bakIcon = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setDefaultIcon(Boolean bool) {
        this.defaultIcon = bool;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFlyme(String str) {
        this.f6570flyme = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIndexStatus(int i) {
        this.indexStatus = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMzUid(String str) {
        this.mzUid = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setQmImage(String str) {
        this.qmImage = str;
    }

    public void setQmStatus(Boolean bool) {
        this.qmStatus = bool;
    }

    public String toString() {
        return "AccountInfo{id='" + this.id + '\'' + ", mzUid='" + this.mzUid + '\'' + ", backgroundColor='" + this.backgroundColor + '\'' + ", backgroundImage='" + this.backgroundImage + '\'' + ", bakIcon='" + this.bakIcon + '\'' + ", email='" + this.email + '\'' + ", flyme='" + this.f6570flyme + '\'' + ", icon='" + this.icon + '\'' + ", message='" + this.message + '\'' + ", nickname='" + this.nickname + '\'' + ", phone='" + this.phone + '\'' + ", qmImage='" + this.qmImage + '\'' + ", defaultIcon=" + this.defaultIcon + ", qmStatus=" + this.qmStatus + ", indexStatus=" + this.indexStatus + ", code=" + this.code + '}';
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.mzUid);
        parcel.writeString(this.backgroundColor);
        parcel.writeString(this.backgroundImage);
        parcel.writeString(this.bakIcon);
        parcel.writeString(this.email);
        parcel.writeString(this.f6570flyme);
        parcel.writeString(this.icon);
        parcel.writeString(this.message);
        parcel.writeString(this.nickname);
        parcel.writeString(this.phone);
        parcel.writeBoolean(this.defaultIcon.booleanValue());
        parcel.writeBoolean(this.qmStatus.booleanValue());
        parcel.writeInt(this.indexStatus);
        parcel.writeInt(this.code);
    }

    public AccountInfo(Parcel parcel) {
        this.id = parcel.readString();
        this.mzUid = parcel.readString();
        this.backgroundColor = parcel.readString();
        this.backgroundImage = parcel.readString();
        this.bakIcon = parcel.readString();
        this.email = parcel.readString();
        this.f6570flyme = parcel.readString();
        this.icon = parcel.readString();
        this.message = parcel.readString();
        this.nickname = parcel.readString();
        this.phone = parcel.readString();
        this.qmImage = parcel.readString();
        this.defaultIcon = Boolean.valueOf(parcel.readBoolean());
        this.qmStatus = Boolean.valueOf(parcel.readBoolean());
        this.indexStatus = parcel.readInt();
        this.code = parcel.readInt();
    }
}
