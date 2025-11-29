package com.here.posclient.analytics;

public class PositioningCounters extends Counters {
    public final long byCell;
    public final long byWlan;
    public final long estimates;
    public final long externals;
    public final long fallbacks;
    public final long onlines;
    public final long updateErrors;
    public final long updates;
    public final long withBuilding;
    public final long withFloor;

    public PositioningCounters(int i, long[] jArr) {
        super(i);
        this.updates = jArr[0];
        this.updateErrors = jArr[1];
        this.fallbacks = jArr[2];
        this.estimates = jArr[3];
        this.externals = jArr[4];
        this.withBuilding = jArr[5];
        this.withFloor = jArr[6];
        this.byCell = jArr[7];
        this.byWlan = jArr[8];
        this.onlines = jArr[9];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PositioningCounters [");
        stringBuffer.append("event: ");
        stringBuffer.append(this.event);
        stringBuffer.append(", updates: ");
        stringBuffer.append(this.updates);
        stringBuffer.append(", updateErrors: ");
        stringBuffer.append(this.updateErrors);
        stringBuffer.append(", fallbacks: ");
        stringBuffer.append(this.fallbacks);
        stringBuffer.append(", estimates: ");
        stringBuffer.append(this.estimates);
        stringBuffer.append(", externals: ");
        stringBuffer.append(this.externals);
        stringBuffer.append(", withBuilding: ");
        stringBuffer.append(this.withBuilding);
        stringBuffer.append(", withFloor: ");
        stringBuffer.append(this.withFloor);
        stringBuffer.append(", byCell: ");
        stringBuffer.append(this.byCell);
        stringBuffer.append(", byWlan: ");
        stringBuffer.append(this.byWlan);
        stringBuffer.append(", onlines: ");
        stringBuffer.append(this.onlines);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
