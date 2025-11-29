package com.bumptech.glide.load.model;

import android.text.TextUtils;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LazyHeaders implements Headers {
    public final Map c;
    public volatile Map d;

    public static final class Builder {
        public static final String d;
        public static final Map e;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2565a = true;
        public Map b = e;
        public boolean c = true;

        static {
            String b2 = b();
            d = b2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(b2)));
            }
            e = Collections.unmodifiableMap(hashMap);
        }

        public static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public LazyHeaders a() {
            this.f2565a = true;
            return new LazyHeaders(this.b);
        }
    }

    public static final class StringHeaderFactory implements LazyHeaderFactory {

        /* renamed from: a  reason: collision with root package name */
        public final String f2566a;

        public StringHeaderFactory(String str) {
            this.f2566a = str;
        }

        public String a() {
            return this.f2566a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.f2566a.equals(((StringHeaderFactory) obj).f2566a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2566a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f2566a + '\'' + '}';
        }
    }

    public LazyHeaders(Map map) {
        this.c = Collections.unmodifiableMap(map);
    }

    public Map a() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.d = Collections.unmodifiableMap(c());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.d;
    }

    public final String b(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a2 = ((LazyHeaderFactory) list.get(i)).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i != list.size() - 1) {
                    sb.append(StringUtil.COMMA);
                }
            }
        }
        return sb.toString();
    }

    public final Map c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.c.entrySet()) {
            String b = b((List) entry.getValue());
            if (!TextUtils.isEmpty(b)) {
                hashMap.put(entry.getKey(), b);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.c.equals(((LazyHeaders) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }
}
