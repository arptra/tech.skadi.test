package sdk.meizu.account.factor.authentication.sdk.common;

import com.upuphone.starrynetsdk.ability.cast.CastConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0004\u0003\u0004\u0005\u0006\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "T", "", "Default", "Error", "Loading", "Success", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Default;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Error;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Loading;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Success;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ResultUiState<T> {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Default;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default implements ResultUiState {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || (obj instanceof Default);
        }

        public int hashCode() {
            return 1393710226;
        }

        @NotNull
        public String toString() {
            return CastConst.DEFAULT_TAG;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Error;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Error implements ResultUiState {
        @NotNull
        private final String message;

        public Error(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final Error copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Error(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.message, (Object) ((Error) obj).message);
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(message=" + this.message + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Loading;", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Loading implements ResultUiState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || (obj instanceof Loading);
        }

        public int hashCode() {
            return 185556877;
        }

        @NotNull
        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Success;", "T", "Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lsdk/meizu/account/factor/authentication/sdk/common/ResultUiState$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Success<T> implements ResultUiState<T> {
        private final T data;

        public Success(T t) {
            this.data = t;
        }

        public static /* synthetic */ Success copy$default(Success success, T t, int i, Object obj) {
            if ((i & 1) != 0) {
                t = success.data;
            }
            return success.copy(t);
        }

        public final T component1() {
            return this.data;
        }

        @NotNull
        public final Success<T> copy(T t) {
            return new Success<>(t);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.data, (Object) ((Success) obj).data);
        }

        public final T getData() {
            return this.data;
        }

        public int hashCode() {
            T t = this.data;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        @NotNull
        public String toString() {
            return "Success(data=" + this.data + ')';
        }
    }
}
