package io.ktor.client.engine;

import io.ktor.http.HttpHeaders;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0003\" \u0010\u0007\u001a\u00020\u00008\u0006XD¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\u000b"}, d2 = {"", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT$annotations", "()V", "KTOR_DEFAULT_USER_AGENT", "", "Ljava/util/Set;", "DATE_HEADERS", "ktor-client-core"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nio/ktor/client/engine/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,107:1\n1#2:108\n*E\n"})
public final class UtilsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8829a = "Ktor client";
    public static final Set b;

    static {
        HttpHeaders httpHeaders = HttpHeaders.f8966a;
        b = SetsKt.setOf(httpHeaders.m(), httpHeaders.o(), httpHeaders.s(), httpHeaders.p(), httpHeaders.r());
    }

    public static final String b() {
        return f8829a;
    }
}
