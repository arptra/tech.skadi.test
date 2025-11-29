package com.here.services.radiomap.manager;

import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.radiomap.common.GeoArea;
import java.util.List;

public interface RadioMapManagerApi {

    public static class Options implements Api.Options {
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_TECHNOLOGIES = "technologies";
        private static final String TAG = "services.radiomap.manager.RadioMapManagerApi.Options";
        boolean mClearAll = false;
        boolean mIncludeGsm = true;
        boolean mIncludeHdWifiCoverage = false;
        boolean mIncludeHdWifiLocation = false;
        boolean mIncludeLte = true;
        boolean mIncludeWcdma = true;
        boolean mIncludeWifiCoarse = true;
        boolean mIncludeWifiDetailed = false;
        boolean mUpdateOldOnly = false;

        public static long getFlags(Bundle bundle) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getLong(KEY_FLAGS, 0);
        }

        public static int getTechnologies(Bundle bundle) {
            if (bundle == null) {
                return 0;
            }
            return bundle.getInt(KEY_TECHNOLOGIES, 0);
        }

        public Bundle asBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_TECHNOLOGIES, getTechnologies());
            bundle.putLong(KEY_FLAGS, getFlags());
            return bundle;
        }

        public Options setClearAll(boolean z) {
            this.mClearAll = z;
            return this;
        }

        public Options setIncludeGsm(boolean z) {
            this.mIncludeGsm = z;
            return this;
        }

        public Options setIncludeHdWifiCoverage(boolean z) {
            this.mIncludeHdWifiCoverage = z;
            return this;
        }

        public Options setIncludeHdWifiLocation(boolean z) {
            this.mIncludeHdWifiLocation = z;
            return this;
        }

        public Options setIncludeLte(boolean z) {
            this.mIncludeLte = z;
            return this;
        }

        public Options setIncludeWcdma(boolean z) {
            this.mIncludeWcdma = z;
            return this;
        }

        public Options setIncludeWifiCoarse(boolean z) {
            this.mIncludeWifiCoarse = z;
            if (!z) {
                this.mIncludeWifiDetailed = false;
            }
            return this;
        }

        public Options setIncludeWifiDetailed(boolean z) {
            this.mIncludeWifiDetailed = z;
            if (z) {
                this.mIncludeWifiCoarse = true;
            }
            return this;
        }

        public Options setUpdateOldOnly(boolean z) {
            this.mUpdateOldOnly = z;
            return this;
        }

        private long getFlags() {
            long j = this.mClearAll ? 2 : 0;
            if (this.mUpdateOldOnly) {
                j |= 1;
            }
            Log.v(TAG, "getFlags: $%x", Long.valueOf(j));
            return j;
        }

        public int getTechnologies() {
            boolean z = this.mIncludeGsm;
            if (this.mIncludeWcdma) {
                z |= true;
            }
            if (this.mIncludeLte) {
                z |= true;
            }
            if (this.mIncludeWifiCoarse) {
                z |= true;
            }
            if (this.mIncludeWifiDetailed) {
                z |= true;
            }
            if (this.mIncludeHdWifiLocation) {
                z |= true;
            }
            if (this.mIncludeHdWifiCoverage) {
                z |= true;
            }
            Log.v(TAG, "getTechnologies: $%x", Integer.valueOf(z ? 1 : 0));
            return z;
        }
    }

    public static class QueryOptions extends Options {
        Target mTarget = Target.Local;

        public enum Target {
            Local,
            Update,
            Extend
        }

        public QueryOptions setTarget(Target target) {
            this.mTarget = target;
            return this;
        }
    }

    void clear(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener);

    void clear(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper);

    void clearAll(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener);

    void clearAll(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper);

    void extend(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener);

    void extend(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper);

    void query(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull QueryOptions queryOptions, @NonNull RadioMapManagerListener radioMapManagerListener);

    void query(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull QueryOptions queryOptions, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper);

    void refresh(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener);

    void refresh(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper);

    void stop(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull RadioMapManagerListener radioMapManagerListener);

    void update(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener);

    void update(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull List<GeoArea> list, @NonNull Options options, @NonNull RadioMapManagerListener radioMapManagerListener, @Nullable Looper looper);
}
