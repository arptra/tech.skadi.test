package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public interface LastSmtpContent extends SmtpContent {
    public static final LastSmtpContent EMPTY_LAST_CONTENT = new LastSmtpContent() {
        public ByteBuf content() {
            return Unpooled.EMPTY_BUFFER;
        }

        public LastSmtpContent copy() {
            return this;
        }

        public LastSmtpContent duplicate() {
            return this;
        }

        public int refCnt() {
            return 1;
        }

        public boolean release() {
            return false;
        }

        public LastSmtpContent retain() {
            return this;
        }

        public LastSmtpContent retainedDuplicate() {
            return this;
        }

        public LastSmtpContent touch() {
            return this;
        }

        public boolean release(int i) {
            return false;
        }

        public LastSmtpContent retain(int i) {
            return this;
        }

        public LastSmtpContent touch(Object obj) {
            return this;
        }

        public LastSmtpContent replace(ByteBuf byteBuf) {
            return new DefaultLastSmtpContent(byteBuf);
        }
    };

    LastSmtpContent copy();

    LastSmtpContent duplicate();

    LastSmtpContent replace(ByteBuf byteBuf);

    LastSmtpContent retain();

    LastSmtpContent retain(int i);

    LastSmtpContent retainedDuplicate();

    LastSmtpContent touch();

    LastSmtpContent touch(Object obj);
}
