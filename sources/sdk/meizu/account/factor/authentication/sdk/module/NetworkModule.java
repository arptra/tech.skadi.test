package sdk.meizu.account.factor.authentication.sdk.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.honey.account.vc.a;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import java.util.Locale;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivityKt;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;
import sdk.meizu.account.factor.authentication.sdk.api.CaptchaApiService;
import sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService;
import sdk.meizu.account.factor.authentication.sdk.constant.NetworkParamsKt;
import sdk.meizu.account.factor.authentication.sdk.data.ResponseValidateData;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/module/NetworkModule;", "", "()V", "provideApiService", "Lsdk/meizu/account/factor/authentication/sdk/api/FactorAuthenticationService;", "retrofit", "Lretrofit2/Retrofit;", "provideGeetestService", "Lsdk/meizu/account/factor/authentication/sdk/api/CaptchaApiService;", "provideRetrofit", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@InstallIn({SingletonComponent.class})
@Module
public final class NetworkModule {
    @NotNull
    public static final NetworkModule INSTANCE = new NetworkModule();

    private NetworkModule() {
    }

    /* access modifiers changed from: private */
    public static final Response provideRetrofit$lambda$1(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder header = request.newBuilder().header(NetworkParamsKt.HEADER_TYPE, "android").header(NetworkParamsKt.HEADER_PACKAGE_NAME, FactorAuthenticationActivityKt.getParamPackageName()).header(NetworkParamsKt.HEADER_SERVICE_NAME, FactorAuthenticationActivityKt.getParamServiceName());
        return chain.proceed(header.header("Accept-Language", Locale.getDefault().getLanguage() + '_' + Locale.getDefault().getCountry()).method(request.method(), request.body()).build());
    }

    @Singleton
    @NotNull
    @Provides
    public final FactorAuthenticationService provideApiService(@NotNull @Named Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(FactorAuthenticationService.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (FactorAuthenticationService) create;
    }

    @Singleton
    @NotNull
    @Provides
    public final CaptchaApiService provideGeetestService(@NotNull @Named Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(CaptchaApiService.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (CaptchaApiService) create;
    }

    @Named
    @Singleton
    @NotNull
    @Provides
    public final Retrofit provideRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        FactorAuthenticationUtil factorAuthenticationUtil = FactorAuthenticationUtil.INSTANCE;
        BuildConfigProvider buildConfigProvider = factorAuthenticationUtil.getBuildConfigProvider();
        if (buildConfigProvider == null || !buildConfigProvider.isDebug()) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new a()).addInterceptor(httpLoggingInterceptor).build();
        Gson create = new GsonBuilder().registerTypeAdapterFactory(new NullOrEmptyTypeAdapterFactory()).registerTypeAdapter(ResponseValidateData.class, new ResponseValidateDataDeserializer()).create();
        Retrofit.Builder builder = new Retrofit.Builder();
        BuildConfigProvider buildConfigProvider2 = factorAuthenticationUtil.getBuildConfigProvider();
        Retrofit build2 = builder.baseUrl((buildConfigProvider2 == null || !buildConfigProvider2.isOverseas()) ? "https://i.flyme.cn/uc/" : "https://i.in.meizu.com/uc/").client(build).addConverterFactory(GsonConverterFactory.create(create)).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        return build2;
    }
}
