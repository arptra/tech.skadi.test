package com.upuphone.ar.fastrecord.phone.utils;

import android.os.Environment;
import android.os.StatFs;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;

public class MemoryUtils {
    public static boolean checkFreeDiskIsLack() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCountLong = statFs.getBlockCountLong();
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        long j = availableBlocksLong * blockSizeLong;
        LogExt.logE("availROMSize = " + j + ",totalROMSize = " + (blockCountLong * blockSizeLong), "MemoryUtils");
        return j < 104857600;
    }

    public static int getRomPercentage() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCountLong = statFs.getBlockCountLong();
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        return (int) ((((double) (availableBlocksLong * blockSizeLong)) / ((double) (blockCountLong * blockSizeLong))) * 100.0d);
    }
}
