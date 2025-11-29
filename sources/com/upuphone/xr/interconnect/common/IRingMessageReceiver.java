package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.StarryNetRingMessage;

public interface IRingMessageReceiver extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IRingMessageReceiver";

    public static class Default implements IRingMessageReceiver {
        public IBinder asBinder() {
            return null;
        }

        public void onMessageReceive(StarryNetRingMessage starryNetRingMessage) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IRingMessageReceiver {
        static final int TRANSACTION_onMessageReceive = 1;

        public static class Proxy implements IRingMessageReceiver {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IRingMessageReceiver.DESCRIPTOR;
            }

            public void onMessageReceive(StarryNetRingMessage starryNetRingMessage) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IRingMessageReceiver.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, starryNetRingMessage, 0);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IRingMessageReceiver.DESCRIPTOR);
        }

        public static IRingMessageReceiver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IRingMessageReceiver.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRingMessageReceiver)) ? new Proxy(iBinder) : (IRingMessageReceiver) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IRingMessageReceiver.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IRingMessageReceiver.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onMessageReceive((StarryNetRingMessage) _Parcel.readTypedObject(parcel, StarryNetRingMessage.CREATOR));
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

    void onMessageReceive(StarryNetRingMessage starryNetRingMessage) throws RemoteException;
}
