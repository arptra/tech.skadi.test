package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nValueClassUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,46:1\n1549#2:47\n1620#2,3:48\n1549#2:51\n1620#2,3:52\n1549#2:55\n1620#2,3:56\n*S KotlinDebug\n*F\n+ 1 ValueClassUtil.kt\norg/jetbrains/kotlin/serialization/deserialization/ValueClassUtilKt\n*L\n25#1:47\n25#1:48,3\n29#1:51\n29#1:52,3\n32#1:55\n32#1:56,3\n*E\n"})
public final class ValueClassUtilKt {
    @Nullable
    public static final <T extends SimpleTypeMarker> ValueClassRepresentation<T> loadValueClassRepresentation(@NotNull ProtoBuf.Class classR, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull Function1<? super ProtoBuf.Type, ? extends T> function1, @NotNull Function1<? super Name, ? extends T> function12) {
        SimpleTypeMarker simpleTypeMarker;
        List<Object> list;
        Intrinsics.checkNotNullParameter(classR, "<this>");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(function1, "typeDeserializer");
        Intrinsics.checkNotNullParameter(function12, "typeOfPublicProperty");
        if (classR.getMultiFieldValueClassUnderlyingNameCount() > 0) {
            List<Integer> multiFieldValueClassUnderlyingNameList = classR.getMultiFieldValueClassUnderlyingNameList();
            Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingNameList, "multiFieldValueClassUnderlyingNameList");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(multiFieldValueClassUnderlyingNameList, 10));
            for (Integer next : multiFieldValueClassUnderlyingNameList) {
                Intrinsics.checkNotNullExpressionValue(next, "it");
                arrayList.add(NameResolverUtilKt.getName(nameResolver, next.intValue()));
            }
            Pair pair = TuplesKt.to(Integer.valueOf(classR.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(classR.getMultiFieldValueClassUnderlyingTypeCount()));
            if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(Integer.valueOf(arrayList.size()), 0))) {
                List<Integer> multiFieldValueClassUnderlyingTypeIdList = classR.getMultiFieldValueClassUnderlyingTypeIdList();
                Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingTypeIdList, "multiFieldValueClassUnderlyingTypeIdList");
                list = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(multiFieldValueClassUnderlyingTypeIdList, 10));
                for (Integer next2 : multiFieldValueClassUnderlyingTypeIdList) {
                    Intrinsics.checkNotNullExpressionValue(next2, "it");
                    list.add(typeTable.get(next2.intValue()));
                }
            } else if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(0, Integer.valueOf(arrayList.size())))) {
                list = classR.getMultiFieldValueClassUnderlyingTypeList();
            } else {
                throw new IllegalStateException(("class " + NameResolverUtilKt.getName(nameResolver, classR.getFqName()) + " has illegal multi-field value class representation").toString());
            }
            Intrinsics.checkNotNullExpressionValue(list, "when (typeIdCount to typ…epresentation\")\n        }");
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Object invoke : list) {
                arrayList2.add(function1.invoke(invoke));
            }
            return new MultiFieldValueClassRepresentation(CollectionsKt.zip(arrayList, arrayList2));
        } else if (!classR.hasInlineClassUnderlyingPropertyName()) {
            return null;
        } else {
            Name name = NameResolverUtilKt.getName(nameResolver, classR.getInlineClassUnderlyingPropertyName());
            ProtoBuf.Type inlineClassUnderlyingType = ProtoTypeTableUtilKt.inlineClassUnderlyingType(classR, typeTable);
            if ((inlineClassUnderlyingType != null && (simpleTypeMarker = (SimpleTypeMarker) function1.invoke(inlineClassUnderlyingType)) != null) || (simpleTypeMarker = (SimpleTypeMarker) function12.invoke(name)) != null) {
                return new InlineClassRepresentation(name, simpleTypeMarker);
            }
            throw new IllegalStateException(("cannot determine underlying type for value class " + NameResolverUtilKt.getName(nameResolver, classR.getFqName()) + " with property " + name).toString());
        }
    }
}
