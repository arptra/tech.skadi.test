package dagger.hilt.android.internal.managers;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;

@OriginatingElement(topLevelClass = ActivityRetainedComponentManager.class)
@EntryPoint
@InstallIn({SingletonComponent.class})
public interface HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint extends ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint {
}
