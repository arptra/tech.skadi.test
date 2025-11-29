package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.AccountInfo;

public interface IAccountCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IAccountCallback";

    public static class Default implements IAccountCallback {
        public IBinder asBinder() {
            return null;
        }

        public boolean onFailed(int i, String str) throws RemoteException {
            return false;
        }

        public void onSuccess(AccountInfo accountInfo) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAccountCallback {
        static final int TRANSACTION_onFailed = 2;
        static final int TRANSACTION_onSuccess = 1;

        public static class Proxy implements IAccountCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAccountCallback.DESCRIPTOR;
            }

            public boolean onFailed(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAccountCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

            public void onSuccess(AccountInfo accountInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAccountCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, accountInfo, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        accountInfo.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAccountCallback.DESCRIPTOR);
        }

        public static IAccountCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAccountCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAccountCallback)) ? new Proxy(iBinder) : (IAccountCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAccountCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    AccountInfo accountInfo = (AccountInfo) _Parcel.readTypedObject(parcel, AccountInfo.CREATOR);
                    onSuccess(accountInfo);
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, accountInfo, 1);
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    boolean onFailed = onFailed(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(onFailed ? 1 : 0);
                }
                return true;
            }
            parcel2.writeString(IAccountCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    boolean onFailed(int i, String str) throws RemoteException;

    void onSuccess(AccountInfo accountInfo) throws RemoteException;
}
