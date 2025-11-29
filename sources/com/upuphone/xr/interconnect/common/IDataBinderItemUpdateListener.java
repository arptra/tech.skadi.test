package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.DataBinderValue;

public interface IDataBinderItemUpdateListener extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IDataBinderItemUpdateListener";

    public static class Default implements IDataBinderItemUpdateListener {
        public IBinder asBinder() {
            return null;
        }

        public void onUpdate(DataBinderValue dataBinderValue) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IDataBinderItemUpdateListener {
        static final int TRANSACTION_onUpdate = 1;

        public static class Proxy implements IDataBinderItemUpdateListener {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IDataBinderItemUpdateListener.DESCRIPTOR;
            }

            public void onUpdate(DataBinderValue dataBinderValue) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IDataBinderItemUpdateListener.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, dataBinderValue, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IDataBinderItemUpdateListener.DESCRIPTOR);
        }

        public static IDataBinderItemUpdateListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IDataBinderItemUpdateListener.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDataBinderItemUpdateListener)) ? new Proxy(iBinder) : (IDataBinderItemUpdateListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IDataBinderItemUpdateListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IDataBinderItemUpdateListener.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onUpdate((DataBinderValue) _Parcel.readTypedObject(parcel, DataBinderValue.CREATOR));
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

    void onUpdate(DataBinderValue dataBinderValue) throws RemoteException;
}
