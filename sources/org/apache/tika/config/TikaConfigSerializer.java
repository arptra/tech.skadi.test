package org.apache.tika.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TikaConfigSerializer {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f4140a = LoggerFactory.k(TikaConfigSerializer.class);
    public static Map b;

    public static class MethodTuple {

        /* renamed from: a  reason: collision with root package name */
        public String f4141a;
        public Method b;
        public Class c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodTuple methodTuple = (MethodTuple) obj;
            return this.f4141a.equals(methodTuple.f4141a) && this.b.equals(methodTuple.b) && this.c.equals(methodTuple.c);
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.f4141a, this.b, this.c});
        }
    }

    public static class MethodTuples {
    }

    public enum Mode {
        MINIMAL,
        CURRENT,
        STATIC,
        STATIC_FULL
    }

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(Integer.class, "int");
        b.put(Integer.TYPE, "int");
        b.put(String.class, "string");
        b.put(Boolean.class, "bool");
        b.put(Boolean.TYPE, "bool");
        b.put(Float.class, "float");
        b.put(Float.TYPE, "float");
        b.put(Double.class, "double");
        b.put(Double.TYPE, "double");
        b.put(Long.class, "long");
        b.put(Long.TYPE, "long");
        b.put(Map.class, "map");
        b.put(List.class, "list");
    }
}
