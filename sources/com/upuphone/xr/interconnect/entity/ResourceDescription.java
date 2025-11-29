package com.upuphone.xr.interconnect.entity;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

public class ResourceDescription implements Parcelable {
    public static final Parcelable.Creator<ResourceDescription> CREATOR = new Parcelable.Creator<ResourceDescription>() {
        public ResourceDescription createFromParcel(Parcel parcel) {
            ResourceDescription resourceDescription = new ResourceDescription();
            resourceDescription.readFromParcel(parcel);
            return resourceDescription;
        }

        public ResourceDescription[] newArray(int i) {
            return new ResourceDescription[i];
        }
    };
    public String deviceId;
    public String identifier;
    public byte type;

    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        if (readInt >= 4) {
            try {
                if (parcel.dataPosition() - dataPosition < readInt) {
                    this.deviceId = parcel.readString();
                    if (parcel.dataPosition() - dataPosition < readInt) {
                        this.type = parcel.readByte();
                        if (parcel.dataPosition() - dataPosition < readInt) {
                            this.identifier = parcel.readString();
                            if (dataPosition <= Integer.MAX_VALUE - readInt) {
                                parcel.setDataPosition(dataPosition + readInt);
                                return;
                            }
                            throw new BadParcelableException("Overflow in the size of parcelable");
                        } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                            throw new BadParcelableException("Overflow in the size of parcelable");
                        }
                    } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                        throw new BadParcelableException("Overflow in the size of parcelable");
                    }
                } else if (dataPosition > Integer.MAX_VALUE - readInt) {
                    throw new BadParcelableException("Overflow in the size of parcelable");
                }
                parcel.setDataPosition(dataPosition + readInt);
            } catch (Throwable th) {
                if (dataPosition > Integer.MAX_VALUE - readInt) {
                    throw new BadParcelableException("Overflow in the size of parcelable");
                }
                parcel.setDataPosition(dataPosition + readInt);
                throw th;
            }
        } else {
            throw new BadParcelableException("Parcelable too small");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(0);
        parcel.writeString(this.deviceId);
        parcel.writeByte(this.type);
        parcel.writeString(this.identifier);
        int dataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition2 - dataPosition);
        parcel.setDataPosition(dataPosition2);
    }
}
