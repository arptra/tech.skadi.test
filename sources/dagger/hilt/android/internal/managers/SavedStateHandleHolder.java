package dagger.hilt.android.internal.managers;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import dagger.hilt.android.internal.ThreadUtil;
import dagger.hilt.internal.Preconditions;

public final class SavedStateHandleHolder {
    private CreationExtras extras;
    private SavedStateHandle handle;
    private final boolean nonComponentActivity;

    public SavedStateHandleHolder(@Nullable CreationExtras creationExtras) {
        this.nonComponentActivity = creationExtras == null;
        this.extras = creationExtras;
    }

    public void clear() {
        this.extras = null;
    }

    public SavedStateHandle getSavedStateHandle() {
        ThreadUtil.ensureMainThread();
        Preconditions.checkState(!this.nonComponentActivity, "Activity that does not extend ComponentActivity cannot use SavedStateHandle", new Object[0]);
        SavedStateHandle savedStateHandle = this.handle;
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        Preconditions.checkNotNull(this.extras, "The first access to SavedStateHandle should happen between super.onCreate() and super.onDestroy()");
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.extras);
        mutableCreationExtras.c(SavedStateHandleSupport.c, Bundle.EMPTY);
        this.extras = mutableCreationExtras;
        SavedStateHandle a2 = SavedStateHandleSupport.a(mutableCreationExtras);
        this.handle = a2;
        this.extras = null;
        return a2;
    }

    public boolean isInvalid() {
        return this.handle == null && this.extras == null;
    }

    public void setExtras(CreationExtras creationExtras) {
        if (this.handle == null) {
            this.extras = creationExtras;
        }
    }
}
