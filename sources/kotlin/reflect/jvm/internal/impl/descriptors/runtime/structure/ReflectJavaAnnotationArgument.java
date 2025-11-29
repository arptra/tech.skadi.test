package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.honey.account.constant.AccountConstantKt;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    @NotNull
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    @Nullable
    private final Name name;

    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ReflectJavaAnnotationArgument create(@NotNull Object obj, @Nullable Name name) {
            Intrinsics.checkNotNullParameter(obj, AccountConstantKt.RESPONSE_VALUE);
            return ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(obj.getClass()) ? new ReflectJavaEnumValueAnnotationArgument(name, (Enum) obj) : obj instanceof Annotation ? new ReflectJavaAnnotationAsAnnotationArgument(name, (Annotation) obj) : obj instanceof Object[] ? new ReflectJavaArrayAnnotationArgument(name, (Object[]) obj) : obj instanceof Class ? new ReflectJavaClassObjectAnnotationArgument(name, (Class) obj) : new ReflectJavaLiteralAnnotationArgument(name, obj);
        }

        private Factory() {
        }
    }

    public /* synthetic */ ReflectJavaAnnotationArgument(Name name2, DefaultConstructorMarker defaultConstructorMarker) {
        this(name2);
    }

    @Nullable
    public Name getName() {
        return this.name;
    }

    private ReflectJavaAnnotationArgument(Name name2) {
        this.name = name2;
    }
}
