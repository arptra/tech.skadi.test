package io.ktor.http.content;

import io.ktor.http.CacheControl;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/http/content/CachingOptions;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/ktor/http/CacheControl;", "a", "Lio/ktor/http/CacheControl;", "getCacheControl", "()Lio/ktor/http/CacheControl;", "cacheControl", "Lio/ktor/util/date/GMTDate;", "b", "Lio/ktor/util/date/GMTDate;", "getExpires", "()Lio/ktor/util/date/GMTDate;", "expires", "ktor-http"}, k = 1, mv = {1, 8, 0})
public final class CachingOptions {

    /* renamed from: a  reason: collision with root package name */
    public final CacheControl f8988a;
    public final GMTDate b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachingOptions)) {
            return false;
        }
        CachingOptions cachingOptions = (CachingOptions) obj;
        return Intrinsics.areEqual((Object) this.f8988a, (Object) cachingOptions.f8988a) && Intrinsics.areEqual((Object) this.b, (Object) cachingOptions.b);
    }

    public int hashCode() {
        CacheControl cacheControl = this.f8988a;
        int i = 0;
        int hashCode = (cacheControl == null ? 0 : cacheControl.hashCode()) * 31;
        GMTDate gMTDate = this.b;
        if (gMTDate != null) {
            i = gMTDate.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CachingOptions(cacheControl=" + this.f8988a + ", expires=" + this.b + ')';
    }
}
