package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nfindClassInModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n1#1,66:1\n43#1,2:67\n*S KotlinDebug\n*F\n+ 1 findClassInModule.kt\norg/jetbrains/kotlin/descriptors/FindClassInModuleKt\n*L\n23#1:67,2\n*E\n"})
public final class FindClassInModuleKt {
    @Nullable
    public static final ClassDescriptor findClassAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor findClassifierAcrossModuleDependencies(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.ClassId r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "classId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r0 = kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt.getResolutionAnchorIfAny(r10)
            java.lang.String r1 = "name"
            r2 = 1
            java.lang.String r3 = "segments.first()"
            java.lang.String r4 = "classId.relativeClassName.pathSegments()"
            java.lang.String r5 = "classId.packageFqName"
            r6 = 0
            if (r0 != 0) goto L_0x0082
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r10 = r10.getPackage(r0)
            kotlin.reflect.jvm.internal.impl.name.FqName r11 = r11.getRelativeClassName()
            java.util.List r11 = r11.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getMemberScope()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r3 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r3)
            if (r10 != 0) goto L_0x0047
            goto L_0x014c
        L_0x0047:
            int r0 = r11.size()
            java.util.List r11 = r11.subList(r2, r0)
            java.util.Iterator r11 = r11.iterator()
        L_0x0053:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x007f
            java.lang.Object r0 = r11.next()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            boolean r2 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 != 0) goto L_0x0065
            goto L_0x014c
        L_0x0065:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r2 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r2)
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x007b
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            goto L_0x007c
        L_0x007b:
            r10 = r6
        L_0x007c:
            if (r10 == 0) goto L_0x014c
            goto L_0x0053
        L_0x007f:
            r6 = r10
            goto L_0x014c
        L_0x0082:
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r0 = r0.getPackage(r7)
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r11.getRelativeClassName()
            java.util.List r7 = r7.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getMemberScope()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r9 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getContributedClassifier(r8, r9)
            if (r0 != 0) goto L_0x00af
        L_0x00ad:
            r0 = r6
            goto L_0x00e6
        L_0x00af:
            int r8 = r7.size()
            java.util.List r7 = r7.subList(r2, r8)
            java.util.Iterator r7 = r7.iterator()
        L_0x00bb:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00e6
            java.lang.Object r8 = r7.next()
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            boolean r9 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r9 != 0) goto L_0x00cc
            goto L_0x00ad
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r9 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getContributedClassifier(r8, r9)
            boolean r8 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r8 == 0) goto L_0x00e2
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            goto L_0x00e3
        L_0x00e2:
            r0 = r6
        L_0x00e3:
            if (r0 == 0) goto L_0x00ad
            goto L_0x00bb
        L_0x00e6:
            if (r0 != 0) goto L_0x014b
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r10 = r10.getPackage(r0)
            kotlin.reflect.jvm.internal.impl.name.FqName r11 = r11.getRelativeClassName()
            java.util.List r11 = r11.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getMemberScope()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r3 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r3)
            if (r10 != 0) goto L_0x0114
            goto L_0x014c
        L_0x0114:
            int r0 = r11.size()
            java.util.List r11 = r11.subList(r2, r0)
            java.util.Iterator r11 = r11.iterator()
        L_0x0120:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x007f
            java.lang.Object r0 = r11.next()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            boolean r2 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r2 != 0) goto L_0x0131
            goto L_0x014c
        L_0x0131:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r2 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r2)
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x0147
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            goto L_0x0148
        L_0x0147:
            r10 = r6
        L_0x0148:
            if (r10 == 0) goto L_0x014c
            goto L_0x0120
        L_0x014b:
            r6 = r0
        L_0x014c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassifierAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.name.ClassId):kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor");
    }

    @NotNull
    public static final ClassDescriptor findNonGenericClassAcrossDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        return findClassAcrossModuleDependencies != null ? findClassAcrossModuleDependencies : notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    @Nullable
    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
