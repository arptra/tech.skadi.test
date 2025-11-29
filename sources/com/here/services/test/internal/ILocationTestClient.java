package com.here.services.test.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.here.posclient.ClientConfiguration;
import com.here.services.test.internal.FingerprintStatsListener;
import com.here.services.test.internal.HdWifiStateListener;

public interface ILocationTestClient extends IInterface {
    public static final String DESCRIPTOR = "com.here.services.test.internal.ILocationTestClient";

    public static class Default implements ILocationTestClient {
        public IBinder asBinder() {
            return null;
        }

        public int availableFeatures() throws RemoteException {
            return 0;
        }

        public void clearData(int i) throws RemoteException {
        }

        public void dumpCachedData() throws RemoteException {
        }

        public void dumpData() throws RemoteException {
        }

        public void dumpFingerprints() throws RemoteException {
        }

        public void dumpHeapData() throws RemoteException {
        }

        public void dumpRemoteConfiguration() throws RemoteException {
        }

        public int enabledFeatures() throws RemoteException {
            return 0;
        }

        public boolean getActiveCollection() throws RemoteException {
            return false;
        }

        public boolean getAutoUpload() throws RemoteException {
            return false;
        }

        public ClientConfiguration getClientConfiguration() throws RemoteException {
            return null;
        }

        public int getCollectionStats(FingerprintStatsListener fingerprintStatsListener) throws RemoteException {
            return 0;
        }

        public boolean getCollectionStatus() throws RemoteException {
            return false;
        }

        public long getGnssFingerprintCount() throws RemoteException {
            return 0;
        }

        public long getNonGnssFingerprintCount() throws RemoteException {
            return 0;
        }

        public void logLta(String str) throws RemoteException {
        }

        public void overrideConfiguration(String str) throws RemoteException {
        }

        public void refreshRemoteConfiguration() throws RemoteException {
        }

        public boolean registerHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException {
            return false;
        }

        public void sendFingerprints() throws RemoteException {
        }

        public boolean setActiveCollection(boolean z) throws RemoteException {
            return false;
        }

        public boolean setAutoUpload(boolean z) throws RemoteException {
            return false;
        }

        public void setUsername(String str) throws RemoteException {
        }

        public void toggleFeature(String str, boolean z) throws RemoteException {
        }

        public void unBind() throws RemoteException {
        }

        public void unregisterHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ILocationTestClient {
        static final int TRANSACTION_availableFeatures = 7;
        static final int TRANSACTION_clearData = 4;
        static final int TRANSACTION_dumpCachedData = 2;
        static final int TRANSACTION_dumpData = 1;
        static final int TRANSACTION_dumpFingerprints = 9;
        static final int TRANSACTION_dumpHeapData = 3;
        static final int TRANSACTION_dumpRemoteConfiguration = 24;
        static final int TRANSACTION_enabledFeatures = 8;
        static final int TRANSACTION_getActiveCollection = 12;
        static final int TRANSACTION_getAutoUpload = 14;
        static final int TRANSACTION_getClientConfiguration = 19;
        static final int TRANSACTION_getCollectionStats = 18;
        static final int TRANSACTION_getCollectionStatus = 11;
        static final int TRANSACTION_getGnssFingerprintCount = 16;
        static final int TRANSACTION_getNonGnssFingerprintCount = 17;
        static final int TRANSACTION_logLta = 20;
        static final int TRANSACTION_overrideConfiguration = 26;
        static final int TRANSACTION_refreshRemoteConfiguration = 23;
        static final int TRANSACTION_registerHdWifiStateListener = 21;
        static final int TRANSACTION_sendFingerprints = 10;
        static final int TRANSACTION_setActiveCollection = 13;
        static final int TRANSACTION_setAutoUpload = 15;
        static final int TRANSACTION_setUsername = 5;
        static final int TRANSACTION_toggleFeature = 6;
        static final int TRANSACTION_unBind = 25;
        static final int TRANSACTION_unregisterHdWifiStateListener = 22;

        public static class Proxy implements ILocationTestClient {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int availableFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearData(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void dumpCachedData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void dumpData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void dumpFingerprints() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void dumpHeapData() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void dumpRemoteConfiguration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int enabledFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getActiveCollection() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getAutoUpload() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ClientConfiguration getClientConfiguration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return (ClientConfiguration) _Parcel.readTypedObject(obtain2, ClientConfiguration.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getCollectionStats(FingerprintStatsListener fingerprintStatsListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeStrongInterface(fingerprintStatsListener);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getCollectionStatus() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getGnssFingerprintCount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ILocationTestClient.DESCRIPTOR;
            }

            public long getNonGnssFingerprintCount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void logLta(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void overrideConfiguration(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(26, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void refreshRemoteConfiguration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean registerHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeStrongInterface(hdWifiStateListener);
                    boolean z = false;
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void sendFingerprints() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public boolean setActiveCollection(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    boolean z2 = false;
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setAutoUpload(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    boolean z2 = false;
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUsername(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void toggleFeature(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void unBind() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ILocationTestClient.DESCRIPTOR);
                    obtain.writeStrongInterface(hdWifiStateListener);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ILocationTestClient.DESCRIPTOR);
        }

        public static ILocationTestClient asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ILocationTestClient.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ILocationTestClient)) ? new Proxy(iBinder) : (ILocationTestClient) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ILocationTestClient.DESCRIPTOR);
            }
            if (i != 1598968902) {
                boolean z = false;
                switch (i) {
                    case 1:
                        dumpData();
                        break;
                    case 2:
                        dumpCachedData();
                        break;
                    case 3:
                        dumpHeapData();
                        break;
                    case 4:
                        clearData(parcel.readInt());
                        break;
                    case 5:
                        setUsername(parcel.readString());
                        break;
                    case 6:
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        toggleFeature(readString, z);
                        break;
                    case 7:
                        int availableFeatures = availableFeatures();
                        parcel2.writeNoException();
                        parcel2.writeInt(availableFeatures);
                        break;
                    case 8:
                        int enabledFeatures = enabledFeatures();
                        parcel2.writeNoException();
                        parcel2.writeInt(enabledFeatures);
                        break;
                    case 9:
                        dumpFingerprints();
                        break;
                    case 10:
                        sendFingerprints();
                        break;
                    case 11:
                        boolean collectionStatus = getCollectionStatus();
                        parcel2.writeNoException();
                        parcel2.writeInt(collectionStatus ? 1 : 0);
                        break;
                    case 12:
                        boolean activeCollection = getActiveCollection();
                        parcel2.writeNoException();
                        parcel2.writeInt(activeCollection ? 1 : 0);
                        break;
                    case 13:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean activeCollection2 = setActiveCollection(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(activeCollection2 ? 1 : 0);
                        break;
                    case 14:
                        boolean autoUpload = getAutoUpload();
                        parcel2.writeNoException();
                        parcel2.writeInt(autoUpload ? 1 : 0);
                        break;
                    case 15:
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        boolean autoUpload2 = setAutoUpload(z);
                        parcel2.writeNoException();
                        parcel2.writeInt(autoUpload2 ? 1 : 0);
                        break;
                    case 16:
                        long gnssFingerprintCount = getGnssFingerprintCount();
                        parcel2.writeNoException();
                        parcel2.writeLong(gnssFingerprintCount);
                        break;
                    case 17:
                        long nonGnssFingerprintCount = getNonGnssFingerprintCount();
                        parcel2.writeNoException();
                        parcel2.writeLong(nonGnssFingerprintCount);
                        break;
                    case 18:
                        int collectionStats = getCollectionStats(FingerprintStatsListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(collectionStats);
                        break;
                    case 19:
                        ClientConfiguration clientConfiguration = getClientConfiguration();
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, clientConfiguration, 1);
                        break;
                    case 20:
                        logLta(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 21:
                        boolean registerHdWifiStateListener = registerHdWifiStateListener(HdWifiStateListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(registerHdWifiStateListener ? 1 : 0);
                        break;
                    case 22:
                        unregisterHdWifiStateListener(HdWifiStateListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 23:
                        refreshRemoteConfiguration();
                        parcel2.writeNoException();
                        break;
                    case 24:
                        dumpRemoteConfiguration();
                        parcel2.writeNoException();
                        break;
                    case 25:
                        unBind();
                        parcel2.writeNoException();
                        break;
                    case 26:
                        overrideConfiguration(parcel.readString());
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                return true;
            }
            parcel2.writeString(ILocationTestClient.DESCRIPTOR);
            return true;
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

    int availableFeatures() throws RemoteException;

    void clearData(int i) throws RemoteException;

    void dumpCachedData() throws RemoteException;

    void dumpData() throws RemoteException;

    void dumpFingerprints() throws RemoteException;

    void dumpHeapData() throws RemoteException;

    void dumpRemoteConfiguration() throws RemoteException;

    int enabledFeatures() throws RemoteException;

    boolean getActiveCollection() throws RemoteException;

    boolean getAutoUpload() throws RemoteException;

    ClientConfiguration getClientConfiguration() throws RemoteException;

    int getCollectionStats(FingerprintStatsListener fingerprintStatsListener) throws RemoteException;

    boolean getCollectionStatus() throws RemoteException;

    long getGnssFingerprintCount() throws RemoteException;

    long getNonGnssFingerprintCount() throws RemoteException;

    void logLta(String str) throws RemoteException;

    void overrideConfiguration(String str) throws RemoteException;

    void refreshRemoteConfiguration() throws RemoteException;

    boolean registerHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException;

    void sendFingerprints() throws RemoteException;

    boolean setActiveCollection(boolean z) throws RemoteException;

    boolean setAutoUpload(boolean z) throws RemoteException;

    void setUsername(String str) throws RemoteException;

    void toggleFeature(String str, boolean z) throws RemoteException;

    void unBind() throws RemoteException;

    void unregisterHdWifiStateListener(HdWifiStateListener hdWifiStateListener) throws RemoteException;
}
