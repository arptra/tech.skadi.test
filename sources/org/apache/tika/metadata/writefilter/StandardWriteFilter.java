package org.apache.tika.metadata.writefilter;

import com.google.common.net.HttpHeaders;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.tika.metadata.AccessPermissions;
import org.apache.tika.metadata.Property;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

public class StandardWriteFilter implements MetadataWriteFilter, Serializable {
    public static final Set<String> ALWAYS_ADD_FIELDS;
    public static final Set<String> ALWAYS_SET_FIELDS;
    private static final String METADATA_TRUNCATED_KEY = TikaCoreProperties.m.getName();
    private static final String TIKA_CONTENT_KEY;
    private static final String[] TRUE = {BooleanUtils.TRUE};
    int estimatedSize = 0;
    private Map<String, Integer> fieldSizes = new HashMap();
    private final boolean includeEmpty;
    private final Set<String> includeFields;
    private final int maxFieldSize;
    private final int maxKeySize;
    private final int maxTotalEstimatedSize;
    private final int maxValuesPerField;
    private final int minimumMaxFieldSizeInAlwaysFields = 300;

    public static class StringSizePair {

        /* renamed from: a  reason: collision with root package name */
        public final String f7117a;
        public final int b;
        public final boolean c;

        public StringSizePair(String str, int i, boolean z) {
            this.f7117a = str;
            this.b = i;
            this.c = z;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        ALWAYS_SET_FIELDS = hashSet;
        HashSet hashSet2 = new HashSet();
        ALWAYS_ADD_FIELDS = hashSet2;
        hashSet.add("Content-Length");
        hashSet.add("Content-Type");
        hashSet.add("Content-Encoding");
        hashSet.add(TikaCoreProperties.w.getName());
        hashSet.add(TikaCoreProperties.x.getName());
        hashSet.add(TikaCoreProperties.v.getName());
        Property property = TikaCoreProperties.g;
        hashSet.add(property.getName());
        hashSet.add("resourceName");
        hashSet.add(AccessPermissions.b.getName());
        hashSet.add(AccessPermissions.c.getName());
        hashSet.add(HttpHeaders.CONTENT_DISPOSITION);
        hashSet.add(TikaCoreProperties.h.getName());
        hashSet.add(TikaCoreProperties.i.getName());
        hashSet2.add(TikaCoreProperties.o.getName());
        TIKA_CONTENT_KEY = property.getName();
    }

    public StandardWriteFilter(int i, int i2, int i3, int i4, Set<String> set, boolean z) {
        this.maxKeySize = i;
        this.maxFieldSize = i2;
        this.maxTotalEstimatedSize = i3;
        this.maxValuesPerField = i4;
        this.includeFields = set;
        this.includeEmpty = z;
    }

    private void addAlwaysInclude(String str, String str2, Map<String, String[]> map) {
        if (TIKA_CONTENT_KEY.equals(str)) {
            map.put(str, new String[]{str2});
        } else if (!map.containsKey(str)) {
            setAlwaysInclude(str, str2, map);
        } else {
            int estimateSize = estimateSize(str2);
            int max = Math.max(300, this.maxFieldSize);
            if (estimateSize > max) {
                str2 = truncate(str2, max, map);
                estimateSize = estimateSize(str2);
            }
            this.estimatedSize += (map.containsKey(str) ? 0 : estimateSize(str)) + estimateSize;
            map.put(str, appendValue(map.get(str), str2));
        }
    }

    private String[] appendValue(String[] strArr, String str) {
        if (str == null) {
            return strArr;
        }
        int length = strArr.length;
        String[] strArr2 = new String[(length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static int estimateSize(String str) {
        return str.length() * 2;
    }

    private StringSizePair filterKey(String str, String str2, Map<String, String[]> map) {
        int estimateSize = estimateSize(str);
        int i = this.maxKeySize;
        if (estimateSize <= i) {
            return new StringSizePair(str, estimateSize, false);
        }
        String truncate = truncate(str, i, map);
        return new StringSizePair(truncate, estimateSize(truncate), true);
    }

    private boolean include(String str, String str2) {
        return includeField(str) && includeValue(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r2 = r2.includeFields;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean includeField(java.lang.String r3) {
        /*
            r2 = this;
            java.util.Set<java.lang.String> r0 = ALWAYS_SET_FIELDS
            boolean r0 = r0.contains(r3)
            r1 = 1
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            java.util.Set<java.lang.String> r2 = r2.includeFields
            if (r2 == 0) goto L_0x0017
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r2 = 0
            return r2
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.metadata.writefilter.StandardWriteFilter.includeField(java.lang.String):boolean");
    }

    private boolean includeValue(String str) {
        return this.includeEmpty || !StringUtils.a(str);
    }

    private int maxAllowedToAdd(StringSizePair stringSizePair) {
        Integer num = this.fieldSizes.get(stringSizePair.f7117a);
        int i = 0;
        int intValue = this.maxFieldSize - (num == null ? 0 : num.intValue());
        int i2 = (this.maxTotalEstimatedSize - this.estimatedSize) - 1;
        if (num == null) {
            i = stringSizePair.b;
        }
        return Math.min(intValue, i2 - i);
    }

    private int maxAllowedToSet(StringSizePair stringSizePair) {
        Integer num = this.fieldSizes.get(stringSizePair.f7117a);
        int i = 0;
        int intValue = (this.maxTotalEstimatedSize - this.estimatedSize) + (num == null ? 0 : num.intValue());
        if (num == null) {
            i = stringSizePair.b;
        }
        return Math.min(this.maxFieldSize, intValue - i);
    }

    private void setAlwaysInclude(String str, String str2, Map<String, String[]> map) {
        if (TIKA_CONTENT_KEY.equals(str)) {
            map.put(str, new String[]{str2});
            return;
        }
        int estimateSize = estimateSize(str2);
        int max = Math.max(300, this.maxFieldSize);
        if (estimateSize > max) {
            str2 = truncate(str2, max, map);
            estimateSize = estimateSize(str2);
        }
        int estimateSize2 = (map.containsKey(str) ? 0 : estimateSize(str)) + estimateSize;
        if (map.containsKey(str)) {
            String[] strArr = map.get(str);
            if (strArr.length > 0) {
                estimateSize2 -= estimateSize(strArr[0]);
            }
        }
        this.estimatedSize += estimateSize2;
        map.put(str, new String[]{str2});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r7 = truncate(r7, r3, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setFilterKey(org.apache.tika.metadata.writefilter.StandardWriteFilter.StringSizePair r6, java.lang.String r7, java.util.Map<java.lang.String, java.lang.String[]> r8) {
        /*
            r5 = this;
            java.lang.String r0 = r6.f7117a
            boolean r0 = r8.containsKey(r0)
            if (r0 != 0) goto L_0x0015
            int r0 = r6.b
            int r1 = r5.estimatedSize
            int r0 = r0 + r1
            int r1 = r5.maxTotalEstimatedSize
            if (r0 <= r1) goto L_0x0015
            r5.setTruncated(r8)
            return
        L_0x0015:
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r5.fieldSizes
            java.lang.String r1 = r6.f7117a
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r1 = 0
            if (r0 != 0) goto L_0x0024
            r2 = r1
            goto L_0x0028
        L_0x0024:
            int r2 = r0.intValue()
        L_0x0028:
            int r3 = r5.maxAllowedToSet(r6)
            if (r3 > 0) goto L_0x0032
            r5.setTruncated(r8)
            return
        L_0x0032:
            int r4 = estimateSize(r7)
            if (r4 <= r3) goto L_0x0043
            java.lang.String r7 = r5.truncate(r7, r3, r8)
            int r4 = estimateSize(r7)
            if (r4 != 0) goto L_0x0043
            return
        L_0x0043:
            if (r0 != 0) goto L_0x0047
            int r1 = r6.b
        L_0x0047:
            int r0 = r4 - r2
            int r1 = r1 + r0
            int r0 = r5.estimatedSize
            int r0 = r0 + r1
            r5.estimatedSize = r0
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r5.fieldSizes
            java.lang.String r0 = r6.f7117a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r5.put(r0, r1)
            java.lang.String r5 = r6.f7117a
            java.lang.String[] r6 = new java.lang.String[]{r7}
            r8.put(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.metadata.writefilter.StandardWriteFilter.setFilterKey(org.apache.tika.metadata.writefilter.StandardWriteFilter$StringSizePair, java.lang.String, java.util.Map):void");
    }

    private void setTruncated(Map<String, String[]> map) {
        map.put(METADATA_TRUNCATED_KEY, TRUE);
    }

    private String truncate(String str, int i, Map<String, String[]> map) {
        setTruncated(map);
        Charset charset = StandardCharsets.UTF_16BE;
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes(charset), 0, i);
        CharBuffer allocate = CharBuffer.allocate(i);
        CharsetDecoder newDecoder = charset.newDecoder();
        newDecoder.onMalformedInput(CodingErrorAction.IGNORE);
        newDecoder.decode(wrap, allocate, true);
        newDecoder.flush(allocate);
        return new String(allocate.array(), 0, allocate.position());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0064, code lost:
        r6 = truncate(r6, r2, r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String[]> r7) {
        /*
            r4 = this;
            boolean r0 = r4.include(r5, r6)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.Set<java.lang.String> r0 = ALWAYS_SET_FIELDS
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x0013
            r4.setAlwaysInclude(r5, r6, r7)
            return
        L_0x0013:
            java.util.Set<java.lang.String> r0 = ALWAYS_ADD_FIELDS
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x001f
            r4.addAlwaysInclude(r5, r6, r7)
            return
        L_0x001f:
            org.apache.tika.metadata.writefilter.StandardWriteFilter$StringSizePair r5 = r4.filterKey(r5, r6, r7)
            java.lang.String r0 = r5.f7117a
            boolean r0 = r7.containsKey(r0)
            if (r0 != 0) goto L_0x002f
            r4.setFilterKey(r5, r6, r7)
            return
        L_0x002f:
            java.lang.String r0 = r5.f7117a
            java.lang.Object r0 = r7.get(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 == 0) goto L_0x0042
            int r0 = r0.length
            int r1 = r4.maxValuesPerField
            if (r0 < r1) goto L_0x0042
            r4.setTruncated(r7)
            return
        L_0x0042:
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r4.fieldSizes
            java.lang.String r1 = r5.f7117a
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 != 0) goto L_0x0050
            r1 = 0
            goto L_0x0054
        L_0x0050:
            int r1 = r0.intValue()
        L_0x0054:
            int r2 = r4.maxAllowedToAdd(r5)
            if (r2 > 0) goto L_0x005e
            r4.setTruncated(r7)
            return
        L_0x005e:
            int r3 = estimateSize(r6)
            if (r3 <= r2) goto L_0x006f
            java.lang.String r6 = r4.truncate(r6, r2, r7)
            int r3 = estimateSize(r6)
            if (r3 != 0) goto L_0x006f
            return
        L_0x006f:
            if (r0 != 0) goto L_0x0075
            int r0 = r5.b
            int r0 = r0 + r3
            goto L_0x0076
        L_0x0075:
            r0 = r3
        L_0x0076:
            int r2 = r4.estimatedSize
            int r2 = r2 + r0
            r4.estimatedSize = r2
            java.util.Map<java.lang.String, java.lang.Integer> r0 = r4.fieldSizes
            java.lang.String r2 = r5.f7117a
            int r3 = r3 + r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0.put(r2, r1)
            java.lang.String r5 = r5.f7117a
            java.lang.Object r0 = r7.get(r5)
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String[] r4 = r4.appendValue(r0, r6)
            r7.put(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.metadata.writefilter.StandardWriteFilter.add(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public void filterExisting(Map<String, String[]> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String[] strArr = (String[]) next.getValue();
            if (includeField(str)) {
                for (String str2 : strArr) {
                    if (include(str, str2)) {
                        add(str, str2, hashMap);
                    }
                }
            }
        }
        map.clear();
        map.putAll(hashMap);
    }

    public void set(String str, String str2, Map<String, String[]> map) {
        if (include(str, str2)) {
            if (ALWAYS_SET_FIELDS.contains(str) || ALWAYS_ADD_FIELDS.contains(str)) {
                setAlwaysInclude(str, str2, map);
            } else {
                setFilterKey(filterKey(str, str2, map), str2, map);
            }
        }
    }
}
