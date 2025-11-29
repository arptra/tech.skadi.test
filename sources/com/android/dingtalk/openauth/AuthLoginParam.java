package com.android.dingtalk.openauth;

public class AuthLoginParam {
    public String mAltSignature;
    public String mAppId;
    public String mNonce;
    public String mPrompt;
    public String mRedirectUri;
    public String mResponseType;
    public String mScope;
    public String mState;

    public static final class AuthLoginParamBuilder {
        public String mAltSignature = "";
        public String mAppId = "";
        public String mNonce = "";
        public String mPrompt = "";
        public String mRedirectUri = "";
        public String mResponseType = "";
        public String mScope = "";
        public String mState = "";

        public static AuthLoginParamBuilder newBuilder() {
            return new AuthLoginParamBuilder();
        }

        public AuthLoginParamBuilder altSignature(String str) {
            this.mAltSignature = str;
            return this;
        }

        public AuthLoginParamBuilder appId(String str) {
            this.mAppId = str;
            return this;
        }

        public AuthLoginParam build() {
            AuthLoginParam authLoginParam = new AuthLoginParam();
            String unused = authLoginParam.mState = this.mState;
            String unused2 = authLoginParam.mNonce = this.mNonce;
            String unused3 = authLoginParam.mRedirectUri = this.mRedirectUri;
            String unused4 = authLoginParam.mAppId = this.mAppId;
            String unused5 = authLoginParam.mScope = this.mScope;
            String unused6 = authLoginParam.mResponseType = this.mResponseType;
            String unused7 = authLoginParam.mPrompt = this.mPrompt;
            String unused8 = authLoginParam.mAltSignature = this.mAltSignature;
            return authLoginParam;
        }

        public AuthLoginParamBuilder nonce(String str) {
            this.mNonce = str;
            return this;
        }

        public AuthLoginParamBuilder prompt(String str) {
            this.mPrompt = str;
            return this;
        }

        public AuthLoginParamBuilder redirectUri(String str) {
            this.mRedirectUri = str;
            return this;
        }

        public AuthLoginParamBuilder responseType(String str) {
            this.mResponseType = str;
            return this;
        }

        public AuthLoginParamBuilder scope(String str) {
            this.mScope = str;
            return this;
        }

        public AuthLoginParamBuilder state(String str) {
            this.mState = str;
            return this;
        }
    }

    public String getAltSignature() {
        return this.mAltSignature;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getNonce() {
        return this.mNonce;
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public String getResponseType() {
        return this.mResponseType;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getState() {
        return this.mState;
    }
}
