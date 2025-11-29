package org.apache.tika.mime;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class MediaType implements Comparable<MediaType>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final MediaType APPLICATION_XML = parse(MimeTypes.XML);
    public static final MediaType APPLICATION_ZIP = parse("application/zip");
    private static final Pattern CHARSET_FIRST_PATTERN = Pattern.compile("(?is)\\s*(charset\\s*=\\s*[^\\c;\\s]+)\\s*;\\s*([^\\c\\(\\)<>@,;:\\\\\"/\\[\\]\\?=\\s]+)\\s*/\\s*([^\\c\\(\\)<>@,;:\\\\\"/\\[\\]\\?=\\s]+)\\s*");
    public static final MediaType EMPTY = parse("application/x-empty");
    public static final MediaType OCTET_STREAM = parse("application/octet-stream");
    private static final Map<String, MediaType> SIMPLE_TYPES = new HashMap();
    private static final Pattern SPECIAL = Pattern.compile("[\\(\\)<>@,;:\\\\\"/\\[\\]\\?=]");
    private static final Pattern SPECIAL_OR_WHITESPACE = Pattern.compile("[\\(\\)<>@,;:\\\\\"/\\[\\]\\?=\\s]");
    public static final MediaType TEXT_HTML = parse("text/html");
    public static final MediaType TEXT_PLAIN = parse("text/plain");
    private static final Pattern TYPE_PATTERN = Pattern.compile("(?s)\\s*([^\\c\\(\\)<>@,;:\\\\\"/\\[\\]\\?=\\s]+)\\s*/\\s*([^\\c\\(\\)<>@,;:\\\\\"/\\[\\]\\?=\\s]+)\\s*($|;.*)");
    private static final String VALID_CHARS = "([^\\c\\(\\)<>@,;:\\\\\"/\\[\\]\\?=\\s]+)";
    private static final long serialVersionUID = -3831000556189036392L;
    private final Map<String, String> parameters;
    private final int semicolon;
    private final int slash;
    private final String string;

    public MediaType(String str, String str2, Map<String, String> map) {
        String trim = str.trim();
        Locale locale = Locale.ENGLISH;
        String lowerCase = trim.toLowerCase(locale);
        String lowerCase2 = str2.trim().toLowerCase(locale);
        int length = lowerCase.length();
        this.slash = length;
        this.semicolon = length + 1 + lowerCase2.length();
        if (map.isEmpty()) {
            this.parameters = Collections.emptyMap();
            this.string = lowerCase + '/' + lowerCase2;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lowerCase);
        sb.append('/');
        sb.append(lowerCase2);
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            treeMap.put(((String) next.getKey()).trim().toLowerCase(Locale.ENGLISH), (String) next.getValue());
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append("; ");
            sb.append((String) entry.getKey());
            sb.append("=");
            String str3 = (String) entry.getValue();
            if (SPECIAL_OR_WHITESPACE.matcher(str3).find()) {
                sb.append('\"');
                sb.append(SPECIAL.matcher(str3).replaceAll("\\\\$0"));
                sb.append('\"');
            } else {
                sb.append(str3);
            }
        }
        this.string = sb.toString();
        this.parameters = Collections.unmodifiableSortedMap(treeMap);
    }

    public static MediaType application(String str) {
        return parse("application/" + str);
    }

    public static MediaType audio(String str) {
        return parse("audio/" + str);
    }

    public static MediaType image(String str) {
        return parse("image/" + str);
    }

    private static boolean isSimpleName(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '-' && charAt != '+' && charAt != '.' && charAt != '_' && (('0' > charAt || charAt > '9') && ('a' > charAt || charAt > 'z'))) {
                return false;
            }
        }
        return str.length() > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        r1 = TYPE_PATTERN.matcher(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r1.matches() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        return new org.apache.tika.mime.MediaType(r1.group(1), r1.group(2), parseParameters(r1.group(3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        r6 = CHARSET_FIRST_PATTERN.matcher(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        if (r6.matches() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return new org.apache.tika.mime.MediaType(r6.group(2), r6.group(3), parseParameters(r6.group(1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.tika.mime.MediaType parse(java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Map<java.lang.String, org.apache.tika.mime.MediaType> r1 = SIMPLE_TYPES
            monitor-enter(r1)
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x001a }
            org.apache.tika.mime.MediaType r2 = (org.apache.tika.mime.MediaType) r2     // Catch:{ all -> 0x001a }
            if (r2 != 0) goto L_0x0043
            r3 = 47
            int r3 = r6.indexOf(r3)     // Catch:{ all -> 0x001a }
            r4 = -1
            if (r3 != r4) goto L_0x001c
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            return r0
        L_0x001a:
            r6 = move-exception
            goto L_0x008f
        L_0x001c:
            int r4 = r1.size()     // Catch:{ all -> 0x001a }
            r5 = 10000(0x2710, float:1.4013E-41)
            if (r4 >= r5) goto L_0x0043
            r4 = 0
            java.lang.String r4 = r6.substring(r4, r3)     // Catch:{ all -> 0x001a }
            boolean r4 = isSimpleName(r4)     // Catch:{ all -> 0x001a }
            if (r4 == 0) goto L_0x0043
            int r4 = r3 + 1
            java.lang.String r4 = r6.substring(r4)     // Catch:{ all -> 0x001a }
            boolean r4 = isSimpleName(r4)     // Catch:{ all -> 0x001a }
            if (r4 == 0) goto L_0x0043
            org.apache.tika.mime.MediaType r2 = new org.apache.tika.mime.MediaType     // Catch:{ all -> 0x001a }
            r2.<init>((java.lang.String) r6, (int) r3)     // Catch:{ all -> 0x001a }
            r1.put(r6, r2)     // Catch:{ all -> 0x001a }
        L_0x0043:
            if (r2 == 0) goto L_0x0047
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            return r2
        L_0x0047:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            java.util.regex.Pattern r1 = TYPE_PATTERN
            java.util.regex.Matcher r1 = r1.matcher(r6)
            boolean r2 = r1.matches()
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x006d
            org.apache.tika.mime.MediaType r6 = new org.apache.tika.mime.MediaType
            java.lang.String r0 = r1.group(r5)
            java.lang.String r2 = r1.group(r4)
            java.lang.String r1 = r1.group(r3)
            java.util.Map r1 = parseParameters(r1)
            r6.<init>((java.lang.String) r0, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r1)
            return r6
        L_0x006d:
            java.util.regex.Pattern r1 = CHARSET_FIRST_PATTERN
            java.util.regex.Matcher r6 = r1.matcher(r6)
            boolean r1 = r6.matches()
            if (r1 == 0) goto L_0x008e
            org.apache.tika.mime.MediaType r0 = new org.apache.tika.mime.MediaType
            java.lang.String r1 = r6.group(r4)
            java.lang.String r2 = r6.group(r3)
            java.lang.String r6 = r6.group(r5)
            java.util.Map r6 = parseParameters(r6)
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r6)
        L_0x008e:
            return r0
        L_0x008f:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.mime.MediaType.parse(java.lang.String):org.apache.tika.mime.MediaType");
    }

    private static Map<String, String> parseParameters(String str) {
        String str2;
        if (str.length() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        while (str.length() > 0) {
            int indexOf = str.indexOf(59);
            String str3 = "";
            if (indexOf != -1) {
                String substring = str.substring(0, indexOf);
                str2 = str.substring(indexOf + 1);
                str = substring;
            } else {
                str2 = str3;
            }
            int indexOf2 = str.indexOf(61);
            if (indexOf2 != -1) {
                str3 = str.substring(indexOf2 + 1);
                str = str.substring(0, indexOf2);
            }
            String trim = str.trim();
            if (trim.length() > 0) {
                hashMap.put(trim, unquote(str3.trim()));
            }
            str = str2;
        }
        return hashMap;
    }

    public static Set<MediaType> set(MediaType... mediaTypeArr) {
        HashSet hashSet = new HashSet();
        for (MediaType mediaType : mediaTypeArr) {
            if (mediaType != null) {
                hashSet.add(mediaType);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static MediaType text(String str) {
        return parse("text/" + str);
    }

    private static Map<String, String> union(Map<String, String> map, Map<String, String> map2) {
        if (map.isEmpty()) {
            return map2;
        }
        if (map2.isEmpty()) {
            return map;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    private static String unquote(String str) {
        while (true) {
            if (!str.startsWith("\"") && !str.startsWith("'")) {
                break;
            }
            str = str.substring(1);
        }
        while (true) {
            if (!str.endsWith("\"") && !str.endsWith("'")) {
                return str;
            }
            str = str.substring(0, str.length() - 1);
        }
    }

    public static MediaType video(String str) {
        return parse("video/" + str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MediaType) {
            return this.string.equals(((MediaType) obj).string);
        }
        return false;
    }

    public MediaType getBaseType() {
        return this.parameters.isEmpty() ? this : parse(this.string.substring(0, this.semicolon));
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public String getSubtype() {
        return this.string.substring(this.slash + 1, this.semicolon);
    }

    public String getType() {
        return this.string.substring(0, this.slash);
    }

    public boolean hasParameters() {
        return !this.parameters.isEmpty();
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    public String toString() {
        return this.string;
    }

    public int compareTo(MediaType mediaType) {
        return this.string.compareTo(mediaType.string);
    }

    public static Set<MediaType> set(String... strArr) {
        HashSet hashSet = new HashSet();
        for (String parse : strArr) {
            MediaType parse2 = parse(parse);
            if (parse2 != null) {
                hashSet.add(parse2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public MediaType(String str, String str2) {
        this(str, str2, (Map<String, String>) Collections.emptyMap());
    }

    private MediaType(String str, int i) {
        this.string = str;
        this.slash = i;
        this.semicolon = str.length();
        this.parameters = Collections.emptyMap();
    }

    public MediaType(MediaType mediaType, Map<String, String> map) {
        this(mediaType.getType(), mediaType.getSubtype(), union(mediaType.parameters, map));
    }

    public MediaType(MediaType mediaType, String str, String str2) {
        this(mediaType, (Map<String, String>) Collections.singletonMap(str, str2));
    }

    public MediaType(MediaType mediaType, Charset charset) {
        this(mediaType, "charset", charset.name());
    }
}
