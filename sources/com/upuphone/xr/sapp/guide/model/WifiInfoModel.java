package com.upuphone.xr.sapp.guide.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b7\b\b\u0018\u00002\u00020\u0001B\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u0012J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001J\u0013\u0010<\u001a\u00020\t2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0006HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0016\"\u0004\b\u001f\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0014R\u001a\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$¨\u0006@"}, d2 = {"Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;", "", "sSid", "", "bSsid", "wifiState", "", "itemType", "needPassword", "", "refreshState", "isPhoneConnectWifi", "isDelete", "checkedState", "checkedEnable", "checkedVisible", "wifiInValid", "ignoreShow", "(Ljava/lang/String;Ljava/lang/String;IIZZZZZZZZZ)V", "getBSsid", "()Ljava/lang/String;", "getCheckedEnable", "()Z", "setCheckedEnable", "(Z)V", "getCheckedState", "setCheckedState", "getCheckedVisible", "setCheckedVisible", "getIgnoreShow", "setIgnoreShow", "setDelete", "setPhoneConnectWifi", "getItemType", "()I", "setItemType", "(I)V", "getNeedPassword", "setNeedPassword", "getRefreshState", "setRefreshState", "getSSid", "getWifiInValid", "setWifiInValid", "getWifiState", "setWifiState", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class WifiInfoModel {
    @SerializedName("bssids")
    @NotNull
    private final String bSsid;
    private boolean checkedEnable;
    private boolean checkedState;
    private boolean checkedVisible;
    private boolean ignoreShow;
    private boolean isDelete;
    private boolean isPhoneConnectWifi;
    @SerializedName("item_type")
    private int itemType;
    @SerializedName("need_password")
    private boolean needPassword;
    private boolean refreshState;
    @SerializedName("ssid")
    @NotNull
    private final String sSid;
    private boolean wifiInValid;
    @SerializedName("wifi_state")
    private int wifiState;

    public WifiInfoModel(@NotNull String str, @NotNull String str2, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        Intrinsics.checkNotNullParameter(str, "sSid");
        Intrinsics.checkNotNullParameter(str2, "bSsid");
        this.sSid = str;
        this.bSsid = str2;
        this.wifiState = i;
        this.itemType = i2;
        this.needPassword = z;
        this.refreshState = z2;
        this.isPhoneConnectWifi = z3;
        this.isDelete = z4;
        this.checkedState = z5;
        this.checkedEnable = z6;
        this.checkedVisible = z7;
        this.wifiInValid = z8;
        this.ignoreShow = z9;
    }

    public static /* synthetic */ WifiInfoModel copy$default(WifiInfoModel wifiInfoModel, String str, String str2, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i3, Object obj) {
        WifiInfoModel wifiInfoModel2 = wifiInfoModel;
        int i4 = i3;
        return wifiInfoModel.copy((i4 & 1) != 0 ? wifiInfoModel2.sSid : str, (i4 & 2) != 0 ? wifiInfoModel2.bSsid : str2, (i4 & 4) != 0 ? wifiInfoModel2.wifiState : i, (i4 & 8) != 0 ? wifiInfoModel2.itemType : i2, (i4 & 16) != 0 ? wifiInfoModel2.needPassword : z, (i4 & 32) != 0 ? wifiInfoModel2.refreshState : z2, (i4 & 64) != 0 ? wifiInfoModel2.isPhoneConnectWifi : z3, (i4 & 128) != 0 ? wifiInfoModel2.isDelete : z4, (i4 & 256) != 0 ? wifiInfoModel2.checkedState : z5, (i4 & 512) != 0 ? wifiInfoModel2.checkedEnable : z6, (i4 & 1024) != 0 ? wifiInfoModel2.checkedVisible : z7, (i4 & 2048) != 0 ? wifiInfoModel2.wifiInValid : z8, (i4 & 4096) != 0 ? wifiInfoModel2.ignoreShow : z9);
    }

    @NotNull
    public final String component1() {
        return this.sSid;
    }

    public final boolean component10() {
        return this.checkedEnable;
    }

    public final boolean component11() {
        return this.checkedVisible;
    }

    public final boolean component12() {
        return this.wifiInValid;
    }

    public final boolean component13() {
        return this.ignoreShow;
    }

    @NotNull
    public final String component2() {
        return this.bSsid;
    }

    public final int component3() {
        return this.wifiState;
    }

    public final int component4() {
        return this.itemType;
    }

    public final boolean component5() {
        return this.needPassword;
    }

    public final boolean component6() {
        return this.refreshState;
    }

    public final boolean component7() {
        return this.isPhoneConnectWifi;
    }

    public final boolean component8() {
        return this.isDelete;
    }

    public final boolean component9() {
        return this.checkedState;
    }

    @NotNull
    public final WifiInfoModel copy(@NotNull String str, @NotNull String str2, int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "sSid");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "bSsid");
        return new WifiInfoModel(str3, str4, i, i2, z, z2, z3, z4, z5, z6, z7, z8, z9);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiInfoModel)) {
            return false;
        }
        WifiInfoModel wifiInfoModel = (WifiInfoModel) obj;
        return Intrinsics.areEqual((Object) this.sSid, (Object) wifiInfoModel.sSid) && Intrinsics.areEqual((Object) this.bSsid, (Object) wifiInfoModel.bSsid) && this.wifiState == wifiInfoModel.wifiState && this.itemType == wifiInfoModel.itemType && this.needPassword == wifiInfoModel.needPassword && this.refreshState == wifiInfoModel.refreshState && this.isPhoneConnectWifi == wifiInfoModel.isPhoneConnectWifi && this.isDelete == wifiInfoModel.isDelete && this.checkedState == wifiInfoModel.checkedState && this.checkedEnable == wifiInfoModel.checkedEnable && this.checkedVisible == wifiInfoModel.checkedVisible && this.wifiInValid == wifiInfoModel.wifiInValid && this.ignoreShow == wifiInfoModel.ignoreShow;
    }

    @NotNull
    public final String getBSsid() {
        return this.bSsid;
    }

    public final boolean getCheckedEnable() {
        return this.checkedEnable;
    }

    public final boolean getCheckedState() {
        return this.checkedState;
    }

    public final boolean getCheckedVisible() {
        return this.checkedVisible;
    }

    public final boolean getIgnoreShow() {
        return this.ignoreShow;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final boolean getNeedPassword() {
        return this.needPassword;
    }

    public final boolean getRefreshState() {
        return this.refreshState;
    }

    @NotNull
    public final String getSSid() {
        return this.sSid;
    }

    public final boolean getWifiInValid() {
        return this.wifiInValid;
    }

    public final int getWifiState() {
        return this.wifiState;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.sSid.hashCode() * 31) + this.bSsid.hashCode()) * 31) + Integer.hashCode(this.wifiState)) * 31) + Integer.hashCode(this.itemType)) * 31) + Boolean.hashCode(this.needPassword)) * 31) + Boolean.hashCode(this.refreshState)) * 31) + Boolean.hashCode(this.isPhoneConnectWifi)) * 31) + Boolean.hashCode(this.isDelete)) * 31) + Boolean.hashCode(this.checkedState)) * 31) + Boolean.hashCode(this.checkedEnable)) * 31) + Boolean.hashCode(this.checkedVisible)) * 31) + Boolean.hashCode(this.wifiInValid)) * 31) + Boolean.hashCode(this.ignoreShow);
    }

    public final boolean isDelete() {
        return this.isDelete;
    }

    public final boolean isPhoneConnectWifi() {
        return this.isPhoneConnectWifi;
    }

    public final void setCheckedEnable(boolean z) {
        this.checkedEnable = z;
    }

    public final void setCheckedState(boolean z) {
        this.checkedState = z;
    }

    public final void setCheckedVisible(boolean z) {
        this.checkedVisible = z;
    }

    public final void setDelete(boolean z) {
        this.isDelete = z;
    }

    public final void setIgnoreShow(boolean z) {
        this.ignoreShow = z;
    }

    public final void setItemType(int i) {
        this.itemType = i;
    }

    public final void setNeedPassword(boolean z) {
        this.needPassword = z;
    }

    public final void setPhoneConnectWifi(boolean z) {
        this.isPhoneConnectWifi = z;
    }

    public final void setRefreshState(boolean z) {
        this.refreshState = z;
    }

    public final void setWifiInValid(boolean z) {
        this.wifiInValid = z;
    }

    public final void setWifiState(int i) {
        this.wifiState = i;
    }

    @NotNull
    public String toString() {
        String str = this.sSid;
        String str2 = this.bSsid;
        int i = this.wifiState;
        int i2 = this.itemType;
        boolean z = this.needPassword;
        boolean z2 = this.refreshState;
        boolean z3 = this.isPhoneConnectWifi;
        boolean z4 = this.isDelete;
        boolean z5 = this.checkedState;
        boolean z6 = this.checkedEnable;
        boolean z7 = this.checkedVisible;
        boolean z8 = this.wifiInValid;
        boolean z9 = this.ignoreShow;
        return "WifiInfoModel(sSid=" + str + ", bSsid=" + str2 + ", wifiState=" + i + ", itemType=" + i2 + ", needPassword=" + z + ", refreshState=" + z2 + ", isPhoneConnectWifi=" + z3 + ", isDelete=" + z4 + ", checkedState=" + z5 + ", checkedEnable=" + z6 + ", checkedVisible=" + z7 + ", wifiInValid=" + z8 + ", ignoreShow=" + z9 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WifiInfoModel(java.lang.String r18, java.lang.String r19, int r20, int r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r22
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r23
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r24
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0021
            r11 = r2
            goto L_0x0023
        L_0x0021:
            r11 = r25
        L_0x0023:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0029
            r12 = r2
            goto L_0x002b
        L_0x0029:
            r12 = r26
        L_0x002b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0031
            r13 = r2
            goto L_0x0033
        L_0x0031:
            r13 = r27
        L_0x0033:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0039
            r14 = r2
            goto L_0x003b
        L_0x0039:
            r14 = r28
        L_0x003b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0041
            r15 = r2
            goto L_0x0043
        L_0x0041:
            r15 = r29
        L_0x0043:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x004a
            r16 = r2
            goto L_0x004c
        L_0x004a:
            r16 = r30
        L_0x004c:
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.guide.model.WifiInfoModel.<init>(java.lang.String, java.lang.String, int, int, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
