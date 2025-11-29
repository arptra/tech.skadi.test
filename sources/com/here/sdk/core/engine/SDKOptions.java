package com.here.sdk.core.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.sdk.core.SDKLibraryLoader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class SDKOptions {
    static final SDKLibraryLoader LIBRARY_LOADER = new SDKLibraryLoader("SDK");
    @NonNull
    public String accessKeyId;
    @NonNull
    public String accessKeySecret;
    @NonNull
    public ActionOnCacheLock actionOnCacheLock;
    @NonNull
    public AuthenticationMode authenticationMode;
    public boolean autoUpdateOfOnlineCache;
    @Nullable
    public String billingTag;
    @NonNull
    public String cachePath;
    public long cacheSizeInBytes;
    @NonNull
    public List<CatalogConfiguration> catalogConfigurations;
    @NonNull
    public Map<EngineBaseURL, String> customEngineBaseUrls;
    @NonNull
    public LayerConfiguration layerConfiguration;
    @NonNull
    public NetworkSettings networkSettings;
    public boolean offlineMode;
    @NonNull
    public String persistentMapStoragePath;
    @NonNull
    public String politicalView;
    @NonNull
    public String scope;

    public enum ActionOnCacheLock {
        NO_ACTION(0),
        WAIT_LOCKING_APP_FINISH(1),
        KILL_LOCKING_APP(2);
        
        public final int value;

        private ActionOnCacheLock(int i) {
            this.value = i;
        }
    }

    public SDKOptions(@NonNull AuthenticationMode authenticationMode2) {
        SDKOptions make = make(authenticationMode2);
        this.accessKeyId = make.accessKeyId;
        this.accessKeySecret = make.accessKeySecret;
        this.scope = make.scope;
        this.cachePath = make.cachePath;
        this.cacheSizeInBytes = make.cacheSizeInBytes;
        this.persistentMapStoragePath = make.persistentMapStoragePath;
        this.politicalView = make.politicalView;
        this.offlineMode = make.offlineMode;
        this.layerConfiguration = make.layerConfiguration;
        this.catalogConfigurations = make.catalogConfigurations;
        this.autoUpdateOfOnlineCache = make.autoUpdateOfOnlineCache;
        this.customEngineBaseUrls = make.customEngineBaseUrls;
        this.actionOnCacheLock = make.actionOnCacheLock;
        this.authenticationMode = make.authenticationMode;
        this.networkSettings = make.networkSettings;
        this.billingTag = make.billingTag;
    }

    private static native SDKOptions make(@NonNull AuthenticationMode authenticationMode2);

    private static native SDKOptions make(@NonNull String str);

    private static native SDKOptions make(@NonNull String str, @NonNull String str2);

    private static native SDKOptions make(@NonNull String str, @NonNull String str2, @NonNull String str3);

    private static native SDKOptions make(@NonNull String str, @NonNull String str2, @NonNull String str3, long j);

    private static native SDKOptions make(@NonNull String str, @NonNull String str2, @NonNull String str3, long j, @NonNull String str4);

    private static native SDKOptions make(@NonNull String str, @NonNull String str2, @NonNull String str3, long j, @NonNull String str4, @NonNull String str5);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SDKOptions)) {
            return false;
        }
        SDKOptions sDKOptions = (SDKOptions) obj;
        return Objects.equals(this.accessKeyId, sDKOptions.accessKeyId) && Objects.equals(this.accessKeySecret, sDKOptions.accessKeySecret) && Objects.equals(this.scope, sDKOptions.scope) && Objects.equals(this.cachePath, sDKOptions.cachePath) && this.cacheSizeInBytes == sDKOptions.cacheSizeInBytes && Objects.equals(this.persistentMapStoragePath, sDKOptions.persistentMapStoragePath) && Objects.equals(this.politicalView, sDKOptions.politicalView) && this.offlineMode == sDKOptions.offlineMode && Objects.equals(this.layerConfiguration, sDKOptions.layerConfiguration) && Objects.equals(this.catalogConfigurations, sDKOptions.catalogConfigurations) && this.autoUpdateOfOnlineCache == sDKOptions.autoUpdateOfOnlineCache && Objects.equals(this.customEngineBaseUrls, sDKOptions.customEngineBaseUrls) && Objects.equals(this.actionOnCacheLock, sDKOptions.actionOnCacheLock) && Objects.equals(this.authenticationMode, sDKOptions.authenticationMode) && Objects.equals(this.networkSettings, sDKOptions.networkSettings) && Objects.equals(this.billingTag, sDKOptions.billingTag);
    }

    public int hashCode() {
        String str = this.accessKeyId;
        int i = 0;
        int hashCode = (217 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.accessKeySecret;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.scope;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.cachePath;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        long j = this.cacheSizeInBytes;
        int i2 = (((hashCode3 + hashCode4) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str5 = this.persistentMapStoragePath;
        int hashCode5 = (i2 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.politicalView;
        int i3 = 97;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + (this.offlineMode ? 79 : 97)) * 31;
        LayerConfiguration layerConfiguration2 = this.layerConfiguration;
        int hashCode7 = (hashCode6 + (layerConfiguration2 != null ? layerConfiguration2.hashCode() : 0)) * 31;
        List<CatalogConfiguration> list = this.catalogConfigurations;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        if (this.autoUpdateOfOnlineCache) {
            i3 = 79;
        }
        int i4 = (hashCode8 + i3) * 31;
        Map<EngineBaseURL, String> map = this.customEngineBaseUrls;
        int hashCode9 = (i4 + (map != null ? map.hashCode() : 0)) * 31;
        ActionOnCacheLock actionOnCacheLock2 = this.actionOnCacheLock;
        int hashCode10 = (hashCode9 + (actionOnCacheLock2 != null ? actionOnCacheLock2.hashCode() : 0)) * 31;
        AuthenticationMode authenticationMode2 = this.authenticationMode;
        int hashCode11 = (hashCode10 + (authenticationMode2 != null ? authenticationMode2.hashCode() : 0)) * 31;
        NetworkSettings networkSettings2 = this.networkSettings;
        int hashCode12 = (hashCode11 + (networkSettings2 != null ? networkSettings2.hashCode() : 0)) * 31;
        String str7 = this.billingTag;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode12 + i;
    }

    public SDKOptions(@NonNull String str) {
        SDKOptions make = make(str);
        this.accessKeyId = make.accessKeyId;
        this.accessKeySecret = make.accessKeySecret;
        this.scope = make.scope;
        this.cachePath = make.cachePath;
        this.cacheSizeInBytes = make.cacheSizeInBytes;
        this.persistentMapStoragePath = make.persistentMapStoragePath;
        this.politicalView = make.politicalView;
        this.offlineMode = make.offlineMode;
        this.layerConfiguration = make.layerConfiguration;
        this.catalogConfigurations = make.catalogConfigurations;
        this.autoUpdateOfOnlineCache = make.autoUpdateOfOnlineCache;
        this.customEngineBaseUrls = make.customEngineBaseUrls;
        this.actionOnCacheLock = make.actionOnCacheLock;
        this.authenticationMode = make.authenticationMode;
        this.networkSettings = make.networkSettings;
        this.billingTag = make.billingTag;
    }

    public SDKOptions(@NonNull String str, @NonNull String str2) {
        SDKOptions make = make(str, str2);
        this.accessKeyId = make.accessKeyId;
        this.accessKeySecret = make.accessKeySecret;
        this.scope = make.scope;
        this.cachePath = make.cachePath;
        this.cacheSizeInBytes = make.cacheSizeInBytes;
        this.persistentMapStoragePath = make.persistentMapStoragePath;
        this.politicalView = make.politicalView;
        this.offlineMode = make.offlineMode;
        this.layerConfiguration = make.layerConfiguration;
        this.catalogConfigurations = make.catalogConfigurations;
        this.autoUpdateOfOnlineCache = make.autoUpdateOfOnlineCache;
        this.customEngineBaseUrls = make.customEngineBaseUrls;
        this.actionOnCacheLock = make.actionOnCacheLock;
        this.authenticationMode = make.authenticationMode;
        this.networkSettings = make.networkSettings;
        this.billingTag = make.billingTag;
    }

    public SDKOptions(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        SDKOptions make = make(str, str2, str3);
        this.accessKeyId = make.accessKeyId;
        this.accessKeySecret = make.accessKeySecret;
        this.scope = make.scope;
        this.cachePath = make.cachePath;
        this.cacheSizeInBytes = make.cacheSizeInBytes;
        this.persistentMapStoragePath = make.persistentMapStoragePath;
        this.politicalView = make.politicalView;
        this.offlineMode = make.offlineMode;
        this.layerConfiguration = make.layerConfiguration;
        this.catalogConfigurations = make.catalogConfigurations;
        this.autoUpdateOfOnlineCache = make.autoUpdateOfOnlineCache;
        this.customEngineBaseUrls = make.customEngineBaseUrls;
        this.actionOnCacheLock = make.actionOnCacheLock;
        this.authenticationMode = make.authenticationMode;
        this.networkSettings = make.networkSettings;
        this.billingTag = make.billingTag;
    }

    public SDKOptions(@NonNull String str, @NonNull String str2, @NonNull String str3, long j) {
        SDKOptions make = make(str, str2, str3, j);
        this.accessKeyId = make.accessKeyId;
        this.accessKeySecret = make.accessKeySecret;
        this.scope = make.scope;
        this.cachePath = make.cachePath;
        this.cacheSizeInBytes = make.cacheSizeInBytes;
        this.persistentMapStoragePath = make.persistentMapStoragePath;
        this.politicalView = make.politicalView;
        this.offlineMode = make.offlineMode;
        this.layerConfiguration = make.layerConfiguration;
        this.catalogConfigurations = make.catalogConfigurations;
        this.autoUpdateOfOnlineCache = make.autoUpdateOfOnlineCache;
        this.customEngineBaseUrls = make.customEngineBaseUrls;
        this.actionOnCacheLock = make.actionOnCacheLock;
        this.authenticationMode = make.authenticationMode;
        this.networkSettings = make.networkSettings;
        this.billingTag = make.billingTag;
    }

    public SDKOptions(@NonNull String str, @NonNull String str2, @NonNull String str3, long j, @NonNull String str4) {
        SDKOptions make = make(str, str2, str3, j, str4);
        this.accessKeyId = make.accessKeyId;
        this.accessKeySecret = make.accessKeySecret;
        this.scope = make.scope;
        this.cachePath = make.cachePath;
        this.cacheSizeInBytes = make.cacheSizeInBytes;
        this.persistentMapStoragePath = make.persistentMapStoragePath;
        this.politicalView = make.politicalView;
        this.offlineMode = make.offlineMode;
        this.layerConfiguration = make.layerConfiguration;
        this.catalogConfigurations = make.catalogConfigurations;
        this.autoUpdateOfOnlineCache = make.autoUpdateOfOnlineCache;
        this.customEngineBaseUrls = make.customEngineBaseUrls;
        this.actionOnCacheLock = make.actionOnCacheLock;
        this.authenticationMode = make.authenticationMode;
        this.networkSettings = make.networkSettings;
        this.billingTag = make.billingTag;
    }

    public SDKOptions(@NonNull String str, @NonNull String str2, @NonNull String str3, long j, @NonNull String str4, @NonNull String str5) {
        SDKOptions make = make(str, str2, str3, j, str4, str5);
        this.accessKeyId = make.accessKeyId;
        this.accessKeySecret = make.accessKeySecret;
        this.scope = make.scope;
        this.cachePath = make.cachePath;
        this.cacheSizeInBytes = make.cacheSizeInBytes;
        this.persistentMapStoragePath = make.persistentMapStoragePath;
        this.politicalView = make.politicalView;
        this.offlineMode = make.offlineMode;
        this.layerConfiguration = make.layerConfiguration;
        this.catalogConfigurations = make.catalogConfigurations;
        this.autoUpdateOfOnlineCache = make.autoUpdateOfOnlineCache;
        this.customEngineBaseUrls = make.customEngineBaseUrls;
        this.actionOnCacheLock = make.actionOnCacheLock;
        this.authenticationMode = make.authenticationMode;
        this.networkSettings = make.networkSettings;
        this.billingTag = make.billingTag;
    }
}
