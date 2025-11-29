package io.ktor.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata(d1 = {"\u00008\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\"\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\" \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014\"\u001a\u0010\u001a\u001a\u00020\u00168\u0002X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u0002¨\u0006\u001b"}, d2 = {"", "b", "()V", "Ljava/security/SecureRandom;", "f", "()Ljava/security/SecureRandom;", "", "name", "c", "(Ljava/lang/String;)Ljava/security/SecureRandom;", "", "a", "Ljava/util/List;", "SECURE_RANDOM_PROVIDERS", "Lkotlinx/coroutines/channels/Channel;", "Lkotlinx/coroutines/channels/Channel;", "e", "()Lkotlinx/coroutines/channels/Channel;", "seedChannel", "Lkotlinx/coroutines/CoroutineName;", "Lkotlinx/coroutines/CoroutineName;", "NonceGeneratorCoroutineName", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "getNonceGeneratorJob$annotations", "nonceGeneratorJob", "ktor-utils"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nNonce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nonce.kt\nio/ktor/util/NonceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
public final class NonceKt {

    /* renamed from: a  reason: collision with root package name */
    public static final List f9036a = CollectionsKt.listOf("NativePRNGNonBlocking", "WINDOWS-PRNG", "DRBG");
    public static final Channel b = ChannelKt.b(1024, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    public static final CoroutineName c;
    public static final Job d;

    static {
        CoroutineName coroutineName = new CoroutineName("nonce-generator");
        c = coroutineName;
        d = BuildersKt.c(GlobalScope.f3732a, Dispatchers.b().plus(NonCancellable.f3740a).plus(coroutineName), CoroutineStart.LAZY, new NonceKt$nonceGeneratorJob$1((Continuation<? super NonceKt$nonceGeneratorJob$1>) null));
    }

    public static final void b() {
        d.start();
    }

    public static final SecureRandom c(String str) {
        if (str == null) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstance(str);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static /* synthetic */ SecureRandom d(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return c(str);
    }

    public static final Channel e() {
        return b;
    }

    public static final SecureRandom f() {
        SecureRandom c2;
        String property = System.getProperty("io.ktor.random.secure.random.provider");
        if (property != null && (c2 = c(property)) != null) {
            return c2;
        }
        for (String c3 : f9036a) {
            SecureRandom c4 = c(c3);
            if (c4 != null) {
                return c4;
            }
        }
        Logger l = LoggerFactory.l("io.ktor.util.random");
        l.warn("None of the " + CollectionsKt.joinToString$default(f9036a, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + " found, fallback to default");
        SecureRandom d2 = d((String) null, 1, (Object) null);
        if (d2 != null) {
            return d2;
        }
        throw new IllegalStateException("No SecureRandom implementation found".toString());
    }
}
