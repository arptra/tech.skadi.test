package dagger.hilt.android.components;

import dagger.hilt.DefineComponent;
import dagger.hilt.android.scopes.ActivityScoped;

@DefineComponent(parent = ActivityRetainedComponent.class)
@ActivityScoped
public interface ActivityComponent {
}
