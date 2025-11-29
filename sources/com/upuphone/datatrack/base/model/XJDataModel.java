package com.upuphone.datatrack.base.model;

import java.io.Serializable;

public class XJDataModel implements Serializable {
    public String msg;
    public String packageName;

    public XJDataModel(String str, String str2) {
        this.packageName = str;
        this.msg = str2;
    }
}
