package com.upuphone.star.httplib;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "", "d", "([B)Ljava/lang/String;", "Ljava/io/File;", "b", "(Ljava/io/File;)Ljava/lang/String;", "Ljava/io/InputStream;", "c", "(Ljava/io/InputStream;)Ljava/lang/String;", "", "Ljava/lang/reflect/Type;", "a", "(Ljava/lang/Object;)Ljava/lang/reflect/Type;", "super-http-lib_release"}, k = 2, mv = {1, 8, 0})
public final class UtilExtKt {
    public static final Type a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Type type = obj.getClass().getGenericInterfaces()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        Intrinsics.checkNotNullExpressionValue(type2, "(this.javaClass.genericI…e).actualTypeArguments[0]");
        return type2;
    }

    public static final String b(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return c(new FileInputStream(file));
    }

    public static final String c(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    byte[] digest = instance.digest();
                    Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
                    String d = d(digest);
                    inputStream.close();
                    return d;
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable unused) {
            inputStream.close();
            return null;
        }
    }

    public static final String d(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) UtilExtKt$toHex$1.INSTANCE, 30, (Object) null);
    }
}
