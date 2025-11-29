package io.netty.handler.codec.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;

public class MqttPublishMessage extends MqttMessage implements ByteBufHolder {
    public MqttPublishMessage(MqttFixedHeader mqttFixedHeader, MqttPublishVariableHeader mqttPublishVariableHeader, ByteBuf byteBuf) {
        super(mqttFixedHeader, mqttPublishVariableHeader, byteBuf);
    }

    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible((ByteBuf) super.payload());
    }

    public int refCnt() {
        return content().refCnt();
    }

    public boolean release() {
        return content().release();
    }

    public MqttPublishMessage copy() {
        return replace(content().copy());
    }

    public MqttPublishMessage duplicate() {
        return replace(content().duplicate());
    }

    public ByteBuf payload() {
        return content();
    }

    public boolean release(int i) {
        return content().release(i);
    }

    public MqttPublishMessage replace(ByteBuf byteBuf) {
        return new MqttPublishMessage(fixedHeader(), variableHeader(), byteBuf);
    }

    public MqttPublishMessage retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    public MqttPublishVariableHeader variableHeader() {
        return (MqttPublishVariableHeader) super.variableHeader();
    }

    public MqttPublishMessage retain() {
        content().retain();
        return this;
    }

    public MqttPublishMessage touch() {
        content().touch();
        return this;
    }

    public MqttPublishMessage retain(int i) {
        content().retain(i);
        return this;
    }

    public MqttPublishMessage touch(Object obj) {
        content().touch(obj);
        return this;
    }
}
