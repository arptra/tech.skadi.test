package com.upuphone.runasone;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import java.nio.ByteBuffer;

public class ArrayData implements Parcelable {
    public static final Parcelable.Creator<ArrayData> CREATOR = new Parcelable.Creator<ArrayData>() {
        public ArrayData createFromParcel(Parcel parcel) {
            return new ArrayData(parcel);
        }

        public ArrayData[] newArray(int i) {
            return new ArrayData[i];
        }
    };
    private static final long THRESHOLD = 40960;
    private final byte[] data;

    public ArrayData(byte[] bArr) {
        this.data = bArr;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.data.length);
        byte[] bArr = this.data;
        if (((long) bArr.length) > THRESHOLD) {
            try {
                SharedMemory create = SharedMemory.create("ArrayData_", bArr.length);
                ByteBuffer mapReadWrite = create.mapReadWrite();
                mapReadWrite.put(this.data);
                create.writeToParcel(parcel, i);
                create.setProtect(OsConstants.PROT_READ);
                SharedMemory.unmap(mapReadWrite);
                create.close();
            } catch (ErrnoException e) {
                e.printStackTrace();
            }
        } else {
            parcel.writeByteArray(bArr);
        }
    }

    public ArrayData(Parcel parcel) {
        int readInt = parcel.readInt();
        byte[] bArr = new byte[readInt];
        this.data = bArr;
        if (((long) readInt) > THRESHOLD) {
            SharedMemory sharedMemory = (SharedMemory) SharedMemory.CREATOR.createFromParcel(parcel);
            try {
                ByteBuffer mapReadOnly = sharedMemory.mapReadOnly();
                mapReadOnly.get(bArr);
                SharedMemory.unmap(mapReadOnly);
                sharedMemory.close();
            } catch (ErrnoException e) {
                e.printStackTrace();
            }
        } else {
            parcel.readByteArray(bArr);
        }
    }
}
