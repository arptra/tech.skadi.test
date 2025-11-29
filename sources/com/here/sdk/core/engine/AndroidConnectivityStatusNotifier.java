package com.here.sdk.core.engine;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.util.Log;
import androidx.annotation.NonNull;
import com.here.sdk.core.engine.ConnectivityStatusNotifier;
import com.meizu.common.widget.MzContactsContract;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

class AndroidConnectivityStatusNotifier extends ConnectivityManager.NetworkCallback implements ConnectivityStatusNotifier {
    private final List<Network> mAvailableNetworks = new ArrayList();
    private ConnectivityStatus mConnectivityStatus;
    private final Context mContext;
    private ConnectivityStatusListener mReachabilityListener = null;

    private AndroidConnectivityStatusNotifier(Context context, ConnectivityStatus connectivityStatus) {
        this.mContext = context;
        this.mConnectivityStatus = connectivityStatus;
    }

    private void addNetwork(Network network) {
        if (!this.mAvailableNetworks.contains(network)) {
            this.mAvailableNetworks.add(network);
        }
        updateReachability();
    }

    public static ConnectivityStatusNotifier make(@NonNull Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
        AndroidConnectivityStatusNotifier androidConnectivityStatusNotifier = new AndroidConnectivityStatusNotifier(context, connectivityManager.getActiveNetworkInfo() != null ? ConnectivityStatus.REACHABLE : ConnectivityStatus.NOT_REACHABLE);
        connectivityManager.registerNetworkCallback(build, androidConnectivityStatusNotifier);
        return androidConnectivityStatusNotifier;
    }

    private void notifyReachabilityChanged() {
        if (this.mConnectivityStatus == ConnectivityStatus.NOT_REACHABLE) {
            Log.i("Reachability", "Network unreachable");
        } else {
            Log.i("Reachability", "Network reachable");
        }
        ConnectivityStatusListener connectivityStatusListener = this.mReachabilityListener;
        if (connectivityStatusListener != null) {
            connectivityStatusListener.onConnectivityStatusChange(this.mConnectivityStatus);
        }
    }

    private void removeNetwork(Network network) {
        this.mAvailableNetworks.remove(network);
        updateReachability();
    }

    private void updateReachability() {
        ConnectivityStatus connectivityStatus = this.mAvailableNetworks.isEmpty() ? ConnectivityStatus.NOT_REACHABLE : ConnectivityStatus.REACHABLE;
        if (connectivityStatus != this.mConnectivityStatus) {
            this.mConnectivityStatus = connectivityStatus;
            notifyReachabilityChanged();
        }
    }

    @NonNull
    public ConnectivityStatusNotifier.NetworkState getNetworkState() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return ConnectivityStatusNotifier.NetworkState.NOT_CONNECTED;
        }
        int type = activeNetworkInfo.getType();
        return type == 1 ? ConnectivityStatusNotifier.NetworkState.WIFI : type == 0 ? ConnectivityStatusNotifier.NetworkState.CELLULAR : ConnectivityStatusNotifier.NetworkState.NOT_CONNECTED;
    }

    public void onAvailable(Network network) {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
        connectivityManager.getNetworkCapabilities(network);
        String str = ((("network=" + network) + " interface_name=" + linkProperties.getInterfaceName()) + " domains=" + linkProperties.getDomains()) + " dns=";
        for (InetAddress hostAddress : linkProperties.getDnsServers()) {
            str = str + hostAddress.getHostAddress() + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA;
        }
        Log.w("Reachability", "Acquired " + str);
        addNetwork(network);
    }

    public void onLost(Network network) {
        Log.i("Reachability", "Lost network=" + network);
        removeNetwork(network);
    }

    public void start() {
    }

    public void subscribe(@NonNull ConnectivityStatusListener connectivityStatusListener) {
        this.mReachabilityListener = connectivityStatusListener;
        notifyReachabilityChanged();
    }
}
