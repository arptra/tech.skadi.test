package dagger.hilt.android.internal.managers;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.hilt.codegen.OriginatingElement;

@OriginatingElement(topLevelClass = ActivityRetainedComponentManager.class)
@EntryPoint
@InstallIn({ActivityRetainedComponent.class})
public interface HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint extends ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint {
}
