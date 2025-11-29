package com.upuphone.ar.tici.phone.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.MD5Checksum$calculateMD5$2", f = "Md5Checksum.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MD5Checksum$calculateMD5$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $content;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MD5Checksum$calculateMD5$2(String str, Continuation<? super MD5Checksum$calculateMD5$2> continuation) {
        super(2, continuation);
        this.$content = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MD5Checksum$calculateMD5$2(this.$content, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                byte[] bytes = this.$content.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                String bigInteger = new BigInteger(1, instance.digest(bytes)).toString(16);
                while (bigInteger.length() < 32) {
                    bigInteger = "0" + bigInteger;
                }
                CommonExtKt.e("calculateMD5: " + bigInteger, "Md5Checksum");
                Intrinsics.checkNotNull(bigInteger);
                return bigInteger;
            } catch (IOException e) {
                CommonExtKt.e("calculateMD5: " + e, "Md5Checksum");
                CommonExtKt.e("calculateMD5: 计算失败", "Md5Checksum");
                return "";
            } catch (NoSuchAlgorithmException e2) {
                CommonExtKt.e("calculateMD5: " + e2, "Md5Checksum");
                CommonExtKt.e("calculateMD5: 计算失败", "Md5Checksum");
                return "";
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((MD5Checksum$calculateMD5$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
