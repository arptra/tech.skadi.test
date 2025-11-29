package com.xjsd.ai.assistant.protocol.nav;

import android.os.Parcel;
import com.upuphone.xr.interconnect.entity.PoiResult;

public class TypedPoiResult extends PoiResult {
    private int index = 0;
    private int type = 0;

    public TypedPoiResult() {
    }

    public int getIndex() {
        return this.index;
    }

    public int getType() {
        return this.type;
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.type = parcel.readInt();
        this.index = parcel.readInt();
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.type);
        parcel.writeInt(this.index);
    }

    public TypedPoiResult(PoiResult poiResult, int i) {
        setName(poiResult.getName());
        setDistance(poiResult.getDistance());
        setAddress(poiResult.getAddress());
        setLatitude(poiResult.getLatitude());
        setLongitude(poiResult.getLongitude());
        setPoiId(poiResult.getPoiId());
        setType(i);
    }
}
