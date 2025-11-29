package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IClient extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IClient";

    public static class Default implements IClient {
        public IBinder asBinder() {
            return null;
        }

        public void connectSuccess() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IClient {
        static final int TRANSACTION_connectSuccess = 1;

        public static class Proxy implements IClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void connectSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IClient.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IClient.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IClient.DESCRIPTOR);
        }

        public static IClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IClient)) ? new Proxy(iBinder) : (IClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IClient.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IClient.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                connectSuccess();
                return true;
            }
        }
    }

    void connectSuccess() throws RemoteException;
}
