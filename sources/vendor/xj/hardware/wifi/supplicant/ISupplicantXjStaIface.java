package vendor.xj.hardware.wifi.supplicant;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ISupplicantXjStaIface extends IInterface {
    public static final String DESCRIPTOR = "vendor$xj$hardware$wifi$supplicant$ISupplicantXjStaIface".replace('$', '.');
    public static final String HASH = "notfrozen";
    public static final int VERSION = 1;

    public static class Default implements ISupplicantXjStaIface {
        public IBinder asBinder() {
            return null;
        }

        public String doXJSupplicantCmd(String str) throws RemoteException {
            return null;
        }

        public String getInterfaceHash() {
            return "";
        }

        public int getInterfaceVersion() {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements ISupplicantXjStaIface {
        static final int TRANSACTION_doXJSupplicantCmd = 1;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;

        public static class Proxy implements ISupplicantXjStaIface {
            private String mCachedHash = "-1";
            private int mCachedVersion = -1;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String doXJSupplicantCmd(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ISupplicantXjStaIface.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    throw new RemoteException("Method doXJSupplicantCmd is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ISupplicantXjStaIface.DESCRIPTOR;
            }

            public synchronized String getInterfaceHash() throws RemoteException {
                Parcel obtain;
                Parcel obtain2;
                try {
                    if ("-1".equals(this.mCachedHash)) {
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken(ISupplicantXjStaIface.DESCRIPTOR);
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
                        obtain.writeInterfaceToken(ISupplicantXjStaIface.DESCRIPTOR);
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
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, ISupplicantXjStaIface.DESCRIPTOR);
        }

        public static ISupplicantXjStaIface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ISupplicantXjStaIface.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISupplicantXjStaIface)) ? new Proxy(iBinder) : (ISupplicantXjStaIface) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = ISupplicantXjStaIface.DESCRIPTOR;
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
                    if (i != 1) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    String doXJSupplicantCmd = doXJSupplicantCmd(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(doXJSupplicantCmd);
                    return true;
            }
        }
    }

    String doXJSupplicantCmd(String str) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;
}
