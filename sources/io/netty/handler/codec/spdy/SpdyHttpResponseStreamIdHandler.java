package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class SpdyHttpResponseStreamIdHandler extends MessageToMessageCodec<Object, HttpMessage> {
    private static final Integer NO_ID = -1;
    private final Queue<Integer> ids = new ArrayDeque();

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return (obj instanceof HttpMessage) || (obj instanceof SpdyRstStreamFrame);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        if (obj instanceof HttpMessage) {
            HttpMessage httpMessage = (HttpMessage) obj;
            HttpHeaders headers = httpMessage.headers();
            AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
            if (!headers.contains((CharSequence) asciiString)) {
                this.ids.add(NO_ID);
            } else {
                this.ids.add(httpMessage.headers().getInt(asciiString));
            }
        } else if (obj instanceof SpdyRstStreamFrame) {
            this.ids.remove(Integer.valueOf(((SpdyRstStreamFrame) obj).streamId()));
        }
        list.add(ReferenceCountUtil.retain(obj));
    }

    public void encode(ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage, List<Object> list) throws Exception {
        Integer poll = this.ids.poll();
        if (!(poll == null || poll.intValue() == NO_ID.intValue())) {
            HttpHeaders headers = httpMessage.headers();
            AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
            if (!headers.contains((CharSequence) asciiString)) {
                httpMessage.headers().setInt(asciiString, poll.intValue());
            }
        }
        list.add(ReferenceCountUtil.retain(httpMessage));
    }
}
