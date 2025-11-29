package io.ktor.client.request.forms;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/core/Input;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
@SourceDebugExtension({"SMAP\nformDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 formDsl.kt\nio/ktor/client/request/forms/FormDslKt$append$2\n+ 2 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n*L\n1#1,234:1\n12#2,11:235\n*S KotlinDebug\n*F\n+ 1 formDsl.kt\nio/ktor/client/request/forms/FormDslKt$append$2\n*L\n193#1:235,11\n*E\n"})
public final class FormDslKt$append$2 extends Lambda implements Function0<Input> {
    final /* synthetic */ Function1<BytePacketBuilder, Unit> $bodyBuilder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormDslKt$append$2(Function1<? super BytePacketBuilder, Unit> function1) {
        super(0);
        this.$bodyBuilder = function1;
    }

    @NotNull
    public final Input invoke() {
        Function1<BytePacketBuilder, Unit> function1 = this.$bodyBuilder;
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            function1.invoke(bytePacketBuilder);
            return bytePacketBuilder.F0();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
