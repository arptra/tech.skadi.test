package org.apache.commons.csv;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.csv.Token;

public final class CSVParser implements Iterable<CSVRecord>, Closeable {
    private final long characterOffset;
    private final CSVRecordIterator csvRecordIterator;
    private final CSVFormat format;
    private String headerComment;
    private final Headers headers;
    private final Lexer lexer;
    private final List<String> recordList;
    private long recordNumber;
    private final Token reusableToken;
    private String trailerComment;

    /* renamed from: org.apache.commons.csv.CSVParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$Token$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.apache.commons.csv.Token$Type[] r0 = org.apache.commons.csv.Token.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$csv$Token$Type = r0
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.TOKEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.EORECORD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.EOF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.INVALID     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$apache$commons$csv$Token$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                org.apache.commons.csv.Token$Type r1 = org.apache.commons.csv.Token.Type.COMMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVParser.AnonymousClass1.<clinit>():void");
        }
    }

    public class CSVRecordIterator implements Iterator<CSVRecord> {
        private CSVRecord current;

        public CSVRecordIterator() {
        }

        private CSVRecord getNextRecord() {
            try {
                return CSVParser.this.nextRecord();
            } catch (IOException e) {
                throw new UncheckedIOException(e.getClass().getSimpleName() + " reading next record: " + e.toString(), e);
            }
        }

        public boolean hasNext() {
            if (CSVParser.this.isClosed()) {
                return false;
            }
            if (this.current == null) {
                this.current = getNextRecord();
            }
            return this.current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public CSVRecord next() {
            if (!CSVParser.this.isClosed()) {
                CSVRecord cSVRecord = this.current;
                this.current = null;
                if (cSVRecord != null || (cSVRecord = getNextRecord()) != null) {
                    return cSVRecord;
                }
                throw new NoSuchElementException("No more CSV records available");
            }
            throw new NoSuchElementException("CSVParser has been closed");
        }
    }

    public static final class Headers {
        final Map<String, Integer> headerMap;
        final List<String> headerNames;

        public Headers(Map<String, Integer> map, List<String> list) {
            this.headerMap = map;
            this.headerNames = list;
        }
    }

    public CSVParser(Reader reader, CSVFormat cSVFormat) throws IOException {
        this(reader, cSVFormat, 0, 1);
    }

    private void addRecordValue(boolean z) {
        String trim = this.format.trim(this.reusableToken.content.toString());
        if (!z || !trim.isEmpty() || !this.format.getTrailingDelimiter()) {
            this.recordList.add(handleNull(trim));
        }
    }

    private Map<String, Integer> createEmptyHeaderMap() {
        return this.format.getIgnoreHeaderCase() ? new TreeMap(String.CASE_INSENSITIVE_ORDER) : new LinkedHashMap();
    }

    private Headers createHeaders() throws IOException {
        Map<String, Integer> map;
        CSVRecord nextRecord;
        String[] header = this.format.getHeader();
        ArrayList arrayList = null;
        if (header != null) {
            map = createEmptyHeaderMap();
            if (header.length == 0) {
                CSVRecord nextRecord2 = nextRecord();
                if (nextRecord2 != null) {
                    String[] values = nextRecord2.values();
                    this.headerComment = nextRecord2.getComment();
                    header = values;
                } else {
                    header = null;
                }
            } else if (this.format.getSkipHeaderRecord() && (nextRecord = nextRecord()) != null) {
                this.headerComment = nextRecord.getComment();
            }
            if (header != null) {
                int i = 0;
                boolean z = false;
                while (i < header.length) {
                    String str = header[i];
                    boolean isBlank = CSVFormat.isBlank(str);
                    if (!isBlank || this.format.getAllowMissingColumnNames()) {
                        boolean containsKey = isBlank ? z : map.containsKey(str);
                        DuplicateHeaderMode duplicateHeaderMode = this.format.getDuplicateHeaderMode();
                        boolean z2 = true;
                        boolean z3 = duplicateHeaderMode == DuplicateHeaderMode.ALLOW_ALL;
                        if (duplicateHeaderMode != DuplicateHeaderMode.ALLOW_EMPTY) {
                            z2 = false;
                        }
                        if (!containsKey || z3 || (isBlank && z2)) {
                            z |= isBlank;
                            if (str != null) {
                                map.put(str, Integer.valueOf(i));
                                if (arrayList == null) {
                                    arrayList = new ArrayList(header.length);
                                }
                                arrayList.add(str);
                            }
                            i++;
                        } else {
                            throw new IllegalArgumentException(String.format("The header contains a duplicate name: \"%s\" in %s. If this is valid then use CSVFormat.Builder.setDuplicateHeaderMode().", new Object[]{str, Arrays.toString(header)}));
                        }
                    } else {
                        throw new IllegalArgumentException("A header name is missing in " + Arrays.toString(header));
                    }
                }
            }
        } else {
            map = null;
        }
        return new Headers(map, arrayList == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList));
    }

    private String handleNull(String str) {
        boolean z = this.reusableToken.isQuoted;
        String nullString = this.format.getNullString();
        boolean isStrictQuoteMode = isStrictQuoteMode();
        if (str.equals(nullString)) {
            if (!isStrictQuoteMode || !z) {
                return null;
            }
            return str;
        } else if (!isStrictQuoteMode || nullString != null || !str.isEmpty() || z) {
            return str;
        } else {
            return null;
        }
    }

    private boolean isStrictQuoteMode() {
        return this.format.getQuoteMode() == QuoteMode.ALL_NON_NULL || this.format.getQuoteMode() == QuoteMode.NON_NUMERIC;
    }

    public static CSVParser parse(File file, Charset charset, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(file, "file");
        return parse(file.toPath(), charset, cSVFormat);
    }

    public void close() throws IOException {
        Lexer lexer2 = this.lexer;
        if (lexer2 != null) {
            lexer2.close();
        }
    }

    public long getCurrentLineNumber() {
        return this.lexer.getCurrentLineNumber();
    }

    public String getFirstEndOfLine() {
        return this.lexer.getFirstEol();
    }

    public String getHeaderComment() {
        return this.headerComment;
    }

    public Map<String, Integer> getHeaderMap() {
        if (this.headers.headerMap == null) {
            return null;
        }
        Map<String, Integer> createEmptyHeaderMap = createEmptyHeaderMap();
        createEmptyHeaderMap.putAll(this.headers.headerMap);
        return createEmptyHeaderMap;
    }

    public Map<String, Integer> getHeaderMapRaw() {
        return this.headers.headerMap;
    }

    public List<String> getHeaderNames() {
        return Collections.unmodifiableList(this.headers.headerNames);
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public List<CSVRecord> getRecords() {
        return (List) stream().collect(Collectors.toList());
    }

    public String getTrailerComment() {
        return this.trailerComment;
    }

    public boolean hasHeaderComment() {
        return this.headerComment != null;
    }

    public boolean hasTrailerComment() {
        return this.trailerComment != null;
    }

    public boolean isClosed() {
        return this.lexer.isClosed();
    }

    public Iterator<CSVRecord> iterator() {
        return this.csvRecordIterator;
    }

    public CSVRecord nextRecord() throws IOException {
        this.recordList.clear();
        long characterPosition = this.lexer.getCharacterPosition() + this.characterOffset;
        String str = null;
        StringBuilder sb = null;
        do {
            this.reusableToken.reset();
            this.lexer.nextToken(this.reusableToken);
            int i = AnonymousClass1.$SwitchMap$org$apache$commons$csv$Token$Type[this.reusableToken.type.ordinal()];
            if (i == 1) {
                addRecordValue(false);
            } else if (i == 2) {
                addRecordValue(true);
            } else if (i != 3) {
                if (i == 4) {
                    throw new IOException("(line " + getCurrentLineNumber() + ") invalid parse sequence");
                } else if (i == 5) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    } else {
                        sb.append(10);
                    }
                    sb.append(this.reusableToken.content);
                    this.reusableToken.type = Token.Type.TOKEN;
                } else {
                    throw new IllegalStateException("Unexpected Token type: " + this.reusableToken.type);
                }
            } else if (this.reusableToken.isReady) {
                addRecordValue(true);
            } else if (sb != null) {
                this.trailerComment = sb.toString();
            }
        } while (this.reusableToken.type == Token.Type.TOKEN);
        if (this.recordList.isEmpty()) {
            return null;
        }
        this.recordNumber++;
        if (sb != null) {
            str = sb.toString();
        }
        return new CSVRecord(this, (String[]) this.recordList.toArray(Constants.EMPTY_STRING_ARRAY), str, this.recordNumber, characterPosition);
    }

    public Stream<CSVRecord> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), 16), false);
    }

    public CSVParser(Reader reader, CSVFormat cSVFormat, long j, long j2) throws IOException {
        this.recordList = new ArrayList();
        this.reusableToken = new Token();
        Objects.requireNonNull(reader, "reader");
        Objects.requireNonNull(cSVFormat, "format");
        this.format = cSVFormat.copy();
        this.lexer = new Lexer(cSVFormat, new ExtendedBufferedReader(reader));
        this.csvRecordIterator = new CSVRecordIterator();
        this.headers = createHeaders();
        this.characterOffset = j;
        this.recordNumber = j2 - 1;
    }

    public static CSVParser parse(InputStream inputStream, Charset charset, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream");
        Objects.requireNonNull(cSVFormat, "format");
        return parse((Reader) new InputStreamReader(inputStream, charset), cSVFormat);
    }

    public static CSVParser parse(Path path, Charset charset, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(path, "path");
        Objects.requireNonNull(cSVFormat, "format");
        return parse(Files.newInputStream(path, new OpenOption[0]), charset, cSVFormat);
    }

    public static CSVParser parse(Reader reader, CSVFormat cSVFormat) throws IOException {
        return new CSVParser(reader, cSVFormat);
    }

    public static CSVParser parse(String str, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(str, "string");
        Objects.requireNonNull(cSVFormat, "format");
        return new CSVParser(new StringReader(str), cSVFormat);
    }

    public static CSVParser parse(URL url, Charset charset, CSVFormat cSVFormat) throws IOException {
        Objects.requireNonNull(url, "url");
        Objects.requireNonNull(charset, "charset");
        Objects.requireNonNull(cSVFormat, "format");
        return new CSVParser(new InputStreamReader(url.openStream(), charset), cSVFormat);
    }
}
