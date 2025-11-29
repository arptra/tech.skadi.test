package dagger.hilt.android.internal.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistryOwner;
import com.honey.account.qa.a;
import dagger.Module;
import dagger.hilt.EntryPoint;
import dagger.hilt.EntryPoints;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import dagger.multibindings.Multibinds;
import java.util.Map;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class HiltViewModelFactory implements ViewModelProvider.Factory {
    public static final CreationExtras.Key<Function1<Object, ViewModel>> CREATION_CALLBACK_KEY = new CreationExtras.Key<Function1<Object, ViewModel>>() {
    };
    private final ViewModelProvider.Factory delegateFactory;
    private final ViewModelProvider.Factory hiltViewModelFactory;
    private final Map<Class<?>, Boolean> hiltViewModelKeys;

    @EntryPoint
    @InstallIn({ActivityComponent.class})
    public interface ActivityCreatorEntryPoint {
        ViewModelComponentBuilder getViewModelComponentBuilder();

        @HiltViewModelMap.KeySet
        Map<Class<?>, Boolean> getViewModelKeys();
    }

    @EntryPoint
    @InstallIn({ViewModelComponent.class})
    public interface ViewModelFactoriesEntryPoint {
        @HiltViewModelAssistedMap
        Map<Class<?>, Object> getHiltViewModelAssistedMap();

        @HiltViewModelMap
        Map<Class<?>, Provider<ViewModel>> getHiltViewModelMap();
    }

    @Module
    @InstallIn({ViewModelComponent.class})
    public interface ViewModelModule {
        @HiltViewModelAssistedMap
        @Multibinds
        Map<Class<?>, Object> hiltViewModelAssistedMap();

        @Multibinds
        @HiltViewModelMap
        Map<Class<?>, ViewModel> hiltViewModelMap();
    }

    public HiltViewModelFactory(@NonNull Map<Class<?>, Boolean> map, @NonNull ViewModelProvider.Factory factory, @NonNull final ViewModelComponentBuilder viewModelComponentBuilder) {
        this.hiltViewModelKeys = map;
        this.delegateFactory = factory;
        this.hiltViewModelFactory = new ViewModelProvider.Factory() {
            private <T extends ViewModel> T createViewModel(@NonNull ViewModelComponent viewModelComponent, @NonNull Class<T> cls, @NonNull CreationExtras creationExtras) {
                Class cls2 = ViewModelFactoriesEntryPoint.class;
                Provider provider = ((ViewModelFactoriesEntryPoint) EntryPoints.get(viewModelComponent, cls2)).getHiltViewModelMap().get(cls);
                Function1 function1 = (Function1) creationExtras.a(HiltViewModelFactory.CREATION_CALLBACK_KEY);
                Object obj = ((ViewModelFactoriesEntryPoint) EntryPoints.get(viewModelComponent, cls2)).getHiltViewModelAssistedMap().get(cls);
                if (obj == null) {
                    if (function1 != null) {
                        throw new IllegalStateException("Found creation callback but class " + cls.getName() + " does not have an assisted factory specified in @HiltViewModel.");
                    } else if (provider != null) {
                        return (ViewModel) provider.get();
                    } else {
                        throw new IllegalStateException("Expected the @HiltViewModel-annotated class " + cls.getName() + " to be available in the multi-binding of @HiltViewModelMap but none was found.");
                    }
                } else if (provider != null) {
                    throw new AssertionError("Found the @HiltViewModel-annotated class " + cls.getName() + " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap.");
                } else if (function1 != null) {
                    return (ViewModel) function1.invoke(obj);
                } else {
                    throw new IllegalStateException("Found @HiltViewModel-annotated class " + cls.getName() + " using @AssistedInject but no creation callback was provided in CreationExtras.");
                }
            }

            @NotNull
            public /* bridge */ /* synthetic */ ViewModel create(@NotNull Class cls) {
                return super.create(cls);
            }

            @NonNull
            public <T extends ViewModel> T create(@NonNull Class<T> cls, @NonNull CreationExtras creationExtras) {
                RetainedLifecycleImpl retainedLifecycleImpl = new RetainedLifecycleImpl();
                T createViewModel = createViewModel(viewModelComponentBuilder.savedStateHandle(SavedStateHandleSupport.a(creationExtras)).viewModelLifecycle(retainedLifecycleImpl).build(), cls, creationExtras);
                createViewModel.addCloseable(new a(retainedLifecycleImpl));
                return createViewModel;
            }
        };
    }

    public static ViewModelProvider.Factory createInternal(@NonNull Activity activity, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle, @NonNull ViewModelProvider.Factory factory) {
        return createInternal(activity, factory);
    }

    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls, @NonNull CreationExtras creationExtras) {
        if (this.hiltViewModelKeys.containsKey(cls)) {
            return this.hiltViewModelFactory.create(cls, creationExtras);
        }
        return this.delegateFactory.create(cls, creationExtras);
    }

    public static ViewModelProvider.Factory createInternal(@NonNull Activity activity, @NonNull ViewModelProvider.Factory factory) {
        ActivityCreatorEntryPoint activityCreatorEntryPoint = (ActivityCreatorEntryPoint) EntryPoints.get(activity, ActivityCreatorEntryPoint.class);
        return new HiltViewModelFactory(activityCreatorEntryPoint.getViewModelKeys(), factory, activityCreatorEntryPoint.getViewModelComponentBuilder());
    }

    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        if (this.hiltViewModelKeys.containsKey(cls)) {
            return this.hiltViewModelFactory.create(cls);
        }
        return this.delegateFactory.create(cls);
    }
}
