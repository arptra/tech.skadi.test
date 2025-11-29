package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@TypeQualifierDefault
@Nullable
@Retention(RetentionPolicy.RUNTIME)
public @interface ParametersAreNullableByDefault {
}
