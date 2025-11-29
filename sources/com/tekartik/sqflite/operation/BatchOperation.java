package com.tekartik.sqflite.operation;

import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BatchOperation extends BaseOperation {

    /* renamed from: a  reason: collision with root package name */
    public final Map f10048a;
    public final BatchOperationResult b = new BatchOperationResult();
    public final boolean c;

    public class BatchOperationResult implements OperationResult {

        /* renamed from: a  reason: collision with root package name */
        public Object f10049a;
        public String b;
        public String c;
        public Object d;

        public BatchOperationResult() {
        }

        public void error(String str, String str2, Object obj) {
            this.b = str;
            this.c = str2;
            this.d = obj;
        }

        public void success(Object obj) {
            this.f10049a = obj;
        }
    }

    public BatchOperation(Map map, boolean z) {
        this.f10048a = map;
        this.c = z;
    }

    public Object a(String str) {
        return this.f10048a.get(str);
    }

    public boolean b(String str) {
        return this.f10048a.containsKey(str);
    }

    public boolean f() {
        return this.c;
    }

    public String getMethod() {
        return (String) this.f10048a.get("method");
    }

    public OperationResult l() {
        return this.b;
    }

    public Map m() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", this.b.b);
        hashMap2.put("message", this.b.c);
        hashMap2.put("data", this.b.d);
        hashMap.put("error", hashMap2);
        return hashMap;
    }

    public Map n() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.b.f10049a);
        return hashMap;
    }

    public void o(MethodChannel.Result result) {
        BatchOperationResult batchOperationResult = this.b;
        result.error(batchOperationResult.b, batchOperationResult.c, batchOperationResult.d);
    }

    public void p(List list) {
        if (!f()) {
            list.add(m());
        }
    }

    public void q(List list) {
        if (!f()) {
            list.add(n());
        }
    }
}
