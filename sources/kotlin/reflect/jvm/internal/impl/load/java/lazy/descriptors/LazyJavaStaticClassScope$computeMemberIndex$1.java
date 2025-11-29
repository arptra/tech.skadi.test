package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaStaticClassScope$computeMemberIndex$1 extends Lambda implements Function1<JavaMember, Boolean> {
    public static final LazyJavaStaticClassScope$computeMemberIndex$1 INSTANCE = new LazyJavaStaticClassScope$computeMemberIndex$1();

    public LazyJavaStaticClassScope$computeMemberIndex$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull JavaMember javaMember) {
        Intrinsics.checkNotNullParameter(javaMember, "it");
        return Boolean.valueOf(javaMember.isStatic());
    }
}
