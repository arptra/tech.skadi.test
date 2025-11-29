package com.here.services.radiomap.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface RadioMapActionListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.radiomap.internal.RadioMapActionListener";

    public static class Default implements RadioMapActionListener {
        public IBinder asBinder() {
            return null;
        }

        public void onRadioMapActionProgress(int i) throws RemoteException {
        }

        public void onRadioMapQueryActionComplete(int i, long j) throws RemoteException {
        }

        public void onRadioMapStorageActionComplete(int i) throws RemoteException {
        }

        public void onSessionClosed() throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements RadioMapActionListener {
        static final int TRANSACTION_onRadioMapActionProgress = 1;
        static final int TRANSACTION_onRadioMapQueryActionComplete = 2;
        static final int TRANSACTION_onRadioMapStorageActionComplete = 3;
        static final int TRANSACTION_onSessionClosed = 4;

        public static class Proxy implements RadioMapActionListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return RadioMapActionListener.DESCRIPTOR;
            }

            public void onRadioMapActionProgress(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(RadioMapActionListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onRadioMapQueryActionComplete(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(RadioMapActionListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onRadioMapStorageActionComplete(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(RadioMapActionListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onSessionClosed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(RadioMapActionListener.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, RadioMapActionListener.DESCRIPTOR);
        }

        public static RadioMapActionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(RadioMapActionListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof RadioMapActionListener)) ? new Proxy(iBinder) : (RadioMapActionListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(RadioMapActionListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onRadioMapActionProgress(parcel.readInt());
                } else if (i == 2) {
                    onRadioMapQueryActionComplete(parcel.readInt(), parcel.readLong());
                } else if (i == 3) {
                    onRadioMapStorageActionComplete(parcel.readInt());
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onSessionClosed();
                }
                return true;
            }
            parcel2.writeString(RadioMapActionListener.DESCRIPTOR);
            return true;
        }
    }

    void onRadioMapActionProgress(int i) throws RemoteException;

    void onRadioMapQueryActionComplete(int i, long j) throws RemoteException;

    void onRadioMapStorageActionComplete(int i) throws RemoteException;

    void onSessionClosed() throws RemoteException;
}
