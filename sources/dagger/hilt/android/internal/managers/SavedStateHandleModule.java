package dagger.hilt.android.internal.managers;

import androidx.annotation.OptIn;
import androidx.lifecycle.SavedStateHandle;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.lifecycle.ActivityRetainedSavedState;
import dagger.hilt.android.scopes.ActivityRetainedScoped;

@InstallIn({ActivityRetainedComponent.class})
@Module
abstract class SavedStateHandleModule {
    @ActivityRetainedScoped
    @OptIn
    @ActivityRetainedSavedState
    @Provides
    public static SavedStateHandle provideSavedStateHandle(SavedStateHandleHolder savedStateHandleHolder) {
        return savedStateHandleHolder.getSavedStateHandle();
    }
}
