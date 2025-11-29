package com.here.services;

import android.content.Context;
import android.os.Bundle;
import com.here.posclient.InitOptions;
import com.here.posclient.PositioningFeature;
import com.here.posclient.auth.AuthData;
import com.here.posclient.auth.AuthUtils;
import com.here.services.Api;
import com.here.services.common.Types;
import com.here.services.internal.CommonServiceController;
import com.here.services.internal.ServiceController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HereLocationApiClient {
    final CommonServiceController mCommonServiceController;

    public static class ClientOptions implements Api.ServiceOptions {
        AuthData mAuthData;

        public void put(Context context, Bundle bundle) {
            if (bundle != null) {
                AuthUtils.authDataToBundle(bundle, this.mAuthData);
                return;
            }
            throw new IllegalArgumentException("bundle is null");
        }

        public void setAuthData(AuthData authData) {
            this.mAuthData = authData;
        }

        private ClientOptions() {
        }
    }

    public interface ConnectionCallbacks {
        void onConnected();

        void onConnectionFailed(Reason reason);

        void onDisconnected();

        void onInitializationFailed(Api<? extends Api.Options> api);
    }

    public static class Options implements Api.ServiceOptions {
        boolean mCleanBeforeStart = false;
        boolean mDisableCrowdsourcing = false;
        boolean mDisableHdCrowdsourcing;
        boolean mDisableOfflinePositioning = false;
        boolean mEnableInstantCrowdsourcing = false;
        boolean mEnableSubprocessorEndpoint = true;
        String mLogPath;
        long mMobileDataLimitPerDay = -1;
        boolean mOfflineMode = false;
        Types.Storage mStorage = Types.Storage.Internal;

        public void put(Context context, Bundle bundle) {
            if (bundle != null) {
                bundle.putBoolean(InitOptions.KEY_OPTION_OFFLINE_MODE, this.mOfflineMode);
                bundle.putString(InitOptions.KEY_OPTION_RADIO_MAP_STORAGE, this.mStorage.name());
                bundle.putString(InitOptions.KEY_OPTION_LOG_PATH, this.mLogPath);
                bundle.putLong(InitOptions.KEY_OPTION_CELLULAR_LIMIT, this.mMobileDataLimitPerDay);
                bundle.putBoolean(InitOptions.KEY_OPTION_CLEAN, this.mCleanBeforeStart);
                bundle.putBoolean(InitOptions.KEY_OPTION_INSTANT_CROWDSOURCING, this.mEnableInstantCrowdsourcing);
                bundle.putBoolean(InitOptions.KEY_OPTION_NO_OFFLINE_POSITIONING, this.mDisableOfflinePositioning);
                bundle.putBoolean(InitOptions.KEY_OPTION_SUBPROCESSOR_ENDPOINT, this.mEnableSubprocessorEndpoint);
                return;
            }
            throw new IllegalArgumentException("bundle is null");
        }

        public Options setCleanBeforeStart(boolean z) {
            this.mCleanBeforeStart = z;
            return this;
        }

        public Options setDisableCrowdsourcing(boolean z) {
            this.mDisableCrowdsourcing = z;
            return this;
        }

        public Options setDisableHdCrowdsourcing(boolean z) {
            this.mDisableHdCrowdsourcing = z;
            return this;
        }

        public Options setDisableOfflinePositioning(boolean z) {
            this.mDisableOfflinePositioning = z;
            return this;
        }

        public Options setDownloadStorage(Types.Storage storage) {
            this.mStorage = storage;
            return this;
        }

        public Options setEnableInstantCrowdsourcing(boolean z) {
            this.mEnableInstantCrowdsourcing = z;
            return this;
        }

        public Options setEnableSubprocessorEndpoint(boolean z) {
            this.mEnableSubprocessorEndpoint = z;
            return this;
        }

        public Options setLogPath(String str) {
            this.mLogPath = str;
            return this;
        }

        public Options setMobileDataLimitPerDay(long j) {
            this.mMobileDataLimitPerDay = j;
            return this;
        }

        public Options setOfflineMode(boolean z) {
            this.mOfflineMode = z;
            return this;
        }
    }

    public enum Reason {
        ServiceInitializationError,
        ServiceConfigurationError,
        ServiceNotFound,
        PermissionDenied,
        ApiNotLicensed,
        ApiInitializationFailed,
        MissingPermissions,
        UserConsentNotGranted,
        ServiceUsageForbidden
    }

    public boolean changeOptions(Options options) {
        return this.mCommonServiceController.changeServiceOptions(options);
    }

    public void connect() {
        this.mCommonServiceController.startServiceAndConnect();
    }

    public void disconnect() {
        this.mCommonServiceController.stopServiceAndDisconnect();
    }

    public ServiceController getServiceController(Api<? extends Api.Options> api) {
        return this.mCommonServiceController.getServiceController(api);
    }

    public String getServiceVersion() {
        return this.mCommonServiceController.getServiceVersion();
    }

    public boolean isConnected() {
        return this.mCommonServiceController.isConnected();
    }

    public boolean updateUserConsentState(boolean z) {
        return this.mCommonServiceController.updateUserConsentState(z);
    }

    public static class Builder {
        Map<Api<? extends Api.Options>, Api.Options> mApis = new HashMap();
        final ClientOptions mClientOptions;
        final Context mContext;
        final ConnectionCallbacks mListener;
        Options mOptions = new Options();
        SdkOptions mSdkOptions;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks) {
            if (context == null) {
                throw new IllegalArgumentException("context is null");
            } else if (connectionCallbacks != null) {
                this.mContext = context;
                this.mClientOptions = new ClientOptions();
                this.mListener = connectionCallbacks;
            } else {
                throw new IllegalArgumentException("listener is null");
            }
        }

        private void checkDuplicateOptions(Options options, SdkOptions sdkOptions) {
            long j = sdkOptions.mEnabledFeatures;
            boolean z = false;
            boolean z2 = (PositioningFeature.Collector.value & j) != 0;
            if ((j & PositioningFeature.HDWifiCollector.value) != 0) {
                z = true;
            }
            if (options.mDisableCrowdsourcing && z2) {
                throw new IllegalArgumentException("SD crowdsourcing is disabled by Options, but enabled by SdkOptions");
            } else if (options.mDisableHdCrowdsourcing && z) {
                throw new IllegalArgumentException("HD crowdsourcing is disabled by Options, but enabled by SdkOptions");
            }
        }

        private void setOverrideOptions(Options options, SdkOptions sdkOptions) {
            if (options.mDisableCrowdsourcing) {
                sdkOptions.toggleCrowdsourcing(false);
                sdkOptions.mKeepCrowdsourcingFiles = false;
            }
            if (options.mDisableHdCrowdsourcing) {
                sdkOptions.toggleHdCrowdsourcing(false);
                sdkOptions.mKeepHdCrowdsourcingFiles = false;
            }
        }

        public Builder addApi(Api<? extends Api.Options.None> api) {
            if (api != null) {
                this.mApis.put(api, (Object) null);
                return this;
            }
            throw new IllegalArgumentException("api is null");
        }

        public HereLocationApiClient build() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mClientOptions);
            arrayList.add(this.mOptions);
            SdkOptions sdkOptions = this.mSdkOptions;
            if (sdkOptions == null) {
                this.mSdkOptions = new SdkOptions();
            } else {
                checkDuplicateOptions(this.mOptions, sdkOptions);
            }
            setOverrideOptions(this.mOptions, this.mSdkOptions);
            arrayList.add(this.mSdkOptions);
            return new HereLocationApiClient(this.mContext, arrayList, this.mListener, this.mApis);
        }

        public Builder setAuthData(AuthData authData) {
            this.mClientOptions.setAuthData(authData);
            return this;
        }

        public Builder setOptions(Options options) {
            if (options != null) {
                this.mOptions = options;
                return this;
            }
            throw new IllegalArgumentException("options is null");
        }

        public Builder setSdkOptions(SdkOptions sdkOptions) {
            if (sdkOptions != null) {
                this.mSdkOptions = sdkOptions;
                return this;
            }
            throw new IllegalArgumentException("options is null");
        }

        public Builder addApi(Api<? extends Api.Options.Optional> api, Api.Options.Optional optional) {
            if (api != null) {
                this.mApis.put(api, optional);
                return this;
            }
            throw new IllegalArgumentException("api is null");
        }

        public Builder addApi(Api<? extends Api.Options.Required> api, Api.Options.Required required) {
            if (api == null) {
                throw new IllegalArgumentException("api is null");
            } else if (required != null) {
                this.mApis.put(api, required);
                return this;
            } else {
                throw new IllegalArgumentException("required options is null");
            }
        }
    }

    private HereLocationApiClient(Context context, List<Api.ServiceOptions> list, ConnectionCallbacks connectionCallbacks, Map<Api<? extends Api.Options>, Api.Options> map) {
        this.mCommonServiceController = new CommonServiceController(context, list, connectionCallbacks, map);
    }

    public static class SdkOptions implements Api.ServiceOptions {
        long mEnabledFeatures;
        long mHttpAdaptationPointer;
        boolean mKeepCrowdsourcingFiles;
        boolean mKeepHdCrowdsourcingFiles;

        public SdkOptions() {
            this.mKeepCrowdsourcingFiles = true;
            this.mKeepHdCrowdsourcingFiles = true;
            this.mEnabledFeatures = PositioningFeature.All.value;
        }

        public void put(Context context, Bundle bundle) {
            if (bundle != null) {
                bundle.putLong(InitOptions.KEY_OPTION_FEATURES, this.mEnabledFeatures);
                bundle.putBoolean(InitOptions.KEY_OPTION_KEEP_COLLECTOR_FILES, this.mKeepCrowdsourcingFiles);
                bundle.putBoolean(InitOptions.KEY_OPTION_KEEP_HDWIFI_COLLECTOR_FILES, this.mKeepHdCrowdsourcingFiles);
                long j = this.mHttpAdaptationPointer;
                if (j != 0) {
                    bundle.putLong(InitOptions.KEY_OPTION_HTTP_ADAPTATION_PTR, j);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("bundle is null");
        }

        public SdkOptions setHttpAdaptation(long j) {
            this.mHttpAdaptationPointer = j;
            return this;
        }

        public SdkOptions toggleCrowdsourcing(boolean z) {
            toggleFeature(PositioningFeature.Collector.value, z);
            return this;
        }

        public SdkOptions toggleFeature(long j, boolean z) {
            if (z) {
                this.mEnabledFeatures = j | this.mEnabledFeatures;
            } else {
                this.mEnabledFeatures = (~j) & this.mEnabledFeatures;
            }
            return this;
        }

        public SdkOptions toggleHdCrowdsourcing(boolean z) {
            toggleFeature(PositioningFeature.HDWifiCollector.value, z);
            return this;
        }

        public SdkOptions(long j) {
            this.mKeepCrowdsourcingFiles = true;
            this.mKeepHdCrowdsourcingFiles = true;
            this.mEnabledFeatures = j;
        }
    }
}
