package com.upuphone.xr.sapp.datatrack;

import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.HttpResult;
import com.upuphone.star.httplib.HttpResultKt;
import com.upuphone.xr.sapp.entity.BasicResponse;
import com.upuphone.xr.sapp.entity.BasicResponseKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper$fetchConfig$1", f = "DataTrackRuleHelper.kt", i = {}, l = {91, 102}, m = "invokeSuspend", n = {}, s = {})
public final class DataTrackRuleHelper$fetchConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $glassModel;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackRuleHelper$fetchConfig$1(String str, Continuation<? super DataTrackRuleHelper$fetchConfig$1> continuation) {
        super(2, continuation);
        this.$glassModel = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataTrackRuleHelper$fetchConfig$1(this.$glassModel, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BasicResponse basicResponse;
        DataTrackRuleConfig dataTrackRuleConfig;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        List<DataTrackRule> list = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            String str = this.$glassModel;
            delegate.a("DataTrackRuleHelper", "fetchConfig, glassModel: " + str);
            ArrayList arrayList = new ArrayList();
            arrayList.add("MYVU Android");
            String str2 = this.$glassModel;
            if (str2 != null) {
                Boxing.boxBoolean(arrayList.add(str2));
            }
            DataTrackRuleHelper dataTrackRuleHelper = DataTrackRuleHelper.b;
            List c = DataTrackRuleHelper.c;
            this.label = 1;
            obj = dataTrackRuleHelper.l(arrayList, c, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.c("DataTrackRuleHelper", "fetchConfig, error: " + e);
                basicResponse = null;
            }
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            DataTrackRuleHelper.b.q();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        basicResponse = (BasicResponse) HttpResultKt.b((HttpResult) obj);
        ULog.Delegate delegate3 = ULog.f6446a;
        delegate3.a("DataTrackRuleHelper", "fetchConfig, result: " + basicResponse);
        if (!(basicResponse == null || (dataTrackRuleConfig = (DataTrackRuleConfig) basicResponse.getData()) == null)) {
            list = dataTrackRuleConfig.getDataTrackRules();
        }
        if (basicResponse == null || !BasicResponseKt.isSuccess(basicResponse)) {
            DataTrackRuleHelper.f = true;
            return Unit.INSTANCE;
        }
        String str3 = this.$glassModel;
        if (str3 != null) {
            Boolean bool = (Boolean) DataTrackRuleHelper.e.put(str3, Boxing.boxBoolean(true));
        }
        DataTrackRuleHelper dataTrackRuleHelper2 = DataTrackRuleHelper.b;
        this.label = 2;
        if (dataTrackRuleHelper2.n(list, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        DataTrackRuleHelper.b.q();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataTrackRuleHelper$fetchConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
