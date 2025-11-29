package dagger.hilt.android.components;

import dagger.hilt.DefineComponent;
import dagger.hilt.android.scopes.ViewModelScoped;

@ViewModelScoped
@DefineComponent(parent = ActivityRetainedComponent.class)
public interface ViewModelComponent {
}
