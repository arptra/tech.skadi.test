package com.here.posclient.auth;

public class AuthData {
    private static final String TAG = "posclient.auth.AuthData";
    public String accessKeyId;
    public String accessKeySecret;
    public String accessToken;
    public long expiryTime;

    public AuthData() {
    }

    public AuthData setAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public AuthData setExpiryTime(long j) {
        this.expiryTime = j;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AuthData [");
        stringBuffer.append("token: ");
        if (this.accessToken != null) {
            stringBuffer.append("true ");
            stringBuffer.append(", expiryTime: ");
            stringBuffer.append(this.expiryTime);
        } else {
            stringBuffer.append("false ");
        }
        stringBuffer.append(", access key: ");
        if (this.accessKeyId != null) {
            stringBuffer.append("true ");
            stringBuffer.append(", id: ");
            stringBuffer.append(this.accessKeyId);
        } else {
            stringBuffer.append("false ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public AuthData(String str, long j) {
        this.accessToken = str;
        this.expiryTime = j;
    }

    public AuthData(String str, String str2) {
        this.accessKeyId = str;
        this.accessKeySecret = str2;
    }
}
