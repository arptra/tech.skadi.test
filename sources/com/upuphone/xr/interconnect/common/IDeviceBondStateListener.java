package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;

public interface IDeviceBondStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDeviceBondStateListener";

    public static class Default implements IDeviceBondStateListener {
        public IBinder asBinder() {
            return null;
        }

        public void onDeviceBondStateChange(StarryNetDevice starryNetDevice, int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDeviceBondStateListener {
        static final int TRANSACTION_onDeviceBondStateChange = 1;

        public static class Proxy implements IDeviceBondStateListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDeviceBondStateListener.DESCRIPTOR;
            }

            public void onDeviceBondStateChange(StarryNetDevice starryNetDevice, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceBondStateListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetDevice, 0);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDeviceBondStateListener.DESCRIPTOR);
        }

        public static IDeviceBondStateListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceBondStateListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceBondStateListener)) ? new Proxy(iBinder) : (IDeviceBondStateListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceBondStateListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDeviceBondStateListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onDeviceBondStateChange((StarryNetDevice) _Parcel.readTypedObject(parcel, StarryNetDevice.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void onDeviceBondStateChange(StarryNetDevice starryNetDevice, int i) throws RemoteException;
}
