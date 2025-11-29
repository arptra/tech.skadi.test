package com.here.posclient.ext;

public class RndExtension {
    private RndExtension() {
    }

    public static native void dumpRemoteConfiguration();

    public static native void refreshRemoteConfiguration();
}
