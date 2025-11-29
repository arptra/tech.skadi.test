package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGroupMessageSendCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IGroupMessageSendCallback";

    public static class Default implements IGroupMessageSendCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onFailure(int i) throws RemoteException {
        }

        public void onSuccess() throws RemoteException {
        }

        public void onTimeout() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGroupMessageSendCallback {
        static final int TRANSACTION_onFailure = 3;
        static final int TRANSACTION_onSuccess = 1;
        static final int TRANSACTION_onTimeout = 2;

        public static class Proxy implements IGroupMessageSendCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGroupMessageSendCallback.DESCRIPTOR;
            }

            public void onFailure(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageSendCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageSendCallback.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onTimeout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageSendCallback.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IGroupMessageSendCallback.DESCRIPTOR);
        }

        public static IGroupMessageSendCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IGroupMessageSendCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGroupMessageSendCallback)) ? new Proxy(iBinder) : (IGroupMessageSendCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IGroupMessageSendCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onSuccess();
                } else if (i == 2) {
                    onTimeout();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFailure(parcel.readInt());
                }
                return true;
            }
            parcel2.writeString(IGroupMessageSendCallback.DESCRIPTOR);
            return true;
        }
    }

    void onFailure(int i) throws RemoteException;

    void onSuccess() throws RemoteException;

    void onTimeout() throws RemoteException;
}
