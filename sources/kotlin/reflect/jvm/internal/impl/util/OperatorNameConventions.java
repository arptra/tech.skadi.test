package kotlin.reflect.jvm.internal.impl.util;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class OperatorNameConventions {
    @NotNull
    @JvmField
    public static final Set<Name> ALL_BINARY_OPERATION_NAMES;
    @NotNull
    @JvmField
    public static final Name AND;
    @NotNull
    @JvmField
    public static final Set<Name> ASSIGNMENT_OPERATIONS;
    @NotNull
    @JvmField
    public static final Set<Name> BINARY_OPERATION_NAMES;
    @NotNull
    @JvmField
    public static final Set<Name> BITWISE_OPERATION_NAMES;
    @NotNull
    @JvmField
    public static final Name COMPARE_TO;
    @NotNull
    @JvmField
    public static final Regex COMPONENT_REGEX = new Regex("component\\d+");
    @NotNull
    @JvmField
    public static final Name CONTAINS;
    @NotNull
    @JvmField
    public static final Name DEC;
    @NotNull
    @JvmField
    public static final Set<Name> DELEGATED_PROPERTY_OPERATORS;
    @NotNull
    @JvmField
    public static final Name DIV;
    @NotNull
    @JvmField
    public static final Name DIV_ASSIGN;
    @NotNull
    @JvmField
    public static final Name EQUALS;
    @NotNull
    @JvmField
    public static final Name GET;
    @NotNull
    @JvmField
    public static final Name GET_VALUE;
    @NotNull
    @JvmField
    public static final Name HASH_CODE;
    @NotNull
    @JvmField
    public static final Name HAS_NEXT;
    @NotNull
    @JvmField
    public static final Name INC;
    @NotNull
    public static final OperatorNameConventions INSTANCE = new OperatorNameConventions();
    @NotNull
    @JvmField
    public static final Name INV;
    @NotNull
    @JvmField
    public static final Name INVOKE;
    @NotNull
    @JvmField
    public static final Name ITERATOR;
    @NotNull
    @JvmField
    public static final Name MINUS;
    @NotNull
    @JvmField
    public static final Name MINUS_ASSIGN;
    @NotNull
    @JvmField
    public static final Name MOD;
    @NotNull
    @JvmField
    public static final Name MOD_ASSIGN;
    @NotNull
    @JvmField
    public static final Name NEXT;
    @NotNull
    @JvmField
    public static final Name NOT;
    @NotNull
    @JvmField
    public static final Name OR;
    @NotNull
    @JvmField
    public static final Name PLUS;
    @NotNull
    @JvmField
    public static final Name PLUS_ASSIGN;
    @NotNull
    @JvmField
    public static final Name PROVIDE_DELEGATE;
    @NotNull
    @JvmField
    public static final Name RANGE_TO;
    @NotNull
    @JvmField
    public static final Name RANGE_UNTIL;
    @NotNull
    @JvmField
    public static final Name REM;
    @NotNull
    @JvmField
    public static final Name REM_ASSIGN;
    @NotNull
    @JvmField
    public static final Name SET;
    @NotNull
    @JvmField
    public static final Name SET_VALUE;
    @NotNull
    @JvmField
    public static final Name SHL;
    @NotNull
    @JvmField
    public static final Name SHR;
    @NotNull
    @JvmField
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES;
    @NotNull
    @JvmField
    public static final Name TIMES;
    @NotNull
    @JvmField
    public static final Name TIMES_ASSIGN;
    @NotNull
    @JvmField
    public static final Name TO_STRING;
    @NotNull
    @JvmField
    public static final Name UNARY_MINUS;
    @NotNull
    @JvmField
    public static final Set<Name> UNARY_OPERATION_NAMES;
    @NotNull
    @JvmField
    public static final Name UNARY_PLUS;
    @NotNull
    @JvmField
    public static final Name USHR;
    @NotNull
    @JvmField
    public static final Name XOR;

    static {
        Name identifier = Name.identifier("getValue");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"getValue\")");
        GET_VALUE = identifier;
        Name identifier2 = Name.identifier("setValue");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"setValue\")");
        SET_VALUE = identifier2;
        Name identifier3 = Name.identifier("provideDelegate");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = identifier3;
        Name identifier4 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"equals\")");
        EQUALS = identifier4;
        Name identifier5 = Name.identifier("hashCode");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"hashCode\")");
        HASH_CODE = identifier5;
        Name identifier6 = Name.identifier("compareTo");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(\"compareTo\")");
        COMPARE_TO = identifier6;
        Name identifier7 = Name.identifier("contains");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(\"contains\")");
        CONTAINS = identifier7;
        Name identifier8 = Name.identifier("invoke");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(\"invoke\")");
        INVOKE = identifier8;
        Name identifier9 = Name.identifier("iterator");
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(\"iterator\")");
        ITERATOR = identifier9;
        Name identifier10 = Name.identifier("get");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(\"get\")");
        GET = identifier10;
        Name identifier11 = Name.identifier("set");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(\"set\")");
        SET = identifier11;
        Name identifier12 = Name.identifier("next");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(\"next\")");
        NEXT = identifier12;
        Name identifier13 = Name.identifier("hasNext");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(\"hasNext\")");
        HAS_NEXT = identifier13;
        Name identifier14 = Name.identifier("toString");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(\"toString\")");
        TO_STRING = identifier14;
        Name identifier15 = Name.identifier("and");
        Intrinsics.checkNotNullExpressionValue(identifier15, "identifier(\"and\")");
        AND = identifier15;
        Name identifier16 = Name.identifier("or");
        Intrinsics.checkNotNullExpressionValue(identifier16, "identifier(\"or\")");
        OR = identifier16;
        Name identifier17 = Name.identifier("xor");
        Intrinsics.checkNotNullExpressionValue(identifier17, "identifier(\"xor\")");
        XOR = identifier17;
        Name identifier18 = Name.identifier("inv");
        Intrinsics.checkNotNullExpressionValue(identifier18, "identifier(\"inv\")");
        INV = identifier18;
        Name identifier19 = Name.identifier("shl");
        Intrinsics.checkNotNullExpressionValue(identifier19, "identifier(\"shl\")");
        SHL = identifier19;
        Name identifier20 = Name.identifier("shr");
        Intrinsics.checkNotNullExpressionValue(identifier20, "identifier(\"shr\")");
        SHR = identifier20;
        Name identifier21 = Name.identifier("ushr");
        Intrinsics.checkNotNullExpressionValue(identifier21, "identifier(\"ushr\")");
        USHR = identifier21;
        Name identifier22 = Name.identifier("inc");
        Intrinsics.checkNotNullExpressionValue(identifier22, "identifier(\"inc\")");
        INC = identifier22;
        Name identifier23 = Name.identifier("dec");
        Intrinsics.checkNotNullExpressionValue(identifier23, "identifier(\"dec\")");
        DEC = identifier23;
        Name identifier24 = Name.identifier("plus");
        Name name = identifier21;
        Intrinsics.checkNotNullExpressionValue(identifier24, "identifier(\"plus\")");
        PLUS = identifier24;
        Name identifier25 = Name.identifier("minus");
        Name name2 = identifier24;
        Intrinsics.checkNotNullExpressionValue(identifier25, "identifier(\"minus\")");
        MINUS = identifier25;
        Name identifier26 = Name.identifier("not");
        Name name3 = identifier25;
        Intrinsics.checkNotNullExpressionValue(identifier26, "identifier(\"not\")");
        NOT = identifier26;
        Name identifier27 = Name.identifier("unaryMinus");
        Name name4 = identifier26;
        Intrinsics.checkNotNullExpressionValue(identifier27, "identifier(\"unaryMinus\")");
        UNARY_MINUS = identifier27;
        Name identifier28 = Name.identifier("unaryPlus");
        Name name5 = identifier27;
        Intrinsics.checkNotNullExpressionValue(identifier28, "identifier(\"unaryPlus\")");
        UNARY_PLUS = identifier28;
        Name identifier29 = Name.identifier("times");
        Name name6 = identifier28;
        Intrinsics.checkNotNullExpressionValue(identifier29, "identifier(\"times\")");
        TIMES = identifier29;
        Name identifier30 = Name.identifier("div");
        Name name7 = identifier29;
        Intrinsics.checkNotNullExpressionValue(identifier30, "identifier(\"div\")");
        DIV = identifier30;
        Name identifier31 = Name.identifier("mod");
        Name name8 = identifier30;
        Intrinsics.checkNotNullExpressionValue(identifier31, "identifier(\"mod\")");
        MOD = identifier31;
        Name identifier32 = Name.identifier("rem");
        Name name9 = identifier31;
        Intrinsics.checkNotNullExpressionValue(identifier32, "identifier(\"rem\")");
        REM = identifier32;
        Name identifier33 = Name.identifier("rangeTo");
        Name name10 = identifier32;
        Intrinsics.checkNotNullExpressionValue(identifier33, "identifier(\"rangeTo\")");
        RANGE_TO = identifier33;
        Name identifier34 = Name.identifier("rangeUntil");
        Name name11 = identifier33;
        Intrinsics.checkNotNullExpressionValue(identifier34, "identifier(\"rangeUntil\")");
        RANGE_UNTIL = identifier34;
        Name identifier35 = Name.identifier("timesAssign");
        Name name12 = identifier34;
        Intrinsics.checkNotNullExpressionValue(identifier35, "identifier(\"timesAssign\")");
        TIMES_ASSIGN = identifier35;
        Name identifier36 = Name.identifier("divAssign");
        Name name13 = identifier35;
        Intrinsics.checkNotNullExpressionValue(identifier36, "identifier(\"divAssign\")");
        DIV_ASSIGN = identifier36;
        Name identifier37 = Name.identifier("modAssign");
        Name name14 = identifier36;
        Intrinsics.checkNotNullExpressionValue(identifier37, "identifier(\"modAssign\")");
        MOD_ASSIGN = identifier37;
        Name identifier38 = Name.identifier("remAssign");
        Name name15 = identifier37;
        Intrinsics.checkNotNullExpressionValue(identifier38, "identifier(\"remAssign\")");
        REM_ASSIGN = identifier38;
        Name identifier39 = Name.identifier("plusAssign");
        Name name16 = identifier38;
        Intrinsics.checkNotNullExpressionValue(identifier39, "identifier(\"plusAssign\")");
        PLUS_ASSIGN = identifier39;
        Name identifier40 = Name.identifier("minusAssign");
        Name name17 = identifier39;
        Intrinsics.checkNotNullExpressionValue(identifier40, "identifier(\"minusAssign\")");
        MINUS_ASSIGN = identifier40;
        Name name18 = identifier40;
        Name name19 = name4;
        Name name20 = name8;
        Name name21 = name10;
        Name name22 = name12;
        Name name23 = name6;
        Name name24 = name11;
        Name name25 = name9;
        Name name26 = name;
        Name name27 = name19;
        Name name28 = identifier20;
        UNARY_OPERATION_NAMES = SetsKt.setOf(identifier22, identifier23, name23, name5, name27, identifier18);
        SIMPLE_UNARY_OPERATION_NAMES = SetsKt.setOf(name23, name5, name27, identifier18);
        Set<Name> of = SetsKt.setOf(name7, name2, name3, name20, name25, name21, name24, name22);
        BINARY_OPERATION_NAMES = of;
        Set<Name> of2 = SetsKt.setOf(identifier15, identifier16, identifier17, identifier18, identifier19, name28, name26);
        BITWISE_OPERATION_NAMES = of2;
        ALL_BINARY_OPERATION_NAMES = SetsKt.plus(SetsKt.plus(of, of2), SetsKt.setOf(identifier4, identifier7, identifier6));
        ASSIGNMENT_OPERATIONS = SetsKt.setOf(name13, name14, name15, name16, name17, name18);
        DELEGATED_PROPERTY_OPERATORS = SetsKt.setOf(identifier, identifier2, identifier3);
    }

    private OperatorNameConventions() {
    }
}
