package io.ktor.http;

import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.eclipse.jetty.util.URIUtil;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0018"}, d2 = {"Lio/ktor/http/URLProtocol;", "", "", "name", "", "defaultPort", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "f", "b", "I", "e", "c", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nURLProtocol.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URLProtocol.kt\nio/ktor/http/URLProtocol\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n1064#2,2:70\n1#3:72\n1194#4,2:73\n1222#4,4:75\n*S KotlinDebug\n*F\n+ 1 URLProtocol.kt\nio/ktor/http/URLProtocol\n*L\n16#1:70,2\n49#1:73,2\n49#1:75,4\n*E\n"})
public final class URLProtocol {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public static final URLProtocol d;
    public static final URLProtocol e;
    public static final URLProtocol f;
    public static final URLProtocol g;
    public static final URLProtocol h;
    public static final Map i;

    /* renamed from: a  reason: collision with root package name */
    public final String f8979a;
    public final int b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/http/URLProtocol$Companion;", "", "<init>", "()V", "", "name", "Lio/ktor/http/URLProtocol;", "a", "(Ljava/lang/String;)Lio/ktor/http/URLProtocol;", "HTTP", "Lio/ktor/http/URLProtocol;", "c", "()Lio/ktor/http/URLProtocol;", "WS", "d", "WSS", "e", "", "byName", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final URLProtocol a(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            String c = TextKt.c(str);
            URLProtocol uRLProtocol = (URLProtocol) URLProtocol.c.b().get(c);
            return uRLProtocol == null ? new URLProtocol(c, 0) : uRLProtocol;
        }

        public final Map b() {
            return URLProtocol.i;
        }

        public final URLProtocol c() {
            return URLProtocol.d;
        }

        public final URLProtocol d() {
            return URLProtocol.f;
        }

        public final URLProtocol e() {
            return URLProtocol.g;
        }

        public Companion() {
        }
    }

    static {
        URLProtocol uRLProtocol = new URLProtocol(URIUtil.HTTP, 80);
        d = uRLProtocol;
        URLProtocol uRLProtocol2 = new URLProtocol(URIUtil.HTTPS, 443);
        e = uRLProtocol2;
        URLProtocol uRLProtocol3 = new URLProtocol("ws", 80);
        f = uRLProtocol3;
        URLProtocol uRLProtocol4 = new URLProtocol("wss", 443);
        g = uRLProtocol4;
        URLProtocol uRLProtocol5 = new URLProtocol("socks", 1080);
        h = uRLProtocol5;
        List listOf = CollectionsKt.listOf(uRLProtocol, uRLProtocol2, uRLProtocol3, uRLProtocol4, uRLProtocol5);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf, 10)), 16));
        for (Object next : listOf) {
            linkedHashMap.put(((URLProtocol) next).f8979a, next);
        }
        i = linkedHashMap;
    }

    public URLProtocol(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f8979a = str;
        this.b = i2;
        int i3 = 0;
        while (i3 < str.length()) {
            if (CharsetKt.a(str.charAt(i3))) {
                i3++;
            } else {
                throw new IllegalArgumentException("All characters should be lower case".toString());
            }
        }
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof URLProtocol)) {
            return false;
        }
        URLProtocol uRLProtocol = (URLProtocol) obj;
        return Intrinsics.areEqual((Object) this.f8979a, (Object) uRLProtocol.f8979a) && this.b == uRLProtocol.b;
    }

    public final String f() {
        return this.f8979a;
    }

    public int hashCode() {
        return (this.f8979a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "URLProtocol(name=" + this.f8979a + ", defaultPort=" + this.b + ')';
    }
}
