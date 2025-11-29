package com.honey.account.module;

import android.content.Context;
import com.google.gson.GsonBuilder;
import com.honey.account.AccountHelper;
import com.honey.account.HoneyAccountManager;
import com.honey.account.api.AccountApiService;
import com.honey.account.api.LoginApiService;
import com.honey.account.api.TokenApiService;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.f2.a;
import com.honey.account.utils.system.DeviceUtilsKt;
import com.honey.account.utils.system.PackageUtilsKt;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import java.util.Locale;
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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/honey/account/module/NetworkModule;", "", "()V", "provideAccountApiService", "Lcom/honey/account/api/AccountApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideLoginApiService", "Lcom/honey/account/api/LoginApiService;", "provideRetrofit", "provideTokenApiService", "Lcom/honey/account/api/TokenApiService;", "CoreLibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        Context mApplicationContext = AccountHelper.INSTANCE.getMApplicationContext();
        Request request = chain.request();
        Request.Builder header = request.newBuilder().header(AccountConstantKt.REQUEST_HEADER_OS_VER, DeviceUtilsKt.getOsVersion()).header("model", DeviceUtilsKt.getModel()).header("brand", DeviceUtilsKt.getBrand());
        String packageName = mApplicationContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        Request.Builder header2 = header.header(AccountConstantKt.REQUEST_HEADER_PKG, packageName).header(AccountConstantKt.REQUEST_HEADER_APP_VER, PackageUtilsKt.getAppVersionName(mApplicationContext)).header(AccountConstantKt.REQUEST_HEADER_OAID, DeviceUtilsKt.getOaidOrOtherId(mApplicationContext)).header("devcie_id", DeviceUtilsKt.getOaidOrOtherId(mApplicationContext));
        return chain.proceed(header2.header("Accept-Language", Locale.getDefault().getLanguage() + '_' + Locale.getDefault().getCountry()).method(request.method(), request.body()).build());
    }

    @Singleton
    @NotNull
    @Provides
    public final AccountApiService provideAccountApiService(@NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(AccountApiService.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (AccountApiService) create;
    }

    @Singleton
    @NotNull
    @Provides
    public final LoginApiService provideLoginApiService(@NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(LoginApiService.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (LoginApiService) create;
    }

    @Singleton
    @NotNull
    @Provides
    public final Retrofit provideRetrofit() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null);
        BuildConfigProvider buildConfigProvider = HoneyAccountManager.Companion.getBuildConfigProvider();
        if (buildConfigProvider == null || !buildConfigProvider.isDebug()) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        Retrofit build = new Retrofit.Builder().baseUrl(AccountConstantKt.URL_OLOGIN_FLYME_SERVER).client(new OkHttpClient.Builder().addInterceptor(new a()).addInterceptor(httpLoggingInterceptor).build()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().registerTypeAdapterFactory(new NullOrEmptyTypeAdapterFactory()).create())).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @Singleton
    @NotNull
    @Provides
    public final TokenApiService provideTokenApiService(@NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object create = retrofit.create(TokenApiService.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (TokenApiService) create;
    }
}
