package com.upuphone.runasone.message;

import com.upuphone.runasone.QosLevel;
import com.upuphone.runasone.StreamType;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.EnumLinkStrategy;

public class ChannelMessage implements Cloneable {
    private AbilityMessage abilityMessage;
    private boolean bRetransmission;
    private String category;
    private String character_uuid;
    private long commitTime;
    private String dstId;
    private String id;
    private EnumLinkStrategy linkStrategy;
    private StreamType messageType;
    private QosLevel qos;
    private long requestId;
    private boolean sendTlv;
    private String service_uuid;
    private String session;
    private String srcId;

    public static class Builder {
        /* access modifiers changed from: private */
        public AbilityMessage abilityMessage;
        /* access modifiers changed from: private */
        public boolean bRetransmission = false;
        /* access modifiers changed from: private */
        public String category;
        /* access modifiers changed from: private */
        public String character_uuid;
        /* access modifiers changed from: private */
        public String dstId;
        /* access modifiers changed from: private */
        public String id;
        /* access modifiers changed from: private */
        public EnumLinkStrategy linkStrategy;
        /* access modifiers changed from: private */
        public StreamType messageType = StreamType.BYPASS;
        /* access modifiers changed from: private */
        public QosLevel qos = QosLevel.QOS_0;
        /* access modifiers changed from: private */
        public long requestId;
        /* access modifiers changed from: private */
        public String service_uuid;
        /* access modifiers changed from: private */
        public String session = Constants.INVALID_SESSION;
        /* access modifiers changed from: private */
        public String srcId;

        public ChannelMessage build() {
            return new ChannelMessage(this);
        }

        public Builder setAbilityMessage(AbilityMessage abilityMessage2) {
            this.abilityMessage = abilityMessage2;
            return this;
        }

        public Builder setCategory(String str) {
            this.category = str;
            return this;
        }

        public Builder setCharacterUuid(String str) {
            this.character_uuid = str;
            return this;
        }

        public Builder setDstId(String str) {
            this.dstId = str;
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setLinkStrategy(EnumLinkStrategy enumLinkStrategy) {
            this.linkStrategy = enumLinkStrategy;
            return this;
        }

        public Builder setMessageType(StreamType streamType) {
            this.messageType = streamType;
            return this;
        }

        public Builder setQos(QosLevel qosLevel) {
            this.qos = qosLevel;
            return this;
        }

        public Builder setRequestId(long j) {
            this.requestId = j;
            return this;
        }

        public Builder setRetransmission(boolean z) {
            this.bRetransmission = z;
            return this;
        }

        public Builder setServiceUuid(String str) {
            this.service_uuid = str;
            return this;
        }

        public Builder setSession(String str) {
            this.session = str;
            return this;
        }

        public Builder setSrcId(String str) {
            this.srcId = str;
            return this;
        }
    }

    public ChannelMessage(Builder builder) {
        this.abilityMessage = builder.abilityMessage;
        this.category = builder.category;
        this.character_uuid = builder.character_uuid;
        this.service_uuid = builder.service_uuid;
        this.id = builder.id;
        this.requestId = builder.requestId;
        this.linkStrategy = builder.linkStrategy;
        this.bRetransmission = builder.bRetransmission;
        this.qos = builder.qos;
        this.session = builder.session;
        this.messageType = builder.messageType;
        this.dstId = builder.dstId;
        this.srcId = builder.srcId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public AbilityMessage getAbilityMessage() {
        return this.abilityMessage;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCharacterUuid() {
        return this.character_uuid;
    }

    public long getCommitTime() {
        return this.commitTime;
    }

    public String getDstId() {
        return this.dstId;
    }

    public String getId() {
        return this.id;
    }

    public EnumLinkStrategy getLinkStrategy() {
        return this.linkStrategy;
    }

    public StreamType getMessageType() {
        return this.messageType;
    }

    public QosLevel getQos() {
        return this.qos;
    }

    public long getRequestId() {
        return this.requestId;
    }

    public String getServiceUuid() {
        return this.service_uuid;
    }

    public String getSession() {
        return this.session;
    }

    public String getSrcId() {
        return this.srcId;
    }

    public boolean isRetransmission() {
        return this.bRetransmission;
    }

    public boolean isSendTlv() {
        return this.sendTlv;
    }

    public void setCommitTime(long j) {
        this.commitTime = j;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMessageType(StreamType streamType) {
        this.messageType = streamType;
    }

    public void setRequestId(long j) {
        this.requestId = j;
    }

    public void setRetransmission(boolean z) {
        this.bRetransmission = z;
    }

    public void setSendTlv(boolean z) {
        this.sendTlv = z;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String toString() {
        return "ChannelMessage{id='" + this.id + '\'' + ", category='" + this.category + '\'' + ", requestId=" + this.requestId + ", commitTime=" + this.commitTime + ", linkStrategy=" + this.linkStrategy + ", abilityMessage=" + this.abilityMessage + ", bRetransmission=" + this.bRetransmission + ", qos=" + this.qos + ", session='" + this.session + '\'' + ", character_uuid='" + this.character_uuid + '\'' + ", service_uuid='" + this.service_uuid + '\'' + ", messageType=" + this.messageType + ", dstId='" + this.dstId + '\'' + ", srcId='" + this.srcId + '\'' + ", sendTlv=" + this.sendTlv + '}';
    }

    public ChannelMessage clone() throws CloneNotSupportedException {
        return (ChannelMessage) super.clone();
    }
}
