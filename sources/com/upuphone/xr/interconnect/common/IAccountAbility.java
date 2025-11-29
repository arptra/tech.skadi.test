package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IAccountCallback;
import com.upuphone.xr.interconnect.common.ITokenCallback;

public interface IAccountAbility extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IAccountAbility";

    public static class Default implements IAccountAbility {
        public IBinder asBinder() {
            return null;
        }

        public void exitApp() throws RemoteException {
        }

        public void getAccount(String str, IAccountCallback iAccountCallback) throws RemoteException {
        }

        public void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAccountAbility {
        static final int TRANSACTION_exitApp = 3;
        static final int TRANSACTION_getAccount = 2;
        static final int TRANSACTION_getToken = 1;

        public static class Proxy implements IAccountAbility {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void exitApp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAccountAbility.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void getAccount(String str, IAccountCallback iAccountCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAccountAbility.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iAccountCallback);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IAccountAbility.DESCRIPTOR;
            }

            public void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAccountAbility.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeStrongInterface(iTokenCallback);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAccountAbility.DESCRIPTOR);
        }

        public static IAccountAbility asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAccountAbility.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAccountAbility)) ? new Proxy(iBinder) : (IAccountAbility) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAccountAbility.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    boolean z = false;
                    boolean z2 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    getToken(z2, z, ITokenCallback.Stub.asInterface(parcel.readStrongBinder()));
                } else if (i == 2) {
                    getAccount(parcel.readString(), IAccountCallback.Stub.asInterface(parcel.readStrongBinder()));
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    exitApp();
                }
                return true;
            }
            parcel2.writeString(IAccountAbility.DESCRIPTOR);
            return true;
        }
    }

    void exitApp() throws RemoteException;

    void getAccount(String str, IAccountCallback iAccountCallback) throws RemoteException;

    void getToken(boolean z, boolean z2, ITokenCallback iTokenCallback) throws RemoteException;
}
