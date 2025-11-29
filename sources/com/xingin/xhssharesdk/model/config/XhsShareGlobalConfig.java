package com.xingin.xhssharesdk.model.config;

import androidx.annotation.Keep;
import com.xingin.xhssharesdk.k.a;
import com.xingin.xhssharesdk.log.IShareLogger;

@Keep
public class XhsShareGlobalConfig {
    private String cacheDirPath = null;
    private boolean clearCacheWhenShareComplete = true;
    private boolean enableLog = false;
    private String fileProviderAuthority;
    private IShareLogger iShareLogger = new a();
    private boolean needRegisterReceiverWithOutsideActivity = false;

    public String getCacheDirPath() {
        return this.cacheDirPath;
    }

    public String getFileProviderAuthority() {
        return this.fileProviderAuthority;
    }

    public IShareLogger getShareLogger() {
        return this.iShareLogger;
    }

    public boolean isClearCacheWhenShareComplete() {
        return this.clearCacheWhenShareComplete;
    }

    public boolean isEnableLog() {
        return this.enableLog;
    }

    public boolean isNeedRegisterReceiverWithOutsideActivity() {
        return this.needRegisterReceiverWithOutsideActivity;
    }

    public XhsShareGlobalConfig setCacheDirPath(String str) {
        this.cacheDirPath = str;
        return this;
    }

    public XhsShareGlobalConfig setClearCacheWhenShareComplete(boolean z) {
        this.clearCacheWhenShareComplete = z;
        return this;
    }

    public XhsShareGlobalConfig setEnableLog(boolean z) {
        this.enableLog = z;
        return this;
    }

    public XhsShareGlobalConfig setFileProviderAuthority(String str) {
        this.fileProviderAuthority = str;
        return this;
    }

    public XhsShareGlobalConfig setNeedRegisterReceiverWithOutsideActivity(boolean z) {
        this.needRegisterReceiverWithOutsideActivity = z;
        return this;
    }

    public void setShareLogger(IShareLogger iShareLogger2) {
        this.iShareLogger = iShareLogger2;
    }
}
