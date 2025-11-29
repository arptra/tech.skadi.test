package io.ktor.util;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u0001\u0011\u0001\u00020\rø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/ktor/util/DigestImpl;", "Lio/ktor/util/Digest;", "", "c", "(Ljava/security/MessageDigest;)Ljava/lang/String;", "", "b", "(Ljava/security/MessageDigest;)I", "", "other", "", "a", "(Ljava/security/MessageDigest;Ljava/lang/Object;)Z", "Ljava/security/MessageDigest;", "Ljava/security/MessageDigest;", "getDelegate", "()Ljava/security/MessageDigest;", "delegate", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@JvmInline
final class DigestImpl implements Digest {

    /* renamed from: a  reason: collision with root package name */
    public final MessageDigest f9027a;

    public static boolean a(MessageDigest messageDigest, Object obj) {
        return (obj instanceof DigestImpl) && Intrinsics.areEqual((Object) messageDigest, (Object) ((DigestImpl) obj).d());
    }

    public static int b(MessageDigest messageDigest) {
        return messageDigest.hashCode();
    }

    public static String c(MessageDigest messageDigest) {
        return "DigestImpl(delegate=" + messageDigest + ')';
    }

    public final /* synthetic */ MessageDigest d() {
        return this.f9027a;
    }

    public boolean equals(Object obj) {
        return a(this.f9027a, obj);
    }

    public int hashCode() {
        return b(this.f9027a);
    }

    public String toString() {
        return c(this.f9027a);
    }
}
