package com.here.services.playback.internal;

import android.location.Location;
import android.os.Bundle;
import com.here.services.playback.TestTrackSimulationApi;
import java.util.ArrayList;
import java.util.List;

public class SimulationResult implements TestTrackSimulationApi.Result {
    private static final String KEY_LOCATIONS = "locations";
    private final ArrayList<Location> mLocations = new ArrayList<>();

    public static SimulationResult fromBundle(Bundle bundle) {
        return new SimulationResult().setLocations(bundle.getParcelableArrayList(KEY_LOCATIONS));
    }

    public Bundle asBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_LOCATIONS, this.mLocations);
        return bundle;
    }

    public List<Location> getLocations() {
        return this.mLocations;
    }

    public SimulationResult setLocations(List<Location> list) {
        this.mLocations.clear();
        if (list != null) {
            this.mLocations.addAll(list);
        }
        return this;
    }
}
