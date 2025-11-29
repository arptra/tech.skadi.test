package com.upuphone.xr.interconnect.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.upuphone.xr.interconnect.entity.AIModelResult;

public interface IAIModelResult extends IInterface {
    public static final String DESCRIPTOR = "com.upuphone.xr.interconnect.common.IAIModelResult";

    public static class Default implements IAIModelResult {
        public void aiResult(AIModelResult aIModelResult) throws RemoteException {
        }

        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IAIModelResult {
        static final int TRANSACTION_aiResult = 1;

        public static class Proxy implements IAIModelResult {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void aiResult(AIModelResult aIModelResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IAIModelResult.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, aIModelResult, 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        aIModelResult.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IAIModelResult.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, IAIModelResult.DESCRIPTOR);
        }

        public static IAIModelResult asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IAIModelResult.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIModelResult)) ? new Proxy(iBinder) : (IAIModelResult) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IAIModelResult.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IAIModelResult.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                AIModelResult aIModelResult = (AIModelResult) _Parcel.readTypedObject(parcel, AIModelResult.CREATOR);
                aiResult(aIModelResult);
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, aIModelResult, 1);
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

    void aiResult(AIModelResult aIModelResult) throws RemoteException;
}
