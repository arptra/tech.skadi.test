package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.view.TextureView;
import java.util.ArrayList;
import java.util.Iterator;
import org.extra.tools.d;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;

public class PAGView extends TextureView implements TextureView.SurfaceTextureListener, d, PAGAnimator.Listener {

    /* renamed from: a  reason: collision with root package name */
    private TextureView.SurfaceTextureListener f3423a;
    private PAGPlayer b;
    private PAGSurface c;
    private PAGAnimator d;
    private String e = "";
    private boolean f = false;
    private EGLContext g = null;
    private ArrayList h = new ArrayList();
    /* access modifiers changed from: private */
    public ArrayList i = new ArrayList();
    private boolean j = false;

    @Deprecated
    public interface PAGFlushListener {
        void onFlush();
    }

    public interface PAGViewListener {
        void onAnimationCancel(PAGView pAGView);

        void onAnimationEnd(PAGView pAGView);

        void onAnimationRepeat(PAGView pAGView);

        void onAnimationStart(PAGView pAGView);

        void onAnimationUpdate(PAGView pAGView);
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            boolean isOpaque = PAGView.this.isOpaque();
            PAGView.this.setOpaque(!isOpaque);
            PAGView.this.setOpaque(isOpaque);
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SurfaceTexture f3425a;

        public b(SurfaceTexture surfaceTexture) {
            this.f3425a = surfaceTexture;
        }

        public void run() {
            this.f3425a.release();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ArrayList arrayList;
            synchronized (PAGView.this) {
                arrayList = new ArrayList(PAGView.this.i);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGFlushListener) it.next()).onFlush();
            }
        }
    }

    public PAGView(Context context) {
        super(context);
        b();
    }

    private void b() {
        org.extra.tools.b.a().b(this);
        setOpaque(false);
        this.b = new PAGPlayer();
        setSurfaceTextureListener(this);
        this.d = PAGAnimator.a(getContext(), this);
    }

    private void c() {
        post(new a());
    }

    public void addListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.h.add(pAGViewListener);
        }
    }

    @Deprecated
    public void addPAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.i.add(pAGFlushListener);
        }
    }

    public boolean cacheEnabled() {
        return this.b.cacheEnabled();
    }

    public float cacheScale() {
        return this.b.cacheScale();
    }

    public long currentFrame() {
        return this.b.currentFrame();
    }

    public long duration() {
        return this.b.duration();
    }

    public boolean flush() {
        return this.b.flush();
    }

    public void freeCache() {
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
    }

    public RectF getBounds(PAGLayer pAGLayer) {
        return pAGLayer != null ? this.b.getBounds(pAGLayer) : new RectF();
    }

    public PAGComposition getComposition() {
        return this.b.getComposition();
    }

    public PAGLayer[] getLayersUnderPoint(float f2, float f3) {
        return this.b.getLayersUnderPoint(f2, f3);
    }

    public String getPath() {
        return this.e;
    }

    public double getProgress() {
        return this.b.getProgress();
    }

    public boolean isPlaying() {
        return this.d.isRunning();
    }

    public boolean isSync() {
        return this.d.isSync();
    }

    public Bitmap makeSnapshot() {
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            return pAGSurface.makeSnapshot();
        }
        return null;
    }

    public Matrix matrix() {
        return this.b.matrix();
    }

    public float maxFrameRate() {
        return this.b.maxFrameRate();
    }

    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationCancel(this);
        }
    }

    public void onAnimationEnd(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationEnd(this);
        }
    }

    public void onAnimationRepeat(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationRepeat(this);
        }
    }

    public void onAnimationStart(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationStart(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r3.j == false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
        r4.setDuration(r3.b.duration());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        if (flush() == false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r4 = new java.util.ArrayList(r3.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        r4 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r4.hasNext() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        ((org.libpag.PAGView.PAGViewListener) r4.next()).onAnimationUpdate(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        if (r3.i.isEmpty() != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        post(new org.libpag.PAGView.c(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAnimationUpdate(org.libpag.PAGAnimator r4) {
        /*
            r3 = this;
            org.libpag.PAGPlayer r0 = r3.b
            double r1 = r4.progress()
            r0.setProgress(r1)
            monitor-enter(r3)
            boolean r0 = r3.f     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x0012
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            return
        L_0x0010:
            r4 = move-exception
            goto L_0x005a
        L_0x0012:
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            boolean r0 = r3.j
            if (r0 == 0) goto L_0x0020
            org.libpag.PAGPlayer r0 = r3.b
            long r0 = r0.duration()
            r4.setDuration(r0)
        L_0x0020:
            boolean r4 = r3.flush()
            if (r4 == 0) goto L_0x0029
            r3.c()
        L_0x0029:
            monitor-enter(r3)
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0057 }
            java.util.ArrayList r0 = r3.h     // Catch:{ all -> 0x0057 }
            r4.<init>(r0)     // Catch:{ all -> 0x0057 }
            monitor-exit(r3)     // Catch:{ all -> 0x0057 }
            java.util.Iterator r4 = r4.iterator()
        L_0x0036:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r4.next()
            org.libpag.PAGView$PAGViewListener r0 = (org.libpag.PAGView.PAGViewListener) r0
            r0.onAnimationUpdate(r3)
            goto L_0x0036
        L_0x0046:
            java.util.ArrayList r4 = r3.i
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0056
            org.libpag.PAGView$c r4 = new org.libpag.PAGView$c
            r4.<init>()
            r3.post(r4)
        L_0x0056:
            return
        L_0x0057:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0057 }
            throw r4
        L_0x005a:
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.PAGView.onAnimationUpdate(org.libpag.PAGAnimator):void");
    }

    public void onAttachedToWindow() {
        this.f = true;
        super.onAttachedToWindow();
        a();
    }

    public void onDetachedFromWindow() {
        this.f = false;
        super.onDetachedFromWindow();
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.c = null;
        }
        a();
    }

    public void onResume() {
        if (this.j) {
            setVisibility(4);
            setVisibility(0);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.c = null;
        }
        PAGSurface FromSurfaceTexture = PAGSurface.FromSurfaceTexture(surfaceTexture, this.g);
        this.c = FromSurfaceTexture;
        this.b.setSurface(FromSurfaceTexture);
        PAGSurface pAGSurface2 = this.c;
        if (pAGSurface2 != null) {
            pAGSurface2.clearAll();
            this.d.update();
            TextureView.SurfaceTextureListener surfaceTextureListener = this.f3423a;
            if (surfaceTextureListener != null) {
                surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.b.setSurface((PAGSurface) null);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f3423a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        post(new b(surfaceTexture));
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            pAGSurface.updateSize();
            this.c.clearAll();
            this.d.update();
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f3423a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f3423a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        a();
    }

    public void pause() {
        this.d.cancel();
    }

    public void play() {
        this.b.prepare();
        this.d.a();
    }

    public void removeListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.h.remove(pAGViewListener);
        }
    }

    @Deprecated
    public void removePAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.i.remove(pAGFlushListener);
        }
    }

    public int repeatCount() {
        return this.d.repeatCount();
    }

    public int scaleMode() {
        return this.b.scaleMode();
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setCacheEnabled(boolean z) {
        this.b.setCacheEnabled(z);
    }

    public void setCacheScale(float f2) {
        this.b.setCacheScale(f2);
    }

    public void setComposition(PAGComposition pAGComposition) {
        this.e = null;
        this.b.setComposition(pAGComposition);
        this.d.setProgress(this.b.getProgress());
        if (this.j) {
            this.d.setDuration(this.b.duration());
        }
    }

    public void setMatrix(Matrix matrix) {
        this.b.setMatrix(matrix);
    }

    public void setMaxFrameRate(float f2) {
        this.b.setMaxFrameRate(f2);
    }

    public boolean setPath(String str) {
        PAGFile Load = (str == null || !str.startsWith("assets://")) ? PAGFile.Load(str) : PAGFile.Load(getContext().getAssets(), str.substring(9));
        setComposition(Load);
        this.e = str;
        return Load != null;
    }

    public void setPathAsync(String str, PAGFile.LoadListener loadListener) {
        NativeTask.Run(new com.honey.account.pc.c(this, str, loadListener));
    }

    public void setProgress(double d2) {
        this.b.setProgress(d2);
        this.d.setProgress(this.b.getProgress());
        this.d.update();
    }

    public void setRepeatCount(int i2) {
        this.d.setRepeatCount(i2);
    }

    public void setScaleMode(int i2) {
        this.b.setScaleMode(i2);
    }

    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (surfaceTextureListener == this) {
            super.setSurfaceTextureListener(surfaceTextureListener);
        } else {
            this.f3423a = surfaceTextureListener;
        }
    }

    public void setSync(boolean z) {
        this.d.setSync(z);
    }

    public void setUseDiskCache(boolean z) {
        this.b.setUseDiskCache(z);
    }

    public void setVideoEnabled(boolean z) {
        this.b.setVideoEnabled(z);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        a();
    }

    public void stop() {
        this.d.cancel();
    }

    public boolean useDiskCache() {
        return this.b.useDiskCache();
    }

    public boolean videoEnabled() {
        return this.b.videoEnabled();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, PAGFile.LoadListener loadListener) {
        setPath(str);
        if (loadListener != null) {
            loadListener.onLoad((PAGFile) this.b.getComposition());
        }
    }

    private void a() {
        boolean z = this.f && isShown();
        if (this.j != z) {
            this.j = z;
            if (z) {
                this.d.setDuration(this.b.duration());
                this.d.update();
                return;
            }
            this.d.setDuration(0);
        }
    }

    public PAGView(Context context, EGLContext eGLContext) {
        super(context);
        this.g = eGLContext;
        b();
    }

    public PAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public PAGView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
