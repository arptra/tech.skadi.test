package dagger.hilt.internal;

import dagger.hilt.GeneratesRootInput;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@GeneratesRootInput
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface ComponentEntryPoint {
}
