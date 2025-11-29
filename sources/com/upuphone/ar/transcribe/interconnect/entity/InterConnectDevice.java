package com.upuphone.ar.transcribe.interconnect.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00064"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectDevice;", "", "()V", "bleMac", "", "getBleMac", "()Ljava/lang/String;", "setBleMac", "(Ljava/lang/String;)V", "brEdrMac", "getBrEdrMac", "setBrEdrMac", "categoryId", "getCategoryId", "setCategoryId", "categoryName", "getCategoryName", "setCategoryName", "companyId", "getCompanyId", "setCompanyId", "companyName", "getCompanyName", "setCompanyName", "deviceId", "getDeviceId", "setDeviceId", "deviceName", "getDeviceName", "setDeviceName", "modelId", "getModelId", "setModelId", "modelName", "getModelName", "setModelName", "status", "", "getStatus", "()I", "setStatus", "(I)V", "terminalType", "", "getTerminalType", "()B", "setTerminalType", "(B)V", "wifiMac", "getWifiMac", "setWifiMac", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InterConnectDevice {
    @NotNull
    private String bleMac = "";
    @NotNull
    private String brEdrMac = "";
    @NotNull
    private String categoryId = "";
    @NotNull
    private String categoryName = "";
    @NotNull
    private String companyId = "";
    @NotNull
    private String companyName = "";
    @NotNull
    private String deviceId = "";
    @NotNull
    private String deviceName = "";
    @NotNull
    private String modelId = "";
    @NotNull
    private String modelName = "";
    private int status;
    private byte terminalType;
    @NotNull
    private String wifiMac = "";

    @NotNull
    public final String getBleMac() {
        return this.bleMac;
    }

    @NotNull
    public final String getBrEdrMac() {
        return this.brEdrMac;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getCompanyId() {
        return this.companyId;
    }

    @NotNull
    public final String getCompanyName() {
        return this.companyName;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getDeviceName() {
        return this.deviceName;
    }

    @NotNull
    public final String getModelId() {
        return this.modelId;
    }

    @NotNull
    public final String getModelName() {
        return this.modelName;
    }

    public final int getStatus() {
        return this.status;
    }

    public final byte getTerminalType() {
        return this.terminalType;
    }

    @NotNull
    public final String getWifiMac() {
        return this.wifiMac;
    }

    public final void setBleMac(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bleMac = str;
    }

    public final void setBrEdrMac(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.brEdrMac = str;
    }

    public final void setCategoryId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryId = str;
    }

    public final void setCategoryName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryName = str;
    }

    public final void setCompanyId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.companyId = str;
    }

    public final void setCompanyName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.companyName = str;
    }

    public final void setDeviceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceId = str;
    }

    public final void setDeviceName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceName = str;
    }

    public final void setModelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelId = str;
    }

    public final void setModelName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelName = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTerminalType(byte b) {
        this.terminalType = b;
    }

    public final void setWifiMac(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wifiMac = str;
    }

    @NotNull
    public String toString() {
        String str = this.deviceId;
        String str2 = this.deviceName;
        String str3 = this.categoryId;
        String str4 = this.categoryName;
        String str5 = this.companyId;
        String str6 = this.companyName;
        String str7 = this.modelId;
        String str8 = this.modelName;
        String str9 = this.brEdrMac;
        String str10 = this.bleMac;
        String str11 = this.wifiMac;
        byte b = this.terminalType;
        int i = this.status;
        return "InterConnectDevice(deviceId='" + str + "', deviceName='" + str2 + "', categoryId='" + str3 + "', categoryName='" + str4 + "', companyId='" + str5 + "', companyName='" + str6 + "', modelId='" + str7 + "', modelName='" + str8 + "', brEdrMac='" + str9 + "', bleMac='" + str10 + "', wifiMac='" + str11 + "', terminalType='" + b + "', status='" + i + "')";
    }
}
