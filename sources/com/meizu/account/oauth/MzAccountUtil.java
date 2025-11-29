package com.meizu.account.oauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;
import com.meizu.account.oauth.data.AccountInfo;
import com.meizu.common.widget.MzContactsContract;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class MzAccountUtil {
    private static final String DEFAULT_SEGMENT = "_";
    private static final String TAG = "MzAccountUtil";
    private static Class<?> mBuildExt;
    private static Boolean mIsInternational;

    public static Account getAccount(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType(MzContactsContract.MzAccounts.FLYME_ACCOUNT_TYPE);
        if (accountsByType.length <= 0) {
            return null;
        }
        if (accountsByType.length != 1) {
            String str = TAG;
            Log.e(str, "more than 1 flyme account : " + accountsByType.length);
        }
        return accountsByType[0];
    }

    public static AccountInfo getAccountInfo(Context context) {
        Account account = getAccount(context);
        if (account == null) {
            return null;
        }
        try {
            AccountManager accountManager = AccountManager.get(context);
            return new AccountInfo(accountManager.getUserData(account, "nickname"), accountManager.getUserData(account, "phone"), accountManager.getUserData(account, OAuthConstants.KEY_ICON));
        } catch (Exception unused) {
            return new AccountInfo((String) null, (String) null, (String) null);
        }
    }

    public static String getAccountUid(Context context) {
        if (context == null) {
            return null;
        }
        Account account = getAccount(context);
        return account == null ? "" : account.name;
    }

    public static String getLocalLanguage() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    public static boolean hasAccount(Context context) {
        return (context == null || getAccount(context) == null) ? false : true;
    }

    public static boolean isProductInternational() {
        try {
            if (mIsInternational == null) {
                if (mBuildExt == null) {
                    mBuildExt = Class.forName("android.os.BuildExt");
                }
                mIsInternational = (Boolean) mBuildExt.getMethod("isProductInternational", (Class[]) null).invoke((Object) null, (Object[]) null);
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            String str = TAG;
            Log.d(str, "[isProductInternational] error = " + e.getMessage());
        }
        Boolean bool = mIsInternational;
        return bool != null && bool.booleanValue();
    }
}
