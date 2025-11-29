package dagger.hilt.android.internal.lifecycle;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.codegen.OriginatingElement;

@OriginatingElement(topLevelClass = HiltViewModelFactory.class)
@EntryPoint
@InstallIn({ActivityComponent.class})
public interface HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint extends HiltViewModelFactory.ActivityCreatorEntryPoint {
}
