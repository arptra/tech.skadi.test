package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.PromiseCombiner;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class HttpObjectEncoder<H extends HttpMessage> extends MessageToMessageEncoder<Object> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ByteBuf CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2).writeByte(13).writeByte(10)).asReadOnly();
    static final int CRLF_SHORT = 3338;
    private static final float HEADERS_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_WEIGHT_NEW = 0.2f;
    private static final int ST_CONTENT_ALWAYS_EMPTY = 3;
    private static final int ST_CONTENT_CHUNK = 2;
    private static final int ST_CONTENT_NON_CHUNK = 1;
    private static final int ST_INIT = 0;
    private static final float TRAILERS_WEIGHT_HISTORICAL = 0.8f;
    private static final float TRAILERS_WEIGHT_NEW = 0.2f;
    private static final byte[] ZERO_CRLF_CRLF;
    private static final ByteBuf ZERO_CRLF_CRLF_BUF;
    private static final int ZERO_CRLF_MEDIUM = 3149066;
    private float headersEncodedSizeAccumulator = 256.0f;
    private final List<Object> out = new ArrayList();
    private int state = 0;
    private float trailersEncodedSizeAccumulator = 256.0f;

    static {
        byte[] bArr = {48, 13, 10, 13, 10};
        ZERO_CRLF_CRLF = bArr;
        ZERO_CRLF_CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(bArr.length).writeBytes(bArr)).asReadOnly();
    }

    private static void addEncodedLengthHex(ChannelHandlerContext channelHandlerContext, long j, List<Object> list) {
        String hexString = Long.toHexString(j);
        ByteBuf buffer = channelHandlerContext.alloc().buffer(hexString.length() + 2);
        buffer.writeCharSequence(hexString, CharsetUtil.US_ASCII);
        ByteBufUtil.writeShortBE(buffer, CRLF_SHORT);
        list.add(buffer);
    }

    private static boolean bypassEncoderIfEmpty(ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.isReadable()) {
            return false;
        }
        list.add(byteBuf.retain());
        return true;
    }

    private static boolean checkContentState(int i) {
        return i == 2 || i == 1 || i == 3;
    }

    @Deprecated
    public static void encodeAscii(String str, ByteBuf byteBuf) {
        byteBuf.writeCharSequence(str, CharsetUtil.US_ASCII);
    }

    private void encodeByteBufAndTrailers(int i, ChannelHandlerContext channelHandlerContext, List<Object> list, ByteBuf byteBuf, HttpHeaders httpHeaders) {
        if (i != 1) {
            if (i == 2) {
                encodeChunkedHttpContent(channelHandlerContext, byteBuf, httpHeaders, list);
                return;
            } else if (i != 3) {
                throw new Error();
            }
        } else if (byteBuf.isReadable()) {
            list.add(byteBuf.retain());
            return;
        }
        list.add(Unpooled.EMPTY_BUFFER);
    }

    private void encodeByteBufContent(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        try {
            if (!bypassEncoderIfEmpty(byteBuf, list)) {
                encodeByteBufAndTrailers(this.state, channelHandlerContext, list, byteBuf, (HttpHeaders) null);
                byteBuf.release();
            }
        } finally {
            byteBuf.release();
        }
    }

    private void encodeByteBufHttpContent(int i, ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2, HttpHeaders httpHeaders, List<Object> list) {
        if (i != 1) {
            if (i == 2) {
                list.add(byteBuf);
                encodeChunkedHttpContent(channelHandlerContext, byteBuf2, httpHeaders, list);
                return;
            } else if (i != 3) {
                throw new Error();
            }
        } else if (encodeContentNonChunk(list, byteBuf, byteBuf2)) {
            return;
        }
        list.add(byteBuf);
    }

    private void encodeChunkedHttpContent(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, HttpHeaders httpHeaders, List<Object> list) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes > 0) {
            addEncodedLengthHex(channelHandlerContext, (long) readableBytes, list);
            list.add(byteBuf.retain());
            list.add(CRLF_BUF.duplicate());
        }
        if (httpHeaders != null) {
            encodeTrailingHeaders(channelHandlerContext, httpHeaders, list);
        } else if (readableBytes == 0) {
            list.add(byteBuf.retain());
        }
    }

    private static boolean encodeContentNonChunk(List<Object> list, ByteBuf byteBuf, ByteBuf byteBuf2) {
        int readableBytes = byteBuf2.readableBytes();
        if (readableBytes <= 0) {
            return false;
        }
        if (byteBuf.writableBytes() >= readableBytes) {
            byteBuf.writeBytes(byteBuf2);
            list.add(byteBuf);
            return true;
        }
        list.add(byteBuf);
        list.add(byteBuf2.retain());
        return true;
    }

    private static int encodeEmptyLastHttpContent(int i, List<Object> list) {
        if (i != 1) {
            if (i == 2) {
                list.add(ZERO_CRLF_CRLF_BUF.duplicate());
                return 0;
            } else if (i != 3) {
                throw new Error();
            }
        }
        list.add(Unpooled.EMPTY_BUFFER);
        return 0;
    }

    private void encodeFileRegionContent(ChannelHandlerContext channelHandlerContext, FileRegion fileRegion, List<Object> list) {
        try {
            int i = this.state;
            if (i != 1) {
                if (i == 2) {
                    encodedChunkedFileRegionContent(channelHandlerContext, fileRegion, list);
                } else if (i != 3) {
                    throw new Error();
                }
            } else if (fileRegion.count() > 0) {
                list.add(fileRegion.retain());
            }
            list.add(Unpooled.EMPTY_BUFFER);
        } finally {
            fileRegion.release();
        }
    }

    private void encodeFullHttpMessage(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        FullHttpMessage fullHttpMessage = (FullHttpMessage) obj;
        try {
            int i = this.state;
            if (i != 0) {
                throwUnexpectedMessageTypeEx(obj, i);
            }
            HttpMessage httpMessage = (HttpMessage) obj;
            ByteBuf buffer = channelHandlerContext.alloc().buffer((int) this.headersEncodedSizeAccumulator);
            encodeInitialLine(buffer, httpMessage);
            boolean z = true;
            int i2 = isContentAlwaysEmpty(httpMessage) ? 3 : HttpUtil.isTransferEncodingChunked(httpMessage) ? 2 : 1;
            if (i2 != 3) {
                z = false;
            }
            sanitizeHeadersBeforeEncode(httpMessage, z);
            encodeHeaders(httpMessage.headers(), buffer);
            ByteBufUtil.writeShortBE(buffer, CRLF_SHORT);
            this.headersEncodedSizeAccumulator = (((float) padSizeForAccumulation(buffer.readableBytes())) * 0.2f) + (this.headersEncodedSizeAccumulator * 0.8f);
            encodeByteBufHttpContent(i2, channelHandlerContext, buffer, fullHttpMessage.content(), fullHttpMessage.trailingHeaders(), list);
            fullHttpMessage.release();
        } catch (Throwable th) {
            fullHttpMessage.release();
            throw th;
        }
    }

    private void encodeHttpContent(ChannelHandlerContext channelHandlerContext, HttpContent httpContent, List<Object> list) {
        try {
            encodeByteBufAndTrailers(this.state, channelHandlerContext, list, httpContent.content(), (HttpHeaders) null);
        } finally {
            httpContent.release();
        }
    }

    private void encodeHttpMessageLastContent(ChannelHandlerContext channelHandlerContext, H h, List<Object> list) throws Exception {
        LastHttpContent lastHttpContent = (LastHttpContent) h;
        try {
            int i = this.state;
            if (i != 0) {
                throwUnexpectedMessageTypeEx(h, i);
            }
            ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
            encodeByteBufHttpContent(this.state, channelHandlerContext2, encodeInitHttpMessage(channelHandlerContext, h), lastHttpContent.content(), lastHttpContent.trailingHeaders(), list);
            this.state = 0;
            lastHttpContent.release();
        } catch (Throwable th) {
            lastHttpContent.release();
            throw th;
        }
    }

    private void encodeHttpMessageNotLastContent(ChannelHandlerContext channelHandlerContext, H h, List<Object> list) throws Exception {
        HttpContent httpContent = (HttpContent) h;
        try {
            int i = this.state;
            if (i != 0) {
                throwUnexpectedMessageTypeEx(h, i);
            }
            ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
            encodeByteBufHttpContent(this.state, channelHandlerContext2, encodeInitHttpMessage(channelHandlerContext, h), httpContent.content(), (HttpHeaders) null, list);
            httpContent.release();
        } catch (Throwable th) {
            httpContent.release();
            throw th;
        }
    }

    private ByteBuf encodeInitHttpMessage(ChannelHandlerContext channelHandlerContext, H h) throws Exception {
        ByteBuf buffer = channelHandlerContext.alloc().buffer((int) this.headersEncodedSizeAccumulator);
        encodeInitialLine(buffer, h);
        boolean z = true;
        int i = isContentAlwaysEmpty(h) ? 3 : HttpUtil.isTransferEncodingChunked(h) ? 2 : 1;
        this.state = i;
        if (i != 3) {
            z = false;
        }
        sanitizeHeadersBeforeEncode(h, z);
        encodeHeaders(h.headers(), buffer);
        ByteBufUtil.writeShortBE(buffer, CRLF_SHORT);
        this.headersEncodedSizeAccumulator = (((float) padSizeForAccumulation(buffer.readableBytes())) * 0.2f) + (this.headersEncodedSizeAccumulator * 0.8f);
        return buffer;
    }

    private void encodeJustHttpMessage(ChannelHandlerContext channelHandlerContext, H h, List<Object> list) throws Exception {
        try {
            int i = this.state;
            if (i != 0) {
                throwUnexpectedMessageTypeEx(h, i);
            }
            list.add(encodeInitHttpMessage(channelHandlerContext, h));
            ReferenceCountUtil.release(h);
        } catch (Throwable th) {
            ReferenceCountUtil.release(h);
            throw th;
        }
    }

    private void encodeLastHttpContent(ChannelHandlerContext channelHandlerContext, LastHttpContent lastHttpContent, List<Object> list) {
        try {
            encodeByteBufAndTrailers(this.state, channelHandlerContext, list, lastHttpContent.content(), lastHttpContent.trailingHeaders());
            this.state = 0;
        } finally {
            lastHttpContent.release();
        }
    }

    private void encodeNotHttpMessageContentTypes(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) {
        if (this.state == 0) {
            try {
                if (!(obj instanceof ByteBuf) || !bypassEncoderIfEmpty((ByteBuf) obj, list)) {
                    throwUnexpectedMessageTypeEx(obj, 0);
                    ReferenceCountUtil.release(obj);
                } else {
                    return;
                }
            } finally {
                ReferenceCountUtil.release(obj);
            }
        }
        if (obj == LastHttpContent.EMPTY_LAST_CONTENT) {
            this.state = encodeEmptyLastHttpContent(this.state, list);
        } else if (obj instanceof LastHttpContent) {
            encodeLastHttpContent(channelHandlerContext, (LastHttpContent) obj, list);
        } else if (obj instanceof HttpContent) {
            encodeHttpContent(channelHandlerContext, (HttpContent) obj, list);
        } else if (obj instanceof ByteBuf) {
            encodeByteBufContent(channelHandlerContext, (ByteBuf) obj, list);
        } else if (obj instanceof FileRegion) {
            encodeFileRegionContent(channelHandlerContext, (FileRegion) obj, list);
        } else {
            try {
                throwUnexpectedMessageTypeEx(obj, this.state);
            } finally {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    private void encodeTrailingHeaders(ChannelHandlerContext channelHandlerContext, HttpHeaders httpHeaders, List<Object> list) {
        if (httpHeaders.isEmpty()) {
            list.add(ZERO_CRLF_CRLF_BUF.duplicate());
            return;
        }
        ByteBuf buffer = channelHandlerContext.alloc().buffer((int) this.trailersEncodedSizeAccumulator);
        ByteBufUtil.writeMediumBE(buffer, ZERO_CRLF_MEDIUM);
        encodeHeaders(httpHeaders, buffer);
        ByteBufUtil.writeShortBE(buffer, CRLF_SHORT);
        this.trailersEncodedSizeAccumulator = (((float) padSizeForAccumulation(buffer.readableBytes())) * 0.2f) + (this.trailersEncodedSizeAccumulator * 0.8f);
        list.add(buffer);
    }

    private static void encodedChunkedFileRegionContent(ChannelHandlerContext channelHandlerContext, FileRegion fileRegion, List<Object> list) {
        long count = fileRegion.count();
        int i = (count > 0 ? 1 : (count == 0 ? 0 : -1));
        if (i > 0) {
            addEncodedLengthHex(channelHandlerContext, count, list);
            list.add(fileRegion.retain());
            list.add(CRLF_BUF.duplicate());
        } else if (i == 0) {
            list.add(fileRegion.retain());
        }
    }

    private static int padSizeForAccumulation(int i) {
        return (i << 2) / 3;
    }

    private static void throwUnexpectedMessageTypeEx(Object obj, int i) {
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj) + ", state: " + i);
    }

    private static void writeOutList(ChannelHandlerContext channelHandlerContext, List<Object> list, ChannelPromise channelPromise) {
        int size = list.size();
        if (size == 1) {
            try {
                channelHandlerContext.write(list.get(0), channelPromise);
            } finally {
                list.clear();
            }
        } else if (size > 1) {
            if (channelPromise == channelHandlerContext.voidPromise()) {
                writeVoidPromise(channelHandlerContext, list);
            } else {
                writePromiseCombiner(channelHandlerContext, list, channelPromise);
            }
        }
    }

    private static void writePromiseCombiner(ChannelHandlerContext channelHandlerContext, List<Object> list, ChannelPromise channelPromise) {
        PromiseCombiner promiseCombiner = new PromiseCombiner(channelHandlerContext.executor());
        for (int i = 0; i < list.size(); i++) {
            promiseCombiner.add((Future) channelHandlerContext.write(list.get(i)));
        }
        promiseCombiner.finish(channelPromise);
    }

    private static void writeVoidPromise(ChannelHandlerContext channelHandlerContext, List<Object> list) {
        ChannelPromise voidPromise = channelHandlerContext.voidPromise();
        for (int i = 0; i < list.size(); i++) {
            channelHandlerContext.write(list.get(i), voidPromise);
        }
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return obj == Unpooled.EMPTY_BUFFER || obj == LastHttpContent.EMPTY_LAST_CONTENT || (obj instanceof FullHttpMessage) || (obj instanceof HttpMessage) || (obj instanceof LastHttpContent) || (obj instanceof HttpContent) || (obj instanceof ByteBuf) || (obj instanceof FileRegion);
    }

    public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
        ByteBuf byteBuf = Unpooled.EMPTY_BUFFER;
        if (obj == byteBuf) {
            list.add(byteBuf);
        } else if (obj instanceof FullHttpMessage) {
            encodeFullHttpMessage(channelHandlerContext, obj, list);
        } else if (obj instanceof HttpMessage) {
            try {
                HttpMessage httpMessage = (HttpMessage) obj;
                if (httpMessage instanceof LastHttpContent) {
                    encodeHttpMessageLastContent(channelHandlerContext, httpMessage, list);
                } else if (httpMessage instanceof HttpContent) {
                    encodeHttpMessageNotLastContent(channelHandlerContext, httpMessage, list);
                }
                encodeJustHttpMessage(channelHandlerContext, httpMessage, list);
            } catch (Exception e) {
                ReferenceCountUtil.release(obj);
                throw e;
            }
        } else {
            encodeNotHttpMessageContentTypes(channelHandlerContext, obj, list);
        }
    }

    public void encodeHeaders(HttpHeaders httpHeaders, ByteBuf byteBuf) {
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry next = iteratorCharSequence.next();
            HttpHeadersEncoder.encoderHeader((CharSequence) next.getKey(), (CharSequence) next.getValue(), byteBuf);
        }
    }

    public abstract void encodeInitialLine(ByteBuf byteBuf, H h) throws Exception;

    public boolean isContentAlwaysEmpty(H h) {
        return false;
    }

    public void sanitizeHeadersBeforeEncode(H h, boolean z) {
    }

    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        try {
            if (acceptOutboundMessage(obj)) {
                encode(channelHandlerContext, obj, this.out);
                if (this.out.isEmpty()) {
                    throw new EncoderException(StringUtil.simpleClassName((Object) this) + " must produce at least one message.");
                }
            } else {
                channelHandlerContext.write(obj, channelPromise);
            }
            writeOutList(channelHandlerContext, this.out, channelPromise);
        } catch (EncoderException e) {
            throw e;
        } catch (Throwable th) {
            writeOutList(channelHandlerContext, this.out, channelPromise);
            throw th;
        }
    }
}
