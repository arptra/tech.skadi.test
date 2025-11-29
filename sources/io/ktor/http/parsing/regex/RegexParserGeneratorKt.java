package io.ktor.http.parsing.regex;

import com.meizu.common.widget.MzContactsContract;
import io.ktor.http.parsing.AnyOfGrammar;
import io.ktor.http.parsing.AtLeastOne;
import io.ktor.http.parsing.ComplexGrammar;
import io.ktor.http.parsing.Grammar;
import io.ktor.http.parsing.ManyGrammar;
import io.ktor.http.parsing.MaybeGrammar;
import io.ktor.http.parsing.NamedGrammar;
import io.ktor.http.parsing.OrGrammar;
import io.ktor.http.parsing.Parser;
import io.ktor.http.parsing.RangeGrammar;
import io.ktor.http.parsing.RawGrammar;
import io.ktor.http.parsing.SimpleGrammar;
import io.ktor.http.parsing.StringGrammar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001aA\u0010\r\u001a\u00020\f*\u00020\u00002\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a5\u0010\u0012\u001a\u00020\u0011*\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/Parser;", "b", "(Lio/ktor/http/parsing/Grammar;)Lio/ktor/http/parsing/Parser;", "", "", "", "", "groups", "offset", "", "shouldGroup", "Lio/ktor/http/parsing/regex/GrammarRegex;", "c", "(Lio/ktor/http/parsing/Grammar;Ljava/util/Map;IZ)Lio/ktor/http/parsing/regex/GrammarRegex;", "key", "value", "", "a", "(Ljava/util/Map;Ljava/lang/String;I)V", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRegexParserGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RegexParserGenerator.kt\nio/ktor/http/parsing/regex/RegexParserGeneratorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,72:1\n1864#2,3:73\n*S KotlinDebug\n*F\n+ 1 RegexParserGenerator.kt\nio/ktor/http/parsing/regex/RegexParserGeneratorKt\n*L\n41#1:73,3\n*E\n"})
public final class RegexParserGeneratorKt {
    public static final void a(Map map, String str, int i) {
        if (!map.containsKey(str)) {
            map.put(str, new ArrayList());
        }
        Integer valueOf = Integer.valueOf(i);
        Object obj = map.get(str);
        Intrinsics.checkNotNull(obj);
        ((Collection) obj).add(valueOf);
    }

    public static final Parser b(Grammar grammar) {
        Intrinsics.checkNotNullParameter(grammar, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return new RegexParser(new Regex(d(grammar, linkedHashMap, 0, false, 6, (Object) null).b()), linkedHashMap);
    }

    public static final GrammarRegex c(Grammar grammar, Map map, int i, boolean z) {
        char c;
        if (grammar instanceof StringGrammar) {
            return new GrammarRegex(Regex.Companion.escape(((StringGrammar) grammar).c()), 0, false, 6, (DefaultConstructorMarker) null);
        }
        if (grammar instanceof RawGrammar) {
            return new GrammarRegex(((RawGrammar) grammar).c(), 0, false, 6, (DefaultConstructorMarker) null);
        }
        if (grammar instanceof NamedGrammar) {
            NamedGrammar namedGrammar = (NamedGrammar) grammar;
            GrammarRegex d = d(namedGrammar.b(), map, i + 1, false, 4, (Object) null);
            a(map, namedGrammar.c(), i);
            return new GrammarRegex(d.b(), d.a(), true);
        } else if (grammar instanceof ComplexGrammar) {
            StringBuilder sb = new StringBuilder();
            int i2 = z ? i + 1 : i;
            int i3 = 0;
            for (Object next : ((ComplexGrammar) grammar).a()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                GrammarRegex c2 = c((Grammar) next, map, i2, true);
                if (i3 != 0 && (grammar instanceof OrGrammar)) {
                    sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
                }
                sb.append(c2.b());
                i2 += c2.a();
                i3 = i4;
            }
            int i5 = i2 - i;
            if (z) {
                i5--;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "expression.toString()");
            return new GrammarRegex(sb2, i5, z);
        } else if (grammar instanceof SimpleGrammar) {
            if (grammar instanceof MaybeGrammar) {
                c = '?';
            } else if (grammar instanceof ManyGrammar) {
                c = '*';
            } else if (grammar instanceof AtLeastOne) {
                c = '+';
            } else {
                throw new IllegalStateException(("Unsupported simple grammar element: " + grammar).toString());
            }
            GrammarRegex c3 = c(((SimpleGrammar) grammar).b(), map, i, true);
            return new GrammarRegex(c3.b() + c, c3.a(), false, 4, (DefaultConstructorMarker) null);
        } else if (grammar instanceof AnyOfGrammar) {
            return new GrammarRegex('[' + Regex.Companion.escape(((AnyOfGrammar) grammar).c()) + ']', 0, false, 6, (DefaultConstructorMarker) null);
        } else if (grammar instanceof RangeGrammar) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('[');
            RangeGrammar rangeGrammar = (RangeGrammar) grammar;
            sb3.append(rangeGrammar.c());
            sb3.append(Soundex.SILENT_MARKER);
            sb3.append(rangeGrammar.d());
            sb3.append(']');
            return new GrammarRegex(sb3.toString(), 0, false, 6, (DefaultConstructorMarker) null);
        } else {
            throw new IllegalStateException(("Unsupported grammar element: " + grammar).toString());
        }
    }

    public static /* synthetic */ GrammarRegex d(Grammar grammar, Map map, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return c(grammar, map, i, z);
    }
}
