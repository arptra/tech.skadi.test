package com.upuphone.xr.account.domain.enums;

import com.ucar.vehiclesdk.MDevice;
import com.upuphone.xr.sapp.contract.ProtocolCategory;

public enum AccountTypeEnum {
    XJSD("xjsd", "xj"),
    MEIZU(MDevice.MANUFACTURERS_MEIZU, "mz"),
    FLYME(ProtocolCategory.FLYME, "mz-uc");
    
    private final String accountType;
    private final String key;

    private AccountTypeEnum(String str, String str2) {
        this.key = str;
        this.accountType = str2;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getKey() {
        return this.key;
    }

    public static AccountTypeEnum getAccountType(String str) {
        for (AccountTypeEnum accountTypeEnum : values()) {
            if (accountTypeEnum.getAccountType().equals(str)) {
                return accountTypeEnum;
            }
        }
        return null;
    }
}
