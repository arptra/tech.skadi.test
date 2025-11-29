package io.ktor.util;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DeflaterKt$deflateTo$4 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Deflater $deflater;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeflaterKt$deflateTo$4(Deflater deflater) {
        super(0);
        this.$deflater = deflater;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(!this.$deflater.finished());
    }
}
