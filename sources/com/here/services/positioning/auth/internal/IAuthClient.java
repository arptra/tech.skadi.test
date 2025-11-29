package com.here.services.positioning.auth.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.services.positioning.auth.internal.AuthListener;

public interface IAuthClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.positioning.auth.internal.IAuthClient";

    public static class Default implements IAuthClient {
        public IBinder asBinder() {
            return null;
        }

        public int setAuthData(Bundle bundle) throws RemoteException {
            return 0;
        }

        public int subscribe(AuthListener authListener) throws RemoteException {
            return 0;
        }

        public int unsubscribe() throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IAuthClient {
        static final int TRANSACTION_setAuthData = 1;
        static final int TRANSACTION_subscribe = 2;
        static final int TRANSACTION_unsubscribe = 3;

        public static class Proxy implements IAuthClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAuthClient.DESCRIPTOR;
            }

            public int setAuthData(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAuthClient.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int subscribe(AuthListener authListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAuthClient.DESCRIPTOR);
                    obtain.writeStrongInterface(authListener);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unsubscribe() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAuthClient.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAuthClient.DESCRIPTOR);
        }

        public static IAuthClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAuthClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAuthClient)) ? new Proxy(iBinder) : (IAuthClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAuthClient.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    int authData = setAuthData((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(authData);
                } else if (i == 2) {
                    int subscribe = subscribe(AuthListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(subscribe);
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    int unsubscribe = unsubscribe();
                    parcel2.writeNoException();
                    parcel2.writeInt(unsubscribe);
                }
                return true;
            }
            parcel2.writeString(IAuthClient.DESCRIPTOR);
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

    int setAuthData(Bundle bundle) throws RemoteException;

    int subscribe(AuthListener authListener) throws RemoteException;

    int unsubscribe() throws RemoteException;
}
