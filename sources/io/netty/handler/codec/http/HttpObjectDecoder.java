package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEFAULT_ALLOW_DUPLICATE_CONTENT_LENGTHS = false;
    public static final boolean DEFAULT_ALLOW_PARTIAL_CHUNKS = true;
    public static final boolean DEFAULT_CHUNKED_SUPPORTED = true;
    public static final int DEFAULT_INITIAL_BUFFER_SIZE = 128;
    public static final int DEFAULT_MAX_CHUNK_SIZE = 8192;
    public static final int DEFAULT_MAX_HEADER_SIZE = 8192;
    public static final int DEFAULT_MAX_INITIAL_LINE_LENGTH = 4096;
    public static final boolean DEFAULT_VALIDATE_HEADERS = true;
    private static final String EMPTY_VALUE = "";
    private final boolean allowDuplicateContentLengths;
    private final boolean allowPartialChunks;
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    /* access modifiers changed from: private */
    public State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private CharSequence name;
    private volatile boolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private CharSequence value;

    /* renamed from: io.netty.handler.codec.http.HttpObjectDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.netty.handler.codec.http.HttpObjectDecoder$State[] r0 = io.netty.handler.codec.http.HttpObjectDecoder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = r0
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.SKIP_CONTROL_CHARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_SIZE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_INITIAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_HEADER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_VARIABLE_LENGTH_CONTENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_FIXED_LENGTH_CONTENT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNKED_CONTENT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_DELIMITER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x006c }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_FOOTER     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.BAD_MESSAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.netty.handler.codec.http.HttpObjectDecoder$State r1 = io.netty.handler.codec.http.HttpObjectDecoder.State.UPGRADED     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public static class HeaderParser implements ByteProcessor {
        private final int maxLength;
        private final AppendableCharSequence seq;
        int size;

        public HeaderParser(AppendableCharSequence appendableCharSequence, int i) {
            this.seq = appendableCharSequence;
            this.maxLength = i;
        }

        public final void increaseCount() {
            int i = this.size + 1;
            this.size = i;
            int i2 = this.maxLength;
            if (i > i2) {
                throw newException(i2);
            }
        }

        public TooLongFrameException newException(int i) {
            return new TooLongHttpHeaderException("HTTP header is larger than " + i + " bytes.");
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            int i = this.size;
            this.seq.reset();
            int forEachByte = byteBuf.forEachByte(this);
            if (forEachByte == -1) {
                this.size = i;
                return null;
            }
            byteBuf.readerIndex(forEachByte + 1);
            return this.seq;
        }

        public boolean process(byte b) throws Exception {
            char c = (char) (b & 255);
            if (c == 10) {
                int length = this.seq.length();
                if (length < 1) {
                    return false;
                }
                int i = length - 1;
                if (this.seq.charAtUnsafe(i) != 13) {
                    return false;
                }
                this.size--;
                this.seq.setLength(i);
                return false;
            }
            increaseCount();
            this.seq.append(c);
            return true;
        }

        public void reset() {
            this.size = 0;
        }
    }

    public final class LineParser extends HeaderParser {
        public LineParser(AppendableCharSequence appendableCharSequence, int i) {
            super(appendableCharSequence, i);
        }

        public TooLongFrameException newException(int i) {
            return new TooLongHttpLineException("An HTTP line is larger than " + i + " bytes.");
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            return super.parse(byteBuf);
        }

        public boolean process(byte b) throws Exception {
            if (HttpObjectDecoder.this.currentState == State.SKIP_CONTROL_CHARS) {
                char c = (char) (b & 255);
                if (Character.isISOControl(c) || Character.isWhitespace(c)) {
                    increaseCount();
                    return true;
                }
                State unused = HttpObjectDecoder.this.currentState = State.READ_INITIAL;
            }
            return super.process(b);
        }
    }

    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    public HttpObjectDecoder() {
        this(4096, 8192, 8192, true);
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1);
        }
        return this.contentLength;
    }

    private static int findEndOfString(AppendableCharSequence appendableCharSequence) {
        for (int length = appendableCharSequence.length() - 1; length > 0; length--) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(length))) {
                return length + 1;
            }
        }
        return 0;
    }

    private static int findNonSPLenient(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            char charAtUnsafe = appendableCharSequence.charAtUnsafe(i);
            if (isSPLenient(charAtUnsafe)) {
                i++;
            } else if (!Character.isWhitespace(charAtUnsafe)) {
                return i;
            } else {
                throw new IllegalArgumentException("Invalid separator");
            }
        }
        return appendableCharSequence.length();
    }

    private static int findNonWhitespace(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            char charAtUnsafe = appendableCharSequence.charAtUnsafe(i);
            if (!Character.isWhitespace(charAtUnsafe)) {
                return i;
            }
            if (isOWS(charAtUnsafe)) {
                i++;
            } else {
                throw new IllegalArgumentException("Invalid separator, only a single space or horizontal tab allowed, but received a '" + charAtUnsafe + "' (0x" + Integer.toHexString(charAtUnsafe) + ")");
            }
        }
        return appendableCharSequence.length();
    }

    private static int findSPLenient(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            if (isSPLenient(appendableCharSequence.charAtUnsafe(i))) {
                return i;
            }
            i++;
        }
        return appendableCharSequence.length();
    }

    private static int getChunkSize(String str) {
        String trim = str.trim();
        int i = 0;
        while (true) {
            if (i >= trim.length()) {
                break;
            }
            char charAt = trim.charAt(i);
            if (charAt == ';' || Character.isWhitespace(charAt) || Character.isISOControl(charAt)) {
                trim = trim.substring(0, i);
            } else {
                i++;
            }
        }
        trim = trim.substring(0, i);
        return Integer.parseInt(trim, 16);
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        if (this.message == null) {
            this.message = createInvalidMessage();
        }
        this.message.setDecoderResult(DecoderResult.failure(exc));
        HttpMessage httpMessage = this.message;
        this.message = null;
        return httpMessage;
    }

    private static boolean isOWS(char c) {
        return c == ' ' || c == 9;
    }

    private static boolean isSPLenient(char c) {
        return c == ' ' || c == 9 || c == 11 || c == 12 || c == 13;
    }

    private State readHeaders(ByteBuf byteBuf) {
        HttpMessage httpMessage = this.message;
        HttpHeaders headers = httpMessage.headers();
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        if (parse.length() > 0) {
            do {
                char charAtUnsafe = parse.charAtUnsafe(0);
                CharSequence charSequence = this.name;
                if (charSequence == null || !(charAtUnsafe == ' ' || charAtUnsafe == 9)) {
                    if (charSequence != null) {
                        headers.add(charSequence, (Object) this.value);
                    }
                    splitHeader(parse);
                } else {
                    String trim = parse.toString().trim();
                    this.value = String.valueOf(this.value) + ' ' + trim;
                }
                parse = this.headerParser.parse(byteBuf);
                if (parse == null) {
                    return null;
                }
            } while (parse.length() > 0);
        }
        CharSequence charSequence2 = this.name;
        if (charSequence2 != null) {
            headers.add(charSequence2, (Object) this.value);
        }
        this.name = null;
        this.value = null;
        httpMessage.setDecoderResult(new HttpMessageDecoderResult(this.lineParser.size, this.headerParser.size));
        AsciiString asciiString = HttpHeaderNames.CONTENT_LENGTH;
        List<String> all = headers.getAll((CharSequence) asciiString);
        if (!all.isEmpty()) {
            HttpVersion protocolVersion = httpMessage.protocolVersion();
            boolean z = true;
            if (protocolVersion.majorVersion() >= 1 && !(protocolVersion.majorVersion() == 1 && protocolVersion.minorVersion() == 0)) {
                z = false;
            }
            long normalizeAndGetContentLength = HttpUtil.normalizeAndGetContentLength(all, z, this.allowDuplicateContentLengths);
            this.contentLength = normalizeAndGetContentLength;
            if (normalizeAndGetContentLength != -1) {
                headers.set((CharSequence) asciiString, (Object) Long.valueOf(normalizeAndGetContentLength));
            }
        }
        if (isContentAlwaysEmpty(httpMessage)) {
            HttpUtil.setTransferEncodingChunked(httpMessage, false);
            return State.SKIP_CONTROL_CHARS;
        } else if (!HttpUtil.isTransferEncodingChunked(httpMessage)) {
            return contentLength() >= 0 ? State.READ_FIXED_LENGTH_CONTENT : State.READ_VARIABLE_LENGTH_CONTENT;
        } else {
            if (!all.isEmpty() && httpMessage.protocolVersion() == HttpVersion.HTTP_1_1) {
                handleTransferEncodingChunkedWithContentLength(httpMessage);
            }
            return State.READ_CHUNK_SIZE;
        }
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        LastHttpContent lastHttpContent = this.trailer;
        if (parse.length() == 0 && lastHttpContent == null) {
            return LastHttpContent.EMPTY_LAST_CONTENT;
        }
        if (lastHttpContent == null) {
            lastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
            this.trailer = lastHttpContent;
        }
        CharSequence charSequence = null;
        while (parse.length() > 0) {
            char charAtUnsafe = parse.charAtUnsafe(0);
            if (charSequence == null || !(charAtUnsafe == ' ' || charAtUnsafe == 9)) {
                splitHeader(parse);
                CharSequence charSequence2 = this.name;
                if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(charSequence2)) {
                    lastHttpContent.trailingHeaders().add(charSequence2, (Object) this.value);
                }
                charSequence = this.name;
                this.name = null;
                this.value = null;
            } else {
                List<String> all = lastHttpContent.trailingHeaders().getAll(charSequence);
                if (!all.isEmpty()) {
                    int size = all.size() - 1;
                    all.set(size, all.get(size) + parse.toString().trim());
                }
            }
            parse = this.headerParser.parse(byteBuf);
            if (parse == null) {
                return null;
            }
        }
        this.trailer = null;
        return lastHttpContent;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (isDecodingRequest() || (httpResponse = (HttpResponse) httpMessage) == null || !isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.resetRequested = false;
            this.currentState = State.SKIP_CONTROL_CHARS;
            return;
        }
        this.currentState = State.UPGRADED;
    }

    private void splitHeader(AppendableCharSequence appendableCharSequence) {
        int length = appendableCharSequence.length();
        int findNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int i = findNonWhitespace;
        while (i < length && (r4 = appendableCharSequence.charAtUnsafe(i)) != ':' && (isDecodingRequest() || !isOWS(r4))) {
            i++;
        }
        if (i != length) {
            int i2 = i;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (appendableCharSequence.charAtUnsafe(i2) == ':') {
                    i2++;
                    break;
                } else {
                    i2++;
                }
            }
            this.name = appendableCharSequence.subStringUnsafe(findNonWhitespace, i);
            int findNonWhitespace2 = findNonWhitespace(appendableCharSequence, i2);
            if (findNonWhitespace2 == length) {
                this.value = "";
            } else {
                this.value = appendableCharSequence.subStringUnsafe(findNonWhitespace2, findEndOfString(appendableCharSequence));
            }
        } else {
            throw new IllegalArgumentException("No colon found");
        }
    }

    private static String[] splitInitialLine(AppendableCharSequence appendableCharSequence) {
        int findNonSPLenient = findNonSPLenient(appendableCharSequence, 0);
        int findSPLenient = findSPLenient(appendableCharSequence, findNonSPLenient);
        int findNonSPLenient2 = findNonSPLenient(appendableCharSequence, findSPLenient);
        int findSPLenient2 = findSPLenient(appendableCharSequence, findNonSPLenient2);
        int findNonSPLenient3 = findNonSPLenient(appendableCharSequence, findSPLenient2);
        int findEndOfString = findEndOfString(appendableCharSequence);
        return new String[]{appendableCharSequence.subStringUnsafe(findNonSPLenient, findSPLenient), appendableCharSequence.subStringUnsafe(findNonSPLenient2, findSPLenient2), findNonSPLenient3 < findEndOfString ? appendableCharSequence.subStringUnsafe(findNonSPLenient3, findEndOfString) : ""};
    }

    public abstract HttpMessage createInvalidMessage();

    public abstract HttpMessage createMessage(String[] strArr) throws Exception;

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x018e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0196, code lost:
        throw new java.lang.IllegalArgumentException("Chunked messages not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0197, code lost:
        r10.add(r7.message);
        r10.add(io.netty.handler.codec.http.LastHttpContent.EMPTY_LAST_CONTENT);
        resetNow();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01a4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01a5, code lost:
        r10.add(invalidMessage(r9, r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ac, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b8, code lost:
        r8 = java.lang.Math.min((int) r7.chunkSize, r7.maxChunkSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c3, code lost:
        if (r7.allowPartialChunks != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c9, code lost:
        if (r9.readableBytes() >= r8) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cb, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        r8 = java.lang.Math.min(r8, r9.readableBytes());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d4, code lost:
        if (r8 != 0) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r0 = new io.netty.handler.codec.http.DefaultHttpContent(r9.readRetainedSlice(r8));
        r7.chunkSize -= (long) r8;
        r10.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ed, code lost:
        if (r7.chunkSize == 0) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ef, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f0, code lost:
        r7.currentState = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_DELIMITER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f4, code lost:
        r8 = r9.writerIndex();
        r10 = r9.readerIndex();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fc, code lost:
        if (r8 <= r10) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fe, code lost:
        r0 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0106, code lost:
        if (r9.getByte(r10) != 10) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0108, code lost:
        r7.currentState = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_SIZE;
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010e, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0110, code lost:
        r9.readerIndex(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0113, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r0 = readHeaders(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0143, code lost:
        if (r0 != null) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0145, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0146, code lost:
        r7.currentState = r0;
        r8 = r8[r0.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x014f, code lost:
        if (r8 == 1) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0152, code lost:
        if (r8 == 2) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0154, code lost:
        r3 = contentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x015a, code lost:
        if (r3 == 0) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0160, code lost:
        if (r3 != -1) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0166, code lost:
        if (isDecodingRequest() == false) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0169, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x016b, code lost:
        r10.add(r7.message);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0172, code lost:
        if (r0 != io.netty.handler.codec.http.HttpObjectDecoder.State.READ_FIXED_LENGTH_CONTENT) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0174, code lost:
        r7.chunkSize = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0177, code lost:
        r10.add(r7.message);
        r10.add(io.netty.handler.codec.http.LastHttpContent.EMPTY_LAST_CONTENT);
        resetNow();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0184, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0187, code lost:
        if (r7.chunkedSupported == false) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0189, code lost:
        r10.add(r7.message);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            r7 = this;
            boolean r8 = r7.resetRequested
            if (r8 == 0) goto L_0x0007
            r7.resetNow()
        L_0x0007:
            int[] r8 = io.netty.handler.codec.http.HttpObjectDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State
            io.netty.handler.codec.http.HttpObjectDecoder$State r0 = r7.currentState
            int r0 = r0.ordinal()
            r0 = r8[r0]
            r1 = 0
            switch(r0) {
                case 1: goto L_0x011c;
                case 2: goto L_0x0097;
                case 3: goto L_0x011c;
                case 4: goto L_0x013f;
                case 5: goto L_0x007e;
                case 6: goto L_0x0044;
                case 7: goto L_0x00b8;
                case 8: goto L_0x00f4;
                case 9: goto L_0x002d;
                case 10: goto L_0x0025;
                case 11: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x002c
        L_0x0017:
            int r7 = r9.readableBytes()
            if (r7 <= 0) goto L_0x002c
            io.netty.buffer.ByteBuf r7 = r9.readBytes((int) r7)
            r10.add(r7)
            goto L_0x002c
        L_0x0025:
            int r7 = r9.readableBytes()
            r9.skipBytes(r7)
        L_0x002c:
            return
        L_0x002d:
            io.netty.handler.codec.http.LastHttpContent r8 = r7.readTrailingHeaders(r9)     // Catch:{ Exception -> 0x003b }
            if (r8 != 0) goto L_0x0034
            return
        L_0x0034:
            r10.add(r8)     // Catch:{ Exception -> 0x003b }
            r7.resetNow()     // Catch:{ Exception -> 0x003b }
            return
        L_0x003b:
            r8 = move-exception
            io.netty.handler.codec.http.HttpContent r7 = r7.invalidChunk(r9, r8)
            r10.add(r7)
            return
        L_0x0044:
            int r8 = r9.readableBytes()
            if (r8 != 0) goto L_0x004b
            return
        L_0x004b:
            int r0 = r7.maxChunkSize
            int r8 = java.lang.Math.min(r8, r0)
            long r3 = (long) r8
            long r5 = r7.chunkSize
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0059
            int r8 = (int) r5
        L_0x0059:
            io.netty.buffer.ByteBuf r9 = r9.readRetainedSlice(r8)
            long r3 = r7.chunkSize
            long r5 = (long) r8
            long r3 = r3 - r5
            r7.chunkSize = r3
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x0075
            io.netty.handler.codec.http.DefaultLastHttpContent r8 = new io.netty.handler.codec.http.DefaultLastHttpContent
            boolean r0 = r7.validateHeaders
            r8.<init>(r9, r0)
            r10.add(r8)
            r7.resetNow()
            goto L_0x007d
        L_0x0075:
            io.netty.handler.codec.http.DefaultHttpContent r7 = new io.netty.handler.codec.http.DefaultHttpContent
            r7.<init>(r9)
            r10.add(r7)
        L_0x007d:
            return
        L_0x007e:
            int r8 = r9.readableBytes()
            int r7 = r7.maxChunkSize
            int r7 = java.lang.Math.min(r8, r7)
            if (r7 <= 0) goto L_0x0096
            io.netty.buffer.ByteBuf r7 = r9.readRetainedSlice(r7)
            io.netty.handler.codec.http.DefaultHttpContent r8 = new io.netty.handler.codec.http.DefaultHttpContent
            r8.<init>(r7)
            r10.add(r8)
        L_0x0096:
            return
        L_0x0097:
            io.netty.handler.codec.http.HttpObjectDecoder$LineParser r8 = r7.lineParser     // Catch:{ Exception -> 0x00b2 }
            io.netty.util.internal.AppendableCharSequence r8 = r8.parse(r9)     // Catch:{ Exception -> 0x00b2 }
            if (r8 != 0) goto L_0x00a0
            return
        L_0x00a0:
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00b2 }
            int r8 = getChunkSize(r8)     // Catch:{ Exception -> 0x00b2 }
            long r3 = (long) r8     // Catch:{ Exception -> 0x00b2 }
            r7.chunkSize = r3     // Catch:{ Exception -> 0x00b2 }
            if (r8 != 0) goto L_0x00b4
            io.netty.handler.codec.http.HttpObjectDecoder$State r8 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_FOOTER     // Catch:{ Exception -> 0x00b2 }
            r7.currentState = r8     // Catch:{ Exception -> 0x00b2 }
            return
        L_0x00b2:
            r8 = move-exception
            goto L_0x0114
        L_0x00b4:
            io.netty.handler.codec.http.HttpObjectDecoder$State r8 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNKED_CONTENT     // Catch:{ Exception -> 0x00b2 }
            r7.currentState = r8     // Catch:{ Exception -> 0x00b2 }
        L_0x00b8:
            long r3 = r7.chunkSize
            int r8 = (int) r3
            int r0 = r7.maxChunkSize
            int r8 = java.lang.Math.min(r8, r0)
            boolean r0 = r7.allowPartialChunks
            if (r0 != 0) goto L_0x00cc
            int r0 = r9.readableBytes()
            if (r0 >= r8) goto L_0x00cc
            return
        L_0x00cc:
            int r0 = r9.readableBytes()
            int r8 = java.lang.Math.min(r8, r0)
            if (r8 != 0) goto L_0x00d7
            return
        L_0x00d7:
            io.netty.handler.codec.http.DefaultHttpContent r0 = new io.netty.handler.codec.http.DefaultHttpContent
            io.netty.buffer.ByteBuf r3 = r9.readRetainedSlice(r8)
            r0.<init>(r3)
            long r3 = r7.chunkSize
            long r5 = (long) r8
            long r3 = r3 - r5
            r7.chunkSize = r3
            r10.add(r0)
            long r3 = r7.chunkSize
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 == 0) goto L_0x00f0
            return
        L_0x00f0:
            io.netty.handler.codec.http.HttpObjectDecoder$State r8 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_DELIMITER
            r7.currentState = r8
        L_0x00f4:
            int r8 = r9.writerIndex()
            int r10 = r9.readerIndex()
        L_0x00fc:
            if (r8 <= r10) goto L_0x0110
            int r0 = r10 + 1
            byte r10 = r9.getByte(r10)
            r1 = 10
            if (r10 != r1) goto L_0x010e
            io.netty.handler.codec.http.HttpObjectDecoder$State r8 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_CHUNK_SIZE
            r7.currentState = r8
            r10 = r0
            goto L_0x0110
        L_0x010e:
            r10 = r0
            goto L_0x00fc
        L_0x0110:
            r9.readerIndex(r10)
            return
        L_0x0114:
            io.netty.handler.codec.http.HttpContent r7 = r7.invalidChunk(r9, r8)
            r10.add(r7)
            return
        L_0x011c:
            io.netty.handler.codec.http.HttpObjectDecoder$LineParser r0 = r7.lineParser     // Catch:{ Exception -> 0x0132 }
            io.netty.util.internal.AppendableCharSequence r0 = r0.parse(r9)     // Catch:{ Exception -> 0x0132 }
            if (r0 != 0) goto L_0x0125
            return
        L_0x0125:
            java.lang.String[] r0 = splitInitialLine(r0)     // Catch:{ Exception -> 0x0132 }
            int r3 = r0.length     // Catch:{ Exception -> 0x0132 }
            r4 = 3
            if (r3 >= r4) goto L_0x0135
            io.netty.handler.codec.http.HttpObjectDecoder$State r8 = io.netty.handler.codec.http.HttpObjectDecoder.State.SKIP_CONTROL_CHARS     // Catch:{ Exception -> 0x0132 }
            r7.currentState = r8     // Catch:{ Exception -> 0x0132 }
            return
        L_0x0132:
            r8 = move-exception
            goto L_0x01ad
        L_0x0135:
            io.netty.handler.codec.http.HttpMessage r0 = r7.createMessage(r0)     // Catch:{ Exception -> 0x0132 }
            r7.message = r0     // Catch:{ Exception -> 0x0132 }
            io.netty.handler.codec.http.HttpObjectDecoder$State r0 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_HEADER     // Catch:{ Exception -> 0x0132 }
            r7.currentState = r0     // Catch:{ Exception -> 0x0132 }
        L_0x013f:
            io.netty.handler.codec.http.HttpObjectDecoder$State r0 = r7.readHeaders(r9)     // Catch:{ Exception -> 0x0169 }
            if (r0 != 0) goto L_0x0146
            return
        L_0x0146:
            r7.currentState = r0     // Catch:{ Exception -> 0x0169 }
            int r3 = r0.ordinal()     // Catch:{ Exception -> 0x0169 }
            r8 = r8[r3]     // Catch:{ Exception -> 0x0169 }
            r3 = 1
            if (r8 == r3) goto L_0x0197
            r3 = 2
            if (r8 == r3) goto L_0x0185
            long r3 = r7.contentLength()     // Catch:{ Exception -> 0x0169 }
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 == 0) goto L_0x0177
            r1 = -1
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x016b
            boolean r8 = r7.isDecodingRequest()     // Catch:{ Exception -> 0x0169 }
            if (r8 == 0) goto L_0x016b
            goto L_0x0177
        L_0x0169:
            r8 = move-exception
            goto L_0x01a5
        L_0x016b:
            io.netty.handler.codec.http.HttpMessage r8 = r7.message     // Catch:{ Exception -> 0x0169 }
            r10.add(r8)     // Catch:{ Exception -> 0x0169 }
            io.netty.handler.codec.http.HttpObjectDecoder$State r8 = io.netty.handler.codec.http.HttpObjectDecoder.State.READ_FIXED_LENGTH_CONTENT     // Catch:{ Exception -> 0x0169 }
            if (r0 != r8) goto L_0x0176
            r7.chunkSize = r3     // Catch:{ Exception -> 0x0169 }
        L_0x0176:
            return
        L_0x0177:
            io.netty.handler.codec.http.HttpMessage r8 = r7.message     // Catch:{ Exception -> 0x0169 }
            r10.add(r8)     // Catch:{ Exception -> 0x0169 }
            io.netty.handler.codec.http.LastHttpContent r8 = io.netty.handler.codec.http.LastHttpContent.EMPTY_LAST_CONTENT     // Catch:{ Exception -> 0x0169 }
            r10.add(r8)     // Catch:{ Exception -> 0x0169 }
            r7.resetNow()     // Catch:{ Exception -> 0x0169 }
            return
        L_0x0185:
            boolean r8 = r7.chunkedSupported     // Catch:{ Exception -> 0x0169 }
            if (r8 == 0) goto L_0x018f
            io.netty.handler.codec.http.HttpMessage r8 = r7.message     // Catch:{ Exception -> 0x0169 }
            r10.add(r8)     // Catch:{ Exception -> 0x0169 }
            return
        L_0x018f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0169 }
            java.lang.String r0 = "Chunked messages not supported"
            r8.<init>(r0)     // Catch:{ Exception -> 0x0169 }
            throw r8     // Catch:{ Exception -> 0x0169 }
        L_0x0197:
            io.netty.handler.codec.http.HttpMessage r8 = r7.message     // Catch:{ Exception -> 0x0169 }
            r10.add(r8)     // Catch:{ Exception -> 0x0169 }
            io.netty.handler.codec.http.LastHttpContent r8 = io.netty.handler.codec.http.LastHttpContent.EMPTY_LAST_CONTENT     // Catch:{ Exception -> 0x0169 }
            r10.add(r8)     // Catch:{ Exception -> 0x0169 }
            r7.resetNow()     // Catch:{ Exception -> 0x0169 }
            return
        L_0x01a5:
            io.netty.handler.codec.http.HttpMessage r7 = r7.invalidMessage(r9, r8)
            r10.add(r7)
            return
        L_0x01ad:
            io.netty.handler.codec.http.HttpMessage r7 = r7.invalidMessage(r9, r8)
            r10.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean isTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !isTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
            } else if (this.currentState == State.READ_HEADER) {
                list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                resetNow();
            } else {
                if (!isDecodingRequest() && !isTransferEncodingChunked && contentLength() <= 0) {
                    list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                }
                resetNow();
            }
        }
    }

    public void handleTransferEncodingChunkedWithContentLength(HttpMessage httpMessage) {
        httpMessage.headers().remove((CharSequence) HttpHeaderNames.CONTENT_LENGTH);
        this.contentLength = Long.MIN_VALUE;
    }

    public boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (!(httpMessage instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) httpMessage;
        int code = httpResponse.status().code();
        return (code < 100 || code >= 200) ? code == 204 || code == 304 : code != 101 || httpResponse.headers().contains((CharSequence) HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) || !httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true);
    }

    public abstract boolean isDecodingRequest();

    public boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get((CharSequence) HttpHeaderNames.UPGRADE);
        return str == null || (!str.contains(HttpVersion.HTTP_1_0.text()) && !str.contains(HttpVersion.HTTP_1_1.text()));
    }

    public void reset() {
        this.resetRequested = true;
    }

    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        int i;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i == 5 || i == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z) {
        this(i, i2, i3, z, true);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2) {
        this(i, i2, i3, z, z2, 128);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2, int i4) {
        this(i, i2, i3, z, z2, i4, false);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3) {
        this(i, i2, i3, z, z2, i4, z3, true);
    }

    public HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, boolean z4) {
        this.contentLength = Long.MIN_VALUE;
        this.currentState = State.SKIP_CONTROL_CHARS;
        ObjectUtil.checkPositive(i, "maxInitialLineLength");
        ObjectUtil.checkPositive(i2, "maxHeaderSize");
        ObjectUtil.checkPositive(i3, "maxChunkSize");
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i4);
        this.lineParser = new LineParser(appendableCharSequence, i);
        this.headerParser = new HeaderParser(appendableCharSequence, i2);
        this.maxChunkSize = i3;
        this.chunkedSupported = z;
        this.validateHeaders = z2;
        this.allowDuplicateContentLengths = z3;
        this.allowPartialChunks = z4;
    }
}
