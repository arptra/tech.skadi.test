package com.upuphone.runasone.channel.bean.debug;

import java.util.List;

public class DebugInfoBean {
    private List<ChannelBean> channelBeanList;
    private String coreCommit;
    private String rootCommit;
    private String selfId;
    private String selfName;
    private String version;

    public List<ChannelBean> getChannelBeanList() {
        return this.channelBeanList;
    }

    public String getCoreCommit() {
        return this.coreCommit;
    }

    public String getRootCommit() {
        return this.rootCommit;
    }

    public String getSelfId() {
        return this.selfId;
    }

    public String getSelfName() {
        return this.selfName;
    }

    public String getVersion() {
        return this.version;
    }

    public void setChannelBeanList(List<ChannelBean> list) {
        this.channelBeanList = list;
    }

    public void setCoreCommit(String str) {
        this.coreCommit = str;
    }

    public void setRootCommit(String str) {
        this.rootCommit = str;
    }

    public void setSelfId(String str) {
        this.selfId = str;
    }

    public void setSelfName(String str) {
        this.selfName = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
