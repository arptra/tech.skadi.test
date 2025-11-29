package dagger.hilt.android.internal.modules;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.codegen.OriginatingElement;

@OriginatingElement(topLevelClass = ActivityModule.class)
@InstallIn({ActivityComponent.class})
@Module
public final class HiltWrapper_ActivityModule {
}
