package com.here.services.crowdsource.hd.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IHdWifiCollectionActivityListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.crowdsource.hd.internal.IHdWifiCollectionActivityListener";

    public static class Default implements IHdWifiCollectionActivityListener {
        public IBinder asBinder() {
            return null;
        }

        public void onActivityEvent(Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IHdWifiCollectionActivityListener {
        static final int TRANSACTION_onActivityEvent = 1;

        public static class Proxy implements IHdWifiCollectionActivityListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IHdWifiCollectionActivityListener.DESCRIPTOR;
            }

            public void onActivityEvent(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IHdWifiCollectionActivityListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IHdWifiCollectionActivityListener.DESCRIPTOR);
        }

        public static IHdWifiCollectionActivityListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IHdWifiCollectionActivityListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHdWifiCollectionActivityListener)) ? new Proxy(iBinder) : (IHdWifiCollectionActivityListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IHdWifiCollectionActivityListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IHdWifiCollectionActivityListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onActivityEvent((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            }
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

    void onActivityEvent(Bundle bundle) throws RemoteException;
}
