package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITransAbility extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.ITransAbility";

    public static class Default implements ITransAbility {
        public IBinder asBinder() {
            return null;
        }

        public int getTransCurrentState() throws RemoteException {
            return 0;
        }

        public boolean isSupportLanguage(boolean z, int i, String str, String str2) throws RemoteException {
            return false;
        }

        public boolean isTransStarted() throws RemoteException {
            return false;
        }

        public int startTranslation(int i) throws RemoteException {
            return 0;
        }

        public int stopTranslation(int i) throws RemoteException {
            return 0;
        }

        public int switchLang(String str, String str2) throws RemoteException {
            return 0;
        }

        public int switchLanguage(boolean z, int i, String str, String str2) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ITransAbility {
        static final int TRANSACTION_getTransCurrentState = 6;
        static final int TRANSACTION_isSupportLanguage = 7;
        static final int TRANSACTION_isTransStarted = 1;
        static final int TRANSACTION_startTranslation = 4;
        static final int TRANSACTION_stopTranslation = 5;
        static final int TRANSACTION_switchLang = 2;
        static final int TRANSACTION_switchLanguage = 3;

        public static class Proxy implements ITransAbility {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITransAbility.DESCRIPTOR;
            }

            public int getTransCurrentState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITransAbility.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isSupportLanguage(boolean z, int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITransAbility.DESCRIPTOR);
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isTransStarted() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITransAbility.DESCRIPTOR);
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

            public int startTranslation(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITransAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stopTranslation(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITransAbility.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int switchLang(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITransAbility.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int switchLanguage(boolean z, int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITransAbility.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
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
            attachInterface(this, ITransAbility.DESCRIPTOR);
        }

        public static ITransAbility asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITransAbility.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITransAbility)) ? new Proxy(iBinder) : (ITransAbility) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITransAbility.DESCRIPTOR);
            }
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        boolean isTransStarted = isTransStarted();
                        parcel2.writeNoException();
                        parcel2.writeInt(isTransStarted ? 1 : 0);
                        break;
                    case 2:
                        int switchLang = switchLang(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(switchLang);
                        break;
                    case 3:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        int switchLanguage = switchLanguage(z, parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(switchLanguage);
                        break;
                    case 4:
                        int startTranslation = startTranslation(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(startTranslation);
                        break;
                    case 5:
                        int stopTranslation = stopTranslation(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(stopTranslation);
                        break;
                    case 6:
                        int transCurrentState = getTransCurrentState();
                        parcel2.writeNoException();
                        parcel2.writeInt(transCurrentState);
                        break;
                    case 7:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean isSupportLanguage = isSupportLanguage(z, parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupportLanguage ? 1 : 0);
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(ITransAbility.DESCRIPTOR);
            return true;
        }
    }

    int getTransCurrentState() throws RemoteException;

    boolean isSupportLanguage(boolean z, int i, String str, String str2) throws RemoteException;

    boolean isTransStarted() throws RemoteException;

    int startTranslation(int i) throws RemoteException;

    int stopTranslation(int i) throws RemoteException;

    int switchLang(String str, String str2) throws RemoteException;

    int switchLanguage(boolean z, int i, String str, String str2) throws RemoteException;
}
