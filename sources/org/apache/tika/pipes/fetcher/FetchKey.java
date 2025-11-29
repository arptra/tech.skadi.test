package org.apache.tika.pipes.fetcher;

import java.io.Serializable;
import java.util.Objects;

public class FetchKey implements Serializable {
    private static final long serialVersionUID = -3861669115439125268L;
    private String fetchKey;
    private String fetcherName;
    private long rangeEnd;
    private long rangeStart;

    public FetchKey() {
        this.rangeStart = -1;
        this.rangeEnd = -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FetchKey fetchKey2 = (FetchKey) obj;
        return this.rangeStart == fetchKey2.rangeStart && this.rangeEnd == fetchKey2.rangeEnd && Objects.equals(this.fetcherName, fetchKey2.fetcherName) && Objects.equals(this.fetchKey, fetchKey2.fetchKey);
    }

    public String getFetchKey() {
        return this.fetchKey;
    }

    public String getFetcherName() {
        return this.fetcherName;
    }

    public long getRangeEnd() {
        return this.rangeEnd;
    }

    public long getRangeStart() {
        return this.rangeStart;
    }

    public boolean hasRange() {
        return this.rangeStart > -1 && this.rangeEnd > -1;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.fetcherName, this.fetchKey, Long.valueOf(this.rangeStart), Long.valueOf(this.rangeEnd)});
    }

    public String toString() {
        return "FetchKey{fetcherName='" + this.fetcherName + '\'' + ", fetchKey='" + this.fetchKey + '\'' + ", rangeStart=" + this.rangeStart + ", rangeEnd=" + this.rangeEnd + '}';
    }

    public FetchKey(String str, String str2) {
        this(str, str2, -1, -1);
    }

    public FetchKey(String str, String str2, long j, long j2) {
        this.fetcherName = str;
        this.fetchKey = str2;
        this.rangeStart = j;
        this.rangeEnd = j2;
    }
}
