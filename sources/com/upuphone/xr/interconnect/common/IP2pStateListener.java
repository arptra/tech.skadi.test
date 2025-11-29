package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IP2pStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IP2pStateListener";

    public static class Default implements IP2pStateListener {
        public IBinder asBinder() {
            return null;
        }

        public void onP2pStateChanged(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IP2pStateListener {
        static final int TRANSACTION_onP2pStateChanged = 1;

        public static class Proxy implements IP2pStateListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IP2pStateListener.DESCRIPTOR;
            }

            public void onP2pStateChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IP2pStateListener.DESCRIPTOR);
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
            attachInterface(this, IP2pStateListener.DESCRIPTOR);
        }

        public static IP2pStateListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IP2pStateListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IP2pStateListener)) ? new Proxy(iBinder) : (IP2pStateListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IP2pStateListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IP2pStateListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onP2pStateChanged(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onP2pStateChanged(int i) throws RemoteException;
}
