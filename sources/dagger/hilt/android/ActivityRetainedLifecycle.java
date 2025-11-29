package dagger.hilt.android;

import dagger.hilt.android.lifecycle.RetainedLifecycle;

public interface ActivityRetainedLifecycle extends RetainedLifecycle {

    public interface OnClearedListener extends RetainedLifecycle.OnClearedListener {
    }
}
