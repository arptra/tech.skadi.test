package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4 extends Lambda implements Function1<TypeCheckerState.ForkPointContext, Unit> {
    final /* synthetic */ TypeCheckerState $state;
    final /* synthetic */ SimpleTypeMarker $superType;
    final /* synthetic */ List<SimpleTypeMarker> $supertypesWithSameConstructor;
    final /* synthetic */ TypeSystemContext $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4(List<? extends SimpleTypeMarker> list, TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        super(1);
        this.$supertypesWithSameConstructor = list;
        this.$state = typeCheckerState;
        this.$this_with = typeSystemContext;
        this.$superType = simpleTypeMarker;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypeCheckerState.ForkPointContext) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TypeCheckerState.ForkPointContext forkPointContext) {
        Intrinsics.checkNotNullParameter(forkPointContext, "$this$runForkingPoint");
        for (final SimpleTypeMarker next : this.$supertypesWithSameConstructor) {
            final TypeCheckerState typeCheckerState = this.$state;
            final TypeSystemContext typeSystemContext = this.$this_with;
            final SimpleTypeMarker simpleTypeMarker = this.$superType;
            forkPointContext.fork(new Function0<Boolean>() {
                @NotNull
                public final Boolean invoke() {
                    return Boolean.valueOf(AbstractTypeChecker.INSTANCE.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext.asArgumentList(next), simpleTypeMarker));
                }
            });
        }
    }
}
