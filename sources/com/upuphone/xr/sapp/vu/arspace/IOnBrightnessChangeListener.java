package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnBrightnessChangeListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnBrightnessChangeListener";

    public static class Default implements IOnBrightnessChangeListener {
        public IBinder asBinder() {
            return null;
        }

        public void onBrightnessChange(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnBrightnessChangeListener {
        static final int TRANSACTION_onBrightnessChange = 1;

        public static class Proxy implements IOnBrightnessChangeListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnBrightnessChangeListener.DESCRIPTOR;
            }

            public void onBrightnessChange(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnBrightnessChangeListener.DESCRIPTOR);
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
            attachInterface(this, IOnBrightnessChangeListener.DESCRIPTOR);
        }

        public static IOnBrightnessChangeListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnBrightnessChangeListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnBrightnessChangeListener)) ? new Proxy(iBinder) : (IOnBrightnessChangeListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnBrightnessChangeListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnBrightnessChangeListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onBrightnessChange(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onBrightnessChange(int i) throws RemoteException;
}
