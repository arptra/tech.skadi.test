package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.utils.SpUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHelper.kt\ncom/upuphone/ar/tici/phone/utils/TiciHelper$runSPMigration$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,623:1\n215#2,2:624\n*S KotlinDebug\n*F\n+ 1 TiciHelper.kt\ncom/upuphone/ar/tici/phone/utils/TiciHelper$runSPMigration$2\n*L\n477#1:624,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper$runSPMigration$2", f = "TiciHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciHelper$runSPMigration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciHelper$runSPMigration$2(String str, Continuation<? super TiciHelper$runSPMigration$2> continuation) {
        super(2, continuation);
        this.$userId = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciHelper$runSPMigration$2(this.$userId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$userId;
            CommonExtKt.b("runSPMigration, start, userId: " + str, "TiciHelper");
            SpUtil.Companion companion = SpUtil.b;
            SpUtil b = companion.b(this.$userId);
            SpUtil a2 = companion.a();
            for (Map.Entry entry : a2.d().entrySet()) {
                CommonExtKt.b("runSPMigration, item: " + entry, "TiciHelper");
            }
            b.A(a2.n());
            b.B(a2.o());
            b.x(a2.j());
            b.y(a2.k());
            b.v(a2.h());
            b.z(a2.l());
            CommonExtKt.b("runSPMigration, end", "TiciHelper");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciHelper$runSPMigration$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
