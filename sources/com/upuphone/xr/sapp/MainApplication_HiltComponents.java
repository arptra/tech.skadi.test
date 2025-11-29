package com.upuphone.xr.sapp;

import com.honey.account.view.PersonalInfoActivity_GeneratedInjector;
import com.honey.account.view.home.AccountHomepageActivity_GeneratedInjector;
import com.honey.account.view.login.pwd.PasswordLoginActivity_GeneratedInjector;
import com.honey.account.view.login.validate.ValidateAccountActivity_GeneratedInjector;
import com.honey.account.view.login.vcode.VCodeLoginActivity_GeneratedInjector;
import com.honey.account.view.web.WebActivity_GeneratedInjector;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.inject.Singleton;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationActivity_GeneratedInjector;
import sdk.meizu.account.factor.authentication.sdk.fragment.answer.AnswerFragment_GeneratedInjector;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.PasswordFragment_GeneratedInjector;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateAllFragment_GeneratedInjector;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.VerificationCodeFragment_GeneratedInjector;
import sdk.meizu.account.factor.authentication.sdk.fragment.login_account.LoginAccountFragment_GeneratedInjector;
import sdk.meizu.account.factor.authentication.sdk.view.PasswordEditLayout_GeneratedInjector;
import sdk.meizu.account.factor.authentication.sdk.view.VCodeEditLayout_GeneratedInjector;

public final class MainApplication_HiltComponents {

    @Subcomponent
    @ActivityScoped
    public static abstract class ActivityC implements PersonalInfoActivity_GeneratedInjector, AccountHomepageActivity_GeneratedInjector, PasswordLoginActivity_GeneratedInjector, ValidateAccountActivity_GeneratedInjector, VCodeLoginActivity_GeneratedInjector, WebActivity_GeneratedInjector, ActivityComponent, DefaultViewModelFactories.ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, FragmentComponentManager.FragmentComponentBuilderEntryPoint, ViewComponentManager.ViewComponentBuilderEntryPoint, GeneratedComponent, FactorAuthenticationActivity_GeneratedInjector {

        @Subcomponent.Builder
        public interface Builder extends ActivityComponentBuilder {
        }
    }

    @DisableInstallInCheck
    @Module
    public interface ActivityCBuilderModule {
    }

    @Subcomponent
    @ActivityRetainedScoped
    public static abstract class ActivityRetainedC implements ActivityRetainedComponent, ActivityComponentManager.ActivityComponentBuilderEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        public interface Builder extends ActivityRetainedComponentBuilder {
        }
    }

    @DisableInstallInCheck
    @Module
    public interface ActivityRetainedCBuilderModule {
    }

    @Subcomponent
    @FragmentScoped
    public static abstract class FragmentC implements FragmentComponent, DefaultViewModelFactories.FragmentEntryPoint, ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint, GeneratedComponent, AnswerFragment_GeneratedInjector, PasswordFragment_GeneratedInjector, ValidateAllFragment_GeneratedInjector, VerificationCodeFragment_GeneratedInjector, LoginAccountFragment_GeneratedInjector {

        @Subcomponent.Builder
        public interface Builder extends FragmentComponentBuilder {
        }
    }

    @DisableInstallInCheck
    @Module
    public interface FragmentCBuilderModule {
    }

    @Subcomponent
    @ServiceScoped
    public static abstract class ServiceC implements ServiceComponent, GeneratedComponent {

        @Subcomponent.Builder
        public interface Builder extends ServiceComponentBuilder {
        }
    }

    @DisableInstallInCheck
    @Module
    public interface ServiceCBuilderModule {
    }

    @Component
    @Singleton
    public static abstract class SingletonC implements MainApplication_GeneratedInjector, FragmentGetContextFix.FragmentGetContextFixEntryPoint, HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent {
        public abstract /* synthetic */ void injectMainApplication(MainApplication mainApplication);
    }

    @Subcomponent
    @ViewScoped
    public static abstract class ViewC implements ViewComponent, GeneratedComponent, PasswordEditLayout_GeneratedInjector, VCodeEditLayout_GeneratedInjector {

        @Subcomponent.Builder
        public interface Builder extends ViewComponentBuilder {
        }
    }

    @DisableInstallInCheck
    @Module
    public interface ViewCBuilderModule {
    }

    @Subcomponent
    @ViewModelScoped
    public static abstract class ViewModelC implements ViewModelComponent, HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        public interface Builder extends ViewModelComponentBuilder {
        }
    }

    @DisableInstallInCheck
    @Module
    public interface ViewModelCBuilderModule {
    }

    @Subcomponent
    @ViewScoped
    public static abstract class ViewWithFragmentC implements ViewWithFragmentComponent, GeneratedComponent {

        @Subcomponent.Builder
        public interface Builder extends ViewWithFragmentComponentBuilder {
        }
    }

    @DisableInstallInCheck
    @Module
    public interface ViewWithFragmentCBuilderModule {
    }
}
