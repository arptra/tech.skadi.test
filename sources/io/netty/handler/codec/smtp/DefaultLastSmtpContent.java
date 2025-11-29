package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;

public final class DefaultLastSmtpContent extends DefaultSmtpContent implements LastSmtpContent {
    public DefaultLastSmtpContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public LastSmtpContent copy() {
        return (LastSmtpContent) super.copy();
    }

    public LastSmtpContent duplicate() {
        return (LastSmtpContent) super.duplicate();
    }

    public LastSmtpContent replace(ByteBuf byteBuf) {
        return new DefaultLastSmtpContent(byteBuf);
    }

    public LastSmtpContent retainedDuplicate() {
        return (LastSmtpContent) super.retainedDuplicate();
    }

    public DefaultLastSmtpContent retain() {
        super.retain();
        return this;
    }

    public DefaultLastSmtpContent touch() {
        super.touch();
        return this;
    }

    public DefaultLastSmtpContent retain(int i) {
        super.retain(i);
        return this;
    }

    public DefaultLastSmtpContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
