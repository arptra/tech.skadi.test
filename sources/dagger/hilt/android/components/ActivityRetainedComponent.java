package dagger.hilt.android.components;

import dagger.hilt.DefineComponent;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.components.SingletonComponent;

@ActivityRetainedScoped
@DefineComponent(parent = SingletonComponent.class)
public interface ActivityRetainedComponent {
}
