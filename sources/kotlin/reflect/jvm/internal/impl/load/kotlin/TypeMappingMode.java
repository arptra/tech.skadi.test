package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeMappingMode {
    @NotNull
    @JvmField
    public static final TypeMappingMode CLASS_DECLARATION;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final TypeMappingMode DEFAULT;
    @NotNull
    @JvmField
    public static final TypeMappingMode DEFAULT_UAST;
    @NotNull
    @JvmField
    public static final TypeMappingMode GENERIC_ARGUMENT;
    @NotNull
    @JvmField
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST;
    @NotNull
    @JvmField
    public static final TypeMappingMode RETURN_TYPE_BOXED = new TypeMappingMode(false, true, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 1021, (DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final TypeMappingMode SUPER_TYPE;
    @NotNull
    @JvmField
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;
    @NotNull
    @JvmField
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;
    @Nullable
    private final TypeMappingMode genericArgumentMode;
    @Nullable
    private final TypeMappingMode genericContravariantArgumentMode;
    @Nullable
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                kotlin.reflect.jvm.internal.impl.types.Variance[] r0 = kotlin.reflect.jvm.internal.impl.types.Variance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.jvm.internal.impl.types.Variance r1 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode.WhenMappings.<clinit>():void");
        }
    }

    static {
        TypeMappingMode typeMappingMode = new TypeMappingMode(false, false, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 1023, (DefaultConstructorMarker) null);
        GENERIC_ARGUMENT = typeMappingMode;
        TypeMappingMode typeMappingMode2 = new TypeMappingMode(false, false, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, true, 511, (DefaultConstructorMarker) null);
        GENERIC_ARGUMENT_UAST = typeMappingMode2;
        TypeMappingMode typeMappingMode3 = typeMappingMode;
        DEFAULT = new TypeMappingMode(false, false, false, false, false, typeMappingMode3, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 988, (DefaultConstructorMarker) null);
        DEFAULT_UAST = new TypeMappingMode(false, false, false, false, false, typeMappingMode2, false, (TypeMappingMode) null, (TypeMappingMode) null, true, 476, (DefaultConstructorMarker) null);
        CLASS_DECLARATION = new TypeMappingMode(false, true, false, false, false, typeMappingMode3, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 988, (DefaultConstructorMarker) null);
        SUPER_TYPE = new TypeMappingMode(false, false, false, true, false, typeMappingMode3, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 983, (DefaultConstructorMarker) null);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(false, false, false, true, false, typeMappingMode3, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 919, (DefaultConstructorMarker) null);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(false, false, true, false, false, typeMappingMode3, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 984, (DefaultConstructorMarker) null);
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, (TypeMappingMode) null, false, (TypeMappingMode) null, (TypeMappingMode) null, false, 1023, (DefaultConstructorMarker) null);
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    @NotNull
    public final TypeMappingMode toGenericArgumentMode(@NotNull Variance variance, boolean z) {
        TypeMappingMode typeMappingMode;
        Intrinsics.checkNotNullParameter(variance, "effectiveVariance");
        if (z && this.isForAnnotationParameter) {
            return this;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            typeMappingMode = this.genericContravariantArgumentMode;
            if (typeMappingMode == null) {
                return this;
            }
        } else if (i != 2) {
            typeMappingMode = this.genericArgumentMode;
            if (typeMappingMode == null) {
                return this;
            }
        } else {
            typeMappingMode = this.genericInvariantArgumentMode;
            if (typeMappingMode == null) {
                return this;
            }
        }
        return typeMappingMode;
    }

    @NotNull
    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, (DefaultConstructorMarker) null);
    }

    public TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable TypeMappingMode typeMappingMode, boolean z6, @Nullable TypeMappingMode typeMappingMode2, @Nullable TypeMappingMode typeMappingMode3, boolean z7) {
        this.needPrimitiveBoxing = z;
        this.needInlineClassWrapping = z2;
        this.isForAnnotationParameter = z3;
        this.skipDeclarationSiteWildcards = z4;
        this.skipDeclarationSiteWildcardsIfPossible = z5;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z6;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
        this.mapTypeAliases = z7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TypeMappingMode(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r8, boolean r9, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r10, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r2 = this;
            r14 = r13 & 1
            r0 = 1
            if (r14 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x000b
            r4 = r0
        L_0x000b:
            r14 = r13 & 4
            r1 = 0
            if (r14 == 0) goto L_0x0011
            r5 = r1
        L_0x0011:
            r14 = r13 & 8
            if (r14 == 0) goto L_0x0016
            r6 = r1
        L_0x0016:
            r14 = r13 & 16
            if (r14 == 0) goto L_0x001b
            r7 = r1
        L_0x001b:
            r14 = r13 & 32
            if (r14 == 0) goto L_0x0020
            r8 = 0
        L_0x0020:
            r14 = r13 & 64
            if (r14 == 0) goto L_0x0025
            r9 = r0
        L_0x0025:
            r14 = r13 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x002a
            r10 = r8
        L_0x002a:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x002f
            r11 = r8
        L_0x002f:
            r13 = r13 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0034
            r12 = r1
        L_0x0034:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode.<init>(boolean, boolean, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, boolean, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
