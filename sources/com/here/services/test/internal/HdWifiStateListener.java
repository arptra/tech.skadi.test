package com.here.services.test.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface HdWifiStateListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.test.internal.HdWifiStateListener";

    public static class Default implements HdWifiStateListener {
        public IBinder asBinder() {
            return null;
        }

        public void onStateUpdate(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements HdWifiStateListener {
        static final int TRANSACTION_onStateUpdate = 1;

        public static class Proxy implements HdWifiStateListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return HdWifiStateListener.DESCRIPTOR;
            }

            public void onStateUpdate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(HdWifiStateListener.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, HdWifiStateListener.DESCRIPTOR);
        }

        public static HdWifiStateListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(HdWifiStateListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof HdWifiStateListener)) ? new Proxy(iBinder) : (HdWifiStateListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(HdWifiStateListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(HdWifiStateListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onStateUpdate(parcel.readString());
                return true;
            }
        }
    }

    void onStateUpdate(String str) throws RemoteException;
}
