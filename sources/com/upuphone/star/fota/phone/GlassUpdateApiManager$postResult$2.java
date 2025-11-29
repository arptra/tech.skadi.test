package com.upuphone.star.fota.phone;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.httplib.SignUtils;
import java.util.SortedMap;
import javax.crypto.SecretKey;
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

@SourceDebugExtension({"SMAP\nGlassUpdateApiManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateApiManager.kt\ncom/upuphone/star/fota/phone/GlassUpdateApiManager$postResult$2\n*L\n1#1,177:1\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.star.fota.phone.GlassUpdateApiManager$postResult$2", f = "GlassUpdateApiManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateApiManager$postResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SortedMap<String, String> $params;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateApiManager$postResult$2(SortedMap<String, String> sortedMap, Continuation<? super GlassUpdateApiManager$postResult$2> continuation) {
        super(2, continuation);
        this.$params = sortedMap;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateApiManager$postResult$2(this.$params, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SortedMap<String, String> sortedMap = this.$params;
            sortedMap.put(AccountConstantKt.REQUEST_HEADER_SIGN, SignUtils.signWithHMacSha256$default(SignUtils.INSTANCE, sortedMap, (SecretKey) null, 2, (Object) null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateApiManager$postResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
