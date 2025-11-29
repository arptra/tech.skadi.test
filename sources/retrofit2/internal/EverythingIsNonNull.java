package retrofit2.internal;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@TypeQualifierDefault
@Nonnull
@Retention(RetentionPolicy.RUNTIME)
public @interface EverythingIsNonNull {
}
