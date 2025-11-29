package com.upuphone.xr.sapp;

import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

public abstract class Hilt_MainApplication extends BaseApplication implements GeneratedComponentManagerHolder {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6592a = false;
    public final ApplicationComponentManager b = new ApplicationComponentManager(new ComponentSupplier() {
        public Object get() {
            return DaggerMainApplication_HiltComponents_SingletonC.a().a(new ApplicationContextModule(Hilt_MainApplication.this)).b();
        }
    });

    /* renamed from: a */
    public final ApplicationComponentManager componentManager() {
        return this.b;
    }

    public void b() {
        if (!this.f6592a) {
            this.f6592a = true;
            ((MainApplication_GeneratedInjector) generatedComponent()).injectMainApplication((MainApplication) UnsafeCasts.unsafeCast(this));
        }
    }

    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    public void onCreate() {
        b();
        super.onCreate();
    }
}
