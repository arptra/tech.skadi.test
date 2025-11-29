package com.upuphone.ai.ttsengine.engines.cache.cache;

import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cache.cache.PcmLFUCache$loadCache$1", f = "PcmLFUCache.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class PcmLFUCache$loadCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PcmLFUCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PcmLFUCache$loadCache$1(PcmLFUCache pcmLFUCache, Continuation<? super PcmLFUCache$loadCache$1> continuation) {
        super(2, continuation);
        this.this$0 = pcmLFUCache;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PcmLFUCache$loadCache$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow c = this.this$0.d.c();
            final PcmLFUCache pcmLFUCache = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(List list, Continuation continuation) {
                    AILOG a2 = PcmLFUCacheKt.f5540a;
                    int size = list.size();
                    a2.c("reload cache list cause update: " + size, new Object[0]);
                    PcmLFUCache pcmLFUCache = pcmLFUCache;
                    synchronized (pcmLFUCache) {
                        pcmLFUCache.c.clear();
                        pcmLFUCache.c.addAll(list);
                    }
                    PcmLFUCacheKt.f5540a.c("reload cache finished", new Object[0]);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (c.collect(r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PcmLFUCache$loadCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
