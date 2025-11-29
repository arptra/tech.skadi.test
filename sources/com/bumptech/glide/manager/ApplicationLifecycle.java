package com.bumptech.glide.manager;

class ApplicationLifecycle implements Lifecycle {
    public void a(LifecycleListener lifecycleListener) {
    }

    public void b(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
