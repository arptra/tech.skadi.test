package io.ktor.http.content;

import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/LastModifiedVersion;", "Lio/ktor/http/content/Version;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/ktor/util/date/GMTDate;", "a", "Lio/ktor/util/date/GMTDate;", "getLastModified", "()Lio/ktor/util/date/GMTDate;", "lastModified", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nVersions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Versions.kt\nio/ktor/http/content/LastModifiedVersion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,261:1\n1747#2,3:262\n1726#2,3:265\n766#2:268\n857#2,2:269\n1603#2,9:271\n1855#2:280\n1856#2:282\n1612#2:283\n1#3:281\n1#3:284\n*S KotlinDebug\n*F\n+ 1 Versions.kt\nio/ktor/http/content/LastModifiedVersion\n*L\n96#1:262,3\n103#1:265,3\n111#1:268\n111#1:269,2\n112#1:271,9\n112#1:280\n112#1:282\n112#1:283\n112#1:281\n*E\n"})
public final class LastModifiedVersion implements Version {

    /* renamed from: a  reason: collision with root package name */
    public final GMTDate f8992a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LastModifiedVersion) && Intrinsics.areEqual((Object) this.f8992a, (Object) ((LastModifiedVersion) obj).f8992a);
    }

    public int hashCode() {
        return this.f8992a.hashCode();
    }

    public String toString() {
        return "LastModifiedVersion(lastModified=" + this.f8992a + ')';
    }
}
