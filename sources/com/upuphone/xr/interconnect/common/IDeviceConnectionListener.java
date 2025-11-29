package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;

public interface IDeviceConnectionListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDeviceConnectionListener";

    public static class Default implements IDeviceConnectionListener {
        public IBinder asBinder() {
            return null;
        }

        public void onDeviceConnected(StarryNetDevice starryNetDevice) throws RemoteException {
        }

        public void onDeviceDisconnected(StarryNetDevice starryNetDevice) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDeviceConnectionListener {
        static final int TRANSACTION_onDeviceConnected = 1;
        static final int TRANSACTION_onDeviceDisconnected = 2;

        public static class Proxy implements IDeviceConnectionListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDeviceConnectionListener.DESCRIPTOR;
            }

            public void onDeviceConnected(StarryNetDevice starryNetDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceConnectionListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetDevice, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDeviceDisconnected(StarryNetDevice starryNetDevice) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceConnectionListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetDevice, 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDeviceConnectionListener.DESCRIPTOR);
        }

        public static IDeviceConnectionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceConnectionListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceConnectionListener)) ? new Proxy(iBinder) : (IDeviceConnectionListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceConnectionListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onDeviceConnected((StarryNetDevice) _Parcel.readTypedObject(parcel, StarryNetDevice.CREATOR));
                    parcel2.writeNoException();
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onDeviceDisconnected((StarryNetDevice) _Parcel.readTypedObject(parcel, StarryNetDevice.CREATOR));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IDeviceConnectionListener.DESCRIPTOR);
            return true;
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

    void onDeviceConnected(StarryNetDevice starryNetDevice) throws RemoteException;

    void onDeviceDisconnected(StarryNetDevice starryNetDevice) throws RemoteException;
}
