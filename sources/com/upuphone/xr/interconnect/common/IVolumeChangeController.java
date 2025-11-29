package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IVolumeChange;

public interface IVolumeChangeController extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IVolumeChangeController";

    public static class Default implements IVolumeChangeController {
        public IBinder asBinder() {
            return null;
        }

        public void dispatchVolumeChange(int i) throws RemoteException {
        }

        public void registerVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException {
        }

        public void unregisterVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVolumeChangeController {
        static final int TRANSACTION_dispatchVolumeChange = 3;
        static final int TRANSACTION_registerVolumeChangeReceiver = 1;
        static final int TRANSACTION_unregisterVolumeChangeReceiver = 2;

        public static class Proxy implements IVolumeChangeController {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void dispatchVolumeChange(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IVolumeChangeController.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IVolumeChangeController.DESCRIPTOR;
            }

            public void registerVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IVolumeChangeController.DESCRIPTOR);
                    obtain.writeStrongInterface(iVolumeChange);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IVolumeChangeController.DESCRIPTOR);
                    obtain.writeStrongInterface(iVolumeChange);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVolumeChangeController.DESCRIPTOR);
        }

        public static IVolumeChangeController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IVolumeChangeController.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IVolumeChangeController)) ? new Proxy(iBinder) : (IVolumeChangeController) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IVolumeChangeController.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    registerVolumeChangeReceiver(IVolumeChange.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i == 2) {
                    unregisterVolumeChangeReceiver(IVolumeChange.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    dispatchVolumeChange(parcel.readInt());
                }
                return true;
            }
            parcel2.writeString(IVolumeChangeController.DESCRIPTOR);
            return true;
        }
    }

    void dispatchVolumeChange(int i) throws RemoteException;

    void registerVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException;

    void unregisterVolumeChangeReceiver(IVolumeChange iVolumeChange) throws RemoteException;
}
