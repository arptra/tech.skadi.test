package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashMap;
import java.util.Map;

public class DomainWildcardMappingBuilder<V> {
    private final V defaultValue;
    private final Map<String, V> map;

    public static final class ImmutableDomainWildcardMapping<V> implements Mapping<String, V> {
        private static final String REPR_HEADER = "ImmutableDomainWildcardMapping(default: ";
        private static final String REPR_MAP_CLOSING = ")";
        private static final String REPR_MAP_OPENING = ", map: ";
        private final V defaultValue;
        private final Map<String, V> map;

        public ImmutableDomainWildcardMapping(V v, Map<String, V> map2) {
            this.defaultValue = v;
            this.map = new LinkedHashMap(map2);
        }

        public static String normalize(String str) {
            return DomainNameMapping.normalizeHostname(str);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(REPR_HEADER);
            sb.append(this.defaultValue);
            sb.append(REPR_MAP_OPENING);
            sb.append('{');
            for (Map.Entry next : this.map.entrySet()) {
                String str = (String) next.getKey();
                if (str.charAt(0) == '.') {
                    str = '*' + str;
                }
                sb.append(str);
                sb.append('=');
                sb.append(next.getValue());
                sb.append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append('}');
            sb.append(REPR_MAP_CLOSING);
            return sb.toString();
        }

        public V map(String str) {
            V v;
            if (str != null) {
                String normalize = normalize(str);
                V v2 = this.map.get(normalize);
                if (v2 != null) {
                    return v2;
                }
                int indexOf = normalize.indexOf(46);
                if (!(indexOf == -1 || (v = this.map.get(normalize.substring(indexOf))) == null)) {
                    return v;
                }
            }
            return this.defaultValue;
        }
    }

    public DomainWildcardMappingBuilder(V v) {
        this(4, v);
    }

    private String normalizeHostName(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        if (str.isEmpty() || str.charAt(0) == '.') {
            throw new IllegalArgumentException("Hostname '" + str + "' not valid");
        }
        String normalize = ImmutableDomainWildcardMapping.normalize((String) ObjectUtil.checkNotNull(str, "hostname"));
        if (normalize.charAt(0) != '*') {
            return normalize;
        }
        if (normalize.length() >= 3 && normalize.charAt(1) == '.') {
            return normalize.substring(1);
        }
        throw new IllegalArgumentException("Wildcard Hostname '" + normalize + "'not valid");
    }

    public DomainWildcardMappingBuilder<V> add(String str, V v) {
        this.map.put(normalizeHostName(str), ObjectUtil.checkNotNull(v, "output"));
        return this;
    }

    public Mapping<String, V> build() {
        return new ImmutableDomainWildcardMapping(this.defaultValue, this.map);
    }

    public DomainWildcardMappingBuilder(int i, V v) {
        this.defaultValue = ObjectUtil.checkNotNull(v, "defaultValue");
        this.map = new LinkedHashMap(i);
    }
}
