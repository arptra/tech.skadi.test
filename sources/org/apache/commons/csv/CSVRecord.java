package org.apache.commons.csv;

import com.honey.account.qb.e;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class CSVRecord implements Serializable, Iterable<String> {
    private static final long serialVersionUID = 1;
    private final long characterPosition;
    private final String comment;
    private final transient CSVParser parser;
    private final long recordNumber;
    private final String[] values;

    public CSVRecord(CSVParser cSVParser, String[] strArr, String str, long j, long j2) {
        this.recordNumber = j;
        this.values = strArr == null ? Constants.EMPTY_STRING_ARRAY : strArr;
        this.parser = cSVParser;
        this.comment = str;
        this.characterPosition = j2;
    }

    private Map<String, Integer> getHeaderMapRaw() {
        CSVParser cSVParser = this.parser;
        if (cSVParser == null) {
            return null;
        }
        return cSVParser.getHeaderMapRaw();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$putIn$0(Map map, String str, Integer num) {
        int intValue = num.intValue();
        String[] strArr = this.values;
        if (intValue < strArr.length) {
            map.put(str, strArr[num.intValue()]);
        }
    }

    public String get(Enum<?> enumR) {
        return get(enumR == null ? null : enumR.name());
    }

    public long getCharacterPosition() {
        return this.characterPosition;
    }

    public String getComment() {
        return this.comment;
    }

    public CSVParser getParser() {
        return this.parser;
    }

    public long getRecordNumber() {
        return this.recordNumber;
    }

    public boolean hasComment() {
        return this.comment != null;
    }

    public boolean isConsistent() {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw == null || headerMapRaw.size() == this.values.length;
    }

    public boolean isMapped(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        return headerMapRaw != null && headerMapRaw.containsKey(str);
    }

    public boolean isSet(int i) {
        return i >= 0 && i < this.values.length;
    }

    public Iterator<String> iterator() {
        return toList().iterator();
    }

    public <M extends Map<String, String>> M putIn(M m) {
        if (getHeaderMapRaw() == null) {
            return m;
        }
        getHeaderMapRaw().forEach(new e(this, m));
        return m;
    }

    public int size() {
        return this.values.length;
    }

    public Stream<String> stream() {
        return Stream.of(this.values);
    }

    public List<String> toList() {
        return (List) stream().collect(Collectors.toList());
    }

    public Map<String, String> toMap() {
        return putIn(new LinkedHashMap(this.values.length));
    }

    public String toString() {
        return "CSVRecord [comment='" + this.comment + "', recordNumber=" + this.recordNumber + ", values=" + Arrays.toString(this.values) + "]";
    }

    public String[] values() {
        return this.values;
    }

    public String get(int i) {
        return this.values[i];
    }

    public boolean isSet(String str) {
        return isMapped(str) && getHeaderMapRaw().get(str).intValue() < this.values.length;
    }

    public String get(String str) {
        Map<String, Integer> headerMapRaw = getHeaderMapRaw();
        if (headerMapRaw != null) {
            Integer num = headerMapRaw.get(str);
            if (num != null) {
                try {
                    return this.values[num.intValue()];
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new IllegalArgumentException(String.format("Index for header '%s' is %d but CSVRecord only has %d values!", new Object[]{str, num, Integer.valueOf(this.values.length)}));
                }
            } else {
                throw new IllegalArgumentException(String.format("Mapping for %s not found, expected one of %s", new Object[]{str, headerMapRaw.keySet()}));
            }
        } else {
            throw new IllegalStateException("No header mapping was specified, the record values can't be accessed by name");
        }
    }
}
