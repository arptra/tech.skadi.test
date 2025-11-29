package com.here.services.location;

import androidx.annotation.NonNull;
import com.here.posclient.UpdateOptions;
import com.here.services.common.Types;
import java.util.EnumSet;

public class OptionsChangedEvent {
    private final EnumSet<Types.Source> mDisabledSources;
    private final EnumSet<Types.Technology> mDisabledTechnologies;
    private final EnumSet<Types.Source> mRequestedSources;
    private final EnumSet<Types.Technology> mRequestedTechnologies;

    public OptionsChangedEvent(@NonNull UpdateOptions updateOptions, @NonNull UpdateOptions updateOptions2) {
        EnumSet<Types.Source> sourceSet = updateOptions.getSourceSet();
        this.mRequestedSources = sourceSet;
        EnumSet<Types.Source> clone = sourceSet.clone();
        this.mDisabledSources = clone;
        clone.removeAll(updateOptions2.getSourceSet());
        EnumSet<Types.Technology> technologySet = updateOptions.getTechnologySet();
        this.mRequestedTechnologies = technologySet;
        EnumSet<Types.Technology> clone2 = technologySet.clone();
        this.mDisabledTechnologies = clone2;
        clone2.removeAll(updateOptions2.getTechnologySet());
    }

    @NonNull
    public EnumSet<Types.Source> getDisabledSources() {
        return this.mDisabledSources.clone();
    }

    @NonNull
    public EnumSet<Types.Technology> getDisabledTechnologies() {
        return this.mDisabledTechnologies.clone();
    }

    @NonNull
    public EnumSet<Types.Source> getRequestedSources() {
        return this.mRequestedSources.clone();
    }

    @NonNull
    public EnumSet<Types.Technology> getRequestedTechnologies() {
        return this.mRequestedTechnologies.clone();
    }

    public boolean hasChanged() {
        return !this.mDisabledSources.isEmpty() || !this.mDisabledTechnologies.isEmpty();
    }
}
