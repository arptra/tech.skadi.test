package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.here.posclient.PositionEstimate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaModuleAnnotationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public final class JavaResolverComponents {
    @NotNull
    private final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    @NotNull
    private final DeserializedDescriptorResolver deserializedDescriptorResolver;
    @NotNull
    private final ErrorReporter errorReporter;
    @NotNull
    private final JavaClassFinder finder;
    @NotNull
    private final JavaClassesTracker javaClassesTracker;
    @NotNull
    private final JavaModuleAnnotationsProvider javaModuleResolver;
    @NotNull
    private final JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator;
    @NotNull
    private final JavaResolverCache javaResolverCache;
    @NotNull
    private final JavaTypeEnhancementState javaTypeEnhancementState;
    @NotNull
    private final KotlinClassFinder kotlinClassFinder;
    @NotNull
    private final NewKotlinTypeChecker kotlinTypeChecker;
    @NotNull
    private final LookupTracker lookupTracker;
    @NotNull
    private final ModuleDescriptor module;
    @NotNull
    private final ModuleClassResolver moduleClassResolver;
    @NotNull
    private final PackagePartProvider packagePartProvider;
    @NotNull
    private final ReflectionTypes reflectionTypes;
    @NotNull
    private final SamConversionResolver samConversionResolver;
    @NotNull
    private final JavaResolverSettings settings;
    @NotNull
    private final SignatureEnhancement signatureEnhancement;
    @NotNull
    private final SignaturePropagator signaturePropagator;
    @NotNull
    private final JavaSourceElementFactory sourceElementFactory;
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final SupertypeLoopChecker supertypeLoopChecker;
    @NotNull
    private final SyntheticJavaPartsProvider syntheticPartsProvider;

    public JavaResolverComponents(@NotNull StorageManager storageManager2, @NotNull JavaClassFinder javaClassFinder, @NotNull KotlinClassFinder kotlinClassFinder2, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver2, @NotNull SignaturePropagator signaturePropagator2, @NotNull ErrorReporter errorReporter2, @NotNull JavaResolverCache javaResolverCache2, @NotNull JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator2, @NotNull SamConversionResolver samConversionResolver2, @NotNull JavaSourceElementFactory javaSourceElementFactory, @NotNull ModuleClassResolver moduleClassResolver2, @NotNull PackagePartProvider packagePartProvider2, @NotNull SupertypeLoopChecker supertypeLoopChecker2, @NotNull LookupTracker lookupTracker2, @NotNull ModuleDescriptor moduleDescriptor, @NotNull ReflectionTypes reflectionTypes2, @NotNull AnnotationTypeQualifierResolver annotationTypeQualifierResolver2, @NotNull SignatureEnhancement signatureEnhancement2, @NotNull JavaClassesTracker javaClassesTracker2, @NotNull JavaResolverSettings javaResolverSettings, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull JavaTypeEnhancementState javaTypeEnhancementState2, @NotNull JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, @NotNull SyntheticJavaPartsProvider syntheticJavaPartsProvider) {
        StorageManager storageManager3 = storageManager2;
        JavaClassFinder javaClassFinder2 = javaClassFinder;
        KotlinClassFinder kotlinClassFinder3 = kotlinClassFinder2;
        DeserializedDescriptorResolver deserializedDescriptorResolver3 = deserializedDescriptorResolver2;
        SignaturePropagator signaturePropagator3 = signaturePropagator2;
        ErrorReporter errorReporter3 = errorReporter2;
        JavaResolverCache javaResolverCache3 = javaResolverCache2;
        JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator3 = javaPropertyInitializerEvaluator2;
        SamConversionResolver samConversionResolver3 = samConversionResolver2;
        JavaSourceElementFactory javaSourceElementFactory2 = javaSourceElementFactory;
        ModuleClassResolver moduleClassResolver3 = moduleClassResolver2;
        PackagePartProvider packagePartProvider3 = packagePartProvider2;
        SupertypeLoopChecker supertypeLoopChecker3 = supertypeLoopChecker2;
        LookupTracker lookupTracker3 = lookupTracker2;
        ReflectionTypes reflectionTypes3 = reflectionTypes2;
        Intrinsics.checkNotNullParameter(storageManager3, "storageManager");
        Intrinsics.checkNotNullParameter(javaClassFinder2, "finder");
        Intrinsics.checkNotNullParameter(kotlinClassFinder3, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver3, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(signaturePropagator3, "signaturePropagator");
        Intrinsics.checkNotNullParameter(errorReporter3, "errorReporter");
        Intrinsics.checkNotNullParameter(javaResolverCache3, "javaResolverCache");
        Intrinsics.checkNotNullParameter(javaPropertyInitializerEvaluator3, "javaPropertyInitializerEvaluator");
        Intrinsics.checkNotNullParameter(samConversionResolver3, "samConversionResolver");
        Intrinsics.checkNotNullParameter(javaSourceElementFactory2, "sourceElementFactory");
        Intrinsics.checkNotNullParameter(moduleClassResolver3, "moduleClassResolver");
        Intrinsics.checkNotNullParameter(packagePartProvider3, "packagePartProvider");
        Intrinsics.checkNotNullParameter(supertypeLoopChecker3, "supertypeLoopChecker");
        Intrinsics.checkNotNullParameter(lookupTracker3, "lookupTracker");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(reflectionTypes2, "reflectionTypes");
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver2, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(signatureEnhancement2, "signatureEnhancement");
        Intrinsics.checkNotNullParameter(javaClassesTracker2, "javaClassesTracker");
        Intrinsics.checkNotNullParameter(javaResolverSettings, "settings");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState2, "javaTypeEnhancementState");
        Intrinsics.checkNotNullParameter(javaModuleAnnotationsProvider, "javaModuleResolver");
        Intrinsics.checkNotNullParameter(syntheticJavaPartsProvider, "syntheticPartsProvider");
        this.storageManager = storageManager3;
        this.finder = javaClassFinder2;
        this.kotlinClassFinder = kotlinClassFinder3;
        this.deserializedDescriptorResolver = deserializedDescriptorResolver3;
        this.signaturePropagator = signaturePropagator3;
        this.errorReporter = errorReporter3;
        this.javaResolverCache = javaResolverCache3;
        this.javaPropertyInitializerEvaluator = javaPropertyInitializerEvaluator3;
        this.samConversionResolver = samConversionResolver3;
        this.sourceElementFactory = javaSourceElementFactory2;
        this.moduleClassResolver = moduleClassResolver3;
        this.packagePartProvider = packagePartProvider3;
        this.supertypeLoopChecker = supertypeLoopChecker3;
        this.lookupTracker = lookupTracker3;
        this.module = moduleDescriptor;
        this.reflectionTypes = reflectionTypes2;
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver2;
        this.signatureEnhancement = signatureEnhancement2;
        this.javaClassesTracker = javaClassesTracker2;
        this.settings = javaResolverSettings;
        this.kotlinTypeChecker = newKotlinTypeChecker;
        this.javaTypeEnhancementState = javaTypeEnhancementState2;
        this.javaModuleResolver = javaModuleAnnotationsProvider;
        this.syntheticPartsProvider = syntheticJavaPartsProvider;
    }

    @NotNull
    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.annotationTypeQualifierResolver;
    }

    @NotNull
    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.deserializedDescriptorResolver;
    }

    @NotNull
    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    @NotNull
    public final JavaClassFinder getFinder() {
        return this.finder;
    }

    @NotNull
    public final JavaClassesTracker getJavaClassesTracker() {
        return this.javaClassesTracker;
    }

    @NotNull
    public final JavaModuleAnnotationsProvider getJavaModuleResolver() {
        return this.javaModuleResolver;
    }

    @NotNull
    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.javaPropertyInitializerEvaluator;
    }

    @NotNull
    public final JavaResolverCache getJavaResolverCache() {
        return this.javaResolverCache;
    }

    @NotNull
    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.javaTypeEnhancementState;
    }

    @NotNull
    public final KotlinClassFinder getKotlinClassFinder() {
        return this.kotlinClassFinder;
    }

    @NotNull
    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    @NotNull
    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    @NotNull
    public final ModuleDescriptor getModule() {
        return this.module;
    }

    @NotNull
    public final ModuleClassResolver getModuleClassResolver() {
        return this.moduleClassResolver;
    }

    @NotNull
    public final PackagePartProvider getPackagePartProvider() {
        return this.packagePartProvider;
    }

    @NotNull
    public final ReflectionTypes getReflectionTypes() {
        return this.reflectionTypes;
    }

    @NotNull
    public final JavaResolverSettings getSettings() {
        return this.settings;
    }

    @NotNull
    public final SignatureEnhancement getSignatureEnhancement() {
        return this.signatureEnhancement;
    }

    @NotNull
    public final SignaturePropagator getSignaturePropagator() {
        return this.signaturePropagator;
    }

    @NotNull
    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.sourceElementFactory;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @NotNull
    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.supertypeLoopChecker;
    }

    @NotNull
    public final SyntheticJavaPartsProvider getSyntheticPartsProvider() {
        return this.syntheticPartsProvider;
    }

    @NotNull
    public final JavaResolverComponents replace(@NotNull JavaResolverCache javaResolverCache2) {
        Intrinsics.checkNotNullParameter(javaResolverCache2, "javaResolverCache");
        return new JavaResolverComponents(this.storageManager, this.finder, this.kotlinClassFinder, this.deserializedDescriptorResolver, this.signaturePropagator, this.errorReporter, javaResolverCache2, this.javaPropertyInitializerEvaluator, this.samConversionResolver, this.sourceElementFactory, this.moduleClassResolver, this.packagePartProvider, this.supertypeLoopChecker, this.lookupTracker, this.module, this.reflectionTypes, this.annotationTypeQualifierResolver, this.signatureEnhancement, this.javaClassesTracker, this.settings, this.kotlinTypeChecker, this.javaTypeEnhancementState, this.javaModuleResolver, (SyntheticJavaPartsProvider) null, PositionEstimate.Value.ACTIVITY, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaResolverComponents(StorageManager storageManager2, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder2, DeserializedDescriptorResolver deserializedDescriptorResolver2, SignaturePropagator signaturePropagator2, ErrorReporter errorReporter2, JavaResolverCache javaResolverCache2, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator2, SamConversionResolver samConversionResolver2, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver2, PackagePartProvider packagePartProvider2, SupertypeLoopChecker supertypeLoopChecker2, LookupTracker lookupTracker2, ModuleDescriptor moduleDescriptor, ReflectionTypes reflectionTypes2, AnnotationTypeQualifierResolver annotationTypeQualifierResolver2, SignatureEnhancement signatureEnhancement2, JavaClassesTracker javaClassesTracker2, JavaResolverSettings javaResolverSettings, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState2, JavaModuleAnnotationsProvider javaModuleAnnotationsProvider, SyntheticJavaPartsProvider syntheticJavaPartsProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager2, javaClassFinder, kotlinClassFinder2, deserializedDescriptorResolver2, signaturePropagator2, errorReporter2, javaResolverCache2, javaPropertyInitializerEvaluator2, samConversionResolver2, javaSourceElementFactory, moduleClassResolver2, packagePartProvider2, supertypeLoopChecker2, lookupTracker2, moduleDescriptor, reflectionTypes2, annotationTypeQualifierResolver2, signatureEnhancement2, javaClassesTracker2, javaResolverSettings, newKotlinTypeChecker, javaTypeEnhancementState2, javaModuleAnnotationsProvider, (i & PositionEstimate.Value.ACTIVITY) != 0 ? SyntheticJavaPartsProvider.Companion.getEMPTY() : syntheticJavaPartsProvider);
    }
}
