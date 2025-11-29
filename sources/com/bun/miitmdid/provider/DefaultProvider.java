package com.bun.miitmdid.provider;

import com.bun.miitmdid.interfaces.IdSupplier;
import com.netease.nis.sdkwrapper.Utils;

public class DefaultProvider implements IdSupplier {
    public String AAID;
    public String OAID;
    public String VAID;
    public boolean isSupport;

    public DefaultProvider() {
        this.OAID = "";
        this.VAID = "";
        this.AAID = "";
        this.isSupport = false;
    }

    public String getAAID() {
        return (String) Utils.rL(new Object[]{this, 41, 1606976968513L});
    }

    public String getOAID() {
        return (String) Utils.rL(new Object[]{this, 42, 1606976968514L});
    }

    public String getVAID() {
        return (String) Utils.rL(new Object[]{this, 43, 1606976968515L});
    }

    public boolean isSupported() {
        return ((Boolean) Utils.rL(new Object[]{this, 44, 1606976968516L})).booleanValue();
    }

    public DefaultProvider(String str, String str2, String str3, boolean z) {
        this.OAID = str;
        this.VAID = str2;
        this.AAID = str3;
        this.isSupport = z;
    }
}
