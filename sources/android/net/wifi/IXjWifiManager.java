package android.net.wifi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IXjWifiManager extends IInterface {

    public static class Default implements IXjWifiManager {
        public IBinder asBinder() {
            return null;
        }

        public void setLowLatencyMode(int i, boolean z) throws RemoteException {
        }

        public void setStaticIp(String str) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IXjWifiManager {
        private static final String DESCRIPTOR = "android.net.wifi.IXjWifiManager";
        static final int TRANSACTION_setLowLatencyMode = 1;
        static final int TRANSACTION_setStaticIp = 2;

        public static class Proxy implements IXjWifiManager {
            public static IXjWifiManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void setLowLatencyMode(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setLowLatencyMode(i, z);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setStaticIp(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().setStaticIp(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IXjWifiManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IXjWifiManager)) ? new Proxy(iBinder) : (IXjWifiManager) queryLocalInterface;
        }

        public static IXjWifiManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IXjWifiManager iXjWifiManager) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iXjWifiManager == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iXjWifiManager;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                setLowLatencyMode(parcel.readInt(), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                setStaticIp(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void setLowLatencyMode(int i, boolean z) throws RemoteException;

    void setStaticIp(String str) throws RemoteException;
}
