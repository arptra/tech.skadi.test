package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.stream.ChunkedInput;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;

public class HttpPostRequestEncoder implements ChunkedInput<HttpContent> {
    private static final Map.Entry[] percentEncodings = {new AbstractMap.SimpleImmutableEntry(Pattern.compile("\\*"), "%2A"), new AbstractMap.SimpleImmutableEntry(Pattern.compile("\\+"), "%20"), new AbstractMap.SimpleImmutableEntry(Pattern.compile("~"), "%7E")};
    private final List<InterfaceHttpData> bodyListDatas;
    private final Charset charset;
    private ByteBuf currentBuffer;
    private InterfaceHttpData currentData;
    private FileUpload currentFileUpload;
    private boolean duringMixedMode;
    private final EncoderMode encoderMode;
    private final HttpDataFactory factory;
    private long globalBodySize;
    private long globalProgress;
    private boolean headerFinalized;
    private boolean isChunked;
    private boolean isKey;
    private boolean isLastChunk;
    private boolean isLastChunkSent;
    private final boolean isMultipart;
    private ListIterator<InterfaceHttpData> iterator;
    String multipartDataBoundary;
    final List<InterfaceHttpData> multipartHttpDatas;
    String multipartMixedBoundary;
    private final HttpRequest request;

    public enum EncoderMode {
        RFC1738,
        RFC3986,
        HTML5
    }

    public static class ErrorDataEncoderException extends Exception {
        private static final long serialVersionUID = 5020247425493164465L;

        public ErrorDataEncoderException() {
        }

        public ErrorDataEncoderException(String str) {
            super(str);
        }

        public ErrorDataEncoderException(Throwable th) {
            super(th);
        }

        public ErrorDataEncoderException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static final class WrappedFullHttpRequest extends WrappedHttpRequest implements FullHttpRequest {
        private final HttpContent content;

        public ByteBuf content() {
            return this.content.content();
        }

        public int refCnt() {
            return this.content.refCnt();
        }

        public boolean release() {
            return this.content.release();
        }

        public HttpHeaders trailingHeaders() {
            HttpContent httpContent = this.content;
            return httpContent instanceof LastHttpContent ? ((LastHttpContent) httpContent).trailingHeaders() : EmptyHttpHeaders.INSTANCE;
        }

        private WrappedFullHttpRequest(HttpRequest httpRequest, HttpContent httpContent) {
            super(httpRequest);
            this.content = httpContent;
        }

        public boolean release(int i) {
            return this.content.release(i);
        }

        public FullHttpRequest setMethod(HttpMethod httpMethod) {
            super.setMethod(httpMethod);
            return this;
        }

        public FullHttpRequest setUri(String str) {
            super.setUri(str);
            return this;
        }

        public FullHttpRequest setProtocolVersion(HttpVersion httpVersion) {
            super.setProtocolVersion(httpVersion);
            return this;
        }

        public FullHttpRequest copy() {
            return replace(content().copy());
        }

        public FullHttpRequest duplicate() {
            return replace(content().duplicate());
        }

        public FullHttpRequest replace(ByteBuf byteBuf) {
            DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(protocolVersion(), method(), uri(), byteBuf);
            defaultFullHttpRequest.headers().set(headers());
            defaultFullHttpRequest.trailingHeaders().set(trailingHeaders());
            return defaultFullHttpRequest;
        }

        public FullHttpRequest retainedDuplicate() {
            return replace(content().retainedDuplicate());
        }

        public FullHttpRequest retain(int i) {
            this.content.retain(i);
            return this;
        }

        public FullHttpRequest touch() {
            this.content.touch();
            return this;
        }

        public FullHttpRequest retain() {
            this.content.retain();
            return this;
        }

        public FullHttpRequest touch(Object obj) {
            this.content.touch(obj);
            return this;
        }
    }

    public static class WrappedHttpRequest implements HttpRequest {
        private final HttpRequest request;

        public WrappedHttpRequest(HttpRequest httpRequest) {
            this.request = httpRequest;
        }

        public DecoderResult decoderResult() {
            return this.request.decoderResult();
        }

        @Deprecated
        public DecoderResult getDecoderResult() {
            return this.request.getDecoderResult();
        }

        public HttpMethod getMethod() {
            return this.request.method();
        }

        public HttpVersion getProtocolVersion() {
            return this.request.protocolVersion();
        }

        public String getUri() {
            return this.request.uri();
        }

        public HttpHeaders headers() {
            return this.request.headers();
        }

        public HttpMethod method() {
            return this.request.method();
        }

        public HttpVersion protocolVersion() {
            return this.request.protocolVersion();
        }

        public void setDecoderResult(DecoderResult decoderResult) {
            this.request.setDecoderResult(decoderResult);
        }

        public HttpRequest setMethod(HttpMethod httpMethod) {
            this.request.setMethod(httpMethod);
            return this;
        }

        public HttpRequest setUri(String str) {
            this.request.setUri(str);
            return this;
        }

        public String uri() {
            return this.request.uri();
        }

        public HttpRequest setProtocolVersion(HttpVersion httpVersion) {
            this.request.setProtocolVersion(httpVersion);
            return this;
        }
    }

    public HttpPostRequestEncoder(HttpRequest httpRequest, boolean z) throws ErrorDataEncoderException {
        this(new DefaultHttpDataFactory(16384), httpRequest, z, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
    }

    private int calculateRemainingSize() {
        ByteBuf byteBuf = this.currentBuffer;
        return byteBuf != null ? HttpPostBodyUtil.chunkSize - byteBuf.readableBytes() : HttpPostBodyUtil.chunkSize;
    }

    private String encodeAttribute(String str, Charset charset2) throws ErrorDataEncoderException {
        if (str == null) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, charset2.name());
            if (this.encoderMode == EncoderMode.RFC3986) {
                for (Map.Entry entry : percentEncodings) {
                    encode = ((Pattern) entry.getKey()).matcher(encode).replaceAll((String) entry.getValue());
                }
            }
            return encode;
        } catch (UnsupportedEncodingException e) {
            throw new ErrorDataEncoderException(charset2.name(), e);
        }
    }

    private HttpContent encodeNextChunkMultipart(int i) throws ErrorDataEncoderException {
        ByteBuf byteBuf;
        InterfaceHttpData interfaceHttpData = this.currentData;
        if (interfaceHttpData == null) {
            return null;
        }
        if (interfaceHttpData instanceof InternalAttribute) {
            byteBuf = ((InternalAttribute) interfaceHttpData).toByteBuf();
            this.currentData = null;
        } else {
            try {
                byteBuf = ((HttpData) interfaceHttpData).getChunk(i);
                if (byteBuf.capacity() == 0) {
                    this.currentData = null;
                    return null;
                }
            } catch (IOException e) {
                throw new ErrorDataEncoderException((Throwable) e);
            }
        }
        ByteBuf byteBuf2 = this.currentBuffer;
        if (byteBuf2 == null) {
            this.currentBuffer = byteBuf;
        } else {
            this.currentBuffer = Unpooled.wrappedBuffer(byteBuf2, byteBuf);
        }
        if (this.currentBuffer.readableBytes() >= 8096) {
            return new DefaultHttpContent(fillByteBuf());
        }
        this.currentData = null;
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.netty.handler.codec.http.HttpContent encodeNextChunkUrlEncoded(int r8) throws io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.ErrorDataEncoderException {
        /*
            r7 = this;
            io.netty.handler.codec.http.multipart.InterfaceHttpData r0 = r7.currentData
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r2 = r7.isKey
            r3 = 8096(0x1fa0, float:1.1345E-41)
            r4 = 1
            if (r2 == 0) goto L_0x0065
            java.lang.String r0 = r0.getName()
            java.nio.charset.Charset r2 = r7.charset
            byte[] r0 = r0.getBytes(r2)
            io.netty.buffer.ByteBuf r0 = io.netty.buffer.Unpooled.wrappedBuffer((byte[]) r0)
            r2 = 0
            r7.isKey = r2
            io.netty.buffer.ByteBuf r2 = r7.currentBuffer
            java.lang.String r5 = "="
            if (r2 != 0) goto L_0x0039
            java.nio.charset.Charset r2 = r7.charset
            byte[] r2 = r5.getBytes(r2)
            io.netty.buffer.ByteBuf r2 = io.netty.buffer.Unpooled.wrappedBuffer((byte[]) r2)
            io.netty.buffer.ByteBuf[] r2 = new io.netty.buffer.ByteBuf[]{r0, r2}
            io.netty.buffer.ByteBuf r2 = io.netty.buffer.Unpooled.wrappedBuffer((io.netty.buffer.ByteBuf[]) r2)
            r7.currentBuffer = r2
            goto L_0x004d
        L_0x0039:
            java.nio.charset.Charset r6 = r7.charset
            byte[] r5 = r5.getBytes(r6)
            io.netty.buffer.ByteBuf r5 = io.netty.buffer.Unpooled.wrappedBuffer((byte[]) r5)
            io.netty.buffer.ByteBuf[] r2 = new io.netty.buffer.ByteBuf[]{r2, r0, r5}
            io.netty.buffer.ByteBuf r2 = io.netty.buffer.Unpooled.wrappedBuffer((io.netty.buffer.ByteBuf[]) r2)
            r7.currentBuffer = r2
        L_0x004d:
            int r0 = r0.readableBytes()
            int r0 = r0 + r4
            int r8 = r8 - r0
            io.netty.buffer.ByteBuf r0 = r7.currentBuffer
            int r0 = r0.readableBytes()
            if (r0 < r3) goto L_0x0065
            io.netty.buffer.ByteBuf r7 = r7.fillByteBuf()
            io.netty.handler.codec.http.DefaultHttpContent r8 = new io.netty.handler.codec.http.DefaultHttpContent
            r8.<init>(r7)
            return r8
        L_0x0065:
            io.netty.handler.codec.http.multipart.InterfaceHttpData r0 = r7.currentData     // Catch:{ IOException -> 0x00fe }
            io.netty.handler.codec.http.multipart.HttpData r0 = (io.netty.handler.codec.http.multipart.HttpData) r0     // Catch:{ IOException -> 0x00fe }
            io.netty.buffer.ByteBuf r0 = r0.getChunk(r8)     // Catch:{ IOException -> 0x00fe }
            int r2 = r0.readableBytes()
            if (r2 >= r8) goto L_0x008a
            r7.isKey = r4
            java.util.ListIterator<io.netty.handler.codec.http.multipart.InterfaceHttpData> r8 = r7.iterator
            boolean r8 = r8.hasNext()
            if (r8 == 0) goto L_0x008a
            java.lang.String r8 = "&"
            java.nio.charset.Charset r2 = r7.charset
            byte[] r8 = r8.getBytes(r2)
            io.netty.buffer.ByteBuf r8 = io.netty.buffer.Unpooled.wrappedBuffer((byte[]) r8)
            goto L_0x008b
        L_0x008a:
            r8 = r1
        L_0x008b:
            int r2 = r0.capacity()
            if (r2 != 0) goto L_0x00bc
            r7.currentData = r1
            io.netty.buffer.ByteBuf r0 = r7.currentBuffer
            if (r0 != 0) goto L_0x009d
            if (r8 != 0) goto L_0x009a
            return r1
        L_0x009a:
            r7.currentBuffer = r8
            goto L_0x00a9
        L_0x009d:
            if (r8 == 0) goto L_0x00a9
            io.netty.buffer.ByteBuf[] r8 = new io.netty.buffer.ByteBuf[]{r0, r8}
            io.netty.buffer.ByteBuf r8 = io.netty.buffer.Unpooled.wrappedBuffer((io.netty.buffer.ByteBuf[]) r8)
            r7.currentBuffer = r8
        L_0x00a9:
            io.netty.buffer.ByteBuf r8 = r7.currentBuffer
            int r8 = r8.readableBytes()
            if (r8 < r3) goto L_0x00bb
            io.netty.buffer.ByteBuf r7 = r7.fillByteBuf()
            io.netty.handler.codec.http.DefaultHttpContent r8 = new io.netty.handler.codec.http.DefaultHttpContent
            r8.<init>(r7)
            return r8
        L_0x00bb:
            return r1
        L_0x00bc:
            io.netty.buffer.ByteBuf r2 = r7.currentBuffer
            if (r2 != 0) goto L_0x00d0
            if (r8 == 0) goto L_0x00cd
            io.netty.buffer.ByteBuf[] r8 = new io.netty.buffer.ByteBuf[]{r0, r8}
            io.netty.buffer.ByteBuf r8 = io.netty.buffer.Unpooled.wrappedBuffer((io.netty.buffer.ByteBuf[]) r8)
            r7.currentBuffer = r8
            goto L_0x00e7
        L_0x00cd:
            r7.currentBuffer = r0
            goto L_0x00e7
        L_0x00d0:
            if (r8 == 0) goto L_0x00dd
            io.netty.buffer.ByteBuf[] r8 = new io.netty.buffer.ByteBuf[]{r2, r0, r8}
            io.netty.buffer.ByteBuf r8 = io.netty.buffer.Unpooled.wrappedBuffer((io.netty.buffer.ByteBuf[]) r8)
            r7.currentBuffer = r8
            goto L_0x00e7
        L_0x00dd:
            io.netty.buffer.ByteBuf[] r8 = new io.netty.buffer.ByteBuf[]{r2, r0}
            io.netty.buffer.ByteBuf r8 = io.netty.buffer.Unpooled.wrappedBuffer((io.netty.buffer.ByteBuf[]) r8)
            r7.currentBuffer = r8
        L_0x00e7:
            io.netty.buffer.ByteBuf r8 = r7.currentBuffer
            int r8 = r8.readableBytes()
            if (r8 >= r3) goto L_0x00f4
            r7.currentData = r1
            r7.isKey = r4
            return r1
        L_0x00f4:
            io.netty.buffer.ByteBuf r7 = r7.fillByteBuf()
            io.netty.handler.codec.http.DefaultHttpContent r8 = new io.netty.handler.codec.http.DefaultHttpContent
            r8.<init>(r7)
            return r8
        L_0x00fe:
            r7 = move-exception
            io.netty.handler.codec.http.multipart.HttpPostRequestEncoder$ErrorDataEncoderException r8 = new io.netty.handler.codec.http.multipart.HttpPostRequestEncoder$ErrorDataEncoderException
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostRequestEncoder.encodeNextChunkUrlEncoded(int):io.netty.handler.codec.http.HttpContent");
    }

    private ByteBuf fillByteBuf() {
        if (this.currentBuffer.readableBytes() > 8096) {
            return this.currentBuffer.readRetainedSlice(HttpPostBodyUtil.chunkSize);
        }
        ByteBuf byteBuf = this.currentBuffer;
        this.currentBuffer = null;
        return byteBuf;
    }

    private static String getNewMultipartDelimiter() {
        return Long.toHexString(PlatformDependent.threadLocalRandom().nextLong());
    }

    private void initDataMultipart() {
        this.multipartDataBoundary = getNewMultipartDelimiter();
    }

    private void initMixedMultipart() {
        this.multipartMixedBoundary = getNewMultipartDelimiter();
    }

    private HttpContent lastChunk() {
        this.isLastChunk = true;
        ByteBuf byteBuf = this.currentBuffer;
        if (byteBuf == null) {
            this.isLastChunkSent = true;
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        this.currentBuffer = null;
        return new DefaultHttpContent(byteBuf);
    }

    private HttpContent nextChunk() throws ErrorDataEncoderException {
        if (this.isLastChunk) {
            this.isLastChunkSent = true;
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        int calculateRemainingSize = calculateRemainingSize();
        if (calculateRemainingSize <= 0) {
            return new DefaultHttpContent(fillByteBuf());
        }
        if (this.currentData != null) {
            HttpContent encodeNextChunkMultipart = this.isMultipart ? encodeNextChunkMultipart(calculateRemainingSize) : encodeNextChunkUrlEncoded(calculateRemainingSize);
            if (encodeNextChunkMultipart != null) {
                return encodeNextChunkMultipart;
            }
            calculateRemainingSize = calculateRemainingSize();
        }
        if (!this.iterator.hasNext()) {
            return lastChunk();
        }
        while (calculateRemainingSize > 0 && this.iterator.hasNext()) {
            this.currentData = this.iterator.next();
            HttpContent encodeNextChunkMultipart2 = this.isMultipart ? encodeNextChunkMultipart(calculateRemainingSize) : encodeNextChunkUrlEncoded(calculateRemainingSize);
            if (encodeNextChunkMultipart2 != null) {
                return encodeNextChunkMultipart2;
            }
            calculateRemainingSize = calculateRemainingSize();
        }
        return lastChunk();
    }

    public void addBodyAttribute(String str, String str2) throws ErrorDataEncoderException {
        if (str2 == null) {
            str2 = "";
        }
        addBodyHttpData(this.factory.createAttribute(this.request, (String) ObjectUtil.checkNotNull(str, "name"), str2));
    }

    public void addBodyFileUpload(String str, File file, String str2, boolean z) throws ErrorDataEncoderException {
        addBodyFileUpload(str, file.getName(), file, str2, z);
    }

    public void addBodyFileUploads(String str, File[] fileArr, String[] strArr, boolean[] zArr) throws ErrorDataEncoderException {
        if (fileArr.length == strArr.length || fileArr.length == zArr.length) {
            for (int i = 0; i < fileArr.length; i++) {
                addBodyFileUpload(str, fileArr[i], strArr[i], zArr[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Different array length");
    }

    public void addBodyHttpData(InterfaceHttpData interfaceHttpData) throws ErrorDataEncoderException {
        String str;
        String str2;
        boolean z;
        FileUpload fileUpload;
        InterfaceHttpData interfaceHttpData2 = interfaceHttpData;
        if (!this.headerFinalized) {
            this.bodyListDatas.add(ObjectUtil.checkNotNull(interfaceHttpData2, "data"));
            if (this.isMultipart) {
                String str3 = "=\"";
                if (interfaceHttpData2 instanceof Attribute) {
                    if (this.duringMixedMode) {
                        InternalAttribute internalAttribute = new InternalAttribute(this.charset);
                        internalAttribute.addValue("\r\n--" + this.multipartMixedBoundary + "--");
                        this.multipartHttpDatas.add(internalAttribute);
                        this.multipartMixedBoundary = null;
                        this.currentFileUpload = null;
                        this.duringMixedMode = false;
                    }
                    InternalAttribute internalAttribute2 = new InternalAttribute(this.charset);
                    if (!this.multipartHttpDatas.isEmpty()) {
                        internalAttribute2.addValue("\r\n");
                    }
                    internalAttribute2.addValue("--" + this.multipartDataBoundary + "\r\n");
                    Attribute attribute = (Attribute) interfaceHttpData2;
                    internalAttribute2.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.FORM_DATA + "; " + HttpHeaderValues.NAME + str3 + attribute.getName() + "\"\r\n");
                    StringBuilder sb = new StringBuilder();
                    sb.append(HttpHeaderNames.CONTENT_LENGTH);
                    sb.append(": ");
                    sb.append(attribute.length());
                    sb.append("\r\n");
                    internalAttribute2.addValue(sb.toString());
                    Charset charset2 = attribute.getCharset();
                    if (charset2 != null) {
                        internalAttribute2.addValue(HttpHeaderNames.CONTENT_TYPE + ": " + "text/plain" + "; " + HttpHeaderValues.CHARSET + '=' + charset2.name() + "\r\n");
                    }
                    internalAttribute2.addValue("\r\n");
                    this.multipartHttpDatas.add(internalAttribute2);
                    this.multipartHttpDatas.add(interfaceHttpData2);
                    this.globalBodySize += attribute.length() + ((long) internalAttribute2.size());
                } else if (interfaceHttpData2 instanceof FileUpload) {
                    FileUpload fileUpload2 = (FileUpload) interfaceHttpData2;
                    InternalAttribute internalAttribute3 = new InternalAttribute(this.charset);
                    if (!this.multipartHttpDatas.isEmpty()) {
                        internalAttribute3.addValue("\r\n");
                    }
                    if (this.duringMixedMode) {
                        FileUpload fileUpload3 = this.currentFileUpload;
                        if (fileUpload3 == null || !fileUpload3.getName().equals(fileUpload2.getName())) {
                            internalAttribute3.addValue("--" + this.multipartMixedBoundary + "--");
                            this.multipartHttpDatas.add(internalAttribute3);
                            this.multipartMixedBoundary = null;
                            internalAttribute3 = new InternalAttribute(this.charset);
                            internalAttribute3.addValue("\r\n");
                            this.currentFileUpload = fileUpload2;
                            this.duringMixedMode = false;
                            str = "\"\r\n";
                            z = false;
                            str2 = "\r\n\r\n";
                        } else {
                            str = "\"\r\n";
                            str2 = "\r\n\r\n";
                            z = true;
                        }
                    } else if (this.encoderMode == EncoderMode.HTML5 || (fileUpload = this.currentFileUpload) == null || !fileUpload.getName().equals(fileUpload2.getName())) {
                        str = "\"\r\n";
                        str2 = "\r\n\r\n";
                        this.currentFileUpload = fileUpload2;
                        this.duringMixedMode = false;
                        z = false;
                    } else {
                        initMixedMultipart();
                        List<InterfaceHttpData> list = this.multipartHttpDatas;
                        InternalAttribute internalAttribute4 = (InternalAttribute) list.get(list.size() - 2);
                        this.globalBodySize -= (long) internalAttribute4.size();
                        StringBuilder sb2 = new StringBuilder(this.multipartDataBoundary.length() + 139 + (this.multipartMixedBoundary.length() * 2) + fileUpload2.getFilename().length() + fileUpload2.getName().length());
                        sb2.append("--");
                        sb2.append(this.multipartDataBoundary);
                        sb2.append("\r\n");
                        AsciiString asciiString = HttpHeaderNames.CONTENT_DISPOSITION;
                        sb2.append(asciiString);
                        sb2.append(": ");
                        sb2.append(HttpHeaderValues.FORM_DATA);
                        sb2.append("; ");
                        sb2.append(HttpHeaderValues.NAME);
                        str3 = str3;
                        sb2.append(str3);
                        sb2.append(fileUpload2.getName());
                        sb2.append("\"\r\n");
                        sb2.append(HttpHeaderNames.CONTENT_TYPE);
                        sb2.append(": ");
                        sb2.append(HttpHeaderValues.MULTIPART_MIXED);
                        sb2.append("; ");
                        sb2.append(HttpHeaderValues.BOUNDARY);
                        sb2.append('=');
                        sb2.append(this.multipartMixedBoundary);
                        sb2.append("\r\n\r\n");
                        sb2.append("--");
                        sb2.append(this.multipartMixedBoundary);
                        sb2.append("\r\n");
                        sb2.append(asciiString);
                        sb2.append(": ");
                        sb2.append(HttpHeaderValues.ATTACHMENT);
                        if (!fileUpload2.getFilename().isEmpty()) {
                            sb2.append("; ");
                            sb2.append(HttpHeaderValues.FILENAME);
                            sb2.append(str3);
                            sb2.append(this.currentFileUpload.getFilename());
                            sb2.append('\"');
                        }
                        sb2.append("\r\n");
                        internalAttribute4.setValue(sb2.toString(), 1);
                        internalAttribute4.setValue("", 2);
                        str2 = "\r\n\r\n";
                        str = "\"\r\n";
                        this.globalBodySize += (long) internalAttribute4.size();
                        z = true;
                        this.duringMixedMode = true;
                    }
                    if (z) {
                        internalAttribute3.addValue("--" + this.multipartMixedBoundary + "\r\n");
                        if (fileUpload2.getFilename().isEmpty()) {
                            internalAttribute3.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.ATTACHMENT + "\r\n");
                        } else {
                            internalAttribute3.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.ATTACHMENT + "; " + HttpHeaderValues.FILENAME + str3 + fileUpload2.getFilename() + str);
                        }
                    } else {
                        String str4 = str;
                        internalAttribute3.addValue("--" + this.multipartDataBoundary + "\r\n");
                        if (fileUpload2.getFilename().isEmpty()) {
                            internalAttribute3.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.FORM_DATA + "; " + HttpHeaderValues.NAME + str3 + fileUpload2.getName() + str4);
                        } else {
                            internalAttribute3.addValue(HttpHeaderNames.CONTENT_DISPOSITION + ": " + HttpHeaderValues.FORM_DATA + "; " + HttpHeaderValues.NAME + str3 + fileUpload2.getName() + "\"; " + HttpHeaderValues.FILENAME + str3 + fileUpload2.getFilename() + str4);
                        }
                    }
                    internalAttribute3.addValue(HttpHeaderNames.CONTENT_LENGTH + ": " + fileUpload2.length() + "\r\n");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(HttpHeaderNames.CONTENT_TYPE);
                    sb3.append(": ");
                    sb3.append(fileUpload2.getContentType());
                    internalAttribute3.addValue(sb3.toString());
                    String contentTransferEncoding = fileUpload2.getContentTransferEncoding();
                    if (contentTransferEncoding != null) {
                        HttpPostBodyUtil.TransferEncodingMechanism transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BINARY;
                        if (contentTransferEncoding.equals(transferEncodingMechanism.value())) {
                            internalAttribute3.addValue("\r\n" + HttpHeaderNames.CONTENT_TRANSFER_ENCODING + ": " + transferEncodingMechanism.value() + str2);
                            this.multipartHttpDatas.add(internalAttribute3);
                            this.multipartHttpDatas.add(interfaceHttpData2);
                            this.globalBodySize += fileUpload2.length() + ((long) internalAttribute3.size());
                        }
                    }
                    if (fileUpload2.getCharset() != null) {
                        internalAttribute3.addValue("; " + HttpHeaderValues.CHARSET + '=' + fileUpload2.getCharset().name() + str2);
                    } else {
                        internalAttribute3.addValue(str2);
                    }
                    this.multipartHttpDatas.add(internalAttribute3);
                    this.multipartHttpDatas.add(interfaceHttpData2);
                    this.globalBodySize += fileUpload2.length() + ((long) internalAttribute3.size());
                }
            } else if (interfaceHttpData2 instanceof Attribute) {
                Attribute attribute2 = (Attribute) interfaceHttpData2;
                try {
                    Attribute createAttribute = this.factory.createAttribute(this.request, encodeAttribute(attribute2.getName(), this.charset), encodeAttribute(attribute2.getValue(), this.charset));
                    this.multipartHttpDatas.add(createAttribute);
                    this.globalBodySize += ((long) (createAttribute.getName().length() + 1)) + createAttribute.length() + 1;
                } catch (IOException e) {
                    throw new ErrorDataEncoderException((Throwable) e);
                }
            } else if (interfaceHttpData2 instanceof FileUpload) {
                FileUpload fileUpload4 = (FileUpload) interfaceHttpData2;
                Attribute createAttribute2 = this.factory.createAttribute(this.request, encodeAttribute(fileUpload4.getName(), this.charset), encodeAttribute(fileUpload4.getFilename(), this.charset));
                this.multipartHttpDatas.add(createAttribute2);
                this.globalBodySize += ((long) (createAttribute2.getName().length() + 1)) + createAttribute2.length() + 1;
            }
        } else {
            throw new ErrorDataEncoderException("Cannot add value once finalized");
        }
    }

    public void cleanFiles() {
        this.factory.cleanRequestHttpData(this.request);
    }

    public void close() throws Exception {
    }

    public HttpRequest finalizeRequest() throws ErrorDataEncoderException {
        if (!this.headerFinalized) {
            if (this.isMultipart) {
                InternalAttribute internalAttribute = new InternalAttribute(this.charset);
                if (this.duringMixedMode) {
                    internalAttribute.addValue("\r\n--" + this.multipartMixedBoundary + "--");
                }
                internalAttribute.addValue("\r\n--" + this.multipartDataBoundary + "--\r\n");
                this.multipartHttpDatas.add(internalAttribute);
                this.multipartMixedBoundary = null;
                this.currentFileUpload = null;
                this.duringMixedMode = false;
                this.globalBodySize += (long) internalAttribute.size();
            }
            this.headerFinalized = true;
            HttpHeaders headers = this.request.headers();
            AsciiString asciiString = HttpHeaderNames.CONTENT_TYPE;
            List<String> all = headers.getAll((CharSequence) asciiString);
            List<String> all2 = headers.getAll((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
            if (all != null) {
                headers.remove((CharSequence) asciiString);
                for (String next : all) {
                    String lowerCase = next.toLowerCase();
                    if (!lowerCase.startsWith(HttpHeaderValues.MULTIPART_FORM_DATA.toString()) && !lowerCase.startsWith(HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())) {
                        headers.add((CharSequence) HttpHeaderNames.CONTENT_TYPE, (Object) next);
                    }
                }
            }
            if (this.isMultipart) {
                headers.add((CharSequence) HttpHeaderNames.CONTENT_TYPE, (Object) HttpHeaderValues.MULTIPART_FORM_DATA + "; " + HttpHeaderValues.BOUNDARY + '=' + this.multipartDataBoundary);
            } else {
                headers.add((CharSequence) HttpHeaderNames.CONTENT_TYPE, (Object) HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED);
            }
            long j = this.globalBodySize;
            if (!this.isMultipart) {
                j--;
            }
            this.iterator = this.multipartHttpDatas.listIterator();
            headers.set((CharSequence) HttpHeaderNames.CONTENT_LENGTH, (Object) String.valueOf(j));
            if (j > 8096 || this.isMultipart) {
                this.isChunked = true;
                if (all2 != null) {
                    headers.remove((CharSequence) HttpHeaderNames.TRANSFER_ENCODING);
                    for (CharSequence next2 : all2) {
                        if (!HttpHeaderValues.CHUNKED.contentEqualsIgnoreCase(next2)) {
                            headers.add((CharSequence) HttpHeaderNames.TRANSFER_ENCODING, (Object) next2);
                        }
                    }
                }
                HttpUtil.setTransferEncodingChunked(this.request, true);
                return new WrappedHttpRequest(this.request);
            }
            HttpContent nextChunk = nextChunk();
            HttpRequest httpRequest = this.request;
            if (!(httpRequest instanceof FullHttpRequest)) {
                return new WrappedFullHttpRequest(httpRequest, nextChunk);
            }
            FullHttpRequest fullHttpRequest = (FullHttpRequest) httpRequest;
            ByteBuf content = nextChunk.content();
            if (fullHttpRequest.content() != content) {
                fullHttpRequest.content().clear().writeBytes(content);
                content.release();
            }
            return fullHttpRequest;
        }
        throw new ErrorDataEncoderException("Header already encoded");
    }

    public List<InterfaceHttpData> getBodyListAttributes() {
        return this.bodyListDatas;
    }

    public boolean isChunked() {
        return this.isChunked;
    }

    public boolean isEndOfInput() throws Exception {
        return this.isLastChunkSent;
    }

    public boolean isMultipart() {
        return this.isMultipart;
    }

    public long length() {
        return this.isMultipart ? this.globalBodySize : this.globalBodySize - 1;
    }

    public long progress() {
        return this.globalProgress;
    }

    public void setBodyHttpDatas(List<InterfaceHttpData> list) throws ErrorDataEncoderException {
        ObjectUtil.checkNotNull(list, "datas");
        this.globalBodySize = 0;
        this.bodyListDatas.clear();
        this.currentFileUpload = null;
        this.duringMixedMode = false;
        this.multipartHttpDatas.clear();
        for (InterfaceHttpData addBodyHttpData : list) {
            addBodyHttpData(addBodyHttpData);
        }
    }

    public HttpPostRequestEncoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, boolean z) throws ErrorDataEncoderException {
        this(httpDataFactory, httpRequest, z, HttpConstants.DEFAULT_CHARSET, EncoderMode.RFC1738);
    }

    public void addBodyFileUpload(String str, String str2, File file, String str3, boolean z) throws ErrorDataEncoderException {
        ObjectUtil.checkNotNull(str, "name");
        ObjectUtil.checkNotNull(file, "file");
        if (str2 == null) {
            str2 = "";
        }
        String str4 = str2;
        if (str3 == null) {
            if (z) {
                str3 = "text/plain";
            } else {
                str3 = "application/octet-stream";
            }
        }
        FileUpload createFileUpload = this.factory.createFileUpload(this.request, str, str4, str3, !z ? HttpPostBodyUtil.TransferEncodingMechanism.BINARY.value() : null, (Charset) null, file.length());
        try {
            createFileUpload.setContent(file);
            addBodyHttpData(createFileUpload);
        } catch (IOException e) {
            throw new ErrorDataEncoderException((Throwable) e);
        }
    }

    public HttpPostRequestEncoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, boolean z, Charset charset2, EncoderMode encoderMode2) throws ErrorDataEncoderException {
        this.isKey = true;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset2, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        if (!HttpMethod.TRACE.equals(httpRequest.method())) {
            this.bodyListDatas = new ArrayList();
            this.isLastChunk = false;
            this.isLastChunkSent = false;
            this.isMultipart = z;
            this.multipartHttpDatas = new ArrayList();
            this.encoderMode = encoderMode2;
            if (z) {
                initDataMultipart();
                return;
            }
            return;
        }
        throw new ErrorDataEncoderException("Cannot create a Encoder if request is a TRACE");
    }

    @Deprecated
    public HttpContent readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public HttpContent readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        if (this.isLastChunkSent) {
            return null;
        }
        HttpContent nextChunk = nextChunk();
        this.globalProgress += (long) nextChunk.content().readableBytes();
        return nextChunk;
    }
}
