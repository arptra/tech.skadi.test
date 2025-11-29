package io.ktor.http;

import io.ktor.http.HttpStatusCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "Lio/ktor/http/HttpStatusCode;", "a", "()Ljava/util/List;", "", "b", "(Lio/ktor/http/HttpStatusCode;)Z", "ktor-http"}, k = 2, mv = {1, 8, 0})
public final class HttpStatusCodeKt {
    public static final List a() {
        HttpStatusCode.Companion companion = HttpStatusCode.c;
        return CollectionsKt.listOf(companion.e(), companion.Q(), companion.G(), companion.A(), companion.f(), companion.a(), companion.v(), companion.u(), companion.M(), companion.B(), companion.s(), companion.t(), companion.r(), companion.j(), companion.N(), companion.z(), companion.Y(), companion.P(), companion.R(), companion.E(), companion.c(), companion.U(), companion.D(), companion.i(), companion.x(), companion.q(), companion.w(), companion.H(), companion.J(), companion.d(), companion.l(), companion.o(), companion.F(), companion.C(), companion.K(), companion.W(), companion.L(), companion.g(), companion.V(), companion.p(), companion.h(), companion.S(), companion.X(), companion.T(), companion.I(), companion.n(), companion.y(), companion.b(), companion.O(), companion.k(), companion.a0(), companion.Z(), companion.m());
    }

    public static final boolean b(HttpStatusCode httpStatusCode) {
        Intrinsics.checkNotNullParameter(httpStatusCode, "<this>");
        int h0 = httpStatusCode.h0();
        return 200 <= h0 && h0 < 300;
    }
}
