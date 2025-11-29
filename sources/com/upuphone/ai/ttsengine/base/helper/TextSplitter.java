package com.upuphone.ai.ttsengine.base.helper;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/helper/TextSplitter;", "", "<init>", "()V", "", "text", "", "splitLen", "", "c", "(Ljava/lang/String;I)Ljava/util/List;", "Lcom/upuphone/ai/ttsengine/base/helper/TextSplitter$SymbolString;", "list", "b", "(Ljava/util/List;)I", "size", "a", "(Ljava/util/List;I)Ljava/lang/String;", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "symbolRegex", "SymbolString", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTextProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextProcessor.kt\ncom/upuphone/ai/ttsengine/base/helper/TextSplitter\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,207:1\n1313#2,2:208\n*S KotlinDebug\n*F\n+ 1 TextProcessor.kt\ncom/upuphone/ai/ttsengine/base/helper/TextSplitter\n*L\n45#1:208,2\n*E\n"})
public final class TextSplitter {

    /* renamed from: a  reason: collision with root package name */
    public static final TextSplitter f5506a = new TextSplitter();
    public static final AILOG b = AILOG.a("TextSplit");
    public static final Regex c = new Regex("[,，.。!！?？;；\n]");

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/helper/TextSplitter$SymbolString;", "", "", "content", "split", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SymbolString {

        /* renamed from: a  reason: collision with root package name */
        public final String f5507a;
        public final String b;

        public SymbolString(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "content");
            Intrinsics.checkNotNullParameter(str2, "split");
            this.f5507a = str;
            this.b = str2;
        }

        public final String a() {
            return this.f5507a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SymbolString)) {
                return false;
            }
            SymbolString symbolString = (SymbolString) obj;
            return Intrinsics.areEqual((Object) this.f5507a, (Object) symbolString.f5507a) && Intrinsics.areEqual((Object) this.b, (Object) symbolString.b);
        }

        public int hashCode() {
            return (this.f5507a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str = this.f5507a;
            String str2 = this.b;
            return "SymbolString(content=" + str + ", split=" + str2 + ")";
        }
    }

    public final String a(List list, int i) {
        String str = "";
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                str = str + ((SymbolString) list.get(i2)).a();
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return StringsKt.trim((CharSequence) str).toString();
    }

    public final int b(List list) {
        if (list.size() == 1) {
            return 0;
        }
        int a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$index$1.INSTANCE);
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$1.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$2.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$3.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$4.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$5.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$6.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$7.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$8.INSTANCE);
        }
        if (a2 < 0) {
            a2 = TextProcessorKt.b(list, TextSplitter$findOptimal$9.INSTANCE);
        }
        return a2 < 0 ? TextProcessorKt.b(list, TextSplitter$findOptimal$10.INSTANCE) : a2;
    }

    public final List c(String str, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "text");
        ArrayList arrayList = new ArrayList();
        try {
            Result.Companion companion = Result.Companion;
            if (StringsKt.encodeToByteArray(str).length <= i) {
                return CollectionsKt.listOf(str);
            }
            List arrayList2 = new ArrayList();
            Sequence<MatchResult> findAll = c.findAll(str, 0);
            b.c("split size: " + SequencesKt.count(findAll), new Object[0]);
            int i2 = 0;
            int i3 = 0;
            for (MatchResult next : findAll) {
                String substring = str.substring(i2, next.getRange().getFirst() + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                int length = StringsKt.encodeToByteArray(substring).length;
                if (i3 + length > i) {
                    int b2 = b(arrayList2);
                    String a2 = a(arrayList2, b2);
                    if (a2 != null && a2.length() > 0) {
                        arrayList.add(a(arrayList2, b2));
                    }
                    arrayList2 = CollectionsKt.toMutableList(CollectionsKt.drop(arrayList2, b2 + 1));
                    arrayList2.add(new SymbolString(substring, next.getValue()));
                    i3 = 0;
                } else {
                    arrayList2.add(new SymbolString(substring, next.getValue()));
                }
                i3 += length;
                i2 += substring.length();
            }
            if (i2 != str.length()) {
                String substring2 = str.substring(i2);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                arrayList2.add(new SymbolString(substring2, ""));
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(a(arrayList2, arrayList2.size() - 1));
            }
            obj = Result.m20constructorimpl(Unit.INSTANCE);
            Throwable r10 = Result.m23exceptionOrNullimpl(obj);
            if (r10 != null) {
                AILOG ailog = b;
                r10.printStackTrace();
                ailog.c("split text error: " + Unit.INSTANCE, new Object[0]);
                arrayList.clear();
                arrayList.add(str);
            }
            return arrayList;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }
}
