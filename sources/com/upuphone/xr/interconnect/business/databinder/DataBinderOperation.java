package com.upuphone.xr.interconnect.business.databinder;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.xr.interconnect.entity.DataBinderValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "stringifyPrefix", "getStringifyPrefix", "stringify", "Delete", "Update", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation$Delete;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation$Update;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DataBinderOperation {
    @NotNull
    private final String name;
    @NotNull
    private final String stringifyPrefix;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation$Delete;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "name", "", "(Ljava/lang/String;)V", "stringify", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Delete extends DataBinderOperation {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Delete(@NotNull String str) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
        }

        @NotNull
        public String stringify() {
            String stringifyPrefix = getStringifyPrefix();
            return stringifyPrefix + "Delete()";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation$Update;", "Lcom/upuphone/xr/interconnect/business/databinder/DataBinderOperation;", "name", "", "value", "Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "(Ljava/lang/String;Lcom/upuphone/xr/interconnect/entity/DataBinderValue;)V", "getValue", "()Lcom/upuphone/xr/interconnect/entity/DataBinderValue;", "stringify", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Update extends DataBinderOperation {
        @NotNull
        private final DataBinderValue<?> value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Update(@NotNull String str, @NotNull DataBinderValue<?> dataBinderValue) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(dataBinderValue, AccountConstantKt.RESPONSE_VALUE);
            this.value = dataBinderValue;
        }

        @NotNull
        public final DataBinderValue<?> getValue() {
            return this.value;
        }

        @NotNull
        public String stringify() {
            String stringifyPrefix = getStringifyPrefix();
            DataBinderValue<?> dataBinderValue = this.value;
            return stringifyPrefix + "Update(" + dataBinderValue + ")";
        }
    }

    public /* synthetic */ DataBinderOperation(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getStringifyPrefix() {
        return this.stringifyPrefix;
    }

    @NotNull
    public String stringify() {
        return this.name;
    }

    private DataBinderOperation(String str) {
        this.name = str;
        this.stringifyPrefix = str + "::";
    }
}
