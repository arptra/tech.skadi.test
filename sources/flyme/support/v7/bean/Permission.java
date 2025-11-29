package flyme.support.v7.bean;

import java.util.ArrayList;

public class Permission {
    private String name;
    private String permission;
    private ArrayList<Permission> permissionChild;
    private int resId;

    public String getName() {
        return this.name;
    }

    public String getPermission() {
        return this.permission;
    }

    public ArrayList<Permission> getPermissionChild() {
        return this.permissionChild;
    }

    public int getResId() {
        return this.resId;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPermission(String str) {
        this.permission = str;
    }

    public void setPermissionChild(ArrayList<Permission> arrayList) {
        this.permissionChild = arrayList;
    }

    public void setResId(int i) {
        this.resId = i;
    }
}
