package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "e", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class CryptoKt__CryptoJvmKt$getDigestFunction$1 extends Lambda implements Function1<String, byte[]> {
    final /* synthetic */ String $algorithm;
    final /* synthetic */ Function1<String, String> $salt;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CryptoKt__CryptoJvmKt$getDigestFunction$1(String str, Function1<? super String, String> function1) {
        super(1);
        this.$algorithm = str;
        this.$salt = function1;
    }

    @NotNull
    public final byte[] invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "e");
        return CryptoKt__CryptoJvmKt.d(str, this.$algorithm, this.$salt);
    }
}
