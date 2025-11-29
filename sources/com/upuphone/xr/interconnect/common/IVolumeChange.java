package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IVolumeChange extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IVolumeChange";

    public static class Default implements IVolumeChange {
        public IBinder asBinder() {
            return null;
        }

        public void onMessageReceive(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IVolumeChange {
        static final int TRANSACTION_onMessageReceive = 1;

        public static class Proxy implements IVolumeChange {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IVolumeChange.DESCRIPTOR;
            }

            public void onMessageReceive(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IVolumeChange.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IVolumeChange.DESCRIPTOR);
        }

        public static IVolumeChange asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IVolumeChange.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IVolumeChange)) ? new Proxy(iBinder) : (IVolumeChange) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IVolumeChange.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IVolumeChange.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onMessageReceive(parcel.readInt());
                return true;
            }
        }
    }

    void onMessageReceive(int i) throws RemoteException;
}
