package com.xjsd.ai.assistant.nlu.bean;

import java.util.HashMap;
import java.util.Map;

public class ContextData {
    private Header header;
    private Map<String, Object> payload = new HashMap();

    public static class AssistantInfo {
        private Personalization personalization;
        private Wakeup wakeup;

        public Personalization getPersonalization() {
            return this.personalization;
        }

        public Wakeup getWakeup() {
            return this.wakeup;
        }

        public void setPersonalization(Personalization personalization2) {
            this.personalization = personalization2;
        }

        public void setWakeup(Wakeup wakeup2) {
            this.wakeup = wakeup2;
        }
    }

    public static class Header {
        private String name;
        private String namespace;

        public String getName() {
            return this.name;
        }

        public String getNamespace() {
            return this.namespace;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setNamespace(String str) {
            this.namespace = str;
        }
    }

    public static class Personalization {
        private String ttsSpeaker;
        private String wakeupWord;

        public String getTtsSpeaker() {
            return this.ttsSpeaker;
        }

        public String getWakeupWord() {
            return this.wakeupWord;
        }

        public void setTtsSpeaker(String str) {
            this.ttsSpeaker = str;
        }

        public void setWakeupWord(String str) {
            this.wakeupWord = str;
        }
    }

    public static class Wakeup {
        private String deviceType;
        private String location;
        private boolean status;
        private String type;
        private String wakeupWord;

        public String getDeviceType() {
            return this.deviceType;
        }

        public String getLocation() {
            return this.location;
        }

        public String getType() {
            return this.type;
        }

        public String getWakeupWord() {
            return this.wakeupWord;
        }

        public boolean isStatus() {
            return this.status;
        }

        public void setDeviceType(String str) {
            this.deviceType = str;
        }

        public void setLocation(String str) {
            this.location = str;
        }

        public void setStatus(boolean z) {
            this.status = z;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setWakeupWord(String str) {
            this.wakeupWord = str;
        }
    }

    public ContextData(String str, String str2) {
        Header header2 = new Header();
        this.header = header2;
        header2.setNamespace(str);
        this.header.setName(str2);
    }

    public ContextData appendPayload(String str, Object obj) {
        this.payload.put(str, obj);
        return this;
    }

    public Header getHeader() {
        return this.header;
    }

    public Map<String, Object> getPayload() {
        return this.payload;
    }
}
