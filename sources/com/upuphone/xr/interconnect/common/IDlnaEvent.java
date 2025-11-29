package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDlnaEvent extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDlnaEvent";

    public static class Default implements IDlnaEvent {
        public IBinder asBinder() {
            return null;
        }

        public void remotePause() throws RemoteException {
        }

        public void remotePlay() throws RemoteException {
        }

        public void remoteSeek(long j) throws RemoteException {
        }

        public void remoteSetUrl(String str) throws RemoteException {
        }

        public void remoteSetvolume(int i) throws RemoteException {
        }

        public void remoteStop() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDlnaEvent {
        static final int TRANSACTION_remotePause = 2;
        static final int TRANSACTION_remotePlay = 3;
        static final int TRANSACTION_remoteSeek = 4;
        static final int TRANSACTION_remoteSetUrl = 1;
        static final int TRANSACTION_remoteSetvolume = 6;
        static final int TRANSACTION_remoteStop = 5;

        public static class Proxy implements IDlnaEvent {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDlnaEvent.DESCRIPTOR;
            }

            public void remotePause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaEvent.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void remotePlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaEvent.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void remoteSeek(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaEvent.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void remoteSetUrl(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaEvent.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void remoteSetvolume(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaEvent.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void remoteStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDlnaEvent.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDlnaEvent.DESCRIPTOR);
        }

        public static IDlnaEvent asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDlnaEvent.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDlnaEvent)) ? new Proxy(iBinder) : (IDlnaEvent) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDlnaEvent.DESCRIPTOR);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        remoteSetUrl(parcel.readString());
                        break;
                    case 2:
                        remotePause();
                        break;
                    case 3:
                        remotePlay();
                        break;
                    case 4:
                        remoteSeek(parcel.readLong());
                        break;
                    case 5:
                        remoteStop();
                        break;
                    case 6:
                        remoteSetvolume(parcel.readInt());
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(IDlnaEvent.DESCRIPTOR);
            return true;
        }
    }

    void remotePause() throws RemoteException;

    void remotePlay() throws RemoteException;

    void remoteSeek(long j) throws RemoteException;

    void remoteSetUrl(String str) throws RemoteException;

    void remoteSetvolume(int i) throws RemoteException;

    void remoteStop() throws RemoteException;
}
