package com.xjsd.ai.assistant.common.util;

import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/xjsd/ai/assistant/common/util/StringUtil;", "", "<init>", "()V", "", "", "targetMap", "a", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", "d", "(Ljava/lang/String;)Ljava/lang/String;", "c", "b", "Ljava/util/Map;", "chn2NumMap", "getChn2NumSeriesMap", "()Ljava/util/Map;", "chn2NumSeriesMap", "num2ChnMap", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final StringUtil f8447a = new StringUtil();
    public static final Map b;
    public static final Map c;
    public static final Map d;

    static {
        Pair pair = TuplesKt.to("零", "0");
        Pair pair2 = TuplesKt.to("一", "1");
        Pair pair3 = TuplesKt.to("二", "2");
        Pair pair4 = TuplesKt.to("三", "3");
        Pair pair5 = TuplesKt.to("四", "4");
        Pair pair6 = TuplesKt.to("五", "5");
        Pair pair7 = TuplesKt.to("六", "6");
        Pair pair8 = TuplesKt.to("七", "7");
        Object obj = "七";
        Object obj2 = "7";
        Object obj3 = "八";
        Object obj4 = "8";
        Object obj5 = "九";
        Pair pair9 = pair6;
        Object obj6 = "9";
        Pair pair10 = pair7;
        Pair pair11 = pair8;
        Object obj7 = "3";
        Pair pair12 = TuplesKt.to("八", "8");
        Object obj8 = "三";
        b = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair9, pair10, pair11, pair12, TuplesKt.to("九", "9"));
        Object obj9 = "二";
        Object obj10 = "2";
        Object obj11 = "四";
        Object obj12 = "4";
        Object obj13 = "5";
        Object obj14 = "五";
        Object obj15 = "六";
        Object obj16 = "6";
        c = MapsKt.mapOf(TuplesKt.to("零", "0"), TuplesKt.to("一", "1"), TuplesKt.to(obj9, obj10), TuplesKt.to(obj8, obj7), TuplesKt.to(obj11, obj12), TuplesKt.to(obj14, obj13), TuplesKt.to(obj15, obj16), TuplesKt.to(obj, obj2), TuplesKt.to(obj3, obj4), TuplesKt.to(obj5, obj6), TuplesKt.to("十", "10"));
        d = MapsKt.mapOf(TuplesKt.to("0", "零"), TuplesKt.to("1", "一"), TuplesKt.to(obj10, obj9), TuplesKt.to(obj7, obj8), TuplesKt.to(obj12, obj11), TuplesKt.to(obj13, obj14), TuplesKt.to(obj16, obj15), TuplesKt.to(obj2, obj), TuplesKt.to(obj4, obj3), TuplesKt.to(obj6, obj5));
    }

    public static /* synthetic */ String b(StringUtil stringUtil, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = d;
        }
        return stringUtil.a(str, map);
    }

    public final String a(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(map, "targetMap");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            sb.append(map.getOrDefault(String.valueOf(charAt), Character.valueOf(charAt)));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String c(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String upperCase = d(str).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return b(this, upperCase, (Map) null, 1, (Object) null);
    }

    public final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[^0-9a-zA-Z\\u4e00-\\u9fa5]").replace((CharSequence) str, "");
    }
}
