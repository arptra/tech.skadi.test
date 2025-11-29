package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "size", "Lio/ktor/http/ParametersBuilder;", "a", "(I)Lio/ktor/http/ParametersBuilder;", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nParameters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Parameters.kt\nio/ktor/http/ParametersKt\n+ 2 Parameters.kt\nio/ktor/http/Parameters$Companion\n*L\n1#1,116:1\n24#2:117\n24#2:118\n*S KotlinDebug\n*F\n+ 1 Parameters.kt\nio/ktor/http/ParametersKt\n*L\n74#1:117\n96#1:118\n*E\n"})
public final class ParametersKt {
    public static final ParametersBuilder a(int i) {
        return new ParametersBuilderImpl(i);
    }

    public static /* synthetic */ ParametersBuilder b(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        return a(i);
    }
}
