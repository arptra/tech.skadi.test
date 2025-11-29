package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.here.posclient.PositionEstimate;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;
import org.jetbrains.annotations.NotNull;

public final class DeserializationComponentsForJavaKt {
    @NotNull
    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull NotFoundClasses notFoundClasses, @NotNull LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull ErrorReporter errorReporter, @NotNull JvmMetadataVersion jvmMetadataVersion) {
        StorageManager storageManager2 = storageManager;
        NotFoundClasses notFoundClasses2 = notFoundClasses;
        KotlinClassFinder kotlinClassFinder2 = kotlinClassFinder;
        DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
        JvmMetadataVersion jvmMetadataVersion2 = jvmMetadataVersion;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider2 = lazyJavaPackageFragmentProvider;
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragmentProvider2, "lazyJavaPackageFragmentProvider");
        Intrinsics.checkNotNullParameter(kotlinClassFinder2, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
        ErrorReporter errorReporter2 = errorReporter;
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(jvmMetadataVersion2, "jvmMetadataVersion");
        JavaClassDataFinder javaClassDataFinder = new JavaClassDataFinder(kotlinClassFinder2, deserializedDescriptorResolver2);
        BinaryClassAnnotationAndConstantLoaderImpl createBinaryClassAnnotationAndConstantLoader = BinaryClassAnnotationAndConstantLoaderImplKt.createBinaryClassAnnotationAndConstantLoader(moduleDescriptor, notFoundClasses2, storageManager2, kotlinClassFinder2, jvmMetadataVersion2);
        return new DeserializationComponentsForJava(storageManager2, moduleDescriptor, DeserializationConfiguration.Default.INSTANCE, javaClassDataFinder, createBinaryClassAnnotationAndConstantLoader, lazyJavaPackageFragmentProvider2, notFoundClasses2, errorReporter2, LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), NewKotlinTypeChecker.Companion.getDefault(), new TypeAttributeTranslators(CollectionsKt.listOf(DefaultTypeAttributeTranslator.INSTANCE)));
    }

    @NotNull
    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider(@NotNull JavaClassFinder javaClassFinder, @NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull NotFoundClasses notFoundClasses, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull ErrorReporter errorReporter, @NotNull JavaSourceElementFactory javaSourceElementFactory, @NotNull ModuleClassResolver moduleClassResolver, @NotNull PackagePartProvider packagePartProvider) {
        StorageManager storageManager2 = storageManager;
        Intrinsics.checkNotNullParameter(javaClassFinder, "javaClassFinder");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(javaSourceElementFactory, "javaSourceElementFactory");
        Intrinsics.checkNotNullParameter(moduleClassResolver, "singleModuleClassResolver");
        Intrinsics.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
        SignaturePropagator signaturePropagator2 = signaturePropagator;
        Intrinsics.checkNotNullExpressionValue(signaturePropagator, "DO_NOTHING");
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        JavaResolverCache javaResolverCache2 = javaResolverCache;
        Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        JavaPropertyInitializerEvaluator.DoNothing doNothing = JavaPropertyInitializerEvaluator.DoNothing.INSTANCE;
        JavaResolverComponents javaResolverComponents = r0;
        SamConversionResolverImpl samConversionResolverImpl = r14;
        SamConversionResolverImpl samConversionResolverImpl2 = new SamConversionResolverImpl(storageManager2, CollectionsKt.emptyList());
        SupertypeLoopChecker.EMPTY empty = SupertypeLoopChecker.EMPTY.INSTANCE;
        LookupTracker.DO_NOTHING do_nothing = LookupTracker.DO_NOTHING.INSTANCE;
        JavaClassFinder javaClassFinder2 = javaClassFinder;
        ReflectionTypes reflectionTypes = r2;
        ReflectionTypes reflectionTypes2 = new ReflectionTypes(moduleDescriptor, notFoundClasses);
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = r0;
        JavaTypeEnhancementState.Companion companion = JavaTypeEnhancementState.Companion;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver2 = new AnnotationTypeQualifierResolver(companion.getDEFAULT());
        SignatureEnhancement signatureEnhancement = r0;
        JavaResolverSettings.Default defaultR = JavaResolverSettings.Default.INSTANCE;
        JavaResolverSettings.Default defaultR2 = defaultR;
        SignatureEnhancement signatureEnhancement2 = new SignatureEnhancement(new JavaTypeEnhancement(defaultR));
        JavaClassesTracker.Default defaultR3 = JavaClassesTracker.Default.INSTANCE;
        NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
        JavaTypeEnhancementState javaTypeEnhancementState = companion.getDEFAULT();
        DeserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1 deserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1 = r0;
        DeserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1 deserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$12 = new DeserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1();
        StorageManager storageManager3 = storageManager;
        JavaClassFinder javaClassFinder3 = javaClassFinder2;
        KotlinClassFinder kotlinClassFinder2 = kotlinClassFinder;
        JavaResolverComponents javaResolverComponents2 = new JavaResolverComponents(storageManager3, javaClassFinder3, kotlinClassFinder2, deserializedDescriptorResolver, signaturePropagator2, errorReporter, javaResolverCache2, doNothing, samConversionResolverImpl, javaSourceElementFactory, moduleClassResolver, packagePartProvider, empty, do_nothing, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, defaultR3, defaultR2, newKotlinTypeCheckerImpl, javaTypeEnhancementState, deserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1, (SyntheticJavaPartsProvider) null, PositionEstimate.Value.ACTIVITY, (DefaultConstructorMarker) null);
        return new LazyJavaPackageFragmentProvider(javaResolverComponents);
    }

    public static /* synthetic */ LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider$default(JavaClassFinder javaClassFinder, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ErrorReporter errorReporter, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, int i, Object obj) {
        return makeLazyJavaPackageFragmentProvider(javaClassFinder, moduleDescriptor, storageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, errorReporter, javaSourceElementFactory, moduleClassResolver, (i & 512) != 0 ? PackagePartProvider.Empty.INSTANCE : packagePartProvider);
    }
}
