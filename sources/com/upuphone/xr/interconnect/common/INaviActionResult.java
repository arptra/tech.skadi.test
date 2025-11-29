package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface INaviActionResult extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.INaviActionResult";

    public static class Default implements INaviActionResult {
        public void actionFailure(String str, int i) throws RemoteException {
        }

        public void actionSuceess(String str, int i) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements INaviActionResult {
        static final int TRANSACTION_actionFailure = 2;
        static final int TRANSACTION_actionSuceess = 1;

        public static class Proxy implements INaviActionResult {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void actionFailure(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviActionResult.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void actionSuceess(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviActionResult.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return INaviActionResult.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, INaviActionResult.DESCRIPTOR);
        }

        public static INaviActionResult asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INaviActionResult.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INaviActionResult)) ? new Proxy(iBinder) : (INaviActionResult) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INaviActionResult.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    actionSuceess(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    actionFailure(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(INaviActionResult.DESCRIPTOR);
            return true;
        }
    }

    void actionFailure(String str, int i) throws RemoteException;

    void actionSuceess(String str, int i) throws RemoteException;
}
