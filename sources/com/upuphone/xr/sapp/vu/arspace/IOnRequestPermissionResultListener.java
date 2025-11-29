package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnRequestPermissionResultListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnRequestPermissionResultListener";

    public static class Default implements IOnRequestPermissionResultListener {
        public IBinder asBinder() {
            return null;
        }

        public void onRequestPermissionResult(String str, boolean z) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnRequestPermissionResultListener {
        static final int TRANSACTION_onRequestPermissionResult = 1;

        public static class Proxy implements IOnRequestPermissionResultListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnRequestPermissionResultListener.DESCRIPTOR;
            }

            public void onRequestPermissionResult(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnRequestPermissionResultListener.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IOnRequestPermissionResultListener.DESCRIPTOR);
        }

        public static IOnRequestPermissionResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnRequestPermissionResultListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnRequestPermissionResultListener)) ? new Proxy(iBinder) : (IOnRequestPermissionResultListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnRequestPermissionResultListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnRequestPermissionResultListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onRequestPermissionResult(parcel.readString(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onRequestPermissionResult(String str, boolean z) throws RemoteException;
}
