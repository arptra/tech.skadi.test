package com.upuphone.runasone.channel.bean.debug;

import com.upuphone.runasone.channel.bean.stream.LinkerStatus;
import java.util.List;

public class ChannelBean {
    private List<String> activeAbilityList;
    private String channelId;
    private String coreCommit;
    private long deltaSystemTime;
    private String deviceName;
    private int deviceType;
    private List<String> localAbilityList;
    private List<String> remoteAbilityList;
    private Status status;
    private String version;

    public static class Status {
        private String createTime;
        private long inputTotalSize;
        private boolean isLinkUp;
        private List<LinkerStatus> linkerList;
        private long outputTotalSize;

        public String getCreateTime() {
            return this.createTime;
        }

        public long getInputTotalSize() {
            return this.inputTotalSize;
        }

        public List<LinkerStatus> getLinkerList() {
            return this.linkerList;
        }

        public long getOutputTotalSize() {
            return this.outputTotalSize;
        }

        public boolean isLinkUp() {
            return this.isLinkUp;
        }

        public void setCreateTime(String str) {
            this.createTime = str;
        }

        public void setInputTotalSize(long j) {
            this.inputTotalSize = j;
        }

        public void setLinkUp(boolean z) {
            this.isLinkUp = z;
        }

        public void setLinkerList(List<LinkerStatus> list) {
            this.linkerList = list;
        }

        public void setOutputTotalSize(long j) {
            this.outputTotalSize = j;
        }
    }

    public List<String> getActiveAbilityList() {
        return this.activeAbilityList;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getCoreCommit() {
        return this.coreCommit;
    }

    public long getDeltaSystemTime() {
        return this.deltaSystemTime;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public List<String> getLocalAbilityList() {
        return this.localAbilityList;
    }

    public List<String> getRemoteAbilityList() {
        return this.remoteAbilityList;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getVersion() {
        return this.version;
    }

    public void setActiveAbilityList(List<String> list) {
        this.activeAbilityList = list;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setCoreCommit(String str) {
        this.coreCommit = str;
    }

    public void setDeltaSystemTime(long j) {
        this.deltaSystemTime = j;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public void setLocalAbilityList(List<String> list) {
        this.localAbilityList = list;
    }

    public void setRemoteAbilityList(List<String> list) {
        this.remoteAbilityList = list;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
