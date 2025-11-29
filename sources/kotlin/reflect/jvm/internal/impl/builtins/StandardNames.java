package kotlin.reflect.jvm.internal.impl.builtins;

import com.honey.account.constant.AccountConstantKt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class StandardNames {
    @NotNull
    @JvmField
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;
    @NotNull
    @JvmField
    public static final Name BACKING_FIELD;
    @NotNull
    @JvmField
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
    @NotNull
    @JvmField
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;
    @NotNull
    @JvmField
    public static final Name BUILT_INS_PACKAGE_NAME;
    @NotNull
    @JvmField
    public static final Name CHAR_CODE;
    @NotNull
    @JvmField
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
    @NotNull
    @JvmField
    public static final Name CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME;
    @NotNull
    @JvmField
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME;
    @NotNull
    @JvmField
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.intrinsics");
    @NotNull
    @JvmField
    public static final FqName COROUTINES_JVM_INTERNAL_PACKAGE_FQ_NAME = new FqName("kotlin.coroutines.jvm.internal");
    @NotNull
    @JvmField
    public static final FqName COROUTINES_PACKAGE_FQ_NAME;
    @NotNull
    @JvmField
    public static final String DATA_CLASS_COMPONENT_PREFIX = "component";
    @NotNull
    @JvmField
    public static final Name DATA_CLASS_COPY;
    @NotNull
    @JvmField
    public static final Name DEFAULT_VALUE_PARAMETER;
    @NotNull
    @JvmField
    public static final FqName DYNAMIC_FQ_NAME = new FqName("<dynamic>");
    @NotNull
    @JvmField
    public static final Name ENUM_ENTRIES;
    @NotNull
    @JvmField
    public static final Name ENUM_VALUES;
    @NotNull
    @JvmField
    public static final Name ENUM_VALUE_OF;
    @NotNull
    @JvmField
    public static final Name HASHCODE_NAME;
    @NotNull
    public static final StandardNames INSTANCE = new StandardNames();
    @NotNull
    @JvmField
    public static final FqName KOTLIN_INTERNAL_FQ_NAME;
    @NotNull
    @JvmField
    public static final FqName KOTLIN_REFLECT_FQ_NAME;
    @NotNull
    @JvmField
    public static final Name NEXT_CHAR;
    @NotNull
    private static final FqName NON_EXISTENT_CLASS = new FqName("error.NonExistentClass");
    @NotNull
    @JvmField
    public static final List<String> PREFIXES = CollectionsKt.listOf("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
    @NotNull
    @JvmField
    public static final FqName RANGES_PACKAGE_FQ_NAME;
    @NotNull
    @JvmField
    public static final FqName RESULT_FQ_NAME = new FqName("kotlin.Result");
    @NotNull
    @JvmField
    public static final FqName TEXT_PACKAGE_FQ_NAME;

    @SourceDebugExtension({"SMAP\nStandardNames.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,295:1\n11670#2,3:296\n11670#2,3:299\n*S KotlinDebug\n*F\n+ 1 StandardNames.kt\norg/jetbrains/kotlin/builtins/StandardNames$FqNames\n*L\n191#1:296,3\n195#1:299,3\n*E\n"})
    public static final class FqNames {
        @NotNull
        public static final FqNames INSTANCE;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _boolean;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _byte;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _char;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _double;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _enum;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _float;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _int;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _long;
        @NotNull
        @JvmField
        public static final FqNameUnsafe _short;
        @NotNull
        @JvmField
        public static final FqName accessibleLateinitPropertyLiteral;
        @NotNull
        @JvmField
        public static final FqName annotation;
        @NotNull
        @JvmField
        public static final FqName annotationRetention;
        @NotNull
        @JvmField
        public static final FqName annotationTarget;
        @NotNull
        @JvmField
        public static final FqNameUnsafe any;
        @NotNull
        @JvmField
        public static final FqNameUnsafe array;
        @NotNull
        @JvmField
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;
        @NotNull
        @JvmField
        public static final FqNameUnsafe charSequence;
        @NotNull
        @JvmField
        public static final FqNameUnsafe cloneable;
        @NotNull
        @JvmField
        public static final FqName collection;
        @NotNull
        @JvmField
        public static final FqName comparable;
        @NotNull
        @JvmField
        public static final FqName contextFunctionTypeParams;
        @NotNull
        @JvmField
        public static final FqName deprecated;
        @NotNull
        @JvmField
        public static final FqName deprecatedSinceKotlin;
        @NotNull
        @JvmField
        public static final FqName deprecationLevel;
        @NotNull
        @JvmField
        public static final FqName extensionFunctionType;
        @NotNull
        @JvmField
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;
        @NotNull
        @JvmField
        public static final FqNameUnsafe functionSupertype;
        @NotNull
        @JvmField
        public static final FqNameUnsafe intRange;
        @NotNull
        @JvmField
        public static final FqName iterable;
        @NotNull
        @JvmField
        public static final FqName iterator;
        @NotNull
        @JvmField
        public static final FqNameUnsafe kCallable = reflect("KCallable");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kClass = reflect("KClass");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kDeclarationContainer = reflect("KDeclarationContainer");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kMutableProperty0 = reflect("KMutableProperty0");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kMutableProperty1 = reflect("KMutableProperty1");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kMutableProperty2 = reflect("KMutableProperty2");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kMutablePropertyFqName = reflect("KMutableProperty");
        @NotNull
        @JvmField
        public static final ClassId kProperty;
        @NotNull
        @JvmField
        public static final FqNameUnsafe kProperty0 = reflect("KProperty0");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kProperty1 = reflect("KProperty1");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kProperty2 = reflect("KProperty2");
        @NotNull
        @JvmField
        public static final FqNameUnsafe kPropertyFqName;
        @NotNull
        @JvmField
        public static final FqName list;
        @NotNull
        @JvmField
        public static final FqName listIterator;
        @NotNull
        @JvmField
        public static final FqNameUnsafe longRange;
        @NotNull
        @JvmField
        public static final FqName map;
        @NotNull
        @JvmField
        public static final FqName mapEntry;
        @NotNull
        @JvmField
        public static final FqName mustBeDocumented;
        @NotNull
        @JvmField
        public static final FqName mutableCollection;
        @NotNull
        @JvmField
        public static final FqName mutableIterable;
        @NotNull
        @JvmField
        public static final FqName mutableIterator;
        @NotNull
        @JvmField
        public static final FqName mutableList;
        @NotNull
        @JvmField
        public static final FqName mutableListIterator;
        @NotNull
        @JvmField
        public static final FqName mutableMap;
        @NotNull
        @JvmField
        public static final FqName mutableMapEntry;
        @NotNull
        @JvmField
        public static final FqName mutableSet;
        @NotNull
        @JvmField
        public static final FqNameUnsafe nothing;
        @NotNull
        @JvmField
        public static final FqNameUnsafe number;
        @NotNull
        @JvmField
        public static final FqName parameterName;
        @NotNull
        @JvmField
        public static final ClassId parameterNameClassId;
        @NotNull
        @JvmField
        public static final Set<Name> primitiveArrayTypeShortNames;
        @NotNull
        @JvmField
        public static final Set<Name> primitiveTypeShortNames;
        @NotNull
        @JvmField
        public static final FqName publishedApi;
        @NotNull
        @JvmField
        public static final FqName repeatable;
        @NotNull
        @JvmField
        public static final ClassId repeatableClassId;
        @NotNull
        @JvmField
        public static final FqName replaceWith;
        @NotNull
        @JvmField
        public static final FqName retention;
        @NotNull
        @JvmField
        public static final ClassId retentionClassId;
        @NotNull
        @JvmField
        public static final FqName set;
        @NotNull
        @JvmField
        public static final FqNameUnsafe string;
        @NotNull
        @JvmField
        public static final FqName suppress;
        @NotNull
        @JvmField
        public static final FqName target;
        @NotNull
        @JvmField
        public static final ClassId targetClassId;
        @NotNull
        @JvmField
        public static final FqName throwable;
        @NotNull
        @JvmField
        public static final ClassId uByte;
        @NotNull
        @JvmField
        public static final FqName uByteArrayFqName;
        @NotNull
        @JvmField
        public static final FqName uByteFqName;
        @NotNull
        @JvmField
        public static final ClassId uInt;
        @NotNull
        @JvmField
        public static final FqName uIntArrayFqName;
        @NotNull
        @JvmField
        public static final FqName uIntFqName;
        @NotNull
        @JvmField
        public static final ClassId uLong;
        @NotNull
        @JvmField
        public static final FqName uLongArrayFqName;
        @NotNull
        @JvmField
        public static final FqName uLongFqName;
        @NotNull
        @JvmField
        public static final ClassId uShort;
        @NotNull
        @JvmField
        public static final FqName uShortArrayFqName;
        @NotNull
        @JvmField
        public static final FqName uShortFqName;
        @NotNull
        @JvmField
        public static final FqNameUnsafe unit;
        @NotNull
        @JvmField
        public static final FqName unsafeVariance;

        static {
            FqNames fqNames = new FqNames();
            INSTANCE = fqNames;
            any = fqNames.fqNameUnsafe("Any");
            nothing = fqNames.fqNameUnsafe("Nothing");
            cloneable = fqNames.fqNameUnsafe("Cloneable");
            suppress = fqNames.fqName("Suppress");
            unit = fqNames.fqNameUnsafe("Unit");
            charSequence = fqNames.fqNameUnsafe("CharSequence");
            string = fqNames.fqNameUnsafe("String");
            array = fqNames.fqNameUnsafe("Array");
            _boolean = fqNames.fqNameUnsafe("Boolean");
            _char = fqNames.fqNameUnsafe("Char");
            _byte = fqNames.fqNameUnsafe("Byte");
            _short = fqNames.fqNameUnsafe("Short");
            _int = fqNames.fqNameUnsafe("Int");
            _long = fqNames.fqNameUnsafe("Long");
            _float = fqNames.fqNameUnsafe("Float");
            _double = fqNames.fqNameUnsafe("Double");
            number = fqNames.fqNameUnsafe("Number");
            _enum = fqNames.fqNameUnsafe("Enum");
            functionSupertype = fqNames.fqNameUnsafe("Function");
            throwable = fqNames.fqName("Throwable");
            comparable = fqNames.fqName("Comparable");
            intRange = fqNames.rangesFqName("IntRange");
            longRange = fqNames.rangesFqName("LongRange");
            deprecated = fqNames.fqName("Deprecated");
            deprecatedSinceKotlin = fqNames.fqName("DeprecatedSinceKotlin");
            deprecationLevel = fqNames.fqName("DeprecationLevel");
            replaceWith = fqNames.fqName("ReplaceWith");
            extensionFunctionType = fqNames.fqName("ExtensionFunctionType");
            contextFunctionTypeParams = fqNames.fqName("ContextFunctionTypeParams");
            FqName fqName = fqNames.fqName("ParameterName");
            parameterName = fqName;
            ClassId classId = ClassId.topLevel(fqName);
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(parameterName)");
            parameterNameClassId = classId;
            annotation = fqNames.fqName("Annotation");
            FqName annotationName = fqNames.annotationName("Target");
            target = annotationName;
            ClassId classId2 = ClassId.topLevel(annotationName);
            Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(target)");
            targetClassId = classId2;
            annotationTarget = fqNames.annotationName("AnnotationTarget");
            annotationRetention = fqNames.annotationName("AnnotationRetention");
            FqName annotationName2 = fqNames.annotationName("Retention");
            retention = annotationName2;
            ClassId classId3 = ClassId.topLevel(annotationName2);
            Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(retention)");
            retentionClassId = classId3;
            FqName annotationName3 = fqNames.annotationName("Repeatable");
            repeatable = annotationName3;
            ClassId classId4 = ClassId.topLevel(annotationName3);
            Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(repeatable)");
            repeatableClassId = classId4;
            mustBeDocumented = fqNames.annotationName("MustBeDocumented");
            unsafeVariance = fqNames.fqName("UnsafeVariance");
            publishedApi = fqNames.fqName("PublishedApi");
            accessibleLateinitPropertyLiteral = fqNames.internalName("AccessibleLateinitPropertyLiteral");
            iterator = fqNames.collectionsFqName("Iterator");
            iterable = fqNames.collectionsFqName("Iterable");
            collection = fqNames.collectionsFqName("Collection");
            list = fqNames.collectionsFqName("List");
            listIterator = fqNames.collectionsFqName("ListIterator");
            set = fqNames.collectionsFqName("Set");
            FqName collectionsFqName = fqNames.collectionsFqName("Map");
            map = collectionsFqName;
            FqName child = collectionsFqName.child(Name.identifier("Entry"));
            Intrinsics.checkNotNullExpressionValue(child, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = child;
            mutableIterator = fqNames.collectionsFqName("MutableIterator");
            mutableIterable = fqNames.collectionsFqName("MutableIterable");
            mutableCollection = fqNames.collectionsFqName("MutableCollection");
            mutableList = fqNames.collectionsFqName("MutableList");
            mutableListIterator = fqNames.collectionsFqName("MutableListIterator");
            mutableSet = fqNames.collectionsFqName("MutableSet");
            FqName collectionsFqName2 = fqNames.collectionsFqName("MutableMap");
            mutableMap = collectionsFqName2;
            FqName child2 = collectionsFqName2.child(Name.identifier("MutableEntry"));
            Intrinsics.checkNotNullExpressionValue(child2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = child2;
            FqNameUnsafe reflect = reflect("KProperty");
            kPropertyFqName = reflect;
            ClassId classId5 = ClassId.topLevel(reflect.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId5, "topLevel(kPropertyFqName.toSafe())");
            kProperty = classId5;
            FqName fqName2 = fqNames.fqName("UByte");
            uByteFqName = fqName2;
            FqName fqName3 = fqNames.fqName("UShort");
            uShortFqName = fqName3;
            FqName fqName4 = fqNames.fqName("UInt");
            uIntFqName = fqName4;
            FqName fqName5 = fqNames.fqName("ULong");
            uLongFqName = fqName5;
            ClassId classId6 = ClassId.topLevel(fqName2);
            Intrinsics.checkNotNullExpressionValue(classId6, "topLevel(uByteFqName)");
            uByte = classId6;
            ClassId classId7 = ClassId.topLevel(fqName3);
            Intrinsics.checkNotNullExpressionValue(classId7, "topLevel(uShortFqName)");
            uShort = classId7;
            ClassId classId8 = ClassId.topLevel(fqName4);
            Intrinsics.checkNotNullExpressionValue(classId8, "topLevel(uIntFqName)");
            uInt = classId8;
            ClassId classId9 = ClassId.topLevel(fqName5);
            Intrinsics.checkNotNullExpressionValue(classId9, "topLevel(uLongFqName)");
            uLong = classId9;
            uByteArrayFqName = fqNames.fqName("UByteArray");
            uShortArrayFqName = fqNames.fqName("UShortArray");
            uIntArrayFqName = fqNames.fqName("UIntArray");
            uLongArrayFqName = fqNames.fqName("ULongArray");
            HashSet newHashSetWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType typeName : PrimitiveType.values()) {
                newHashSetWithExpectedSize.add(typeName.getTypeName());
            }
            primitiveTypeShortNames = newHashSetWithExpectedSize;
            HashSet newHashSetWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashSetWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType arrayTypeName : PrimitiveType.values()) {
                newHashSetWithExpectedSize2.add(arrayTypeName.getArrayTypeName());
            }
            primitiveArrayTypeShortNames = newHashSetWithExpectedSize2;
            HashMap newHashMapWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                FqNames fqNames2 = INSTANCE;
                String asString = primitiveType.getTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "primitiveType.typeName.asString()");
                newHashMapWithExpectedSize.put(fqNames2.fqNameUnsafe(asString), primitiveType);
            }
            fqNameToPrimitiveType = newHashMapWithExpectedSize;
            HashMap newHashMapWithExpectedSize2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(PrimitiveType.values().length);
            for (PrimitiveType primitiveType2 : PrimitiveType.values()) {
                FqNames fqNames3 = INSTANCE;
                String asString2 = primitiveType2.getArrayTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "primitiveType.arrayTypeName.asString()");
                newHashMapWithExpectedSize2.put(fqNames3.fqNameUnsafe(asString2), primitiveType2);
            }
            arrayClassFqNameToPrimitiveType = newHashMapWithExpectedSize2;
        }

        private FqNames() {
        }

        private final FqName annotationName(String str) {
            FqName child = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "ANNOTATION_PACKAGE_FQ_NA…e.identifier(simpleName))");
            return child;
        }

        private final FqName collectionsFqName(String str) {
            FqName child = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "COLLECTIONS_PACKAGE_FQ_N…e.identifier(simpleName))");
            return child;
        }

        private final FqName fqName(String str) {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(simpleName))");
            return child;
        }

        private final FqNameUnsafe fqNameUnsafe(String str) {
            FqNameUnsafe unsafe = fqName(str).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "fqName(simpleName).toUnsafe()");
            return unsafe;
        }

        private final FqName internalName(String str) {
            FqName child = StandardNames.KOTLIN_INTERNAL_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "KOTLIN_INTERNAL_FQ_NAME.…e.identifier(simpleName))");
            return child;
        }

        private final FqNameUnsafe rangesFqName(String str) {
            FqNameUnsafe unsafe = StandardNames.RANGES_PACKAGE_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "RANGES_PACKAGE_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return unsafe;
        }

        @JvmStatic
        @NotNull
        public static final FqNameUnsafe reflect(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "simpleName");
            FqNameUnsafe unsafe = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "KOTLIN_REFLECT_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return unsafe;
        }
    }

    static {
        Name identifier = Name.identifier("field");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"field\")");
        BACKING_FIELD = identifier;
        Name identifier2 = Name.identifier(AccountConstantKt.RESPONSE_VALUE);
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"value\")");
        DEFAULT_VALUE_PARAMETER = identifier2;
        Name identifier3 = Name.identifier("values");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"values\")");
        ENUM_VALUES = identifier3;
        Name identifier4 = Name.identifier("entries");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"entries\")");
        ENUM_ENTRIES = identifier4;
        Name identifier5 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = identifier5;
        Name identifier6 = Name.identifier("copy");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(\"copy\")");
        DATA_CLASS_COPY = identifier6;
        Name identifier7 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(\"hashCode\")");
        HASHCODE_NAME = identifier7;
        Name identifier8 = Name.identifier("code");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(\"code\")");
        CHAR_CODE = identifier8;
        Name identifier9 = Name.identifier("nextChar");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(\"nextChar\")");
        NEXT_CHAR = identifier9;
        Name identifier10 = Name.identifier("count");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(\"count\")");
        CONTEXT_FUNCTION_TYPE_PARAMETER_COUNT_NAME = identifier10;
        FqName fqName = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME = fqName;
        FqName child = fqName.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(child, "COROUTINES_PACKAGE_FQ_NA…entifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME = child;
        FqName fqName2 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = fqName2;
        Name identifier11 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = identifier11;
        FqName fqName3 = FqName.topLevel(identifier11);
        Intrinsics.checkNotNullExpressionValue(fqName3, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = fqName3;
        FqName child2 = fqName3.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child2, "BUILT_INS_PACKAGE_FQ_NAM…identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = child2;
        FqName child3 = fqName3.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(child3, "BUILT_INS_PACKAGE_FQ_NAM…dentifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = child3;
        FqName child4 = fqName3.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(child4, "BUILT_INS_PACKAGE_FQ_NAM…ame.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = child4;
        FqName child5 = fqName3.child(Name.identifier("text"));
        Intrinsics.checkNotNullExpressionValue(child5, "BUILT_INS_PACKAGE_FQ_NAM…(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = child5;
        FqName child6 = fqName3.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child6, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(\"internal\"))");
        KOTLIN_INTERNAL_FQ_NAME = child6;
        BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(fqName3, child3, child4, child2, fqName2, child6, fqName);
    }

    private StandardNames() {
    }

    @JvmStatic
    @NotNull
    public static final ClassId getFunctionClassId(int i) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(i)));
    }

    @JvmStatic
    @NotNull
    public static final String getFunctionName(int i) {
        return "Function" + i;
    }

    @JvmStatic
    @NotNull
    public static final FqName getPrimitiveFqName(@NotNull PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        FqName child = BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAM…d(primitiveType.typeName)");
        return child;
    }

    @JvmStatic
    @NotNull
    public static final String getSuspendFunctionName(int i) {
        return FunctionClassKind.SuspendFunction.getClassNamePrefix() + i;
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "arrayFqName");
        return FqNames.arrayClassFqNameToPrimitiveType.get(fqNameUnsafe) != null;
    }
}
