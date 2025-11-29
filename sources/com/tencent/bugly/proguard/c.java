package com.tencent.bugly.proguard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class c {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f9578a = new HashMap<>();
    protected HashMap<String, Object> b = new HashMap<>();
    protected String c = "GBK";
    k d = new k();
    private HashMap<String, Object> e = new HashMap<>();

    public static void b(ArrayList arrayList, Object obj) {
        while (true) {
            if (obj.getClass().isArray()) {
                if (!obj.getClass().getComponentType().toString().equals("byte")) {
                    throw new IllegalArgumentException("only byte[] is supported");
                } else if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    obj = Array.get(obj, 0);
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            } else if (obj instanceof Array) {
                throw new IllegalArgumentException("can not support Array, please use List");
            } else if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    obj = list.get(0);
                } else {
                    arrayList.add("?");
                    return;
                }
            } else if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    obj = map.get(next);
                    arrayList.add(next.getClass().getName());
                } else {
                    arrayList.add("?");
                    arrayList.add("?");
                    return;
                }
            } else {
                arrayList.add(obj.getClass().getName());
                return;
            }
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (obj == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(obj instanceof Set)) {
            l lVar = new l();
            lVar.a(this.c);
            lVar.a(obj, 0);
            byte[] a2 = n.a(lVar.f9584a);
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            b(arrayList, obj);
            hashMap.put(a.a(arrayList), a2);
            this.e.remove(str);
            this.f9578a.put(str, hashMap);
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    public byte[] a() {
        l lVar = new l(0);
        lVar.a(this.c);
        lVar.a(this.f9578a, 0);
        return n.a(lVar.f9584a);
    }

    public void a(byte[] bArr) {
        this.d.a(bArr);
        this.d.a(this.c);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f9578a = this.d.a(hashMap, 0, false);
    }
}
