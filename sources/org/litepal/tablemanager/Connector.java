package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import org.litepal.LitePalApplication;
import org.litepal.parser.LitePalAttr;

public class Connector {
    private static LitePalOpenHelper mLitePalHelper;

    private static LitePalOpenHelper buildConnection() {
        LitePalAttr instance = LitePalAttr.getInstance();
        instance.checkSelfValid();
        if (mLitePalHelper == null) {
            String dbName = instance.getDbName();
            if ("external".equalsIgnoreCase(instance.getStorage())) {
                dbName = LitePalApplication.getContext().getExternalFilesDir("") + "/databases/" + dbName;
            } else if (!"internal".equalsIgnoreCase(instance.getStorage()) && !TextUtils.isEmpty(instance.getStorage())) {
                String replace = (Environment.getExternalStorageDirectory().getPath() + "/" + instance.getStorage()).replace("//", "/");
                File file = new File(replace);
                if (!file.exists()) {
                    file.mkdirs();
                }
                dbName = replace + "/" + dbName;
            }
            mLitePalHelper = new LitePalOpenHelper(dbName, instance.getVersion());
        }
        return mLitePalHelper;
    }

    public static void clearLitePalOpenHelperInstance() {
        LitePalOpenHelper litePalOpenHelper = mLitePalHelper;
        if (litePalOpenHelper != null) {
            litePalOpenHelper.getWritableDatabase().close();
            mLitePalHelper = null;
        }
    }

    public static SQLiteDatabase getDatabase() {
        return getWritableDatabase();
    }

    public static synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (Connector.class) {
            writableDatabase = buildConnection().getWritableDatabase();
        }
        return writableDatabase;
    }
}
