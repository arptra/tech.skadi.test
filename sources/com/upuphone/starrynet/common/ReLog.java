package com.upuphone.starrynet.common;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.meizu.common.widget.MzContactsContract;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReLog {
    private static final int LOG_INTERVAL = 2000;
    private static Handler logHandler;
    private static Map<String, ReLogBean> logs = new ConcurrentHashMap();

    public static class ReLogBean {
        private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("MM-dd HH:mm:ss SSS");
        private static final int MAX_RECORD_LOG_INTERVAL = 10000;
        private int count;
        private long lastInterval = -1;
        private long lastRepeatTime = -1;
        private int logLevel;
        /* access modifiers changed from: private */
        public String message;
        private long startTime;
        String tag;
        private int tid;

        public ReLogBean(int i, String str, String str2) {
            this.tag = str;
            this.count = 1;
            this.startTime = System.currentTimeMillis();
            this.message = str2;
            this.logLevel = i;
            this.tid = Process.myTid();
        }

        public boolean needLog() {
            long j = this.lastInterval;
            return j > AssistantConstants.TIMEOUT_VAD_MUTE || j < 0 || System.currentTimeMillis() - this.startTime > 10000;
        }

        public void outputLog() {
            int i = this.logLevel;
            if (i == 2) {
                StLog.v(this.tag, toString());
            } else if (i == 4) {
                StLog.i(this.tag, toString());
            } else if (i == 5) {
                StLog.w(this.tag, toString());
            } else if (i != 6) {
                StLog.d(this.tag, toString());
            } else {
                StLog.e(this.tag, toString());
            }
        }

        public void repeat() {
            this.count++;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.lastInterval < 0) {
                this.lastInterval = currentTimeMillis - this.startTime;
            } else {
                this.lastInterval = currentTimeMillis - this.lastRepeatTime;
            }
            this.lastRepeatTime = currentTimeMillis;
        }

        @NonNull
        public String toString() {
            return "REPEAT[" + this.tid + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + FORMATTER.format(new Date(this.startTime)) + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA + this.count + "]:" + this.message;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("RepeatLog");
        handlerThread.start();
        logHandler = new Handler(handlerThread.getLooper());
    }

    public static void d(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            log(3, str, str2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$outputLogIfNeed$0(ReLogBean reLogBean) {
        ReLogBean reLogBean2 = logs.get(reLogBean.message);
        if (reLogBean2 == null) {
            return;
        }
        if (reLogBean2.needLog()) {
            logs.remove(reLogBean2.message);
            reLogBean2.outputLog();
            return;
        }
        outputLogIfNeed(reLogBean2);
    }

    private static void log(int i, String str, String str2) {
        ReLogBean reLogBean = logs.get(str2);
        if (reLogBean != null) {
            reLogBean.repeat();
            return;
        }
        ReLogBean reLogBean2 = new ReLogBean(i, str, str2);
        logs.put(str2, reLogBean2);
        outputLogIfNeed(reLogBean2);
    }

    private static void outputLogIfNeed(ReLogBean reLogBean) {
        logHandler.postDelayed(new a(reLogBean), AssistantConstants.TIMEOUT_VAD_MUTE);
    }

    public static void v(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            log(2, str, str2);
        }
    }
}
