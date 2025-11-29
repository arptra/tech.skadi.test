package com.upuphone.ai.ttsengine.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.Objects;

@Keep
public class SpeakerInfo implements Parcelable {
    public static final Parcelable.Creator<SpeakerInfo> CREATOR = new Parcelable.Creator<SpeakerInfo>() {
        /* renamed from: a */
        public SpeakerInfo createFromParcel(Parcel parcel) {
            return new SpeakerInfo(parcel);
        }

        /* renamed from: b */
        public SpeakerInfo[] newArray(int i) {
            return new SpeakerInfo[i];
        }
    };
    float age = 18.0f;
    String category;
    String engine;
    String extJson;
    private int mPitch = 10;
    private int mSpeed = 10;
    private int mVolume = 10;
    String name;
    int sex = 1;
    int speakerId;
    String voiceAudioPath;
    String voiceName;

    public SpeakerInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeakerInfo)) {
            return false;
        }
        SpeakerInfo speakerInfo = (SpeakerInfo) obj;
        return this.speakerId == speakerInfo.speakerId && Objects.equals(this.name, speakerInfo.name);
    }

    public float getAge() {
        return this.age;
    }

    public String getCategory() {
        return this.category;
    }

    public String getEngine() {
        return this.engine;
    }

    public String getName() {
        return this.name;
    }

    public int getSex() {
        return this.sex;
    }

    public int getSpeakerId() {
        return this.speakerId;
    }

    public String getVoiceAudioPath() {
        return this.voiceAudioPath;
    }

    public String getVoiceName() {
        return this.voiceName;
    }

    public int getmPitch() {
        return this.mPitch;
    }

    public int getmSpeed() {
        return this.mSpeed;
    }

    public int getmVolume() {
        return this.mVolume;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.speakerId), this.name});
    }

    public void readFromParcel(Parcel parcel) {
        this.speakerId = parcel.readInt();
        this.name = parcel.readString();
        this.engine = parcel.readString();
        this.voiceAudioPath = parcel.readString();
        this.sex = parcel.readInt();
        this.age = parcel.readFloat();
        this.mVolume = parcel.readInt();
        this.mSpeed = parcel.readInt();
        this.mPitch = parcel.readInt();
        this.voiceName = parcel.readString();
        this.extJson = parcel.readString();
        this.category = parcel.readString();
    }

    public void setAge(float f) {
        this.age = f;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setEngine(String str) {
        this.engine = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setSpeakerId(int i) {
        this.speakerId = i;
    }

    public void setVoiceAudioPath(String str) {
        this.voiceAudioPath = str;
    }

    public void setVoiceName(String str) {
        this.voiceName = str;
    }

    public void setmPitch(int i) {
        this.mPitch = i;
    }

    public void setmSpeed(int i) {
        this.mSpeed = i;
    }

    public void setmVolume(int i) {
        this.mVolume = i;
    }

    public String toString() {
        return "SpeakerInfo{speakerId=" + this.speakerId + ", name='" + this.name + '\'' + ", engine='" + this.engine + '\'' + ", voiceAudioPath='" + this.voiceAudioPath + '\'' + ", sex=" + this.sex + ", age=" + this.age + ", mVolume=" + this.mVolume + ", mSpeed=" + this.mSpeed + ", mPitch=" + this.mPitch + ", voiceName='" + this.voiceName + '\'' + ", extJson='" + this.extJson + '\'' + ", category='" + this.category + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.speakerId);
        parcel.writeString(this.name);
        parcel.writeString(this.engine);
        parcel.writeString(this.voiceAudioPath);
        parcel.writeInt(this.sex);
        parcel.writeFloat(this.age);
        parcel.writeInt(this.mVolume);
        parcel.writeInt(this.mSpeed);
        parcel.writeInt(this.mPitch);
        parcel.writeString(this.voiceName);
        parcel.writeString(this.extJson);
        parcel.writeString(this.category);
    }

    public SpeakerInfo(Parcel parcel) {
        this.speakerId = parcel.readInt();
        this.name = parcel.readString();
        this.engine = parcel.readString();
        this.voiceAudioPath = parcel.readString();
        this.sex = parcel.readInt();
        this.age = parcel.readFloat();
        this.mVolume = parcel.readInt();
        this.mSpeed = parcel.readInt();
        this.mPitch = parcel.readInt();
        this.voiceName = parcel.readString();
        this.extJson = parcel.readString();
        this.category = parcel.readString();
    }
}
