package com.here.services.crowdsource.hd.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.here.services.crowdsource.hd.internal.IHdWifiCollectionActivityListener;

public interface IHdWifiCollectionController extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.crowdsource.hd.internal.IHdWifiCollectionController";

    public static class Default implements IHdWifiCollectionController {
        public IBinder asBinder() {
            return null;
        }

        public boolean registerActivityEvents(IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) throws RemoteException {
            return false;
        }

        public boolean sendEvent(String str) throws RemoteException {
            return false;
        }

        public boolean setWifiIntervals(int i, int i2) throws RemoteException {
            return false;
        }

        public void unregisterActivityEvents(IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IHdWifiCollectionController {
        static final int TRANSACTION_registerActivityEvents = 3;
        static final int TRANSACTION_sendEvent = 1;
        static final int TRANSACTION_setWifiIntervals = 2;
        static final int TRANSACTION_unregisterActivityEvents = 4;

        public static class Proxy implements IHdWifiCollectionController {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IHdWifiCollectionController.DESCRIPTOR;
            }

            public boolean registerActivityEvents(IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IHdWifiCollectionController.DESCRIPTOR);
                    obtain.writeStrongInterface(iHdWifiCollectionActivityListener);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public boolean sendEvent(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IHdWifiCollectionController.DESCRIPTOR);
                    obtain.writeString(str);
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

            public boolean setWifiIntervals(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IHdWifiCollectionController.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
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

            public void unregisterActivityEvents(IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IHdWifiCollectionController.DESCRIPTOR);
                    obtain.writeStrongInterface(iHdWifiCollectionActivityListener);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IHdWifiCollectionController.DESCRIPTOR);
        }

        public static IHdWifiCollectionController asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IHdWifiCollectionController.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHdWifiCollectionController)) ? new Proxy(iBinder) : (IHdWifiCollectionController) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IHdWifiCollectionController.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    boolean sendEvent = sendEvent(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(sendEvent ? 1 : 0);
                } else if (i == 2) {
                    boolean wifiIntervals = setWifiIntervals(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(wifiIntervals ? 1 : 0);
                } else if (i == 3) {
                    boolean registerActivityEvents = registerActivityEvents(IHdWifiCollectionActivityListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerActivityEvents ? 1 : 0);
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    unregisterActivityEvents(IHdWifiCollectionActivityListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IHdWifiCollectionController.DESCRIPTOR);
            return true;
        }
    }

    boolean registerActivityEvents(IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) throws RemoteException;

    boolean sendEvent(String str) throws RemoteException;

    boolean setWifiIntervals(int i, int i2) throws RemoteException;

    void unregisterActivityEvents(IHdWifiCollectionActivityListener iHdWifiCollectionActivityListener) throws RemoteException;
}
