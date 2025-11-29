package org.apache.tika.metadata.writefilter;

import java.util.Set;

public class StandardWriteFilterFactory implements MetadataWriteFilterFactory {

    /* renamed from: a  reason: collision with root package name */
    public Set f7118a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;

    public MetadataWriteFilter newInstance() {
        if (this.c < 0) {
            throw new IllegalArgumentException("maxFieldSize must be > 0");
        } else if (this.e < 1) {
            throw new IllegalArgumentException("maxValuesPerField must be > 0");
        } else if (this.d >= 0) {
            return new StandardWriteFilter(this.b, this.c, this.d, this.e, this.f7118a, this.f);
        } else {
            throw new IllegalArgumentException("max estimated size must be > 0");
        }
    }

    public String toString() {
        return "StandardWriteFilterFactory{includeFields=" + this.f7118a + ", maxKeySize=" + this.b + ", maxFieldSize=" + this.c + ", maxTotalEstimatedBytes=" + this.d + ", maxValuesPerField=" + this.e + ", includeEmpty=" + this.f + '}';
    }
}
