package org.eclipse.jetty.util.security;

import com.meizu.common.util.LunarCalendar;
import com.meizu.common.widget.MzContactsContract;
import java.io.Serializable;
import java.util.Arrays;

public class Constraint implements Cloneable, Serializable {
    public static final String ANY_ROLE = "*";
    public static final int DC_CONFIDENTIAL = 2;
    public static final int DC_FORBIDDEN = 3;
    public static final int DC_INTEGRAL = 1;
    public static final int DC_NONE = 0;
    public static final int DC_UNSET = -1;
    public static final String NONE = "NONE";
    public static final String __BASIC_AUTH = "BASIC";
    public static final String __CERT_AUTH = "CLIENT_CERT";
    public static final String __CERT_AUTH2 = "CLIENT-CERT";
    public static final String __DIGEST_AUTH = "DIGEST";
    public static final String __FORM_AUTH = "FORM";
    public static final String __NEGOTIATE_AUTH = "NEGOTIATE";
    public static final String __SPNEGO_AUTH = "SPNEGO";
    private boolean _anyRole = false;
    private boolean _authenticate = false;
    private int _dataConstraint = -1;
    private String _name;
    private String[] _roles;

    public Constraint() {
    }

    public static boolean validateMethod(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        return trim.equals(__FORM_AUTH) || trim.equals(__BASIC_AUTH) || trim.equals(__DIGEST_AUTH) || trim.equals(__CERT_AUTH) || trim.equals(__CERT_AUTH2) || trim.equals(__SPNEGO_AUTH) || trim.equals(__NEGOTIATE_AUTH);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean getAuthenticate() {
        return this._authenticate;
    }

    public int getDataConstraint() {
        return this._dataConstraint;
    }

    public String[] getRoles() {
        return this._roles;
    }

    public boolean hasDataConstraint() {
        return this._dataConstraint >= 0;
    }

    public boolean hasRole(String str) {
        if (this._anyRole) {
            return true;
        }
        String[] strArr = this._roles;
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return false;
            }
            if (str.equals(this._roles[i])) {
                return true;
            }
            length = i;
        }
    }

    public boolean isAnyRole() {
        return this._anyRole;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = r1._roles;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isForbidden() {
        /*
            r1 = this;
            boolean r0 = r1._authenticate
            if (r0 == 0) goto L_0x0011
            boolean r0 = r1._anyRole
            if (r0 != 0) goto L_0x0011
            java.lang.String[] r1 = r1._roles
            if (r1 == 0) goto L_0x000f
            int r1 = r1.length
            if (r1 != 0) goto L_0x0011
        L_0x000f:
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.security.Constraint.isForbidden():boolean");
    }

    public void setAuthenticate(boolean z) {
        this._authenticate = z;
    }

    public void setDataConstraint(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("Constraint out of range");
        }
        this._dataConstraint = i;
    }

    public void setName(String str) {
        this._name = str;
    }

    public void setRoles(String[] strArr) {
        this._roles = strArr;
        this._anyRole = false;
        if (strArr != null) {
            int length = strArr.length;
            while (true) {
                boolean z = this._anyRole;
                if (!z) {
                    int i = length - 1;
                    if (length > 0) {
                        this._anyRole = "*".equals(strArr[i]) | z;
                        length = i;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("SC{");
        sb.append(this._name);
        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        if (this._anyRole) {
            str = "*";
        } else {
            String[] strArr = this._roles;
            str = strArr == null ? LunarCalendar.DATE_SEPARATOR : Arrays.asList(strArr).toString();
        }
        sb.append(str);
        sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        int i = this._dataConstraint;
        sb.append(i == -1 ? "DC_UNSET}" : i == 0 ? "NONE}" : i == 1 ? "INTEGRAL}" : "CONFIDENTIAL}");
        return sb.toString();
    }

    public Constraint(String str, String str2) {
        setName(str);
        setRoles(new String[]{str2});
    }
}
