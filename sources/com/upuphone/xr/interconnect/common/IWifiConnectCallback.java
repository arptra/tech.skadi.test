package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IWifiConnectCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IWifiConnectCallback";

    public static class Default implements IWifiConnectCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onResult(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWifiConnectCallback {
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IWifiConnectCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWifiConnectCallback.DESCRIPTOR;
            }

            public void onResult(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWifiConnectCallback.DESCRIPTOR);
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
            attachInterface(this, IWifiConnectCallback.DESCRIPTOR);
        }

        public static IWifiConnectCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWifiConnectCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IWifiConnectCallback)) ? new Proxy(iBinder) : (IWifiConnectCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWifiConnectCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWifiConnectCallback.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onResult(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onResult(int i) throws RemoteException;
}
