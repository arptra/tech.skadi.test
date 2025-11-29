package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IDlnaEvent;
import com.upuphone.xr.interconnect.entity.StarryDlnaMediaInfo;

public interface IDlnaServer extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDlnaServer";

    public static class Default implements IDlnaServer {
        public IBinder asBinder() {
            return null;
        }

        public void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo) throws RemoteException {
        }

        public void registerDlnaEvent(IDlnaEvent iDlnaEvent) throws RemoteException {
        }

        public void registerStartPlayerAction(String str) throws RemoteException {
        }

        public void setNotifyConfig(int i, int i2) throws RemoteException {
        }

        public void startDlnaService(String str) throws RemoteException {
        }

        public void stopDlnaService() throws RemoteException {
        }

        public void stopPlay() throws RemoteException {
        }

        public void syncLocalPause() throws RemoteException {
        }

        public void syncLocalPlay() throws RemoteException {
        }

        public void syncRemoteSetVolume() throws RemoteException {
        }

        public void unregisterDlnaEvent() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDlnaServer {
        static final int TRANSACTION_getDlnaInfo = 7;
        static final int TRANSACTION_registerDlnaEvent = 5;
        static final int TRANSACTION_registerStartPlayerAction = 4;
        static final int TRANSACTION_setNotifyConfig = 11;
        static final int TRANSACTION_startDlnaService = 1;
        static final int TRANSACTION_stopDlnaService = 2;
        static final int TRANSACTION_stopPlay = 3;
        static final int TRANSACTION_syncLocalPause = 10;
        static final int TRANSACTION_syncLocalPlay = 9;
        static final int TRANSACTION_syncRemoteSetVolume = 8;
        static final int TRANSACTION_unregisterDlnaEvent = 6;

        public static class Proxy implements IDlnaServer {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryDlnaMediaInfo, 0);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        starryDlnaMediaInfo.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IDlnaServer.DESCRIPTOR;
            }

            public void registerDlnaEvent(IDlnaEvent iDlnaEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    obtain.writeStrongInterface(iDlnaEvent);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void registerStartPlayerAction(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setNotifyConfig(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startDlnaService(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopDlnaService() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void syncLocalPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void syncLocalPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void syncRemoteSetVolume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterDlnaEvent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaServer.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDlnaServer.DESCRIPTOR);
        }

        public static IDlnaServer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDlnaServer.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDlnaServer)) ? new Proxy(iBinder) : (IDlnaServer) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDlnaServer.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        startDlnaService(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 2:
                        stopDlnaService();
                        parcel2.writeNoException();
                        break;
                    case 3:
                        stopPlay();
                        parcel2.writeNoException();
                        break;
                    case 4:
                        registerStartPlayerAction(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 5:
                        registerDlnaEvent(IDlnaEvent.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 6:
                        unregisterDlnaEvent();
                        parcel2.writeNoException();
                        break;
                    case 7:
                        StarryDlnaMediaInfo starryDlnaMediaInfo = (StarryDlnaMediaInfo) _Parcel.readTypedObject(parcel, StarryDlnaMediaInfo.CREATOR);
                        getDlnaInfo(starryDlnaMediaInfo);
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, starryDlnaMediaInfo, 1);
                        break;
                    case 8:
                        syncRemoteSetVolume();
                        parcel2.writeNoException();
                        break;
                    case 9:
                        syncLocalPlay();
                        parcel2.writeNoException();
                        break;
                    case 10:
                        syncLocalPause();
                        parcel2.writeNoException();
                        break;
                    case 11:
                        setNotifyConfig(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IDlnaServer.DESCRIPTOR);
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

    void getDlnaInfo(StarryDlnaMediaInfo starryDlnaMediaInfo) throws RemoteException;

    void registerDlnaEvent(IDlnaEvent iDlnaEvent) throws RemoteException;

    void registerStartPlayerAction(String str) throws RemoteException;

    void setNotifyConfig(int i, int i2) throws RemoteException;

    void startDlnaService(String str) throws RemoteException;

    void stopDlnaService() throws RemoteException;

    void stopPlay() throws RemoteException;

    void syncLocalPause() throws RemoteException;

    void syncLocalPlay() throws RemoteException;

    void syncRemoteSetVolume() throws RemoteException;

    void unregisterDlnaEvent() throws RemoteException;
}
