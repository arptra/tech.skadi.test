package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/navigation/NavViewModelStoreProvider;", "<init>", "()V", "", "backStackEntryId", "", "d", "(Ljava/lang/String;)V", "onCleared", "Landroidx/lifecycle/ViewModelStore;", "a", "(Ljava/lang/String;)Landroidx/lifecycle/ViewModelStore;", "toString", "()Ljava/lang/String;", "", "Ljava/util/Map;", "viewModelStores", "b", "Companion", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
public final class NavControllerViewModel extends ViewModel implements NavViewModelStoreProvider {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final ViewModelProvider.Factory c = new NavControllerViewModel$Companion$FACTORY$1();

    /* renamed from: a  reason: collision with root package name */
    public final Map f1476a = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/navigation/NavControllerViewModel$Companion;", "", "<init>", "()V", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "Landroidx/navigation/NavControllerViewModel;", "a", "(Landroidx/lifecycle/ViewModelStore;)Landroidx/navigation/NavControllerViewModel;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "FACTORY", "Landroidx/lifecycle/ViewModelProvider$Factory;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavControllerViewModel a(ViewModelStore viewModelStore) {
            Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
            ViewModel viewModel = new ViewModelProvider(viewModelStore, NavControllerViewModel.c).get(NavControllerViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "get(VM::class.java)");
            return (NavControllerViewModel) viewModel;
        }

        public Companion() {
        }
    }

    public ViewModelStore a(String str) {
        Intrinsics.checkNotNullParameter(str, "backStackEntryId");
        ViewModelStore viewModelStore = (ViewModelStore) this.f1476a.get(str);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f1476a.put(str, viewModelStore2);
        return viewModelStore2;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "backStackEntryId");
        ViewModelStore viewModelStore = (ViewModelStore) this.f1476a.remove(str);
        if (viewModelStore != null) {
            viewModelStore.clear();
        }
    }

    public void onCleared() {
        for (ViewModelStore clear : this.f1476a.values()) {
            clear.clear();
        }
        this.f1476a.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator it = this.f1476a.keySet().iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
