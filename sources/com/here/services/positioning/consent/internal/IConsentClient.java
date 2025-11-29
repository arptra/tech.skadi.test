package com.here.services.positioning.consent.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IConsentClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.positioning.consent.internal.IConsentClient";

    public static class Default implements IConsentClient {
        public IBinder asBinder() {
            return null;
        }

        public void onConsentUpdated(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IConsentClient {
        static final int TRANSACTION_onConsentUpdated = 1;

        public static class Proxy implements IConsentClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IConsentClient.DESCRIPTOR;
            }

            public void onConsentUpdated(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IConsentClient.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IConsentClient.DESCRIPTOR);
        }

        public static IConsentClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IConsentClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IConsentClient)) ? new Proxy(iBinder) : (IConsentClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IConsentClient.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IConsentClient.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onConsentUpdated(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onConsentUpdated(int i) throws RemoteException;
}
