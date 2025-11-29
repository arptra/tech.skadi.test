package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u000f2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u00072\u0006\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/utils/TextSimilarityUtils;", "", "<init>", "()V", "", "originalText", "matchText", "Lkotlin/Pair;", "", "c", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Pair;", "strA", "strB", "", "similarityThreshold", "", "b", "(Ljava/lang/String;Ljava/lang/String;D)Ljava/util/List;", "str1", "str2", "systemLanguage", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)D", "", "f", "(Ljava/lang/String;)V", "aLength", "maxThreshold", "a", "(ID)D", "text", "h", "(Ljava/lang/String;)Lkotlin/Pair;", "g", "(Ljava/lang/String;)Ljava/util/List;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTextSimilarityUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextSimilarityUtils.kt\ncom/upuphone/xr/sapp/utils/TextSimilarityUtils\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,215:1\n1313#2,2:216\n*S KotlinDebug\n*F\n+ 1 TextSimilarityUtils.kt\ncom/upuphone/xr/sapp/utils/TextSimilarityUtils\n*L\n196#1:216,2\n*E\n"})
public final class TextSimilarityUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TextSimilarityUtils f7926a = new TextSimilarityUtils();

    public static /* synthetic */ double e(TextSimilarityUtils textSimilarityUtils, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "zh";
        }
        return textSimilarityUtils.d(str, str2, str3);
    }

    public final double a(int i, double d) {
        if (i <= 5) {
            return 0.4d;
        }
        return RangesKt.coerceAtMost(((double) i) * 0.02d, d - 0.4d) + 0.4d;
    }

    public final List b(String str, String str2, double d) {
        String str3 = str;
        String str4 = str2;
        double d2 = d;
        Intrinsics.checkNotNullParameter(str3, "strA");
        Intrinsics.checkNotNullParameter(str4, "strB");
        List g = g(str);
        Pair h = h(str4);
        List list = (List) h.component1();
        List list2 = (List) h.component2();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (g.size() > list.size()) {
            if (d(str3, str4, "en") >= d2) {
                arrayList.add(new Pair(0, Integer.valueOf(CollectionsKt.getLastIndex(list))));
            }
            return arrayList;
        }
        int size = g.size();
        int size2 = list.size() - size;
        if (size2 >= 0) {
            while (true) {
                int i2 = i + size;
                if (d(str3, CollectionsKt.joinToString$default(list.subList(i, i2), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), "en") >= a(size, d2)) {
                    int i3 = i2 - 1;
                    arrayList.add(new Pair(Integer.valueOf(((Number) list2.get(i)).intValue()), Integer.valueOf(((Number) list2.get(i3)).intValue() + ((String) list.get(i3)).length())));
                }
                if (i == size2) {
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair c(java.lang.String r21, java.lang.String r22) {
        /*
            r20 = this;
            r6 = r20
            r0 = r21
            r1 = r22
            java.lang.String r2 = "originalText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "matchText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r7 = r0.toLowerCase(r2)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.lang.String r8 = r1.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            int r0 = r7.length()
            int r1 = r8.length()
            int r9 = r0 - r1
            java.lang.String r10 = ""
            r11 = -1
            r0 = 0
            r12 = 0
            r13 = r0
            r17 = r10
            if (r9 < 0) goto L_0x0071
            r16 = r11
            r15 = r12
        L_0x003b:
            int r0 = r8.length()
            int r0 = r0 + r15
            int r1 = r7.length()
            if (r0 <= r1) goto L_0x0049
        L_0x0046:
            r9 = r16
            goto L_0x0072
        L_0x0049:
            java.lang.String r5 = r7.substring(r15, r0)
            java.lang.String r0 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r4 = 4
            r18 = 0
            r3 = 0
            r0 = r20
            r1 = r5
            r2 = r8
            r19 = r5
            r5 = r18
            double r0 = e(r0, r1, r2, r3, r4, r5)
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x006c
            r13 = r0
            r16 = r15
            r17 = r19
        L_0x006c:
            if (r15 == r9) goto L_0x0046
            int r15 = r15 + 1
            goto L_0x003b
        L_0x0071:
            r9 = r11
        L_0x0072:
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r18 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            if (r9 != r11) goto L_0x00ae
            int r0 = r7.length()
            int r1 = r8.length()
            if (r0 >= r1) goto L_0x00ae
            r4 = 4
            r5 = 0
            r3 = 0
            r0 = r20
            r1 = r7
            r2 = r8
            double r0 = e(r0, r1, r2, r3, r4, r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "findMostSimilarSubstring similarity="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r6.f(r2)
            int r2 = (r18 > r0 ? 1 : (r18 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ae
            int r2 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x00ae
            r13 = r0
            goto L_0x00b1
        L_0x00ae:
            r12 = r9
            r7 = r17
        L_0x00b1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "findMostSimilarSubstring final similarity="
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            r6.f(r0)
            int r0 = (r18 > r13 ? 1 : (r18 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x00d7
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 > 0) goto L_0x00d7
            kotlin.Pair r0 = new kotlin.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r0.<init>(r7, r1)
            goto L_0x00e0
        L_0x00d7:
            kotlin.Pair r0 = new kotlin.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            r0.<init>(r10, r1)
        L_0x00e0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.TextSimilarityUtils.c(java.lang.String, java.lang.String):kotlin.Pair");
    }

    public final double d(String str, String str2, String str3) {
        Iterable set = Intrinsics.areEqual((Object) str3, (Object) "zh") ? StringsKt.toSet(str) : g(str);
        Iterable set2 = Intrinsics.areEqual((Object) str3, (Object) "zh") ? StringsKt.toSet(str2) : g(str2);
        double size = (double) CollectionsKt.intersect(set, set2).size();
        double size2 = (double) CollectionsKt.union(set, set2).size();
        if (size2 == 0.0d) {
            return 0.0d;
        }
        return size / size2;
    }

    public final void f(String str) {
        ULog.f6446a.g("TextSimilarityUtils", str);
    }

    public final List g(String str) {
        return SequencesKt.toList(SequencesKt.map(Regex.findAll$default(new Regex("[a-zA-Z]+(?:'[a-z]+)?"), str, 0, 2, (Object) null), TextSimilarityUtils$tokenize$1.INSTANCE));
    }

    public final Pair h(String str) {
        Regex regex = new Regex("[a-zA-Z]+(?:'[a-z]+)?");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MatchResult matchResult : Regex.findAll$default(regex, str, 0, 2, (Object) null)) {
            arrayList.add(matchResult.getValue());
            arrayList2.add(Integer.valueOf(matchResult.getRange().getFirst()));
        }
        return new Pair(arrayList, arrayList2);
    }
}
