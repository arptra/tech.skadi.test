package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class JvmAnnotationNamesKt {
    @NotNull
    private static final FqName ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    @NotNull
    private static final FqName ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    @NotNull
    private static final FqName COMPATQUAL_NONNULL_ANNOTATION;
    @NotNull
    private static final FqName COMPATQUAL_NULLABLE_ANNOTATION;
    @NotNull
    private static final FqName JAVAX_CHECKFORNULL_ANNOTATION = new FqName("javax.annotation.CheckForNull");
    @NotNull
    private static final FqName JAVAX_NONNULL_ANNOTATION;
    @NotNull
    private static final FqName JSPECIFY_NULLABLE;
    @NotNull
    private static final FqName JSPECIFY_NULLNESS_UNKNOWN = new FqName("org.jspecify.annotations.NullnessUnspecified");
    @NotNull
    private static final FqName JSPECIFY_NULL_MARKED;
    @NotNull
    private static final FqName JSPECIFY_OLD_NULLABLE;
    @NotNull
    private static final FqName JSPECIFY_OLD_NULLNESS_UNKNOWN = new FqName("org.jspecify.nullness.NullnessUnspecified");
    @NotNull
    private static final FqName JSPECIFY_OLD_NULL_MARKED;
    @NotNull
    private static final Set<FqName> MUTABLE_ANNOTATIONS = SetsKt.setOf(JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION);
    @NotNull
    private static final List<FqName> NOT_NULL_ANNOTATIONS;
    @NotNull
    private static final Set<FqName> NULLABILITY_ANNOTATIONS;
    @NotNull
    private static final List<FqName> NULLABLE_ANNOTATIONS;
    @NotNull
    private static final Set<FqName> READ_ONLY_ANNOTATIONS = SetsKt.setOf(JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION);
    @NotNull
    private static final Map<FqName, FqName> javaToKotlinNameMap = MapsKt.mapOf(TuplesKt.to(JvmAnnotationNames.TARGET_ANNOTATION, StandardNames.FqNames.target), TuplesKt.to(JvmAnnotationNames.RETENTION_ANNOTATION, StandardNames.FqNames.retention), TuplesKt.to(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), TuplesKt.to(JvmAnnotationNames.DOCUMENTED_ANNOTATION, StandardNames.FqNames.mustBeDocumented));

    static {
        FqName fqName = new FqName("org.jspecify.nullness.Nullable");
        JSPECIFY_OLD_NULLABLE = fqName;
        FqName fqName2 = new FqName("org.jspecify.nullness.NullMarked");
        JSPECIFY_OLD_NULL_MARKED = fqName2;
        FqName fqName3 = new FqName("org.jspecify.annotations.Nullable");
        JSPECIFY_NULLABLE = fqName3;
        FqName fqName4 = new FqName("org.jspecify.annotations.NullMarked");
        JSPECIFY_NULL_MARKED = fqName4;
        FqName fqName5 = fqName4;
        FqName fqName6 = fqName3;
        FqName fqName7 = fqName2;
        FqName fqName8 = fqName;
        List<FqName> listOf = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable"));
        NULLABLE_ANNOTATIONS = listOf;
        FqName fqName9 = new FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION = fqName9;
        List<FqName> listOf2 = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull"));
        NOT_NULL_ANNOTATIONS = listOf2;
        FqName fqName10 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        COMPATQUAL_NULLABLE_ANNOTATION = fqName10;
        FqName fqName11 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        COMPATQUAL_NONNULL_ANNOTATION = fqName11;
        FqName fqName12 = new FqName("androidx.annotation.RecentlyNullable");
        ANDROIDX_RECENTLY_NULLABLE_ANNOTATION = fqName12;
        FqName fqName13 = new FqName("androidx.annotation.RecentlyNonNull");
        ANDROIDX_RECENTLY_NON_NULL_ANNOTATION = fqName13;
        NULLABILITY_ANNOTATIONS = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(new LinkedHashSet(), listOf), fqName9), listOf2), fqName10), fqName11), fqName12), fqName13), fqName8), fqName7), fqName6), fqName5);
    }

    @NotNull
    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    }

    @NotNull
    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    }

    @NotNull
    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return COMPATQUAL_NONNULL_ANNOTATION;
    }

    @NotNull
    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return COMPATQUAL_NULLABLE_ANNOTATION;
    }

    @NotNull
    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return JAVAX_CHECKFORNULL_ANNOTATION;
    }

    @NotNull
    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return JAVAX_NONNULL_ANNOTATION;
    }

    @NotNull
    public static final FqName getJSPECIFY_NULLABLE() {
        return JSPECIFY_NULLABLE;
    }

    @NotNull
    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return JSPECIFY_NULLNESS_UNKNOWN;
    }

    @NotNull
    public static final FqName getJSPECIFY_NULL_MARKED() {
        return JSPECIFY_NULL_MARKED;
    }

    @NotNull
    public static final FqName getJSPECIFY_OLD_NULLABLE() {
        return JSPECIFY_OLD_NULLABLE;
    }

    @NotNull
    public static final FqName getJSPECIFY_OLD_NULLNESS_UNKNOWN() {
        return JSPECIFY_OLD_NULLNESS_UNKNOWN;
    }

    @NotNull
    public static final FqName getJSPECIFY_OLD_NULL_MARKED() {
        return JSPECIFY_OLD_NULL_MARKED;
    }

    @NotNull
    public static final Set<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    @NotNull
    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    @NotNull
    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }
}
