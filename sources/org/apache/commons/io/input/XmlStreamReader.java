package org.apache.commons.io.input;

import com.alibaba.fastjson.asm.Opcodes;
import com.meizu.common.widget.MzContactsContract;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.IOUtils;
import org.apache.tika.mime.MimeTypes;

public class XmlStreamReader extends Reader {
    private static final ByteOrderMark[] BOMS = {ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE};
    private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");
    private static final String EBCDIC = "CP1047";
    public static final Pattern ENCODING_PATTERN = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);
    private static final String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
    private static final String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
    private static final String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
    private static final String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
    private static final String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
    private static final String US_ASCII = "US-ASCII";
    private static final String UTF_16 = "UTF-16";
    private static final String UTF_16BE = "UTF-16BE";
    private static final String UTF_16LE = "UTF-16LE";
    private static final String UTF_32 = "UTF-32";
    private static final String UTF_32BE = "UTF-32BE";
    private static final String UTF_32LE = "UTF-32LE";
    private static final String UTF_8 = "UTF-8";
    private static final ByteOrderMark[] XML_GUESS_BYTES = {new ByteOrderMark("UTF-8", 60, 63, 120, 109), new ByteOrderMark("UTF-16BE", 0, 60, 0, 63), new ByteOrderMark("UTF-16LE", 60, 0, 63, 0), new ByteOrderMark(UTF_32BE, 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109), new ByteOrderMark(UTF_32LE, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0), new ByteOrderMark(EBCDIC, 76, 111, Opcodes.GOTO, Opcodes.LCMP)};
    private final String defaultEncoding;
    private final String encoding;
    private final Reader reader;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public XmlStreamReader(File file) throws IOException {
        this(file.toPath());
        Objects.requireNonNull(file, "file");
    }

    private String doLenientDetection(String str, XmlStreamReaderException xmlStreamReaderException) throws IOException {
        if (str != null && str.startsWith("text/html")) {
            String substring = str.substring(9);
            try {
                return calculateHttpEncoding("text/xml" + substring, xmlStreamReaderException.getBomEncoding(), xmlStreamReaderException.getXmlGuessEncoding(), xmlStreamReaderException.getXmlEncoding(), true);
            } catch (XmlStreamReaderException e) {
                xmlStreamReaderException = e;
            }
        }
        String xmlEncoding = xmlStreamReaderException.getXmlEncoding();
        if (xmlEncoding == null) {
            xmlEncoding = xmlStreamReaderException.getContentTypeEncoding();
        }
        if (xmlEncoding != null) {
            return xmlEncoding;
        }
        String str2 = this.defaultEncoding;
        if (str2 == null) {
            str2 = "UTF-8";
        }
        return str2;
    }

    private String doRawStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, boolean z) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateRawEncoding(bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2));
        } catch (XmlStreamReaderException e) {
            if (z) {
                return doLenientDetection((String) null, e);
            }
            throw e;
        }
    }

    public static String getContentTypeEncoding(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD)) <= -1) {
            return null;
        }
        Matcher matcher = CHARSET_PATTERN.matcher(str.substring(indexOf + 1));
        String group = matcher.find() ? matcher.group(1) : null;
        if (group != null) {
            return group.toUpperCase(Locale.ROOT);
        }
        return null;
    }

    public static String getContentTypeMime(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    private static String getXmlProlog(InputStream inputStream, String str) throws IOException {
        if (str != null) {
            byte[] byteArray = IOUtils.byteArray();
            inputStream.mark(8192);
            int read = inputStream.read(byteArray, 0, 8192);
            String str2 = "";
            int i = 8192;
            int i2 = 0;
            int i3 = -1;
            while (read != -1 && i3 == -1 && i2 < 8192) {
                i2 += read;
                i -= read;
                read = inputStream.read(byteArray, i2, i);
                str2 = new String(byteArray, 0, i2, str);
                i3 = str2.indexOf(62);
            }
            if (i3 == -1) {
                if (read == -1) {
                    throw new IOException("Unexpected end of XML stream");
                }
                throw new IOException("XML prolog or ROOT element not found on first " + i2 + " bytes");
            } else if (i2 > 0) {
                inputStream.reset();
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str2.substring(0, i3 + 1)));
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer);
                if (matcher.find()) {
                    String upperCase = matcher.group(1).toUpperCase(Locale.ROOT);
                    return upperCase.substring(1, upperCase.length() - 1);
                }
            }
        }
        return null;
    }

    public static boolean isAppXml(String str) {
        return str != null && (str.equals(MimeTypes.XML) || str.equals("application/xml-dtd") || str.equals("application/xml-external-parsed-entity") || (str.startsWith("application/") && str.endsWith("+xml")));
    }

    public static boolean isTextXml(String str) {
        return str != null && (str.equals("text/xml") || str.equals("text/xml-external-parsed-entity") || (str.startsWith("text/") && str.endsWith("+xml")));
    }

    private String processHttpStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, String str, boolean z) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateHttpEncoding(str, bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2), z);
        } catch (XmlStreamReaderException e) {
            if (z) {
                return doLenientDetection(str, e);
            }
            throw e;
        }
    }

    public String calculateHttpEncoding(String str, String str2, String str3, String str4, boolean z) throws IOException {
        if (z && str4 != null) {
            return str4;
        }
        String contentTypeMime = getContentTypeMime(str);
        String contentTypeEncoding = getContentTypeEncoding(str);
        boolean isAppXml = isAppXml(contentTypeMime);
        boolean isTextXml = isTextXml(contentTypeMime);
        if (!isAppXml && !isTextXml) {
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_3, new Object[]{contentTypeMime, contentTypeEncoding, str2, str3, str4}), contentTypeMime, contentTypeEncoding, str2, str3, str4);
        } else if (contentTypeEncoding == null) {
            if (isAppXml) {
                return calculateRawEncoding(str2, str3, str4);
            }
            String str5 = this.defaultEncoding;
            return str5 == null ? "US-ASCII" : str5;
        } else if (contentTypeEncoding.equals("UTF-16BE") || contentTypeEncoding.equals("UTF-16LE")) {
            if (str2 == null) {
                return contentTypeEncoding;
            }
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, new Object[]{contentTypeMime, contentTypeEncoding, str2, str3, str4}), contentTypeMime, contentTypeEncoding, str2, str3, str4);
        } else if (contentTypeEncoding.equals("UTF-16")) {
            if (str2 != null && str2.startsWith("UTF-16")) {
                return str2;
            }
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, new Object[]{contentTypeMime, contentTypeEncoding, str2, str3, str4}), contentTypeMime, contentTypeEncoding, str2, str3, str4);
        } else if (contentTypeEncoding.equals(UTF_32BE) || contentTypeEncoding.equals(UTF_32LE)) {
            if (str2 == null) {
                return contentTypeEncoding;
            }
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, new Object[]{contentTypeMime, contentTypeEncoding, str2, str3, str4}), contentTypeMime, contentTypeEncoding, str2, str3, str4);
        } else if (!contentTypeEncoding.equals(UTF_32)) {
            return contentTypeEncoding;
        } else {
            if (str2 != null && str2.startsWith(UTF_32)) {
                return str2;
            }
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, new Object[]{contentTypeMime, contentTypeEncoding, str2, str3, str4}), contentTypeMime, contentTypeEncoding, str2, str3, str4);
        }
    }

    public String calculateRawEncoding(String str, String str2, String str3) throws IOException {
        if (str == null) {
            if (str2 != null && str3 != null) {
                return (!str3.equals("UTF-16") || (!str2.equals("UTF-16BE") && !str2.equals("UTF-16LE"))) ? str3 : str2;
            }
            String str4 = this.defaultEncoding;
            return str4 == null ? "UTF-8" : str4;
        } else if (str.equals("UTF-8")) {
            if (str2 != null && !str2.equals("UTF-8")) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, new Object[]{str, str2, str3}), str, str2, str3);
            } else if (str3 == null || str3.equals("UTF-8")) {
                return str;
            } else {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, new Object[]{str, str2, str3}), str, str2, str3);
            }
        } else if (str.equals("UTF-16BE") || str.equals("UTF-16LE")) {
            if (str2 != null && !str2.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, new Object[]{str, str2, str3}), str, str2, str3);
            } else if (str3 == null || str3.equals("UTF-16") || str3.equals(str)) {
                return str;
            } else {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, new Object[]{str, str2, str3}), str, str2, str3);
            }
        } else if (!str.equals(UTF_32BE) && !str.equals(UTF_32LE)) {
            throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_2, new Object[]{str, str2, str3}), str, str2, str3);
        } else if (str2 != null && !str2.equals(str)) {
            throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, new Object[]{str, str2, str3}), str, str2, str3);
        } else if (str3 == null || str3.equals(UTF_32) || str3.equals(str)) {
            return str;
        } else {
            throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, new Object[]{str, str2, str3}), str, str2, str3);
        }
    }

    public void close() throws IOException {
        this.reader.close();
    }

    public String getDefaultEncoding() {
        return this.defaultEncoding;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        return this.reader.read(cArr, i, i2);
    }

    public XmlStreamReader(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public XmlStreamReader(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, z, (String) null);
    }

    public XmlStreamReader(InputStream inputStream, boolean z, String str) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream");
        this.defaultEncoding = str;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 8192), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        String doRawStream = doRawStream(bOMInputStream, bOMInputStream2, z);
        this.encoding = doRawStream;
        this.reader = new InputStreamReader(bOMInputStream2, doRawStream);
    }

    public XmlStreamReader(InputStream inputStream, String str) throws IOException {
        this(inputStream, str, true);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z) throws IOException {
        this(inputStream, str, z, (String) null);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z, String str2) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream");
        this.defaultEncoding = str2;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 8192), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        String processHttpStream = processHttpStream(bOMInputStream, bOMInputStream2, str, z);
        this.encoding = processHttpStream;
        this.reader = new InputStreamReader(bOMInputStream2, processHttpStream);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public XmlStreamReader(Path path) throws IOException {
        this(Files.newInputStream(path, new OpenOption[0]));
        Objects.requireNonNull(path, "file");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public XmlStreamReader(URL url) throws IOException {
        this(url.openConnection(), (String) null);
        Objects.requireNonNull(url, "url");
    }

    public XmlStreamReader(URLConnection uRLConnection, String str) throws IOException {
        Objects.requireNonNull(uRLConnection, "conn");
        this.defaultEncoding = str;
        String contentType = uRLConnection.getContentType();
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(uRLConnection.getInputStream(), 8192), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        if ((uRLConnection instanceof HttpURLConnection) || contentType != null) {
            this.encoding = processHttpStream(bOMInputStream, bOMInputStream2, contentType, true);
        } else {
            this.encoding = doRawStream(bOMInputStream, bOMInputStream2, true);
        }
        this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
    }
}
