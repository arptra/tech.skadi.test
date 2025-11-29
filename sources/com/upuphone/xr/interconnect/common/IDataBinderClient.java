package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDataBinderClient extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDataBinderClient";

    public static class Default implements IDataBinderClient {
        public IBinder asBinder() {
            return null;
        }

        public void updateDeviceList(String[] strArr) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDataBinderClient {
        static final int TRANSACTION_updateDeviceList = 1;

        public static class Proxy implements IDataBinderClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDataBinderClient.DESCRIPTOR;
            }

            public void updateDeviceList(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinderClient.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDataBinderClient.DESCRIPTOR);
        }

        public static IDataBinderClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDataBinderClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDataBinderClient)) ? new Proxy(iBinder) : (IDataBinderClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDataBinderClient.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDataBinderClient.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                updateDeviceList(parcel.createStringArray());
                return true;
            }
        }
    }

    void updateDeviceList(String[] strArr) throws RemoteException;
}
