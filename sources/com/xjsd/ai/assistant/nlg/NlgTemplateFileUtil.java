package com.xjsd.ai.assistant.nlg;

import android.content.Context;
import android.content.SharedPreferences;
import com.xjsd.ai.assistant.log.ILog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class NlgTemplateFileUtil {
    public static void a(Context context) {
        String str;
        BufferedOutputStream bufferedOutputStream;
        try {
            str = new BufferedReader(new InputStreamReader(context.getAssets().open("nlg_update_date"))).readLine();
        } catch (IOException unused) {
            str = "2020-01-01";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("assistant", 0);
        String string = sharedPreferences.getString("nlg_update_date", "");
        ILog.a("NlgTemplateFileUtil", "读取assets中的版本日期->" + str + "，已缓存版本日期->" + string);
        if (str.equals(string)) {
            ILog.j("NlgTemplateFileUtil", "nlg模版资源无更新，无需再次拷贝");
            return;
        }
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + "nlg_template.json";
        b(new File(str2));
        byte[] bArr = new byte[5120];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open("nlg_template.json"));
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    sharedPreferences.edit().putString("nlg_update_date", str).commit();
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public static void b(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                Objects.requireNonNull(listFiles);
                for (File b : listFiles) {
                    b(b);
                }
            }
            ILog.a("NlgTemplateFileUtil", "删除文件->" + file.getAbsolutePath() + "，result->" + file.delete());
        }
    }
}
