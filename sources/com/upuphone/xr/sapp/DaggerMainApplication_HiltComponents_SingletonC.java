package com.upuphone.xr.sapp;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.honey.account.api.AccountApiService;
import com.honey.account.api.LoginApiService;
import com.honey.account.api.TokenApiService;
import com.honey.account.module.NetworkModule_ProvideAccountApiServiceFactory;
import com.honey.account.module.NetworkModule_ProvideLoginApiServiceFactory;
import com.honey.account.module.NetworkModule_ProvideRetrofitFactory;
import com.honey.account.module.NetworkModule_ProvideTokenApiServiceFactory;
import com.honey.account.view.PersonalInfoActivity;
import com.honey.account.view.home.AccountHomepageActivity;
import com.honey.account.view.home.AccountHomepageViewModel;
import com.honey.account.view.home.AccountHomepageViewModel_HiltModules;
import com.honey.account.view.home.AccountRepository;
import com.honey.account.view.login.base.VerificationCodeViewModel;
import com.honey.account.view.login.base.VerificationCodeViewModel_HiltModules;
import com.honey.account.view.login.pwd.PasswordLoginActivity;
import com.honey.account.view.login.repository.LoginRepository;
import com.honey.account.view.login.validate.ValidateAccountActivity;
import com.honey.account.view.login.validate.ValidateAccountViewModel;
import com.honey.account.view.login.validate.ValidateAccountViewModel_HiltModules;
import com.honey.account.view.login.vcode.VCodeLoginActivity;
import com.honey.account.view.oauth.TokenRepository;
import com.honey.account.view.web.WebActivity;
import com.upuphone.xr.sapp.MainApplication_HiltComponents;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ActivityModule_ProvideFragmentActivityFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import java.util.Map;
import java.util.Set;
import retrofit2.Retrofit;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity_MembersInjector;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel_HiltModules;
import sdk.meizu.account.factor.authentication.sdk.api.FactorAuthenticationService;
import sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.BasicAuthenticationFragment_MembersInjector;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.PasswordFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment_MembersInjector;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel_HiltModules;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeFragment;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel_HiltModules;
import sdk.meizu.account.factor.authentication.sdk.fragment.login_account.LoginAccountFragment;
import sdk.meizu.account.factor.authentication.sdk.module.NetworkModule_ProvideApiServiceFactory;
import sdk.meizu.account.factor.authentication.sdk.navigator.AuthenticationNavigatorImpl;
import sdk.meizu.account.factor.authentication.sdk.repository.FactorAuthenticationRepository;
import sdk.meizu.account.factor.authentication.sdk.view.PasswordEditLayout;
import sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout;

@DaggerGenerated
public final class DaggerMainApplication_HiltComponents_SingletonC {

    public static final class ActivityCBuilder implements MainApplication_HiltComponents.ActivityC.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final SingletonCImpl f6576a;
        public final ActivityRetainedCImpl b;
        public Activity c;

        /* renamed from: a */
        public ActivityCBuilder activity(Activity activity) {
            this.c = (Activity) Preconditions.b(activity);
            return this;
        }

        /* renamed from: b */
        public MainApplication_HiltComponents.ActivityC build() {
            Preconditions.a(this.c, Activity.class);
            return new ActivityCImpl(this.f6576a, this.b, this.c);
        }

        public ActivityCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.f6576a = singletonCImpl;
            this.b = activityRetainedCImpl;
        }
    }

    public static final class ActivityCImpl extends MainApplication_HiltComponents.ActivityC {
        /* access modifiers changed from: private */
        public final Activity activity;
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<FragmentActivity> provideFragmentActivityProvider;
        private final SingletonCImpl singletonCImpl;

        @IdentifierNameString
        public static final class LazyClassKeyProvider {

            /* renamed from: a  reason: collision with root package name */
            public static String f6577a = "com.honey.account.view.home.AccountHomepageViewModel";
            public static String b = "sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel";
            public static String c = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel";
            public static String d = "com.honey.account.view.login.base.VerificationCodeViewModel";
            public static String e = "com.honey.account.view.login.validate.ValidateAccountViewModel";
            public static String f = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel";
        }

        public static final class SwitchingProvider<T> implements Provider<T> {

            /* renamed from: a  reason: collision with root package name */
            public final SingletonCImpl f6578a;
            public final ActivityRetainedCImpl b;
            public final ActivityCImpl c;
            public final int d;

            public SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, int i) {
                this.f6578a = singletonCImpl;
                this.b = activityRetainedCImpl;
                this.c = activityCImpl;
                this.d = i;
            }

            public Object get() {
                if (this.d == 0) {
                    return ActivityModule_ProvideFragmentActivityFactory.provideFragmentActivity(this.c.activity);
                }
                throw new AssertionError(this.d);
            }
        }

        /* access modifiers changed from: private */
        public AuthenticationNavigatorImpl authenticationNavigatorImpl() {
            return new AuthenticationNavigatorImpl((FragmentActivity) this.provideFragmentActivityProvider.get());
        }

        private void initialize(Activity activity2) {
            this.provideFragmentActivityProvider = SingleCheck.a(new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 0));
        }

        @CanIgnoreReturnValue
        private FactorAuthenticationActivity injectFactorAuthenticationActivity2(FactorAuthenticationActivity factorAuthenticationActivity) {
            FactorAuthenticationActivity_MembersInjector.injectNavigator(factorAuthenticationActivity, authenticationNavigatorImpl());
            return factorAuthenticationActivity;
        }

        public FragmentComponentBuilder fragmentComponentBuilder() {
            return new FragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl));
        }

        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        public Map<Class<?>, Boolean> getViewModelKeys() {
            return LazyClassKeyMap.a(ImmutableMap.builderWithExpectedSize(6).put(LazyClassKeyProvider.f6577a, Boolean.valueOf(AccountHomepageViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.b, Boolean.valueOf(FactorAuthenticationViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.e, Boolean.valueOf(ValidateAccountViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.c, Boolean.valueOf(ValidateViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.d, Boolean.valueOf(VerificationCodeViewModel_HiltModules.KeyModule.provide())).put(LazyClassKeyProvider.f, Boolean.valueOf(VerificationCodeViewModel_HiltModules.KeyModule.provide())).build());
        }

        public void injectAccountHomepageActivity(AccountHomepageActivity accountHomepageActivity) {
        }

        public void injectFactorAuthenticationActivity(FactorAuthenticationActivity factorAuthenticationActivity) {
            injectFactorAuthenticationActivity2(factorAuthenticationActivity);
        }

        public void injectPasswordLoginActivity(PasswordLoginActivity passwordLoginActivity) {
        }

        public void injectPersonalInfoActivity(PersonalInfoActivity personalInfoActivity) {
        }

        public void injectVCodeLoginActivity(VCodeLoginActivity vCodeLoginActivity) {
        }

        public void injectValidateAccountActivity(ValidateAccountActivity validateAccountActivity) {
        }

        public void injectWebActivity(WebActivity webActivity) {
        }

        public ViewComponentBuilder viewComponentBuilder() {
            return new ViewCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        private ActivityCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, Activity activity2) {
            this.activityCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activity = activity2;
            initialize(activity2);
        }
    }

    public static final class ActivityRetainedCBuilder implements MainApplication_HiltComponents.ActivityRetainedC.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final SingletonCImpl f6579a;
        public SavedStateHandleHolder b;

        /* renamed from: a */
        public MainApplication_HiltComponents.ActivityRetainedC build() {
            Preconditions.a(this.b, SavedStateHandleHolder.class);
            return new ActivityRetainedCImpl(this.f6579a, this.b);
        }

        /* renamed from: b */
        public ActivityRetainedCBuilder savedStateHandleHolder(SavedStateHandleHolder savedStateHandleHolder) {
            this.b = (SavedStateHandleHolder) Preconditions.b(savedStateHandleHolder);
            return this;
        }

        public ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
            this.f6579a = singletonCImpl;
        }
    }

    public static final class ActivityRetainedCImpl extends MainApplication_HiltComponents.ActivityRetainedC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;
        private final SingletonCImpl singletonCImpl;

        public static final class SwitchingProvider<T> implements Provider<T> {

            /* renamed from: a  reason: collision with root package name */
            public final SingletonCImpl f6580a;
            public final ActivityRetainedCImpl b;
            public final int c;

            public SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, int i) {
                this.f6580a = singletonCImpl;
                this.b = activityRetainedCImpl;
                this.c = i;
            }

            public Object get() {
                if (this.c == 0) {
                    return ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();
                }
                throw new AssertionError(this.c);
            }
        }

        private void initialize(SavedStateHandleHolder savedStateHandleHolder) {
            this.provideActivityRetainedLifecycleProvider = DoubleCheck.b(new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 0));
        }

        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return (ActivityRetainedLifecycle) this.provideActivityRetainedLifecycleProvider.get();
        }

        private ActivityRetainedCImpl(SingletonCImpl singletonCImpl2, SavedStateHandleHolder savedStateHandleHolder) {
            this.activityRetainedCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            initialize(savedStateHandleHolder);
        }
    }

    public static final class Builder {
        public Builder a(ApplicationContextModule applicationContextModule) {
            Preconditions.b(applicationContextModule);
            return this;
        }

        public MainApplication_HiltComponents.SingletonC b() {
            return new SingletonCImpl();
        }

        public Builder() {
        }
    }

    public static final class FragmentCBuilder implements MainApplication_HiltComponents.FragmentC.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final SingletonCImpl f6581a;
        public final ActivityRetainedCImpl b;
        public final ActivityCImpl c;
        public Fragment d;

        /* renamed from: a */
        public MainApplication_HiltComponents.FragmentC build() {
            Preconditions.a(this.d, Fragment.class);
            return new FragmentCImpl(this.f6581a, this.b, this.c, this.d);
        }

        /* renamed from: b */
        public FragmentCBuilder fragment(Fragment fragment) {
            this.d = (Fragment) Preconditions.b(fragment);
            return this;
        }

        public FragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.f6581a = singletonCImpl;
            this.b = activityRetainedCImpl;
            this.c = activityCImpl;
        }
    }

    public static final class FragmentCImpl extends MainApplication_HiltComponents.FragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;

        @CanIgnoreReturnValue
        private PasswordFragment injectPasswordFragment2(PasswordFragment passwordFragment) {
            BasicAuthenticationFragment_MembersInjector.injectNavigator(passwordFragment, this.activityCImpl.authenticationNavigatorImpl());
            return passwordFragment;
        }

        @CanIgnoreReturnValue
        private ValidateAllFragment injectValidateAllFragment2(ValidateAllFragment validateAllFragment) {
            ValidateAllFragment_MembersInjector.injectNavigator(validateAllFragment, this.activityCImpl.authenticationNavigatorImpl());
            return validateAllFragment;
        }

        @CanIgnoreReturnValue
        private VerificationCodeFragment injectVerificationCodeFragment2(VerificationCodeFragment verificationCodeFragment) {
            BasicAuthenticationFragment_MembersInjector.injectNavigator(verificationCodeFragment, this.activityCImpl.authenticationNavigatorImpl());
            return verificationCodeFragment;
        }

        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return this.activityCImpl.getHiltInternalFactoryFactory();
        }

        public void injectAnswerFragment(AnswerFragment answerFragment) {
        }

        public void injectLoginAccountFragment(LoginAccountFragment loginAccountFragment) {
        }

        public void injectPasswordFragment(PasswordFragment passwordFragment) {
            injectPasswordFragment2(passwordFragment);
        }

        public void injectValidateAllFragment(ValidateAllFragment validateAllFragment) {
            injectValidateAllFragment2(validateAllFragment);
        }

        public void injectVerificationCodeFragment(VerificationCodeFragment verificationCodeFragment) {
            injectVerificationCodeFragment2(verificationCodeFragment);
        }

        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
            return new ViewWithFragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
        }

        private FragmentCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, Fragment fragment) {
            this.fragmentCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }
    }

    public static final class ServiceCBuilder implements MainApplication_HiltComponents.ServiceC.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final SingletonCImpl f6582a;
        public Service b;

        /* renamed from: a */
        public MainApplication_HiltComponents.ServiceC build() {
            Preconditions.a(this.b, Service.class);
            return new ServiceCImpl(this.f6582a, this.b);
        }

        /* renamed from: b */
        public ServiceCBuilder service(Service service) {
            this.b = (Service) Preconditions.b(service);
            return this;
        }

        public ServiceCBuilder(SingletonCImpl singletonCImpl) {
            this.f6582a = singletonCImpl;
        }
    }

    public static final class ServiceCImpl extends MainApplication_HiltComponents.ServiceC {
        private final ServiceCImpl serviceCImpl;
        private final SingletonCImpl singletonCImpl;

        private ServiceCImpl(SingletonCImpl singletonCImpl2, Service service) {
            this.serviceCImpl = this;
            this.singletonCImpl = singletonCImpl2;
        }
    }

    public static final class SingletonCImpl extends MainApplication_HiltComponents.SingletonC {
        /* access modifiers changed from: private */
        public Provider<AccountApiService> provideAccountApiServiceProvider;
        /* access modifiers changed from: private */
        public Provider<FactorAuthenticationService> provideApiServiceProvider;
        /* access modifiers changed from: private */
        public Provider<LoginApiService> provideLoginApiServiceProvider;
        /* access modifiers changed from: private */
        public Provider<Retrofit> provideRetrofitProvider;
        /* access modifiers changed from: private */
        public Provider<Retrofit> provideRetrofitProvider2;
        /* access modifiers changed from: private */
        public Provider<TokenApiService> provideTokenApiServiceProvider;
        private final SingletonCImpl singletonCImpl;

        public static final class SwitchingProvider<T> implements Provider<T> {

            /* renamed from: a  reason: collision with root package name */
            public final SingletonCImpl f6583a;
            public final int b;

            public SwitchingProvider(SingletonCImpl singletonCImpl, int i) {
                this.f6583a = singletonCImpl;
                this.b = i;
            }

            public Object get() {
                int i = this.b;
                if (i == 0) {
                    return NetworkModule_ProvideAccountApiServiceFactory.provideAccountApiService((Retrofit) this.f6583a.provideRetrofitProvider.get());
                }
                if (i == 1) {
                    return NetworkModule_ProvideRetrofitFactory.provideRetrofit();
                }
                if (i == 2) {
                    return NetworkModule_ProvideTokenApiServiceFactory.provideTokenApiService((Retrofit) this.f6583a.provideRetrofitProvider.get());
                }
                if (i == 3) {
                    return NetworkModule_ProvideApiServiceFactory.provideApiService((Retrofit) this.f6583a.provideRetrofitProvider2.get());
                }
                if (i == 4) {
                    return sdk.meizu.account.factor.authentication.sdk.module.NetworkModule_ProvideRetrofitFactory.provideRetrofit();
                }
                if (i == 5) {
                    return NetworkModule_ProvideLoginApiServiceFactory.provideLoginApiService((Retrofit) this.f6583a.provideRetrofitProvider.get());
                }
                throw new AssertionError(this.b);
            }
        }

        private void initialize() {
            this.provideRetrofitProvider = DoubleCheck.b(new SwitchingProvider(this.singletonCImpl, 1));
            this.provideAccountApiServiceProvider = DoubleCheck.b(new SwitchingProvider(this.singletonCImpl, 0));
            this.provideTokenApiServiceProvider = DoubleCheck.b(new SwitchingProvider(this.singletonCImpl, 2));
            this.provideRetrofitProvider2 = DoubleCheck.b(new SwitchingProvider(this.singletonCImpl, 4));
            this.provideApiServiceProvider = DoubleCheck.b(new SwitchingProvider(this.singletonCImpl, 3));
            this.provideLoginApiServiceProvider = DoubleCheck.b(new SwitchingProvider(this.singletonCImpl, 5));
        }

        public Set<Boolean> getDisableFragmentGetContextFix() {
            return ImmutableSet.of();
        }

        public void injectMainApplication(MainApplication mainApplication) {
        }

        public ActivityRetainedComponentBuilder retainedComponentBuilder() {
            return new ActivityRetainedCBuilder(this.singletonCImpl);
        }

        public ServiceComponentBuilder serviceComponentBuilder() {
            return new ServiceCBuilder(this.singletonCImpl);
        }

        private SingletonCImpl() {
            this.singletonCImpl = this;
            initialize();
        }
    }

    public static final class ViewCBuilder implements MainApplication_HiltComponents.ViewC.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final SingletonCImpl f6584a;
        public final ActivityRetainedCImpl b;
        public final ActivityCImpl c;
        public View d;

        /* renamed from: a */
        public MainApplication_HiltComponents.ViewC build() {
            Preconditions.a(this.d, View.class);
            return new ViewCImpl(this.f6584a, this.b, this.c, this.d);
        }

        /* renamed from: b */
        public ViewCBuilder view(View view) {
            this.d = (View) Preconditions.b(view);
            return this;
        }

        public ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.f6584a = singletonCImpl;
            this.b = activityRetainedCImpl;
            this.c = activityCImpl;
        }
    }

    public static final class ViewCImpl extends MainApplication_HiltComponents.ViewC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewCImpl viewCImpl;

        public void injectPasswordEditLayout(PasswordEditLayout passwordEditLayout) {
        }

        public void injectVCodeEditLayout(VCodeEditLayout vCodeEditLayout) {
        }

        private ViewCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, View view) {
            this.viewCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }
    }

    public static final class ViewModelCBuilder implements MainApplication_HiltComponents.ViewModelC.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final SingletonCImpl f6585a;
        public final ActivityRetainedCImpl b;
        public SavedStateHandle c;
        public ViewModelLifecycle d;

        /* renamed from: a */
        public MainApplication_HiltComponents.ViewModelC build() {
            Preconditions.a(this.c, SavedStateHandle.class);
            Preconditions.a(this.d, ViewModelLifecycle.class);
            return new ViewModelCImpl(this.f6585a, this.b, this.c, this.d);
        }

        /* renamed from: b */
        public ViewModelCBuilder savedStateHandle(SavedStateHandle savedStateHandle) {
            this.c = (SavedStateHandle) Preconditions.b(savedStateHandle);
            return this;
        }

        /* renamed from: c */
        public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
            this.d = (ViewModelLifecycle) Preconditions.b(viewModelLifecycle);
            return this;
        }

        public ViewModelCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.f6585a = singletonCImpl;
            this.b = activityRetainedCImpl;
        }
    }

    public static final class ViewModelCImpl extends MainApplication_HiltComponents.ViewModelC {
        private Provider<AccountHomepageViewModel> accountHomepageViewModelProvider;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<FactorAuthenticationViewModel> factorAuthenticationViewModelProvider;
        private final SingletonCImpl singletonCImpl;
        private Provider<ValidateAccountViewModel> validateAccountViewModelProvider;
        private Provider<ValidateViewModel> validateViewModelProvider;
        private Provider<VerificationCodeViewModel> verificationCodeViewModelProvider;
        private Provider<sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel> verificationCodeViewModelProvider2;
        private final ViewModelCImpl viewModelCImpl;

        @IdentifierNameString
        public static final class LazyClassKeyProvider {

            /* renamed from: a  reason: collision with root package name */
            public static String f6586a = "com.honey.account.view.home.AccountHomepageViewModel";
            public static String b = "sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel";
            public static String c = "com.honey.account.view.login.base.VerificationCodeViewModel";
            public static String d = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel";
            public static String e = "com.honey.account.view.login.validate.ValidateAccountViewModel";
            public static String f = "sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel";
        }

        public static final class SwitchingProvider<T> implements Provider<T> {

            /* renamed from: a  reason: collision with root package name */
            public final SingletonCImpl f6587a;
            public final ActivityRetainedCImpl b;
            public final ViewModelCImpl c;
            public final int d;

            public SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int i) {
                this.f6587a = singletonCImpl;
                this.b = activityRetainedCImpl;
                this.c = viewModelCImpl;
                this.d = i;
            }

            public Object get() {
                int i = this.d;
                if (i == 0) {
                    return new AccountHomepageViewModel(this.c.accountRepository(), this.c.tokenRepository());
                }
                if (i == 1) {
                    return new FactorAuthenticationViewModel(this.c.factorAuthenticationRepository());
                }
                if (i == 2) {
                    return new ValidateAccountViewModel(this.c.loginRepository(), this.c.tokenRepository());
                }
                if (i == 3) {
                    return new ValidateViewModel(this.c.factorAuthenticationRepository());
                }
                if (i == 4) {
                    return new VerificationCodeViewModel(this.c.loginRepository());
                }
                if (i == 5) {
                    return new sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeViewModel(this.c.factorAuthenticationRepository());
                }
                throw new AssertionError(this.d);
            }
        }

        /* access modifiers changed from: private */
        public AccountRepository accountRepository() {
            return new AccountRepository((AccountApiService) this.singletonCImpl.provideAccountApiServiceProvider.get());
        }

        /* access modifiers changed from: private */
        public FactorAuthenticationRepository factorAuthenticationRepository() {
            return new FactorAuthenticationRepository((FactorAuthenticationService) this.singletonCImpl.provideApiServiceProvider.get());
        }

        private void initialize(SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.accountHomepageViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.factorAuthenticationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 1);
            this.validateAccountViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 2);
            this.validateViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 3);
            this.verificationCodeViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 4);
            this.verificationCodeViewModelProvider2 = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 5);
        }

        /* access modifiers changed from: private */
        public LoginRepository loginRepository() {
            return new LoginRepository((LoginApiService) this.singletonCImpl.provideLoginApiServiceProvider.get());
        }

        /* access modifiers changed from: private */
        public TokenRepository tokenRepository() {
            return new TokenRepository((TokenApiService) this.singletonCImpl.provideTokenApiServiceProvider.get());
        }

        public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
            return ImmutableMap.of();
        }

        public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
            return LazyClassKeyMap.a(ImmutableMap.builderWithExpectedSize(6).put(LazyClassKeyProvider.f6586a, this.accountHomepageViewModelProvider).put(LazyClassKeyProvider.b, this.factorAuthenticationViewModelProvider).put(LazyClassKeyProvider.e, this.validateAccountViewModelProvider).put(LazyClassKeyProvider.f, this.validateViewModelProvider).put(LazyClassKeyProvider.c, this.verificationCodeViewModelProvider).put(LazyClassKeyProvider.d, this.verificationCodeViewModelProvider2).build());
        }

        private ViewModelCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, SavedStateHandle savedStateHandle, ViewModelLifecycle viewModelLifecycle) {
            this.viewModelCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            initialize(savedStateHandle, viewModelLifecycle);
        }
    }

    public static final class ViewWithFragmentCBuilder implements MainApplication_HiltComponents.ViewWithFragmentC.Builder {

        /* renamed from: a  reason: collision with root package name */
        public final SingletonCImpl f6588a;
        public final ActivityRetainedCImpl b;
        public final ActivityCImpl c;
        public final FragmentCImpl d;
        public View e;

        /* renamed from: a */
        public MainApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.a(this.e, View.class);
            return new ViewWithFragmentCImpl(this.f6588a, this.b, this.c, this.d, this.e);
        }

        /* renamed from: b */
        public ViewWithFragmentCBuilder view(View view) {
            this.e = (View) Preconditions.b(view);
            return this;
        }

        public ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl) {
            this.f6588a = singletonCImpl;
            this.b = activityRetainedCImpl;
            this.c = activityCImpl;
            this.d = fragmentCImpl;
        }
    }

    public static final class ViewWithFragmentCImpl extends MainApplication_HiltComponents.ViewWithFragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewWithFragmentCImpl viewWithFragmentCImpl;

        private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, FragmentCImpl fragmentCImpl2, View view) {
            this.viewWithFragmentCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
            this.fragmentCImpl = fragmentCImpl2;
        }
    }

    public static Builder a() {
        return new Builder();
    }
}
