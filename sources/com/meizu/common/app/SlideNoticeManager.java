package com.meizu.common.app;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.util.ArrayList;

public class SlideNoticeManager {
    private static final boolean DBG = true;
    private static final int LONG_DELAY = 3500;
    private static final int MESSAGE_TIMEOUT = 1;
    private static final int SHORT_DELAY = 2000;
    private static final String TAG = "SlideNoticeManager";
    private Activity mCurActivity;
    private WorkerHandler mHandler = new WorkerHandler();
    private ArrayList<NoticeRecord> mNoticeQueue = new ArrayList<>();

    public interface NoticeCallBack {
        void hide();

        void show();
    }

    public final class WorkerHandler extends Handler {
        private WorkerHandler() {
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                SlideNoticeManager.this.handleTimeout((NoticeRecord) message.obj);
            }
        }
    }

    private void cancelNotice(int i) {
        Log.d(TAG, "cancelNotice index=" + i);
        this.mNoticeQueue.get(i).callback.hide();
        this.mNoticeQueue.remove(i);
        if (this.mNoticeQueue.size() > 0) {
            showNextNotice();
        }
    }

    /* access modifiers changed from: private */
    public void handleTimeout(NoticeRecord noticeRecord) {
        Log.d(TAG, "Timeout callback=" + noticeRecord.callback);
        synchronized (this.mNoticeQueue) {
            try {
                int indexOfNotice = indexOfNotice(noticeRecord.callback);
                if (indexOfNotice >= 0) {
                    cancelNotice(indexOfNotice);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int indexOfNotice(NoticeCallBack noticeCallBack) {
        ArrayList<NoticeRecord> arrayList = this.mNoticeQueue;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).callback == noticeCallBack) {
                return i;
            }
        }
        return -1;
    }

    private void removeLastActivityRecord() {
        ArrayList<NoticeRecord> arrayList = this.mNoticeQueue;
        int i = 0;
        while (i < arrayList.size()) {
            if (arrayList.get(i).activity != null) {
                arrayList.remove(i);
                i--;
            }
            i++;
        }
    }

    private void scheduleTimeout(NoticeRecord noticeRecord) {
        this.mHandler.removeCallbacksAndMessages(noticeRecord);
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 1, noticeRecord), noticeRecord.duration == 1 ? 3500 : AssistantConstants.TIMEOUT_VAD_MUTE);
    }

    private void showNextNotice() {
        NoticeRecord noticeRecord = this.mNoticeQueue.get(0);
        while (noticeRecord != null) {
            try {
                Log.d(TAG, "Show callback=" + noticeRecord.callback);
                noticeRecord.callback.show();
                scheduleTimeout(noticeRecord);
                return;
            } catch (Exception e) {
                Log.e(TAG, "catch an exception when showing next notice, it will be romoved from queue", e);
                int indexOf = this.mNoticeQueue.indexOf(noticeRecord);
                if (indexOf >= 0) {
                    this.mNoticeQueue.remove(indexOf);
                }
                noticeRecord = this.mNoticeQueue.size() > 0 ? this.mNoticeQueue.get(0) : null;
            }
        }
    }

    public void enqueueNotice(CharSequence charSequence, NoticeCallBack noticeCallBack, int i) {
        Log.i(TAG, "enqueueNotice callback=" + noticeCallBack + " message=" + charSequence + " duration=" + i);
        if (noticeCallBack != null) {
            synchronized (this.mNoticeQueue) {
                try {
                    int indexOfNotice = indexOfNotice(noticeCallBack);
                    if (indexOfNotice >= 0) {
                        this.mNoticeQueue.get(indexOfNotice).update(i);
                    } else {
                        if (this.mNoticeQueue.size() > 0) {
                            ArrayList<NoticeRecord> arrayList = this.mNoticeQueue;
                            if (TextUtils.equals(charSequence, arrayList.get(arrayList.size() - 1).message)) {
                                indexOfNotice = this.mNoticeQueue.size() - 1;
                            }
                        }
                        this.mNoticeQueue.add(new NoticeRecord(charSequence, i, noticeCallBack));
                        indexOfNotice = this.mNoticeQueue.size() - 1;
                    }
                    if (indexOfNotice == 0) {
                        showNextNotice();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void enqueueNoticeInActivity(CharSequence charSequence, NoticeCallBack noticeCallBack, int i, Activity activity) {
        Log.i(TAG, "enqueueNoticeInActivity callback=" + noticeCallBack + " message=" + charSequence + " duration=" + i + " activity=" + activity);
        if (noticeCallBack != null && activity != null) {
            synchronized (this.mNoticeQueue) {
                try {
                    if (this.mCurActivity != activity) {
                        this.mCurActivity = activity;
                        removeLastActivityRecord();
                    }
                    int indexOfNotice = indexOfNotice(noticeCallBack);
                    if (indexOfNotice >= 0) {
                        this.mNoticeQueue.get(indexOfNotice).update(i);
                    } else {
                        if (this.mNoticeQueue.size() > 0) {
                            ArrayList<NoticeRecord> arrayList = this.mNoticeQueue;
                            if (TextUtils.equals(charSequence, arrayList.get(arrayList.size() - 1).message)) {
                                indexOfNotice = this.mNoticeQueue.size() - 1;
                            }
                        }
                        this.mNoticeQueue.add(new NoticeRecord(charSequence, i, noticeCallBack, activity));
                        indexOfNotice = this.mNoticeQueue.size() - 1;
                    }
                    if (indexOfNotice == 0) {
                        showNextNotice();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class NoticeRecord {
        final Activity activity;
        final NoticeCallBack callback;
        int duration;
        CharSequence message;

        public NoticeRecord(CharSequence charSequence, int i, NoticeCallBack noticeCallBack) {
            this.message = charSequence;
            this.duration = i;
            this.callback = noticeCallBack;
            this.activity = null;
        }

        public final String toString() {
            return "NoticeRecord{" + Integer.toHexString(System.identityHashCode(this)) + " callback=" + this.callback + " duration=" + this.duration;
        }

        public void update(int i) {
            this.duration = i;
        }

        public NoticeRecord(CharSequence charSequence, int i, NoticeCallBack noticeCallBack, Activity activity2) {
            this.message = charSequence;
            this.duration = i;
            this.callback = noticeCallBack;
            this.activity = activity2;
        }
    }

    public void cancelNotice(NoticeCallBack noticeCallBack) {
        if (noticeCallBack != null) {
            synchronized (this.mNoticeQueue) {
                try {
                    int indexOfNotice = indexOfNotice(noticeCallBack);
                    if (indexOfNotice >= 0) {
                        this.mHandler.removeCallbacksAndMessages(this.mNoticeQueue.get(indexOfNotice));
                        cancelNotice(indexOfNotice);
                    } else {
                        Log.w(TAG, "Notice already cancelled. callback=" + noticeCallBack);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
