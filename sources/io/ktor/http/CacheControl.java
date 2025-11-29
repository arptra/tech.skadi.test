package io.ktor.http;

import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000b"}, d2 = {"Lio/ktor/http/CacheControl;", "", "Lio/ktor/http/CacheControl$Visibility;", "a", "Lio/ktor/http/CacheControl$Visibility;", "()Lio/ktor/http/CacheControl$Visibility;", "visibility", "MaxAge", "NoCache", "NoStore", "Visibility", "ktor-http"}, k = 1, mv = {1, 8, 0})
public abstract class CacheControl {

    /* renamed from: a  reason: collision with root package name */
    public final Visibility f8939a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019¨\u0006\u001e"}, d2 = {"Lio/ktor/http/CacheControl$MaxAge;", "Lio/ktor/http/CacheControl;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "b", "I", "getMaxAgeSeconds", "maxAgeSeconds", "c", "Ljava/lang/Integer;", "getProxyMaxAgeSeconds", "()Ljava/lang/Integer;", "proxyMaxAgeSeconds", "d", "Z", "getMustRevalidate", "()Z", "mustRevalidate", "e", "getProxyRevalidate", "proxyRevalidate", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class MaxAge extends CacheControl {
        public final int b;
        public final Integer c;
        public final boolean d;
        public final boolean e;

        public boolean equals(Object obj) {
            if (obj != this) {
                if (obj instanceof MaxAge) {
                    MaxAge maxAge = (MaxAge) obj;
                    if (!(maxAge.b == this.b && Intrinsics.areEqual((Object) maxAge.c, (Object) this.c) && maxAge.d == this.d && maxAge.e == this.e && maxAge.a() == a())) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.b * 31;
            Integer num = this.c;
            int i2 = 0;
            int intValue = (((((i + (num != null ? num.intValue() : 0)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31;
            Visibility a2 = a();
            if (a2 != null) {
                i2 = a2.hashCode();
            }
            return intValue + i2;
        }

        public String toString() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add("max-age=" + this.b);
            if (this.c != null) {
                arrayList.add("s-maxage=" + this.c);
            }
            if (this.d) {
                arrayList.add("must-revalidate");
            }
            if (this.e) {
                arrayList.add("proxy-revalidate");
            }
            if (a() != null) {
                arrayList.add(a().getHeaderValue$ktor_http());
            }
            return CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/CacheControl$NoCache;", "Lio/ktor/http/CacheControl;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class NoCache extends CacheControl {
        public boolean equals(Object obj) {
            return (obj instanceof NoCache) && a() == ((NoCache) obj).a();
        }

        public int hashCode() {
            Visibility a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            if (a() == null) {
                return "no-cache";
            }
            return "no-cache, " + a().getHeaderValue$ktor_http();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/CacheControl$NoStore;", "Lio/ktor/http/CacheControl;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class NoStore extends CacheControl {
        public boolean equals(Object obj) {
            return (obj instanceof NoStore) && ((NoStore) obj).a() == a();
        }

        public int hashCode() {
            Visibility a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            if (a() == null) {
                return HttpHeaders.Values.NO_STORE;
            }
            return "no-store, " + a().getHeaderValue$ktor_http();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/ktor/http/CacheControl$Visibility;", "", "headerValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getHeaderValue$ktor_http", "()Ljava/lang/String;", "Public", "Private", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Visibility {
        Public("public"),
        Private("private");
        
        @NotNull
        private final String headerValue;

        private Visibility(String str) {
            this.headerValue = str;
        }

        @NotNull
        public final String getHeaderValue$ktor_http() {
            return this.headerValue;
        }
    }

    public final Visibility a() {
        return this.f8939a;
    }
}
