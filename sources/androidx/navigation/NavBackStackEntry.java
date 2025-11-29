package androidx.navigation;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.upuphone.runasone.relay.api.IntentKey;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003\\]^BS\b\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013B\u001d\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0000\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\tH\u0007¢\u0006\u0004\b*\u0010+J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010@R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b8\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010=R\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010NR\u001b\u0010S\u001a\u00020P8BX\u0002¢\u0006\f\n\u0004\b*\u0010Q\u001a\u0004\bA\u0010RR\u001b\u0010V\u001a\u00020T8FX\u0002¢\u0006\f\n\u0004\b:\u0010Q\u001a\u0004\bK\u0010UR*\u0010[\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b8G@GX\u000e¢\u0006\u0012\n\u0004\bX\u0010@\u001a\u0004\bG\u0010Y\"\u0004\bX\u0010Z¨\u0006_"}, d2 = {"Landroidx/navigation/NavBackStackEntry;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroid/content/Context;", "context", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/navigation/NavViewModelStoreProvider;", "viewModelStoreProvider", "", "id", "savedState", "<init>", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/NavViewModelStoreProvider;Ljava/lang/String;Landroid/os/Bundle;)V", "entry", "(Landroidx/navigation/NavBackStackEntry;Landroid/os/Bundle;)V", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "j", "(Landroidx/lifecycle/Lifecycle$Event;)V", "n", "()V", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "outBundle", "k", "(Landroid/os/Bundle;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "a", "Landroid/content/Context;", "b", "Landroidx/navigation/NavDestination;", "f", "()Landroidx/navigation/NavDestination;", "l", "(Landroidx/navigation/NavDestination;)V", "c", "Landroid/os/Bundle;", "d", "()Landroid/os/Bundle;", "Landroidx/lifecycle/Lifecycle$State;", "e", "Landroidx/navigation/NavViewModelStoreProvider;", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "Landroidx/lifecycle/LifecycleRegistry;", "h", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/savedstate/SavedStateRegistryController;", "i", "Landroidx/savedstate/SavedStateRegistryController;", "savedStateRegistryController", "Z", "savedStateRegistryRestored", "Landroidx/lifecycle/SavedStateViewModelFactory;", "Lkotlin/Lazy;", "()Landroidx/lifecycle/SavedStateViewModelFactory;", "defaultFactory", "Landroidx/lifecycle/SavedStateHandle;", "()Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "maxState", "m", "()Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/Lifecycle$State;)V", "maxLifecycle", "Companion", "NavResultSavedStateFactory", "SavedStateViewModel", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f1472a;
    public NavDestination b;
    public final Bundle c;
    public Lifecycle.State d;
    public final NavViewModelStoreProvider e;
    public final String f;
    public final Bundle g;
    public LifecycleRegistry h;
    public final SavedStateRegistryController i;
    public boolean j;
    public final Lazy k;
    public final Lazy l;
    public Lifecycle.State m;

    @RestrictTo
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0012\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavBackStackEntry$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/navigation/NavViewModelStoreProvider;", "viewModelStoreProvider", "", "id", "savedState", "Landroidx/navigation/NavBackStackEntry;", "a", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/NavViewModelStoreProvider;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry b(Companion companion, Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, int i, Object obj) {
            String str2;
            Bundle bundle3 = (i & 4) != 0 ? null : bundle;
            Lifecycle.State state2 = (i & 8) != 0 ? Lifecycle.State.CREATED : state;
            NavViewModelStoreProvider navViewModelStoreProvider2 = (i & 16) != 0 ? null : navViewModelStoreProvider;
            if ((i & 32) != 0) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
                str2 = uuid;
            } else {
                str2 = str;
            }
            return companion.a(context, navDestination, bundle3, state2, navViewModelStoreProvider2, str2, (i & 64) != 0 ? null : bundle2);
        }

        public final NavBackStackEntry a(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2) {
            Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
            Intrinsics.checkNotNullParameter(state, "hostLifecycleState");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "id");
            return new NavBackStackEntry(context, navDestination, bundle, state, navViewModelStoreProvider, str2, bundle2, (DefaultConstructorMarker) null);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/navigation/NavBackStackEntry$NavResultSavedStateFactory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "Landroid/os/Bundle;", "defaultArgs", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "Landroidx/lifecycle/ViewModel;", "T", "", "key", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/SavedStateHandle;", "handle", "c", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NavResultSavedStateFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        }

        public ViewModel c(String str, Class cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
            return new SavedStateViewModel(savedStateHandle);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/navigation/NavBackStackEntry$SavedStateViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/SavedStateHandle;", "handle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "a", "Landroidx/lifecycle/SavedStateHandle;", "c", "()Landroidx/lifecycle/SavedStateHandle;", "navigation-common_release"}, k = 1, mv = {1, 6, 0})
    public static final class SavedStateViewModel extends ViewModel {

        /* renamed from: a  reason: collision with root package name */
        public final SavedStateHandle f1473a;

        public SavedStateViewModel(@NotNull SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
            this.f1473a = savedStateHandle;
        }

        public final SavedStateHandle c() {
            return this.f1473a;
        }
    }

    public /* synthetic */ NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, navDestination, bundle, state, navViewModelStoreProvider, str, bundle2);
    }

    public final Bundle d() {
        return this.c;
    }

    public final SavedStateViewModelFactory e() {
        return (SavedStateViewModelFactory) this.k.getValue();
    }

    public boolean equals(Object obj) {
        Set<String> keySet;
        if (obj == null || !(obj instanceof NavBackStackEntry)) {
            return false;
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (!Intrinsics.areEqual((Object) this.f, (Object) navBackStackEntry.f) || !Intrinsics.areEqual((Object) this.b, (Object) navBackStackEntry.b) || !Intrinsics.areEqual((Object) this.h, (Object) navBackStackEntry.h) || !Intrinsics.areEqual((Object) getSavedStateRegistry(), (Object) navBackStackEntry.getSavedStateRegistry())) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.c, (Object) navBackStackEntry.c)) {
            Bundle bundle = this.c;
            if (bundle == null || (keySet = bundle.keySet()) == null) {
                return false;
            }
            if (!keySet.isEmpty()) {
                for (String str : keySet) {
                    Object obj2 = d().get(str);
                    Bundle d2 = navBackStackEntry.d();
                    if (!Intrinsics.areEqual(obj2, d2 == null ? null : d2.get(str))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final NavDestination f() {
        return this.b;
    }

    public final String g() {
        return this.f;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return e();
    }

    public Lifecycle getLifecycle() {
        return this.h;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        SavedStateRegistry b2 = this.i.b();
        Intrinsics.checkNotNullExpressionValue(b2, "savedStateRegistryController.savedStateRegistry");
        return b2;
    }

    public ViewModelStore getViewModelStore() {
        if (!this.j) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        } else if (this.h.b() != Lifecycle.State.DESTROYED) {
            NavViewModelStoreProvider navViewModelStoreProvider = this.e;
            if (navViewModelStoreProvider != null) {
                return navViewModelStoreProvider.a(this.f);
            }
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
        } else {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
    }

    public final Lifecycle.State h() {
        return this.m;
    }

    public int hashCode() {
        Set<String> keySet;
        int hashCode = (this.f.hashCode() * 31) + this.b.hashCode();
        Bundle bundle = this.c;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i2 = hashCode * 31;
                Object obj = d().get(str);
                hashCode = i2 + (obj == null ? 0 : obj.hashCode());
            }
        }
        return (((hashCode * 31) + this.h.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final SavedStateHandle i() {
        return (SavedStateHandle) this.l.getValue();
    }

    public final void j(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.checkNotNullExpressionValue(targetState, "event.targetState");
        this.d = targetState;
        n();
    }

    public final void k(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outBundle");
        this.i.e(bundle);
    }

    public final void l(NavDestination navDestination) {
        Intrinsics.checkNotNullParameter(navDestination, "<set-?>");
        this.b = navDestination;
    }

    public final void m(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "maxState");
        this.m = state;
        n();
    }

    public final void n() {
        if (!this.j) {
            this.i.d(this.g);
            this.j = true;
        }
        if (this.d.ordinal() < this.m.ordinal()) {
            this.h.n(this.d);
        } else {
            this.h.n(this.m);
        }
    }

    public NavBackStackEntry(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavViewModelStoreProvider navViewModelStoreProvider, String str, Bundle bundle2) {
        this.f1472a = context;
        this.b = navDestination;
        this.c = bundle;
        this.d = state;
        this.e = navViewModelStoreProvider;
        this.f = str;
        this.g = bundle2;
        this.h = new LifecycleRegistry(this);
        SavedStateRegistryController a2 = SavedStateRegistryController.a(this);
        Intrinsics.checkNotNullExpressionValue(a2, "create(this)");
        this.i = a2;
        this.k = LazyKt.lazy(new NavBackStackEntry$defaultFactory$2(this));
        this.l = LazyKt.lazy(new NavBackStackEntry$savedStateHandle$2(this));
        this.m = Lifecycle.State.INITIALIZED;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavBackStackEntry(NavBackStackEntry navBackStackEntry, Bundle bundle) {
        this(navBackStackEntry.f1472a, navBackStackEntry.b, bundle, navBackStackEntry.d, navBackStackEntry.e, navBackStackEntry.f, navBackStackEntry.g);
        Intrinsics.checkNotNullParameter(navBackStackEntry, "entry");
        this.d = navBackStackEntry.d;
        m(navBackStackEntry.m);
    }
}
