package com.here.odnp.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.here.odnp.net.IConnectivityManager;
import com.here.odnp.util.Log;
import com.here.posclient.INetworkManager;
import com.here.posclient.PosClientLib;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"MissingPermission"})
public class PlatformConnectivityManager implements IConnectivityManager {
    private static final String TAG = "odnp.net.PlatformConnectivityManager";
    private final BroadcastReceiver mActiveConnectionChangeReceiver = new BroadcastReceiver() {
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a9, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d0, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r4, android.content.Intent r5) {
            /*
                r3 = this;
                java.lang.String r4 = r5.getAction()
                java.lang.Object[] r4 = new java.lang.Object[]{r4}
                java.lang.String r0 = "odnp.net.PlatformConnectivityManager"
                java.lang.String r1 = "onReceive: %s"
                com.here.odnp.util.Log.v(r0, r1, r4)
                com.here.odnp.net.PlatformConnectivityManager r4 = com.here.odnp.net.PlatformConnectivityManager.this
                monitor-enter(r4)
                java.lang.String r0 = "android.net.conn.CONNECTIVITY_CHANGE"
                java.lang.String r1 = r5.getAction()     // Catch:{ all -> 0x0035 }
                boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x00cf
                java.lang.String r0 = "noConnectivity"
                r1 = 0
                boolean r0 = r5.getBooleanExtra(r0, r1)     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x0038
                java.lang.String r5 = "odnp.net.PlatformConnectivityManager"
                java.lang.String r0 = "Connection: no connectivity"
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0035 }
                com.here.odnp.util.Log.v(r5, r0, r1)     // Catch:{ all -> 0x0035 }
                r3.reportDisconnect()     // Catch:{ all -> 0x0035 }
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                return
            L_0x0035:
                r3 = move-exception
                goto L_0x00d1
            L_0x0038:
                java.lang.String r0 = "isFailover"
                boolean r5 = r5.getBooleanExtra(r0, r1)     // Catch:{ all -> 0x0035 }
                if (r5 == 0) goto L_0x0049
                java.lang.String r5 = "odnp.net.PlatformConnectivityManager"
                java.lang.String r0 = "Connection: fail over"
                java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0035 }
                com.here.odnp.util.Log.v(r5, r0, r2)     // Catch:{ all -> 0x0035 }
            L_0x0049:
                com.here.odnp.net.PlatformConnectivityManager r5 = com.here.odnp.net.PlatformConnectivityManager.this     // Catch:{ all -> 0x0035 }
                android.net.ConnectivityManager r5 = r5.mConnectivityManager     // Catch:{ all -> 0x0035 }
                android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch:{ all -> 0x0035 }
                if (r5 != 0) goto L_0x0063
                java.lang.String r5 = "odnp.net.PlatformConnectivityManager"
                java.lang.String r0 = "mActiveConnectionChangeReceiver.onReceive: active network info is null"
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0035 }
                com.here.odnp.util.Log.v(r5, r0, r1)     // Catch:{ all -> 0x0035 }
                r3.reportDisconnect()     // Catch:{ all -> 0x0035 }
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                return
            L_0x0063:
                com.here.odnp.net.PlatformConnectivityManager r0 = com.here.odnp.net.PlatformConnectivityManager.this     // Catch:{ all -> 0x0035 }
                com.here.posclient.INetworkManager$Connection r5 = r0.createConnection(r5)     // Catch:{ all -> 0x0035 }
                if (r5 != 0) goto L_0x0079
                java.lang.String r5 = "odnp.net.PlatformConnectivityManager"
                java.lang.String r0 = "mActiveConnectionChangeReceiver.onReceive: connection is null"
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0035 }
                com.here.odnp.util.Log.w(r5, r0, r1)     // Catch:{ all -> 0x0035 }
                r3.reportDisconnect()     // Catch:{ all -> 0x0035 }
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                return
            L_0x0079:
                com.here.odnp.net.PlatformConnectivityManager r0 = com.here.odnp.net.PlatformConnectivityManager.this     // Catch:{ all -> 0x0035 }
                com.here.posclient.INetworkManager$Connection r0 = r0.mStoredConnection     // Catch:{ all -> 0x0035 }
                boolean r0 = r5.isSame(r0)     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x00aa
                boolean r0 = r5.isConnected     // Catch:{ all -> 0x0035 }
                if (r0 != 0) goto L_0x0097
                com.here.odnp.net.PlatformConnectivityManager r0 = com.here.odnp.net.PlatformConnectivityManager.this     // Catch:{ all -> 0x0035 }
                com.here.posclient.INetworkManager$Connection r0 = r0.mStoredConnection     // Catch:{ all -> 0x0035 }
                boolean r0 = r0.isConnected     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x0097
                r3.reportDisconnect()     // Catch:{ all -> 0x0035 }
                goto L_0x00a8
            L_0x0097:
                boolean r0 = r5.isConnected     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x00a8
                com.here.odnp.net.PlatformConnectivityManager r0 = com.here.odnp.net.PlatformConnectivityManager.this     // Catch:{ all -> 0x0035 }
                com.here.posclient.INetworkManager$Connection r0 = r0.mStoredConnection     // Catch:{ all -> 0x0035 }
                boolean r0 = r0.isConnected     // Catch:{ all -> 0x0035 }
                if (r0 != 0) goto L_0x00a8
                r3.reportConnected(r5)     // Catch:{ all -> 0x0035 }
            L_0x00a8:
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                return
            L_0x00aa:
                com.here.odnp.net.PlatformConnectivityManager r0 = com.here.odnp.net.PlatformConnectivityManager.this     // Catch:{ all -> 0x0035 }
                com.here.posclient.INetworkManager$Connection r0 = r0.mStoredConnection     // Catch:{ all -> 0x0035 }
                boolean r0 = r5.isSameType(r0)     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x00bb
                r3.reportConnectionChanged(r5)     // Catch:{ all -> 0x0035 }
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                return
            L_0x00bb:
                r3.reportDisconnect()     // Catch:{ all -> 0x0035 }
                boolean r0 = r5.isConnected     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x00c6
                r3.reportConnected(r5)     // Catch:{ all -> 0x0035 }
                goto L_0x00cf
            L_0x00c6:
                java.lang.String r3 = "odnp.net.PlatformConnectivityManager"
                java.lang.String r5 = "mActiveConnectionChangeReceiver.onReceive: new connection not connected"
                java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0035 }
                com.here.odnp.util.Log.w(r3, r5, r0)     // Catch:{ all -> 0x0035 }
            L_0x00cf:
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                return
            L_0x00d1:
                monitor-exit(r4)     // Catch:{ all -> 0x0035 }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.odnp.net.PlatformConnectivityManager.AnonymousClass1.onReceive(android.content.Context, android.content.Intent):void");
        }

        public void reportConnected(INetworkManager.Connection connection) {
            PlatformConnectivityManager.this.reportConnection(PosClientLib.ConnectionChangeAction.CONNECTION_CONNECTED, connection);
        }

        public void reportConnectionChanged(INetworkManager.Connection connection) {
            PlatformConnectivityManager.this.reportConnection(PosClientLib.ConnectionChangeAction.CONNECTION_CHANGED, connection);
        }

        public void reportDisconnect() {
            if (PlatformConnectivityManager.this.mStoredConnection != null) {
                if (PlatformConnectivityManager.this.mStoredConnection.isConnected) {
                    PlatformConnectivityManager.this.mStoredConnection.isConnected = false;
                    PlatformConnectivityManager platformConnectivityManager = PlatformConnectivityManager.this;
                    platformConnectivityManager.reportConnection(PosClientLib.ConnectionChangeAction.CONNECTION_DISCONNECTED, platformConnectivityManager.mStoredConnection);
                }
                INetworkManager.Connection unused = PlatformConnectivityManager.this.mStoredConnection = null;
            }
        }
    };
    /* access modifiers changed from: private */
    public final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private IConnectivityManager.IConnectivityListener mListener;
    /* access modifiers changed from: private */
    public INetworkManager.Connection mStoredConnection;

    public PlatformConnectivityManager(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    /* access modifiers changed from: private */
    public INetworkManager.Connection createConnection(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return null;
        }
        Log.i(TAG, "createConnection: isConnected: %b isConnectedOrConnecting: %b", Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()));
        INetworkManager.Connection connection = new INetworkManager.Connection();
        connection.isConnected = networkInfo.isConnected();
        connection.isRoaming = networkInfo.isRoaming();
        if (networkInfo.getType() == 1) {
            connection.type = INetworkManager.Connection.Type.WIFI;
        } else if (networkInfo.getType() == 9) {
            connection.type = INetworkManager.Connection.Type.ETHERNET;
        } else if (networkInfo.getType() == 0) {
            connection.type = INetworkManager.Connection.Type.MOBILE;
        } else {
            connection.type = INetworkManager.Connection.Type.OTHER;
        }
        if (!this.mConnectivityManager.isActiveNetworkMetered()) {
            return connection;
        }
        connection.meteredStatus = INetworkManager.Connection.MeterStatus.METERED;
        return connection;
    }

    /* access modifiers changed from: private */
    public void reportConnection(PosClientLib.ConnectionChangeAction connectionChangeAction, INetworkManager.Connection connection) {
        if (this.mListener == null) {
            Log.w(TAG, "reportConnection: mListener is null", new Object[0]);
            return;
        }
        Log.v(TAG, "reportConnection: action: %s connection: %s", connectionChangeAction, connection);
        this.mStoredConnection = connection;
        this.mListener.onConnectionStateChanged(connectionChangeAction, connection);
    }

    public synchronized void close() {
        if (this.mListener != null) {
            this.mContext.unregisterReceiver(this.mActiveConnectionChangeReceiver);
            this.mListener = null;
        }
    }

    public INetworkManager.Connection[] getConnections() {
        NetworkInfo[] allNetworkInfo = this.mConnectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return new INetworkManager.Connection[0];
        }
        ArrayList arrayList = new ArrayList();
        for (NetworkInfo createConnection : allNetworkInfo) {
            INetworkManager.Connection createConnection2 = createConnection(createConnection);
            if (createConnection2 != null) {
                arrayList.add(createConnection2);
            }
        }
        return (INetworkManager.Connection[]) arrayList.toArray(new INetworkManager.Connection[arrayList.size()]);
    }

    public INetworkManager.Connection getDataConnection() {
        INetworkManager.Connection createConnection = createConnection(this.mConnectivityManager.getActiveNetworkInfo());
        if (createConnection != null && this.mConnectivityManager.isActiveNetworkMetered()) {
            createConnection.meteredStatus = INetworkManager.Connection.MeterStatus.METERED;
        }
        this.mStoredConnection = createConnection;
        return createConnection;
    }

    public INetworkManager.Proxy getProxy(String str) {
        try {
            List<Proxy> select = ProxySelector.getDefault().select(new URI(str));
            if (select == null) {
                return null;
            }
            for (Proxy next : select) {
                if (next.type() == Proxy.Type.HTTP) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) next.address();
                    if (inetSocketAddress != null) {
                        INetworkManager.Proxy proxy = new INetworkManager.Proxy();
                        proxy.address = inetSocketAddress.getHostName();
                        int port = inetSocketAddress.getPort();
                        proxy.port = port;
                        Log.i(TAG, "getProxy: proxy.address: '%s'' proxy.port: %d", proxy.address, Integer.valueOf(port));
                        return proxy;
                    }
                }
            }
            return null;
        } catch (URISyntaxException e) {
            Log.e(TAG, "getProxy: error uri: '%s' error: %s", str, Log.getStackTraceString(e));
            return null;
        } catch (IllegalArgumentException e2) {
            Log.e(TAG, "getProxy: error: %s", Log.getStackTraceString(e2));
            return null;
        }
    }

    public synchronized void open(IConnectivityManager.IConnectivityListener iConnectivityListener) {
        close();
        if (iConnectivityListener != null) {
            this.mListener = iConnectivityListener;
            this.mContext.registerReceiver(this.mActiveConnectionChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }
}
