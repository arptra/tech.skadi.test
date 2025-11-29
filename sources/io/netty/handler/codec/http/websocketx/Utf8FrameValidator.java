package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Utf8FrameValidator extends ChannelInboundHandlerAdapter {
    private final boolean closeOnProtocolViolation;
    private int fragmentedFramesCount;
    private Utf8Validator utf8Validator;

    public Utf8FrameValidator() {
        this(true);
    }

    private void checkUTF8String(ByteBuf byteBuf) {
        if (this.utf8Validator == null) {
            this.utf8Validator = new Utf8Validator();
        }
        this.utf8Validator.check(byteBuf);
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, CorruptedWebSocketFrameException corruptedWebSocketFrameException) {
        webSocketFrame.release();
        if (this.closeOnProtocolViolation && channelHandlerContext.channel().isOpen()) {
            WebSocketCloseStatus closeStatus = corruptedWebSocketFrameException.closeStatus();
            String message = corruptedWebSocketFrameException.getMessage();
            if (message == null) {
                message = closeStatus.reasonText();
            }
            channelHandlerContext.writeAndFlush(new CloseWebSocketFrame(closeStatus.code(), message)).addListener(ChannelFutureListener.CLOSE);
        }
        throw corruptedWebSocketFrameException;
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof WebSocketFrame) {
            WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
            try {
                if (!((WebSocketFrame) obj).isFinalFragment()) {
                    if (this.fragmentedFramesCount != 0) {
                        Utf8Validator utf8Validator2 = this.utf8Validator;
                        if (utf8Validator2 != null && utf8Validator2.isChecking()) {
                            checkUTF8String(webSocketFrame.content());
                        }
                    } else if (webSocketFrame instanceof TextWebSocketFrame) {
                        checkUTF8String(webSocketFrame.content());
                    }
                    this.fragmentedFramesCount++;
                } else if (!(webSocketFrame instanceof PingWebSocketFrame)) {
                    this.fragmentedFramesCount = 0;
                    if (!(webSocketFrame instanceof TextWebSocketFrame)) {
                        Utf8Validator utf8Validator3 = this.utf8Validator;
                        if (utf8Validator3 != null && utf8Validator3.isChecking()) {
                        }
                    }
                    checkUTF8String(webSocketFrame.content());
                    this.utf8Validator.finish();
                }
            } catch (CorruptedWebSocketFrameException e) {
                protocolViolation(channelHandlerContext, webSocketFrame, e);
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        super.exceptionCaught(channelHandlerContext, th);
    }

    public Utf8FrameValidator(boolean z) {
        this.closeOnProtocolViolation = z;
    }
}
