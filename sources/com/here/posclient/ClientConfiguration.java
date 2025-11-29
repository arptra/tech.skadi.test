package com.here.posclient;

import android.os.Parcel;
import android.os.Parcelable;

public class ClientConfiguration implements Parcelable {
    public static final Parcelable.Creator<ClientConfiguration> CREATOR = new Parcelable.Creator<ClientConfiguration>() {
        public ClientConfiguration createFromParcel(Parcel parcel) {
            return new ClientConfiguration(parcel);
        }

        public ClientConfiguration[] newArray(int i) {
            return new ClientConfiguration[i];
        }
    };
    public String clientId;
    public long features;
    public String rmdBaseUrl;
    public String rmdServerAddress;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ClientConfiguration [" + "clientId(" + this.clientId + ") features(0x" + Long.toHexString(this.features) + ") rmdSA(" + this.rmdServerAddress + ")]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.clientId);
        parcel.writeLong(this.features);
        parcel.writeString(this.rmdServerAddress);
        parcel.writeString(this.rmdBaseUrl);
    }

    private ClientConfiguration(Parcel parcel) {
        this.clientId = parcel.readString();
        this.features = parcel.readLong();
        this.rmdServerAddress = parcel.readString();
        this.rmdBaseUrl = parcel.readString();
    }

    public ClientConfiguration() {
    }
}
