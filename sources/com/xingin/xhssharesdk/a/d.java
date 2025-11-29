package com.xingin.xhssharesdk.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public int f8127a = 0;
    public final int b;
    public final /* synthetic */ e c;

    public d(e eVar) {
        this.c = eVar;
        this.b = eVar.size();
    }

    public final boolean hasNext() {
        return this.f8127a < this.b;
    }

    public final Object next() {
        try {
            e eVar = this.c;
            int i = this.f8127a;
            this.f8127a = i + 1;
            return Byte.valueOf(eVar.a(i));
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
