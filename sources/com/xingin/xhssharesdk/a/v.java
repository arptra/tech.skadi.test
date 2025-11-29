package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.j;
import com.xingin.xhssharesdk.a.w;
import java.util.Map;

public final class v extends w<Object, Object> {
    public v(int i) {
        super(i, 0);
    }

    public final void f() {
        if (!this.d) {
            for (int i = 0; i < this.b.size(); i++) {
                ((j.a) ((Map.Entry) this.b.get(i)).getKey()).a();
            }
            for (Map.Entry key : this.c.isEmpty() ? w.a.b : this.c.entrySet()) {
                ((j.a) key.getKey()).a();
            }
        }
        super.f();
    }

    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((j.a) obj, obj2);
    }
}
