package com.meizu.flyme.policy.sdk;

import android.content.Context;
import com.google.gson.Gson;
import com.meizu.flyme.policy.sdk.bean.PolicyRecordRequest;
import com.meizu.flyme.policy.sdk.bean.PolicySdkResultBean;
import com.meizu.flyme.policy.sdk.util.PolicySdkLogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.meizu.flyme.policy.sdk.PolicyManager$autoUploadRecordOnline$1$1", f = "PolicyManager.kt", i = {}, l = {771}, m = "invokeSuspend", n = {}, s = {})
public final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public int f3196a;
    public final /* synthetic */ PolicySdkResultBean b;
    public final /* synthetic */ Ref.ObjectRef<PolicyRecordRequest> c;
    public final /* synthetic */ Context d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(PolicySdkResultBean policySdkResultBean, Ref.ObjectRef<PolicyRecordRequest> objectRef, Context context, Continuation<? super b> continuation) {
        super(2, continuation);
        this.b = policySdkResultBean;
        this.c = objectRef;
        this.d = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new b(this.b, this.c, this.d, continuation);
    }

    public Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        return new b(this.b, this.c, this.d, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f3196a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PolicySdkLogUtils.Companion companion = PolicySdkLogUtils.Companion;
            companion.d("autoUploadRecord", Intrinsics.stringPlus("policySdkResultBean.code ", Boxing.boxInt(this.b.getCode())));
            if (this.b.getCode() == 0) {
                str = "";
                z = true;
            } else {
                str = new Gson().toJson((Object) this.c.element);
                Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(policyRecordRequest)");
                z = false;
            }
            companion.d("autoUploadRecord", Intrinsics.stringPlus("isOperateSuccess ", Boxing.boxBoolean(z)));
            PolicyManager policyManager = PolicyManager.INSTANCE;
            Context context = this.d;
            this.f3196a = 1;
            if (policyManager.savePolicyOperate(context, z, str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
