package io.ktor.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lio/ktor/util/KtorExperimentalAPI;", "", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RequiresOptIn(level = RequiresOptIn.Level.WARNING, message = "This API is experimental. It could be removed or changed in future releases, or its behaviour may be different.")
@Deprecated(message = "This annotation is no longer used and there is no need to opt-in into it.")
@Retention(RetentionPolicy.RUNTIME)
public @interface KtorExperimentalAPI {
}
