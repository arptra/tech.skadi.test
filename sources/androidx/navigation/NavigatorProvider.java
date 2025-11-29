package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.navigation.Navigator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\b\u0017\u0018\u0000 \f2\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00028\u0000\"\f\b\u0000\u0010\u0005*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004H\u0017¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00040\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R%\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u00040\u00148G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavigatorProvider;", "", "<init>", "()V", "Landroidx/navigation/Navigator;", "T", "", "name", "d", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigator", "b", "(Landroidx/navigation/Navigator;)Landroidx/navigation/Navigator;", "c", "(Ljava/lang/String;Landroidx/navigation/Navigator;)Landroidx/navigation/Navigator;", "", "a", "Ljava/util/Map;", "_navigators", "", "e", "()Ljava/util/Map;", "navigators", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final Map c = new LinkedHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final Map f1495a = new LinkedHashMap();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\tH\u0001¢\u0006\u0004\b\f\u0010\rR&\u0010\u000f\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/navigation/NavigatorProvider$Companion;", "", "<init>", "()V", "", "name", "", "b", "(Ljava/lang/String;)Z", "Ljava/lang/Class;", "Landroidx/navigation/Navigator;", "navigatorClass", "a", "(Ljava/lang/Class;)Ljava/lang/String;", "", "annotationNames", "Ljava/util/Map;", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Class cls) {
            Intrinsics.checkNotNullParameter(cls, "navigatorClass");
            String str = (String) NavigatorProvider.c.get(cls);
            if (str == null) {
                Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
                str = name == null ? null : name.value();
                if (b(str)) {
                    NavigatorProvider.c.put(cls, str);
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("No @Navigator.Name annotation found for ", cls.getSimpleName()).toString());
                }
            }
            Intrinsics.checkNotNull(str);
            return str;
        }

        public final boolean b(String str) {
            return str != null && str.length() > 0;
        }

        public Companion() {
        }
    }

    public final Navigator b(Navigator navigator) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        return c(b.a(navigator.getClass()), navigator);
    }

    public Navigator c(String str, Navigator navigator) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        if (b.b(str)) {
            Navigator navigator2 = (Navigator) this.f1495a.get(str);
            if (Intrinsics.areEqual((Object) navigator2, (Object) navigator)) {
                return navigator;
            }
            boolean z = false;
            if (navigator2 != null && navigator2.c()) {
                z = true;
            }
            if (!(!z)) {
                throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
            } else if (!navigator.c()) {
                return (Navigator) this.f1495a.put(str, navigator);
            } else {
                throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
            }
        } else {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
    }

    public Navigator d(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (b.b(str)) {
            Navigator navigator = (Navigator) this.f1495a.get(str);
            if (navigator != null) {
                return navigator;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }

    public final Map e() {
        return MapsKt.toMap(this.f1495a);
    }
}
