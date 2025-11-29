package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HttpPostStandardRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private final Charset charset;
    private Attribute currentAttribute;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* renamed from: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus[] r0 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = r0
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.DISPOSITION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.FIELD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class UrlDecoder implements ByteProcessor {
        private byte hiByte;
        /* access modifiers changed from: private */
        public int nextEscapedIdx;
        private final ByteBuf output;

        public UrlDecoder(ByteBuf byteBuf) {
            this.output = byteBuf;
        }

        public boolean process(byte b) {
            int i = this.nextEscapedIdx;
            if (i != 0) {
                if (i == 1) {
                    this.hiByte = b;
                    this.nextEscapedIdx = i + 1;
                } else {
                    int decodeHexNibble = StringUtil.decodeHexNibble((char) this.hiByte);
                    int decodeHexNibble2 = StringUtil.decodeHexNibble((char) b);
                    if (decodeHexNibble == -1 || decodeHexNibble2 == -1) {
                        this.nextEscapedIdx++;
                        return false;
                    }
                    this.output.writeByte((decodeHexNibble << 4) + decodeHexNibble2);
                    this.nextEscapedIdx = 0;
                }
            } else if (b == 37) {
                this.nextEscapedIdx = 1;
            } else if (b == 43) {
                this.output.writeByte(32);
            } else {
                this.output.writeByte(b);
            }
            return true;
        }
    }

    public static final class UrlEncodedDetector implements ByteProcessor {
        private UrlEncodedDetector() {
        }

        public boolean process(byte b) throws Exception {
            return (b == 37 || b == 43) ? false : true;
        }

        public /* synthetic */ UrlEncodedDetector(AnonymousClass1 r1) {
            this();
        }
    }

    public HttpPostStandardRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException(HttpPostStandardRequestDecoder.class.getSimpleName() + " was destroyed already");
        }
    }

    private static String decodeAttribute(String str, Charset charset2) {
        try {
            return QueryStringDecoder.decodeComponent(str, charset2);
        } catch (IllegalArgumentException e) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad string: '" + str + '\'', e);
        }
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyAttributes();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyAttributes() {
        int i;
        int i2;
        boolean z;
        Attribute attribute;
        int i3;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null) {
            if (!byteBuf.hasArray()) {
                parseBodyAttributesStandard();
                return;
            }
            HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
            int readerIndex = this.undecodedChunk.readerIndex();
            if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
            }
            loop0:
            while (true) {
                i2 = i;
                while (true) {
                    try {
                        int i4 = seekAheadOptimize.pos;
                        z = true;
                        if (i4 >= seekAheadOptimize.limit) {
                            break loop0;
                        }
                        byte[] bArr = seekAheadOptimize.bytes;
                        seekAheadOptimize.pos = i4 + 1;
                        char c = (char) (bArr[i4] & 255);
                        i3 = i + 1;
                        int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                        if (i5 != 1) {
                            if (i5 != 2) {
                                seekAheadOptimize.setReadPosition(0);
                                i = i3;
                                break loop0;
                            } else if (c == '&') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                                break;
                            } else if (c == 13) {
                                int i6 = seekAheadOptimize.pos;
                                int i7 = seekAheadOptimize.limit;
                                if (i6 < i7) {
                                    byte[] bArr2 = seekAheadOptimize.bytes;
                                    seekAheadOptimize.pos = i6 + 1;
                                    char c2 = (char) (bArr2[i6] & 255);
                                    i3 = i + 2;
                                    if (c2 == 10) {
                                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                        seekAheadOptimize.setReadPosition(0);
                                        setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                                    } else {
                                        seekAheadOptimize.setReadPosition(0);
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                                    }
                                } else {
                                    if (i7 > 0) {
                                    }
                                    i = i3;
                                }
                            } else {
                                if (c == 10) {
                                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                    seekAheadOptimize.setReadPosition(0);
                                    setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
                                    break loop0;
                                }
                                i = i3;
                            }
                        } else if (c == '=') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                            this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i2, i - i2, this.charset), this.charset));
                            break;
                        } else {
                            if (c == '&') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                                String decodeAttribute = decodeAttribute(this.undecodedChunk.toString(i2, i - i2, this.charset), this.charset);
                                if (!decodeAttribute.isEmpty()) {
                                    Attribute createAttribute = this.factory.createAttribute(this.request, decodeAttribute);
                                    this.currentAttribute = createAttribute;
                                    createAttribute.setValue("");
                                    addHttpData(this.currentAttribute);
                                }
                                this.currentAttribute = null;
                            }
                            i = i3;
                        }
                    } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
                        e = e;
                        this.undecodedChunk.readerIndex(i2);
                        throw e;
                    } catch (IOException e2) {
                        e = e2;
                        this.undecodedChunk.readerIndex(i2);
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        this.undecodedChunk.readerIndex(i2);
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
                    }
                }
                readerIndex = i3;
            }
            i = i3;
            i2 = i;
            z = false;
            if (!this.isLastChunk || (attribute = this.currentAttribute) == null) {
                if (z) {
                    Attribute attribute2 = this.currentAttribute;
                    if (attribute2 != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
                        attribute2.addContent(this.undecodedChunk.retainedSlice(i2, i - i2), false);
                    }
                }
                this.undecodedChunk.readerIndex(i2);
            }
            if (i > i2) {
                setFinalBuffer(this.undecodedChunk.retainedSlice(i2, i - i2));
            } else if (!attribute.isCompleted()) {
                setFinalBuffer(Unpooled.EMPTY_BUFFER);
            }
            try {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e4) {
                e = e4;
                i2 = i;
            } catch (IOException e5) {
                e = e5;
                i2 = i;
                this.undecodedChunk.readerIndex(i2);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            } catch (IllegalArgumentException e6) {
                e = e6;
                i2 = i;
                this.undecodedChunk.readerIndex(i2);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            }
            i2 = i;
            this.undecodedChunk.readerIndex(i2);
        }
    }

    private void parseBodyAttributesStandard() {
        Attribute attribute;
        int readerIndex = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
        }
        int i = readerIndex;
        boolean z = true;
        while (this.undecodedChunk.isReadable() && z) {
            try {
                char readUnsignedByte = (char) this.undecodedChunk.readUnsignedByte();
                int i2 = readerIndex + 1;
                int i3 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        z = false;
                    } else if (readUnsignedByte == '&') {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i, readerIndex - i));
                        z = true;
                        readerIndex = i2;
                        i = readerIndex;
                    } else if (readUnsignedByte == 13) {
                        if (this.undecodedChunk.isReadable()) {
                            int i4 = readerIndex + 2;
                            if (((char) this.undecodedChunk.readUnsignedByte()) == 10) {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i, readerIndex - i));
                                readerIndex = i4;
                                i = readerIndex;
                                z = false;
                            } else {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                            }
                        } else {
                            continue;
                        }
                    } else if (readUnsignedByte == 10) {
                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                        setFinalBuffer(this.undecodedChunk.retainedSlice(i, readerIndex - i));
                        z = false;
                        readerIndex = i2;
                        i = readerIndex;
                    }
                } else if (readUnsignedByte == '=') {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                    this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i, readerIndex - i, this.charset), this.charset));
                    readerIndex = i2;
                    i = readerIndex;
                } else if (readUnsignedByte == '&') {
                    this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                    String decodeAttribute = decodeAttribute(this.undecodedChunk.toString(i, readerIndex - i, this.charset), this.charset);
                    if (!decodeAttribute.isEmpty()) {
                        Attribute createAttribute = this.factory.createAttribute(this.request, decodeAttribute);
                        this.currentAttribute = createAttribute;
                        createAttribute.setValue("");
                        addHttpData(this.currentAttribute);
                    }
                    this.currentAttribute = null;
                    z = true;
                    readerIndex = i2;
                    i = readerIndex;
                }
                readerIndex = i2;
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
                e = e;
                this.undecodedChunk.readerIndex(i);
                throw e;
            } catch (IOException e2) {
                e = e2;
                this.undecodedChunk.readerIndex(i);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            } catch (IllegalArgumentException e3) {
                e = e3;
                this.undecodedChunk.readerIndex(i);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            }
        }
        if (!this.isLastChunk || (attribute = this.currentAttribute) == null) {
            if (z) {
                Attribute attribute2 = this.currentAttribute;
                if (attribute2 != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
                    attribute2.addContent(this.undecodedChunk.retainedSlice(i, readerIndex - i), false);
                }
            }
            readerIndex = i;
        } else {
            if (readerIndex > i) {
                setFinalBuffer(this.undecodedChunk.retainedSlice(i, readerIndex - i));
            } else if (!attribute.isCompleted()) {
                setFinalBuffer(Unpooled.EMPTY_BUFFER);
            }
            try {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e4) {
                i = readerIndex;
                e = e4;
            } catch (IOException e5) {
                i = readerIndex;
                e = e5;
                this.undecodedChunk.readerIndex(i);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            } catch (IllegalArgumentException e6) {
                i = readerIndex;
                e = e6;
                this.undecodedChunk.readerIndex(i);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            }
        }
        this.undecodedChunk.readerIndex(readerIndex);
    }

    private void setFinalBuffer(ByteBuf byteBuf) throws IOException {
        this.currentAttribute.addContent(byteBuf, true);
        ByteBuf decodeAttribute = decodeAttribute(this.currentAttribute.getByteBuf(), this.charset);
        if (decodeAttribute != null) {
            this.currentAttribute.setContent(decodeAttribute);
        }
        addHttpData(this.currentAttribute);
        this.currentAttribute = null;
    }

    public void addHttpData(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData != null) {
            List list = this.bodyMapHttpData.get(interfaceHttpData.getName());
            if (list == null) {
                list = new ArrayList(1);
                this.bodyMapHttpData.put(interfaceHttpData.getName(), list);
            }
            list.add(interfaceHttpData);
            this.bodyListHttpData.add(interfaceHttpData);
        }
    }

    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    public InterfaceHttpData currentPartialHttpData() {
        return this.currentAttribute;
    }

    public void destroy() {
        cleanFiles();
        for (InterfaceHttpData next : this.bodyListHttpData) {
            if (next.refCnt() > 0) {
                next.release();
            }
        }
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null && byteBuf.refCnt() > 0) {
            this.undecodedChunk.release();
            this.undecodedChunk = null;
        }
    }

    public InterfaceHttpData getBodyHttpData(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            List list = this.bodyMapHttpData.get(str);
            if (list != null) {
                return (InterfaceHttpData) list.get(0);
            }
            return null;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    public List<InterfaceHttpData> getBodyHttpDatas() {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyListHttpData;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    public boolean hasNext() {
        checkDestroyed();
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE || this.bodyListHttpDataRank < this.bodyListHttpData.size()) {
            return !this.bodyListHttpData.isEmpty() && this.bodyListHttpDataRank < this.bodyListHttpData.size();
        }
        throw new HttpPostRequestDecoder.EndOfDataDecoderException();
    }

    public boolean isMultipart() {
        checkDestroyed();
        return false;
    }

    public InterfaceHttpData next() {
        checkDestroyed();
        if (!hasNext()) {
            return null;
        }
        List<InterfaceHttpData> list = this.bodyListHttpData;
        int i = this.bodyListHttpDataRank;
        this.bodyListHttpDataRank = i + 1;
        return list.get(i);
    }

    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        checkDestroyed();
        this.factory.removeHttpDataFromClean(this.request, interfaceHttpData);
    }

    public void setDiscardThreshold(int i) {
        this.discardThreshold = ObjectUtil.checkPositiveOrZero(i, "discardThreshold");
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    public HttpPostStandardRequestDecoder offer(HttpContent httpContent) {
        checkDestroyed();
        if (httpContent instanceof LastHttpContent) {
            this.isLastChunk = true;
        }
        ByteBuf content = httpContent.content();
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf == null) {
            this.undecodedChunk = content.alloc().buffer(content.readableBytes()).writeBytes(content);
        } else {
            byteBuf.writeBytes(content);
        }
        parseBody();
        ByteBuf byteBuf2 = this.undecodedChunk;
        if (byteBuf2 != null && byteBuf2.writerIndex() > this.discardThreshold) {
            if (this.undecodedChunk.refCnt() == 1) {
                this.undecodedChunk.discardReadBytes();
            } else {
                ByteBuf buffer = this.undecodedChunk.alloc().buffer(this.undecodedChunk.readableBytes());
                buffer.writeBytes(this.undecodedChunk);
                this.undecodedChunk.release();
                this.undecodedChunk = buffer;
            }
        }
        return this;
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset2) {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.charset = (Charset) ObjectUtil.checkNotNull(charset2, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        try {
            if (httpRequest instanceof HttpContent) {
                offer((HttpContent) httpRequest);
            } else {
                parseBody();
            }
        } catch (Throwable th) {
            destroy();
            PlatformDependent.throwException(th);
        }
    }

    private static ByteBuf decodeAttribute(ByteBuf byteBuf, Charset charset2) {
        if (byteBuf.forEachByte(new UrlEncodedDetector((AnonymousClass1) null)) == -1) {
            return null;
        }
        ByteBuf buffer = byteBuf.alloc().buffer(byteBuf.readableBytes());
        UrlDecoder urlDecoder = new UrlDecoder(buffer);
        int forEachByte = byteBuf.forEachByte(urlDecoder);
        if (urlDecoder.nextEscapedIdx == 0) {
            return buffer;
        }
        if (forEachByte == -1) {
            forEachByte = byteBuf.readableBytes() - 1;
        }
        buffer.release();
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(String.format("Invalid hex byte at index '%d' in string: '%s'", new Object[]{Integer.valueOf(forEachByte - (urlDecoder.nextEscapedIdx - 1)), byteBuf.toString(charset2)}));
    }

    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
}
