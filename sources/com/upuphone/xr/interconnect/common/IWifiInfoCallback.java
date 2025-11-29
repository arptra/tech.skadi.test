package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.StarryNetWifiInfo;

public interface IWifiInfoCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IWifiInfoCallback";

    public static class Default implements IWifiInfoCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onResult(StarryNetWifiInfo starryNetWifiInfo) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWifiInfoCallback {
        static final int TRANSACTION_onResult = 1;

        public static class Proxy implements IWifiInfoCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IWifiInfoCallback.DESCRIPTOR;
            }

            public void onResult(StarryNetWifiInfo starryNetWifiInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWifiInfoCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetWifiInfo, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        starryNetWifiInfo.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IWifiInfoCallback.DESCRIPTOR);
        }

        public static IWifiInfoCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWifiInfoCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IWifiInfoCallback)) ? new Proxy(iBinder) : (IWifiInfoCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWifiInfoCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IWifiInfoCallback.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                StarryNetWifiInfo starryNetWifiInfo = (StarryNetWifiInfo) _Parcel.readTypedObject(parcel, StarryNetWifiInfo.CREATOR);
                onResult(starryNetWifiInfo);
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, starryNetWifiInfo, 1);
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

    void onResult(StarryNetWifiInfo starryNetWifiInfo) throws RemoteException;
}
