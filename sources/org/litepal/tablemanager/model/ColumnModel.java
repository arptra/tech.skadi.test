package org.litepal.tablemanager.model;

import android.text.TextUtils;

public class ColumnModel {
    private String columnName;
    private String columnType;
    private String defaultValue = "";
    private boolean hasIndex = false;
    private boolean isNullable = true;
    private boolean isUnique = false;

    public String getColumnName() {
        return this.columnName;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public boolean hasIndex() {
        return this.hasIndex;
    }

    public boolean isIdColumn() {
        return "_id".equalsIgnoreCase(this.columnName) || "id".equalsIgnoreCase(this.columnName);
    }

    public boolean isNullable() {
        return this.isNullable;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public void setColumnType(String str) {
        this.columnType = str;
    }

    public void setDefaultValue(String str) {
        if (!"text".equalsIgnoreCase(this.columnType)) {
            this.defaultValue = str;
        } else if (!TextUtils.isEmpty(str)) {
            this.defaultValue = "'" + str + "'";
        }
    }

    public void setHasIndex(boolean z) {
        this.hasIndex = z;
    }

    public void setNullable(boolean z) {
        this.isNullable = z;
    }

    public void setUnique(boolean z) {
        this.isUnique = z;
    }
}
