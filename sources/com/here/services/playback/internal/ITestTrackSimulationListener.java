package com.here.services.playback.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ITestTrackSimulationListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.playback.internal.ITestTrackSimulationListener";

    public static class Default implements ITestTrackSimulationListener {
        public IBinder asBinder() {
            return null;
        }

        public void onFinished(int i, Bundle bundle, boolean z) throws RemoteException {
        }

        public void onProgressUpdated(int i) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITestTrackSimulationListener {
        static final int TRANSACTION_onFinished = 2;
        static final int TRANSACTION_onProgressUpdated = 1;

        public static class Proxy implements ITestTrackSimulationListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ITestTrackSimulationListener.DESCRIPTOR;
            }

            public void onFinished(int i, Bundle bundle, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITestTrackSimulationListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onProgressUpdated(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ITestTrackSimulationListener.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ITestTrackSimulationListener.DESCRIPTOR);
        }

        public static ITestTrackSimulationListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ITestTrackSimulationListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITestTrackSimulationListener)) ? new Proxy(iBinder) : (ITestTrackSimulationListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ITestTrackSimulationListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onProgressUpdated(parcel.readInt());
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFinished(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                }
                return true;
            }
            parcel2.writeString(ITestTrackSimulationListener.DESCRIPTOR);
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

    void onFinished(int i, Bundle bundle, boolean z) throws RemoteException;

    void onProgressUpdated(int i) throws RemoteException;
}
