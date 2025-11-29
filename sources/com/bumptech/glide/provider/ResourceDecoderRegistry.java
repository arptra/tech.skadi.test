package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ResourceDecoderRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List f2703a = new ArrayList();
    public final Map b = new HashMap();

    public static class Entry<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public final Class f2704a;
        public final Class b;
        public final ResourceDecoder c;

        public Entry(Class cls, Class cls2, ResourceDecoder resourceDecoder) {
            this.f2704a = cls;
            this.b = cls2;
            this.c = resourceDecoder;
        }

        public boolean a(Class cls, Class cls2) {
            return this.f2704a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    public synchronized void a(String str, ResourceDecoder resourceDecoder, Class cls, Class cls2) {
        c(str).add(new Entry(cls, cls2, resourceDecoder));
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f2703a) {
            List<Entry> list = (List) this.b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2)) {
                        arrayList.add(entry.c);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized List c(String str) {
        List list;
        try {
            if (!this.f2703a.contains(str)) {
                this.f2703a.add(str);
            }
            list = (List) this.b.get(str);
            if (list == null) {
                list = new ArrayList();
                this.b.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public synchronized List d(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f2703a) {
            List<Entry> list = (List) this.b.get(str);
            if (list != null) {
                for (Entry entry : list) {
                    if (entry.a(cls, cls2) && !arrayList.contains(entry.b)) {
                        arrayList.add(entry.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List list) {
        try {
            ArrayList<String> arrayList = new ArrayList<>(this.f2703a);
            this.f2703a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f2703a.add((String) it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f2703a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
