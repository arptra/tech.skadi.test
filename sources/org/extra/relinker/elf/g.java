package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class g extends d {
    public final i j;

    public g(boolean z, i iVar) {
        this.f3355a = z;
        this.j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = iVar.g(allocate, 16);
        this.c = iVar.o(allocate, 28);
        this.d = iVar.o(allocate, 32);
        this.e = iVar.g(allocate, 42);
        this.f = iVar.g(allocate, 44);
        this.g = iVar.g(allocate, 46);
        this.h = iVar.g(allocate, 48);
        this.i = iVar.g(allocate, 50);
    }

    public c a(long j2, int i) {
        return new a(this.j, this, j2, i);
    }

    public e b(long j2) {
        return new j(this.j, this, j2);
    }

    public f c(int i) {
        return new l(this.j, this, i);
    }
}
