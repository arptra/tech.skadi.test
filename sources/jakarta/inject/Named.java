package jakarta.inject;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Named {
}
