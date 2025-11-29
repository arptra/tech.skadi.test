package org.apache.tika.renderer;

import java.util.Objects;

public class PageRangeRequest implements RenderRequest {
    public static PageRangeRequest c = new PageRangeRequest(1, -1);

    /* renamed from: a  reason: collision with root package name */
    public final int f3313a;
    public final int b;

    public PageRangeRequest(int i, int i2) {
        this.f3313a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PageRangeRequest pageRangeRequest = (PageRangeRequest) obj;
        return this.f3313a == pageRangeRequest.f3313a && this.b == pageRangeRequest.b;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f3313a), Integer.valueOf(this.b)});
    }
}
