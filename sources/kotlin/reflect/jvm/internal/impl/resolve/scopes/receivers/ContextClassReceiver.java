package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContextClassReceiver extends AbstractReceiverValue implements ImplicitContextReceiver {
    @NotNull
    private final ClassDescriptor classDescriptor;
    @Nullable
    private final Name customLabelName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextClassReceiver(@NotNull ClassDescriptor classDescriptor2, @NotNull KotlinType kotlinType, @Nullable Name name, @Nullable ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        Intrinsics.checkNotNullParameter(kotlinType, "receiverType");
        this.classDescriptor = classDescriptor2;
        this.customLabelName = name;
    }

    @Nullable
    public Name getCustomLabelName() {
        return this.customLabelName;
    }

    @NotNull
    public String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}
