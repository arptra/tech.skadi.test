package io.ktor.util;

import io.ktor.utils.io.core.Input;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/utils/io/core/Input;", "Ljava/io/InputStream;", "a", "(Lio/ktor/utils/io/core/Input;)Ljava/io/InputStream;", "ktor-utils"}, k = 2, mv = {1, 8, 0})
public final class InputJvmKt {
    public static final InputStream a(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return new InputJvmKt$asStream$1(input);
    }
}
