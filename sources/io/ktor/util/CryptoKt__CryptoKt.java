package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n\"\u0014\u0010\f\u001a\u00020\u00058\u0000XT¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "bytes", "", "b", "([B)Ljava/lang/String;", "", "size", "a", "(I)[B", "", "[C", "digits", "NONCE_SIZE_IN_BYTES", "I", "ktor-utils"}, k = 5, mv = {1, 8, 0}, xs = "io/ktor/util/CryptoKt")
@SourceDebugExtension({"SMAP\nCrypto.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Crypto.kt\nio/ktor/util/CryptoKt__CryptoKt\n+ 2 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 3 Strings.kt\nio/ktor/utils/io/core/StringsKt\n*L\n1#1,112:1\n12#2,11:113\n8#3,3:124\n*S KotlinDebug\n*F\n+ 1 Crypto.kt\nio/ktor/util/CryptoKt__CryptoKt\n*L\n58#1:113,11\n109#1:124,3\n*E\n"})
final /* synthetic */ class CryptoKt__CryptoKt {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f9023a = CharsetKt.b("0123456789abcdef");

    public static final byte[] a(int i) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        while (bytePacketBuilder.G0() < i) {
            try {
                StringsKt.m(bytePacketBuilder, CryptoKt.a(), 0, 0, (Charset) null, 14, (Object) null);
            } catch (Throwable th) {
                bytePacketBuilder.release();
                throw th;
            }
        }
        return StringsKt.b(bytePacketBuilder.F0(), i);
    }

    public static final String b(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        char[] cArr = new char[(bArr.length * 2)];
        char[] cArr2 = f9023a;
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = cArr2[(b & 255) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return kotlin.text.StringsKt.concatToString(cArr);
    }
}
