package vendor.upuphone.net.starrynetstack;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IStarryNetStack extends IInterface {
    public static final String DESCRIPTOR = "vendor$upuphone$net$starrynetstack$IStarryNetStack".replace('$', '.');
    public static final String HASH = "264d88d290d8a566026d2d7461a1db51d671f2bd";
    public static final int VERSION = 1;

    public static class Default implements IStarryNetStack {
        public IBinder asBinder() {
            return null;
        }

        public int attachHwif(int i, String str, int i2) throws RemoteException {
            return 0;
        }

        public int detachHwif(int i, String str) throws RemoteException {
            return 0;
        }

        public int disableLinkAggregation(int i) throws RemoteException {
            return 0;
        }

        public int disableLinkTransition(int i) throws RemoteException {
            return 0;
        }

        public int disableLossDetect(int i) throws RemoteException {
            return 0;
        }

        public int enableLinkAggregation(int i) throws RemoteException {
            return 0;
        }

        public int enableLinkTransition(int i) throws RemoteException {
            return 0;
        }

        public int enableLossDetect(int i, int i2, int i3) throws RemoteException {
            return 0;
        }

        public String getInterfaceHash() {
            return "";
        }

        public int getInterfaceVersion() {
            return 0;
        }

        public String getifacename(int i) throws RemoteException {
            return null;
        }

        public int getindexbyname(String str) throws RemoteException {
            return 0;
        }

        public String getipaddress(String str) throws RemoteException {
            return null;
        }

        public int getloadnums() throws RemoteException {
            return 0;
        }

        public int getmtu(String str) throws RemoteException {
            return 0;
        }

        public int load(String str, String str2, int i, byte[] bArr) throws RemoteException {
            return 0;
        }

        public int unload(String str) throws RemoteException {
            return 0;
        }

        public int updateip(String str, String str2, String str3) throws RemoteException {
            return 0;
        }

        public int updatemtu(String str, int i) throws RemoteException {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements IStarryNetStack {
        static final int TRANSACTION_attachHwif = 12;
        static final int TRANSACTION_detachHwif = 13;
        static final int TRANSACTION_disableLinkAggregation = 11;
        static final int TRANSACTION_disableLinkTransition = 15;
        static final int TRANSACTION_disableLossDetect = 17;
        static final int TRANSACTION_enableLinkAggregation = 10;
        static final int TRANSACTION_enableLinkTransition = 14;
        static final int TRANSACTION_enableLossDetect = 16;
        static final int TRANSACTION_getInterfaceHash = 16777214;
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_getifacename = 6;
        static final int TRANSACTION_getindexbyname = 7;
        static final int TRANSACTION_getipaddress = 8;
        static final int TRANSACTION_getloadnums = 5;
        static final int TRANSACTION_getmtu = 9;
        static final int TRANSACTION_load = 1;
        static final int TRANSACTION_unload = 2;
        static final int TRANSACTION_updateip = 3;
        static final int TRANSACTION_updatemtu = 4;

        public static class Proxy implements IStarryNetStack {
            private String mCachedHash = "-1";
            private int mCachedVersion = -1;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int attachHwif(int i, String str, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(12, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method attachHwif is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int detachHwif(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.mRemote.transact(13, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method detachHwif is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int disableLinkAggregation(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(11, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method disableLinkAggregation is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int disableLinkTransition(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(15, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method disableLinkTransition is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int disableLossDetect(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(17, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method disableLossDetect is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int enableLinkAggregation(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(10, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method enableLinkAggregation is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int enableLinkTransition(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(14, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method enableLinkTransition is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int enableLossDetect(int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (this.mRemote.transact(16, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method enableLossDetect is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return IStarryNetStack.DESCRIPTOR;
            }

            public synchronized String getInterfaceHash() throws RemoteException {
                Parcel obtain;
                Parcel obtain2;
                try {
                    if ("-1".equals(this.mCachedHash)) {
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
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
                        obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
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

            public String getifacename(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(6, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    throw new RemoteException("Method getifacename is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getindexbyname(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(7, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method getindexbyname is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getipaddress(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(8, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    throw new RemoteException("Method getipaddress is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getloadnums() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    if (this.mRemote.transact(5, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method getloadnums is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getmtu(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(9, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method getmtu is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int load(String str, String str2, int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(1, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method load is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unload(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method unload is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int updateip(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (this.mRemote.transact(3, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method updateip is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int updatemtu(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IStarryNetStack.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(4, obtain, obtain2, 0)) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    throw new RemoteException("Method updatemtu is unimplemented.");
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            markVintfStability();
            attachInterface(this, IStarryNetStack.DESCRIPTOR);
        }

        public static IStarryNetStack asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IStarryNetStack.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStarryNetStack)) ? new Proxy(iBinder) : (IStarryNetStack) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = IStarryNetStack.DESCRIPTOR;
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
                    switch (i) {
                        case 1:
                            String readString = parcel.readString();
                            String readString2 = parcel.readString();
                            int readInt = parcel.readInt();
                            byte[] createByteArray = parcel.createByteArray();
                            parcel.enforceNoDataAvail();
                            int load = load(readString, readString2, readInt, createByteArray);
                            parcel2.writeNoException();
                            parcel2.writeInt(load);
                            break;
                        case 2:
                            String readString3 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int unload = unload(readString3);
                            parcel2.writeNoException();
                            parcel2.writeInt(unload);
                            break;
                        case 3:
                            String readString4 = parcel.readString();
                            String readString5 = parcel.readString();
                            String readString6 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int updateip = updateip(readString4, readString5, readString6);
                            parcel2.writeNoException();
                            parcel2.writeInt(updateip);
                            break;
                        case 4:
                            String readString7 = parcel.readString();
                            int readInt2 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int updatemtu = updatemtu(readString7, readInt2);
                            parcel2.writeNoException();
                            parcel2.writeInt(updatemtu);
                            break;
                        case 5:
                            int i3 = getloadnums();
                            parcel2.writeNoException();
                            parcel2.writeInt(i3);
                            break;
                        case 6:
                            int readInt3 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            String str2 = getifacename(readInt3);
                            parcel2.writeNoException();
                            parcel2.writeString(str2);
                            break;
                        case 7:
                            String readString8 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int i4 = getindexbyname(readString8);
                            parcel2.writeNoException();
                            parcel2.writeInt(i4);
                            break;
                        case 8:
                            String readString9 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            String str3 = getipaddress(readString9);
                            parcel2.writeNoException();
                            parcel2.writeString(str3);
                            break;
                        case 9:
                            String readString10 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int i5 = getmtu(readString10);
                            parcel2.writeNoException();
                            parcel2.writeInt(i5);
                            break;
                        case 10:
                            int readInt4 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int enableLinkAggregation = enableLinkAggregation(readInt4);
                            parcel2.writeNoException();
                            parcel2.writeInt(enableLinkAggregation);
                            break;
                        case 11:
                            int readInt5 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int disableLinkAggregation = disableLinkAggregation(readInt5);
                            parcel2.writeNoException();
                            parcel2.writeInt(disableLinkAggregation);
                            break;
                        case 12:
                            int readInt6 = parcel.readInt();
                            String readString11 = parcel.readString();
                            int readInt7 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int attachHwif = attachHwif(readInt6, readString11, readInt7);
                            parcel2.writeNoException();
                            parcel2.writeInt(attachHwif);
                            break;
                        case 13:
                            int readInt8 = parcel.readInt();
                            String readString12 = parcel.readString();
                            parcel.enforceNoDataAvail();
                            int detachHwif = detachHwif(readInt8, readString12);
                            parcel2.writeNoException();
                            parcel2.writeInt(detachHwif);
                            break;
                        case 14:
                            int readInt9 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int enableLinkTransition = enableLinkTransition(readInt9);
                            parcel2.writeNoException();
                            parcel2.writeInt(enableLinkTransition);
                            break;
                        case 15:
                            int readInt10 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int disableLinkTransition = disableLinkTransition(readInt10);
                            parcel2.writeNoException();
                            parcel2.writeInt(disableLinkTransition);
                            break;
                        case 16:
                            int readInt11 = parcel.readInt();
                            int readInt12 = parcel.readInt();
                            int readInt13 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int enableLossDetect = enableLossDetect(readInt11, readInt12, readInt13);
                            parcel2.writeNoException();
                            parcel2.writeInt(enableLossDetect);
                            break;
                        case 17:
                            int readInt14 = parcel.readInt();
                            parcel.enforceNoDataAvail();
                            int disableLossDetect = disableLossDetect(readInt14);
                            parcel2.writeNoException();
                            parcel2.writeInt(disableLossDetect);
                            break;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
                    return true;
            }
        }
    }

    int attachHwif(int i, String str, int i2) throws RemoteException;

    int detachHwif(int i, String str) throws RemoteException;

    int disableLinkAggregation(int i) throws RemoteException;

    int disableLinkTransition(int i) throws RemoteException;

    int disableLossDetect(int i) throws RemoteException;

    int enableLinkAggregation(int i) throws RemoteException;

    int enableLinkTransition(int i) throws RemoteException;

    int enableLossDetect(int i, int i2, int i3) throws RemoteException;

    String getInterfaceHash() throws RemoteException;

    int getInterfaceVersion() throws RemoteException;

    String getifacename(int i) throws RemoteException;

    int getindexbyname(String str) throws RemoteException;

    String getipaddress(String str) throws RemoteException;

    int getloadnums() throws RemoteException;

    int getmtu(String str) throws RemoteException;

    int load(String str, String str2, int i, byte[] bArr) throws RemoteException;

    int unload(String str) throws RemoteException;

    int updateip(String str, String str2, String str3) throws RemoteException;

    int updatemtu(String str, int i) throws RemoteException;
}
