package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.spi.MDCAdapter;

public class BasicMDCAdapter implements MDCAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadLocalMapOfStacks f3458a = new ThreadLocalMapOfStacks();
    public final InheritableThreadLocal b = new InheritableThreadLocal<Map<String, String>>() {
        /* renamed from: a */
        public Map childValue(Map map) {
            if (map == null) {
                return null;
            }
            return new HashMap(map);
        }
    };

    public Map a() {
        Map map = (Map) this.b.get();
        if (map != null) {
            return new HashMap(map);
        }
        return null;
    }

    public void b(Map map) {
        this.b.set(map != null ? new HashMap(map) : null);
    }

    public void clear() {
        Map map = (Map) this.b.get();
        if (map != null) {
            map.clear();
            this.b.remove();
        }
    }

    public void remove(String str) {
        Map map = (Map) this.b.get();
        if (map != null) {
            map.remove(str);
        }
    }
}
