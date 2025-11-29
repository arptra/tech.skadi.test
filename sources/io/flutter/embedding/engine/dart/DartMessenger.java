package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.util.TraceSection;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    private static final String TAG = "DartMessenger";
    @NonNull
    private Map<String, List<BufferedMessageInfo>> bufferedMessages;
    @NonNull
    private WeakHashMap<BinaryMessenger.TaskQueue, DartMessengerTaskQueue> createdTaskQueues;
    @NonNull
    private final AtomicBoolean enableBufferingIncomingMessages;
    @NonNull
    private final FlutterJNI flutterJNI;
    @NonNull
    private final Object handlersLock;
    @NonNull
    private final Map<String, HandlerInfo> messageHandlers;
    private int nextReplyId;
    @NonNull
    private final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
    @NonNull
    private final DartMessengerTaskQueue platformTaskQueue;
    @NonNull
    private TaskQueueFactory taskQueueFactory;

    public static class BufferedMessageInfo {
        @NonNull
        public final ByteBuffer message;
        long messageData;
        int replyId;

        public BufferedMessageInfo(@NonNull ByteBuffer byteBuffer, int i, long j) {
            this.message = byteBuffer;
            this.replyId = i;
            this.messageData = j;
        }
    }

    public static class ConcurrentTaskQueue implements DartMessengerTaskQueue {
        @NonNull
        private final ExecutorService executor;

        public ConcurrentTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        public void dispatch(@NonNull Runnable runnable) {
            this.executor.execute(runnable);
        }
    }

    public interface DartMessengerTaskQueue {
        void dispatch(@NonNull Runnable runnable);
    }

    public static class DefaultTaskQueueFactory implements TaskQueueFactory {
        ExecutorService executorService = FlutterInjector.instance().executorService();

        public DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
            return taskQueueOptions.getIsSerial() ? new SerialTaskQueue(this.executorService) : new ConcurrentTaskQueue(this.executorService);
        }
    }

    public static class HandlerInfo {
        @NonNull
        public final BinaryMessenger.BinaryMessageHandler handler;
        @Nullable
        public final DartMessengerTaskQueue taskQueue;

        public HandlerInfo(@NonNull BinaryMessenger.BinaryMessageHandler binaryMessageHandler, @Nullable DartMessengerTaskQueue dartMessengerTaskQueue) {
            this.handler = binaryMessageHandler;
            this.taskQueue = dartMessengerTaskQueue;
        }
    }

    public static class Reply implements BinaryMessenger.BinaryReply {
        private final AtomicBoolean done = new AtomicBoolean(false);
        @NonNull
        private final FlutterJNI flutterJNI;
        private final int replyId;

        public Reply(@NonNull FlutterJNI flutterJNI2, int i) {
            this.flutterJNI = flutterJNI2;
            this.replyId = i;
        }

        public void reply(@Nullable ByteBuffer byteBuffer) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            } else if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }

    public static class SerialTaskQueue implements DartMessengerTaskQueue {
        @NonNull
        private final ExecutorService executor;
        @NonNull
        private final AtomicBoolean isRunning = new AtomicBoolean(false);
        @NonNull
        private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        public SerialTaskQueue(ExecutorService executorService) {
            this.executor = executorService;
        }

        /* access modifiers changed from: private */
        /* renamed from: flush */
        public void lambda$flush$1() {
            if (this.isRunning.compareAndSet(false, true)) {
                try {
                    Runnable poll = this.queue.poll();
                    if (poll != null) {
                        poll.run();
                    }
                } finally {
                    this.isRunning.set(false);
                    if (!this.queue.isEmpty()) {
                        this.executor.execute(new c(this));
                    }
                }
            }
        }

        public void dispatch(@NonNull Runnable runnable) {
            this.queue.add(runnable);
            this.executor.execute(new b(this));
        }
    }

    public interface TaskQueueFactory {
        DartMessengerTaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions);
    }

    public static class TaskQueueToken implements BinaryMessenger.TaskQueue {
        private TaskQueueToken() {
        }
    }

    public DartMessenger(@NonNull FlutterJNI flutterJNI2, @NonNull TaskQueueFactory taskQueueFactory2) {
        this.messageHandlers = new HashMap();
        this.bufferedMessages = new HashMap();
        this.handlersLock = new Object();
        this.enableBufferingIncomingMessages = new AtomicBoolean(false);
        this.pendingReplies = new HashMap();
        this.nextReplyId = 1;
        this.platformTaskQueue = new PlatformTaskQueue();
        this.createdTaskQueues = new WeakHashMap<>();
        this.flutterJNI = flutterJNI2;
        this.taskQueueFactory = taskQueueFactory2;
    }

    private void dispatchMessageToQueue(@NonNull String str, @Nullable HandlerInfo handlerInfo, @Nullable ByteBuffer byteBuffer, int i, long j) {
        HandlerInfo handlerInfo2 = handlerInfo;
        DartMessengerTaskQueue dartMessengerTaskQueue = handlerInfo2 != null ? handlerInfo2.taskQueue : null;
        TraceSection.beginAsyncSection("PlatformChannel ScheduleHandler on " + str, i);
        a aVar = new a(this, str, i, handlerInfo, byteBuffer, j);
        if (dartMessengerTaskQueue == null) {
            dartMessengerTaskQueue = this.platformTaskQueue;
        }
        dartMessengerTaskQueue.dispatch(aVar);
    }

    private static void handleError(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() != null) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
            return;
        }
        throw error;
    }

    private void invokeHandler(@Nullable HandlerInfo handlerInfo, @Nullable ByteBuffer byteBuffer, int i) {
        if (handlerInfo != null) {
            try {
                Log.v(TAG, "Deferring to registered handler to process message.");
                handlerInfo.handler.onMessage(byteBuffer, new Reply(this.flutterJNI, i));
            } catch (Exception e) {
                Log.e(TAG, "Uncaught exception in binary message listener", e);
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
            } catch (Error e2) {
                handleError(e2);
            }
        } else {
            Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchMessageToQueue$0(String str, int i, HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j) {
        TraceSection scoped;
        TraceSection.endAsyncSection("PlatformChannel ScheduleHandler on " + str, i);
        try {
            scoped = TraceSection.scoped("DartMessenger#handleMessageFromDart on " + str);
            invokeHandler(handlerInfo, byteBuffer, i);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
            if (scoped != null) {
                scoped.close();
            }
            this.flutterJNI.cleanupMessageData(j);
            return;
        } catch (Throwable th) {
            this.flutterJNI.cleanupMessageData(j);
            throw th;
        }
        throw th;
    }

    public void disableBufferingIncomingMessages() {
        Map<String, List<BufferedMessageInfo>> map;
        synchronized (this.handlersLock) {
            this.enableBufferingIncomingMessages.set(false);
            map = this.bufferedMessages;
            this.bufferedMessages = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            for (BufferedMessageInfo bufferedMessageInfo : (List) next.getValue()) {
                dispatchMessageToQueue((String) next.getKey(), (HandlerInfo) null, bufferedMessageInfo.message, bufferedMessageInfo.replyId, bufferedMessageInfo.messageData);
            }
        }
    }

    public void enableBufferingIncomingMessages() {
        this.enableBufferingIncomingMessages.set(true);
    }

    @UiThread
    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    public void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i, long j) {
        HandlerInfo handlerInfo;
        boolean z;
        Log.v(TAG, "Received message from Dart over channel '" + str + "'");
        synchronized (this.handlersLock) {
            try {
                handlerInfo = this.messageHandlers.get(str);
                z = this.enableBufferingIncomingMessages.get() && handlerInfo == null;
                if (z) {
                    if (!this.bufferedMessages.containsKey(str)) {
                        this.bufferedMessages.put(str, new LinkedList());
                    }
                    this.bufferedMessages.get(str).add(new BufferedMessageInfo(byteBuffer, i, j));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!z) {
            dispatchMessageToQueue(str, handlerInfo, byteBuffer, i, j);
        }
    }

    public void handlePlatformMessageResponse(int i, @Nullable ByteBuffer byteBuffer) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.pendingReplies.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                remove.reply(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            } catch (Exception e) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", e);
            } catch (Error e2) {
                handleError(e2);
            }
        }
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        DartMessengerTaskQueue makeBackgroundTaskQueue = this.taskQueueFactory.makeBackgroundTaskQueue(taskQueueOptions);
        TaskQueueToken taskQueueToken = new TaskQueueToken();
        this.createdTaskQueues.put(taskQueueToken, makeBackgroundTaskQueue);
        return taskQueueToken;
    }

    @UiThread
    public void send(@NonNull String str, @NonNull ByteBuffer byteBuffer) {
        Log.v(TAG, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        setMessageHandler(str, binaryMessageHandler, (BinaryMessenger.TaskQueue) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        r10 = r10.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        if (r10.hasNext() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        r11 = (io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r10.next();
        dispatchMessageToQueue(r9, r8.messageHandlers.get(r9), r11.message, r11.replyId, r11.messageData);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMessageHandler(@androidx.annotation.NonNull java.lang.String r9, @androidx.annotation.Nullable io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler r10, @androidx.annotation.Nullable io.flutter.plugin.common.BinaryMessenger.TaskQueue r11) {
        /*
            r8 = this;
            if (r10 != 0) goto L_0x002a
            java.lang.String r10 = "DartMessenger"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Removing handler for channel '"
            r11.append(r0)
            r11.append(r9)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            io.flutter.Log.v(r10, r11)
            java.lang.Object r0 = r8.handlersLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r8 = r8.messageHandlers     // Catch:{ all -> 0x0027 }
            r8.remove(r9)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r8
        L_0x002a:
            if (r11 == 0) goto L_0x003f
            java.util.WeakHashMap<io.flutter.plugin.common.BinaryMessenger$TaskQueue, io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue> r0 = r8.createdTaskQueues
            java.lang.Object r11 = r0.get(r11)
            io.flutter.embedding.engine.dart.DartMessenger$DartMessengerTaskQueue r11 = (io.flutter.embedding.engine.dart.DartMessenger.DartMessengerTaskQueue) r11
            if (r11 == 0) goto L_0x0037
            goto L_0x0040
        L_0x0037:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue)."
            r8.<init>(r9)
            throw r8
        L_0x003f:
            r11 = 0
        L_0x0040:
            java.lang.String r0 = "DartMessenger"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Setting handler for channel '"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            io.flutter.Log.v(r0, r1)
            java.lang.Object r0 = r8.handlersLock
            monitor-enter(r0)
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r1 = r8.messageHandlers     // Catch:{ all -> 0x0074 }
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r2 = new io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo     // Catch:{ all -> 0x0074 }
            r2.<init>(r10, r11)     // Catch:{ all -> 0x0074 }
            r1.put(r9, r2)     // Catch:{ all -> 0x0074 }
            java.util.Map<java.lang.String, java.util.List<io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo>> r10 = r8.bufferedMessages     // Catch:{ all -> 0x0074 }
            java.lang.Object r10 = r10.remove(r9)     // Catch:{ all -> 0x0074 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x0074 }
            if (r10 != 0) goto L_0x0076
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            return
        L_0x0074:
            r8 = move-exception
            goto L_0x009d
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            java.util.Iterator r10 = r10.iterator()
        L_0x007b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x009c
            java.lang.Object r11 = r10.next()
            io.flutter.embedding.engine.dart.DartMessenger$BufferedMessageInfo r11 = (io.flutter.embedding.engine.dart.DartMessenger.BufferedMessageInfo) r11
            java.util.Map<java.lang.String, io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo> r0 = r8.messageHandlers
            java.lang.Object r0 = r0.get(r9)
            r3 = r0
            io.flutter.embedding.engine.dart.DartMessenger$HandlerInfo r3 = (io.flutter.embedding.engine.dart.DartMessenger.HandlerInfo) r3
            java.nio.ByteBuffer r4 = r11.message
            int r5 = r11.replyId
            long r6 = r11.messageData
            r1 = r8
            r2 = r9
            r1.dispatchMessageToQueue(r2, r3, r4, r5, r6)
            goto L_0x007b
        L_0x009c:
            return
        L_0x009d:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.dart.DartMessenger.setMessageHandler(java.lang.String, io.flutter.plugin.common.BinaryMessenger$BinaryMessageHandler, io.flutter.plugin.common.BinaryMessenger$TaskQueue):void");
    }

    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
        TraceSection scoped = TraceSection.scoped("DartMessenger#send on " + str);
        try {
            Log.v(TAG, "Sending message with callback over channel '" + str + "'");
            int i = this.nextReplyId;
            this.nextReplyId = i + 1;
            if (binaryReply != null) {
                this.pendingReplies.put(Integer.valueOf(i), binaryReply);
            }
            if (byteBuffer == null) {
                this.flutterJNI.dispatchEmptyPlatformMessage(str, i);
            } else {
                this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
            }
            if (scoped != null) {
                scoped.close();
                return;
            }
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public DartMessenger(@NonNull FlutterJNI flutterJNI2) {
        this(flutterJNI2, new DefaultTaskQueueFactory());
    }
}
