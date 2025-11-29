package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.common.IAppDockMenuClickListener;
import com.upuphone.xr.interconnect.entity.StarryNetApp;

public interface IAppManager extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IAppManager";

    public static class Default implements IAppManager {
        public IBinder asBinder() {
            return null;
        }

        public void registerMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException {
        }

        public void unregisterMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException {
        }

        public void updateApp(StarryNetApp starryNetApp) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IAppManager {
        static final int TRANSACTION_registerMenuClickListener = 2;
        static final int TRANSACTION_unregisterMenuClickListener = 3;
        static final int TRANSACTION_updateApp = 1;

        public static class Proxy implements IAppManager {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAppManager.DESCRIPTOR;
            }

            public void registerMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAppManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iAppDockMenuClickListener);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAppManager.DESCRIPTOR);
                    obtain.writeStrongInterface(iAppDockMenuClickListener);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateApp(StarryNetApp starryNetApp) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAppManager.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetApp, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IAppManager.DESCRIPTOR);
        }

        public static IAppManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAppManager.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAppManager)) ? new Proxy(iBinder) : (IAppManager) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAppManager.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    updateApp((StarryNetApp) _Parcel.readTypedObject(parcel, StarryNetApp.CREATOR));
                } else if (i == 2) {
                    registerMenuClickListener(IAppDockMenuClickListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                } else if (i != 3) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    unregisterMenuClickListener(IAppDockMenuClickListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                }
                return true;
            }
            parcel2.writeString(IAppManager.DESCRIPTOR);
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

    void registerMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException;

    void unregisterMenuClickListener(IAppDockMenuClickListener iAppDockMenuClickListener) throws RemoteException;

    void updateApp(StarryNetApp starryNetApp) throws RemoteException;
}
