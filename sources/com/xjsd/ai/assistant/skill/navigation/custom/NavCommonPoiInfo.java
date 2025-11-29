package com.xjsd.ai.assistant.skill.navigation.custom;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class NavCommonPoiInfo implements Serializable {
    private Header header;
    private Payload payload;

    @Keep
    public static class CommonAddr {
        private double latitude = 0.0d;
        private double longitude = 0.0d;
        private String name = "";

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public String getName() {
            return this.name;
        }

        public void setLatitude(double d) {
            this.latitude = d;
        }

        public void setLongitude(double d) {
            this.longitude = d;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    @Keep
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

    @Keep
    public static class Payload {
        private CommonAddr company;
        private CommonAddr home;

        public CommonAddr getCompany() {
            return this.company;
        }

        public CommonAddr getHome() {
            return this.home;
        }

        public void setCompany(CommonAddr commonAddr) {
            this.company = commonAddr;
        }

        public void setHome(CommonAddr commonAddr) {
            this.home = commonAddr;
        }
    }

    public Header getHeader() {
        return this.header;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setHeader(Header header2) {
        this.header = header2;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }
}
