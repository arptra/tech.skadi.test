package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;

public class DefaultSmtpContent extends DefaultByteBufHolder implements SmtpContent {
    public DefaultSmtpContent(ByteBuf byteBuf) {
        super(byteBuf);
    }

    public SmtpContent copy() {
        return (SmtpContent) super.copy();
    }

    public SmtpContent duplicate() {
        return (SmtpContent) super.duplicate();
    }

    public SmtpContent replace(ByteBuf byteBuf) {
        return new DefaultSmtpContent(byteBuf);
    }

    public SmtpContent retainedDuplicate() {
        return (SmtpContent) super.retainedDuplicate();
    }

    public SmtpContent retain() {
        super.retain();
        return this;
    }

    public SmtpContent touch() {
        super.touch();
        return this;
    }

    public SmtpContent retain(int i) {
        super.retain(i);
        return this;
    }

    public SmtpContent touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
