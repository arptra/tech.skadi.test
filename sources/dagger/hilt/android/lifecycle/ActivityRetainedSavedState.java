package dagger.hilt.android.lifecycle;

import dagger.hilt.android.UnstableApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Qualifier
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@UnstableApi
@Retention(RetentionPolicy.CLASS)
public @interface ActivityRetainedSavedState {
}
