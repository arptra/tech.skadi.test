package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.honey.account.constant.AccountConstantKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nBinaryClassAnnotationAndConstantLoaderImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryClassAnnotationAndConstantLoaderImpl.kt\norg/jetbrains/kotlin/load/kotlin/BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,245:1\n800#2,11:246\n1620#2,3:257\n*S KotlinDebug\n*F\n+ 1 BinaryClassAnnotationAndConstantLoaderImpl.kt\norg/jetbrains/kotlin/load/kotlin/BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1\n*L\n93#1:246,11\n93#1:257,3\n*E\n"})
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 extends BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor {
    final /* synthetic */ ClassDescriptor $annotationClass;
    final /* synthetic */ ClassId $annotationClassId;
    final /* synthetic */ List<AnnotationDescriptor> $result;
    final /* synthetic */ SourceElement $source;
    @NotNull
    private final HashMap<Name, ConstantValue<?>> arguments = new HashMap<>();
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, ClassDescriptor classDescriptor, ClassId classId, List<AnnotationDescriptor> list, SourceElement sourceElement) {
        super();
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl;
        this.$annotationClass = classDescriptor;
        this.$annotationClassId = classId;
        this.$result = list;
        this.$source = sourceElement;
    }

    public void visitArrayValue(@Nullable Name name, @NotNull ArrayList<ConstantValue<?>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "elements");
        if (name != null) {
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, this.$annotationClass);
            if (annotationParameterByName != null) {
                HashMap<Name, ConstantValue<?>> hashMap = this.arguments;
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                List<T> compact = CollectionsKt.compact(arrayList);
                KotlinType type = annotationParameterByName.getType();
                Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
                hashMap.put(name, constantValueFactory.createArrayValue(compact, type));
            } else if (this.this$0.isImplicitRepeatableContainer(this.$annotationClassId) && Intrinsics.areEqual((Object) name.asString(), (Object) AccountConstantKt.RESPONSE_VALUE)) {
                ArrayList<AnnotationValue> arrayList2 = new ArrayList<>();
                for (T next : arrayList) {
                    if (next instanceof AnnotationValue) {
                        arrayList2.add(next);
                    }
                }
                List<AnnotationDescriptor> list = this.$result;
                for (AnnotationValue value : arrayList2) {
                    list.add((AnnotationDescriptor) value.getValue());
                }
            }
        }
    }

    public void visitConstantValue(@Nullable Name name, @NotNull ConstantValue<?> constantValue) {
        Intrinsics.checkNotNullParameter(constantValue, AccountConstantKt.RESPONSE_VALUE);
        if (name != null) {
            this.arguments.put(name, constantValue);
        }
    }

    public void visitEnd() {
        if (!this.this$0.isRepeatableWithImplicitContainer(this.$annotationClassId, this.arguments) && !this.this$0.isImplicitRepeatableContainer(this.$annotationClassId)) {
            this.$result.add(new AnnotationDescriptorImpl(this.$annotationClass.getDefaultType(), this.arguments, this.$source));
        }
    }
}
