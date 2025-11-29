package org.apache.tika.parser.csv;

import io.netty.util.internal.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.tika.config.Field;
import org.apache.tika.detect.AutoDetectReader;
import org.apache.tika.detect.EncodingDetector;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractEncodingDetectorParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.XHTMLContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class TextAndCSVParser extends AbstractEncodingDetectorParser {
    private static final String CHARSET = "charset";
    private static final Map<Character, String> CHAR_TO_STRING_DELIMITER_MAP;
    static final MediaType CSV;
    private static final String CSV_PREFIX = "csv";
    private static final char[] DEFAULT_DELIMITERS = {StringUtil.COMMA, 9};
    private static final int DEFAULT_MARK_LIMIT = 20000;
    private static final String DELIMITER = "delimiter";
    public static final Property DELIMITER_PROPERTY = Property.k("csv:delimiter");
    public static final Property NUM_COLUMNS = Property.h("csv:num_columns");
    public static final Property NUM_ROWS = Property.h("csv:num_rows");
    private static final Map<String, Character> STRING_TO_CHAR_DELIMITER_MAP = new HashMap();
    private static final Set<MediaType> SUPPORTED_TYPES;
    private static final String TABLE = "table";
    private static final String TD = "td";
    private static final String TR = "tr";
    static final MediaType TSV;
    private char[] delimiters = DEFAULT_DELIMITERS;
    @Field
    private int markLimit = 20000;
    @Field
    private double minConfidence = 0.5d;

    static {
        MediaType text = MediaType.text(CSV_PREFIX);
        CSV = text;
        MediaType text2 = MediaType.text("tsv");
        TSV = text2;
        HashMap hashMap = new HashMap();
        CHAR_TO_STRING_DELIMITER_MAP = hashMap;
        SUPPORTED_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new MediaType[]{text, text2, MediaType.TEXT_PLAIN})));
        hashMap.put(Character.valueOf(StringUtil.COMMA), "comma");
        hashMap.put(9, "tab");
        hashMap.put('|', "pipe");
        hashMap.put(';', "semicolon");
        hashMap.put(':', "colon");
        for (Map.Entry entry : hashMap.entrySet()) {
            STRING_TO_CHAR_DELIMITER_MAP.put((String) entry.getValue(), (Character) entry.getKey());
        }
    }

    public TextAndCSVParser() {
    }

    private Reader detect(CSVParams cSVParams, InputStream inputStream, Metadata metadata, ParseContext parseContext) throws IOException, TikaException {
        AutoDetectReader autoDetectReader;
        String str = metadata.get("Content-Type");
        if (str != null) {
            MediaType parse = MediaType.parse(str);
            if (!SUPPORTED_TYPES.contains(parse.getBaseType())) {
                cSVParams.g(parse);
                return new AutoDetectReader(new CloseShieldInputStream(inputStream), metadata, getEncodingDetector(parseContext));
            }
        }
        if (cSVParams.a() == null) {
            AutoDetectReader autoDetectReader2 = new AutoDetectReader(new CloseShieldInputStream(inputStream), metadata, getEncodingDetector(parseContext));
            cSVParams.e(autoDetectReader2.c());
            autoDetectReader = autoDetectReader2;
            if (cSVParams.d()) {
                return autoDetectReader2;
            }
        } else {
            autoDetectReader = new BufferedReader(new InputStreamReader(new CloseShieldInputStream(inputStream), cSVParams.a()));
        }
        if (cSVParams.b() == null && (cSVParams.c() == null || isCSVOrTSV(cSVParams.c()))) {
            CSVResult b = new CSVSniffer(this.markLimit, this.delimiters, this.minConfidence).b(autoDetectReader, metadata);
            cSVParams.g(b.g());
            cSVParams.f(b.f());
        }
        return autoDetectReader;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.tika.parser.csv.CSVParams getOverride(org.apache.tika.metadata.Metadata r4) {
        /*
            r3 = this;
            org.apache.tika.metadata.Property r3 = org.apache.tika.metadata.TikaCoreProperties.w
            java.lang.String r3 = r4.get((org.apache.tika.metadata.Property) r3)
            if (r3 != 0) goto L_0x000e
            org.apache.tika.parser.csv.CSVParams r3 = new org.apache.tika.parser.csv.CSVParams
            r3.<init>()
            return r3
        L_0x000e:
            org.apache.tika.mime.MediaType r3 = org.apache.tika.mime.MediaType.parse(r3)
            if (r3 != 0) goto L_0x001a
            org.apache.tika.parser.csv.CSVParams r3 = new org.apache.tika.parser.csv.CSVParams
            r3.<init>()
            return r3
        L_0x001a:
            java.util.Map r4 = r3.getParameters()
            java.lang.String r0 = "charset"
            java.lang.Object r4 = r4.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x002d
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)     // Catch:{ UnsupportedCharsetException -> 0x002d }
            goto L_0x002e
        L_0x002d:
            r4 = 0
        L_0x002e:
            boolean r0 = isCSVOrTSV(r3)
            if (r0 != 0) goto L_0x003a
            org.apache.tika.parser.csv.CSVParams r0 = new org.apache.tika.parser.csv.CSVParams
            r0.<init>(r3, r4)
            return r0
        L_0x003a:
            java.util.Map r0 = r3.getParameters()
            java.lang.String r1 = "delimiter"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x004e
            org.apache.tika.parser.csv.CSVParams r0 = new org.apache.tika.parser.csv.CSVParams
            r0.<init>(r3, r4)
            return r0
        L_0x004e:
            java.util.Map<java.lang.String, java.lang.Character> r1 = STRING_TO_CHAR_DELIMITER_MAP
            boolean r2 = r1.containsKey(r0)
            if (r2 == 0) goto L_0x0065
            org.apache.tika.parser.csv.CSVParams r2 = new org.apache.tika.parser.csv.CSVParams
            java.lang.Object r0 = r1.get(r0)
            java.lang.Character r0 = (java.lang.Character) r0
            r0.charValue()
            r2.<init>(r3, r4, r0)
            return r2
        L_0x0065:
            int r1 = r0.length()
            r2 = 1
            if (r1 != r2) goto L_0x007b
            org.apache.tika.parser.csv.CSVParams r1 = new org.apache.tika.parser.csv.CSVParams
            r2 = 0
            char r0 = r0.charAt(r2)
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r1.<init>(r3, r4, r0)
            return r1
        L_0x007b:
            org.apache.tika.parser.csv.CSVParams r0 = new org.apache.tika.parser.csv.CSVParams
            r0.<init>(r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.parser.csv.TextAndCSVParser.getOverride(org.apache.tika.metadata.Metadata):org.apache.tika.parser.csv.CSVParams");
    }

    private static void handleText(Reader reader, XHTMLContentHandler xHTMLContentHandler) throws SAXException, IOException {
        xHTMLContentHandler.r("p");
        char[] cArr = new char[4096];
        int read = reader.read(cArr);
        while (read != -1) {
            xHTMLContentHandler.characters(cArr, 0, read);
            read = reader.read(cArr);
        }
        xHTMLContentHandler.n("p");
    }

    public static boolean isCSVOrTSV(MediaType mediaType) {
        if (mediaType == null) {
            return false;
        }
        return mediaType.getBaseType().equals(TSV) || mediaType.getBaseType().equals(CSV);
    }

    private void updateMetadata(CSVParams cSVParams, Metadata metadata) {
        MediaType baseType = cSVParams.c().getBaseType();
        MediaType mediaType = MediaType.TEXT_PLAIN;
        MediaType parse = baseType.equals(mediaType) ? mediaType : cSVParams.b() != null ? cSVParams.b().charValue() == 9 ? TSV : CSV : metadata.get("Content-Type") != null ? MediaType.parse(metadata.get("Content-Type")) : null;
        HashMap hashMap = new HashMap();
        if (cSVParams.a() != null) {
            hashMap.put("charset", cSVParams.a().name());
            metadata.set("Content-Encoding", cSVParams.a().name());
        }
        if (!parse.equals(mediaType) && cSVParams.b() != null) {
            Map<Character, String> map = CHAR_TO_STRING_DELIMITER_MAP;
            if (map.containsKey(cSVParams.b())) {
                hashMap.put(DELIMITER, map.get(cSVParams.b()));
            } else {
                hashMap.put(DELIMITER, Integer.toString(cSVParams.b().charValue()));
            }
        }
        metadata.set("Content-Type", new MediaType(parse, (Map<String, String>) hashMap).toString());
    }

    public Set<MediaType> getSupportedTypes(ParseContext parseContext) {
        return SUPPORTED_TYPES;
    }

    public void parse(InputStream inputStream, ContentHandler contentHandler, Metadata metadata, ParseContext parseContext) throws IOException, SAXException, TikaException {
        Charset charset;
        Reader reader;
        CSVParams override = getOverride(metadata);
        if (!override.d()) {
            reader = detect(override, inputStream, metadata, parseContext);
            charset = override.a() != null ? override.a() : ((AutoDetectReader) reader).c();
        } else {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, override.a()));
            charset = override.a();
            reader = bufferedReader;
        }
        updateMetadata(override, metadata);
        if (override.c().getBaseType().equals(CSV) || override.c().getBaseType().equals(TSV)) {
            CSVFormat withDelimiter = CSVFormat.EXCEL.withDelimiter(override.b().charValue());
            metadata.set(DELIMITER_PROPERTY, CHAR_TO_STRING_DELIMITER_MAP.get(Character.valueOf(withDelimiter.getDelimiter())));
            XHTMLContentHandler xHTMLContentHandler = new XHTMLContentHandler(contentHandler, metadata);
            CSVParser cSVParser = new CSVParser(reader, withDelimiter);
            try {
                xHTMLContentHandler.startDocument();
                xHTMLContentHandler.r(TABLE);
                Iterator<CSVRecord> it = cSVParser.iterator();
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    xHTMLContentHandler.r("tr");
                    Iterator<String> it2 = it.next().iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        if (i == 0) {
                            i2++;
                        }
                        xHTMLContentHandler.r(TD);
                        xHTMLContentHandler.m(next);
                        xHTMLContentHandler.n(TD);
                    }
                    xHTMLContentHandler.n("tr");
                    if (i == 0) {
                        metadata.set(NUM_COLUMNS, i2);
                    }
                    i++;
                }
                metadata.set(NUM_ROWS, i);
                xHTMLContentHandler.n(TABLE);
                xHTMLContentHandler.endDocument();
                cSVParser.close();
                return;
            } catch (UncheckedIOException e) {
                if (e.getCause() != null) {
                    if (e.getCause().getMessage() != null) {
                        if (e.getCause().getMessage().contains("encapsulated")) {
                            xHTMLContentHandler.n(TABLE);
                            xHTMLContentHandler.s("div", "name", "after exception");
                            handleText(reader, xHTMLContentHandler);
                            xHTMLContentHandler.n("div");
                            xHTMLContentHandler.endDocument();
                            throw new TikaException("exception parsing the csv", e);
                        }
                    }
                }
                if (e.getCause() != null) {
                    throw new TikaException("exception parsing the csv", e.getCause());
                }
                throw new TikaException("exception parsing the csv", e);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            handleText(reader, charset, contentHandler, metadata);
            return;
        }
        throw th;
    }

    public TextAndCSVParser(EncodingDetector encodingDetector) {
        super(encodingDetector);
    }

    private void handleText(Reader reader, Charset charset, ContentHandler contentHandler, Metadata metadata) throws SAXException, IOException, TikaException {
        MediaType parse;
        String str = metadata.get("Content-Type");
        MediaType mediaType = MediaType.TEXT_PLAIN;
        if (!(str == null || (parse = MediaType.parse(str)) == null)) {
            mediaType = parse;
        }
        metadata.set("Content-Type", new MediaType(mediaType, charset).toString());
        metadata.set("Content-Encoding", charset.name());
        XHTMLContentHandler xHTMLContentHandler = new XHTMLContentHandler(contentHandler, metadata);
        xHTMLContentHandler.startDocument();
        handleText(reader, xHTMLContentHandler);
        xHTMLContentHandler.endDocument();
    }
}
