package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nStandardClassIds.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIds\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n1271#2,2:266\n1285#2,4:268\n1271#2,2:272\n1285#2,4:274\n*S KotlinDebug\n*F\n+ 1 StandardClassIds.kt\norg/jetbrains/kotlin/name/StandardClassIds\n*L\n80#1:266,2\n80#1:268,4\n84#1:272,2\n84#1:274,4\n*E\n"})
public final class StandardClassIds {
    @NotNull
    private static final ClassId Annotation = StandardClassIdsKt.baseId("Annotation");
    @NotNull
    private static final ClassId AnnotationRetention = StandardClassIdsKt.annotationId("AnnotationRetention");
    @NotNull
    private static final ClassId AnnotationTarget = StandardClassIdsKt.annotationId("AnnotationTarget");
    @NotNull
    private static final ClassId Any = StandardClassIdsKt.baseId("Any");
    @NotNull
    private static final ClassId Array = StandardClassIdsKt.baseId("Array");
    @NotNull
    private static final FqName BASE_ANNOTATION_PACKAGE;
    @NotNull
    private static final FqName BASE_COLLECTIONS_PACKAGE;
    @NotNull
    private static final FqName BASE_COROUTINES_PACKAGE;
    @NotNull
    private static final FqName BASE_ENUMS_PACKAGE;
    @NotNull
    private static final FqName BASE_INTERNAL_IR_PACKAGE;
    @NotNull
    private static final FqName BASE_INTERNAL_PACKAGE;
    @NotNull
    private static final FqName BASE_JVM_INTERNAL_PACKAGE;
    @NotNull
    private static final FqName BASE_JVM_PACKAGE;
    @NotNull
    private static final FqName BASE_KOTLIN_PACKAGE;
    @NotNull
    private static final FqName BASE_RANGES_PACKAGE;
    @NotNull
    private static final FqName BASE_REFLECT_PACKAGE;
    @NotNull
    private static final ClassId Boolean;
    @NotNull
    private static final ClassId Byte;
    @NotNull
    private static final ClassId Char;
    @NotNull
    private static final ClassId CharIterator = StandardClassIdsKt.collectionsId("CharIterator");
    @NotNull
    private static final ClassId CharRange = StandardClassIdsKt.rangesId("CharRange");
    @NotNull
    private static final ClassId CharSequence = StandardClassIdsKt.baseId("CharSequence");
    @NotNull
    private static final ClassId Cloneable = StandardClassIdsKt.baseId("Cloneable");
    @NotNull
    private static final ClassId Collection = StandardClassIdsKt.collectionsId("Collection");
    @NotNull
    private static final ClassId Comparable = StandardClassIdsKt.baseId("Comparable");
    @NotNull
    private static final ClassId Continuation = StandardClassIdsKt.coroutinesId("Continuation");
    @NotNull
    private static final ClassId Double;
    @NotNull
    private static final ClassId Enum = StandardClassIdsKt.baseId("Enum");
    @NotNull
    private static final ClassId EnumEntries = StandardClassIdsKt.enumsId("EnumEntries");
    @NotNull
    private static final ClassId Float;
    @NotNull
    private static final ClassId Function = StandardClassIdsKt.baseId("Function");
    @NotNull
    public static final StandardClassIds INSTANCE = new StandardClassIds();
    @NotNull
    private static final ClassId Int;
    @NotNull
    private static final ClassId IntRange = StandardClassIdsKt.rangesId("IntRange");
    @NotNull
    private static final ClassId Iterable = StandardClassIdsKt.collectionsId("Iterable");
    @NotNull
    private static final ClassId Iterator = StandardClassIdsKt.collectionsId("Iterator");
    @NotNull
    private static final ClassId KCallable = StandardClassIdsKt.reflectId("KCallable");
    @NotNull
    private static final ClassId KClass = StandardClassIdsKt.reflectId("KClass");
    @NotNull
    private static final ClassId KFunction = StandardClassIdsKt.reflectId("KFunction");
    @NotNull
    private static final ClassId KMutableProperty = StandardClassIdsKt.reflectId("KMutableProperty");
    @NotNull
    private static final ClassId KMutableProperty0 = StandardClassIdsKt.reflectId("KMutableProperty0");
    @NotNull
    private static final ClassId KMutableProperty1 = StandardClassIdsKt.reflectId("KMutableProperty1");
    @NotNull
    private static final ClassId KMutableProperty2 = StandardClassIdsKt.reflectId("KMutableProperty2");
    @NotNull
    private static final ClassId KProperty = StandardClassIdsKt.reflectId("KProperty");
    @NotNull
    private static final ClassId KProperty0 = StandardClassIdsKt.reflectId("KProperty0");
    @NotNull
    private static final ClassId KProperty1 = StandardClassIdsKt.reflectId("KProperty1");
    @NotNull
    private static final ClassId KProperty2 = StandardClassIdsKt.reflectId("KProperty2");
    @NotNull
    private static final ClassId List = StandardClassIdsKt.collectionsId("List");
    @NotNull
    private static final ClassId ListIterator = StandardClassIdsKt.collectionsId("ListIterator");
    @NotNull
    private static final ClassId Long;
    @NotNull
    private static final ClassId LongRange = StandardClassIdsKt.rangesId("LongRange");
    @NotNull
    private static final ClassId Map;
    @NotNull
    private static final ClassId MapEntry;
    @NotNull
    private static final ClassId MutableCollection = StandardClassIdsKt.collectionsId("MutableCollection");
    @NotNull
    private static final ClassId MutableIterable = StandardClassIdsKt.collectionsId("MutableIterable");
    @NotNull
    private static final ClassId MutableIterator = StandardClassIdsKt.collectionsId("MutableIterator");
    @NotNull
    private static final ClassId MutableList = StandardClassIdsKt.collectionsId("MutableList");
    @NotNull
    private static final ClassId MutableListIterator = StandardClassIdsKt.collectionsId("MutableListIterator");
    @NotNull
    private static final ClassId MutableMap;
    @NotNull
    private static final ClassId MutableMapEntry;
    @NotNull
    private static final ClassId MutableSet = StandardClassIdsKt.collectionsId("MutableSet");
    @NotNull
    private static final ClassId Nothing = StandardClassIdsKt.baseId("Nothing");
    @NotNull
    private static final ClassId Number = StandardClassIdsKt.baseId("Number");
    @NotNull
    private static final ClassId Result = StandardClassIdsKt.baseId("Result");
    @NotNull
    private static final ClassId Set = StandardClassIdsKt.collectionsId("Set");
    @NotNull
    private static final ClassId Short;
    @NotNull
    private static final ClassId String = StandardClassIdsKt.baseId("String");
    @NotNull
    private static final ClassId Throwable = StandardClassIdsKt.baseId("Throwable");
    @NotNull
    private static final ClassId UByte;
    @NotNull
    private static final ClassId UInt;
    @NotNull
    private static final ClassId ULong;
    @NotNull
    private static final ClassId UShort;
    @NotNull
    private static final ClassId Unit = StandardClassIdsKt.baseId("Unit");
    @NotNull
    private static final Set<FqName> builtInsPackages;
    @NotNull
    private static final Set<ClassId> constantAllowedTypes = SetsKt.plus(SetsKt.plus(primitiveTypes, unsignedTypes), String);
    @NotNull
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType;
    @NotNull
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType;
    @NotNull
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType;
    @NotNull
    private static final Set<ClassId> primitiveTypes;
    @NotNull
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType;
    @NotNull
    private static final Set<ClassId> unsignedTypes;

    static {
        FqName fqName = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = fqName;
        FqName child = fqName.child(Name.identifier("reflect"));
        Intrinsics.checkNotNullExpressionValue(child, "BASE_KOTLIN_PACKAGE.chil…me.identifier(\"reflect\"))");
        BASE_REFLECT_PACKAGE = child;
        FqName child2 = fqName.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(child2, "BASE_KOTLIN_PACKAGE.chil…dentifier(\"collections\"))");
        BASE_COLLECTIONS_PACKAGE = child2;
        FqName child3 = fqName.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(child3, "BASE_KOTLIN_PACKAGE.chil…ame.identifier(\"ranges\"))");
        BASE_RANGES_PACKAGE = child3;
        FqName child4 = fqName.child(Name.identifier("jvm"));
        Intrinsics.checkNotNullExpressionValue(child4, "BASE_KOTLIN_PACKAGE.child(Name.identifier(\"jvm\"))");
        BASE_JVM_PACKAGE = child4;
        FqName child5 = child4.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child5, "BASE_JVM_PACKAGE.child(N…e.identifier(\"internal\"))");
        BASE_JVM_INTERNAL_PACKAGE = child5;
        FqName child6 = fqName.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child6, "BASE_KOTLIN_PACKAGE.chil…identifier(\"annotation\"))");
        BASE_ANNOTATION_PACKAGE = child6;
        FqName child7 = fqName.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child7, "BASE_KOTLIN_PACKAGE.chil…e.identifier(\"internal\"))");
        BASE_INTERNAL_PACKAGE = child7;
        FqName child8 = child7.child(Name.identifier("ir"));
        Intrinsics.checkNotNullExpressionValue(child8, "BASE_INTERNAL_PACKAGE.child(Name.identifier(\"ir\"))");
        BASE_INTERNAL_IR_PACKAGE = child8;
        FqName child9 = fqName.child(Name.identifier("coroutines"));
        Intrinsics.checkNotNullExpressionValue(child9, "BASE_KOTLIN_PACKAGE.chil…identifier(\"coroutines\"))");
        BASE_COROUTINES_PACKAGE = child9;
        FqName child10 = fqName.child(Name.identifier("enums"));
        Intrinsics.checkNotNullExpressionValue(child10, "BASE_KOTLIN_PACKAGE.chil…Name.identifier(\"enums\"))");
        BASE_ENUMS_PACKAGE = child10;
        builtInsPackages = SetsKt.setOf(fqName, child2, child3, child6, child, child7, child9);
        ClassId access$baseId = StandardClassIdsKt.baseId("Boolean");
        Boolean = access$baseId;
        ClassId access$baseId2 = StandardClassIdsKt.baseId("Char");
        Char = access$baseId2;
        ClassId access$baseId3 = StandardClassIdsKt.baseId("Byte");
        Byte = access$baseId3;
        ClassId access$baseId4 = StandardClassIdsKt.baseId("Short");
        Short = access$baseId4;
        ClassId access$baseId5 = StandardClassIdsKt.baseId("Int");
        Int = access$baseId5;
        ClassId access$baseId6 = StandardClassIdsKt.baseId("Long");
        Long = access$baseId6;
        ClassId access$baseId7 = StandardClassIdsKt.baseId("Float");
        Float = access$baseId7;
        ClassId access$baseId8 = StandardClassIdsKt.baseId("Double");
        Double = access$baseId8;
        UByte = StandardClassIdsKt.unsignedId(access$baseId3);
        UShort = StandardClassIdsKt.unsignedId(access$baseId4);
        UInt = StandardClassIdsKt.unsignedId(access$baseId5);
        ULong = StandardClassIdsKt.unsignedId(access$baseId6);
        Set<ClassId> of = SetsKt.setOf(access$baseId, access$baseId2, access$baseId3, access$baseId4, access$baseId5, access$baseId6, access$baseId7, access$baseId8);
        primitiveTypes = of;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(of, 10)), 16));
        for (T next : of) {
            Name shortClassName = ((ClassId) next).getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName, "id.shortClassName");
            linkedHashMap.put(next, StandardClassIdsKt.primitiveArrayId(shortClassName));
        }
        primitiveArrayTypeByElementType = linkedHashMap;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.inverseMap(linkedHashMap);
        Set<ClassId> of2 = SetsKt.setOf(UByte, UShort, UInt, ULong);
        unsignedTypes = of2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(of2, 10)), 16));
        for (T next2 : of2) {
            Name shortClassName2 = ((ClassId) next2).getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName2, "id.shortClassName");
            linkedHashMap2.put(next2, StandardClassIdsKt.primitiveArrayId(shortClassName2));
        }
        unsignedArrayTypeByElementType = linkedHashMap2;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.inverseMap(linkedHashMap2);
        ClassId access$collectionsId = StandardClassIdsKt.collectionsId("Map");
        Map = access$collectionsId;
        ClassId access$collectionsId2 = StandardClassIdsKt.collectionsId("MutableMap");
        MutableMap = access$collectionsId2;
        ClassId createNestedClassId = access$collectionsId.createNestedClassId(Name.identifier("Entry"));
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "Map.createNestedClassId(Name.identifier(\"Entry\"))");
        MapEntry = createNestedClassId;
        ClassId createNestedClassId2 = access$collectionsId2.createNestedClassId(Name.identifier("MutableEntry"));
        Intrinsics.checkNotNullExpressionValue(createNestedClassId2, "MutableMap.createNestedC…entifier(\"MutableEntry\"))");
        MutableMapEntry = createNestedClassId2;
    }

    private StandardClassIds() {
    }

    @NotNull
    public final ClassId getArray() {
        return Array;
    }

    @NotNull
    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_ENUMS_PACKAGE() {
        return BASE_ENUMS_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    @NotNull
    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    @NotNull
    public final ClassId getEnumEntries() {
        return EnumEntries;
    }

    @NotNull
    public final ClassId getKClass() {
        return KClass;
    }

    @NotNull
    public final ClassId getKFunction() {
        return KFunction;
    }

    @NotNull
    public final ClassId getMutableList() {
        return MutableList;
    }

    @NotNull
    public final ClassId getMutableMap() {
        return MutableMap;
    }

    @NotNull
    public final ClassId getMutableSet() {
        return MutableSet;
    }
}
