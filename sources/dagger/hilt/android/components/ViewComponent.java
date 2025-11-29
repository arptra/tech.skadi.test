package dagger.hilt.android.components;

import dagger.hilt.DefineComponent;
import dagger.hilt.android.scopes.ViewScoped;

@ViewScoped
@DefineComponent(parent = ActivityComponent.class)
public interface ViewComponent {
}
