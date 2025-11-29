package kotlinx.serialization.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InheritableSerialInfo;

@InheritableSerialInfo
@Target(allowedTargets = {AnnotationTarget.CLASS})
@ExperimentalSerializationApi
@java.lang.annotation.Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/json/JsonClassDiscriminator;", "", "discriminator", "", "()Ljava/lang/String;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonClassDiscriminator {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class Impl implements JsonClassDiscriminator {
        public final /* synthetic */ String b;

        public final /* synthetic */ String discriminator() {
            return this.b;
        }
    }

    String discriminator();
}
