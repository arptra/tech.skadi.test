package io.ktor.http;

import io.ktor.util.StringValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/http/Headers;", "Lio/ktor/util/StringValues;", "a", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0})
public interface Headers extends StringValues {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f8962a = Companion.f8963a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\n\u001a\u00020\u00048\u0006¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/http/Headers$Companion;", "", "<init>", "()V", "Lio/ktor/http/Headers;", "b", "Lio/ktor/http/Headers;", "a", "()Lio/ktor/http/Headers;", "getEmpty$annotations", "Empty", "ktor-http"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f8963a = new Companion();
        public static final Headers b = EmptyHeaders.c;

        public final Headers a() {
            return b;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void a(Headers headers, Function2 function2) {
            Intrinsics.checkNotNullParameter(function2, "body");
            StringValues.DefaultImpls.a(headers, function2);
        }

        public static String b(Headers headers, String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return StringValues.DefaultImpls.b(headers, str);
        }
    }
}
