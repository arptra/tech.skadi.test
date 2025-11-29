package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    @Nullable
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;
    private int width;

    @VisibleForTesting
    public static class DelayTarget extends CustomTarget<Bitmap> {
        public final Handler d;
        public final int e;
        public final long f;
        public Bitmap g;

        public DelayTarget(Handler handler, int i, long j) {
            this.d = handler;
            this.e = i;
            this.f = j;
        }

        public Bitmap b() {
            return this.g;
        }

        public void d(Drawable drawable) {
            this.g = null;
        }

        /* renamed from: f */
        public void e(Bitmap bitmap, Transition transition) {
            this.g = bitmap;
            this.d.sendMessageAtTime(this.d.obtainMessage(1, this), this.f);
        }
    }

    public interface FrameCallback {
        void a();
    }

    public class FrameLoaderCallback implements Handler.Callback {
        public FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            } else if (i != 2) {
                return false;
            } else {
                GifFrameLoader.this.requestManager.l((DelayTarget) message.obj);
                return false;
            }
        }
    }

    @VisibleForTesting
    public interface OnEveryFrameListener {
        void a();
    }

    public GifFrameLoader(Glide glide, GifDecoder gifDecoder2, int i, int i2, Transformation<Bitmap> transformation2, Bitmap bitmap) {
        this(glide.f(), Glide.t(glide.h()), gifDecoder2, (Handler) null, getRequestBuilder(Glide.t(glide.h()), i, i2), transformation2, bitmap);
    }

    private static Key getFrameSignature() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager requestManager2, int i, int i2) {
        return requestManager2.f().b(((RequestOptions) ((RequestOptions) RequestOptions.o0(DiskCacheStrategy.b).m0(true)).f0(true)).U(i, i2));
    }

    private void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            if (this.startFromFirstFrame) {
                Preconditions.a(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
                this.gifDecoder.b();
                this.startFromFirstFrame = false;
            }
            DelayTarget delayTarget = this.pendingTarget;
            if (delayTarget != null) {
                this.pendingTarget = null;
                onFrameReady(delayTarget);
                return;
            }
            this.isLoadPending = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.gifDecoder.i());
            this.gifDecoder.f();
            this.next = new DelayTarget(this.handler, this.gifDecoder.c(), uptimeMillis);
            this.requestBuilder.b(RequestOptions.p0(getFrameSignature())).C0(this.gifDecoder).w0(this.next);
        }
    }

    private void recycleFirstFrame() {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            this.bitmapPool.c(bitmap);
            this.firstFrame = null;
        }
    }

    private void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.isCleared = false;
            loadNextFrame();
        }
    }

    private void stop() {
        this.isRunning = false;
    }

    public void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            this.requestManager.l(delayTarget);
            this.current = null;
        }
        DelayTarget delayTarget2 = this.next;
        if (delayTarget2 != null) {
            this.requestManager.l(delayTarget2);
            this.next = null;
        }
        DelayTarget delayTarget3 = this.pendingTarget;
        if (delayTarget3 != null) {
            this.requestManager.l(delayTarget3);
            this.pendingTarget = null;
        }
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    public ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    public Bitmap getCurrentFrame() {
        DelayTarget delayTarget = this.current;
        return delayTarget != null ? delayTarget.b() : this.firstFrame;
    }

    public int getCurrentIndex() {
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.e;
        }
        return -1;
    }

    public Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    public int getFrameCount() {
        return this.gifDecoder.g();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLoopCount() {
        return this.gifDecoder.h();
    }

    public int getSize() {
        return this.gifDecoder.d() + this.firstFrameSize;
    }

    public int getWidth() {
        return this.width;
    }

    @VisibleForTesting
    public void onFrameReady(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener2 = this.onEveryFrameListener;
        if (onEveryFrameListener2 != null) {
            onEveryFrameListener2.a();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else if (this.isRunning) {
            if (delayTarget.b() != null) {
                recycleFirstFrame();
                DelayTarget delayTarget2 = this.current;
                this.current = delayTarget;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    this.callbacks.get(size).a();
                }
                if (delayTarget2 != null) {
                    this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            loadNextFrame();
        } else if (this.startFromFirstFrame) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else {
            this.pendingTarget = delayTarget;
        }
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation2, Bitmap bitmap) {
        this.transformation = (Transformation) Preconditions.d(transformation2);
        this.firstFrame = (Bitmap) Preconditions.d(bitmap);
        this.requestBuilder = this.requestBuilder.b(new RequestOptions().h0(transformation2));
        this.firstFrameSize = Util.i(bitmap);
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }

    public void setNextStartFromFirstFrame() {
        Preconditions.a(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget != null) {
            this.requestManager.l(delayTarget);
            this.pendingTarget = null;
        }
    }

    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable OnEveryFrameListener onEveryFrameListener2) {
        this.onEveryFrameListener = onEveryFrameListener2;
    }

    public void subscribe(FrameCallback frameCallback) {
        if (this.isCleared) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.callbacks.contains(frameCallback)) {
            boolean isEmpty = this.callbacks.isEmpty();
            this.callbacks.add(frameCallback);
            if (isEmpty) {
                start();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    public void unsubscribe(FrameCallback frameCallback) {
        this.callbacks.remove(frameCallback);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }

    public GifFrameLoader(BitmapPool bitmapPool2, RequestManager requestManager2, GifDecoder gifDecoder2, Handler handler2, RequestBuilder<Bitmap> requestBuilder2, Transformation<Bitmap> transformation2, Bitmap bitmap) {
        this.callbacks = new ArrayList();
        this.requestManager = requestManager2;
        handler2 = handler2 == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler2;
        this.bitmapPool = bitmapPool2;
        this.handler = handler2;
        this.requestBuilder = requestBuilder2;
        this.gifDecoder = gifDecoder2;
        setFrameTransformation(transformation2, bitmap);
    }
}
