package com.here.sdk.transport;

public enum HazardousMaterial {
    EXPLOSIVE(0),
    GAS(1),
    FLAMMABLE(2),
    COMBUSTIBLE(3),
    ORGANIC(4),
    POISON(5),
    RADIOACTIVE(6),
    CORROSIVE(7),
    POISONOUS_INHALATION(8),
    HARMFUL_TO_WATER(9),
    OTHER(10);
    
    public final int value;

    private HazardousMaterial(int i) {
        this.value = i;
    }
}
