package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class OverridingUtilTypeSystemContext$newTypeCheckerState$1 extends TypeCheckerState {
    final /* synthetic */ OverridingUtilTypeSystemContext this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverridingUtilTypeSystemContext$newTypeCheckerState$1(boolean z, boolean z2, OverridingUtilTypeSystemContext overridingUtilTypeSystemContext, KotlinTypePreparator kotlinTypePreparator, KotlinTypeRefiner kotlinTypeRefiner) {
        super(z, z2, true, overridingUtilTypeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
        this.this$0 = overridingUtilTypeSystemContext;
    }

    public boolean customIsSubtypeOf(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        if (!(kotlinTypeMarker instanceof KotlinType)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (kotlinTypeMarker2 instanceof KotlinType) {
            return ((Boolean) this.this$0.customSubtype.invoke(kotlinTypeMarker, kotlinTypeMarker2)).booleanValue();
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
