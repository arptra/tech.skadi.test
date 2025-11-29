package kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Target;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.PROPERTY})
@ExperimentalSerializationApi
@Documented
@java.lang.annotation.Target({})
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/EncodeDefault;", "", "Lkotlinx/serialization/EncodeDefault$Mode;", "mode", "<init>", "(Lkotlinx/serialization/EncodeDefault$Mode;)V", "Mode", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0})
@Retention(RetentionPolicy.RUNTIME)
public @interface EncodeDefault {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/EncodeDefault$Mode;", "", "(Ljava/lang/String;I)V", "ALWAYS", "NEVER", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @ExperimentalSerializationApi
    public enum Mode {
        ALWAYS,
        NEVER;

        static {
            Mode[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        @NotNull
        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }
    }
}
