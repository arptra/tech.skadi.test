package com.upuphone.ar.translation.ext;

import com.upuphone.ar.translation.utils.GsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00028\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class AnyExtKt {
    public static final Object a(Object obj, Class cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return GsonUtils.a(GsonUtils.d(obj), cls);
    }
}
