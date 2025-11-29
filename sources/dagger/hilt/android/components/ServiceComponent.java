package dagger.hilt.android.components;

import dagger.hilt.DefineComponent;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.components.SingletonComponent;

@ServiceScoped
@DefineComponent(parent = SingletonComponent.class)
public interface ServiceComponent {
}
