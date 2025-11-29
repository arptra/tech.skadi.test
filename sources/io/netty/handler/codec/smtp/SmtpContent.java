package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public interface SmtpContent extends ByteBufHolder {
    SmtpContent copy();

    SmtpContent duplicate();

    SmtpContent replace(ByteBuf byteBuf);

    SmtpContent retain();

    SmtpContent retain(int i);

    SmtpContent retainedDuplicate();

    SmtpContent touch();

    SmtpContent touch(Object obj);
}
