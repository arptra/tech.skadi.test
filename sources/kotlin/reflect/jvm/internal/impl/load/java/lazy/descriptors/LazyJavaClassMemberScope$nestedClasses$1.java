package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nLazyJavaClassMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaClassMemberScope.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaClassMemberScope$nestedClasses$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,890:1\n1#2:891\n*E\n"})
public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptor> {
    final /* synthetic */ LazyJavaResolverContext $c;
    final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = lazyJavaResolverContext;
    }

    @Nullable
    public final ClassDescriptor invoke(@NotNull Name name) {
        Name name2 = name;
        Intrinsics.checkNotNullParameter(name2, "name");
        if (((Set) this.this$0.nestedClassIndex.invoke()).contains(name2)) {
            JavaClassFinder finder = this.$c.getComponents().getFinder();
            ClassId classId = DescriptorUtilsKt.getClassId(this.this$0.getOwnerDescriptor());
            Intrinsics.checkNotNull(classId);
            ClassId createNestedClassId = classId.createNestedClassId(name2);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "ownerDescriptor.classId!…createNestedClassId(name)");
            JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, (byte[]) null, this.this$0.jClass, 2, (DefaultConstructorMarker) null));
            if (findClass == null) {
                return null;
            }
            LazyJavaResolverContext lazyJavaResolverContext = this.$c;
            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext, this.this$0.getOwnerDescriptor(), findClass, (ClassDescriptor) null, 8, (DefaultConstructorMarker) null);
            lazyJavaResolverContext.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
            return lazyJavaClassDescriptor;
        } else if (((Set) this.this$0.generatedNestedClassNames.invoke()).contains(name2)) {
            LazyJavaResolverContext lazyJavaResolverContext2 = this.$c;
            LazyJavaClassMemberScope lazyJavaClassMemberScope = this.this$0;
            List createListBuilder = CollectionsKt.createListBuilder();
            lazyJavaResolverContext2.getComponents().getSyntheticPartsProvider().generateNestedClass(lazyJavaResolverContext2, lazyJavaClassMemberScope.getOwnerDescriptor(), name2, createListBuilder);
            List build = CollectionsKt.build(createListBuilder);
            int size = build.size();
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                return (ClassDescriptor) CollectionsKt.single(build);
            }
            throw new IllegalStateException(("Multiple classes with same name are generated: " + build).toString());
        } else {
            JavaField javaField = (JavaField) ((Map) this.this$0.enumEntryIndex.invoke()).get(name2);
            if (javaField == null) {
                return null;
            }
            NotNullLazyValue createLazyValue = this.$c.getStorageManager().createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this.this$0));
            return EnumEntrySyntheticClassDescriptor.create(this.$c.getStorageManager(), this.this$0.getOwnerDescriptor(), name, createLazyValue, LazyJavaAnnotationsKt.resolveAnnotations(this.$c, javaField), this.$c.getComponents().getSourceElementFactory().source(javaField));
        }
    }
}
