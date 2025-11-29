package dagger.hilt.android;

import dagger.hilt.GeneratesRootInput;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@GeneratesRootInput
@Target({ElementType.TYPE})
public @interface AndroidEntryPoint {
    Class<?> value() default Void.class;
}
