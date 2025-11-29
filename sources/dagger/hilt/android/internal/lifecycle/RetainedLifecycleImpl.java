package dagger.hilt.android.internal.lifecycle;

import androidx.annotation.NonNull;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.ThreadUtil;
import dagger.hilt.android.lifecycle.RetainedLifecycle;
import java.util.HashSet;
import java.util.Set;

public final class RetainedLifecycleImpl implements ActivityRetainedLifecycle, ViewModelLifecycle {
    private final Set<RetainedLifecycle.OnClearedListener> listeners = new HashSet();
    private boolean onClearedDispatched = false;

    private void throwIfOnClearedDispatched() {
        if (this.onClearedDispatched) {
            throw new IllegalStateException("There was a race between the call to add/remove an OnClearedListener and onCleared(). This can happen when posting to the Main thread from a background thread, which is not supported.");
        }
    }

    public void addOnClearedListener(@NonNull RetainedLifecycle.OnClearedListener onClearedListener) {
        ThreadUtil.ensureMainThread();
        throwIfOnClearedDispatched();
        this.listeners.add(onClearedListener);
    }

    public void dispatchOnCleared() {
        ThreadUtil.ensureMainThread();
        this.onClearedDispatched = true;
        for (RetainedLifecycle.OnClearedListener onCleared : this.listeners) {
            onCleared.onCleared();
        }
    }

    public void removeOnClearedListener(@NonNull RetainedLifecycle.OnClearedListener onClearedListener) {
        ThreadUtil.ensureMainThread();
        throwIfOnClearedDispatched();
        this.listeners.remove(onClearedListener);
    }
}
