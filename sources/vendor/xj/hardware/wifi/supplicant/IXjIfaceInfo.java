package vendor.xj.hardware.wifi.supplicant;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

public class IXjIfaceInfo implements Parcelable {
    public static final Parcelable.Creator<IXjIfaceInfo> CREATOR = new Parcelable.Creator<IXjIfaceInfo>() {
        /* renamed from: a */
        public IXjIfaceInfo createFromParcel(Parcel parcel) {
            IXjIfaceInfo iXjIfaceInfo = new IXjIfaceInfo();
            iXjIfaceInfo.readFromParcel(parcel);
            return iXjIfaceInfo;
        }

        /* renamed from: b */
        public IXjIfaceInfo[] newArray(int i) {
            return new IXjIfaceInfo[i];
        }
    };
    public String name;
    public int type;

    public int describeContents() {
        return 0;
    }

    public final int getStability() {
        return 1;
    }

    public final void readFromParcel(Parcel parcel) {
        int dataPosition = parcel.dataPosition();
        int readInt = parcel.readInt();
        if (readInt >= 4) {
            try {
                if (parcel.dataPosition() - dataPosition < readInt) {
                    this.type = parcel.readInt();
                    if (parcel.dataPosition() - dataPosition < readInt) {
                        this.name = parcel.readString();
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
        parcel.writeInt(this.type);
        parcel.writeString(this.name);
        int dataPosition2 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition2 - dataPosition);
        parcel.setDataPosition(dataPosition2);
    }
}
