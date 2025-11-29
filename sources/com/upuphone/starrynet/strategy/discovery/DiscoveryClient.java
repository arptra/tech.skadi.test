package com.upuphone.starrynet.strategy.discovery;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.upuphone.starrynet.api.IStarryDiscoveryCallback;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

public class DiscoveryClient {
    private static final String TAG = "DiscoveryClient";
    private List<StDevice> lstFoundDevices = new ArrayList();
    private IStarryDiscoveryCallback mCallback;
    private IBinder.DeathRecipient mDeathRecipient;
    private final UUID mDiscoveryID = UUID.randomUUID();
    private DiscoveryFilter mFilter;

    public DiscoveryClient(DiscoveryFilter discoveryFilter, IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        this.mFilter = discoveryFilter;
        this.mCallback = iStarryDiscoveryCallback;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mCallback, ((DiscoveryClient) obj).mCallback);
    }

    public IStarryDiscoveryCallback getCallback() {
        return this.mCallback;
    }

    public String getDiscoveryID() {
        return this.mDiscoveryID.toString();
    }

    public DiscoveryFilter getFilter() {
        return this.mFilter;
    }

    public List<StDevice> getLstFoundDevices() {
        return this.lstFoundDevices;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mCallback});
    }

    public void linkToDeath(IBinder.DeathRecipient deathRecipient) {
        IStarryDiscoveryCallback iStarryDiscoveryCallback = this.mCallback;
        if (iStarryDiscoveryCallback != null) {
            try {
                ((IInterface) iStarryDiscoveryCallback).asBinder().linkToDeath(deathRecipient, 0);
                this.mDeathRecipient = deathRecipient;
            } catch (RemoteException unused) {
                StLog.e(TAG, "Unable to link deathRecipient for app ");
            }
        }
    }

    public void setCallback(IStarryDiscoveryCallback iStarryDiscoveryCallback) {
        this.mCallback = iStarryDiscoveryCallback;
    }

    public void setFilter(DiscoveryFilter discoveryFilter) {
        this.mFilter = discoveryFilter;
    }

    public void setLstFoundDevices(List<StDevice> list) {
        this.lstFoundDevices = list;
    }

    public void unlinkToDeath() {
        if (this.mDeathRecipient != null) {
            try {
                ((IInterface) this.mCallback).asBinder().unlinkToDeath(this.mDeathRecipient, 0);
            } catch (NoSuchElementException unused) {
                StLog.e(TAG, "Unable to unlink deathRecipient for app");
            }
        }
    }
}
