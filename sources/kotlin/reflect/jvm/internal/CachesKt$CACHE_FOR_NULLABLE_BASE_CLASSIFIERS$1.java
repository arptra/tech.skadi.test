package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClassifiers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/KType;", "it", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CachesKt$CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$1 extends Lambda implements Function1<Class<?>, KType> {
    public static final CachesKt$CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$1 INSTANCE = new CachesKt$CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$1();

    public CachesKt$CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$1() {
        super(1);
    }

    @NotNull
    public final KType invoke(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "it");
        return KClassifiers.createType(CachesKt.getOrCreateKotlinClass(cls), CollectionsKt.emptyList(), true, CollectionsKt.emptyList());
    }
}
