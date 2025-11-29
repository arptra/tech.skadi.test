package com.luck.picture.lib.config;

import java.util.LinkedList;

public class SelectorProviders {
    public static volatile SelectorProviders b;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList f9405a = new LinkedList();

    public static SelectorProviders c() {
        if (b == null) {
            synchronized (SelectorProviders.class) {
                try {
                    if (b == null) {
                        b = new SelectorProviders();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public void a(SelectorConfig selectorConfig) {
        this.f9405a.add(selectorConfig);
    }

    public void b() {
        SelectorConfig d = d();
        if (d != null) {
            d.e();
            this.f9405a.remove(d);
        }
    }

    public SelectorConfig d() {
        return this.f9405a.size() > 0 ? (SelectorConfig) this.f9405a.getLast() : new SelectorConfig();
    }
}
