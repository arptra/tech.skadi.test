package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErrorModuleDescriptor implements ModuleDescriptor {
    @NotNull
    public static final ErrorModuleDescriptor INSTANCE = new ErrorModuleDescriptor();
    @NotNull
    private static final List<ModuleDescriptor> allDependencyModules = CollectionsKt.emptyList();
    @NotNull
    private static final Set<ModuleDescriptor> allExpectedByModules = SetsKt.emptySet();
    @NotNull
    private static final KotlinBuiltIns builtIns = DefaultBuiltIns.Companion.getInstance();
    @NotNull
    private static final List<ModuleDescriptor> expectedByModules = CollectionsKt.emptyList();
    @NotNull
    private static final Name stableName;

    static {
        Name special = Name.special(ErrorEntity.ERROR_MODULE.getDebugText());
        Intrinsics.checkNotNullExpressionValue(special, "special(ErrorEntity.ERROR_MODULE.debugText)");
        stableName = special;
    }

    private ErrorModuleDescriptor() {
    }

    @Nullable
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return null;
    }

    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.getEMPTY();
    }

    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return builtIns;
    }

    @Nullable
    public <T> T getCapability(@NotNull ModuleCapability<T> moduleCapability) {
        Intrinsics.checkNotNullParameter(moduleCapability, "capability");
        return null;
    }

    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return null;
    }

    @NotNull
    public List<ModuleDescriptor> getExpectedByModules() {
        return expectedByModules;
    }

    @NotNull
    public Name getName() {
        return getStableName();
    }

    @NotNull
    public DeclarationDescriptor getOriginal() {
        return this;
    }

    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @NotNull
    public Name getStableName() {
        return stableName;
    }

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt.emptyList();
    }

    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "targetModule");
        return false;
    }
}
