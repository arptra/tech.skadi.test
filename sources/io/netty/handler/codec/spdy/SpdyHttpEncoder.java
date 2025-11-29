package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.UnsupportedMessageTypeException;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.spdy.SpdyHeaders;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jetty.util.URIUtil;

public class SpdyHttpEncoder extends MessageToMessageEncoder<HttpObject> {
    private int currentStreamId;
    private final boolean headersToLowerCase;
    private final boolean validateHeaders;

    public SpdyHttpEncoder(SpdyVersion spdyVersion) {
        this(spdyVersion, true, true);
    }

    private SpdyHeadersFrame createHeadersFrame(HttpResponse httpResponse) throws Exception {
        HttpHeaders headers = httpResponse.headers();
        AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
        int intValue = headers.getInt(asciiString).intValue();
        headers.remove((CharSequence) asciiString);
        headers.remove((CharSequence) HttpHeaderNames.CONNECTION);
        headers.remove("Keep-Alive");
        headers.remove("Proxy-Connection");
        headers.remove((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
        SpdyHeadersFrame defaultSpdyHeadersFrame = SpdyCodecUtil.isServerId(intValue) ? new DefaultSpdyHeadersFrame(intValue, this.validateHeaders) : new DefaultSpdySynReplyFrame(intValue, this.validateHeaders);
        SpdyHeaders headers2 = defaultSpdyHeadersFrame.headers();
        headers2.set(SpdyHeaders.HttpNames.STATUS, httpResponse.status().codeAsText());
        headers2.set(SpdyHeaders.HttpNames.VERSION, httpResponse.protocolVersion().text());
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = headers.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry next = iteratorCharSequence.next();
            defaultSpdyHeadersFrame.headers().add(this.headersToLowerCase ? AsciiString.of((CharSequence) next.getKey()).toLowerCase() : (CharSequence) next.getKey(), next.getValue());
        }
        this.currentStreamId = intValue;
        defaultSpdyHeadersFrame.setLast(isLast(httpResponse));
        return defaultSpdyHeadersFrame;
    }

    private SpdySynStreamFrame createSynStreamFrame(HttpRequest httpRequest) throws Exception {
        HttpHeaders headers = httpRequest.headers();
        AsciiString asciiString = SpdyHttpHeaders.Names.STREAM_ID;
        int intValue = headers.getInt(asciiString).intValue();
        AsciiString asciiString2 = SpdyHttpHeaders.Names.ASSOCIATED_TO_STREAM_ID;
        int i = headers.getInt(asciiString2, 0);
        AsciiString asciiString3 = SpdyHttpHeaders.Names.PRIORITY;
        AsciiString asciiString4 = SpdyHttpHeaders.Names.SCHEME;
        String str = headers.get((CharSequence) asciiString4);
        headers.remove((CharSequence) asciiString);
        headers.remove((CharSequence) asciiString2);
        headers.remove((CharSequence) asciiString3);
        headers.remove((CharSequence) asciiString4);
        headers.remove((CharSequence) HttpHeaderNames.CONNECTION);
        headers.remove("Keep-Alive");
        headers.remove("Proxy-Connection");
        headers.remove((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
        DefaultSpdySynStreamFrame defaultSpdySynStreamFrame = new DefaultSpdySynStreamFrame(intValue, i, (byte) headers.getInt(asciiString3, 0), this.validateHeaders);
        SpdyHeaders headers2 = defaultSpdySynStreamFrame.headers();
        headers2.set(SpdyHeaders.HttpNames.METHOD, httpRequest.method().name());
        headers2.set(SpdyHeaders.HttpNames.PATH, httpRequest.uri());
        headers2.set(SpdyHeaders.HttpNames.VERSION, httpRequest.protocolVersion().text());
        AsciiString asciiString5 = HttpHeaderNames.HOST;
        String str2 = headers.get((CharSequence) asciiString5);
        headers.remove((CharSequence) asciiString5);
        headers2.set(SpdyHeaders.HttpNames.HOST, str2);
        if (str == null) {
            str = URIUtil.HTTPS;
        }
        headers2.set(SpdyHeaders.HttpNames.SCHEME, str);
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = headers.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry next = iteratorCharSequence.next();
            headers2.add(this.headersToLowerCase ? AsciiString.of((CharSequence) next.getKey()).toLowerCase() : (CharSequence) next.getKey(), next.getValue());
        }
        this.currentStreamId = defaultSpdySynStreamFrame.streamId();
        if (i == 0) {
            defaultSpdySynStreamFrame.setLast(isLast(httpRequest));
        } else {
            defaultSpdySynStreamFrame.setUnidirectional(true);
        }
        return defaultSpdySynStreamFrame;
    }

    private static boolean isLast(HttpMessage httpMessage) {
        if (!(httpMessage instanceof FullHttpMessage)) {
            return false;
        }
        FullHttpMessage fullHttpMessage = (FullHttpMessage) httpMessage;
        return fullHttpMessage.trailingHeaders().isEmpty() && !fullHttpMessage.content().isReadable();
    }

    public SpdyHttpEncoder(SpdyVersion spdyVersion, boolean z, boolean z2) {
        ObjectUtil.checkNotNull(spdyVersion, "version");
        this.headersToLowerCase = z;
        this.validateHeaders = z2;
    }

    public void encode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (httpObject instanceof HttpRequest) {
            SpdySynStreamFrame createSynStreamFrame = createSynStreamFrame((HttpRequest) httpObject);
            list.add(createSynStreamFrame);
            z = createSynStreamFrame.isLast() || createSynStreamFrame.isUnidirectional();
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        if (httpObject instanceof HttpResponse) {
            SpdyHeadersFrame createHeadersFrame = createHeadersFrame((HttpResponse) httpObject);
            list.add(createHeadersFrame);
            z = createHeadersFrame.isLast();
            z2 = true;
        }
        if (!(httpObject instanceof HttpContent) || z) {
            z3 = z2;
        } else {
            HttpContent httpContent = (HttpContent) httpObject;
            httpContent.content().retain();
            DefaultSpdyDataFrame defaultSpdyDataFrame = new DefaultSpdyDataFrame(this.currentStreamId, httpContent.content());
            if (httpContent instanceof LastHttpContent) {
                HttpHeaders trailingHeaders = ((LastHttpContent) httpContent).trailingHeaders();
                if (trailingHeaders.isEmpty()) {
                    defaultSpdyDataFrame.setLast(true);
                    list.add(defaultSpdyDataFrame);
                } else {
                    DefaultSpdyHeadersFrame defaultSpdyHeadersFrame = new DefaultSpdyHeadersFrame(this.currentStreamId, this.validateHeaders);
                    defaultSpdyHeadersFrame.setLast(true);
                    Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = trailingHeaders.iteratorCharSequence();
                    while (iteratorCharSequence.hasNext()) {
                        Map.Entry next = iteratorCharSequence.next();
                        defaultSpdyHeadersFrame.headers().add(this.headersToLowerCase ? AsciiString.of((CharSequence) next.getKey()).toLowerCase() : (CharSequence) next.getKey(), next.getValue());
                    }
                    list.add(defaultSpdyDataFrame);
                    list.add(defaultSpdyHeadersFrame);
                }
            } else {
                list.add(defaultSpdyDataFrame);
            }
        }
        if (!z3) {
            throw new UnsupportedMessageTypeException((Object) httpObject, (Class<?>[]) new Class[0]);
        }
    }
}
