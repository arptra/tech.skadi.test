package org.litepal.tablemanager.model;

public class GenericModel {
    private String getMethodName;
    private String tableName;
    private String valueColumnName;
    private String valueColumnType;
    private String valueIdColumnName;

    public String getGetMethodName() {
        return this.getMethodName;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getValueColumnName() {
        return this.valueColumnName;
    }

    public String getValueColumnType() {
        return this.valueColumnType;
    }

    public String getValueIdColumnName() {
        return this.valueIdColumnName;
    }

    public void setGetMethodName(String str) {
        this.getMethodName = str;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public void setValueColumnName(String str) {
        this.valueColumnName = str;
    }

    public void setValueColumnType(String str) {
        this.valueColumnType = str;
    }

    public void setValueIdColumnName(String str) {
        this.valueIdColumnName = str;
    }
}
