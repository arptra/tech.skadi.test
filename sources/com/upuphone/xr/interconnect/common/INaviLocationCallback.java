package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;

public interface INaviLocationCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.INaviLocationCallback";

    public static class Default implements INaviLocationCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onLocationChanged(NaviLocationInfo naviLocationInfo) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements INaviLocationCallback {
        static final int TRANSACTION_onLocationChanged = 1;

        public static class Proxy implements INaviLocationCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return INaviLocationCallback.DESCRIPTOR;
            }

            public void onLocationChanged(NaviLocationInfo naviLocationInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviLocationCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, naviLocationInfo, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, INaviLocationCallback.DESCRIPTOR);
        }

        public static INaviLocationCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INaviLocationCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INaviLocationCallback)) ? new Proxy(iBinder) : (INaviLocationCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INaviLocationCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(INaviLocationCallback.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onLocationChanged((NaviLocationInfo) _Parcel.readTypedObject(parcel, NaviLocationInfo.CREATOR));
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

    void onLocationChanged(NaviLocationInfo naviLocationInfo) throws RemoteException;
}
