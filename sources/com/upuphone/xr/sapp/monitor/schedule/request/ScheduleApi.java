package com.upuphone.xr.sapp.monitor.schedule.request;

import com.upuphone.xr.sapp.monitor.schedule.model.BaseResp;
import com.upuphone.xr.sapp.monitor.schedule.model.RefreshTokenRespModel;
import com.upuphone.xr.sapp.monitor.schedule.model.ScheduleArrayRespModel;
import com.upuphone.xr.sapp.monitor.schedule.model.TokenRespModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\b2\b\b\u0001\u0010\t\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\nJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0010J4\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00032\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/request/ScheduleApi;", "", "getCalendar", "Lcom/upuphone/xr/sapp/monitor/schedule/model/BaseResp;", "Lcom/upuphone/xr/sapp/monitor/schedule/model/ScheduleArrayRespModel;", "body", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "accountId", "(Ljava/util/HashMap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "Lcom/upuphone/xr/sapp/monitor/schedule/model/TokenRespModel;", "type", "code", "getWay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lcom/upuphone/xr/sapp/monitor/schedule/model/RefreshTokenRespModel;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ScheduleApi {
    @POST("calendar/third/getInfo")
    @Nullable
    Object getCalendar(@NotNull @Body HashMap<String, Object> hashMap, @NotNull @Header("accountId") String str, @NotNull Continuation<? super BaseResp<ScheduleArrayRespModel>> continuation);

    @Nullable
    @GET("calendar/third/getToken")
    Object getToken(@NotNull @Query("type") String str, @NotNull @Query("code") String str2, @NotNull @Query("getWay") String str3, @NotNull Continuation<? super BaseResp<TokenRespModel>> continuation);

    @Nullable
    @GET("calendar/third/refreshToken")
    Object refreshToken(@NotNull @Query("type") String str, @NotNull @Query("refreshToken") String str2, @NotNull @Query("getWay") String str3, @NotNull Continuation<? super BaseResp<RefreshTokenRespModel>> continuation);
}
