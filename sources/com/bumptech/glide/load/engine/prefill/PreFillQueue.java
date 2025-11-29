package com.bumptech.glide.load.engine.prefill;

import java.util.List;
import java.util.Map;

final class PreFillQueue {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2542a;
    public final List b;
    public int c;
    public int d;

    public boolean a() {
        return this.c == 0;
    }

    public PreFillType b() {
        PreFillType preFillType = (PreFillType) this.b.get(this.d);
        Integer num = (Integer) this.f2542a.get(preFillType);
        if (num.intValue() == 1) {
            this.f2542a.remove(preFillType);
            this.b.remove(this.d);
        } else {
            this.f2542a.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.c--;
        this.d = this.b.isEmpty() ? 0 : (this.d + 1) % this.b.size();
        return preFillType;
    }
}
