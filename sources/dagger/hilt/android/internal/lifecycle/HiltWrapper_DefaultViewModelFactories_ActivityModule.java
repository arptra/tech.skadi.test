package dagger.hilt.android.internal.lifecycle;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.codegen.OriginatingElement;

@OriginatingElement(topLevelClass = DefaultViewModelFactories.class)
@InstallIn({ActivityComponent.class})
@Module
public final class HiltWrapper_DefaultViewModelFactories_ActivityModule {
}
