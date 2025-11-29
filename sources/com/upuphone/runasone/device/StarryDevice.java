package com.upuphone.runasone.device;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.upuphone.runasone.ability.EnumAbility;
import com.upuphone.starrynet.api.bean.StDevice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class StarryDevice implements Parcelable, Cloneable {
    public static final Parcelable.Creator<StarryDevice> CREATOR = new Parcelable.Creator<StarryDevice>() {
        public StarryDevice createFromParcel(Parcel parcel) {
            return new StarryDevice(parcel);
        }

        public StarryDevice[] newArray(int i) {
            return new StarryDevice[i];
        }
    };
    private List<EnumAbility> abilityList;
    private String address;
    private ConcurrentHashMap<String, Integer> connectCount;
    private String id;
    private boolean isConnectByMdns;
    protected String modelName;
    private String name;
    private int port;
    protected transient int preState;
    protected int rssi;
    private String selfId;
    private StDevice starryDevice;
    private int status;
    protected byte terminalType;

    public static class Builder {
        List<EnumAbility> abilityList;
        String address;
        String id;
        String name;
        int port;
        String selfId;
        StDevice starryDevice;

        public StarryDevice build() {
            return new StarryDevice(this);
        }

        public Builder setAddress(String str) {
            this.address = str;
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setPort(int i) {
            this.port = i;
            return this;
        }

        public Builder setSelfId(String str) {
            this.selfId = str;
            return this;
        }

        public Builder setStarryNet(StDevice stDevice) {
            this.starryDevice = stDevice;
            return this;
        }

        public Builder setSupportAbility(List<EnumAbility> list) {
            this.abilityList = list;
            return this;
        }
    }

    public StarryDevice() {
        this(new Builder());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void addStatus(int i) {
        this.status = i | this.status;
    }

    public boolean checkStatus(int i) {
        return (this.status & i) == i;
    }

    public void decrement(String str, Integer num) {
        if (str == null) {
            for (Map.Entry next : this.connectCount.entrySet()) {
                String str2 = (String) next.getKey();
                int intValue = ((Integer) next.getValue()).intValue() & (~num.intValue());
                if (intValue == 0) {
                    this.connectCount.remove(str2);
                } else {
                    this.connectCount.put(str2, Integer.valueOf(intValue));
                }
            }
            return;
        }
        Integer num2 = this.connectCount.get(str);
        if (num2 != null) {
            int intValue2 = (~num.intValue()) & num2.intValue();
            if (intValue2 == 0) {
                this.connectCount.remove(str);
            } else {
                this.connectCount.put(str, Integer.valueOf(intValue2));
            }
        }
    }

    public void delConnectCount(String str) {
        this.connectCount.remove(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.id, ((StarryDevice) obj).id);
    }

    public String getAddress() {
        return this.address;
    }

    public int getConnectCount(Integer num) {
        int i = 0;
        for (Map.Entry<String, Integer> value : this.connectCount.entrySet()) {
            if ((((Integer) value.getValue()).intValue() & num.intValue()) == num.intValue()) {
                i++;
            }
        }
        return i;
    }

    public String getId() {
        return this.id;
    }

    public String getModelName() {
        return this.modelName;
    }

    @Deprecated
    public String getName() {
        return this.name;
    }

    public int getPort() {
        return this.port;
    }

    public int getPreState() {
        return this.preState;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSelfId() {
        return this.selfId;
    }

    public StDevice getStarryDevice() {
        return this.starryDevice;
    }

    @Deprecated
    public int getStatus() {
        return this.status;
    }

    public List<EnumAbility> getSupportAbility() {
        return this.abilityList;
    }

    public byte getTerminalType() {
        return this.terminalType;
    }

    public int getThroughPutStatus() {
        return this.status & 255;
    }

    public int getVirtualChannelStatus() {
        return (this.status >> 8) & 255;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public void increment(String str, int i) {
        if (str == null) {
            for (Map.Entry next : this.connectCount.entrySet()) {
                this.connectCount.put((String) next.getKey(), Integer.valueOf(((Integer) next.getValue()).intValue() | i));
            }
            return;
        }
        Integer num = this.connectCount.get(str);
        if (num != null) {
            this.connectCount.put(str, Integer.valueOf(i | num.intValue()));
        } else {
            this.connectCount.put(str, Integer.valueOf(i));
        }
    }

    public boolean isConnectByMdns() {
        return this.isConnectByMdns;
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readString();
        this.selfId = parcel.readString();
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.abilityList = arrayList;
        Class<EnumAbility> cls = EnumAbility.class;
        parcel.readList(arrayList, cls.getClassLoader());
        this.address = parcel.readString();
        this.port = parcel.readInt();
        this.status = parcel.readInt();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        this.connectCount = concurrentHashMap;
        parcel.readMap(concurrentHashMap, cls.getClassLoader());
    }

    public void recordPreState() {
        if (checkStatus(1024) || checkStatus(512)) {
            this.preState = 2;
            if (checkStatus(256)) {
                this.preState = 3;
            }
        } else if (checkStatus(256)) {
            this.preState = 1;
        } else {
            this.preState = 0;
        }
    }

    public void removeStatus(int i) {
        this.status = (~i) & this.status;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setConnectByMdns(boolean z) {
        this.isConnectByMdns = z;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public void setSelfId(String str) {
        this.selfId = str;
    }

    public void setStarryDevice(StDevice stDevice) {
        this.starryDevice = stDevice;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTerminalType(byte b) {
        this.terminalType = b;
    }

    public String toString() {
        return "StarryDevice{id='" + this.id + '\'' + ", selfId='" + this.selfId + '\'' + ", name='" + this.name + '\'' + ", address='" + this.address + '\'' + ", port=" + this.port + ", status=" + Integer.toBinaryString(this.status) + ", connectCount=" + this.connectCount + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.selfId);
        parcel.writeString(this.name);
        parcel.writeList(this.abilityList);
        parcel.writeString(this.address);
        parcel.writeInt(this.port);
        parcel.writeInt(this.status);
        parcel.writeMap(this.connectCount);
        parcel.writeParcelable(this.starryDevice, i);
    }

    public StarryDevice(Builder builder) {
        this.isConnectByMdns = false;
        this.preState = 0;
        this.connectCount = new ConcurrentHashMap<>();
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.port = builder.port;
        this.selfId = builder.selfId;
        this.abilityList = builder.abilityList;
        this.starryDevice = builder.starryDevice;
    }

    @NonNull
    public StarryDevice clone() {
        try {
            return (StarryDevice) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StarryDevice(Parcel parcel) {
        this.isConnectByMdns = false;
        this.preState = 0;
        this.connectCount = new ConcurrentHashMap<>();
        this.id = parcel.readString();
        this.selfId = parcel.readString();
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.abilityList = arrayList;
        Class<EnumAbility> cls = EnumAbility.class;
        parcel.readList(arrayList, cls.getClassLoader());
        this.address = parcel.readString();
        this.port = parcel.readInt();
        this.status = parcel.readInt();
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        this.connectCount = concurrentHashMap;
        parcel.readMap(concurrentHashMap, cls.getClassLoader());
        this.starryDevice = (StDevice) parcel.readParcelable(StDevice.class.getClassLoader());
    }
}
