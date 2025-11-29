package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRequestCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IRequestCallback";
    public static final int ERROR_CODE_DEVICE_NOT_CONNECTED = 3;
    public static final int ERROR_CODE_STARRYNET_FAILURE = 4;
    public static final int ERROR_CODE_STARRYNET_NOT_READY = 2;
    public static final int ERROR_CODE_TIMEOUT = 1;

    public static class Default implements IRequestCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onFail(int i, String str) throws RemoteException {
        }

        public void onSuccess() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRequestCallback {
        static final int TRANSACTION_onFail = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IRequestCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRequestCallback.DESCRIPTOR;
            }

            public void onFail(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IRequestCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken(IRequestCallback.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IRequestCallback.DESCRIPTOR);
        }

        public static IRequestCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IRequestCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRequestCallback)) ? new Proxy(iBinder) : (IRequestCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRequestCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onSuccess();
                    parcel2.writeNoException();
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFail(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IRequestCallback.DESCRIPTOR);
            return true;
        }
    }

    void onFail(int i, String str) throws RemoteException;

    void onSuccess() throws RemoteException;
}
