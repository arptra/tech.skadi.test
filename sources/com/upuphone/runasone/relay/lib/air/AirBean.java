package com.upuphone.runasone.relay.lib.air;

import java.util.Map;

public class AirBean {
    private Map<Integer, String> airMapping;

    public Map<Integer, String> getAirMapping() {
        return this.airMapping;
    }

    public AirBean setAirMapping(Map<Integer, String> map) {
        this.airMapping = map;
        return this;
    }
}
