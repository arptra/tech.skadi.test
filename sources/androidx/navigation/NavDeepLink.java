package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.meizu.common.util.CommonConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0004HIJKB'\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00022\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J1\u0010%\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010(\u001a\u0004\b-\u0010*R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010/R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000201008\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010(R\u001d\u00109\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b-\u00106\u001a\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010(R\u001d\u0010>\u001a\u0004\u0018\u00010\u001d8BX\u0002¢\u0006\f\n\u0004\b7\u00106\u001a\u0004\b<\u00108R*\u0010D\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00148G@@X\u000e¢\u0006\u0012\n\u0004\b)\u0010:\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00020E8@X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010F¨\u0006L"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "", "uriPattern", "action", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "h", "(Ljava/lang/String;)I", "Landroid/net/Uri;", "deepLink", "", "Landroidx/navigation/NavArgument;", "arguments", "Landroid/os/Bundle;", "f", "(Landroid/net/Uri;Ljava/util/Map;)Landroid/os/Bundle;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "uri", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "uriRegex", "Ljava/util/regex/Pattern;", "fillInPattern", "c", "(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/regex/Pattern;)Z", "bundle", "name", "value", "argument", "m", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)Z", "a", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "b", "d", "g", "", "Ljava/util/List;", "", "Landroidx/navigation/NavDeepLink$ParamQuery;", "e", "Ljava/util/Map;", "paramArgMap", "patternFinalRegex", "Lkotlin/Lazy;", "j", "()Ljava/util/regex/Pattern;", "pattern", "Z", "isParameterizedQuery", "i", "mimeTypeFinalRegex", "mimeTypePattern", "<set-?>", "l", "()Z", "setExactDeepLink$navigation_common_release", "(Z)V", "isExactDeepLink", "", "()Ljava/util/List;", "argumentsNames", "Builder", "Companion", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavDeepLink {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public static final Pattern m = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a  reason: collision with root package name */
    public final String f1477a;
    public final String b;
    public final String c;
    public final List d = new ArrayList();
    public final Map e = new LinkedHashMap();
    public String f;
    public final Lazy g = LazyKt.lazy(new NavDeepLink$pattern$2(this));
    public boolean h;
    public String i;
    public final Lazy j = LazyKt.lazy(new NavDeepLink$mimeTypePattern$2(this));
    public boolean k;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0010B\t\b\u0017¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0007J\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "<init>", "()V", "", "uriPattern", "d", "(Ljava/lang/String;)Landroidx/navigation/NavDeepLink$Builder;", "action", "b", "mimeType", "c", "Landroidx/navigation/NavDeepLink;", "a", "()Landroidx/navigation/NavDeepLink;", "Ljava/lang/String;", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Builder {
        public static final Companion d = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public String f1478a;
        public String b;
        public String c;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "<init>", "()V", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public Companion() {
            }
        }

        public final NavDeepLink a() {
            return new NavDeepLink(this.f1478a, this.b, this.c);
        }

        public final Builder b(String str) {
            Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
            if (str.length() > 0) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        }

        public final Builder c(String str) {
            Intrinsics.checkNotNullParameter(str, "mimeType");
            this.c = str;
            return this;
        }

        public final Builder d(String str) {
            Intrinsics.checkNotNullParameter(str, "uriPattern");
            this.f1478a = str;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0005¨\u0006\u0013"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "", "mimeType", "<init>", "(Ljava/lang/String;)V", "other", "", "a", "(Landroidx/navigation/NavDeepLink$MimeType;)I", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setType", "type", "b", "d", "setSubType", "subType", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class MimeType implements Comparable<MimeType> {

        /* renamed from: a  reason: collision with root package name */
        public String f1479a;
        public String b;

        public MimeType(String str) {
            List<T> list;
            Intrinsics.checkNotNullParameter(str, "mimeType");
            List<String> split = new Regex("/").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            list = CollectionsKt.emptyList();
            this.f1479a = (String) list.get(0);
            this.b = (String) list.get(1);
        }

        /* renamed from: a */
        public int compareTo(MimeType mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "other");
            int i = Intrinsics.areEqual((Object) this.f1479a, (Object) mimeType.f1479a) ? 2 : 0;
            return Intrinsics.areEqual((Object) this.b, (Object) mimeType.b) ? i + 1 : i;
        }

        public final String d() {
            return this.b;
        }

        public final String f() {
            return this.f1479a;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\bR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "<init>", "()V", "", "name", "", "a", "(Ljava/lang/String;)V", "", "index", "b", "(I)Ljava/lang/String;", "f", "()I", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "e", "paramRegex", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "arguments", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class ParamQuery {

        /* renamed from: a  reason: collision with root package name */
        public String f1480a;
        public final List b = new ArrayList();

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.b.add(str);
        }

        public final String b(int i) {
            return (String) this.b.get(i);
        }

        public final List c() {
            return this.b;
        }

        public final String d() {
            return this.f1480a;
        }

        public final void e(String str) {
            this.f1480a = str;
        }

        public final int f() {
            return this.b.size();
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        String str4 = str;
        this.f1477a = str4;
        this.b = str2;
        this.c = str3;
        if (str4 != null) {
            Uri parse = Uri.parse(str);
            this.h = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!m.matcher(str4).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.h) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str4);
                if (matcher.find()) {
                    String substring = str4.substring(0, matcher.start());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Intrinsics.checkNotNullExpressionValue(compile, "fillInPattern");
                    this.k = c(substring, sb, compile);
                }
                for (String next : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(next);
                    if (queryParameter != null) {
                        Matcher matcher2 = compile.matcher(queryParameter);
                        ParamQuery paramQuery = new ParamQuery();
                        int i2 = 0;
                        while (matcher2.find()) {
                            String group = matcher2.group(1);
                            if (group != null) {
                                paramQuery.a(group);
                                String substring2 = queryParameter.substring(i2, matcher2.start());
                                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                sb2.append(Pattern.quote(substring2));
                                sb2.append("(.+?)?");
                                i2 = matcher2.end();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                        if (i2 < queryParameter.length()) {
                            String substring3 = queryParameter.substring(i2);
                            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                            sb2.append(Pattern.quote(substring3));
                        }
                        String sb3 = sb2.toString();
                        Intrinsics.checkNotNullExpressionValue(sb3, "argRegex.toString()");
                        paramQuery.e(StringsKt.replace$default(sb3, CommonConstants.IS_FLYME_OS_4_MATCH, "\\E.*\\Q", false, 4, (Object) null));
                        Map map = this.e;
                        Intrinsics.checkNotNullExpressionValue(next, "paramName");
                        map.put(next, paramQuery);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(compile, "fillInPattern");
                this.k = c(str4, sb, compile);
            }
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "uriRegex.toString()");
            this.f = StringsKt.replace$default(sb4, CommonConstants.IS_FLYME_OS_4_MATCH, "\\E.*\\Q", false, 4, (Object) null);
        }
        if (this.c == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.c).matches()) {
            MimeType mimeType = new MimeType(this.c);
            this.i = StringsKt.replace$default("^(" + mimeType.f() + "|[*]+)/(" + mimeType.d() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
            return;
        }
        throw new IllegalArgumentException(("The given mimeType " + g() + " does not match to required \"type/subtype\" format").toString());
    }

    public final boolean c(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !StringsKt.contains$default((CharSequence) str, (CharSequence) CommonConstants.IS_FLYME_OS_4_MATCH, false, 2, (Object) null);
        int i2 = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group != null) {
                this.d.add(group);
                String substring = str.substring(i2, matcher.start());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(Pattern.quote(substring));
                sb.append("([^/]+?)");
                i2 = matcher.end();
                z = false;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (i2 < str.length()) {
            String substring2 = str.substring(i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(Pattern.quote(substring2));
        }
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        return z;
    }

    public final String d() {
        return this.b;
    }

    public final List e() {
        List list = this.d;
        Collection<ParamQuery> values = this.e.values();
        ArrayList arrayList = new ArrayList();
        for (ParamQuery c2 : values) {
            CollectionsKt.addAll(arrayList, c2.c());
        }
        return CollectionsKt.plus(list, arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        return Intrinsics.areEqual((Object) this.f1477a, (Object) navDeepLink.f1477a) && Intrinsics.areEqual((Object) this.b, (Object) navDeepLink.b) && Intrinsics.areEqual((Object) this.c, (Object) navDeepLink.c);
    }

    public final Bundle f(Uri uri, Map map) {
        Matcher matcher;
        Intrinsics.checkNotNullParameter(uri, "deepLink");
        Intrinsics.checkNotNullParameter(map, "arguments");
        Pattern j2 = j();
        Matcher matcher2 = j2 == null ? null : j2.matcher(uri.toString());
        if (matcher2 == null || !matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.d.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            String str = (String) this.d.get(i2);
            String decode = Uri.decode(matcher2.group(i3));
            Intrinsics.checkNotNullExpressionValue(decode, AccountConstantKt.RESPONSE_VALUE);
            if (m(bundle, str, decode, (NavArgument) map.get(str))) {
                return null;
            }
            i2 = i3;
        }
        if (this.h) {
            for (String str2 : this.e.keySet()) {
                ParamQuery paramQuery = (ParamQuery) this.e.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    Intrinsics.checkNotNull(paramQuery);
                    matcher = Pattern.compile(paramQuery.d()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                Intrinsics.checkNotNull(paramQuery);
                int f2 = paramQuery.f();
                int i4 = 0;
                while (true) {
                    if (i4 < f2) {
                        int i5 = i4 + 1;
                        String group = matcher != null ? matcher.group(i5) : null;
                        String b2 = paramQuery.b(i4);
                        NavArgument navArgument = (NavArgument) map.get(b2);
                        if (group != null) {
                            if (!Intrinsics.areEqual((Object) group, (Object) '{' + b2 + '}') && m(bundle, b2, group, navArgument)) {
                                return null;
                            }
                        }
                        i4 = i5;
                    }
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            NavArgument navArgument2 = (NavArgument) entry.getValue();
            if (navArgument2 != null && !navArgument2.c() && !navArgument2.b() && !bundle.containsKey(str3)) {
                return null;
            }
        }
        return bundle;
    }

    public final String g() {
        return this.c;
    }

    public final int h(String str) {
        Intrinsics.checkNotNullParameter(str, "mimeType");
        if (this.c != null) {
            Pattern i2 = i();
            Intrinsics.checkNotNull(i2);
            if (i2.matcher(str).matches()) {
                return new MimeType(this.c).compareTo(new MimeType(str));
            }
        }
        return -1;
    }

    public int hashCode() {
        String str = this.f1477a;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final Pattern i() {
        return (Pattern) this.j.getValue();
    }

    public final Pattern j() {
        return (Pattern) this.g.getValue();
    }

    public final String k() {
        return this.f1477a;
    }

    public final boolean l() {
        return this.k;
    }

    public final boolean m(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            try {
                navArgument.a().d(bundle, str, str2);
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
            return false;
        }
    }
}
