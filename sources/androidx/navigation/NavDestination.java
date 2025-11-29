package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDeepLink;
import androidx.navigation.common.R;
import com.honey.account.view.web.WebJs;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\b\b\u0016\u0018\u0000 c2\u00020\u0001:\u0003efgB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0017¢\u0006\u0004\b \u0010!J\u0019\u0010%\u001a\u0004\u0018\u00010$2\b\b\u0001\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\r2\b\b\u0001\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020$¢\u0006\u0004\b)\u0010*J\u001d\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u001b\u00102\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u001f2\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\"H\u0016¢\u0006\u0004\b9\u0010:R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b.\u0010;\u001a\u0004\b<\u00105R.\u0010D\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010=8\u0006@GX\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010;R$\u0010L\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00120M8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010NR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020$0P8\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,0T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR,\u0010#\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\"8G@FX\u000e¢\u0006\u0012\n\u0004\b%\u0010X\u001a\u0004\bY\u0010:\"\u0004\bZ\u0010[R.\u0010\\\u001a\u0004\u0018\u00010\u00022\b\u0010\\\u001a\u0004\u0018\u00010\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b]\u0010;\u001a\u0004\b^\u00105\"\u0004\b_\u0010\u0005R\u001d\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,0`8F¢\u0006\u0006\u001a\u0004\b]\u0010aR\u0014\u0010d\u001a\u00020\u00028WX\u0004¢\u0006\u0006\u001a\u0004\bc\u00105¨\u0006h"}, d2 = {"Landroidx/navigation/NavDestination;", "", "", "navigatorName", "<init>", "(Ljava/lang/String;)V", "Landroidx/navigation/Navigator;", "navigator", "(Landroidx/navigation/Navigator;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "q", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "uriPattern", "c", "Landroidx/navigation/NavDeepLink;", "navDeepLink", "b", "(Landroidx/navigation/NavDeepLink;)V", "Landroidx/navigation/NavDeepLinkRequest;", "navDeepLinkRequest", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "p", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "previousDestination", "", "e", "(Landroidx/navigation/NavDestination;)[I", "", "w", "()Z", "", "id", "Landroidx/navigation/NavAction;", "h", "(I)Landroidx/navigation/NavAction;", "actionId", "action", "r", "(ILandroidx/navigation/NavAction;)V", "argumentName", "Landroidx/navigation/NavArgument;", "argument", "a", "(Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "Landroid/os/Bundle;", "args", "d", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "m", "Landroidx/navigation/NavGraph;", "<set-?>", "Landroidx/navigation/NavGraph;", "n", "()Landroidx/navigation/NavGraph;", "u", "(Landroidx/navigation/NavGraph;)V", "parent", "idName", "", "Ljava/lang/CharSequence;", "l", "()Ljava/lang/CharSequence;", "t", "(Ljava/lang/CharSequence;)V", "label", "", "Ljava/util/List;", "deepLinks", "Landroidx/collection/SparseArrayCompat;", "f", "Landroidx/collection/SparseArrayCompat;", "actions", "", "g", "Ljava/util/Map;", "_arguments", "I", "k", "s", "(I)V", "route", "i", "o", "v", "", "()Ljava/util/Map;", "arguments", "j", "displayName", "ClassType", "Companion", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public class NavDestination {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public static final Map k = new LinkedHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f1485a;
    public NavGraph b;
    public String c;
    public CharSequence d;
    public final List e;
    public final SparseArrayCompat f;
    public Map g;
    public int h;
    public String i;

    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(AnnotationRetention.BINARY)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "Lkotlin/reflect/KClass;", "value", "<init>", "(Lkotlin/reflect/KClass;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    @java.lang.annotation.Retention(RetentionPolicy.CLASS)
    public @interface ClassType {
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000f*\u00020\u000e8FX\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "id", "", "b", "(Landroid/content/Context;I)Ljava/lang/String;", "route", "a", "(Ljava/lang/String;)Ljava/lang/String;", "Landroidx/navigation/NavDestination;", "Lkotlin/sequences/Sequence;", "c", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "hierarchy", "", "Ljava/lang/Class;", "classes", "Ljava/util/Map;", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            return str != null ? Intrinsics.stringPlus("android-app://androidx.navigation/", str) : "";
        }

        public final String b(Context context, int i) {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            try {
                str = context.getResources().getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                str = String.valueOf(i);
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n                co….toString()\n            }");
            return str;
        }

        public final Sequence c(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt.generateSequence(navDestination, NavDestination$Companion$hierarchy$1.INSTANCE);
        }

        public Companion() {
        }
    }

    @RestrictTo
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "matchingArgs", "", "isExactDeepLink", "hasMatchingAction", "", "mimeTypeMatchLevel", "<init>", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZZI)V", "other", "a", "(Landroidx/navigation/NavDestination$DeepLinkMatch;)I", "Landroidx/navigation/NavDestination;", "d", "()Landroidx/navigation/NavDestination;", "b", "Landroid/os/Bundle;", "f", "()Landroid/os/Bundle;", "c", "Z", "e", "I", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {

        /* renamed from: a  reason: collision with root package name */
        public final NavDestination f1486a;
        public final Bundle b;
        public final boolean c;
        public final boolean d;
        public final int e;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, boolean z2, int i) {
            Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
            this.f1486a = navDestination;
            this.b = bundle;
            this.c = z;
            this.d = z2;
            this.e = i;
        }

        /* renamed from: a */
        public int compareTo(DeepLinkMatch deepLinkMatch) {
            Intrinsics.checkNotNullParameter(deepLinkMatch, "other");
            boolean z = this.c;
            if (z && !deepLinkMatch.c) {
                return 1;
            }
            if (!z && deepLinkMatch.c) {
                return -1;
            }
            Bundle bundle = this.b;
            if (bundle != null && deepLinkMatch.b == null) {
                return 1;
            }
            if (bundle == null && deepLinkMatch.b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = deepLinkMatch.b;
                Intrinsics.checkNotNull(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z2 = this.d;
            if (z2 && !deepLinkMatch.d) {
                return 1;
            }
            if (z2 || !deepLinkMatch.d) {
                return this.e - deepLinkMatch.e;
            }
            return -1;
        }

        public final NavDestination d() {
            return this.f1486a;
        }

        public final Bundle f() {
            return this.b;
        }
    }

    public NavDestination(String str) {
        Intrinsics.checkNotNullParameter(str, "navigatorName");
        this.f1485a = str;
        this.e = new ArrayList();
        this.f = new SparseArrayCompat();
        this.g = new LinkedHashMap();
    }

    public static /* synthetic */ int[] f(NavDestination navDestination, NavDestination navDestination2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                navDestination2 = null;
            }
            return navDestination.e(navDestination2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
    }

    public final void a(String str, NavArgument navArgument) {
        Intrinsics.checkNotNullParameter(str, "argumentName");
        Intrinsics.checkNotNullParameter(navArgument, "argument");
        this.g.put(str, navArgument);
    }

    public final void b(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        Map i2 = i();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : i2.entrySet()) {
            NavArgument navArgument = (NavArgument) entry.getValue();
            if (!navArgument.c() && !navArgument.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object next : keySet) {
            if (!navDeepLink.e().contains((String) next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            this.e.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.k() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + arrayList).toString());
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "uriPattern");
        b(new NavDeepLink.Builder().d(str).a());
    }

    public final Bundle d(Bundle bundle) {
        Map map;
        if (bundle == null && ((map = this.g) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.g.entrySet()) {
            ((NavArgument) entry.getValue()).d((String) entry.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry entry2 : this.g.entrySet()) {
                String str = (String) entry2.getKey();
                NavArgument navArgument = (NavArgument) entry2.getValue();
                if (!navArgument.e(str, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + str + "' in argument bundle. " + navArgument.a().b() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    public final int[] e(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            Intrinsics.checkNotNull(this);
            NavGraph navGraph = this.b;
            if ((navDestination == null ? null : navDestination.b) != null) {
                NavGraph navGraph2 = navDestination.b;
                Intrinsics.checkNotNull(navGraph2);
                if (navGraph2.y(this.h) == this) {
                    arrayDeque.addFirst(this);
                    break;
                }
            }
            if (navGraph == null || navGraph.E() != this.h) {
                arrayDeque.addFirst(this);
            }
            if (Intrinsics.areEqual((Object) navGraph, (Object) navDestination) || navGraph == null) {
                break;
            }
            this = navGraph;
        }
        List<NavDestination> list = CollectionsKt.toList(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (NavDestination k2 : list) {
            arrayList.add(Integer.valueOf(k2.k()));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == null || !(obj instanceof NavDestination)) {
            return false;
        }
        NavDestination navDestination = (NavDestination) obj;
        boolean z3 = CollectionsKt.intersect(this.e, navDestination.e).size() == this.e.size();
        if (this.f.p() == navDestination.f.p()) {
            Iterator it = SequencesKt.asSequence(SparseArrayKt.a(this.f)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    Iterator it2 = SequencesKt.asSequence(SparseArrayKt.a(navDestination.f)).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = true;
                            break;
                        }
                        if (!this.f.e((NavAction) it2.next())) {
                            break;
                        }
                    }
                } else {
                    if (!navDestination.f.e((NavAction) it.next())) {
                        break;
                    }
                }
            }
        } else {
            z = false;
        }
        if (i().size() == navDestination.i().size()) {
            Iterator it3 = MapsKt.asSequence(i()).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    Iterator it4 = MapsKt.asSequence(navDestination.i()).iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            z2 = true;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it4.next();
                        if (i().containsKey(entry.getKey())) {
                            if (!Intrinsics.areEqual(i().get(entry.getKey()), entry.getValue())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    Map.Entry entry2 = (Map.Entry) it3.next();
                    if (navDestination.i().containsKey(entry2.getKey())) {
                        if (!Intrinsics.areEqual(navDestination.i().get(entry2.getKey()), entry2.getValue())) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            return (this.h == navDestination.h || Intrinsics.areEqual((Object) this.i, (Object) navDestination.i)) ? false : false;
        }
        z2 = false;
        return (this.h == navDestination.h || Intrinsics.areEqual((Object) this.i, (Object) navDestination.i)) ? false : false;
    }

    public final NavAction h(int i2) {
        NavAction navAction = this.f.k() ? null : (NavAction) this.f.g(i2);
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.b;
        if (navGraph == null) {
            return null;
        }
        return navGraph.h(i2);
    }

    public int hashCode() {
        int i2;
        Set<String> keySet;
        int i3 = this.h * 31;
        String str = this.i;
        int hashCode = i3 + (str == null ? 0 : str.hashCode());
        for (NavDeepLink navDeepLink : this.e) {
            int i4 = i2 * 31;
            String k2 = navDeepLink.k();
            int hashCode2 = (i4 + (k2 == null ? 0 : k2.hashCode())) * 31;
            String d2 = navDeepLink.d();
            int hashCode3 = (hashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
            String g2 = navDeepLink.g();
            hashCode = hashCode3 + (g2 == null ? 0 : g2.hashCode());
        }
        Iterator a2 = SparseArrayKt.a(this.f);
        while (a2.hasNext()) {
            NavAction navAction = (NavAction) a2.next();
            int b2 = ((i2 * 31) + navAction.b()) * 31;
            NavOptions c2 = navAction.c();
            i2 = b2 + (c2 == null ? 0 : c2.hashCode());
            Bundle a3 = navAction.a();
            if (!(a3 == null || (keySet = a3.keySet()) == null)) {
                for (String str2 : keySet) {
                    int i5 = i2 * 31;
                    Bundle a4 = navAction.a();
                    Intrinsics.checkNotNull(a4);
                    Object obj = a4.get(str2);
                    i2 = i5 + (obj == null ? 0 : obj.hashCode());
                }
            }
        }
        for (String str3 : i().keySet()) {
            int hashCode4 = ((i2 * 31) + str3.hashCode()) * 31;
            Object obj2 = i().get(str3);
            i2 = hashCode4 + (obj2 == null ? 0 : obj2.hashCode());
        }
        return i2;
    }

    public final Map i() {
        return MapsKt.toMap(this.g);
    }

    public String j() {
        String str = this.c;
        return str == null ? String.valueOf(this.h) : str;
    }

    public final int k() {
        return this.h;
    }

    public final CharSequence l() {
        return this.d;
    }

    public final String m() {
        return this.f1485a;
    }

    public final NavGraph n() {
        return this.b;
    }

    public final String o() {
        return this.i;
    }

    public DeepLinkMatch p(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.e.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink navDeepLink : this.e) {
            Uri c2 = navDeepLinkRequest.c();
            Bundle f2 = c2 != null ? navDeepLink.f(c2, i()) : null;
            String a2 = navDeepLinkRequest.a();
            boolean z = a2 != null && Intrinsics.areEqual((Object) a2, (Object) navDeepLink.d());
            String b2 = navDeepLinkRequest.b();
            int h2 = b2 != null ? navDeepLink.h(b2) : -1;
            if (f2 != null || z || h2 > -1) {
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, f2, navDeepLink.l(), z, h2);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    public void q(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        v(obtainAttributes.getString(R.styleable.Navigator_route));
        if (obtainAttributes.hasValue(R.styleable.Navigator_android_id)) {
            s(obtainAttributes.getResourceId(R.styleable.Navigator_android_id, 0));
            this.c = j.b(context, k());
        }
        t(obtainAttributes.getText(R.styleable.Navigator_android_label));
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    public final void r(int i2, NavAction navAction) {
        Intrinsics.checkNotNullParameter(navAction, WebJs.ACTION);
        if (!w()) {
            throw new UnsupportedOperationException("Cannot add action " + i2 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (i2 != 0) {
            this.f.m(i2, navAction);
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
        }
    }

    public final void s(int i2) {
        this.h = i2;
        this.c = null;
    }

    public final void t(CharSequence charSequence) {
        this.d = charSequence;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.c;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.h));
        } else {
            sb.append(str);
        }
        sb.append(")");
        String str2 = this.i;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            sb.append(" route=");
            sb.append(this.i);
        }
        if (this.d != null) {
            sb.append(" label=");
            sb.append(this.d);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public final void u(NavGraph navGraph) {
        this.b = navGraph;
    }

    public final void v(String str) {
        Object obj;
        if (str == null) {
            s(0);
        } else if (!StringsKt.isBlank(str)) {
            String a2 = j.a(str);
            s(a2.hashCode());
            c(a2);
        } else {
            throw new IllegalArgumentException("Cannot have an empty route".toString());
        }
        List list = this.e;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((NavDeepLink) obj).k(), (Object) j.a(this.i))) {
                break;
            }
        }
        list.remove(obj);
        this.i = str;
    }

    public boolean w() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDestination(Navigator navigator) {
        this(NavigatorProvider.b.a(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }
}
