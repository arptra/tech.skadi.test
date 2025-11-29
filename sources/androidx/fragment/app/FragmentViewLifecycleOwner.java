package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {

    /* renamed from: a  reason: collision with root package name */
    public final Fragment f1314a;
    public final ViewModelStore b;
    public final Runnable c;
    public ViewModelProvider.Factory d;
    public LifecycleRegistry e = null;
    public SavedStateRegistryController f = null;

    public FragmentViewLifecycleOwner(Fragment fragment, ViewModelStore viewModelStore, Runnable runnable) {
        this.f1314a = fragment;
        this.b = viewModelStore;
        this.c = runnable;
    }

    public void a(Lifecycle.Event event) {
        this.e.i(event);
    }

    public void b() {
        if (this.e == null) {
            this.e = new LifecycleRegistry(this);
            SavedStateRegistryController a2 = SavedStateRegistryController.a(this);
            this.f = a2;
            a2.c();
            this.c.run();
        }
    }

    public boolean c() {
        return this.e != null;
    }

    public void d(Bundle bundle) {
        this.f.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f.e(bundle);
    }

    public void f(Lifecycle.State state) {
        this.e.n(state);
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f1314a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.h, application);
        }
        mutableCreationExtras.c(SavedStateHandleSupport.f1384a, this.f1314a);
        mutableCreationExtras.c(SavedStateHandleSupport.b, this);
        if (this.f1314a.getArguments() != null) {
            mutableCreationExtras.c(SavedStateHandleSupport.c, this.f1314a.getArguments());
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.f1314a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f1314a.mDefaultFactory)) {
            this.d = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.d == null) {
            Context applicationContext = this.f1314a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            Fragment fragment = this.f1314a;
            this.d = new SavedStateViewModelFactory(application, fragment, fragment.getArguments());
        }
        return this.d;
    }

    public Lifecycle getLifecycle() {
        b();
        return this.e;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f.b();
    }

    public ViewModelStore getViewModelStore() {
        b();
        return this.b;
    }
}
