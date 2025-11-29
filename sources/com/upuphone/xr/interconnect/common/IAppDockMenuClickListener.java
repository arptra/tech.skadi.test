package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppDockMenuClickListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IAppDockMenuClickListener";

    public static class Default implements IAppDockMenuClickListener {
        public IBinder asBinder() {
            return null;
        }

        public void onDockMenuClick(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAppDockMenuClickListener {
        static final int TRANSACTION_onDockMenuClick = 1;

        public static class Proxy implements IAppDockMenuClickListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppDockMenuClickListener.DESCRIPTOR;
            }

            public void onDockMenuClick(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAppDockMenuClickListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAppDockMenuClickListener.DESCRIPTOR);
        }

        public static IAppDockMenuClickListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAppDockMenuClickListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAppDockMenuClickListener)) ? new Proxy(iBinder) : (IAppDockMenuClickListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAppDockMenuClickListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAppDockMenuClickListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onDockMenuClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onDockMenuClick(String str) throws RemoteException;
}
