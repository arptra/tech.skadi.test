package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.upuphone.star.fota.phone.GlassCheckUpdateResult;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "", "()V", "Error", "Loading", "Result", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Error;", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Loading;", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Result;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public abstract class GlassCheckUpdateState {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Error;", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "errorCode", "", "msg", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getMsg", "()Ljava/lang/String;", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Error extends GlassCheckUpdateState {
        private final int errorCode;
        @Nullable
        private final String msg;

        public Error(int i, @Nullable String str) {
            super((DefaultConstructorMarker) null);
            this.errorCode = i;
            this.msg = str;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public String toString() {
            int i = this.errorCode;
            return "Error(errorCode=" + i + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Loading;", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading extends GlassCheckUpdateState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState$Result;", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "pair", "Lkotlin/Pair;", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "Lcom/upuphone/star/fota/phone/GlassCheckUpdateResult;", "(Lkotlin/Pair;)V", "getPair", "()Lkotlin/Pair;", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Result extends GlassCheckUpdateState {
        @NotNull
        private final Pair<BasicGlassInfo, GlassCheckUpdateResult> pair;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Result(@NotNull Pair<? extends BasicGlassInfo, GlassCheckUpdateResult> pair2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(pair2, "pair");
            this.pair = pair2;
        }

        @NotNull
        public final Pair<BasicGlassInfo, GlassCheckUpdateResult> getPair() {
            return this.pair;
        }

        @NotNull
        public String toString() {
            Pair<BasicGlassInfo, GlassCheckUpdateResult> pair2 = this.pair;
            return "Result(pair=" + pair2 + ")";
        }
    }

    public /* synthetic */ GlassCheckUpdateState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GlassCheckUpdateState() {
    }
}
