package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnDofModeChangeListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnDofModeChangeListener";

    public static class Default implements IOnDofModeChangeListener {
        public IBinder asBinder() {
            return null;
        }

        public void onDofModeChanged(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnDofModeChangeListener {
        static final int TRANSACTION_onDofModeChanged = 1;

        public static class Proxy implements IOnDofModeChangeListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnDofModeChangeListener.DESCRIPTOR;
            }

            public void onDofModeChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnDofModeChangeListener.DESCRIPTOR);
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
            attachInterface(this, IOnDofModeChangeListener.DESCRIPTOR);
        }

        public static IOnDofModeChangeListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnDofModeChangeListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnDofModeChangeListener)) ? new Proxy(iBinder) : (IOnDofModeChangeListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnDofModeChangeListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnDofModeChangeListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onDofModeChanged(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onDofModeChanged(int i) throws RemoteException;
}
