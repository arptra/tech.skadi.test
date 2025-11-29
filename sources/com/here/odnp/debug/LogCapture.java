package com.here.odnp.debug;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import com.here.odnp.util.Log;
import com.here.odnp.util.Timer;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

public final class LogCapture {
    private static final String TAG = "odnp.debug.LogCapture";
    private static final Collection<String> mSystemProperties = null;
    private final Context mContext;
    private BroadcastReceiver mDeviceStatusListener;
    private volatile boolean mFileTracesEnabled = false;
    private File mLogFile;
    private Process mLogcatProcess;
    private int mStartErrorCounter;
    private Timer.Task mStatusCheckTask;
    private Timer mStatusCheckTimer;

    public LogCapture(Context context) {
        Log.v(TAG, "LogCapture", new Object[0]);
        this.mContext = context;
    }

    private void checkCaptureStatus() {
    }

    @TargetApi(21)
    private static String getAbis() {
        return "";
    }

    private static Integer getProcessExitValue(Process process) {
        return null;
    }

    private static String getTimeInLogFormat(long j) {
        return "";
    }

    private static boolean isEmulator() {
        return false;
    }

    private synchronized boolean isLogcatRunning() {
        return false;
    }

    private static boolean isProcessAlive(Process process) {
        return false;
    }

    private void killLogcatProcesses() {
    }

    private void scanFile(File file) {
    }

    private void startDeviceStatusListener() {
    }

    private synchronized void startLogcat() {
    }

    private synchronized void startStatusCheckTimer(long j) {
    }

    private void stopDeviceStatusListener() {
    }

    private synchronized void stopLogcat() {
    }

    private void stopStatusCheckTimer() {
    }

    @SuppressLint({"HardwareIds"})
    @TargetApi(21)
    private void writeDeviceInfo(PrintStream printStream) {
    }

    private void writeLogHeader(File file) throws IOException {
    }

    private void writeOdnpInfo(PrintStream printStream) {
    }

    public synchronized void startFileTracing() {
    }

    public synchronized void stopFileTracing() {
    }
}
