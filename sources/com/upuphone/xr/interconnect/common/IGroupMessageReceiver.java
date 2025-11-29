package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IGroupMessageReceiver extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IGroupMessageReceiver";

    public static class Default implements IGroupMessageReceiver {
        public IBinder asBinder() {
            return null;
        }

        public void onFailure(int i) throws RemoteException {
        }

        public void onRecv(int i, byte b, byte[] bArr) throws RemoteException {
        }

        public void onTimeout() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IGroupMessageReceiver {
        static final int TRANSACTION_onFailure = 3;
        static final int TRANSACTION_onRecv = 1;
        static final int TRANSACTION_onTimeout = 2;

        public static class Proxy implements IGroupMessageReceiver {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IGroupMessageReceiver.DESCRIPTOR;
            }

            public void onFailure(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageReceiver.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onRecv(int i, byte b, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageReceiver.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeByte(b);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onTimeout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IGroupMessageReceiver.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IGroupMessageReceiver.DESCRIPTOR);
        }

        public static IGroupMessageReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IGroupMessageReceiver.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGroupMessageReceiver)) ? new Proxy(iBinder) : (IGroupMessageReceiver) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IGroupMessageReceiver.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onRecv(parcel.readInt(), parcel.readByte(), parcel.createByteArray());
                } else if (i == 2) {
                    onTimeout();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFailure(parcel.readInt());
                }
                return true;
            }
            parcel2.writeString(IGroupMessageReceiver.DESCRIPTOR);
            return true;
        }
    }

    void onFailure(int i) throws RemoteException;

    void onRecv(int i, byte b, byte[] bArr) throws RemoteException;

    void onTimeout() throws RemoteException;
}
