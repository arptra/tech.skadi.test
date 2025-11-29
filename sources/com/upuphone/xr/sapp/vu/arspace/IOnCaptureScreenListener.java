package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnCaptureScreenListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnCaptureScreenListener";

    public static class Default implements IOnCaptureScreenListener {
        public IBinder asBinder() {
            return null;
        }

        public void onCaptureScreenEnd(String str) throws RemoteException {
        }

        public void onCaptureScreenStart() throws RemoteException {
        }

        public void onPrepare(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnCaptureScreenListener {
        static final int TRANSACTION_onCaptureScreenEnd = 3;
        static final int TRANSACTION_onCaptureScreenStart = 2;
        static final int TRANSACTION_onPrepare = 1;

        public static class Proxy implements IOnCaptureScreenListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnCaptureScreenListener.DESCRIPTOR;
            }

            public void onCaptureScreenEnd(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnCaptureScreenListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCaptureScreenStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnCaptureScreenListener.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPrepare(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnCaptureScreenListener.DESCRIPTOR);
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
            attachInterface(this, IOnCaptureScreenListener.DESCRIPTOR);
        }

        public static IOnCaptureScreenListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnCaptureScreenListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnCaptureScreenListener)) ? new Proxy(iBinder) : (IOnCaptureScreenListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnCaptureScreenListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onPrepare(parcel.readInt());
                    parcel2.writeNoException();
                } else if (i == 2) {
                    onCaptureScreenStart();
                    parcel2.writeNoException();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onCaptureScreenEnd(parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IOnCaptureScreenListener.DESCRIPTOR);
            return true;
        }
    }

    void onCaptureScreenEnd(String str) throws RemoteException;

    void onCaptureScreenStart() throws RemoteException;

    void onPrepare(int i) throws RemoteException;
}
