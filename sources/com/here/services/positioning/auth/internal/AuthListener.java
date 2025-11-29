package com.here.services.positioning.auth.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface AuthListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.positioning.auth.internal.AuthListener";

    public static class Default implements AuthListener {
        public IBinder asBinder() {
            return null;
        }

        public void onAuthDataRequested() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements AuthListener {
        static final int TRANSACTION_onAuthDataRequested = 1;

        public static class Proxy implements AuthListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return AuthListener.DESCRIPTOR;
            }

            public void onAuthDataRequested() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AuthListener.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, AuthListener.DESCRIPTOR);
        }

        public static AuthListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(AuthListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof AuthListener)) ? new Proxy(iBinder) : (AuthListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(AuthListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(AuthListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onAuthDataRequested();
                return true;
            }
        }
    }

    void onAuthDataRequested() throws RemoteException;
}
