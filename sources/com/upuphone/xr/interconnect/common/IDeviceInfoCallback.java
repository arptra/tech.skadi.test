package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.StarryNetDeviceInfo;

public interface IDeviceInfoCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDeviceInfoCallback";

    public static class Default implements IDeviceInfoCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onRecieveDeviceInfo(StarryNetDeviceInfo starryNetDeviceInfo) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDeviceInfoCallback {
        static final int TRANSACTION_onRecieveDeviceInfo = 1;

        public static class Proxy implements IDeviceInfoCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDeviceInfoCallback.DESCRIPTOR;
            }

            public void onRecieveDeviceInfo(StarryNetDeviceInfo starryNetDeviceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDeviceInfoCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetDeviceInfo, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        starryNetDeviceInfo.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDeviceInfoCallback.DESCRIPTOR);
        }

        public static IDeviceInfoCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceInfoCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceInfoCallback)) ? new Proxy(iBinder) : (IDeviceInfoCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDeviceInfoCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDeviceInfoCallback.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                StarryNetDeviceInfo starryNetDeviceInfo = (StarryNetDeviceInfo) _Parcel.readTypedObject(parcel, StarryNetDeviceInfo.CREATOR);
                onRecieveDeviceInfo(starryNetDeviceInfo);
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, starryNetDeviceInfo, 1);
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

    void onRecieveDeviceInfo(StarryNetDeviceInfo starryNetDeviceInfo) throws RemoteException;
}
