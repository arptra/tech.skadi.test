package dagger.hilt.android.components;

import dagger.hilt.DefineComponent;
import dagger.hilt.android.scopes.FragmentScoped;

@FragmentScoped
@DefineComponent(parent = ActivityComponent.class)
public interface FragmentComponent {
}
