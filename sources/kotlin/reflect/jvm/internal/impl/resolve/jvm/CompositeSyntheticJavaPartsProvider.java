package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSyntheticJavaPartsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,90:1\n1360#2:91\n1446#2,5:92\n1855#2,2:97\n1360#2:99\n1446#2,5:100\n1855#2,2:105\n1855#2,2:107\n1360#2:109\n1446#2,5:110\n1855#2,2:115\n*S KotlinDebug\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n*L\n54#1:91\n54#1:92,5\n63#1:97,2\n68#1:99\n68#1:100,5\n72#1:105,2\n77#1:107,2\n82#1:109\n82#1:110,5\n87#1:115,2\n*E\n"})
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {
    @NotNull
    private final List<SyntheticJavaPartsProvider> inner;

    public CompositeSyntheticJavaPartsProvider(@NotNull List<? extends SyntheticJavaPartsProvider> list) {
        Intrinsics.checkNotNullParameter(list, "inner");
        this.inner = list;
    }

    public void generateConstructors(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor, @NotNull List<ClassConstructorDescriptor> list) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(list, "result");
        for (SyntheticJavaPartsProvider generateConstructors : this.inner) {
            generateConstructors.generateConstructors(lazyJavaResolverContext, classDescriptor, list);
        }
    }

    public void generateMethods(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateMethods : this.inner) {
            generateMethods.generateMethods(lazyJavaResolverContext, classDescriptor, name, collection);
        }
    }

    public void generateNestedClass(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor, @NotNull Name name, @NotNull List<ClassDescriptor> list) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(list, "result");
        for (SyntheticJavaPartsProvider generateNestedClass : this.inner) {
            generateNestedClass.generateNestedClass(lazyJavaResolverContext, classDescriptor, name, list);
        }
    }

    public void generateStaticFunctions(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor, @NotNull Name name, @NotNull Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateStaticFunctions : this.inner) {
            generateStaticFunctions.generateStaticFunctions(lazyJavaResolverContext, classDescriptor, name, collection);
        }
    }

    @NotNull
    public List<Name> getMethodNames(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        List<SyntheticJavaPartsProvider> list = this.inner;
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider methodNames : list) {
            CollectionsKt.addAll(arrayList, methodNames.getMethodNames(lazyJavaResolverContext, classDescriptor));
        }
        return arrayList;
    }

    @NotNull
    public List<Name> getNestedClassNames(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        List<SyntheticJavaPartsProvider> list = this.inner;
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider nestedClassNames : list) {
            CollectionsKt.addAll(arrayList, nestedClassNames.getNestedClassNames(lazyJavaResolverContext, classDescriptor));
        }
        return arrayList;
    }

    @NotNull
    public List<Name> getStaticFunctionNames(@NotNull LazyJavaResolverContext lazyJavaResolverContext, @NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "_context_receiver_0");
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        List<SyntheticJavaPartsProvider> list = this.inner;
        ArrayList arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider staticFunctionNames : list) {
            CollectionsKt.addAll(arrayList, staticFunctionNames.getStaticFunctionNames(lazyJavaResolverContext, classDescriptor));
        }
        return arrayList;
    }
}
