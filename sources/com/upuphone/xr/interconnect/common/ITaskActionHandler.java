package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITaskActionHandler extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.ITaskActionHandler";

    public static class Default implements ITaskActionHandler {
        public IBinder asBinder() {
            return null;
        }

        public boolean onAction(String str) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ITaskActionHandler {
        static final int TRANSACTION_onAction = 1;

        public static class Proxy implements ITaskActionHandler {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITaskActionHandler.DESCRIPTOR;
            }

            public boolean onAction(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITaskActionHandler.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITaskActionHandler.DESCRIPTOR);
        }

        public static ITaskActionHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITaskActionHandler.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITaskActionHandler)) ? new Proxy(iBinder) : (ITaskActionHandler) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITaskActionHandler.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ITaskActionHandler.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                boolean onAction = onAction(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(onAction ? 1 : 0);
                return true;
            }
        }
    }

    boolean onAction(String str) throws RemoteException;
}
