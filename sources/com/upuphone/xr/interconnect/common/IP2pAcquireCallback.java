package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IP2pAcquireCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IP2pAcquireCallback";

    public static class Default implements IP2pAcquireCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onFail(int i) throws RemoteException {
        }

        public void onSuccess() throws RemoteException {
        }

        public void onTimeout() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IP2pAcquireCallback {
        static final int TRANSACTION_onFail = 3;
        static final int TRANSACTION_onSuccess = 1;
        static final int TRANSACTION_onTimeout = 2;

        public static class Proxy implements IP2pAcquireCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IP2pAcquireCallback.DESCRIPTOR;
            }

            public void onFail(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IP2pAcquireCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IP2pAcquireCallback.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onTimeout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IP2pAcquireCallback.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IP2pAcquireCallback.DESCRIPTOR);
        }

        public static IP2pAcquireCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IP2pAcquireCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IP2pAcquireCallback)) ? new Proxy(iBinder) : (IP2pAcquireCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IP2pAcquireCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onSuccess();
                    parcel2.writeNoException();
                } else if (i == 2) {
                    onTimeout();
                    parcel2.writeNoException();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFail(parcel.readInt());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IP2pAcquireCallback.DESCRIPTOR);
            return true;
        }
    }

    void onFail(int i) throws RemoteException;

    void onSuccess() throws RemoteException;

    void onTimeout() throws RemoteException;
}
