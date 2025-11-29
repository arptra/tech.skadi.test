package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.List;

public abstract class SslClientHelloHandler<T> extends ByteToMessageDecoder implements ChannelOutboundHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SslClientHelloHandler.class);
    private ByteBuf handshakeBuffer;
    private boolean handshakeFailed;
    /* access modifiers changed from: private */
    public boolean readPending;
    /* access modifiers changed from: private */
    public boolean suppressRead;

    private void releaseHandshakeBuffer() {
        releaseIfNotNull(this.handshakeBuffer);
        this.handshakeBuffer = null;
    }

    /* access modifiers changed from: private */
    public static void releaseIfNotNull(ByteBuf byteBuf) {
        if (byteBuf != null) {
            byteBuf.release();
        }
    }

    private void select(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf) throws Exception {
        try {
            Future lookup = lookup(channelHandlerContext, byteBuf);
            if (lookup.isDone()) {
                onLookupComplete(channelHandlerContext, lookup);
            } else {
                this.suppressRead = true;
                lookup.addListener(new FutureListener<T>() {
                    public void operationComplete(Future<T> future) {
                        SslClientHelloHandler.releaseIfNotNull(byteBuf);
                        try {
                            boolean unused = SslClientHelloHandler.this.suppressRead = false;
                            SslClientHelloHandler.this.onLookupComplete(channelHandlerContext, future);
                        } catch (DecoderException e) {
                            channelHandlerContext.fireExceptionCaught(e);
                        } catch (Exception e2) {
                            channelHandlerContext.fireExceptionCaught(new DecoderException((Throwable) e2));
                        } catch (Throwable th) {
                            if (SslClientHelloHandler.this.readPending) {
                                boolean unused2 = SslClientHelloHandler.this.readPending = false;
                                channelHandlerContext.read();
                            }
                            throw th;
                        }
                        if (SslClientHelloHandler.this.readPending) {
                            boolean unused3 = SslClientHelloHandler.this.readPending = false;
                            channelHandlerContext.read();
                        }
                    }
                });
                byteBuf = null;
            }
        } catch (Throwable th) {
            releaseIfNotNull(byteBuf);
            throw th;
        }
        releaseIfNotNull(byteBuf);
    }

    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.close(channelPromise);
    }

    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (!this.suppressRead && !this.handshakeFailed) {
            try {
                int readerIndex = byteBuf.readerIndex();
                int readableBytes = byteBuf.readableBytes();
                int i = -1;
                while (readableBytes >= 5) {
                    switch (byteBuf.getUnsignedByte(readerIndex)) {
                        case 20:
                        case 21:
                            int encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBuf, readerIndex);
                            if (encryptedPacketLength == -2) {
                                this.handshakeFailed = true;
                                NotSslRecordException notSslRecordException = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf));
                                byteBuf.skipBytes(byteBuf.readableBytes());
                                channelHandlerContext.fireUserEventTriggered(new SniCompletionEvent((Throwable) notSslRecordException));
                                SslUtils.handleHandshakeFailure(channelHandlerContext, notSslRecordException, true);
                                throw notSslRecordException;
                            } else if (encryptedPacketLength != -1) {
                                select(channelHandlerContext, (ByteBuf) null);
                                return;
                            } else {
                                return;
                            }
                        case 22:
                            if (byteBuf.getUnsignedByte(readerIndex + 1) != 3) {
                                break;
                            } else {
                                int unsignedShort = byteBuf.getUnsignedShort(readerIndex + 3);
                                int i2 = unsignedShort + 5;
                                if (readableBytes >= i2) {
                                    if (i2 == 5) {
                                        select(channelHandlerContext, (ByteBuf) null);
                                        return;
                                    }
                                    int i3 = readerIndex + i2;
                                    if (i == -1) {
                                        int i4 = readerIndex + 4;
                                        if (i4 <= i3) {
                                            if (byteBuf.getUnsignedByte(readerIndex + 5) != 1) {
                                                select(channelHandlerContext, (ByteBuf) null);
                                                return;
                                            }
                                            int unsignedMedium = byteBuf.getUnsignedMedium(readerIndex + 6);
                                            i2 = unsignedShort + 1;
                                            if (unsignedMedium + 9 <= i2) {
                                                select(channelHandlerContext, byteBuf.retainedSlice(readerIndex + 9, unsignedMedium));
                                                return;
                                            }
                                            ByteBuf byteBuf2 = this.handshakeBuffer;
                                            if (byteBuf2 == null) {
                                                this.handshakeBuffer = channelHandlerContext.alloc().buffer(unsignedMedium);
                                            } else {
                                                byteBuf2.clear();
                                            }
                                            readerIndex = i4;
                                            i = unsignedMedium;
                                        } else {
                                            return;
                                        }
                                    }
                                    this.handshakeBuffer.writeBytes(byteBuf, readerIndex + 5, i2 - 5);
                                    readerIndex += i2;
                                    readableBytes -= i2;
                                    if (i <= this.handshakeBuffer.readableBytes()) {
                                        ByteBuf index = this.handshakeBuffer.setIndex(0, i);
                                        this.handshakeBuffer = null;
                                        select(channelHandlerContext, index);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                    }
                    select(channelHandlerContext, (ByteBuf) null);
                    return;
                }
            } catch (NotSslRecordException e) {
                throw e;
            } catch (Exception e2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("Unexpected client hello packet: " + ByteBufUtil.hexDump(byteBuf), (Throwable) e2);
                }
                select(channelHandlerContext, (ByteBuf) null);
            }
        }
    }

    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.deregister(channelPromise);
    }

    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.disconnect(channelPromise);
    }

    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.flush();
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
        releaseHandshakeBuffer();
        super.handlerRemoved0(channelHandlerContext);
    }

    public abstract Future<T> lookup(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception;

    public abstract void onLookupComplete(ChannelHandlerContext channelHandlerContext, Future<T> future) throws Exception;

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.suppressRead) {
            this.readPending = true;
        } else {
            channelHandlerContext.read();
        }
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        channelHandlerContext.write(obj, channelPromise);
    }
}
