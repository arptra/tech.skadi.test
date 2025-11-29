package com.here.posclient;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.here.services.common.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import kotlin.jvm.internal.LongCompanionObject;

public class UpdateOptions implements Parcelable {
    public static final Parcelable.Creator<UpdateOptions> CREATOR = new Parcelable.Creator<UpdateOptions>() {
        public UpdateOptions createFromParcel(Parcel parcel) {
            final UpdateOptions updateOptions = new UpdateOptions();
            updateOptions.idleMode = UpdateOptions.readBoolean(parcel);
            updateOptions.alwaysUseRequestedOptions = UpdateOptions.readBoolean(parcel);
            UpdateOptions.readOptionalLong(parcel, new ValueHandler<Long>() {
                public void handleValue(Long l) {
                    updateOptions.setAllowedSources(l.longValue());
                }
            });
            UpdateOptions.readOptionalLong(parcel, new ValueHandler<Long>() {
                public void handleValue(Long l) {
                    updateOptions.setAllowedTechnologies(l.longValue());
                }
            });
            UpdateOptions.readOptionalLong(parcel, new ValueHandler<Long>() {
                public void handleValue(Long l) {
                    updateOptions.setIgnoredFreeTechnologies(l.longValue());
                }
            });
            UpdateOptions.readOptionalInt(parcel, new ValueHandler<Integer>() {
                public void handleValue(Integer num) {
                    updateOptions.setClearDataItems(num.intValue());
                }
            });
            UpdateOptions.readOptionalLong(parcel, new ValueHandler<Long>() {
                public void handleValue(Long l) {
                    updateOptions.setDesiredUpdateInterval(l.longValue());
                }
            });
            UpdateOptions.readOptionalLong(parcel, new ValueHandler<Long>() {
                public void handleValue(Long l) {
                    updateOptions.setSmallestUpdateInterval(l.longValue());
                }
            });
            UpdateOptions.readOptionalLong(parcel, new ValueHandler<Long>() {
                public void handleValue(Long l) {
                    updateOptions.setOptions(l.longValue());
                }
            });
            return updateOptions;
        }

        public UpdateOptions[] newArray(int i) {
            return new UpdateOptions[i];
        }
    };
    private static final String KEY_BUNDLED_INSTANCE = "com.here.posclient.UpdateOptions";
    public static final long OPTION_ALWAYS_UPDATE_ON_DESIRED_INTERVAL = 1024;
    public static final long OPTION_ENABLE_EXTERNAL_FOR_REFERENCE = 128;
    public static final long OPTION_NONE = 0;
    public static final long OPTION_ONLINE_FOR_FREE_CELLULAR = 16;
    public static final long OPTION_ONLINE_FOR_FREE_WLAN = 32;
    public static final long OPTION_RMD_COARSE_OVER_CELLULAR = 2;
    public static final long OPTION_RMD_COARSE_OVER_WLAN = 1;
    public static final long OPTION_RMD_DETAILED_OVER_CELLULAR = 8;
    public static final long OPTION_RMD_DETAILED_OVER_WLAN = 4;
    public static final long OPTION_STATELESS_REQUEST = 4096;
    public static final long OPTION_USE_SMALLEST_MEASUREMENT_INTERVAL = 2048;
    public static final long OPTION_WAKING_MSM_TIMER = 64;
    public static final long SOURCE_ANY = 2147483647L;
    public static final long SOURCE_CACHE = 16;
    public static final long SOURCE_EXTERNAL = 64;
    public static final long SOURCE_FUSION = 128;
    public static final long SOURCE_HD_GNSS = 1024;
    public static final long SOURCE_LAST_KNOWN = 1;
    public static final long SOURCE_OFFLINE = 4;
    public static final long SOURCE_ONLINE = 2;
    public static final long SOURCE_SENSOR_FUSION = 256;
    public static final long SOURCE_UNSPECIFIED = 0;
    public static final long TECHNOLOGY_ALL = 16383;
    public static final long TECHNOLOGY_CELL = 4;
    public static final long TECHNOLOGY_CELLULAR = 12;
    public static final long TECHNOLOGY_CELLULAR_OBJECT = 15472;
    public static final long TECHNOLOGY_COUNTRY = 64;
    public static final long TECHNOLOGY_ECELL = 8;
    public static final long TECHNOLOGY_ENODEB = 4096;
    public static final long TECHNOLOGY_GNSS = 1;
    public static final long TECHNOLOGY_IP = 128;
    public static final long TECHNOLOGY_LOCATION_AREA = 16;
    public static final long TECHNOLOGY_MAP = 512;
    public static final long TECHNOLOGY_NETWORK = 32;
    public static final long TECHNOLOGY_RNC = 2048;
    public static final long TECHNOLOGY_SATELLITES = 32768;
    public static final long TECHNOLOGY_SENSORS = 256;
    public static final long TECHNOLOGY_SYSTEM = 8192;
    public static final long TECHNOLOGY_TRACKING_AREA = 1024;
    public static final long TECHNOLOGY_UNSPECIFIED = 0;
    public static final long TECHNOLOGY_WLAN = 2;
    public long allowedSources = 0;
    public boolean allowedSourcesSet;
    public long allowedTechnologies = 0;
    public boolean allowedTechnologiesSet;
    public boolean alwaysUseRequestedOptions;
    public int clearDataItems;
    public boolean clearDataItemsSet;
    public long desiredUpdateInterval;
    public boolean desiredUpdateIntervalSet;
    public boolean idleMode;
    public long ignoredFreeTechnologies = 0;
    public boolean ignoredFreeTechnologiesSet;
    public long options;
    public boolean optionsSet;
    public long smallestUpdateInterval;
    public boolean smallestUpdateIntervalSet;

    public interface ValueHandler<T> {
        void handleValue(T t);
    }

    public UpdateOptions(UpdateOptions updateOptions) {
        if (updateOptions != null) {
            this.idleMode = updateOptions.idleMode;
            this.allowedSources = updateOptions.allowedSources;
            this.allowedSourcesSet = updateOptions.allowedSourcesSet;
            this.allowedTechnologies = updateOptions.allowedTechnologies;
            this.allowedTechnologiesSet = updateOptions.allowedTechnologiesSet;
            this.ignoredFreeTechnologies = updateOptions.ignoredFreeTechnologies;
            this.ignoredFreeTechnologiesSet = updateOptions.ignoredFreeTechnologiesSet;
            this.clearDataItems = updateOptions.clearDataItems;
            this.clearDataItemsSet = updateOptions.clearDataItemsSet;
            this.desiredUpdateInterval = updateOptions.desiredUpdateInterval;
            this.desiredUpdateIntervalSet = updateOptions.desiredUpdateIntervalSet;
            this.smallestUpdateInterval = updateOptions.smallestUpdateInterval;
            this.smallestUpdateIntervalSet = updateOptions.smallestUpdateIntervalSet;
            this.options = updateOptions.options;
            this.optionsSet = updateOptions.optionsSet;
            this.alwaysUseRequestedOptions = updateOptions.alwaysUseRequestedOptions;
        }
    }

    public static <T> void addIfSet(long j, long j2, Collection<T> collection, T t) {
        if (isSet(j, j2)) {
            collection.add(t);
        }
    }

    public static UpdateOptions fromBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(UpdateOptions.class.getClassLoader());
            return (UpdateOptions) bundle.getParcelable(KEY_BUNDLED_INSTANCE);
        }
        throw new IllegalArgumentException("bundle is null");
    }

    public static boolean isSet(long j, long j2) {
        return (j & j2) == j2;
    }

    public static boolean readBoolean(Parcel parcel) {
        return parcel.readByte() != 0;
    }

    public static void readOptionalInt(Parcel parcel, ValueHandler<Integer> valueHandler) {
        if (parcel.readByte() != 0) {
            valueHandler.handleValue(Integer.valueOf(parcel.readInt()));
        }
    }

    public static void readOptionalLong(Parcel parcel, ValueHandler<Long> valueHandler) {
        if (parcel.readByte() != 0) {
            valueHandler.handleValue(Long.valueOf(parcel.readLong()));
        }
    }

    public static void writeBoolean(Parcel parcel, boolean z) {
        parcel.writeByte(z ? (byte) 1 : 0);
    }

    public static void writeOptionalInt(Parcel parcel, boolean z, int i) {
        if (z) {
            parcel.writeByte((byte) 1);
            parcel.writeInt(i);
            return;
        }
        parcel.writeByte((byte) 0);
    }

    public static void writeOptionalLong(Parcel parcel, boolean z, long j) {
        if (z) {
            parcel.writeByte((byte) 1);
            parcel.writeLong(j);
            return;
        }
        parcel.writeByte((byte) 0);
    }

    public Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BUNDLED_INSTANCE, this);
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public UpdateOptions disableOptions(long j) {
        this.options = (~j) & this.options;
        this.optionsSet = true;
        return this;
    }

    public UpdateOptions disableSources(long j) {
        this.allowedSources = (~j) & this.allowedSources;
        this.allowedSourcesSet = true;
        return this;
    }

    public UpdateOptions disableTechnologies(long j) {
        this.allowedTechnologies = (~j) & this.allowedTechnologies;
        this.allowedTechnologiesSet = true;
        return this;
    }

    public UpdateOptions enableOptions(long j) {
        this.options = j | this.options;
        this.optionsSet = true;
        return this;
    }

    public EnumSet<Types.Source> getSourceSet() {
        if (this.allowedSourcesSet) {
            return getSourceSet(this.allowedSources);
        }
        return getSourceSet(0);
    }

    public EnumSet<Types.Technology> getTechnologySet() {
        if (this.allowedTechnologiesSet) {
            return getTechnologySet(this.allowedTechnologies);
        }
        return getTechnologySet(0);
    }

    public boolean isEqual(UpdateOptions updateOptions) {
        return updateOptions != null && this.idleMode == updateOptions.idleMode && this.alwaysUseRequestedOptions == updateOptions.alwaysUseRequestedOptions && this.allowedSources == updateOptions.allowedSources && this.allowedSourcesSet == updateOptions.allowedSourcesSet && this.allowedTechnologies == updateOptions.allowedTechnologies && this.allowedTechnologiesSet == updateOptions.allowedTechnologiesSet && this.ignoredFreeTechnologies == updateOptions.ignoredFreeTechnologies && this.ignoredFreeTechnologiesSet == updateOptions.ignoredFreeTechnologiesSet && this.clearDataItems == updateOptions.clearDataItems && this.clearDataItemsSet == updateOptions.clearDataItemsSet && this.desiredUpdateInterval == updateOptions.desiredUpdateInterval && this.desiredUpdateIntervalSet == updateOptions.desiredUpdateIntervalSet && this.smallestUpdateInterval == updateOptions.smallestUpdateInterval && this.smallestUpdateIntervalSet == updateOptions.smallestUpdateIntervalSet && this.options == updateOptions.options && this.optionsSet == updateOptions.optionsSet;
    }

    public boolean isSourceAllowed(long j) {
        return this.allowedSourcesSet && (this.allowedSources & j) == j;
    }

    public boolean isTechnologyAllowed(long j) {
        return this.allowedTechnologiesSet && (this.allowedTechnologies & j) == j;
    }

    public UpdateOptions setAllowedSources(long j) {
        this.allowedSources = j;
        this.allowedSourcesSet = true;
        return this;
    }

    public UpdateOptions setAllowedTechnologies(long j) {
        this.allowedTechnologies = j;
        this.allowedTechnologiesSet = true;
        return this;
    }

    public UpdateOptions setAlwaysUseRequestedOptions(boolean z) {
        this.alwaysUseRequestedOptions = z;
        return this;
    }

    public UpdateOptions setClearDataItems(int i) {
        this.clearDataItems = i;
        this.clearDataItemsSet = true;
        return this;
    }

    public UpdateOptions setDesiredUpdateInterval(long j) {
        this.desiredUpdateInterval = j;
        this.desiredUpdateIntervalSet = true;
        return this;
    }

    public UpdateOptions setDisabledPowerOptions() {
        this.idleMode = true;
        setDesiredUpdateInterval(LongCompanionObject.MAX_VALUE);
        setSmallestUpdateInterval(LongCompanionObject.MAX_VALUE);
        setAllowedTechnologies(0);
        setAllowedSources(0);
        setOptions(0);
        return this;
    }

    public UpdateOptions setHighPowerOptions() {
        this.idleMode = false;
        setDesiredUpdateInterval(1000);
        setSmallestUpdateInterval(200);
        setAllowedTechnologies(270);
        setAllowedSources(406);
        setOptions(55);
        return this;
    }

    public UpdateOptions setHybridPositioningOptions() {
        this.idleMode = false;
        setDesiredUpdateInterval(1000);
        setSmallestUpdateInterval(200);
        setAllowedTechnologies(263);
        setAllowedSources(1494);
        setOptions(135);
        return this;
    }

    public UpdateOptions setIgnoredFreeTechnologies(long j) {
        this.ignoredFreeTechnologies = j;
        this.ignoredFreeTechnologiesSet = true;
        return this;
    }

    public UpdateOptions setLowPowerOptions() {
        this.idleMode = false;
        setDesiredUpdateInterval(60000);
        setSmallestUpdateInterval(1000);
        setAllowedTechnologies(14);
        setAllowedSources(150);
        setOptions(1);
        return this;
    }

    public UpdateOptions setMediumPowerOptions() {
        this.idleMode = false;
        setDesiredUpdateInterval(30000);
        setSmallestUpdateInterval(1000);
        setAllowedTechnologies(14);
        setAllowedSources(150);
        setOptions(55);
        return this;
    }

    public UpdateOptions setNoPowerOptions() {
        this.idleMode = false;
        setDesiredUpdateInterval(900000);
        setSmallestUpdateInterval(1000);
        setAllowedTechnologies(12);
        setAllowedSources(148);
        setOptions(0);
        return this;
    }

    public UpdateOptions setOptions(long j) {
        this.options = j;
        this.optionsSet = true;
        return this;
    }

    public UpdateOptions setSmallestUpdateInterval(long j) {
        this.smallestUpdateInterval = j;
        this.smallestUpdateIntervalSet = true;
        return this;
    }

    public UpdateOptions setStreamingWlanOptions() {
        this.idleMode = false;
        setDesiredUpdateInterval(1000);
        setSmallestUpdateInterval(100);
        setAllowedTechnologies(270);
        setAllowedSources(150);
        setOptions(3087);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UpdateOptions [ ");
        sb.append(" idleMode: ");
        sb.append(this.idleMode);
        sb.append(" alwaysUseRequestedOptions: ");
        sb.append(this.alwaysUseRequestedOptions);
        if (this.desiredUpdateIntervalSet) {
            sb.append(" desired: ");
            sb.append(this.desiredUpdateInterval);
            sb.append("ms");
        }
        if (this.smallestUpdateIntervalSet) {
            sb.append(" smallest: ");
            sb.append(this.smallestUpdateInterval);
            sb.append("ms");
        }
        if (this.allowedSourcesSet) {
            sb.append(" sources: ");
            sb.append(this.allowedSources);
        }
        if (this.allowedTechnologiesSet) {
            sb.append(" techs: ");
            sb.append(this.allowedTechnologies);
        }
        if (this.ignoredFreeTechnologiesSet) {
            sb.append(" ignored free techs: ");
            sb.append(this.ignoredFreeTechnologies);
        }
        if (this.clearDataItemsSet) {
            sb.append(" clear data items: ");
            sb.append(this.clearDataItems);
        }
        if (this.optionsSet) {
            sb.append(" options: ");
            sb.append(this.options);
        }
        sb.append(" ]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeBoolean(parcel, this.idleMode);
        writeBoolean(parcel, this.alwaysUseRequestedOptions);
        writeOptionalLong(parcel, this.allowedSourcesSet, this.allowedSources);
        writeOptionalLong(parcel, this.allowedTechnologiesSet, this.allowedTechnologies);
        writeOptionalLong(parcel, this.ignoredFreeTechnologiesSet, this.ignoredFreeTechnologies);
        writeOptionalInt(parcel, this.clearDataItemsSet, this.clearDataItems);
        writeOptionalLong(parcel, this.desiredUpdateIntervalSet, this.desiredUpdateInterval);
        writeOptionalLong(parcel, this.smallestUpdateIntervalSet, this.smallestUpdateInterval);
        writeOptionalLong(parcel, this.optionsSet, this.options);
    }

    public static EnumSet<Types.Source> getSourceSet(long j) {
        ArrayList arrayList = new ArrayList();
        if (j == 0) {
            arrayList.add(Types.Source.Unspecified);
        } else {
            long j2 = j;
            ArrayList arrayList2 = arrayList;
            addIfSet(j2, 1, arrayList2, Types.Source.LastKnown);
            addIfSet(j2, 2, arrayList2, Types.Source.Online);
            addIfSet(j2, 4, arrayList2, Types.Source.Offline);
            addIfSet(j2, 16, arrayList2, Types.Source.Cache);
            addIfSet(j2, 64, arrayList2, Types.Source.Hardware);
            addIfSet(j2, 128, arrayList2, Types.Source.Fusion);
            addIfSet(j2, 256, arrayList2, Types.Source.SensorFusion);
            addIfSet(j2, 1024, arrayList2, Types.Source.HDGnss);
        }
        if (arrayList.isEmpty()) {
            return EnumSet.noneOf(Types.Source.class);
        }
        return EnumSet.copyOf(arrayList);
    }

    public static EnumSet<Types.Technology> getTechnologySet(long j) {
        ArrayList arrayList = new ArrayList();
        Class<Types.Technology> cls = Types.Technology.class;
        if (j == 0) {
            return EnumSet.noneOf(cls);
        }
        long j2 = j;
        ArrayList arrayList2 = arrayList;
        addIfSet(j2, 1, arrayList2, Types.Technology.Gnss);
        addIfSet(j2, 2, arrayList2, Types.Technology.Wlan);
        addIfSet(j2, 12, arrayList2, Types.Technology.Cellular);
        addIfSet(j2, 4, arrayList2, Types.Technology.Cell);
        addIfSet(j2, 8, arrayList2, Types.Technology.ECell);
        addIfSet(j2, 16, arrayList2, Types.Technology.LocationArea);
        addIfSet(j2, 32, arrayList2, Types.Technology.Network);
        addIfSet(j2, 64, arrayList2, Types.Technology.Country);
        addIfSet(j2, 128, arrayList2, Types.Technology.Ip);
        addIfSet(j2, 256, arrayList2, Types.Technology.Sensors);
        addIfSet(j2, 512, arrayList2, Types.Technology.Map);
        addIfSet(j2, 1024, arrayList2, Types.Technology.TrackingArea);
        addIfSet(j2, 2048, arrayList2, Types.Technology.Rnc);
        addIfSet(j2, 4096, arrayList2, Types.Technology.ENodeB);
        addIfSet(j2, 8192, arrayList2, Types.Technology.System);
        if (arrayList.isEmpty()) {
            return EnumSet.noneOf(cls);
        }
        return EnumSet.copyOf(arrayList);
    }

    public UpdateOptions() {
    }
}
