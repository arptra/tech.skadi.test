package org.apache.tika.pipes;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.tika.config.ConfigBase;

public class PipesConfigBase extends ConfigBase {

    /* renamed from: a  reason: collision with root package name */
    public long f3291a;
    public long b;
    public long c;
    public long d;
    public long e;
    public int f;
    public List g;
    public Path h;
    public String i;

    public List J() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.g);
        return arrayList;
    }

    public String N() {
        return this.i;
    }

    public int S() {
        return this.f;
    }

    public long T() {
        return this.f3291a;
    }

    public long U() {
        return this.e;
    }

    public long c0() {
        return this.d;
    }

    public long d0() {
        return this.c;
    }

    public Path f0() {
        return this.h;
    }

    public long i0() {
        return this.b;
    }
}
