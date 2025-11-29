package com.upuphone.runasone.utils.log;

import android.content.Context;
import android.os.Process;
import com.honey.account.constant.AccountConstantKt;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.runasone.utils.log.file.ILogWrite;
import com.upuphone.runasone.utils.log.file.LogWriteFactory;

public class FilePrint implements ILogPrinter {
    private final ILogWrite logWrite;

    public FilePrint(Context context) {
        this.logWrite = LogWriteFactory.getInstance(context, 1);
    }

    private static String getCurrentTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis / 1000;
        long j2 = j % 60;
        long j3 = j / 60;
        long j4 = j3 % 60;
        long j5 = (j3 / 60) % 24;
        long j6 = 8 + j5;
        StringBuilder sb = new StringBuilder();
        if (j6 >= 24) {
            j6 = j5 - 16;
        }
        sb.append(j6);
        sb.append(AccountConstantKt.CODE_SEPARTOR);
        sb.append(j4);
        sb.append(AccountConstantKt.CODE_SEPARTOR);
        sb.append(j2);
        sb.append(".");
        sb.append(currentTimeMillis % 1000);
        return sb.toString();
    }

    public void flush() {
        ILogWrite iLogWrite = this.logWrite;
        if (iLogWrite != null) {
            iLogWrite.flush();
        }
    }

    public void println(int i, String str, String str2) {
        this.logWrite.write(getCurrentTime() + " " + Process.myPid() + LunarCalendar.DATE_SEPARATOR + Process.myTid() + "/" + LogLevel.getShortLevelName(i) + " " + str + " " + str2 + "\r\n");
    }
}
