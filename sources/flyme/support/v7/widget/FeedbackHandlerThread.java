package flyme.support.v7.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.Thread;
import java.lang.ref.WeakReference;

class FeedbackHandlerThread extends HandlerThread {
    private static final int PERFORM_FEEDBACK_MESSAGE = 0;
    private static final String TAG = "FHT_LOG";
    private static final String THREAD_NAME = "FeedbackHandlerThread";
    private static volatile FeedbackHandlerThread instance;
    private Handler mHandler;

    public static final class FeedbackHandler extends Handler {
        public FeedbackHandler(@NonNull Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            Object obj;
            if (message.what == 0) {
                Object obj2 = message.obj;
                if ((obj2 instanceof WeakReference) && (obj = ((WeakReference) obj2).get()) != null) {
                    View view = (View) obj;
                    if (view.isAttachedToWindow()) {
                        view.performHapticFeedback(message.arg1);
                    }
                }
            }
        }
    }

    private FeedbackHandlerThread() {
        super(THREAD_NAME);
    }

    private boolean ensureStarted() {
        if (Thread.State.NEW == getState()) {
            start();
        }
        return this.mHandler != null;
    }

    public static FeedbackHandlerThread getInstance() {
        if (instance == null) {
            synchronized (FeedbackHandlerThread.class) {
                try {
                    if (instance == null) {
                        instance = new FeedbackHandlerThread();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        instance.ensureStarted();
        return instance;
    }

    public void sendPerformHapticFeedbackMessage(View view, int i) {
        if (view.isAttachedToWindow() && ensureStarted()) {
            Message obtain = Message.obtain();
            obtain.obj = new WeakReference(view);
            obtain.arg1 = i;
            obtain.what = 0;
            this.mHandler.sendMessage(obtain);
        }
    }

    public synchronized void start() {
        try {
            Log.d(TAG, "start state" + getState());
            super.start();
            this.mHandler = new FeedbackHandler(getLooper());
        } catch (Exception e) {
            Log.e(TAG, "FeedbackHandlerThread start ex : " + e);
        }
        return;
    }
}
