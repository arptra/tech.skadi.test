package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnRequestExitArSpaceListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnRequestExitArSpaceListener";

    public static class Default implements IOnRequestExitArSpaceListener {
        public IBinder asBinder() {
            return null;
        }

        public void onRequestExit(boolean z) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnRequestExitArSpaceListener {
        static final int TRANSACTION_onRequestExit = 1;

        public static class Proxy implements IOnRequestExitArSpaceListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnRequestExitArSpaceListener.DESCRIPTOR;
            }

            public void onRequestExit(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnRequestExitArSpaceListener.DESCRIPTOR);
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
            attachInterface(this, IOnRequestExitArSpaceListener.DESCRIPTOR);
        }

        public static IOnRequestExitArSpaceListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnRequestExitArSpaceListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnRequestExitArSpaceListener)) ? new Proxy(iBinder) : (IOnRequestExitArSpaceListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnRequestExitArSpaceListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnRequestExitArSpaceListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onRequestExit(parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onRequestExit(boolean z) throws RemoteException;
}
