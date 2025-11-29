package com.upuphone.xr.sapp.vu.arspace;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnRequestChangeLanguageListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.sapp.vu.arspace.IOnRequestChangeLanguageListener";

    public static class Default implements IOnRequestChangeLanguageListener {
        public IBinder asBinder() {
            return null;
        }

        public void onRequestChangeLanguage(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IOnRequestChangeLanguageListener {
        static final int TRANSACTION_onRequestChangeLanguage = 1;

        public static class Proxy implements IOnRequestChangeLanguageListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOnRequestChangeLanguageListener.DESCRIPTOR;
            }

            public void onRequestChangeLanguage(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IOnRequestChangeLanguageListener.DESCRIPTOR);
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
            attachInterface(this, IOnRequestChangeLanguageListener.DESCRIPTOR);
        }

        public static IOnRequestChangeLanguageListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IOnRequestChangeLanguageListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IOnRequestChangeLanguageListener)) ? new Proxy(iBinder) : (IOnRequestChangeLanguageListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IOnRequestChangeLanguageListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IOnRequestChangeLanguageListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onRequestChangeLanguage(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void onRequestChangeLanguage(String str) throws RemoteException;
}
