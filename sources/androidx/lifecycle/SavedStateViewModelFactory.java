package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.upuphone.runasone.relay.api.IntentKey;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00028\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0011\u001a\u00028\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroid/app/Application;", "application", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "Landroid/os/Bundle;", "defaultArgs", "<init>", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "create", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "", "key", "b", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "viewModel", "", "a", "(Landroidx/lifecycle/ViewModel;)V", "Landroid/app/Application;", "c", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "d", "Landroid/os/Bundle;", "Landroidx/lifecycle/Lifecycle;", "e", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/savedstate/SavedStateRegistry;", "f", "Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    public Application b;
    public final ViewModelProvider.Factory c;
    public Bundle d;
    public Lifecycle e;
    public SavedStateRegistry f;

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        this.f = savedStateRegistryOwner.getSavedStateRegistry();
        this.e = savedStateRegistryOwner.getLifecycle();
        this.d = bundle;
        this.b = application;
        this.c = application != null ? ViewModelProvider.AndroidViewModelFactory.f.b(application) : new ViewModelProvider.AndroidViewModelFactory();
    }

    public void a(ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (this.e != null) {
            SavedStateRegistry savedStateRegistry = this.f;
            Intrinsics.checkNotNull(savedStateRegistry);
            Lifecycle lifecycle = this.e;
            Intrinsics.checkNotNull(lifecycle);
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry, lifecycle);
        }
    }

    public final ViewModel b(String str, Class cls) {
        ViewModel viewModel;
        Application application;
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Lifecycle lifecycle = this.e;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            Constructor c2 = (!isAssignableFrom || this.b == null) ? SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.b) : SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.f1387a);
            if (c2 == null) {
                return this.b != null ? this.c.create(cls) : ViewModelProvider.NewInstanceFactory.b.a().create(cls);
            }
            SavedStateRegistry savedStateRegistry = this.f;
            Intrinsics.checkNotNull(savedStateRegistry);
            SavedStateHandleController b2 = LegacySavedStateHandleController.b(savedStateRegistry, lifecycle, str, this.d);
            if (!isAssignableFrom || (application = this.b) == null) {
                viewModel = SavedStateViewModelFactoryKt.d(cls, c2, b2.b());
            } else {
                Intrinsics.checkNotNull(application);
                viewModel = SavedStateViewModelFactoryKt.d(cls, c2, application, b2.b());
            }
            viewModel.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", b2);
            return viewModel;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    public ViewModel create(Class cls, CreationExtras creationExtras) {
        Constructor constructor;
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(creationExtras, "extras");
        String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (creationExtras.a(SavedStateHandleSupport.f1384a) != null && creationExtras.a(SavedStateHandleSupport.b) != null) {
            Application application = (Application) creationExtras.a(ViewModelProvider.AndroidViewModelFactory.h);
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application == null) {
                constructor = SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.b);
            } else {
                constructor = SavedStateViewModelFactoryKt.c(cls, SavedStateViewModelFactoryKt.f1387a);
            }
            if (constructor == null) {
                return this.c.create(cls, creationExtras);
            }
            if (!isAssignableFrom || application == null) {
                return SavedStateViewModelFactoryKt.d(cls, constructor, SavedStateHandleSupport.a(creationExtras));
            }
            return SavedStateViewModelFactoryKt.d(cls, constructor, application, SavedStateHandleSupport.a(creationExtras));
        } else if (this.e != null) {
            return b(str, cls);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public ViewModel create(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
