package io.ktor.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u001a3\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u000f\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"", "text", "algorithm", "Lkotlin/Function1;", "salt", "", "d", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)[B", "b", "()Ljava/lang/String;", "c", "ktor-utils"}, k = 5, mv = {1, 8, 0}, xs = "io/ktor/util/CryptoKt")
final /* synthetic */ class CryptoKt__CryptoJvmKt {
    public static final String b() {
        String str = (String) ChannelResult.f(NonceKt.e().x());
        return str != null ? str : c();
    }

    public static final String c() {
        NonceKt.b();
        return (String) BuildersKt__BuildersKt.b((CoroutineContext) null, new CryptoKt__CryptoJvmKt$generateNonceBlocking$1((Continuation<? super CryptoKt__CryptoJvmKt$generateNonceBlocking$1>) null), 1, (Object) null);
    }

    public static final byte[] d(String str, String str2, Function1 function1) {
        MessageDigest instance = MessageDigest.getInstance(str2);
        Charset charset = Charsets.UTF_8;
        byte[] bytes = ((String) function1.invoke(str)).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        instance.update(bytes);
        byte[] bytes2 = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] digest = instance.digest(bytes2);
        Intrinsics.checkNotNullExpressionValue(digest, "with(MessageDigest.getIn…text.toByteArray())\n    }");
        return digest;
    }
}
