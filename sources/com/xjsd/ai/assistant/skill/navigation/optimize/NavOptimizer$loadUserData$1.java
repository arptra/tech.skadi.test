package com.xjsd.ai.assistant.skill.navigation.optimize;

import android.content.Context;
import com.xjsd.ai.assistant.common.data.DataStoreUtils;
import com.xjsd.ai.assistant.core.ContextHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import com.xjsd.ai.assistant.log.ILog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nNavOptimizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavOptimizer.kt\ncom/xjsd/ai/assistant/skill/navigation/optimize/NavOptimizer$loadUserData$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 GsonUtils.kt\ncom/xjsd/ai/assistant/json/GsonUtils\n*L\n1#1,144:1\n53#2:145\n55#2:149\n50#3:146\n55#3:148\n106#4:147\n142#5,2:150\n*S KotlinDebug\n*F\n+ 1 NavOptimizer.kt\ncom/xjsd/ai/assistant/skill/navigation/optimize/NavOptimizer$loadUserData$1\n*L\n42#1:145\n42#1:149\n42#1:146\n42#1:148\n42#1:147\n47#1:150,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.skill.navigation.optimize.NavOptimizer$loadUserData$1", f = "NavOptimizer.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class NavOptimizer$loadUserData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public NavOptimizer$loadUserData$1(Continuation<? super NavOptimizer$loadUserData$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NavOptimizer$loadUserData$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStoreUtils dataStoreUtils = DataStoreUtils.f8415a;
            Context a2 = ContextHelper.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getContext(...)");
            NavOptimizer$loadUserData$1$invokeSuspend$$inlined$map$1 navOptimizer$loadUserData$1$invokeSuspend$$inlined$map$1 = new NavOptimizer$loadUserData$1$invokeSuspend$$inlined$map$1(dataStoreUtils.h(a2).getData());
            this.label = 1;
            obj = FlowKt.w(navOptimizer$loadUserData$1$invokeSuspend$$inlined$map$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        NavOptimizer.d.clear();
        if (!Intrinsics.areEqual((Object) str, (Object) "")) {
            Map b = NavOptimizer.d;
            Object fromJson = GsonUtils.f8498a.d().fromJson(str, new NavOptimizer$loadUserData$1$invokeSuspend$$inlined$fromJsonForMap$1().getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            b.putAll((Map) fromJson);
        }
        String e = GsonUtils.e(NavOptimizer.d);
        ILog.a("NavOptimizer", "loadUserData: 初始化数据->" + e);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NavOptimizer$loadUserData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
