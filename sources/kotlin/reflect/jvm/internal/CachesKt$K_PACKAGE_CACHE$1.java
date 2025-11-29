package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "it", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CachesKt$K_PACKAGE_CACHE$1 extends Lambda implements Function1<Class<?>, KPackageImpl> {
    public static final CachesKt$K_PACKAGE_CACHE$1 INSTANCE = new CachesKt$K_PACKAGE_CACHE$1();

    public CachesKt$K_PACKAGE_CACHE$1() {
        super(1);
    }

    @NotNull
    public final KPackageImpl invoke(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "it");
        return new KPackageImpl(cls);
    }
}
