package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\r\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\r\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/ktor/http/StringLexer;", "", "", "source", "<init>", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", "", "predicate", "f", "(Lkotlin/jvm/functions/Function1;)Z", "a", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "I", "d", "()I", "setIndex", "(I)V", "index", "c", "()Z", "hasRemaining", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCookieUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CookieUtils.kt\nio/ktor/http/StringLexer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n1#2:350\n*E\n"})
public final class StringLexer {

    /* renamed from: a  reason: collision with root package name */
    public final String f8976a;
    public int b;

    public StringLexer(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.f8976a = str;
    }

    public final boolean a(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        boolean f = f(function1);
        if (f) {
            this.b++;
        }
        return f;
    }

    public final boolean b(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (!f(function1)) {
            return false;
        }
        while (f(function1)) {
            this.b++;
        }
        return true;
    }

    public final boolean c() {
        return this.b < this.f8976a.length();
    }

    public final int d() {
        return this.b;
    }

    public final String e() {
        return this.f8976a;
    }

    public final boolean f(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return this.b < this.f8976a.length() && ((Boolean) function1.invoke(Character.valueOf(this.f8976a.charAt(this.b)))).booleanValue();
    }
}
