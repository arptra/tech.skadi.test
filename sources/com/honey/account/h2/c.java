package com.honey.account.h2;

import com.honey.account.utils.log.SaveLog;
import java.io.File;
import java.io.FileFilter;

public final /* synthetic */ class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SaveLog f9202a;

    public /* synthetic */ c(SaveLog saveLog) {
        this.f9202a = saveLog;
    }

    public final boolean accept(File file) {
        return SaveLog.cleanOldLogFile$lambda$0(this.f9202a, file);
    }
}
