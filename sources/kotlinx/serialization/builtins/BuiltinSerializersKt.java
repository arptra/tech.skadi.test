package kotlinx.serialization.builtins;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanArraySerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharArraySerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleArraySerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongArraySerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.NothingSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.ShortArraySerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.UByteArraySerializer;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntArraySerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongArraySerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortArraySerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.internal.UnitSerializer;

@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\u001aG\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001aG\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\t\u0010\u0007\u001aa\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00100\u0002\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b\"\u0004\b\u0002\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002*\u00020\u0013¢\u0006\u0004\b\u000b\u0010\u0015\u001a\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0002*\u00020\u0019¢\u0006\u0004\b\n\u0010\u001b\u001a\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002¢\u0006\u0004\b\u001d\u0010\u0018\u001a\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0002H\u0007¢\u0006\u0004\b\u001f\u0010\u0018\u001a\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0002*\u00020 ¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0002¢\u0006\u0004\b%\u0010\u0018\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0002H\u0007¢\u0006\u0004\b'\u0010\u0018\u001a\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0002*\u00020(¢\u0006\u0004\b*\u0010+\u001a\u0013\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0002¢\u0006\u0004\b-\u0010\u0018\u001a\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0002H\u0007¢\u0006\u0004\b/\u0010\u0018\u001a\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002010\u0002*\u000200¢\u0006\u0004\b2\u00103\u001a\u0013\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0002¢\u0006\u0004\b5\u0010\u0018\u001a\u0015\u00107\u001a\b\u0012\u0004\u0012\u0002060\u0002H\u0007¢\u0006\u0004\b7\u0010\u0018\u001a\u0017\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0002*\u000208¢\u0006\u0004\b:\u0010;\u001a\u0013\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u0002¢\u0006\u0004\b=\u0010\u0018\u001a\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020?0\u0002*\u00020>¢\u0006\u0004\b\f\u0010@\u001a\u0013\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u0002¢\u0006\u0004\bB\u0010\u0018\u001a\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020D0\u0002*\u00020C¢\u0006\u0004\bE\u0010F\u001a\u0013\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u0002¢\u0006\u0004\bH\u0010\u0018\u001a\u0017\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\u0002*\u00020I¢\u0006\u0004\bJ\u0010K\u001a\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u0002*\u00020L¢\u0006\u0004\bN\u0010O\u001aM\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010U0\u0002\"\b\b\u0000\u0010Q*\u00020P\"\n\b\u0001\u0010**\u0004\u0018\u00018\u00002\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000R2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bV\u0010W\u001a-\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000X0\u0002\"\u0004\b\u0000\u0010Q2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\bY\u0010Z\u001aG\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010[0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\\\u0010\u0007\u001a\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020^0\u0002*\u00020]¢\u0006\u0004\b_\u0010`\u001a\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020b0\u0002*\u00020a¢\u0006\u0004\bc\u0010d\u001a\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020f0\u0002*\u00020e¢\u0006\u0004\bg\u0010h\u001a\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020j0\u0002*\u00020i¢\u0006\u0004\bk\u0010l\u001a\u0017\u0010o\u001a\b\u0012\u0004\u0012\u00020n0\u0002*\u00020m¢\u0006\u0004\bo\u0010p\u001a\u0015\u0010r\u001a\b\u0012\u0004\u0012\u00020q0\u0002H\u0007¢\u0006\u0004\br\u0010\u0018\"3\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\"\b\b\u0000\u0010Q*\u00020P*\b\u0012\u0004\u0012\u00028\u00000\u00028F¢\u0006\f\u0012\u0004\bt\u0010u\u001a\u0004\bs\u0010Z¨\u0006w"}, d2 = {"K", "V", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "Lkotlin/Pair;", "m", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "j", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "Lkotlin/Triple;", "o", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "Lkotlin/Char$Companion;", "", "(Lkotlin/jvm/internal/CharCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "d", "()Lkotlinx/serialization/KSerializer;", "Lkotlin/Byte$Companion;", "", "(Lkotlin/jvm/internal/ByteCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "c", "Lkotlin/UByteArray;", "p", "Lkotlin/Short$Companion;", "", "G", "(Lkotlin/jvm/internal/ShortCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "n", "Lkotlin/UShortArray;", "s", "Lkotlin/Int$Companion;", "", "E", "(Lkotlin/jvm/internal/IntCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "g", "Lkotlin/UIntArray;", "q", "Lkotlin/Long$Companion;", "", "F", "(Lkotlin/jvm/internal/LongCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "i", "Lkotlin/ULongArray;", "r", "Lkotlin/Float$Companion;", "", "D", "(Lkotlin/jvm/internal/FloatCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "f", "Lkotlin/Double$Companion;", "", "(Lkotlin/jvm/internal/DoubleCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "e", "Lkotlin/Boolean$Companion;", "", "z", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "b", "", "y", "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", "Lkotlin/String$Companion;", "", "H", "(Lkotlin/jvm/internal/StringCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "T", "Lkotlin/reflect/KClass;", "kClass", "elementSerializer", "", "a", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "h", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "k", "Lkotlin/UInt$Companion;", "Lkotlin/UInt;", "v", "(Lkotlin/UInt$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/ULong$Companion;", "Lkotlin/ULong;", "w", "(Lkotlin/ULong$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/UByte$Companion;", "Lkotlin/UByte;", "u", "(Lkotlin/UByte$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/UShort$Companion;", "Lkotlin/UShort;", "x", "(Lkotlin/UShort$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/time/Duration$Companion;", "Lkotlin/time/Duration;", "I", "(Lkotlin/time/Duration$Companion;)Lkotlinx/serialization/KSerializer;", "", "l", "t", "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "nullable", "kotlinx-serialization-core"}, k = 2, mv = {1, 9, 0})
public final class BuiltinSerializersKt {
    public static final KSerializer A(ByteCompanionObject byteCompanionObject) {
        Intrinsics.checkNotNullParameter(byteCompanionObject, "<this>");
        return ByteSerializer.f4017a;
    }

    public static final KSerializer B(CharCompanionObject charCompanionObject) {
        Intrinsics.checkNotNullParameter(charCompanionObject, "<this>");
        return CharSerializer.f4021a;
    }

    public static final KSerializer C(DoubleCompanionObject doubleCompanionObject) {
        Intrinsics.checkNotNullParameter(doubleCompanionObject, "<this>");
        return DoubleSerializer.f4028a;
    }

    public static final KSerializer D(FloatCompanionObject floatCompanionObject) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return FloatSerializer.f4033a;
    }

    public static final KSerializer E(IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return IntSerializer.f4036a;
    }

    public static final KSerializer F(LongCompanionObject longCompanionObject) {
        Intrinsics.checkNotNullParameter(longCompanionObject, "<this>");
        return LongSerializer.f4042a;
    }

    public static final KSerializer G(ShortCompanionObject shortCompanionObject) {
        Intrinsics.checkNotNullParameter(shortCompanionObject, "<this>");
        return ShortSerializer.f4059a;
    }

    public static final KSerializer H(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        return StringSerializer.f4060a;
    }

    public static final KSerializer I(Duration.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return DurationSerializer.f4029a;
    }

    public static final KSerializer a(KClass kClass, KSerializer kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        return new ReferenceArraySerializer(kClass, kSerializer);
    }

    public static final KSerializer b() {
        return BooleanArraySerializer.c;
    }

    public static final KSerializer c() {
        return ByteArraySerializer.c;
    }

    public static final KSerializer d() {
        return CharArraySerializer.c;
    }

    public static final KSerializer e() {
        return DoubleArraySerializer.c;
    }

    public static final KSerializer f() {
        return FloatArraySerializer.c;
    }

    public static final KSerializer g() {
        return IntArraySerializer.c;
    }

    public static final KSerializer h(KSerializer kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        return new ArrayListSerializer(kSerializer);
    }

    public static final KSerializer i() {
        return LongArraySerializer.c;
    }

    public static final KSerializer j(KSerializer kSerializer, KSerializer kSerializer2) {
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        return new MapEntrySerializer(kSerializer, kSerializer2);
    }

    public static final KSerializer k(KSerializer kSerializer, KSerializer kSerializer2) {
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        return new LinkedHashMapSerializer(kSerializer, kSerializer2);
    }

    public static final KSerializer l() {
        return NothingSerializer.f4048a;
    }

    public static final KSerializer m(KSerializer kSerializer, KSerializer kSerializer2) {
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        return new PairSerializer(kSerializer, kSerializer2);
    }

    public static final KSerializer n() {
        return ShortArraySerializer.c;
    }

    public static final KSerializer o(KSerializer kSerializer, KSerializer kSerializer2, KSerializer kSerializer3) {
        Intrinsics.checkNotNullParameter(kSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "bSerializer");
        Intrinsics.checkNotNullParameter(kSerializer3, "cSerializer");
        return new TripleSerializer(kSerializer, kSerializer2, kSerializer3);
    }

    public static final KSerializer p() {
        return UByteArraySerializer.c;
    }

    public static final KSerializer q() {
        return UIntArraySerializer.c;
    }

    public static final KSerializer r() {
        return ULongArraySerializer.c;
    }

    public static final KSerializer s() {
        return UShortArraySerializer.c;
    }

    public static final KSerializer t(KSerializer kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        return kSerializer.getDescriptor().b() ? kSerializer : new NullableSerializer(kSerializer);
    }

    public static final KSerializer u(UByte.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return UByteSerializer.f4066a;
    }

    public static final KSerializer v(UInt.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return UIntSerializer.f4068a;
    }

    public static final KSerializer w(ULong.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return ULongSerializer.f4070a;
    }

    public static final KSerializer x(UShort.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return UShortSerializer.f4072a;
    }

    public static final KSerializer y(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<this>");
        return UnitSerializer.b;
    }

    public static final KSerializer z(BooleanCompanionObject booleanCompanionObject) {
        Intrinsics.checkNotNullParameter(booleanCompanionObject, "<this>");
        return BooleanSerializer.f4015a;
    }
}
