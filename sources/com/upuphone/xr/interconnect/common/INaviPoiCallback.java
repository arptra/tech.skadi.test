package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.PoiResult;
import java.util.List;

public interface INaviPoiCallback extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.INaviPoiCallback";

    public static class Default implements INaviPoiCallback {
        public IBinder asBinder() {
            return null;
        }

        public void poiCallback(List<PoiResult> list) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements INaviPoiCallback {
        static final int TRANSACTION_poiCallback = 1;

        public static class Proxy implements INaviPoiCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return INaviPoiCallback.DESCRIPTOR;
            }

            public void poiCallback(List<PoiResult> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(INaviPoiCallback.DESCRIPTOR);
                    obtain.writeTypedList(list);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, INaviPoiCallback.DESCRIPTOR);
        }

        public static INaviPoiCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(INaviPoiCallback.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INaviPoiCallback)) ? new Proxy(iBinder) : (INaviPoiCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(INaviPoiCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(INaviPoiCallback.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                poiCallback(parcel.createTypedArrayList(PoiResult.CREATOR));
                return true;
            }
        }
    }

    public static class _Parcel {
        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void poiCallback(List<PoiResult> list) throws RemoteException;
}
