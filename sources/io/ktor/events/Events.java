package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015J?\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eR*\u0010\u0014\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0011\u0012\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lio/ktor/events/Events;", "", "T", "Lio/ktor/events/EventDefinition;", "definition", "Lkotlin/Function1;", "", "Lio/ktor/events/EventHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "b", "(Lio/ktor/events/EventDefinition;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "value", "a", "(Lio/ktor/events/EventDefinition;Ljava/lang/Object;)V", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "getHandlers$annotations", "()V", "handlers", "HandlerRegistration", "ktor-events"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEvents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Events.kt\nio/ktor/events/Events\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n341#2,6:94\n341#2,3:100\n344#2,3:104\n1#3:103\n*S KotlinDebug\n*F\n+ 1 Events.kt\nio/ktor/events/Events\n*L\n33#1:94,6\n46#1:100,3\n46#1:104,3\n*E\n"})
public final class Events {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteHashMap f8938a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR)\u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00040\u0003j\u0006\u0012\u0002\b\u0003`\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/events/Events$HandlerRegistration;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlin/Function1;", "", "Lio/ktor/events/EventHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "dispose", "()V", "d", "Lkotlin/jvm/functions/Function1;", "s", "()Lkotlin/jvm/functions/Function1;", "ktor-events"}, k = 1, mv = {1, 8, 0})
    public static final class HandlerRegistration extends LockFreeLinkedListNode implements DisposableHandle {
        public final Function1 d;

        public HandlerRegistration(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "handler");
            this.d = function1;
        }

        public void dispose() {
            o();
        }

        public final Function1 s() {
            return this.d;
        }
    }

    public final void a(EventDefinition eventDefinition, Object obj) {
        Unit unit;
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        LockFreeLinkedListHead lockFreeLinkedListHead = (LockFreeLinkedListHead) this.f8938a.b(eventDefinition);
        Throwable th = null;
        if (lockFreeLinkedListHead != null) {
            Object k = lockFreeLinkedListHead.k();
            Intrinsics.checkNotNull(k, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            Throwable th2 = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) k; !Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.l()) {
                if (lockFreeLinkedListNode instanceof HandlerRegistration) {
                    try {
                        Function1 s = ((HandlerRegistration) lockFreeLinkedListNode).s();
                        Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlin.Function1<T of io.ktor.events.Events.raise$lambda$2, kotlin.Unit>{ io.ktor.events.EventsKt.EventHandler<T of io.ktor.events.Events.raise$lambda$2> }");
                        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(s, 1)).invoke(obj);
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th2, th3);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            th2 = th3;
                        }
                    }
                }
            }
            th = th2;
        }
        if (th != null) {
            throw th;
        }
    }

    public final DisposableHandle b(EventDefinition eventDefinition, Function1 function1) {
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        Intrinsics.checkNotNullParameter(function1, "handler");
        HandlerRegistration handlerRegistration = new HandlerRegistration(function1);
        ((LockFreeLinkedListHead) this.f8938a.a(eventDefinition, Events$subscribe$1.INSTANCE)).e(handlerRegistration);
        return handlerRegistration;
    }
}
