package com.xjsd.ai.assistant.common.stks;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
public class OfflineKey {
    @SerializedName("data")
    private Data data;
    @SerializedName("text")
    private String text;

    @Keep
    public static class Data {
        @SerializedName("domain")
        private String domain;
        @SerializedName("func")
        private String func;
        @SerializedName("intent")
        private String intent;
        @SerializedName("number")
        private String number;
        @SerializedName("slot")
        private String slot;
        @SerializedName("target")
        private String target;

        public String getDomain() {
            return this.domain;
        }

        public String getFunc() {
            return this.func;
        }

        public String getIntent() {
            return this.intent;
        }

        public String getNumber() {
            return this.number;
        }

        public String getSlot() {
            return this.slot;
        }

        public String getTarget() {
            return this.target;
        }

        public void setDomain(String str) {
            this.domain = str;
        }

        public void setFunc(String str) {
            this.func = str;
        }

        public void setIntent(String str) {
            this.intent = str;
        }

        public void setNumber(String str) {
            this.number = str;
        }

        public void setSlot(String str) {
            this.slot = str;
        }

        public void setTarget(String str) {
            this.target = str;
        }
    }

    public Data getData() {
        return this.data;
    }

    public String getText() {
        return this.text;
    }

    public void setData(Data data2) {
        this.data = data2;
    }

    public void setText(String str) {
        this.text = str;
    }
}
