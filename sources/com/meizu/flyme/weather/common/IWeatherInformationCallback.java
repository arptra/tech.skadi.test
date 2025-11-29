package com.meizu.flyme.weather.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IWeatherInformationCallback extends IInterface {
    public static final String DESCRIPTOR = "com.meizu.flyme.weather.common.IWeatherInformationCallback";

    public static class Default implements IWeatherInformationCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onError(int i, String str, String str2) throws RemoteException {
        }

        public void onOther(int i, String str, String str2) throws RemoteException {
        }

        public void onSuccess(int i, String str, String str2) throws RemoteException {
        }

        public void userAction(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWeatherInformationCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onOther = 3;
        static final int TRANSACTION_onSuccess = 1;
        static final int TRANSACTION_userAction = 4;

        public static class Proxy implements IWeatherInformationCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWeatherInformationCallback.DESCRIPTOR;
            }

            public void onError(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onOther(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void userAction(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWeatherInformationCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IWeatherInformationCallback.DESCRIPTOR);
        }

        public static IWeatherInformationCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWeatherInformationCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IWeatherInformationCallback)) ? new Proxy(iBinder) : (IWeatherInformationCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWeatherInformationCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onSuccess(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                } else if (i == 2) {
                    onError(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                } else if (i == 3) {
                    onOther(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    userAction(parcel.readString());
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IWeatherInformationCallback.DESCRIPTOR);
            return true;
        }
    }

    void onError(int i, String str, String str2) throws RemoteException;

    void onOther(int i, String str, String str2) throws RemoteException;

    void onSuccess(int i, String str, String str2) throws RemoteException;

    void userAction(String str) throws RemoteException;
}
