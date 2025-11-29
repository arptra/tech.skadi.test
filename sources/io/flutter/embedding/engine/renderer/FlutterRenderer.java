package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.honey.account.ab.g;
import com.honey.account.ab.h;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";
    @VisibleForTesting
    public static boolean debugForceSurfaceProducerGlTextures = false;
    /* access modifiers changed from: private */
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    /* access modifiers changed from: private */
    public final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isDisplayingFlutterUi = false;
    @NonNull
    private final AtomicLong nextTextureId = new AtomicLong(0);
    @NonNull
    private final Set<WeakReference<TextureRegistry.OnTrimMemoryListener>> onTrimMemoryListeners = new HashSet();
    @Nullable
    private Surface surface;

    public enum DisplayFeatureState {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);
        
        public final int encodedValue;

        private DisplayFeatureState(int i) {
            this.encodedValue = i;
        }
    }

    public enum DisplayFeatureType {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);
        
        public final int encodedValue;

        private DisplayFeatureType(int i) {
            this.encodedValue = i;
        }
    }

    @Keep
    @TargetApi(29)
    public final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer, TextureRegistry.OnTrimMemoryListener {
        private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
        private static final int MAX_IMAGES = 5;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private static final boolean VERBOSE_LOGS = false;
        private boolean createNewReader = true;
        private final long id;
        private boolean ignoringFence = false;
        private final ArrayDeque<PerImageReader> imageReaderQueue = new ArrayDeque<>();
        private long lastDequeueTime = 0;
        private PerImage lastDequeuedImage = null;
        private long lastQueueTime = 0;
        /* access modifiers changed from: private */
        public PerImageReader lastReaderDequeuedFrom = null;
        private long lastScheduleTime = 0;
        private Object lock = new Object();
        private int numTrims = 0;
        private final HashMap<ImageReader, PerImageReader> perImageReaders = new HashMap<>();
        /* access modifiers changed from: private */
        public boolean released;
        private int requestedHeight = 1;
        private int requestedWidth = 1;
        private boolean trimOnMemoryPressure = true;

        public class PerImage {
            public final Image image;
            public final long queuedTime;

            public PerImage(Image image2, long j) {
                this.image = image2;
                this.queuedTime = j;
            }
        }

        public class PerImageReader {
            private boolean closed = false;
            /* access modifiers changed from: private */
            public final ArrayDeque<PerImage> imageQueue = new ArrayDeque<>();
            private final ImageReader.OnImageAvailableListener onImageAvailableListener;
            public final ImageReader reader;

            public PerImageReader(ImageReader imageReader) {
                a aVar = new a(this);
                this.onImageAvailableListener = aVar;
                this.reader = imageReader;
                imageReader.setOnImageAvailableListener(aVar, new Handler(Looper.getMainLooper()));
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$new$0(ImageReader imageReader) {
                Image image;
                try {
                    image = imageReader.acquireLatestImage();
                } catch (IllegalStateException e) {
                    Log.e(ImageReaderSurfaceProducer.TAG, "onImageAvailable acquireLatestImage failed: " + e);
                    image = null;
                }
                if (image != null) {
                    if (ImageReaderSurfaceProducer.this.released || this.closed) {
                        image.close();
                    } else {
                        ImageReaderSurfaceProducer.this.onImage(imageReader, image);
                    }
                }
            }

            public boolean canPrune() {
                return this.imageQueue.size() == 0 && ImageReaderSurfaceProducer.this.lastReaderDequeuedFrom != this;
            }

            public void close() {
                this.closed = true;
                this.reader.close();
                this.imageQueue.clear();
            }

            public PerImage dequeueImage() {
                if (this.imageQueue.size() == 0) {
                    return null;
                }
                return this.imageQueue.removeFirst();
            }

            public PerImage queueImage(Image image) {
                if (this.closed) {
                    return null;
                }
                PerImage perImage = new PerImage(image, System.nanoTime());
                this.imageQueue.add(perImage);
                while (this.imageQueue.size() > 2) {
                    this.imageQueue.removeFirst().image.close();
                }
                return perImage;
            }
        }

        public ImageReaderSurfaceProducer(long j) {
            this.id = j;
        }

        private void cleanup() {
            synchronized (this.lock) {
                try {
                    for (PerImageReader next : this.perImageReaders.values()) {
                        if (this.lastReaderDequeuedFrom == next) {
                            this.lastReaderDequeuedFrom = null;
                        }
                        next.close();
                    }
                    this.perImageReaders.clear();
                    PerImage perImage = this.lastDequeuedImage;
                    if (perImage != null) {
                        perImage.image.close();
                        this.lastDequeuedImage = null;
                    }
                    PerImageReader perImageReader = this.lastReaderDequeuedFrom;
                    if (perImageReader != null) {
                        perImageReader.close();
                        this.lastReaderDequeuedFrom = null;
                    }
                    this.imageReaderQueue.clear();
                } finally {
                }
            }
        }

        private ImageReader createImageReader() {
            return Build.VERSION.SDK_INT >= 33 ? createImageReader33() : createImageReader29();
        }

        @TargetApi(29)
        private ImageReader createImageReader29() {
            return ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 5, 256);
        }

        @TargetApi(33)
        private ImageReader createImageReader33() {
            h.a();
            ImageReader.Builder a2 = g.a(this.requestedWidth, this.requestedHeight);
            ImageReader.Builder unused = a2.setMaxImages(5);
            ImageReader.Builder unused2 = a2.setImageFormat(34);
            ImageReader.Builder unused3 = a2.setUsage(256);
            return a2.build();
        }

        private PerImageReader getActiveReader() {
            synchronized (this.lock) {
                try {
                    if (this.createNewReader) {
                        this.createNewReader = false;
                        PerImageReader orCreatePerImageReader = getOrCreatePerImageReader(createImageReader());
                        return orCreatePerImageReader;
                    }
                    PerImageReader peekLast = this.imageReaderQueue.peekLast();
                    return peekLast;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
                return;
            }
            this.ignoringFence = true;
            Log.w(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
        }

        private void releaseInternal() {
            cleanup();
            this.released = true;
        }

        @TargetApi(33)
        private void waitOnFence(Image image) {
            try {
                boolean unused = image.getFence().awaitForever();
            } catch (IOException unused2) {
            }
        }

        @TargetApi(29)
        public Image acquireLatestImage() {
            PerImage dequeueImage = dequeueImage();
            if (dequeueImage == null) {
                return null;
            }
            maybeWaitOnFence(dequeueImage.image);
            return dequeueImage.image;
        }

        public double deltaMillis(long j) {
            return ((double) j) / 1000000.0d;
        }

        public PerImage dequeueImage() {
            PerImage perImage;
            synchronized (this.lock) {
                try {
                    Iterator<PerImageReader> it = this.imageReaderQueue.iterator();
                    perImage = null;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PerImageReader next = it.next();
                        PerImage dequeueImage = next.dequeueImage();
                        if (dequeueImage == null) {
                            perImage = dequeueImage;
                        } else {
                            PerImage perImage2 = this.lastDequeuedImage;
                            if (perImage2 != null) {
                                perImage2.image.close();
                                this.lastDequeuedImage = null;
                            }
                            this.lastDequeuedImage = dequeueImage;
                            this.lastReaderDequeuedFrom = next;
                            perImage = dequeueImage;
                        }
                    }
                    pruneImageReaderQueue();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return perImage;
        }

        @VisibleForTesting
        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        public void finalize() throws Throwable {
            try {
                if (!this.released) {
                    releaseInternal();
                    FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.id, FlutterRenderer.this.flutterJNI));
                    super.finalize();
                }
            } finally {
                super.finalize();
            }
        }

        public int getHeight() {
            return this.requestedHeight;
        }

        public PerImageReader getOrCreatePerImageReader(ImageReader imageReader) {
            PerImageReader perImageReader = this.perImageReaders.get(imageReader);
            if (perImageReader != null) {
                return perImageReader;
            }
            PerImageReader perImageReader2 = new PerImageReader(imageReader);
            this.perImageReaders.put(imageReader, perImageReader2);
            this.imageReaderQueue.add(perImageReader2);
            return perImageReader2;
        }

        public Surface getSurface() {
            return getActiveReader().reader.getSurface();
        }

        public int getWidth() {
            return this.requestedWidth;
        }

        public long id() {
            return this.id;
        }

        @VisibleForTesting
        public int numImageReaders() {
            int size;
            synchronized (this.lock) {
                size = this.imageReaderQueue.size();
            }
            return size;
        }

        @VisibleForTesting
        public int numImages() {
            int i;
            synchronized (this.lock) {
                try {
                    Iterator<PerImageReader> it = this.imageReaderQueue.iterator();
                    i = 0;
                    while (it.hasNext()) {
                        i += it.next().imageQueue.size();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }

        @VisibleForTesting
        public int numTrims() {
            int i;
            synchronized (this.lock) {
                i = this.numTrims;
            }
            return i;
        }

        public void onImage(ImageReader imageReader, Image image) {
            PerImage queueImage;
            synchronized (this.lock) {
                queueImage = getOrCreatePerImageReader(imageReader).queueImage(image);
            }
            if (queueImage != null) {
                FlutterRenderer.this.scheduleEngineFrame();
            }
        }

        public void onTrimMemory(int i) {
            if (this.trimOnMemoryPressure && i >= 40) {
                synchronized (this.lock) {
                    this.numTrims++;
                }
                cleanup();
                this.createNewReader = true;
            }
        }

        public void pruneImageReaderQueue() {
            while (this.imageReaderQueue.size() > 1) {
                PerImageReader peekFirst = this.imageReaderQueue.peekFirst();
                if (peekFirst.canPrune()) {
                    this.imageReaderQueue.removeFirst();
                    this.perImageReaders.remove(peekFirst.reader);
                    peekFirst.close();
                } else {
                    return;
                }
            }
        }

        public void release() {
            if (!this.released) {
                releaseInternal();
                FlutterRenderer.this.unregisterTexture(this.id);
            }
        }

        public void scheduleFrame() {
            FlutterRenderer.this.scheduleEngineFrame();
        }

        public void setSize(int i, int i2) {
            int max = Math.max(1, i);
            int max2 = Math.max(1, i2);
            if (this.requestedWidth != max || this.requestedHeight != max2) {
                this.createNewReader = true;
                this.requestedHeight = max2;
                this.requestedWidth = max;
            }
        }
    }

    @Keep
    public final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";
        private final long id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        public ImageTextureRegistryEntry(long j) {
            this.id = j;
        }

        @TargetApi(29)
        private void maybeWaitOnFence(Image image2) {
            if (image2 == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image2);
                return;
            }
            this.ignoringFence = true;
            Log.w(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
        }

        @TargetApi(33)
        private void waitOnFence(Image image2) {
            try {
                boolean unused = image2.getFence().awaitForever();
            } catch (IOException unused2) {
            }
        }

        @TargetApi(29)
        public Image acquireLatestImage() {
            Image image2;
            synchronized (this) {
                image2 = this.image;
                this.image = null;
            }
            maybeWaitOnFence(image2);
            return image2;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    super.finalize();
                    return;
                }
                Image image2 = this.image;
                if (image2 != null) {
                    image2.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.id, FlutterRenderer.this.flutterJNI));
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
                throw th;
            }
        }

        public long id() {
            return this.id;
        }

        public void pushImage(Image image2) {
            Image image3;
            if (!this.released) {
                synchronized (this) {
                    image3 = this.image;
                    this.image = image2;
                }
                if (image3 != null) {
                    Log.e(TAG, "Dropping PlatformView Frame");
                    image3.close();
                }
                if (image2 != null) {
                    FlutterRenderer.this.scheduleEngineFrame();
                }
            }
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                Image image2 = this.image;
                if (image2 != null) {
                    image2.close();
                    this.image = null;
                }
                FlutterRenderer.this.unregisterTexture(this.id);
            }
        }
    }

    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.OnTrimMemoryListener {
        @Nullable
        private TextureRegistry.OnFrameConsumedListener frameConsumedListener;
        private final long id;
        private boolean released;
        @NonNull
        private final SurfaceTextureWrapper textureWrapper;
        @Nullable
        private TextureRegistry.OnTrimMemoryListener trimMemoryListener;

        public SurfaceTextureRegistryEntry(long j, @NonNull SurfaceTexture surfaceTexture) {
            this.id = j;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture, new b(this));
            surfaceTexture().setOnFrameAvailableListener(new c(this), new Handler());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0() {
            TextureRegistry.OnFrameConsumedListener onFrameConsumedListener = this.frameConsumedListener;
            if (onFrameConsumedListener != null) {
                onFrameConsumedListener.onFrameConsumed();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(SurfaceTexture surfaceTexture) {
            if (!this.released && FlutterRenderer.this.flutterJNI.isAttached()) {
                this.textureWrapper.markDirty();
                FlutterRenderer.this.scheduleEngineFrame();
            }
        }

        private void removeListener() {
            FlutterRenderer.this.removeOnTrimMemoryListener(this);
        }

        public void finalize() throws Throwable {
            try {
                if (!this.released) {
                    FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.id, FlutterRenderer.this.flutterJNI));
                    super.finalize();
                }
            } finally {
                super.finalize();
            }
        }

        public long id() {
            return this.id;
        }

        public void onTrimMemory(int i) {
            TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = this.trimMemoryListener;
            if (onTrimMemoryListener != null) {
                onTrimMemoryListener.onTrimMemory(i);
            }
        }

        public void release() {
            if (!this.released) {
                Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
                this.textureWrapper.release();
                FlutterRenderer.this.unregisterTexture(this.id);
                removeListener();
                this.released = true;
            }
        }

        public void setOnFrameConsumedListener(@Nullable TextureRegistry.OnFrameConsumedListener onFrameConsumedListener) {
            this.frameConsumedListener = onFrameConsumedListener;
        }

        public void setOnTrimMemoryListener(@Nullable TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
            this.trimMemoryListener = onTrimMemoryListener;
        }

        @NonNull
        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        @NonNull
        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }
    }

    public static final class TextureFinalizerRunnable implements Runnable {
        private final FlutterJNI flutterJNI;
        private final long id;

        public TextureFinalizerRunnable(long j, @NonNull FlutterJNI flutterJNI2) {
            this.id = j;
            this.flutterJNI = flutterJNI2;
        }

        public void run() {
            if (this.flutterJNI.isAttached()) {
                Log.v(FlutterRenderer.TAG, "Releasing a Texture (" + this.id + ").");
                this.flutterJNI.unregisterTexture(this.id);
            }
        }
    }

    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public List<DisplayFeature> displayFeatures = new ArrayList();
        public int height = 0;
        public int physicalTouchSlop = -1;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetTop = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int viewInsetRight = 0;
        public int viewInsetTop = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingTop = 0;
        public int width = 0;

        public boolean validate() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    public FlutterRenderer(@NonNull FlutterJNI flutterJNI2) {
        AnonymousClass1 r0 = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = r0;
        this.flutterJNI = flutterJNI2;
        flutterJNI2.addIsDisplayingFlutterUiListener(r0);
    }

    private void clearDeadListeners() {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            if (((TextureRegistry.OnTrimMemoryListener) it.next().get()) == null) {
                it.remove();
            }
        }
    }

    private void markTextureFrameAvailable(long j) {
        this.flutterJNI.markTextureFrameAvailable(j);
    }

    private void registerImageTexture(long j, @NonNull TextureRegistry.ImageConsumer imageConsumer) {
        this.flutterJNI.registerImageTexture(j, imageConsumer);
    }

    private void registerTexture(long j, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        this.flutterJNI.registerTexture(j, surfaceTextureWrapper);
    }

    /* access modifiers changed from: private */
    public void scheduleEngineFrame() {
        this.flutterJNI.scheduleFrame();
    }

    /* access modifiers changed from: private */
    public void unregisterTexture(long j) {
        this.flutterJNI.unregisterTexture(j);
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener2);
        if (this.isDisplayingFlutterUi) {
            flutterUiDisplayListener2.onFlutterUiDisplayed();
        }
    }

    @VisibleForTesting
    public void addOnTrimMemoryListener(@NonNull TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
        clearDeadListeners();
        this.onTrimMemoryListeners.add(new WeakReference(onTrimMemoryListener));
    }

    @NonNull
    public TextureRegistry.ImageTextureEntry createImageTexture() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.nextTextureId.getAndIncrement());
        Log.v(TAG, "New ImageTextureEntry ID: " + imageTextureRegistryEntry.id());
        registerImageTexture(imageTextureRegistryEntry.id(), imageTextureRegistryEntry);
        return imageTextureRegistryEntry;
    }

    @NonNull
    public TextureRegistry.SurfaceProducer createSurfaceProducer() {
        if (!debugForceSurfaceProducerGlTextures) {
            long andIncrement = this.nextTextureId.getAndIncrement();
            ImageReaderSurfaceProducer imageReaderSurfaceProducer = new ImageReaderSurfaceProducer(andIncrement);
            registerImageTexture(andIncrement, imageReaderSurfaceProducer);
            addOnTrimMemoryListener(imageReaderSurfaceProducer);
            Log.v(TAG, "New ImageReaderSurfaceProducer ID: " + andIncrement);
            return imageReaderSurfaceProducer;
        }
        TextureRegistry.SurfaceTextureEntry createSurfaceTexture = createSurfaceTexture();
        SurfaceTextureSurfaceProducer surfaceTextureSurfaceProducer = new SurfaceTextureSurfaceProducer(createSurfaceTexture.id(), this.handler, this.flutterJNI, createSurfaceTexture);
        Log.v(TAG, "New SurfaceTextureSurfaceProducer ID: " + createSurfaceTexture.id());
        return surfaceTextureSurfaceProducer;
    }

    @NonNull
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i) {
        this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i);
    }

    public void dispatchSemanticsAction(int i, int i2, @Nullable ByteBuffer byteBuffer, int i3) {
        this.flutterJNI.dispatchSemanticsAction(i, i2, byteBuffer, i3);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.getIsSoftwareRenderingEnabled();
    }

    public void onTrimMemory(int i) {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = (TextureRegistry.OnTrimMemoryListener) it.next().get();
            if (onTrimMemoryListener != null) {
                onTrimMemoryListener.onTrimMemory(i);
            } else {
                it.remove();
            }
        }
    }

    @NonNull
    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture) {
        return registerSurfaceTexture(this.nextTextureId.getAndIncrement(), surfaceTexture);
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener2);
    }

    @VisibleForTesting
    public void removeOnTrimMemoryListener(@NonNull TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
        for (WeakReference next : this.onTrimMemoryListeners) {
            if (next.get() == onTrimMemoryListener) {
                this.onTrimMemoryListeners.remove(next);
                return;
            }
        }
    }

    public void setAccessibilityFeatures(int i) {
        this.flutterJNI.setAccessibilityFeatures(i);
    }

    public void setSemanticsEnabled(boolean z) {
        this.flutterJNI.setSemanticsEnabled(z);
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        ViewportMetrics viewportMetrics2 = viewportMetrics;
        if (viewportMetrics.validate()) {
            Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics2.width + " x " + viewportMetrics2.height + "\nPadding - L: " + viewportMetrics2.viewPaddingLeft + ", T: " + viewportMetrics2.viewPaddingTop + ", R: " + viewportMetrics2.viewPaddingRight + ", B: " + viewportMetrics2.viewPaddingBottom + "\nInsets - L: " + viewportMetrics2.viewInsetLeft + ", T: " + viewportMetrics2.viewInsetTop + ", R: " + viewportMetrics2.viewInsetRight + ", B: " + viewportMetrics2.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics2.systemGestureInsetLeft + ", T: " + viewportMetrics2.systemGestureInsetTop + ", R: " + viewportMetrics2.systemGestureInsetRight + ", B: " + viewportMetrics2.systemGestureInsetRight + "\nDisplay Features: " + viewportMetrics2.displayFeatures.size());
            int[] iArr = new int[(viewportMetrics2.displayFeatures.size() * 4)];
            int[] iArr2 = new int[viewportMetrics2.displayFeatures.size()];
            int[] iArr3 = new int[viewportMetrics2.displayFeatures.size()];
            for (int i = 0; i < viewportMetrics2.displayFeatures.size(); i++) {
                DisplayFeature displayFeature = viewportMetrics2.displayFeatures.get(i);
                int i2 = i * 4;
                Rect rect = displayFeature.bounds;
                iArr[i2] = rect.left;
                iArr[i2 + 1] = rect.top;
                iArr[i2 + 2] = rect.right;
                iArr[i2 + 3] = rect.bottom;
                iArr2[i] = displayFeature.type.encodedValue;
                iArr3[i] = displayFeature.state.encodedValue;
            }
            int[] iArr4 = iArr3;
            FlutterJNI flutterJNI2 = this.flutterJNI;
            flutterJNI2.setViewportMetrics(viewportMetrics2.devicePixelRatio, viewportMetrics2.width, viewportMetrics2.height, viewportMetrics2.viewPaddingTop, viewportMetrics2.viewPaddingRight, viewportMetrics2.viewPaddingBottom, viewportMetrics2.viewPaddingLeft, viewportMetrics2.viewInsetTop, viewportMetrics2.viewInsetRight, viewportMetrics2.viewInsetBottom, viewportMetrics2.viewInsetLeft, viewportMetrics2.systemGestureInsetTop, viewportMetrics2.systemGestureInsetRight, viewportMetrics2.systemGestureInsetBottom, viewportMetrics2.systemGestureInsetLeft, viewportMetrics2.physicalTouchSlop, iArr, iArr2, iArr4);
        }
    }

    public void startRenderingToSurface(@NonNull Surface surface2, boolean z) {
        if (!z) {
            stopRenderingToSurface();
        }
        this.surface = surface2;
        if (z) {
            this.flutterJNI.onSurfaceWindowChanged(surface2);
        } else {
            this.flutterJNI.onSurfaceCreated(surface2);
        }
    }

    public void stopRenderingToSurface() {
        if (this.surface != null) {
            this.flutterJNI.onSurfaceDestroyed();
            if (this.isDisplayingFlutterUi) {
                this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
            }
            this.isDisplayingFlutterUi = false;
            this.surface = null;
        }
    }

    public void surfaceChanged(int i, int i2) {
        this.flutterJNI.onSurfaceChanged(i, i2);
    }

    public void swapSurface(@NonNull Surface surface2) {
        this.surface = surface2;
        this.flutterJNI.onSurfaceWindowChanged(surface2);
    }

    @NonNull
    private TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(long j, @NonNull SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(j, surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.id());
        registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
        addOnTrimMemoryListener(surfaceTextureRegistryEntry);
        return surfaceTextureRegistryEntry;
    }

    public static final class DisplayFeature {
        public final Rect bounds;
        public final DisplayFeatureState state;
        public final DisplayFeatureType type;

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType, DisplayFeatureState displayFeatureState) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = displayFeatureState;
        }

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = DisplayFeatureState.UNKNOWN;
        }
    }
}
