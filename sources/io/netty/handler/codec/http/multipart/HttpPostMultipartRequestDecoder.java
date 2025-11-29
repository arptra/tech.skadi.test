package io.netty.handler.codec.http.multipart;

import com.meizu.common.widget.MzContactsContract;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec.language.Soundex;

public class HttpPostMultipartRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private static final String FILENAME_ENCODED = (HttpHeaderValues.FILENAME.toString() + '*');
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private Charset charset;
    private Attribute currentAttribute;
    private Map<CharSequence, Attribute> currentFieldAttributes;
    private FileUpload currentFileUpload;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final String multipartDataBoundary;
    private String multipartMixedBoundary;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* renamed from: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

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
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus[] r0 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = r0
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.PREAMBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.DISPOSITION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x003e }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.FIELD     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.MIXEDDISPOSITION     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x006c }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x0078 }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus     // Catch:{ NoSuchFieldError -> 0x0084 }
                io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.EPILOGUE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.AnonymousClass1.<clinit>():void");
        }
    }

    public HttpPostMultipartRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException(HttpPostMultipartRequestDecoder.class.getSimpleName() + " was destroyed already");
        }
    }

    private void cleanMixedAttributes() {
        this.currentFieldAttributes.remove(HttpHeaderValues.CHARSET);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_LENGTH);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        this.currentFieldAttributes.remove(HttpHeaderNames.CONTENT_TYPE);
        this.currentFieldAttributes.remove(HttpHeaderValues.FILENAME);
    }

    private static String cleanString(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != 9) {
                if (charAt != '\"') {
                    if (!(charAt == ',' || charAt == '=' || charAt == ':' || charAt == ';')) {
                        sb.append(charAt);
                    }
                }
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e A[SYNTHETIC, Splitter:B:37:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7 A[Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.netty.handler.codec.http.multipart.InterfaceHttpData decodeMultipart(io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus r8) {
        /*
            r7 = this;
            int[] r0 = io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus
            int r8 = r8.ordinal()
            r8 = r0[r8]
            java.lang.String r0 = "Should not be called with the current getStatus"
            r1 = 0
            switch(r8) {
                case 1: goto L_0x0101;
                case 2: goto L_0x00fb;
                case 3: goto L_0x00f0;
                case 4: goto L_0x00eb;
                case 5: goto L_0x0035;
                case 6: goto L_0x002e;
                case 7: goto L_0x0023;
                case 8: goto L_0x001e;
                case 9: goto L_0x0017;
                case 10: goto L_0x0016;
                case 11: goto L_0x0016;
                default: goto L_0x000e;
            }
        L_0x000e:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r7 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            java.lang.String r8 = "Shouldn't reach here."
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x0016:
            return r1
        L_0x0017:
            java.lang.String r8 = r7.multipartMixedBoundary
            io.netty.handler.codec.http.multipart.InterfaceHttpData r7 = r7.getFileUpload(r8)
            return r7
        L_0x001e:
            io.netty.handler.codec.http.multipart.InterfaceHttpData r7 = r7.findMultipartDisposition()
            return r7
        L_0x0023:
            java.lang.String r8 = r7.multipartMixedBoundary
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r0 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.MIXEDDISPOSITION
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER
            io.netty.handler.codec.http.multipart.InterfaceHttpData r7 = r7.findMultipartDelimiter(r8, r0, r1)
            return r7
        L_0x002e:
            java.lang.String r8 = r7.multipartDataBoundary
            io.netty.handler.codec.http.multipart.InterfaceHttpData r7 = r7.getFileUpload(r8)
            return r7
        L_0x0035:
            java.util.Map<java.lang.CharSequence, io.netty.handler.codec.http.multipart.Attribute> r8 = r7.currentFieldAttributes
            io.netty.util.AsciiString r0 = io.netty.handler.codec.http.HttpHeaderValues.CHARSET
            java.lang.Object r8 = r8.get(r0)
            io.netty.handler.codec.http.multipart.Attribute r8 = (io.netty.handler.codec.http.multipart.Attribute) r8
            if (r8 == 0) goto L_0x005a
            java.lang.String r8 = r8.getValue()     // Catch:{ IOException -> 0x004c, UnsupportedCharsetException -> 0x004a }
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r8)     // Catch:{ IOException -> 0x004c, UnsupportedCharsetException -> 0x004a }
            goto L_0x005b
        L_0x004a:
            r7 = move-exception
            goto L_0x004e
        L_0x004c:
            r7 = move-exception
            goto L_0x0054
        L_0x004e:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r8 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x0054:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r8 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x005a:
            r8 = r1
        L_0x005b:
            java.util.Map<java.lang.CharSequence, io.netty.handler.codec.http.multipart.Attribute> r0 = r7.currentFieldAttributes
            io.netty.util.AsciiString r2 = io.netty.handler.codec.http.HttpHeaderValues.NAME
            java.lang.Object r0 = r0.get(r2)
            io.netty.handler.codec.http.multipart.Attribute r0 = (io.netty.handler.codec.http.multipart.Attribute) r0
            io.netty.handler.codec.http.multipart.Attribute r2 = r7.currentAttribute
            if (r2 != 0) goto L_0x00d3
            java.util.Map<java.lang.CharSequence, io.netty.handler.codec.http.multipart.Attribute> r2 = r7.currentFieldAttributes
            io.netty.util.AsciiString r3 = io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH
            java.lang.Object r2 = r2.get(r3)
            io.netty.handler.codec.http.multipart.Attribute r2 = (io.netty.handler.codec.http.multipart.Attribute) r2
            r3 = 0
            if (r2 == 0) goto L_0x0082
            java.lang.String r2 = r2.getValue()     // Catch:{ IOException -> 0x0080, NumberFormatException -> 0x0082 }
            long r5 = java.lang.Long.parseLong(r2)     // Catch:{ IOException -> 0x0080, NumberFormatException -> 0x0082 }
            goto L_0x008a
        L_0x0080:
            r7 = move-exception
            goto L_0x0084
        L_0x0082:
            r5 = r3
            goto L_0x008a
        L_0x0084:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r8 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x008a:
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a7
            io.netty.handler.codec.http.multipart.HttpDataFactory r2 = r7.factory     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            io.netty.handler.codec.http.HttpRequest r3 = r7.request     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            java.lang.String r0 = r0.getValue()     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            java.lang.String r0 = cleanString(r0)     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            io.netty.handler.codec.http.multipart.Attribute r0 = r2.createAttribute((io.netty.handler.codec.http.HttpRequest) r3, (java.lang.String) r0, (long) r5)     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            r7.currentAttribute = r0     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            goto L_0x00b9
        L_0x00a1:
            r7 = move-exception
            goto L_0x00c1
        L_0x00a3:
            r7 = move-exception
            goto L_0x00c7
        L_0x00a5:
            r7 = move-exception
            goto L_0x00cd
        L_0x00a7:
            io.netty.handler.codec.http.multipart.HttpDataFactory r2 = r7.factory     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            io.netty.handler.codec.http.HttpRequest r3 = r7.request     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            java.lang.String r0 = r0.getValue()     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            java.lang.String r0 = cleanString(r0)     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            io.netty.handler.codec.http.multipart.Attribute r0 = r2.createAttribute(r3, r0)     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
            r7.currentAttribute = r0     // Catch:{ NullPointerException -> 0x00a5, IllegalArgumentException -> 0x00a3, IOException -> 0x00a1 }
        L_0x00b9:
            if (r8 == 0) goto L_0x00d3
            io.netty.handler.codec.http.multipart.Attribute r0 = r7.currentAttribute
            r0.setCharset(r8)
            goto L_0x00d3
        L_0x00c1:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r8 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x00c7:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r8 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x00cd:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r8 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r8.<init>((java.lang.Throwable) r7)
            throw r8
        L_0x00d3:
            io.netty.buffer.ByteBuf r8 = r7.undecodedChunk
            java.lang.String r0 = r7.multipartDataBoundary
            io.netty.handler.codec.http.multipart.Attribute r2 = r7.currentAttribute
            boolean r8 = loadDataMultipartOptimized(r8, r0, r2)
            if (r8 != 0) goto L_0x00e0
            return r1
        L_0x00e0:
            io.netty.handler.codec.http.multipart.Attribute r8 = r7.currentAttribute
            r7.currentAttribute = r1
            r7.currentFieldAttributes = r1
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r0 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER
            r7.currentStatus = r0
            return r8
        L_0x00eb:
            io.netty.handler.codec.http.multipart.InterfaceHttpData r7 = r7.findMultipartDisposition()
            return r7
        L_0x00f0:
            java.lang.String r8 = r7.multipartDataBoundary
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r0 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.DISPOSITION
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus r1 = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE
            io.netty.handler.codec.http.multipart.InterfaceHttpData r7 = r7.findMultipartDelimiter(r8, r0, r1)
            return r7
        L_0x00fb:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r7 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r7.<init>((java.lang.String) r0)
            throw r7
        L_0x0101:
            io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException r7 = new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$ErrorDataDecoderException
            r7.<init>((java.lang.String) r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder.decodeMultipart(io.netty.handler.codec.http.multipart.HttpPostRequestDecoder$MultiPartStatus):io.netty.handler.codec.http.multipart.InterfaceHttpData");
    }

    private InterfaceHttpData findMultipartDelimiter(String str, HttpPostRequestDecoder.MultiPartStatus multiPartStatus, HttpPostRequestDecoder.MultiPartStatus multiPartStatus2) {
        int readerIndex = this.undecodedChunk.readerIndex();
        try {
            skipControlCharacters(this.undecodedChunk);
            skipOneLine();
            try {
                String readDelimiterOptimized = readDelimiterOptimized(this.undecodedChunk, str, this.charset);
                if (readDelimiterOptimized.equals(str)) {
                    this.currentStatus = multiPartStatus;
                    return decodeMultipart(multiPartStatus);
                }
                if (readDelimiterOptimized.equals(str + "--")) {
                    this.currentStatus = multiPartStatus2;
                    HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
                    if (multiPartStatus2 != multiPartStatus3) {
                        return null;
                    }
                    this.currentFieldAttributes = null;
                    return decodeMultipart(multiPartStatus3);
                }
                this.undecodedChunk.readerIndex(readerIndex);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException("No Multipart delimiter found");
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(readerIndex);
                return null;
            }
        } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused2) {
            this.undecodedChunk.readerIndex(readerIndex);
            return null;
        }
    }

    private InterfaceHttpData findMultipartDisposition() {
        boolean z;
        int readerIndex = this.undecodedChunk.readerIndex();
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            this.currentFieldAttributes = new TreeMap(CaseIgnoringComparator.INSTANCE);
        }
        while (!skipOneLine()) {
            try {
                skipControlCharacters(this.undecodedChunk);
                String[] splitMultipartHeader = splitMultipartHeader(readLineOptimized(this.undecodedChunk, this.charset));
                boolean z2 = false;
                if (HttpHeaderNames.CONTENT_DISPOSITION.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                    if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
                        z = HttpHeaderValues.FORM_DATA.contentEqualsIgnoreCase(splitMultipartHeader[1]);
                    } else {
                        if (HttpHeaderValues.ATTACHMENT.contentEqualsIgnoreCase(splitMultipartHeader[1]) || HttpHeaderValues.FILE.contentEqualsIgnoreCase(splitMultipartHeader[1])) {
                            z2 = true;
                        }
                        z = z2;
                    }
                    if (z) {
                        int i = 2;
                        while (i < splitMultipartHeader.length) {
                            try {
                                Attribute contentDispositionAttribute = getContentDispositionAttribute(splitMultipartHeader[i].split("=", 2));
                                this.currentFieldAttributes.put(contentDispositionAttribute.getName(), contentDispositionAttribute);
                                i++;
                            } catch (NullPointerException e) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
                            } catch (IllegalArgumentException e2) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e2);
                            }
                        }
                    }
                } else {
                    AsciiString asciiString = HttpHeaderNames.CONTENT_TRANSFER_ENCODING;
                    if (asciiString.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                        try {
                            this.currentFieldAttributes.put(asciiString, this.factory.createAttribute(this.request, asciiString.toString(), cleanString(splitMultipartHeader[1])));
                        } catch (NullPointerException e3) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e3);
                        } catch (IllegalArgumentException e4) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e4);
                        }
                    } else {
                        AsciiString asciiString2 = HttpHeaderNames.CONTENT_LENGTH;
                        if (asciiString2.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                            try {
                                this.currentFieldAttributes.put(asciiString2, this.factory.createAttribute(this.request, asciiString2.toString(), cleanString(splitMultipartHeader[1])));
                            } catch (NullPointerException e5) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e5);
                            } catch (IllegalArgumentException e6) {
                                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e6);
                            }
                        } else if (!HttpHeaderNames.CONTENT_TYPE.contentEqualsIgnoreCase(splitMultipartHeader[0])) {
                            continue;
                        } else if (!HttpHeaderValues.MULTIPART_MIXED.contentEqualsIgnoreCase(splitMultipartHeader[1])) {
                            for (int i2 = 1; i2 < splitMultipartHeader.length; i2++) {
                                AsciiString asciiString3 = HttpHeaderValues.CHARSET;
                                String asciiString4 = asciiString3.toString();
                                if (splitMultipartHeader[i2].regionMatches(true, 0, asciiString4, 0, asciiString4.length())) {
                                    try {
                                        this.currentFieldAttributes.put(asciiString3, this.factory.createAttribute(this.request, asciiString4, cleanString(StringUtil.substringAfter(splitMultipartHeader[i2], '='))));
                                    } catch (NullPointerException e7) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e7);
                                    } catch (IllegalArgumentException e8) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e8);
                                    }
                                } else if (splitMultipartHeader[i2].contains("=")) {
                                    String substringBefore = StringUtil.substringBefore(splitMultipartHeader[i2], '=');
                                    try {
                                        this.currentFieldAttributes.put(substringBefore, this.factory.createAttribute(this.request, cleanString(substringBefore), StringUtil.substringAfter(splitMultipartHeader[i2], '=')));
                                    } catch (NullPointerException e9) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e9);
                                    } catch (IllegalArgumentException e10) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e10);
                                    }
                                } else {
                                    try {
                                        Attribute createAttribute = this.factory.createAttribute(this.request, cleanString(splitMultipartHeader[0]), splitMultipartHeader[i2]);
                                        this.currentFieldAttributes.put(createAttribute.getName(), createAttribute);
                                    } catch (NullPointerException e11) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e11);
                                    } catch (IllegalArgumentException e12) {
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e12);
                                    }
                                }
                            }
                        } else if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
                            this.multipartMixedBoundary = "--" + StringUtil.substringAfter(splitMultipartHeader[2], '=');
                            HttpPostRequestDecoder.MultiPartStatus multiPartStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
                            this.currentStatus = multiPartStatus;
                            return decodeMultipart(multiPartStatus);
                        } else {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Mixed Multipart found in a previous Mixed Multipart");
                        }
                    }
                }
            } catch (HttpPostRequestDecoder.NotEnoughDataDecoderException unused) {
                this.undecodedChunk.readerIndex(readerIndex);
                return null;
            }
        }
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.DISPOSITION) {
            if (attribute != null) {
                HttpPostRequestDecoder.MultiPartStatus multiPartStatus2 = HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD;
                this.currentStatus = multiPartStatus2;
                return decodeMultipart(multiPartStatus2);
            }
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus3 = HttpPostRequestDecoder.MultiPartStatus.FIELD;
            this.currentStatus = multiPartStatus3;
            return decodeMultipart(multiPartStatus3);
        } else if (attribute != null) {
            HttpPostRequestDecoder.MultiPartStatus multiPartStatus4 = HttpPostRequestDecoder.MultiPartStatus.MIXEDFILEUPLOAD;
            this.currentStatus = multiPartStatus4;
            return decodeMultipart(multiPartStatus4);
        } else {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Filename not found");
        }
    }

    private Attribute getContentDispositionAttribute(String... strArr) {
        String cleanString = cleanString(strArr[0]);
        String str = strArr[1];
        AsciiString asciiString = HttpHeaderValues.FILENAME;
        if (asciiString.contentEquals(cleanString)) {
            int length = str.length() - 1;
            if (length > 0 && str.charAt(0) == '\"' && str.charAt(length) == '\"') {
                str = str.substring(1, length);
            }
        } else if (FILENAME_ENCODED.equals(cleanString)) {
            try {
                cleanString = asciiString.toString();
                String[] split = cleanString(str).split("'", 3);
                str = QueryStringDecoder.decodeComponent(split[2], Charset.forName(split[0]));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            } catch (UnsupportedCharsetException e2) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e2);
            }
        } else {
            str = cleanString(str);
        }
        return this.factory.createAttribute(this.request, cleanString, str);
    }

    private static boolean loadDataMultipartOptimized(ByteBuf byteBuf, String str, HttpData httpData) {
        if (!byteBuf.isReadable()) {
            return false;
        }
        int readerIndex = byteBuf.readerIndex();
        byte[] bytes = str.getBytes(httpData.getCharset());
        int findDelimiter = HttpPostBodyUtil.findDelimiter(byteBuf, readerIndex, bytes, true);
        if (findDelimiter < 0) {
            int readableBytes = byteBuf.readableBytes();
            int length = (readableBytes - bytes.length) - 1;
            if (length < 0) {
                length = 0;
            }
            int findLastLineBreak = HttpPostBodyUtil.findLastLineBreak(byteBuf, readerIndex + length);
            if (findLastLineBreak < 0 && httpData.definedLength() == (httpData.length() + ((long) readableBytes)) - 1 && byteBuf.getByte((readableBytes + readerIndex) - 1) == 13) {
                findLastLineBreak = readableBytes - 1;
                length = 0;
            }
            if (findLastLineBreak < 0) {
                try {
                    httpData.addContent(byteBuf.copy(), false);
                    byteBuf.readerIndex(readerIndex);
                    byteBuf.writerIndex(readerIndex);
                    return false;
                } catch (IOException e) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
                }
            } else {
                int i = findLastLineBreak + length;
                if (i == 0) {
                    return false;
                }
                try {
                    httpData.addContent(byteBuf.copy(readerIndex, i), false);
                    rewriteCurrentBuffer(byteBuf, i);
                    return false;
                } catch (IOException e2) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e2);
                }
            }
        } else {
            try {
                httpData.addContent(byteBuf.copy(readerIndex, findDelimiter), true);
                rewriteCurrentBuffer(byteBuf, findDelimiter);
                return true;
            } catch (IOException e3) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e3);
            }
        }
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyMultipart();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyMultipart() {
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null && byteBuf.readableBytes() != 0) {
            InterfaceHttpData decodeMultipart = decodeMultipart(this.currentStatus);
            while (decodeMultipart != null) {
                addHttpData(decodeMultipart);
                HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
                if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
                    decodeMultipart = decodeMultipart(multiPartStatus);
                } else {
                    return;
                }
            }
        }
    }

    private static String readDelimiterOptimized(ByteBuf byteBuf, String str, Charset charset2) {
        int readerIndex = byteBuf.readerIndex();
        byte[] bytes = str.getBytes(charset2);
        int length = bytes.length;
        try {
            int findDelimiter = HttpPostBodyUtil.findDelimiter(byteBuf, readerIndex, bytes, false);
            if (findDelimiter >= 0) {
                StringBuilder sb = new StringBuilder(str);
                byteBuf.readerIndex(findDelimiter + readerIndex + length);
                if (byteBuf.isReadable()) {
                    byte readByte = byteBuf.readByte();
                    if (readByte == 13) {
                        if (byteBuf.readByte() == 10) {
                            return sb.toString();
                        }
                        byteBuf.readerIndex(readerIndex);
                        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                    } else if (readByte == 10) {
                        return sb.toString();
                    } else {
                        if (readByte == 45) {
                            sb.append(Soundex.SILENT_MARKER);
                            if (byteBuf.readByte() == 45) {
                                sb.append(Soundex.SILENT_MARKER);
                                if (!byteBuf.isReadable()) {
                                    return sb.toString();
                                }
                                byte readByte2 = byteBuf.readByte();
                                if (readByte2 == 13) {
                                    if (byteBuf.readByte() == 10) {
                                        return sb.toString();
                                    }
                                    byteBuf.readerIndex(readerIndex);
                                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
                                } else if (readByte2 == 10) {
                                    return sb.toString();
                                } else {
                                    byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                                    return sb.toString();
                                }
                            }
                        }
                    }
                }
                byteBuf.readerIndex(readerIndex);
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
            }
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e) {
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException((Throwable) e);
        }
    }

    private static String readLineOptimized(ByteBuf byteBuf, Charset charset2) {
        ReferenceCounted referenceCounted;
        int readerIndex = byteBuf.readerIndex();
        try {
            if (byteBuf.isReadable()) {
                int findLineBreak = HttpPostBodyUtil.findLineBreak(byteBuf, byteBuf.readerIndex());
                if (findLineBreak > 0) {
                    referenceCounted = null;
                    ByteBuf heapBuffer = byteBuf.alloc().heapBuffer(findLineBreak);
                    heapBuffer.writeBytes(byteBuf, findLineBreak);
                    if (byteBuf.readByte() == 13) {
                        byteBuf.readByte();
                    }
                    String byteBuf2 = heapBuffer.toString(charset2);
                    heapBuffer.release();
                    return byteBuf2;
                }
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
            }
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
        } catch (IndexOutOfBoundsException e) {
            byteBuf.readerIndex(readerIndex);
            throw new HttpPostRequestDecoder.NotEnoughDataDecoderException((Throwable) e);
        } catch (Throwable th) {
            referenceCounted.release();
            throw th;
        }
    }

    private static void rewriteCurrentBuffer(ByteBuf byteBuf, int i) {
        if (i != 0) {
            int readerIndex = byteBuf.readerIndex();
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes == i) {
                byteBuf.readerIndex(readerIndex);
                byteBuf.writerIndex(readerIndex);
                return;
            }
            byteBuf.setBytes(readerIndex, byteBuf, readerIndex + i, readableBytes - i);
            byteBuf.readerIndex(readerIndex);
            byteBuf.writerIndex((readerIndex + readableBytes) - i);
        }
    }

    private static void skipControlCharacters(ByteBuf byteBuf) {
        if (!byteBuf.hasArray()) {
            try {
                skipControlCharactersStandard(byteBuf);
            } catch (IndexOutOfBoundsException e) {
                throw new HttpPostRequestDecoder.NotEnoughDataDecoderException((Throwable) e);
            }
        } else {
            HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(byteBuf);
            while (true) {
                int i = seekAheadOptimize.pos;
                if (i < seekAheadOptimize.limit) {
                    byte[] bArr = seekAheadOptimize.bytes;
                    seekAheadOptimize.pos = i + 1;
                    char c = (char) (bArr[i] & 255);
                    if (!Character.isISOControl(c) && !Character.isWhitespace(c)) {
                        seekAheadOptimize.setReadPosition(1);
                        return;
                    }
                } else {
                    throw new HttpPostRequestDecoder.NotEnoughDataDecoderException("Access out of bounds");
                }
            }
        }
    }

    private static void skipControlCharactersStandard(ByteBuf byteBuf) {
        while (true) {
            char readUnsignedByte = (char) byteBuf.readUnsignedByte();
            if (!Character.isISOControl(readUnsignedByte) && !Character.isWhitespace(readUnsignedByte)) {
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    private boolean skipOneLine() {
        if (!this.undecodedChunk.isReadable()) {
            return false;
        }
        byte readByte = this.undecodedChunk.readByte();
        if (readByte == 13) {
            if (!this.undecodedChunk.isReadable()) {
                ByteBuf byteBuf = this.undecodedChunk;
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return false;
            } else if (this.undecodedChunk.readByte() == 10) {
                return true;
            } else {
                ByteBuf byteBuf2 = this.undecodedChunk;
                byteBuf2.readerIndex(byteBuf2.readerIndex() - 2);
                return false;
            }
        } else if (readByte == 10) {
            return true;
        } else {
            ByteBuf byteBuf3 = this.undecodedChunk;
            byteBuf3.readerIndex(byteBuf3.readerIndex() - 1);
            return false;
        }
    }

    private static String[] splitMultipartHeader(String str) {
        ArrayList arrayList = new ArrayList(1);
        int findNonWhitespace = HttpPostBodyUtil.findNonWhitespace(str, 0);
        int i = findNonWhitespace;
        while (i < str.length() && (r4 = str.charAt(i)) != ':' && !Character.isWhitespace(r4)) {
            i++;
        }
        int i2 = i;
        while (true) {
            if (i2 >= str.length()) {
                break;
            } else if (str.charAt(i2) == ':') {
                i2++;
                break;
            } else {
                i2++;
            }
        }
        int findNonWhitespace2 = HttpPostBodyUtil.findNonWhitespace(str, i2);
        int findEndOfString = HttpPostBodyUtil.findEndOfString(str);
        arrayList.add(str.substring(findNonWhitespace, i));
        String substring = findNonWhitespace2 >= findEndOfString ? "" : str.substring(findNonWhitespace2, findEndOfString);
        for (String trim : substring.indexOf(59) >= 0 ? splitMultipartHeaderValues(substring) : substring.split(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA)) {
            arrayList.add(trim.trim());
        }
        String[] strArr = new String[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            strArr[i3] = (String) arrayList.get(i3);
        }
        return strArr;
    }

    private static String[] splitMultipartHeaderValues(String str) {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList(1);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (z) {
                if (z2) {
                    z2 = false;
                } else if (charAt == '\\') {
                    z2 = true;
                } else if (charAt == '\"') {
                    z = false;
                }
            } else if (charAt == '\"') {
                z = true;
            } else if (charAt == ';') {
                arrayList.add(str.substring(i, i2));
                i = i2 + 1;
            }
        }
        arrayList.add(str.substring(i));
        return (String[]) arrayList.toArray(new String[0]);
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
        FileUpload fileUpload = this.currentFileUpload;
        return fileUpload != null ? fileUpload : this.currentAttribute;
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

    public int getCurrentAllocatedCapacity() {
        return this.undecodedChunk.capacity();
    }

    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    public InterfaceHttpData getFileUpload(String str) {
        String str2;
        Attribute attribute = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TRANSFER_ENCODING);
        Charset charset2 = this.charset;
        HttpPostBodyUtil.TransferEncodingMechanism transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT7;
        if (attribute != null) {
            try {
                String lowerCase = attribute.getValue().toLowerCase();
                if (lowerCase.equals(transferEncodingMechanism.value())) {
                    charset2 = CharsetUtil.US_ASCII;
                } else {
                    transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BIT8;
                    if (lowerCase.equals(transferEncodingMechanism.value())) {
                        charset2 = CharsetUtil.ISO_8859_1;
                    } else {
                        transferEncodingMechanism = HttpPostBodyUtil.TransferEncodingMechanism.BINARY;
                        if (!lowerCase.equals(transferEncodingMechanism.value())) {
                            throw new HttpPostRequestDecoder.ErrorDataDecoderException("TransferEncoding Unknown: " + lowerCase);
                        }
                    }
                }
            } catch (IOException e) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
            }
        }
        Attribute attribute2 = this.currentFieldAttributes.get(HttpHeaderValues.CHARSET);
        if (attribute2 != null) {
            try {
                charset2 = Charset.forName(attribute2.getValue());
            } catch (IOException e2) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e2);
            } catch (UnsupportedCharsetException e3) {
                throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e3);
            }
        }
        Charset charset3 = charset2;
        if (this.currentFileUpload == null) {
            Attribute attribute3 = this.currentFieldAttributes.get(HttpHeaderValues.FILENAME);
            Attribute attribute4 = this.currentFieldAttributes.get(HttpHeaderValues.NAME);
            Attribute attribute5 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_TYPE);
            Attribute attribute6 = this.currentFieldAttributes.get(HttpHeaderNames.CONTENT_LENGTH);
            long j = 0;
            if (attribute6 != null) {
                try {
                    j = Long.parseLong(attribute6.getValue());
                } catch (IOException e4) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e4);
                } catch (NumberFormatException unused) {
                }
            }
            if (attribute5 != null) {
                try {
                    str2 = attribute5.getValue();
                } catch (NullPointerException e5) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e5);
                } catch (IllegalArgumentException e6) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e6);
                } catch (IOException e7) {
                    throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e7);
                }
            } else {
                str2 = "application/octet-stream";
            }
            String str3 = str2;
            this.currentFileUpload = this.factory.createFileUpload(this.request, cleanString(attribute4.getValue()), cleanString(attribute3.getValue()), str3, transferEncodingMechanism.value(), charset3, j);
        }
        if (!loadDataMultipartOptimized(this.undecodedChunk, str, this.currentFileUpload) || !this.currentFileUpload.isCompleted()) {
            return null;
        }
        if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FILEUPLOAD) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
            this.currentFieldAttributes = null;
        } else {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.MIXEDDELIMITER;
            cleanMixedAttributes();
        }
        FileUpload fileUpload = this.currentFileUpload;
        this.currentFileUpload = null;
        return fileUpload;
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
        return true;
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

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    public HttpPostMultipartRequestDecoder offer(HttpContent httpContent) {
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

    public HttpPostMultipartRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset2) {
        String str;
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        HttpRequest httpRequest2 = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, "request");
        this.request = httpRequest2;
        this.charset = (Charset) ObjectUtil.checkNotNull(charset2, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        HttpHeaders headers = httpRequest2.headers();
        AsciiString asciiString = HttpHeaderNames.CONTENT_TYPE;
        String str2 = headers.get((CharSequence) asciiString);
        if (str2 != null) {
            String[] multipartDataBoundary2 = HttpPostRequestDecoder.getMultipartDataBoundary(str2);
            if (multipartDataBoundary2 != null) {
                this.multipartDataBoundary = multipartDataBoundary2[0];
                if (multipartDataBoundary2.length > 1 && (str = multipartDataBoundary2[1]) != null) {
                    try {
                        this.charset = Charset.forName(str);
                    } catch (IllegalCharsetNameException e) {
                        throw new HttpPostRequestDecoder.ErrorDataDecoderException((Throwable) e);
                    }
                }
            } else {
                this.multipartDataBoundary = null;
            }
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.HEADERDELIMITER;
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
        } else {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("No '" + asciiString + "' header present.");
        }
    }

    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
}
