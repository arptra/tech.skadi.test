package vendor.xj.hardware.wifi.supplicant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import vendor.xj.hardware.wifi.supplicant.ISupplicantXjStaIface;

public interface ISupplicantXj extends IInterface {
    public static final String DESCRIPTOR = "vendor$xj$hardware$wifi$supplicant$ISupplicantXj".replace('$', '.');
    public static final String HASH = "notfrozen";
    public static final int VERSION = 1;

    public static class Default implements ISupplicantXj {
        public IBinder asBinder() {
            return null;
        }

        public String getInterfaceHash() {
            return "";
        }

        public int getInterfaceVersion() {
            return 0;
        }

        public ISupplicantXjStaIface getXjInterface(IXjIfaceInfo iXjIfaceInfo) throws RemoteException {
            return null;
        }

        public IXjIfaceInfo[] listXjInterfaces() throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ISupplicantXj {
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getXjInterface = 1;
        static final int TRANSACTION_listXjInterfaces = 2;

        public static class Proxy implements ISupplicantXj {
            private String mCachedHash = "-1";
            private int mCachedVersion = -1;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ISupplicantXj.DESCRIPTOR;
            }

            public synchronized String getInterfaceHash() throws RemoteException {
                Parcel obtain;
                Parcel obtain2;
                try {
                    if ("-1".equals(this.mCachedHash)) {
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken(ISupplicantXj.DESCRIPTOR);
                        this.mRemote.transact(Stub.TRANSACTION_getInterfaceHash, obtain, obtain2, 0);
                        obtain2.readException();
                        this.mCachedHash = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                    }
                } catch (Throwable th) {
                    throw th;
                }
                return this.mCachedHash;
            }

            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion == -1) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(ISupplicantXj.DESCRIPTOR);
                        this.mRemote.transact(16777215, obtain, obtain2, 0);
                        obtain2.readException();
                        this.mCachedVersion = obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return this.mCachedVersion;
            }

            public ISupplicantXjStaIface getXjInterface(IXjIfaceInfo iXjIfaceInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ISupplicantXj.DESCRIPTOR);
                    obtain.writeTypedObject(iXjIfaceInfo, 0);
                    if (this.mRemote.transact(1, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return ISupplicantXjStaIface.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    throw new RemoteException("Method getXjInterface is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IXjIfaceInfo[] listXjInterfaces() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ISupplicantXj.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return (IXjIfaceInfo[]) obtain2.createTypedArray(IXjIfaceInfo.CREATOR);
                    }
                    throw new RemoteException("Method listXjInterfaces is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, ISupplicantXj.DESCRIPTOR);
        }

        public static ISupplicantXj asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ISupplicantXj.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISupplicantXj)) ? new Proxy(iBinder) : (ISupplicantXj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = ISupplicantXj.DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            switch (i) {
                case TRANSACTION_getInterfaceHash /*16777214*/:
                    parcel2.writeNoException();
                    parcel2.writeString(getInterfaceHash());
                    return true;
                case 16777215:
                    parcel2.writeNoException();
                    parcel2.writeInt(getInterfaceVersion());
                    return true;
                case 1598968902:
                    parcel2.writeString(str);
                    return true;
                default:
                    if (i == 1) {
                        ISupplicantXjStaIface xjInterface = getXjInterface((IXjIfaceInfo) parcel.readTypedObject(IXjIfaceInfo.CREATOR));
                        parcel2.writeNoException();
                        parcel2.writeStrongInterface(xjInterface);
                    } else if (i != 2) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    } else {
                        IXjIfaceInfo[] listXjInterfaces = listXjInterfaces();
                        parcel2.writeNoException();
                        parcel2.writeTypedArray(listXjInterfaces, 1);
                    }
                    return true;
            }
        }
    }

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    ISupplicantXjStaIface getXjInterface(IXjIfaceInfo iXjIfaceInfo) throws RemoteException;

    IXjIfaceInfo[] listXjInterfaces() throws RemoteException;
}
