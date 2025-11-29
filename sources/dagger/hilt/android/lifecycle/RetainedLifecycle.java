package dagger.hilt.android.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public interface RetainedLifecycle {

    public interface OnClearedListener {
        void onCleared();
    }

    @MainThread
    void addOnClearedListener(@NonNull OnClearedListener onClearedListener);

    @MainThread
    void removeOnClearedListener(@NonNull OnClearedListener onClearedListener);
}
