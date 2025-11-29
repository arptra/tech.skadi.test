package org.litepal.parser;

import java.util.ArrayList;
import java.util.List;

public class LitePalConfig {
    private String cases;
    private List<String> classNames;
    private String dbName;
    private String storage;
    private int version;

    public void addClassName(String str) {
        getClassNames().add(str);
    }

    public String getCases() {
        return this.cases;
    }

    public List<String> getClassNames() {
        List<String> list = this.classNames;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.classNames = arrayList;
            arrayList.add("org.litepal.model.Table_Schema");
        } else if (list.isEmpty()) {
            this.classNames.add("org.litepal.model.Table_Schema");
        }
        return this.classNames;
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getStorage() {
        return this.storage;
    }

    public int getVersion() {
        return this.version;
    }

    public void setCases(String str) {
        this.cases = str;
    }

    public void setClassNames(List<String> list) {
        this.classNames = list;
    }

    public void setDbName(String str) {
        this.dbName = str;
    }

    public void setStorage(String str) {
        this.storage = str;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
