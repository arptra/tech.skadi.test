package io.ktor.events;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "T", "it", "Lio/ktor/events/EventDefinition;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class Events$subscribe$1 extends Lambda implements Function1<EventDefinition<?>, LockFreeLinkedListHead> {
    public static final Events$subscribe$1 INSTANCE = new Events$subscribe$1();

    public Events$subscribe$1() {
        super(1);
    }

    @NotNull
    public final LockFreeLinkedListHead invoke(@NotNull EventDefinition<?> eventDefinition) {
        Intrinsics.checkNotNullParameter(eventDefinition, "it");
        return new LockFreeLinkedListHead();
    }
}
