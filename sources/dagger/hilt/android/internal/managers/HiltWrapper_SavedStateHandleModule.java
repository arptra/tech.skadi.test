package dagger.hilt.android.internal.managers;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;

@OriginatingElement(topLevelClass = SavedStateHandleModule.class)
@InstallIn({ActivityRetainedComponent.class})
@Module
public final class HiltWrapper_SavedStateHandleModule {
}
