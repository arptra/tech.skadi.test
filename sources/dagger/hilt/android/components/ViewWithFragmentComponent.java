package dagger.hilt.android.components;

import dagger.hilt.DefineComponent;
import dagger.hilt.android.scopes.ViewScoped;

@ViewScoped
@DefineComponent(parent = FragmentComponent.class)
public interface ViewWithFragmentComponent {
}
