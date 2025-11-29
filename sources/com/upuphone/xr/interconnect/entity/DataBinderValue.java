package com.upuphone.xr.interconnect.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.CallSuper;
import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001aB\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0001\u0007\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "T", "Landroid/os/Parcelable;", "type", "", "value", "(BLjava/lang/Object;)V", "getType", "()B", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Batch", "Boolean", "CREATOR", "Float", "Integer", "Long", "Null", "String", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Batch;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Boolean;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Float;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Integer;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Long;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Null;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DataBinderValue<T> implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final byte type;
    private final T value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Batch;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "(Ljava/util/List;)V", "toString", "", "writeToParcel", "", "dest", "flags", "", "CREATOR", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Batch extends DataBinderValue<List<? extends DataBinderValue<?>>> {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Batch$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CREATOR implements Parcelable.Creator<String> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @NotNull
            public String createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new String(parcel);
            }

            @NotNull
            public String[] newArray(int i) {
                return new String[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Batch(@NotNull List<? extends DataBinderValue<?>> list) {
            super((byte) 7, list, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, AccountConstantKt.RESPONSE_VALUE);
        }

        @NotNull
        public String toString() {
            return getValue().toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            DataBinderValue.super.writeToParcel(parcel, i);
            DataBinderValueKt.writeBatch(parcel, (List) getValue());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Batch(@NotNull Parcel parcel) {
            this((List<? extends DataBinderValue<?>>) DataBinderValueKt.readBatch(parcel));
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Boolean;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "(Z)V", "toString", "", "writeToParcel", "", "dest", "flags", "", "CREATOR", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Boolean extends DataBinderValue<Boolean> {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Boolean$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Boolean;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Boolean;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CREATOR implements Parcelable.Creator<Boolean> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @NotNull
            public Boolean createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Boolean(parcel);
            }

            @NotNull
            public Boolean[] newArray(int i) {
                return new Boolean[i];
            }
        }

        public Boolean(boolean z) {
            super((byte) 2, Boolean.valueOf(z), (DefaultConstructorMarker) null);
        }

        @NotNull
        public String toString() {
            return String.valueOf(((Boolean) getValue()).booleanValue());
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            DataBinderValue.super.writeToParcel(parcel, i);
            parcel.writeInt(((Boolean) getValue()).booleanValue() ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Boolean(@NotNull Parcel parcel) {
            this(parcel.readInt() != 0);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<DataBinderValue<?>> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Nullable
        public DataBinderValue<?> createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            byte readByte = parcel.readByte();
            if (readByte == 1) {
                return new Null();
            }
            if (readByte == 2) {
                return new Boolean(parcel);
            }
            if (readByte == 3) {
                return new Integer(parcel);
            }
            if (readByte == 4) {
                return new Long(parcel);
            }
            if (readByte == 5) {
                return new Float(parcel);
            }
            if (readByte == 6) {
                return new String(parcel);
            }
            if (readByte == 7) {
                return new Batch(parcel);
            }
            return null;
        }

        @NotNull
        public DataBinderValue<?>[] newArray(int i) {
            return new DataBinderValue[i];
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Float;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "(F)V", "toString", "", "writeToParcel", "", "dest", "flags", "", "CREATOR", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Float extends DataBinderValue<Float> {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Float$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Float;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Float;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CREATOR implements Parcelable.Creator<Float> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @NotNull
            public Float createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Float(parcel);
            }

            @NotNull
            public Float[] newArray(int i) {
                return new Float[i];
            }
        }

        public Float(float f) {
            super((byte) 5, Float.valueOf(f), (DefaultConstructorMarker) null);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(((Number) getValue()).floatValue());
            sb.append('f');
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            DataBinderValue.super.writeToParcel(parcel, i);
            parcel.writeFloat(((Number) getValue()).floatValue());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Float(@NotNull Parcel parcel) {
            this(parcel.readFloat());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Integer;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "(I)V", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Integer extends DataBinderValue<Integer> {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Integer$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Integer;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Integer;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CREATOR implements Parcelable.Creator<Integer> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @NotNull
            public Integer createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Integer(parcel);
            }

            @NotNull
            public Integer[] newArray(int i) {
                return new Integer[i];
            }
        }

        public Integer(int i) {
            super((byte) 3, Integer.valueOf(i), (DefaultConstructorMarker) null);
        }

        @NotNull
        public String toString() {
            return String.valueOf(((Number) getValue()).intValue());
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            DataBinderValue.super.writeToParcel(parcel, i);
            parcel.writeInt(((Number) getValue()).intValue());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Integer(@NotNull Parcel parcel) {
            this(parcel.readInt());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Long;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "(J)V", "toString", "", "writeToParcel", "", "dest", "flags", "", "CREATOR", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Long extends DataBinderValue<Long> {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Long$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Long;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Long;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CREATOR implements Parcelable.Creator<Long> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @NotNull
            public Long createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Long(parcel);
            }

            @NotNull
            public Long[] newArray(int i) {
                return new Long[i];
            }
        }

        public Long(long j) {
            super((byte) 4, Long.valueOf(j), (DefaultConstructorMarker) null);
        }

        @NotNull
        public String toString() {
            return String.valueOf(((Number) getValue()).longValue());
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            DataBinderValue.super.writeToParcel(parcel, i);
            parcel.writeLong(((Number) getValue()).longValue());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Long(@NotNull Parcel parcel) {
            this(parcel.readLong());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Null;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "CREATOR", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Null extends DataBinderValue<Unit> {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Null$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Null;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue$Null;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CREATOR implements Parcelable.Creator<Null> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @NotNull
            public Null createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Null(parcel);
            }

            @NotNull
            public Null[] newArray(int i) {
                return new Null[i];
            }
        }

        public Null() {
            super((byte) 1, Unit.INSTANCE, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            return obj instanceof Null;
        }

        public int hashCode() {
            return Null.class.hashCode();
        }

        @NotNull
        public String toString() {
            return "Null";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Null(@NotNull Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "(Ljava/lang/String;)V", "toString", "writeToParcel", "", "dest", "flags", "", "CREATOR", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class String extends DataBinderValue<String> {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/upuphone/xr/interconnect/entity/DataBinderValue$String;", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class CREATOR implements Parcelable.Creator<String> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @NotNull
            public String createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new String(parcel);
            }

            @NotNull
            public String[] newArray(int i) {
                return new String[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public String(@NotNull String str) {
            super((byte) 6, str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        }

        @NotNull
        public String toString() {
            return '\"' + ((String) getValue()) + '\"';
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            DataBinderValue.super.writeToParcel(parcel, i);
            parcel.writeString((String) getValue());
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public String(@org.jetbrains.annotations.NotNull android.os.Parcel r2) {
            /*
                r1 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r2 = r2.readString()
                if (r2 != 0) goto L_0x000d
                java.lang.String r2 = ""
            L_0x000d:
                r1.<init>((java.lang.String) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.entity.DataBinderValue.String.<init>(android.os.Parcel):void");
        }
    }

    public /* synthetic */ DataBinderValue(byte b, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(b, obj);
    }

    public int describeContents() {
        return 0;
    }

    public final byte getType() {
        return this.type;
    }

    public final T getValue() {
        return this.value;
    }

    @CallSuper
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeByte(this.type);
    }

    private DataBinderValue(byte b, T t) {
        this.type = b;
        this.value = t;
    }
}
