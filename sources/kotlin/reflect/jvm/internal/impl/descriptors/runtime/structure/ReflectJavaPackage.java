package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaPackage extends ReflectJavaElement implements JavaPackage {
    @NotNull
    private final FqName fqName;

    public ReflectJavaPackage(@NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        this.fqName = fqName2;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ReflectJavaPackage) && Intrinsics.areEqual((Object) getFqName(), (Object) ((ReflectJavaPackage) obj).getFqName());
    }

    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        return null;
    }

    @NotNull
    public Collection<JavaClass> getClasses(@NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt.emptyList();
    }

    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    @NotNull
    public Collection<JavaPackage> getSubPackages() {
        return CollectionsKt.emptyList();
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @NotNull
    public String toString() {
        return ReflectJavaPackage.class.getName() + ": " + getFqName();
    }

    @NotNull
    public List<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }
}
