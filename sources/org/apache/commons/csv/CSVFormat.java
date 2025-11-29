package org.apache.commons.csv;

import com.honey.account.qb.a;
import com.honey.account.qb.b;
import com.meizu.common.widget.MzContactsContract;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

public final class CSVFormat implements Serializable {
    public static final CSVFormat DEFAULT;
    public static final CSVFormat EXCEL;
    public static final CSVFormat INFORMIX_UNLOAD;
    public static final CSVFormat INFORMIX_UNLOAD_CSV;
    public static final CSVFormat MONGODB_CSV;
    public static final CSVFormat MONGODB_TSV;
    public static final CSVFormat MYSQL;
    public static final CSVFormat ORACLE;
    public static final CSVFormat POSTGRESQL_CSV;
    public static final CSVFormat POSTGRESQL_TEXT;
    public static final CSVFormat RFC4180;
    public static final CSVFormat TDF;
    private static final long serialVersionUID = 2;
    /* access modifiers changed from: private */
    public final boolean allowMissingColumnNames;
    /* access modifiers changed from: private */
    public final boolean autoFlush;
    /* access modifiers changed from: private */
    public final Character commentMarker;
    /* access modifiers changed from: private */
    public final String delimiter;
    /* access modifiers changed from: private */
    public final DuplicateHeaderMode duplicateHeaderMode;
    /* access modifiers changed from: private */
    public final Character escapeCharacter;
    /* access modifiers changed from: private */
    public final String[] headerComments;
    /* access modifiers changed from: private */
    public final String[] headers;
    /* access modifiers changed from: private */
    public final boolean ignoreEmptyLines;
    /* access modifiers changed from: private */
    public final boolean ignoreHeaderCase;
    /* access modifiers changed from: private */
    public final boolean ignoreSurroundingSpaces;
    /* access modifiers changed from: private */
    public final String nullString;
    /* access modifiers changed from: private */
    public final Character quoteCharacter;
    /* access modifiers changed from: private */
    public final QuoteMode quoteMode;
    /* access modifiers changed from: private */
    public final String quotedNullString;
    /* access modifiers changed from: private */
    public final String recordSeparator;
    /* access modifiers changed from: private */
    public final boolean skipHeaderRecord;
    /* access modifiers changed from: private */
    public final boolean trailingDelimiter;
    /* access modifiers changed from: private */
    public final boolean trim;

    /* renamed from: org.apache.commons.csv.CSVFormat$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$QuoteMode;

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
                org.apache.commons.csv.QuoteMode[] r0 = org.apache.commons.csv.QuoteMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$csv$QuoteMode = r0
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.ALL_NON_NULL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.NON_NUMERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$apache$commons$csv$QuoteMode     // Catch:{ NoSuchFieldError -> 0x003e }
                org.apache.commons.csv.QuoteMode r1 = org.apache.commons.csv.QuoteMode.MINIMAL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean allowMissingColumnNames;
        /* access modifiers changed from: private */
        public boolean autoFlush;
        /* access modifiers changed from: private */
        public Character commentMarker;
        /* access modifiers changed from: private */
        public String delimiter;
        /* access modifiers changed from: private */
        public DuplicateHeaderMode duplicateHeaderMode;
        /* access modifiers changed from: private */
        public Character escapeCharacter;
        /* access modifiers changed from: private */
        public String[] headerComments;
        /* access modifiers changed from: private */
        public String[] headers;
        /* access modifiers changed from: private */
        public boolean ignoreEmptyLines;
        /* access modifiers changed from: private */
        public boolean ignoreHeaderCase;
        /* access modifiers changed from: private */
        public boolean ignoreSurroundingSpaces;
        /* access modifiers changed from: private */
        public String nullString;
        /* access modifiers changed from: private */
        public Character quoteCharacter;
        /* access modifiers changed from: private */
        public QuoteMode quoteMode;
        /* access modifiers changed from: private */
        public String quotedNullString;
        /* access modifiers changed from: private */
        public String recordSeparator;
        /* access modifiers changed from: private */
        public boolean skipHeaderRecord;
        /* access modifiers changed from: private */
        public boolean trailingDelimiter;
        /* access modifiers changed from: private */
        public boolean trim;

        private Builder(CSVFormat cSVFormat) {
            this.delimiter = cSVFormat.delimiter;
            this.quoteCharacter = cSVFormat.quoteCharacter;
            this.quoteMode = cSVFormat.quoteMode;
            this.commentMarker = cSVFormat.commentMarker;
            this.escapeCharacter = cSVFormat.escapeCharacter;
            this.ignoreSurroundingSpaces = cSVFormat.ignoreSurroundingSpaces;
            this.allowMissingColumnNames = cSVFormat.allowMissingColumnNames;
            this.ignoreEmptyLines = cSVFormat.ignoreEmptyLines;
            this.recordSeparator = cSVFormat.recordSeparator;
            this.nullString = cSVFormat.nullString;
            this.headerComments = cSVFormat.headerComments;
            this.headers = cSVFormat.headers;
            this.skipHeaderRecord = cSVFormat.skipHeaderRecord;
            this.ignoreHeaderCase = cSVFormat.ignoreHeaderCase;
            this.trailingDelimiter = cSVFormat.trailingDelimiter;
            this.trim = cSVFormat.trim;
            this.autoFlush = cSVFormat.autoFlush;
            this.quotedNullString = cSVFormat.quotedNullString;
            this.duplicateHeaderMode = cSVFormat.duplicateHeaderMode;
        }

        public static Builder create() {
            return new Builder(CSVFormat.DEFAULT);
        }

        public CSVFormat build() {
            return new CSVFormat(this, (AnonymousClass1) null);
        }

        @Deprecated
        public Builder setAllowDuplicateHeaderNames(boolean z) {
            setDuplicateHeaderMode(z ? DuplicateHeaderMode.ALLOW_ALL : DuplicateHeaderMode.ALLOW_EMPTY);
            return this;
        }

        public Builder setAllowMissingColumnNames(boolean z) {
            this.allowMissingColumnNames = z;
            return this;
        }

        public Builder setAutoFlush(boolean z) {
            this.autoFlush = z;
            return this;
        }

        public Builder setCommentMarker(char c) {
            setCommentMarker(Character.valueOf(c));
            return this;
        }

        public Builder setDelimiter(char c) {
            return setDelimiter(String.valueOf(c));
        }

        public Builder setDuplicateHeaderMode(DuplicateHeaderMode duplicateHeaderMode2) {
            Objects.requireNonNull(duplicateHeaderMode2, "duplicateHeaderMode");
            this.duplicateHeaderMode = duplicateHeaderMode2;
            return this;
        }

        public Builder setEscape(char c) {
            setEscape(Character.valueOf(c));
            return this;
        }

        public Builder setHeader(Class<? extends Enum<?>> cls) {
            String[] strArr;
            if (cls != null) {
                Enum[] enumArr = (Enum[]) cls.getEnumConstants();
                strArr = new String[enumArr.length];
                Arrays.setAll(strArr, new b(enumArr));
            } else {
                strArr = null;
            }
            return setHeader(strArr);
        }

        public Builder setHeaderComments(Object... objArr) {
            this.headerComments = (String[]) CSVFormat.clone(CSVFormat.toStringArray(objArr));
            return this;
        }

        public Builder setIgnoreEmptyLines(boolean z) {
            this.ignoreEmptyLines = z;
            return this;
        }

        public Builder setIgnoreHeaderCase(boolean z) {
            this.ignoreHeaderCase = z;
            return this;
        }

        public Builder setIgnoreSurroundingSpaces(boolean z) {
            this.ignoreSurroundingSpaces = z;
            return this;
        }

        public Builder setNullString(String str) {
            this.nullString = str;
            this.quotedNullString = this.quoteCharacter + str + this.quoteCharacter;
            return this;
        }

        public Builder setQuote(char c) {
            setQuote(Character.valueOf(c));
            return this;
        }

        public Builder setQuoteMode(QuoteMode quoteMode2) {
            this.quoteMode = quoteMode2;
            return this;
        }

        public Builder setRecordSeparator(char c) {
            this.recordSeparator = String.valueOf(c);
            return this;
        }

        public Builder setSkipHeaderRecord(boolean z) {
            this.skipHeaderRecord = z;
            return this;
        }

        public Builder setTrailingDelimiter(boolean z) {
            this.trailingDelimiter = z;
            return this;
        }

        public Builder setTrim(boolean z) {
            this.trim = z;
            return this;
        }

        public static Builder create(CSVFormat cSVFormat) {
            return new Builder(cSVFormat);
        }

        public Builder setCommentMarker(Character ch) {
            if (!CSVFormat.isLineBreak(ch)) {
                this.commentMarker = ch;
                return this;
            }
            throw new IllegalArgumentException("The comment start marker character cannot be a line break");
        }

        public Builder setDelimiter(String str) {
            if (CSVFormat.containsLineBreak(str)) {
                throw new IllegalArgumentException("The delimiter cannot be a line break");
            } else if (!str.isEmpty()) {
                this.delimiter = str;
                return this;
            } else {
                throw new IllegalArgumentException("The delimiter cannot be empty");
            }
        }

        public Builder setEscape(Character ch) {
            if (!CSVFormat.isLineBreak(ch)) {
                this.escapeCharacter = ch;
                return this;
            }
            throw new IllegalArgumentException("The escape character cannot be a line break");
        }

        public Builder setHeaderComments(String... strArr) {
            this.headerComments = (String[]) CSVFormat.clone(strArr);
            return this;
        }

        public Builder setQuote(Character ch) {
            if (!CSVFormat.isLineBreak(ch)) {
                this.quoteCharacter = ch;
                return this;
            }
            throw new IllegalArgumentException("The quoteChar cannot be a line break");
        }

        public Builder setRecordSeparator(String str) {
            this.recordSeparator = str;
            return this;
        }

        public Builder setHeader(ResultSet resultSet) throws SQLException {
            return setHeader(resultSet != null ? resultSet.getMetaData() : null);
        }

        public Builder setHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
            String[] strArr;
            if (resultSetMetaData != null) {
                int columnCount = resultSetMetaData.getColumnCount();
                strArr = new String[columnCount];
                int i = 0;
                while (i < columnCount) {
                    int i2 = i + 1;
                    strArr[i] = resultSetMetaData.getColumnLabel(i2);
                    i = i2;
                }
            } else {
                strArr = null;
            }
            return setHeader(strArr);
        }

        public Builder setHeader(String... strArr) {
            this.headers = (String[]) CSVFormat.clone(strArr);
            return this;
        }
    }

    public enum Predefined {
        Default(CSVFormat.DEFAULT),
        Excel(CSVFormat.EXCEL),
        InformixUnload(CSVFormat.INFORMIX_UNLOAD),
        InformixUnloadCsv(CSVFormat.INFORMIX_UNLOAD_CSV),
        MongoDBCsv(CSVFormat.MONGODB_CSV),
        MongoDBTsv(CSVFormat.MONGODB_TSV),
        MySQL(CSVFormat.MYSQL),
        Oracle(CSVFormat.ORACLE),
        PostgreSQLCsv(CSVFormat.POSTGRESQL_CSV),
        PostgreSQLText(CSVFormat.POSTGRESQL_TEXT),
        RFC4180(CSVFormat.RFC4180),
        TDF(CSVFormat.TDF);
        
        private final CSVFormat format;

        private Predefined(CSVFormat cSVFormat) {
            this.format = cSVFormat;
        }

        public CSVFormat getFormat() {
            return this.format;
        }
    }

    static {
        Character ch = Constants.DOUBLE_QUOTE_CHAR;
        CSVFormat cSVFormat = new CSVFormat(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, ch, (QuoteMode) null, (Character) null, (Character) null, false, true, "\r\n", (String) null, (Object[]) null, (String[]) null, false, false, false, false, false, false, DuplicateHeaderMode.ALLOW_ALL);
        DEFAULT = cSVFormat;
        EXCEL = cSVFormat.builder().setIgnoreEmptyLines(false).setAllowMissingColumnNames(true).build();
        Character ch2 = ch;
        INFORMIX_UNLOAD = cSVFormat.builder().setDelimiter('|').setEscape((char) IOUtils.DIR_SEPARATOR_WINDOWS).setQuote(ch2).setRecordSeparator(10).build();
        INFORMIX_UNLOAD_CSV = cSVFormat.builder().setDelimiter(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA).setQuote(ch2).setRecordSeparator(10).build();
        Builder quote = cSVFormat.builder().setDelimiter(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA).setEscape(ch2).setQuote(ch2);
        QuoteMode quoteMode2 = QuoteMode.MINIMAL;
        MONGODB_CSV = quote.setQuoteMode(quoteMode2).setSkipHeaderRecord(false).build();
        MONGODB_TSV = cSVFormat.builder().setDelimiter(9).setEscape(ch2).setQuote(ch2).setQuoteMode(quoteMode2).setSkipHeaderRecord(false).build();
        Builder nullString2 = cSVFormat.builder().setDelimiter(9).setEscape((char) IOUtils.DIR_SEPARATOR_WINDOWS).setIgnoreEmptyLines(false).setQuote((Character) null).setRecordSeparator(10).setNullString("\\N");
        QuoteMode quoteMode3 = QuoteMode.ALL_NON_NULL;
        MYSQL = nullString2.setQuoteMode(quoteMode3).build();
        ORACLE = cSVFormat.builder().setDelimiter(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA).setEscape((char) IOUtils.DIR_SEPARATOR_WINDOWS).setIgnoreEmptyLines(false).setQuote(ch2).setNullString("\\N").setTrim(true).setRecordSeparator(System.lineSeparator()).setQuoteMode(quoteMode2).build();
        POSTGRESQL_CSV = cSVFormat.builder().setDelimiter(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA).setEscape((Character) null).setIgnoreEmptyLines(false).setQuote(ch2).setRecordSeparator(10).setNullString("").setQuoteMode(quoteMode3).build();
        POSTGRESQL_TEXT = cSVFormat.builder().setDelimiter(9).setEscape((char) IOUtils.DIR_SEPARATOR_WINDOWS).setIgnoreEmptyLines(false).setQuote((Character) null).setRecordSeparator(10).setNullString("\\N").setQuoteMode(quoteMode3).build();
        RFC4180 = cSVFormat.builder().setIgnoreEmptyLines(false).build();
        TDF = cSVFormat.builder().setDelimiter(9).setIgnoreSurroundingSpaces(true).build();
    }

    public /* synthetic */ CSVFormat(Builder builder, AnonymousClass1 r2) {
        this(builder);
    }

    private void append(char c, Appendable appendable) throws IOException {
        appendable.append(c);
    }

    @SafeVarargs
    public static <T> T[] clone(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (Object[]) tArr.clone();
    }

    private static boolean contains(String str, char c) {
        Objects.requireNonNull(str, "source");
        return str.indexOf(c) >= 0;
    }

    /* access modifiers changed from: private */
    public static boolean containsLineBreak(String str) {
        return contains(str, 13) || contains(str, 10);
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    private boolean isDelimiter(char c, CharSequence charSequence, int i, char[] cArr, int i2) {
        if (c != cArr[0] || i + i2 > charSequence.length()) {
            return false;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            if (charSequence.charAt(i + i3) != cArr[i3]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLineBreak(char c) {
        return c == 10 || c == 13;
    }

    private static boolean isTrimChar(char c) {
        return c <= ' ';
    }

    public static CSVFormat newFormat(char c) {
        return new CSVFormat(String.valueOf(c), (Character) null, (QuoteMode) null, (Character) null, (Character) null, false, false, (String) null, (String) null, (Object[]) null, (String[]) null, false, false, false, false, false, false, DuplicateHeaderMode.ALLOW_ALL);
    }

    private void printWithEscapes(CharSequence charSequence, Appendable appendable) throws IOException {
        int length = charSequence.length();
        char[] charArray = getDelimiterString().toCharArray();
        int length2 = charArray.length;
        char charValue = getEscapeCharacter().charValue();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            boolean isDelimiter = isDelimiter(charAt, charSequence, i, charArray, length2);
            if (charAt == 13 || charAt == 10 || charAt == charValue || isDelimiter) {
                if (i > i2) {
                    appendable.append(charSequence, i2, i);
                }
                if (charAt == 10) {
                    charAt = 'n';
                } else if (charAt == 13) {
                    charAt = 'r';
                }
                appendable.append(charValue);
                appendable.append(charAt);
                if (isDelimiter) {
                    for (int i3 = 1; i3 < length2; i3++) {
                        i++;
                        char charAt2 = charSequence.charAt(i);
                        appendable.append(charValue);
                        appendable.append(charAt2);
                    }
                }
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            appendable.append(charSequence, i2, i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
        if (isTrimChar(r6.charAt(r15)) != false) goto L_0x0093;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void printWithQuotes(java.lang.Object r17, java.lang.CharSequence r18, java.lang.Appendable r19, boolean r20) throws java.io.IOException {
        /*
            r16 = this;
            r6 = r18
            r7 = r19
            int r8 = r18.length()
            java.lang.String r0 = r16.getDelimiterString()
            char[] r9 = r0.toCharArray()
            int r10 = r9.length
            java.lang.Character r0 = r16.getQuoteCharacter()
            char r11 = r0.charValue()
            boolean r0 = r16.isEscapeCharacterSet()
            if (r0 == 0) goto L_0x0029
            java.lang.Character r0 = r16.getEscapeCharacter()
            char r0 = r0.charValue()
            r12 = r0
            goto L_0x002a
        L_0x0029:
            r12 = r11
        L_0x002a:
            org.apache.commons.csv.QuoteMode r0 = r16.getQuoteMode()
            if (r0 != 0) goto L_0x0032
            org.apache.commons.csv.QuoteMode r0 = org.apache.commons.csv.QuoteMode.MINIMAL
        L_0x0032:
            int[] r1 = org.apache.commons.csv.CSVFormat.AnonymousClass1.$SwitchMap$org$apache$commons$csv$QuoteMode
            int r2 = r0.ordinal()
            r1 = r1[r2]
            r13 = 1
            r14 = 0
            if (r1 == r13) goto L_0x00bb
            r2 = 2
            if (r1 == r2) goto L_0x00bb
            r2 = 3
            if (r1 == r2) goto L_0x00b6
            r2 = 4
            if (r1 == r2) goto L_0x00b0
            r2 = 5
            if (r1 != r2) goto L_0x0099
            if (r8 > 0) goto L_0x0053
            if (r20 == 0) goto L_0x0050
        L_0x004e:
            r15 = r14
            goto L_0x0093
        L_0x0050:
            r13 = r14
            r15 = r13
            goto L_0x0093
        L_0x0053:
            char r0 = r6.charAt(r14)
            r1 = 35
            if (r0 > r1) goto L_0x005c
            goto L_0x004e
        L_0x005c:
            r15 = r14
        L_0x005d:
            if (r15 >= r8) goto L_0x0082
            char r1 = r6.charAt(r15)
            r0 = 10
            if (r1 == r0) goto L_0x0080
            r0 = 13
            if (r1 == r0) goto L_0x0080
            if (r1 == r11) goto L_0x0080
            if (r1 == r12) goto L_0x0080
            r0 = r16
            r2 = r18
            r3 = r15
            r4 = r9
            r5 = r10
            boolean r0 = r0.isDelimiter(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            int r15 = r15 + 1
            goto L_0x005d
        L_0x0080:
            r0 = r13
            goto L_0x0083
        L_0x0082:
            r0 = r14
        L_0x0083:
            if (r0 != 0) goto L_0x0092
            int r15 = r8 + -1
            char r1 = r6.charAt(r15)
            boolean r1 = isTrimChar(r1)
            if (r1 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r13 = r0
        L_0x0093:
            if (r13 != 0) goto L_0x00bc
            r7.append(r6, r14, r8)
            return
        L_0x0099:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected Quote value: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00b0:
            r0 = r16
            r0.printWithEscapes((java.lang.CharSequence) r6, (java.lang.Appendable) r7)
            return
        L_0x00b6:
            r0 = r17
            boolean r0 = r0 instanceof java.lang.Number
            r13 = r13 ^ r0
        L_0x00bb:
            r15 = r14
        L_0x00bc:
            if (r13 != 0) goto L_0x00c2
            r7.append(r6, r14, r8)
            return
        L_0x00c2:
            r7.append(r11)
        L_0x00c5:
            if (r15 >= r8) goto L_0x00d9
            char r0 = r6.charAt(r15)
            if (r0 == r11) goto L_0x00cf
            if (r0 != r12) goto L_0x00d6
        L_0x00cf:
            r7.append(r6, r14, r15)
            r7.append(r12)
            r14 = r15
        L_0x00d6:
            int r15 = r15 + 1
            goto L_0x00c5
        L_0x00d9:
            r7.append(r6, r14, r15)
            r7.append(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.printWithQuotes(java.lang.Object, java.lang.CharSequence, java.lang.Appendable, boolean):void");
    }

    public static String[] toStringArray(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        Arrays.setAll(strArr, new a(objArr));
        return strArr;
    }

    public static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length && isTrimChar(charSequence, i)) {
            i++;
        }
        int i2 = length;
        while (i < i2 && isTrimChar(charSequence, i2 - 1)) {
            i2--;
        }
        return (i > 0 || i2 < length) ? charSequence.subSequence(i, i2) : charSequence;
    }

    private void validate() throws IllegalArgumentException {
        if (!containsLineBreak(this.delimiter)) {
            Character ch = this.quoteCharacter;
            if (ch == null || !contains(this.delimiter, ch.charValue())) {
                Character ch2 = this.escapeCharacter;
                if (ch2 == null || !contains(this.delimiter, ch2.charValue())) {
                    Character ch3 = this.commentMarker;
                    if (ch3 == null || !contains(this.delimiter, ch3.charValue())) {
                        Character ch4 = this.quoteCharacter;
                        if (ch4 == null || !ch4.equals(this.commentMarker)) {
                            Character ch5 = this.escapeCharacter;
                            if (ch5 != null && ch5.equals(this.commentMarker)) {
                                throw new IllegalArgumentException("The comment start and the escape character cannot be the same ('" + this.commentMarker + "')");
                            } else if (this.escapeCharacter == null && this.quoteMode == QuoteMode.NONE) {
                                throw new IllegalArgumentException("No quotes mode set but no escape character is set");
                            } else if (this.headers != null && this.duplicateHeaderMode != DuplicateHeaderMode.ALLOW_ALL) {
                                HashSet hashSet = new HashSet(this.headers.length);
                                int i = 0;
                                boolean z = this.duplicateHeaderMode == DuplicateHeaderMode.ALLOW_EMPTY;
                                String[] strArr = this.headers;
                                int length = strArr.length;
                                while (i < length) {
                                    String str = strArr[i];
                                    boolean isBlank = isBlank(str);
                                    if (!(!hashSet.add(isBlank ? "" : str)) || (isBlank && z)) {
                                        i++;
                                    } else {
                                        throw new IllegalArgumentException(String.format("The header contains a duplicate name: \"%s\" in %s. If this is valid then use CSVFormat.Builder.setDuplicateHeaderMode().", new Object[]{str, Arrays.toString(this.headers)}));
                                    }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("The comment start character and the quoteChar cannot be the same ('" + this.commentMarker + "')");
                        }
                    } else {
                        throw new IllegalArgumentException("The comment start character and the delimiter cannot be the same ('" + this.commentMarker + "')");
                    }
                } else {
                    throw new IllegalArgumentException("The escape character and the delimiter cannot be the same ('" + this.escapeCharacter + "')");
                }
            } else {
                throw new IllegalArgumentException("The quoteChar character and the delimiter cannot be the same ('" + this.quoteCharacter + "')");
            }
        } else {
            throw new IllegalArgumentException("The delimiter cannot be a line break");
        }
    }

    public static CSVFormat valueOf(String str) {
        return Predefined.valueOf(str).getFormat();
    }

    public Builder builder() {
        return Builder.create(this);
    }

    public CSVFormat copy() {
        return builder().build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CSVFormat.class != obj.getClass()) {
            return false;
        }
        CSVFormat cSVFormat = (CSVFormat) obj;
        return this.duplicateHeaderMode == cSVFormat.duplicateHeaderMode && this.allowMissingColumnNames == cSVFormat.allowMissingColumnNames && this.autoFlush == cSVFormat.autoFlush && Objects.equals(this.commentMarker, cSVFormat.commentMarker) && Objects.equals(this.delimiter, cSVFormat.delimiter) && Objects.equals(this.escapeCharacter, cSVFormat.escapeCharacter) && Arrays.equals(this.headers, cSVFormat.headers) && Arrays.equals(this.headerComments, cSVFormat.headerComments) && this.ignoreEmptyLines == cSVFormat.ignoreEmptyLines && this.ignoreHeaderCase == cSVFormat.ignoreHeaderCase && this.ignoreSurroundingSpaces == cSVFormat.ignoreSurroundingSpaces && Objects.equals(this.nullString, cSVFormat.nullString) && Objects.equals(this.quoteCharacter, cSVFormat.quoteCharacter) && this.quoteMode == cSVFormat.quoteMode && Objects.equals(this.quotedNullString, cSVFormat.quotedNullString) && Objects.equals(this.recordSeparator, cSVFormat.recordSeparator) && this.skipHeaderRecord == cSVFormat.skipHeaderRecord && this.trailingDelimiter == cSVFormat.trailingDelimiter && this.trim == cSVFormat.trim;
    }

    public String format(Object... objArr) {
        StringWriter stringWriter = new StringWriter();
        try {
            CSVPrinter cSVPrinter = new CSVPrinter(stringWriter, this);
            try {
                cSVPrinter.printRecord(objArr);
                String stringWriter2 = stringWriter.toString();
                String substring = stringWriter2.substring(0, this.recordSeparator != null ? stringWriter2.length() - this.recordSeparator.length() : stringWriter2.length());
                cSVPrinter.close();
                return substring;
            } catch (Throwable th) {
                cSVPrinter.close();
                throw th;
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    @Deprecated
    public boolean getAllowDuplicateHeaderNames() {
        return this.duplicateHeaderMode == DuplicateHeaderMode.ALLOW_ALL;
    }

    public boolean getAllowMissingColumnNames() {
        return this.allowMissingColumnNames;
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public Character getCommentMarker() {
        return this.commentMarker;
    }

    @Deprecated
    public char getDelimiter() {
        return this.delimiter.charAt(0);
    }

    public String getDelimiterString() {
        return this.delimiter;
    }

    public DuplicateHeaderMode getDuplicateHeaderMode() {
        return this.duplicateHeaderMode;
    }

    public Character getEscapeCharacter() {
        return this.escapeCharacter;
    }

    public String[] getHeader() {
        String[] strArr = this.headers;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public String[] getHeaderComments() {
        String[] strArr = this.headerComments;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public boolean getIgnoreEmptyLines() {
        return this.ignoreEmptyLines;
    }

    public boolean getIgnoreHeaderCase() {
        return this.ignoreHeaderCase;
    }

    public boolean getIgnoreSurroundingSpaces() {
        return this.ignoreSurroundingSpaces;
    }

    public String getNullString() {
        return this.nullString;
    }

    public Character getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public QuoteMode getQuoteMode() {
        return this.quoteMode;
    }

    public String getRecordSeparator() {
        return this.recordSeparator;
    }

    public boolean getSkipHeaderRecord() {
        return this.skipHeaderRecord;
    }

    public boolean getTrailingDelimiter() {
        return this.trailingDelimiter;
    }

    public boolean getTrim() {
        return this.trim;
    }

    public int hashCode() {
        return ((((Arrays.hashCode(this.headers) + 31) * 31) + Arrays.hashCode(this.headerComments)) * 31) + Objects.hash(new Object[]{this.duplicateHeaderMode, Boolean.valueOf(this.allowMissingColumnNames), Boolean.valueOf(this.autoFlush), this.commentMarker, this.delimiter, this.escapeCharacter, Boolean.valueOf(this.ignoreEmptyLines), Boolean.valueOf(this.ignoreHeaderCase), Boolean.valueOf(this.ignoreSurroundingSpaces), this.nullString, this.quoteCharacter, this.quoteMode, this.quotedNullString, this.recordSeparator, Boolean.valueOf(this.skipHeaderRecord), Boolean.valueOf(this.trailingDelimiter), Boolean.valueOf(this.trim)});
    }

    public boolean isCommentMarkerSet() {
        return this.commentMarker != null;
    }

    public boolean isEscapeCharacterSet() {
        return this.escapeCharacter != null;
    }

    public boolean isNullStringSet() {
        return this.nullString != null;
    }

    public boolean isQuoteCharacterSet() {
        return this.quoteCharacter != null;
    }

    public CSVParser parse(Reader reader) throws IOException {
        return new CSVParser(reader, this);
    }

    public CSVPrinter print(Appendable appendable) throws IOException {
        return new CSVPrinter(appendable, this);
    }

    public synchronized void printRecord(Appendable appendable, Object... objArr) throws IOException {
        int i = 0;
        while (i < objArr.length) {
            try {
                print(objArr[i], appendable, i == 0);
                i++;
            } finally {
            }
        }
        println(appendable);
    }

    public CSVPrinter printer() throws IOException {
        return new CSVPrinter(System.out, this);
    }

    public synchronized void println(Appendable appendable) throws IOException {
        try {
            if (getTrailingDelimiter()) {
                append((CharSequence) getDelimiterString(), appendable);
            }
            String str = this.recordSeparator;
            if (str != null) {
                append((CharSequence) str, appendable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Delimiter=<");
        sb.append(this.delimiter);
        sb.append(Typography.greater);
        if (isEscapeCharacterSet()) {
            sb.append(' ');
            sb.append("Escape=<");
            sb.append(this.escapeCharacter);
            sb.append(Typography.greater);
        }
        if (isQuoteCharacterSet()) {
            sb.append(' ');
            sb.append("QuoteChar=<");
            sb.append(this.quoteCharacter);
            sb.append(Typography.greater);
        }
        if (this.quoteMode != null) {
            sb.append(' ');
            sb.append("QuoteMode=<");
            sb.append(this.quoteMode);
            sb.append(Typography.greater);
        }
        if (isCommentMarkerSet()) {
            sb.append(' ');
            sb.append("CommentStart=<");
            sb.append(this.commentMarker);
            sb.append(Typography.greater);
        }
        if (isNullStringSet()) {
            sb.append(' ');
            sb.append("NullString=<");
            sb.append(this.nullString);
            sb.append(Typography.greater);
        }
        if (this.recordSeparator != null) {
            sb.append(' ');
            sb.append("RecordSeparator=<");
            sb.append(this.recordSeparator);
            sb.append(Typography.greater);
        }
        if (getIgnoreEmptyLines()) {
            sb.append(" EmptyLines:ignored");
        }
        if (getIgnoreSurroundingSpaces()) {
            sb.append(" SurroundingSpaces:ignored");
        }
        if (getIgnoreHeaderCase()) {
            sb.append(" IgnoreHeaderCase:ignored");
        }
        sb.append(" SkipHeaderRecord:");
        sb.append(this.skipHeaderRecord);
        if (this.headerComments != null) {
            sb.append(' ');
            sb.append("HeaderComments:");
            sb.append(Arrays.toString(this.headerComments));
        }
        if (this.headers != null) {
            sb.append(' ');
            sb.append("Header:");
            sb.append(Arrays.toString(this.headers));
        }
        return sb.toString();
    }

    @Deprecated
    public CSVFormat withAllowDuplicateHeaderNames() {
        return builder().setDuplicateHeaderMode(DuplicateHeaderMode.ALLOW_ALL).build();
    }

    @Deprecated
    public CSVFormat withAllowMissingColumnNames() {
        return builder().setAllowMissingColumnNames(true).build();
    }

    @Deprecated
    public CSVFormat withAutoFlush(boolean z) {
        return builder().setAutoFlush(z).build();
    }

    @Deprecated
    public CSVFormat withCommentMarker(char c) {
        return builder().setCommentMarker(c).build();
    }

    @Deprecated
    public CSVFormat withDelimiter(char c) {
        return builder().setDelimiter(c).build();
    }

    @Deprecated
    public CSVFormat withEscape(char c) {
        return builder().setEscape(c).build();
    }

    @Deprecated
    public CSVFormat withFirstRecordAsHeader() {
        return builder().setHeader(new String[0]).setSkipHeaderRecord(true).build();
    }

    @Deprecated
    public CSVFormat withHeader(Class<? extends Enum<?>> cls) {
        return builder().setHeader(cls).build();
    }

    @Deprecated
    public CSVFormat withHeaderComments(Object... objArr) {
        return builder().setHeaderComments(objArr).build();
    }

    @Deprecated
    public CSVFormat withIgnoreEmptyLines() {
        return builder().setIgnoreEmptyLines(true).build();
    }

    @Deprecated
    public CSVFormat withIgnoreHeaderCase() {
        return builder().setIgnoreHeaderCase(true).build();
    }

    @Deprecated
    public CSVFormat withIgnoreSurroundingSpaces() {
        return builder().setIgnoreSurroundingSpaces(true).build();
    }

    @Deprecated
    public CSVFormat withNullString(String str) {
        return builder().setNullString(str).build();
    }

    @Deprecated
    public CSVFormat withQuote(char c) {
        return builder().setQuote(c).build();
    }

    @Deprecated
    public CSVFormat withQuoteMode(QuoteMode quoteMode2) {
        return builder().setQuoteMode(quoteMode2).build();
    }

    @Deprecated
    public CSVFormat withRecordSeparator(char c) {
        return builder().setRecordSeparator(c).build();
    }

    @Deprecated
    public CSVFormat withSkipHeaderRecord() {
        return builder().setSkipHeaderRecord(true).build();
    }

    @Deprecated
    public CSVFormat withSystemRecordSeparator() {
        return builder().setRecordSeparator(System.lineSeparator()).build();
    }

    @Deprecated
    public CSVFormat withTrailingDelimiter() {
        return builder().setTrailingDelimiter(true).build();
    }

    @Deprecated
    public CSVFormat withTrim() {
        return builder().setTrim(true).build();
    }

    private CSVFormat(Builder builder) {
        this.delimiter = builder.delimiter;
        this.quoteCharacter = builder.quoteCharacter;
        this.quoteMode = builder.quoteMode;
        this.commentMarker = builder.commentMarker;
        this.escapeCharacter = builder.escapeCharacter;
        this.ignoreSurroundingSpaces = builder.ignoreSurroundingSpaces;
        this.allowMissingColumnNames = builder.allowMissingColumnNames;
        this.ignoreEmptyLines = builder.ignoreEmptyLines;
        this.recordSeparator = builder.recordSeparator;
        this.nullString = builder.nullString;
        this.headerComments = builder.headerComments;
        this.headers = builder.headers;
        this.skipHeaderRecord = builder.skipHeaderRecord;
        this.ignoreHeaderCase = builder.ignoreHeaderCase;
        this.trailingDelimiter = builder.trailingDelimiter;
        this.trim = builder.trim;
        this.autoFlush = builder.autoFlush;
        this.quotedNullString = builder.quotedNullString;
        this.duplicateHeaderMode = builder.duplicateHeaderMode;
        validate();
    }

    private void append(CharSequence charSequence, Appendable appendable) throws IOException {
        appendable.append(charSequence);
    }

    /* access modifiers changed from: private */
    public static boolean isLineBreak(Character ch) {
        return ch != null && isLineBreak(ch.charValue());
    }

    private static boolean isTrimChar(CharSequence charSequence, int i) {
        return isTrimChar(charSequence.charAt(i));
    }

    public CSVPrinter print(File file, Charset charset) throws IOException {
        return new CSVPrinter(new OutputStreamWriter(new FileOutputStream(file), charset), this);
    }

    @Deprecated
    public CSVFormat withAllowDuplicateHeaderNames(boolean z) {
        return builder().setDuplicateHeaderMode(z ? DuplicateHeaderMode.ALLOW_ALL : DuplicateHeaderMode.ALLOW_EMPTY).build();
    }

    @Deprecated
    public CSVFormat withAllowMissingColumnNames(boolean z) {
        return builder().setAllowMissingColumnNames(z).build();
    }

    @Deprecated
    public CSVFormat withCommentMarker(Character ch) {
        return builder().setCommentMarker(ch).build();
    }

    @Deprecated
    public CSVFormat withEscape(Character ch) {
        return builder().setEscape(ch).build();
    }

    @Deprecated
    public CSVFormat withHeader(ResultSet resultSet) throws SQLException {
        return builder().setHeader(resultSet).build();
    }

    @Deprecated
    public CSVFormat withIgnoreEmptyLines(boolean z) {
        return builder().setIgnoreEmptyLines(z).build();
    }

    @Deprecated
    public CSVFormat withIgnoreHeaderCase(boolean z) {
        return builder().setIgnoreHeaderCase(z).build();
    }

    @Deprecated
    public CSVFormat withIgnoreSurroundingSpaces(boolean z) {
        return builder().setIgnoreSurroundingSpaces(z).build();
    }

    @Deprecated
    public CSVFormat withQuote(Character ch) {
        return builder().setQuote(ch).build();
    }

    @Deprecated
    public CSVFormat withRecordSeparator(String str) {
        return builder().setRecordSeparator(str).build();
    }

    @Deprecated
    public CSVFormat withSkipHeaderRecord(boolean z) {
        return builder().setSkipHeaderRecord(z).build();
    }

    @Deprecated
    public CSVFormat withTrailingDelimiter(boolean z) {
        return builder().setTrailingDelimiter(z).build();
    }

    @Deprecated
    public CSVFormat withTrim(boolean z) {
        return builder().setTrim(z).build();
    }

    public synchronized void print(Object obj, Appendable appendable, boolean z) throws IOException {
        CharSequence charSequence;
        if (obj == null) {
            try {
                charSequence = this.nullString;
                if (charSequence == null) {
                    charSequence = "";
                } else if (QuoteMode.ALL == this.quoteMode) {
                    charSequence = this.quotedNullString;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else if (obj instanceof CharSequence) {
            charSequence = (CharSequence) obj;
        } else if (obj instanceof Reader) {
            print((Reader) obj, appendable, z);
            return;
        } else {
            charSequence = obj.toString();
        }
        if (getTrim()) {
            charSequence = trim(charSequence);
        }
        print(obj, charSequence, appendable, z);
    }

    @Deprecated
    public CSVFormat withHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
        return builder().setHeader(resultSetMetaData).build();
    }

    @Deprecated
    public CSVFormat withHeader(String... strArr) {
        return builder().setHeader(strArr).build();
    }

    public String trim(String str) {
        return getTrim() ? str.trim() : str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void printWithEscapes(java.io.Reader r18, java.lang.Appendable r19) throws java.io.IOException {
        /*
            r17 = this;
            r6 = r17
            r7 = r19
            org.apache.commons.csv.ExtendedBufferedReader r8 = new org.apache.commons.csv.ExtendedBufferedReader
            r0 = r18
            r8.<init>(r0)
            java.lang.String r0 = r17.getDelimiterString()
            char[] r9 = r0.toCharArray()
            int r10 = r9.length
            java.lang.Character r0 = r17.getEscapeCharacter()
            char r11 = r0.charValue()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r0 = 4096(0x1000, float:5.74E-42)
            r12.<init>(r0)
            r14 = 0
            r15 = 0
        L_0x0025:
            int r5 = r8.read()
            r4 = -1
            if (r4 == r5) goto L_0x00a4
            char r1 = (char) r5
            r12.append(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r12.toString()
            r0.append(r2)
            java.lang.String r2 = new java.lang.String
            int r3 = r10 + -1
            char[] r3 = r8.lookAhead((int) r3)
            r2.<init>(r3)
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            r0 = r17
            r3 = r14
            r16 = r4
            r4 = r9
            r13 = r5
            r5 = r10
            boolean r0 = r0.isDelimiter(r1, r2, r3, r4, r5)
            r1 = 10
            r2 = 13
            r3 = 1
            if (r13 == r2) goto L_0x006a
            if (r13 == r1) goto L_0x006a
            if (r13 == r11) goto L_0x006a
            if (r0 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r4 = 0
            goto L_0x00a2
        L_0x006a:
            if (r14 <= r15) goto L_0x007a
            java.lang.String r4 = r12.substring(r15, r14)
            r6.append((java.lang.CharSequence) r4, (java.lang.Appendable) r7)
            r4 = 0
            r12.setLength(r4)
            r14 = r16
            goto L_0x007b
        L_0x007a:
            r4 = 0
        L_0x007b:
            if (r13 != r1) goto L_0x0080
            r5 = 110(0x6e, float:1.54E-43)
            goto L_0x0086
        L_0x0080:
            if (r13 != r2) goto L_0x0085
            r5 = 114(0x72, float:1.6E-43)
            goto L_0x0086
        L_0x0085:
            r5 = r13
        L_0x0086:
            r6.append((char) r11, (java.lang.Appendable) r7)
            char r1 = (char) r5
            r6.append((char) r1, (java.lang.Appendable) r7)
            if (r0 == 0) goto L_0x00a0
            r0 = r3
        L_0x0090:
            if (r0 >= r10) goto L_0x00a0
            int r1 = r8.read()
            r6.append((char) r11, (java.lang.Appendable) r7)
            char r1 = (char) r1
            r6.append((char) r1, (java.lang.Appendable) r7)
            int r0 = r0 + 1
            goto L_0x0090
        L_0x00a0:
            int r15 = r14 + 1
        L_0x00a2:
            int r14 = r14 + r3
            goto L_0x0025
        L_0x00a4:
            if (r14 <= r15) goto L_0x00ad
            java.lang.String r0 = r12.substring(r15, r14)
            r6.append((java.lang.CharSequence) r0, (java.lang.Appendable) r7)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.printWithEscapes(java.io.Reader, java.lang.Appendable):void");
    }

    private synchronized void print(Object obj, CharSequence charSequence, Appendable appendable, boolean z) throws IOException {
        try {
            int length = charSequence.length();
            if (!z) {
                appendable.append(getDelimiterString());
            }
            if (obj == null) {
                appendable.append(charSequence);
            } else if (isQuoteCharacterSet()) {
                printWithQuotes(obj, charSequence, appendable, z);
            } else if (isEscapeCharacterSet()) {
                printWithEscapes(charSequence, appendable);
            } else {
                appendable.append(charSequence, 0, length);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private CSVFormat(String str, Character ch, QuoteMode quoteMode2, Character ch2, Character ch3, boolean z, boolean z2, String str2, String str3, Object[] objArr, String[] strArr, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, DuplicateHeaderMode duplicateHeaderMode2) {
        this.delimiter = str;
        this.quoteCharacter = ch;
        this.quoteMode = quoteMode2;
        this.commentMarker = ch2;
        this.escapeCharacter = ch3;
        this.ignoreSurroundingSpaces = z;
        this.allowMissingColumnNames = z4;
        this.ignoreEmptyLines = z2;
        this.recordSeparator = str2;
        this.nullString = str3;
        this.headerComments = toStringArray(objArr);
        this.headers = (String[]) clone(strArr);
        this.skipHeaderRecord = z3;
        this.ignoreHeaderCase = z5;
        this.trailingDelimiter = z7;
        this.trim = z6;
        this.autoFlush = z8;
        this.quotedNullString = ch + str3 + ch;
        this.duplicateHeaderMode = duplicateHeaderMode2;
        validate();
    }

    private void printWithQuotes(Reader reader, Appendable appendable) throws IOException {
        if (getQuoteMode() == QuoteMode.NONE) {
            printWithEscapes(reader, appendable);
            return;
        }
        char charValue = getQuoteCharacter().charValue();
        StringBuilder sb = new StringBuilder(4096);
        append(charValue, appendable);
        int i = 0;
        while (true) {
            int read = reader.read();
            if (-1 == read) {
                break;
            }
            char c = (char) read;
            sb.append(c);
            if (read == charValue) {
                if (i > 0) {
                    append((CharSequence) sb.substring(0, i), appendable);
                    append(charValue, appendable);
                    sb.setLength(0);
                    i = -1;
                }
                append(c, appendable);
            }
            i++;
        }
        if (i > 0) {
            append((CharSequence) sb.substring(0, i), appendable);
        }
        append(charValue, appendable);
    }

    public CSVPrinter print(Path path, Charset charset) throws IOException {
        return print(Files.newBufferedWriter(path, charset, new OpenOption[0]));
    }

    private void print(Reader reader, Appendable appendable, boolean z) throws IOException {
        if (!z) {
            append((CharSequence) getDelimiterString(), appendable);
        }
        if (isQuoteCharacterSet()) {
            printWithQuotes(reader, appendable);
        } else if (isEscapeCharacterSet()) {
            printWithEscapes(reader, appendable);
        } else if (appendable instanceof Writer) {
            IOUtils.copyLarge(reader, (Writer) appendable);
        } else {
            IOUtils.copy(reader, appendable);
        }
    }
}
