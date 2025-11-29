package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnRecordScreenListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnRecordScreenListener";

    public static class Default implements IOnRecordScreenListener {
        public IBinder asBinder() {
            return null;
        }

        public void onPrepare(int i) throws RemoteException {
        }

        public void onRecordScreenEnd(String str) throws RemoteException {
        }

        public void onRecordScreenStart() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnRecordScreenListener {
        static final int TRANSACTION_onPrepare = 1;
        static final int TRANSACTION_onRecordScreenEnd = 3;
        static final int TRANSACTION_onRecordScreenStart = 2;

        public static class Proxy implements IOnRecordScreenListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnRecordScreenListener.DESCRIPTOR;
            }

            public void onPrepare(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnRecordScreenListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRecordScreenEnd(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnRecordScreenListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRecordScreenStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnRecordScreenListener.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOnRecordScreenListener.DESCRIPTOR);
        }

        public static IOnRecordScreenListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnRecordScreenListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnRecordScreenListener)) ? new Proxy(iBinder) : (IOnRecordScreenListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnRecordScreenListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onPrepare(parcel.readInt());
                    parcel2.writeNoException();
                } else if (i == 2) {
                    onRecordScreenStart();
                    parcel2.writeNoException();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onRecordScreenEnd(parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IOnRecordScreenListener.DESCRIPTOR);
            return true;
        }
    }

    void onPrepare(int i) throws RemoteException;

    void onRecordScreenEnd(String str) throws RemoteException;

    void onRecordScreenStart() throws RemoteException;
}
