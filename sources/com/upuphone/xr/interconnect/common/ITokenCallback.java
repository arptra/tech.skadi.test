package com.upuphone.xr.interconnect.common;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ITokenCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.ITokenCallback";

    public static class Default implements ITokenCallback {
        public IBinder asBinder() {
            return null;
        }

        public boolean onAuthError(int i, String str) throws RemoteException {
            return false;
        }

        public void onAuthIntent(Intent intent) throws RemoteException {
        }

        public void onAuthSuccess(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITokenCallback {
        static final int TRANSACTION_onAuthError = 2;
        static final int TRANSACTION_onAuthIntent = 3;
        static final int TRANSACTION_onAuthSuccess = 1;

        public static class Proxy implements ITokenCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITokenCallback.DESCRIPTOR;
            }

            public boolean onAuthError(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITokenCallback.DESCRIPTOR);
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

            public void onAuthIntent(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITokenCallback.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        intent.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAuthSuccess(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITokenCallback.DESCRIPTOR);
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
            attachInterface(this, ITokenCallback.DESCRIPTOR);
        }

        public static ITokenCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITokenCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITokenCallback)) ? new Proxy(iBinder) : (ITokenCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITokenCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onAuthSuccess(parcel.readString());
                    parcel2.writeNoException();
                } else if (i == 2) {
                    boolean onAuthError = onAuthError(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(onAuthError ? 1 : 0);
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    Intent intent = new Intent();
                    onAuthIntent(intent);
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, intent, 1);
                }
                return true;
            }
            parcel2.writeString(ITokenCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
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

    boolean onAuthError(int i, String str) throws RemoteException;

    void onAuthIntent(Intent intent) throws RemoteException;

    void onAuthSuccess(String str) throws RemoteException;
}
