package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IClient;

public interface ICommonAggregate extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.ICommonAggregate";

    public static class Default implements ICommonAggregate {
        public IBinder asBinder() {
            return null;
        }

        public IBinder queryService(int i) throws RemoteException {
            return null;
        }

        public void register(IClient iClient, String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICommonAggregate {
        static final int TRANSACTION_queryService = 1;
        static final int TRANSACTION_register = 2;

        public static class Proxy implements ICommonAggregate {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ICommonAggregate.DESCRIPTOR;
            }

            public IBinder queryService(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICommonAggregate.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void register(IClient iClient, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICommonAggregate.DESCRIPTOR);
                    obtain.writeStrongInterface(iClient);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICommonAggregate.DESCRIPTOR);
        }

        public static ICommonAggregate asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ICommonAggregate.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICommonAggregate)) ? new Proxy(iBinder) : (ICommonAggregate) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ICommonAggregate.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    IBinder queryService = queryService(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(queryService);
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    register(IClient.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(ICommonAggregate.DESCRIPTOR);
            return true;
        }
    }

    IBinder queryService(int i) throws RemoteException;

    void register(IClient iClient, String str) throws RemoteException;
}
