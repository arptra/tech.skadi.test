package org.extra.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class h extends d {
    public final i j;

    public h(boolean z, i iVar) {
        this.f3355a = z;
        this.j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = iVar.g(allocate, 16);
        this.c = iVar.j(allocate, 32);
        this.d = iVar.j(allocate, 40);
        this.e = iVar.g(allocate, 54);
        this.f = iVar.g(allocate, 56);
        this.g = iVar.g(allocate, 58);
        this.h = iVar.g(allocate, 60);
        this.i = iVar.g(allocate, 62);
    }

    public c a(long j2, int i) {
        return new b(this.j, this, j2, i);
    }

    public e b(long j2) {
        return new k(this.j, this, j2);
    }

    public f c(int i) {
        return new m(this.j, this, i);
    }
}
