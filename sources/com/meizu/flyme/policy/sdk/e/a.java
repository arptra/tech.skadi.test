package com.meizu.flyme.policy.sdk.e;

import com.meizu.flyme.policy.sdk.bean.PolicyHistoryListResponse;
import com.meizu.flyme.policy.sdk.bean.PolicyNewestResponse;
import com.meizu.flyme.policy.sdk.bean.PolicyOperateRecordResponse;
import com.meizu.flyme.policy.sdk.bean.PolicyRecordRequest;
import com.meizu.flyme.policy.sdk.bean.PolicyVersionResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J{\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J{\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011Jq\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017Jq\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u001c\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/meizu/flyme/policy/sdk/api/IPolicyApiService;", "", "getPolicyUsingGET", "Lretrofit2/Response;", "Lcom/meizu/flyme/policy/sdk/bean/PolicyNewestResponse;", "appId", "", "appSign", "category", "reqTime", "", "language", "version", "brand", "model", "osVersion", "versionName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policyHistoryListUsingGET", "Lcom/meizu/flyme/policy/sdk/bean/PolicyHistoryListResponse;", "policyVersionInfoUsingGET", "Lcom/meizu/flyme/policy/sdk/bean/PolicyVersionResponse;", "versionId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadOperateRecordUsingPOST", "Lcom/meizu/flyme/policy/sdk/bean/PolicyOperateRecordResponse;", "policysdkRecordRequest", "Lcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;", "area", "(Ljava/lang/String;Ljava/lang/String;JLcom/meizu/flyme/policy/sdk/bean/PolicyRecordRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policysdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {
    @POST("internal/v1/operate/record")
    @Nullable
    Object a(@NotNull @Header("appId") String str, @NotNull @Header("appSign") String str2, @Header("reqTime") long j, @NotNull @Body PolicyRecordRequest policyRecordRequest, @NotNull @Header("X-brand") String str3, @NotNull @Header("X-model") String str4, @NotNull @Header("X-os-version") String str5, @NotNull @Header("X-version-name") String str6, @NotNull @Header("X-area") String str7, @NotNull Continuation<? super Response<PolicyOperateRecordResponse>> continuation);

    @Nullable
    @GET("internal/v1/version/{versionId}")
    Object a(@NotNull @Header("appId") String str, @NotNull @Header("appSign") String str2, @Header("reqTime") long j, @NotNull @Header("X-client-language") String str3, @Path("versionId") long j2, @NotNull @Header("X-brand") String str4, @NotNull @Header("X-model") String str5, @NotNull @Header("X-os-version") String str6, @NotNull @Header("X-version-name") String str7, @NotNull Continuation<? super Response<PolicyVersionResponse>> continuation);

    @Nullable
    @GET("internal/v1/policy")
    Object a(@NotNull @Header("appId") String str, @NotNull @Header("appSign") String str2, @NotNull @Query("category") String str3, @Header("reqTime") long j, @NotNull @Header("X-client-language") String str4, @Query("version") long j2, @NotNull @Header("X-brand") String str5, @NotNull @Header("X-model") String str6, @NotNull @Header("X-os-version") String str7, @NotNull @Header("X-version-name") String str8, @NotNull Continuation<? super Response<PolicyNewestResponse>> continuation);

    @Nullable
    @GET("internal/v1/history/list")
    Object b(@NotNull @Header("appId") String str, @NotNull @Header("appSign") String str2, @NotNull @Query("category") String str3, @Header("reqTime") long j, @NotNull @Header("X-client-language") String str4, @Query("version") long j2, @NotNull @Header("X-brand") String str5, @NotNull @Header("X-model") String str6, @NotNull @Header("X-os-version") String str7, @NotNull @Header("X-version-name") String str8, @NotNull Continuation<? super Response<PolicyHistoryListResponse>> continuation);
}
