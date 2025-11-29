package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnDataResultListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnDataResultListener";

    public static class Default implements IOnDataResultListener {
        public IBinder asBinder() {
            return null;
        }

        public void onResult(String str, int i, String str2) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnDataResultListener {
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IOnDataResultListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnDataResultListener.DESCRIPTOR;
            }

            public void onResult(String str, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnDataResultListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOnDataResultListener.DESCRIPTOR);
        }

        public static IOnDataResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnDataResultListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnDataResultListener)) ? new Proxy(iBinder) : (IOnDataResultListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnDataResultListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnDataResultListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onResult(parcel.readString(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onResult(String str, int i, String str2) throws RemoteException;
}
