package com.upuphone.xr.interconnect.util;

import com.upuphone.xr.interconnect.entity.DataBinderValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u0018\u00010\u000b*\u0006\u0012\u0002\b\u00030\u0002\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\r*\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0002\u0010\u000e\u001a\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u0002\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0013*\u00020\u0005\u001a\n\u0010\u0011\u001a\u00020\u0014*\u00020\b\u001a\n\u0010\u0011\u001a\u00020\u0015*\u00020\r\u001a\n\u0010\u0011\u001a\u00020\u0016*\u00020\u0010\u001a\u0016\u0010\u0011\u001a\u00020\u0017*\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u000b¨\u0006\u0018"}, d2 = {"asBoolean", "", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "(Lcom/upuphone/xr/interconnect/entity/DataBinderValue;)Ljava/lang/Boolean;", "asFloat", "", "(Lcom/upuphone/xr/interconnect/entity/DataBinderValue;)Ljava/lang/Float;", "asInt", "", "(Lcom/upuphone/xr/interconnect/entity/DataBinderValue;)Ljava/lang/Integer;", "asList", "", "asLong", "", "(Lcom/upuphone/xr/interconnect/entity/DataBinderValue;)Ljava/lang/Long;", "asString", "", "toDataBinderValue", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Boolean;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Float;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Integer;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Long;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Batch;", "Shared_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DataBinderValueExtKt {
    @Nullable
    public static final Boolean asBoolean(@NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(dataBinderValue, "<this>");
        DataBinderValue.Boolean booleanR = dataBinderValue instanceof DataBinderValue.Boolean ? (DataBinderValue.Boolean) dataBinderValue : null;
        if (booleanR != null) {
            return (Boolean) booleanR.getValue();
        }
        return null;
    }

    @Nullable
    public static final Float asFloat(@NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(dataBinderValue, "<this>");
        DataBinderValue.Float floatR = dataBinderValue instanceof DataBinderValue.Float ? (DataBinderValue.Float) dataBinderValue : null;
        if (floatR != null) {
            return (Float) floatR.getValue();
        }
        return null;
    }

    @Nullable
    public static final Integer asInt(@NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(dataBinderValue, "<this>");
        DataBinderValue.Integer integer = dataBinderValue instanceof DataBinderValue.Integer ? (DataBinderValue.Integer) dataBinderValue : null;
        if (integer != null) {
            return (Integer) integer.getValue();
        }
        return null;
    }

    @Nullable
    public static final List<DataBinderValue<?>> asList(@NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(dataBinderValue, "<this>");
        DataBinderValue.Batch batch = dataBinderValue instanceof DataBinderValue.Batch ? (DataBinderValue.Batch) dataBinderValue : null;
        if (batch != null) {
            return (List) batch.getValue();
        }
        return null;
    }

    @Nullable
    public static final Long asLong(@NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(dataBinderValue, "<this>");
        DataBinderValue.Long longR = dataBinderValue instanceof DataBinderValue.Long ? (DataBinderValue.Long) dataBinderValue : null;
        if (longR != null) {
            return (Long) longR.getValue();
        }
        return null;
    }

    @Nullable
    public static final String asString(@NotNull DataBinderValue<?> dataBinderValue) {
        Intrinsics.checkNotNullParameter(dataBinderValue, "<this>");
        DataBinderValue.String string = dataBinderValue instanceof DataBinderValue.String ? (DataBinderValue.String) dataBinderValue : null;
        if (string != null) {
            return (String) string.getValue();
        }
        return null;
    }

    @NotNull
    public static final DataBinderValue.Boolean toDataBinderValue(boolean z) {
        return new DataBinderValue.Boolean(z);
    }

    @NotNull
    public static final DataBinderValue.Integer toDataBinderValue(int i) {
        return new DataBinderValue.Integer(i);
    }

    @NotNull
    public static final DataBinderValue.Long toDataBinderValue(long j) {
        return new DataBinderValue.Long(j);
    }

    @NotNull
    public static final DataBinderValue.Float toDataBinderValue(float f) {
        return new DataBinderValue.Float(f);
    }

    @NotNull
    public static final DataBinderValue.String toDataBinderValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new DataBinderValue.String(str);
    }

    @NotNull
    public static final DataBinderValue.Batch toDataBinderValue(@NotNull List<? extends DataBinderValue<?>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return new DataBinderValue.Batch(list);
    }
}
