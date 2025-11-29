package com.here.services.location.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.posclient.UpdateOptions;
import com.here.services.common.PositioningError;

public interface PositionListener extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.location.internal.PositionListener";

    public static class Default implements PositionListener {
        public IBinder asBinder() {
            return null;
        }

        public void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) throws RemoteException {
        }

        public void onPositionInfoChanged(PositioningError positioningError) throws RemoteException {
        }

        public void onPositionResolvingFailed(PositioningError positioningError) throws RemoteException {
        }

        public void onPositionUpdate(Location location) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements PositionListener {
        static final int TRANSACTION_onOptionsChanged = 4;
        static final int TRANSACTION_onPositionInfoChanged = 1;
        static final int TRANSACTION_onPositionResolvingFailed = 3;
        static final int TRANSACTION_onPositionUpdate = 2;

        public static class Proxy implements PositionListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return PositionListener.DESCRIPTOR;
            }

            public void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(PositionListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, updateOptions, 0);
                    _Parcel.writeTypedObject(obtain, updateOptions2, 0);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onPositionInfoChanged(PositioningError positioningError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(PositionListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, positioningError, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onPositionResolvingFailed(PositioningError positioningError) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(PositionListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, positioningError, 0);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onPositionUpdate(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(PositionListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, location, 0);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, PositionListener.DESCRIPTOR);
        }

        public static PositionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(PositionListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof PositionListener)) ? new Proxy(iBinder) : (PositionListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(PositionListener.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onPositionInfoChanged((PositioningError) _Parcel.readTypedObject(parcel, PositioningError.CREATOR));
                } else if (i == 2) {
                    onPositionUpdate((Location) _Parcel.readTypedObject(parcel, Location.CREATOR));
                } else if (i == 3) {
                    onPositionResolvingFailed((PositioningError) _Parcel.readTypedObject(parcel, PositioningError.CREATOR));
                } else if (i != 4) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    Parcelable.Creator<UpdateOptions> creator = UpdateOptions.CREATOR;
                    onOptionsChanged((UpdateOptions) _Parcel.readTypedObject(parcel, creator), (UpdateOptions) _Parcel.readTypedObject(parcel, creator));
                }
                return true;
            }
            parcel2.writeString(PositionListener.DESCRIPTOR);
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

    void onOptionsChanged(UpdateOptions updateOptions, UpdateOptions updateOptions2) throws RemoteException;

    void onPositionInfoChanged(PositioningError positioningError) throws RemoteException;

    void onPositionResolvingFailed(PositioningError positioningError) throws RemoteException;

    void onPositionUpdate(Location location) throws RemoteException;
}
