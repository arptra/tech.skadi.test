package com.upuphone.xr.sapp.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/config/NetConfigInterface;", "", "getNetConfig", "Lcom/upuphone/xr/sapp/config/NetConfigResult;", "locale", "", "timeZone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface NetConfigInterface {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(NetConfigInterface netConfigInterface, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return netConfigInterface.getNetConfig(str, str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNetConfig");
        }
    }

    @Nullable
    @GET("api/v2/services")
    Object getNetConfig(@Nullable @Query("locale") String str, @Nullable @Query("timeZone") String str2, @NotNull Continuation<? super NetConfigResult> continuation);
}
