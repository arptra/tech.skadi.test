package com.upuphone.xr.interconnect.remote;

import java.util.Objects;

public class BinderClient {
    private int pId;
    private String packageName;

    public BinderClient(int i, String str) {
        this.pId = i;
        this.packageName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinderClient binderClient = (BinderClient) obj;
        return this.pId == binderClient.pId && Objects.equals(this.packageName, binderClient.packageName);
    }

    public int getId() {
        return this.pId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.pId), this.packageName});
    }

    public String toString() {
        return "BinderClient{pId=" + this.pId + ", packageName='" + this.packageName + "'}";
    }
}
