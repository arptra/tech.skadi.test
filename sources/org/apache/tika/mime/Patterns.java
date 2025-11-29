package org.apache.tika.mime;

import com.meizu.common.util.CommonConstants;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.io.IOUtils;

class Patterns implements Serializable {
    private static final long serialVersionUID = -5778015347278111140L;
    private final Map<String, MimeType> extensions = new HashMap();
    private final SortedMap<String, MimeType> globs = new TreeMap(new LengthComparator());
    private int maxExtensionLength = 0;
    private int minExtensionLength = Integer.MAX_VALUE;
    private final Map<String, MimeType> names = new HashMap();
    private final MediaTypeRegistry registry;

    public static final class LengthComparator implements Comparator<String>, Serializable {
        private static final long serialVersionUID = 8468289702915532359L;

        private LengthComparator() {
        }

        public int compare(String str, String str2) {
            int length = str2.length() - str.length();
            return length == 0 ? str.compareTo(str2) : length;
        }
    }

    public Patterns(MediaTypeRegistry mediaTypeRegistry) {
        this.registry = mediaTypeRegistry;
    }

    private void addExtension(String str, MimeType mimeType) throws MimeTypeException {
        MimeType mimeType2 = this.extensions.get(str);
        if (mimeType2 == null || this.registry.isSpecializationOf(mimeType2.getType(), mimeType.getType())) {
            this.extensions.put(str, mimeType);
            int length = str.length();
            this.minExtensionLength = Math.min(this.minExtensionLength, length);
            this.maxExtensionLength = Math.max(this.maxExtensionLength, length);
        } else if (mimeType2 != mimeType && !this.registry.isSpecializationOf(mimeType.getType(), mimeType2.getType())) {
            throw new MimeTypeException("Conflicting extension pattern: " + str);
        }
    }

    private void addGlob(String str, MimeType mimeType) throws MimeTypeException {
        MimeType mimeType2 = this.globs.get(str);
        if (mimeType2 == null || this.registry.isSpecializationOf(mimeType2.getType(), mimeType.getType())) {
            this.globs.put(str, mimeType);
        } else if (mimeType2 != mimeType && !this.registry.isSpecializationOf(mimeType.getType(), mimeType2.getType())) {
            throw new MimeTypeException("Conflicting glob pattern: " + str);
        }
    }

    private void addName(String str, MimeType mimeType) throws MimeTypeException {
        MimeType mimeType2 = this.names.get(str);
        if (mimeType2 == null || this.registry.isSpecializationOf(mimeType2.getType(), mimeType.getType())) {
            this.names.put(str, mimeType);
        } else if (mimeType2 != mimeType && !this.registry.isSpecializationOf(mimeType.getType(), mimeType2.getType())) {
            throw new MimeTypeException("Conflicting name pattern: " + str);
        }
    }

    private String compile(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\A");
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '?') {
                sb.append('.');
            } else if (charAt == '*') {
                sb.append(CommonConstants.IS_FLYME_OS_4_MATCH);
            } else if ("\\[]^.-$+(){}|".indexOf(charAt) != -1) {
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                sb.append(charAt);
            } else {
                sb.append(charAt);
            }
        }
        sb.append("\\z");
        return sb.toString();
    }

    public void add(String str, MimeType mimeType) throws MimeTypeException {
        add(str, false, mimeType);
    }

    public MimeType matches(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Name is missing");
        } else if (this.names.containsKey(str)) {
            return this.names.get(str);
        } else {
            for (int min = Math.min(this.maxExtensionLength, str.length()); min >= this.minExtensionLength; min--) {
                String substring = str.substring(str.length() - min);
                if (this.extensions.containsKey(substring)) {
                    return this.extensions.get(substring);
                }
            }
            for (Map.Entry next : this.globs.entrySet()) {
                if (str.matches((String) next.getKey())) {
                    return (MimeType) next.getValue();
                }
            }
            return null;
        }
    }

    public void add(String str, boolean z, MimeType mimeType) throws MimeTypeException {
        if (str == null || mimeType == null) {
            throw new IllegalArgumentException("Pattern and/or mime type is missing");
        } else if (z) {
            addGlob(str, mimeType);
        } else if (str.indexOf(42) == -1 && str.indexOf(63) == -1 && str.indexOf(91) == -1) {
            addName(str, mimeType);
        } else if (str.startsWith("*") && str.indexOf(42, 1) == -1 && str.indexOf(63) == -1 && str.indexOf(91) == -1) {
            String substring = str.substring(1);
            addExtension(substring, mimeType);
            mimeType.addExtension(substring);
        } else {
            addGlob(compile(str), mimeType);
        }
    }
}
