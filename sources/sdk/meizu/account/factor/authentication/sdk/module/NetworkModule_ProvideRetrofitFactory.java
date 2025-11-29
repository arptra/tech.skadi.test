package sdk.meizu.account.factor.authentication.sdk.module;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import retrofit2.Retrofit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NetworkModule_ProvideRetrofitFactory INSTANCE = new NetworkModule_ProvideRetrofitFactory();

        private InstanceHolder() {
        }
    }

    public static NetworkModule_ProvideRetrofitFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Retrofit provideRetrofit() {
        return (Retrofit) Preconditions.d(NetworkModule.INSTANCE.provideRetrofit());
    }

    public Retrofit get() {
        return provideRetrofit();
    }
}
