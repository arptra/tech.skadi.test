package com.upuphone.xr.interconnect.api;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import com.upuphone.xr.interconnect.util.DataBinderValueExtKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ-\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010\u0011J)\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010\u0017J)\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010\u001aJ5\u0010\u001b\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010\u001dJ)\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010 J)\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010\"J'\u0010#\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010$J5\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c2\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u001f\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010)J+\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\n\u0010*\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0002\u0010+J'\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0006\u0010*\u001a\u00020\u0013¢\u0006\u0002\u0010,J'\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0006\u0010*\u001a\u00020\u0016¢\u0006\u0002\u0010-J'\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0006\u0010*\u001a\u00020\u0019¢\u0006\u0002\u0010.J'\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0006\u0010*\u001a\u00020\u001f¢\u0006\u0002\u0010/J'\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0002\u00100J3\u0010'\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000e0\u001c¢\u0006\u0002\u00101J/\u00102\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0006\u00103\u001a\u000204¢\u0006\u0002\u00105J\u001f\u00106\u001a\u00020(2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u0005¢\u0006\u0002\u0010)J/\u00107\u001a\u00020(2\u0006\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n\"\u00020\u00052\u0006\u00103\u001a\u000204¢\u0006\u0002\u00105R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\u00050\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "", "operator", "Lcom/upuphone/xr/interconnect/api/DataBinderOperator;", "prefix", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/upuphone/xr/interconnect/api/DataBinderOperator;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;)V", "dataName", "", "getDataName", "([Ljava/lang/String;)Ljava/lang/String;", "get", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "deviceId", "params", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "getBoolean", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Boolean;", "getFloat", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Float;", "getInt", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Integer;", "getList", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "getLong", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Long;", "getString", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "isSet", "(Ljava/lang/String;[Ljava/lang/String;)Z", "list", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "set", "", "([Ljava/lang/String;)V", "value", "([Ljava/lang/String;Lcom/upuphone/xr/interconnect/entity/DataBinderValue;)V", "([Ljava/lang/String;Z)V", "([Ljava/lang/String;F)V", "([Ljava/lang/String;I)V", "([Ljava/lang/String;J)V", "([Ljava/lang/String;Ljava/lang/String;)V", "([Ljava/lang/String;Ljava/util/List;)V", "subscribe", "listener", "Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;", "(Ljava/lang/String;[Ljava/lang/String;Lcom/upuphone/xr/interconnect/common/IDataBinderItemUpdateListener;)V", "unset", "unsubscribe", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataBinderSlice {
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final DataBinderOperator operator;
    @NotNull
    private final String prefix;

    public DataBinderSlice(@NotNull DataBinderOperator dataBinderOperator, @NotNull String str, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(dataBinderOperator, "operator");
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.operator = dataBinderOperator;
        this.prefix = str;
        this.dispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final String getDataName(String[] strArr) {
        return this.prefix + ':' + ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Nullable
    public final DataBinderValue<?> get(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        return this.operator.get(str, getDataName(strArr));
    }

    @Nullable
    public final Boolean getBoolean(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        DataBinderValue<?> dataBinderValue = get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (dataBinderValue != null) {
            return DataBinderValueExtKt.asBoolean(dataBinderValue);
        }
        return null;
    }

    @Nullable
    public final Float getFloat(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        DataBinderValue<?> dataBinderValue = get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (dataBinderValue != null) {
            return DataBinderValueExtKt.asFloat(dataBinderValue);
        }
        return null;
    }

    @Nullable
    public final Integer getInt(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        DataBinderValue<?> dataBinderValue = get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (dataBinderValue != null) {
            return DataBinderValueExtKt.asInt(dataBinderValue);
        }
        return null;
    }

    @Nullable
    public final List<DataBinderValue<?>> getList(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        DataBinderValue<?> dataBinderValue = get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (dataBinderValue != null) {
            return DataBinderValueExtKt.asList(dataBinderValue);
        }
        return null;
    }

    @Nullable
    public final Long getLong(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        DataBinderValue<?> dataBinderValue = get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (dataBinderValue != null) {
            return DataBinderValueExtKt.asLong(dataBinderValue);
        }
        return null;
    }

    @Nullable
    public final String getString(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        DataBinderValue<?> dataBinderValue = get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (dataBinderValue != null) {
            return DataBinderValueExtKt.asString(dataBinderValue);
        }
        return null;
    }

    public final boolean isSet(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        return get(str, (String[]) Arrays.copyOf(strArr, strArr.length)) != null;
    }

    @Nullable
    public final Object list(@NotNull String str, @NotNull String[] strArr, @NotNull Continuation<? super List<String>> continuation) {
        return BuildersKt.g(this.dispatcher, new DataBinderSlice$list$2(this, strArr, str, (Continuation<? super DataBinderSlice$list$2>) null), continuation);
    }

    public final void set(@NotNull String[] strArr, @NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(dataBinderValue, AccountConstantKt.RESPONSE_VALUE);
        this.operator.set(getDataName(strArr), dataBinderValue);
    }

    public final void subscribe(@NotNull String str, @NotNull String[] strArr, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.operator.subscribe(str, getDataName(strArr), iDataBinderItemUpdateListener);
    }

    public final void unset(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        this.operator.unset(getDataName(strArr));
    }

    public final void unsubscribe(@NotNull String str, @NotNull String[] strArr, @NotNull IDataBinderItemUpdateListener iDataBinderItemUpdateListener) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(iDataBinderItemUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.operator.unsubscribe(str, getDataName(strArr), iDataBinderItemUpdateListener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataBinderSlice(DataBinderOperator dataBinderOperator, String str, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataBinderOperator, str, (i & 4) != 0 ? Dispatchers.a() : coroutineDispatcher);
    }

    public final void set(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        set((String[]) Arrays.copyOf(strArr, strArr.length), (DataBinderValue<?>) new DataBinderValue.Null());
    }

    public final void set(@NotNull String[] strArr, boolean z) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        set((String[]) Arrays.copyOf(strArr, strArr.length), (DataBinderValue<?>) DataBinderValueExtKt.toDataBinderValue(z));
    }

    public final void set(@NotNull String[] strArr, int i) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        set((String[]) Arrays.copyOf(strArr, strArr.length), (DataBinderValue<?>) DataBinderValueExtKt.toDataBinderValue(i));
    }

    public final void set(@NotNull String[] strArr, long j) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        set((String[]) Arrays.copyOf(strArr, strArr.length), (DataBinderValue<?>) DataBinderValueExtKt.toDataBinderValue(j));
    }

    public final void set(@NotNull String[] strArr, float f) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        set((String[]) Arrays.copyOf(strArr, strArr.length), (DataBinderValue<?>) DataBinderValueExtKt.toDataBinderValue(f));
    }

    public final void set(@NotNull String[] strArr, @NotNull String str) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        set((String[]) Arrays.copyOf(strArr, strArr.length), (DataBinderValue<?>) DataBinderValueExtKt.toDataBinderValue(str));
    }

    public final void set(@NotNull String[] strArr, @NotNull List<? extends DataBinderValue<?>> list) {
        Intrinsics.checkNotNullParameter(strArr, PayloadConstant.KEY_PARAMS);
        Intrinsics.checkNotNullParameter(list, AccountConstantKt.RESPONSE_VALUE);
        set((String[]) Arrays.copyOf(strArr, strArr.length), (DataBinderValue<?>) DataBinderValueExtKt.toDataBinderValue(list));
    }
}
