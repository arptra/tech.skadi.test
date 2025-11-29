package dagger.hilt.internal;

import dagger.hilt.GeneratesRootInput;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@GeneratesRootInput
@Target({ElementType.TYPE})
public @interface GeneratedEntryPoint {
}
