package com.here.services.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IServiceNotAvailable extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.internal.IServiceNotAvailable";

    public static class Default implements IServiceNotAvailable {
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IServiceNotAvailable {

        public static class Proxy implements IServiceNotAvailable {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IServiceNotAvailable.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IServiceNotAvailable.DESCRIPTOR);
        }

        public static IServiceNotAvailable asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IServiceNotAvailable.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IServiceNotAvailable)) ? new Proxy(iBinder) : (IServiceNotAvailable) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(IServiceNotAvailable.DESCRIPTOR);
            return true;
        }
    }
}
