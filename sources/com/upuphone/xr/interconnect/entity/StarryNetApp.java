package com.upuphone.xr.interconnect.entity;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class StarryNetApp implements Parcelable {
    public static final Parcelable.Creator<StarryNetApp> CREATOR = new Parcelable.Creator<StarryNetApp>() {
        public StarryNetApp createFromParcel(Parcel parcel) {
            return new StarryNetApp(parcel);
        }

        public StarryNetApp[] newArray(int i) {
            return new StarryNetApp[i];
        }
    };
    private static final String TAG = "StarryNetApp";
    private boolean canOpen = false;
    List<StarryNetAppDockMenu> dockMenuList;
    @NonNull
    private String entry;
    private Drawable icon;
    @NonNull
    private String iconSrc;
    @Nullable
    private String iconUrl;
    @NonNull
    private String id;
    private boolean isRemoteApp = false;
    private String launchEntry;
    private int launchType;
    @NonNull
    private String name;
    private boolean needSync = true;
    @NonNull
    private String packageName;
    private String reason = "对端应用未完成打开条件检查";
    @Nullable
    private String remoteStarryNetAppId;
    private boolean showStatusBar = false;
    @NonNull
    private String starryNetAppId;

    public StarryNetApp() {
    }

    public int describeContents() {
        return 0;
    }

    public List<StarryNetAppDockMenu> getDockMenuList() {
        return this.dockMenuList;
    }

    @NonNull
    public String getEntry() {
        return this.entry;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    @NonNull
    public String getIconSrc() {
        return this.iconSrc;
    }

    @Nullable
    public String getIconUrl() {
        return this.iconUrl;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    public String getLaunchEntry() {
        return this.launchEntry;
    }

    public int getLaunchType() {
        return this.launchType;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
    public String getPackageName() {
        return this.packageName;
    }

    public String getReason() {
        return this.reason;
    }

    @Nullable
    public String getRemoteStarryNetAppId() {
        return this.remoteStarryNetAppId;
    }

    @NonNull
    public String getStarryNetAppId() {
        return this.starryNetAppId;
    }

    public boolean isAttrValid() {
        if (TextUtils.isEmpty(this.id)) {
            Log.d(TAG, "必要属性app id为空");
            return false;
        } else if (TextUtils.isEmpty(this.name)) {
            Log.d(TAG, "必要属性app name为空");
            return false;
        } else if (!TextUtils.isEmpty(this.entry)) {
            return true;
        } else {
            Log.d(TAG, "必要属性app entry为空");
            return false;
        }
    }

    public boolean isCanOpen() {
        return this.canOpen;
    }

    public boolean isNeedSync() {
        return this.needSync;
    }

    public boolean isRemoteApp() {
        return this.isRemoteApp;
    }

    public boolean isShowStatusBar() {
        return this.showStatusBar;
    }

    public void setCanOpen(boolean z) {
        this.canOpen = z;
    }

    public void setDockMenuList(List<StarryNetAppDockMenu> list) {
        this.dockMenuList = list;
    }

    public void setEntry(@NonNull String str) {
        this.entry = str;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setIconSrc(@NonNull String str) {
        this.iconSrc = str;
    }

    public void setIconUrl(@Nullable String str) {
        this.iconUrl = str;
    }

    public void setId(@NonNull String str) {
        this.id = str;
    }

    public void setLaunchEntry(String str) {
        this.launchEntry = str;
    }

    public void setLaunchType(int i) {
        this.launchType = i;
    }

    public void setName(@NonNull String str) {
        this.name = str;
    }

    public void setNeedSync(boolean z) {
        this.needSync = z;
    }

    public void setPackageName(@NonNull String str) {
        this.packageName = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setRemoteApp(boolean z) {
        this.isRemoteApp = z;
    }

    public void setRemoteStarryNetAppId(@Nullable String str) {
        this.remoteStarryNetAppId = str;
    }

    public void setShowStatusBar(boolean z) {
        this.showStatusBar = z;
    }

    public void setStarryNetAppId(@NonNull String str) {
        this.starryNetAppId = str;
    }

    public String toString() {
        return "StarryNetApp{packageName='" + this.packageName + '\'' + ", id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", entry='" + this.entry + '\'' + ", icon=" + this.icon + ", iconSrc='" + this.iconSrc + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", remoteStarryNetAppId='" + this.remoteStarryNetAppId + '\'' + ", dockMenuList=" + this.dockMenuList + ", launchType=" + this.launchType + ", launchEntry='" + this.launchEntry + '\'' + ", starryNetAppId='" + this.starryNetAppId + '\'' + ", needSync=" + this.needSync + ", showStatusBar=" + this.showStatusBar + ", isRemoteApp=" + this.isRemoteApp + ", canOpen=" + this.canOpen + ", reason='" + this.reason + '\'' + '}';
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.entry);
        parcel.writeString(this.iconSrc);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.remoteStarryNetAppId);
        parcel.writeTypedList(this.dockMenuList);
        parcel.writeInt(this.launchType);
        parcel.writeString(this.launchEntry);
        parcel.writeString(this.starryNetAppId);
        parcel.writeByte(this.needSync ? (byte) 1 : 0);
        parcel.writeByte(this.showStatusBar ? (byte) 1 : 0);
        parcel.writeByte(this.isRemoteApp ? (byte) 1 : 0);
        parcel.writeByte(this.canOpen ? (byte) 1 : 0);
        parcel.writeString(this.reason);
    }

    public StarryNetApp(Parcel parcel) {
        boolean z = true;
        this.packageName = parcel.readString();
        this.id = parcel.readString();
        this.name = parcel.readString();
        this.entry = parcel.readString();
        this.iconSrc = parcel.readString();
        this.iconUrl = parcel.readString();
        this.remoteStarryNetAppId = parcel.readString();
        this.dockMenuList = parcel.createTypedArrayList(StarryNetAppDockMenu.CREATOR);
        this.launchType = parcel.readInt();
        this.launchEntry = parcel.readString();
        this.starryNetAppId = parcel.readString();
        this.needSync = parcel.readByte() != 0;
        this.showStatusBar = parcel.readByte() != 0;
        this.isRemoteApp = parcel.readByte() != 0;
        this.canOpen = parcel.readByte() == 0 ? false : z;
        this.reason = parcel.readString();
    }
}
