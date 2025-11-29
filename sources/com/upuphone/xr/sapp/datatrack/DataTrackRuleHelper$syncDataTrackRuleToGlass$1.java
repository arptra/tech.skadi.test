package com.upuphone.xr.sapp.datatrack;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.common.ResultListener;
import com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDao;
import com.upuphone.xr.sapp.datatrack.db.DataTrackRuleDb;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.glass.GlassMessageHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nDataTrackRuleHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataTrackRuleHelper.kt\ncom/upuphone/xr/sapp/datatrack/DataTrackRuleHelper$syncDataTrackRuleToGlass$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n1603#2,9:230\n1855#2:239\n1856#2:241\n1612#2:242\n1603#2,9:243\n1855#2:252\n1856#2:254\n1612#2:255\n1#3:240\n1#3:253\n*S KotlinDebug\n*F\n+ 1 DataTrackRuleHelper.kt\ncom/upuphone/xr/sapp/datatrack/DataTrackRuleHelper$syncDataTrackRuleToGlass$1\n*L\n158#1:230,9\n158#1:239\n158#1:241\n158#1:242\n164#1:243,9\n164#1:252\n164#1:254\n164#1:255\n158#1:240\n164#1:253\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper$syncDataTrackRuleToGlass$1", f = "DataTrackRuleHelper.kt", i = {0}, l = {153}, m = "invokeSuspend", n = {"isEnable"}, s = {"Z$0"})
public final class DataTrackRuleHelper$syncDataTrackRuleToGlass$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;

    public DataTrackRuleHelper$syncDataTrackRuleToGlass$1(Continuation<? super DataTrackRuleHelper$syncDataTrackRuleToGlass$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataTrackRuleHelper$syncDataTrackRuleToGlass$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceInfo o = ControlUtils.f7858a.o();
            String model = o != null ? o.getModel() : null;
            if (model == null || model.length() == 0) {
                ULog.f6446a.c("DataTrackRuleHelper", "syncDataTrackRuleToGlass, glassModel is null");
                return Unit.INSTANCE;
            } else if (!Intrinsics.areEqual(DataTrackRuleHelper.e.get(model), (Object) Boxing.boxBoolean(true))) {
                ULog.f6446a.c("DataTrackRuleHelper", "syncDataTrackRuleToGlass, fetchConfigSuccess=false");
                DataTrackRuleHelper.b.k(model);
                return Unit.INSTANCE;
            } else {
                boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_user_experience", Boxing.boxBoolean(true), (Context) null, 4, (Object) null)).booleanValue();
                DataTrackRuleDao e = DataTrackRuleDb.f6927a.a().e();
                List listOf = CollectionsKt.listOf(Boxing.boxInt(2), Boxing.boxInt(3));
                this.Z$0 = booleanValue;
                this.label = 1;
                obj = e.c(model, listOf, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z = booleanValue;
            }
        } else if (i == 1) {
            z = this.Z$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<DataTrackRule> list = (List) obj;
        ArrayList arrayList = new ArrayList();
        for (DataTrackRule dataTrackRule : list) {
            Integer boxInt = dataTrackRule.getEventUseType() == 2 ? Boxing.boxInt(dataTrackRule.getRuleId()) : null;
            if (boxInt != null) {
                arrayList.add(boxInt);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (DataTrackRule dataTrackRule2 : list) {
            Integer boxInt2 = dataTrackRule2.getEventUseType() == 3 ? Boxing.boxInt(dataTrackRule2.getRuleId()) : null;
            if (boxInt2 != null) {
                arrayList2.add(boxInt2);
            }
        }
        GlassDataTrackRuleConfig glassDataTrackRuleConfig = new GlassDataTrackRuleConfig(z, arrayList, arrayList2);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("DataTrackRuleHelper", "syncDataTrackRuleToGlass, config: " + glassDataTrackRuleConfig);
        GlassMessageHelper.f7054a.g("event_tracking", "sync_event_rule", JsonUtils.f7893a.d(glassDataTrackRuleConfig), new ResultListener<String>() {
            /* renamed from: a */
            public void onSuccess(String str) {
                Intrinsics.checkNotNullParameter(str, "result");
                DataTrackRuleHelper.f = false;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("DataTrackRuleHelper", "syncDataTrackRuleToGlass, sendMessage-onSuccess, result: " + str);
            }

            public void onFail(int i, String str) {
                Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
                DataTrackRuleHelper.f = true;
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("DataTrackRuleHelper", "syncDataTrackRuleToGlass, sendMessage-onFail, code: " + i + ", msg: " + str);
            }
        });
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataTrackRuleHelper$syncDataTrackRuleToGlass$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
