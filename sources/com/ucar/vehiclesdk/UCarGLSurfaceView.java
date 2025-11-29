package com.ucar.vehiclesdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.easy.logger.EasyLog;
import com.honey.account.h3.x;
import com.honey.account.h3.y;
import com.honey.account.h3.z;
import com.ucar.vehiclesdk.SurfaceProvider;
import com.ucar.vehiclesdk.UCarCommon;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class UCarGLSurfaceView extends GLSurfaceView implements ISurfaceEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final VideoRenderer f5393a;
    public final int b;
    public final List c;
    public final Object d;

    public interface ICaptureSurfaceCallback {
        void a(Bitmap bitmap);
    }

    public static class TextureRender {
        public static final float[] v = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        public static final float[] w = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

        /* renamed from: a  reason: collision with root package name */
        public final FloatBuffer f5396a;
        public final FloatBuffer b;
        public final float[] c;
        public final float[] d;
        public final Object e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public UCarCommon.VisibleRegion p;
        public boolean q;
        public float r;
        public int s;
        public int t;
        public ICaptureSurfaceCallback u;

        public static void e(String str) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                EasyLog.c("TextureRender", str + ": glError " + glGetError);
                throw new RuntimeException(str + ": glError " + glGetError);
            }
        }

        public static int j(int i2, String str) {
            int glCreateShader = GLES20.glCreateShader(i2);
            e("glCreateShader type=" + i2);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 0) {
                return glCreateShader;
            }
            EasyLog.c("TextureRender", "Could not compile shader " + i2 + ": \n" + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }

        public final Bitmap f(GL10 gl10, int i2, int i3, float f2) {
            if (i2 <= 0 || i3 <= 9) {
                return null;
            }
            float f3 = (float) i2;
            float f4 = f3 * f2;
            int i4 = (int) f4;
            float f5 = (float) i3;
            float f6 = f2 * f5;
            int i5 = (int) f6;
            int i6 = (int) ((f3 - f4) / 2.0f);
            int i7 = (int) ((f5 - f6) / 2.0f);
            int i8 = i4 * i5;
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            try {
                gl10.glReadPixels(i6, i7, i4, i5, 6408, 5121, wrap);
                for (int i9 = 0; i9 < i5; i9++) {
                    int i10 = i9 * i4;
                    int i11 = ((i5 - i9) - 1) * i4;
                    for (int i12 = 0; i12 < i4; i12++) {
                        int i13 = iArr[i10 + i12];
                        iArr2[i11 + i12] = (i13 & -16711936) | ((i13 << 16) & 16711680) | ((i13 >> 16) & 255);
                    }
                }
                return Bitmap.createBitmap(iArr2, i4, i5, Bitmap.Config.ARGB_8888);
            } catch (Exception unused) {
                return null;
            }
        }

        public final int g() {
            int j2 = j(35633, "attribute vec4 a_Position;\nattribute vec4 a_TexCoordinate;\nvarying vec2 v_TexCoord;\nuniform mat4 u_MvpMatrix;\nuniform mat4 u_STMatrix;\nvoid main()\n{\n    v_TexCoord = (u_STMatrix * a_TexCoordinate).xy;\n    gl_Position = u_MvpMatrix * a_Position;\n}");
            this.f = j2;
            if (j2 == 0) {
                return 0;
            }
            int j3 = j(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_Texture;\nvarying vec2 v_TexCoord;\nvoid main()\n{\n    gl_FragColor = texture2D(u_Texture, v_TexCoord);\n}");
            this.g = j3;
            if (j3 == 0) {
                return 0;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            e("glCreateProgram");
            if (glCreateProgram == 0) {
                EasyLog.c("TextureRender", "Could not create program");
                return glCreateProgram;
            }
            GLES20.glAttachShader(glCreateProgram, this.f);
            e("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, this.g);
            e("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 1) {
                return glCreateProgram;
            }
            EasyLog.c("TextureRender", "Could not link program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
            m();
            return 0;
        }

        public void h(GL10 gl10, SurfaceTexture surfaceTexture) {
            boolean z;
            ICaptureSurfaceCallback iCaptureSurfaceCallback;
            int i2;
            int i3;
            int i4;
            UCarCommon.VisibleRegion visibleRegion;
            float f2;
            float f3;
            float f4;
            synchronized (this.e) {
                z = this.q;
                iCaptureSurfaceCallback = this.u;
                i2 = this.o;
                i3 = this.s;
                i4 = this.t;
                visibleRegion = this.p;
                f2 = this.r;
            }
            Matrix.setIdentityM(this.d, 0);
            surfaceTexture.getTransformMatrix(this.d);
            GLES20.glUseProgram(this.h);
            this.f5396a.position(0);
            GLES20.glEnableVertexAttribArray(this.j);
            GLES20.glVertexAttribPointer(this.j, 3, 5126, false, 0, this.f5396a);
            this.b.position(0);
            GLES20.glEnableVertexAttribArray(this.k);
            GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 0, this.b);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, this.i);
            GLES20.glUniform1i(this.l, 0);
            GLES20.glUniformMatrix4fv(this.n, 1, false, this.d, 0);
            Matrix.setIdentityM(this.c, 0);
            if (visibleRegion != null && visibleRegion.d()) {
                if (i2 == -90 || i2 == -270) {
                    float f5 = ((float) i3) * 1.0f;
                    float c2 = f5 / ((float) visibleRegion.c());
                    float f6 = ((float) i4) * 1.0f;
                    float h2 = f6 / ((float) visibleRegion.h());
                    float f7 = (f5 / ((float) visibleRegion.f)) / c2;
                    f3 = (f6 / ((float) visibleRegion.e)) / h2;
                    f4 = f7;
                } else {
                    float f8 = ((float) i3) * 1.0f;
                    float h3 = f8 / ((float) visibleRegion.h());
                    float f9 = ((float) i4) * 1.0f;
                    float c3 = f9 / ((float) visibleRegion.c());
                    f4 = (f8 / ((float) visibleRegion.e)) / h3;
                    f3 = (f9 / ((float) visibleRegion.f)) / c3;
                }
                Matrix.scaleM(this.c, 0, 1.0f / f4, 1.0f / f3, -1.0f);
                if (!(visibleRegion.g() == visibleRegion.a() && visibleRegion.e() == visibleRegion.f())) {
                    if (i2 == 0) {
                        Matrix.translateM(this.c, 0, (((float) (visibleRegion.e() - visibleRegion.f())) * 1.0f) / ((float) visibleRegion.e), (((float) (visibleRegion.g() - visibleRegion.a())) * 1.0f) / ((float) visibleRegion.f), -1.0f);
                    } else if (i2 == -90) {
                        Matrix.translateM(this.c, 0, (((float) (visibleRegion.a() - visibleRegion.g())) * 1.0f) / ((float) visibleRegion.f), (((float) (visibleRegion.f() - visibleRegion.e())) * 1.0f) / ((float) visibleRegion.e), -1.0f);
                    } else if (i2 == -180) {
                        Matrix.translateM(this.c, 0, (((float) (visibleRegion.f() - visibleRegion.e())) * 1.0f) / ((float) visibleRegion.e), (((float) (visibleRegion.a() - visibleRegion.g())) * 1.0f) / ((float) visibleRegion.f), -1.0f);
                    } else {
                        Matrix.translateM(this.c, 0, (((float) (visibleRegion.g() - visibleRegion.a())) * 1.0f) / ((float) visibleRegion.f), (((float) (visibleRegion.e() - visibleRegion.f())) * 1.0f) / ((float) visibleRegion.e), -1.0f);
                    }
                }
            }
            if (i2 != 0) {
                Matrix.rotateM(this.c, 0, (float) i2, 0.0f, 0.0f, -1.0f);
            }
            if (z) {
                Matrix.scaleM(this.c, 0, f2, f2, -1.0f);
            }
            GLES20.glUniformMatrix4fv(this.m, 1, false, this.c, 0);
            GLES20.glDrawArrays(5, 0, 4);
            if (z) {
                if (iCaptureSurfaceCallback != null) {
                    iCaptureSurfaceCallback.a(f(gl10, i3, i4, f2));
                }
                if (f2 < 1.0f) {
                    GLES20.glUniformMatrix4fv(this.n, 1, false, this.d, 0);
                    float f10 = 1.0f / f2;
                    Matrix.scaleM(this.c, 0, f10, f10, -1.0f);
                    GLES20.glUniformMatrix4fv(this.m, 1, false, this.c, 0);
                    GLES20.glDrawArrays(5, 0, 4);
                }
                this.q = false;
            }
        }

        public final int i() {
            return this.i;
        }

        public final void k() {
            EasyLog.a("TextureRender", "onSurfaceCreated");
            int g2 = g();
            this.h = g2;
            if (g2 != 0) {
                this.j = GLES20.glGetAttribLocation(g2, "a_Position");
                e("glGetAttribLocation a_Position");
                if (this.j != -1) {
                    this.k = GLES20.glGetAttribLocation(this.h, "a_TexCoordinate");
                    e("glGetAttribLocation a_TexCoordinate");
                    if (this.k != -1) {
                        this.l = GLES20.glGetUniformLocation(this.h, "u_Texture");
                        e("glGetUniformLocation u_Texture");
                        if (this.l != -1) {
                            this.m = GLES20.glGetUniformLocation(this.h, "u_MvpMatrix");
                            e("glGetUniformLocation u_MvpMatrix");
                            if (this.m != -1) {
                                this.n = GLES20.glGetUniformLocation(this.h, "u_STMatrix");
                                e("glGetUniformLocation u_STMatrix");
                                if (this.n != -1) {
                                    int[] iArr = new int[1];
                                    GLES20.glGenTextures(1, iArr, 0);
                                    int i2 = iArr[0];
                                    this.i = i2;
                                    GLES20.glBindTexture(36197, i2);
                                    e("glBindTexture mTextureID");
                                    GLES20.glTexParameterf(36197, 10241, 9729.0f);
                                    GLES20.glTexParameterf(36197, 10240, 9729.0f);
                                    GLES20.glTexParameteri(36197, 10242, 33071);
                                    GLES20.glTexParameteri(36197, 10243, 33071);
                                    e("glTexParameter");
                                    return;
                                }
                                throw new RuntimeException("Could not get attrib location for u_STMatrix");
                            }
                            throw new RuntimeException("Could not get attrib location for u_MvpMatrix");
                        }
                        throw new RuntimeException("Could not get attrib location for u_Texture");
                    }
                    throw new RuntimeException("Could not get attrib location for a_TexCoordinate");
                }
                throw new RuntimeException("Could not get attrib location for a_Position");
            }
            throw new RuntimeException("failed creating program");
        }

        public final void l(int i2, int i3) {
            synchronized (this.e) {
                this.s = i2;
                this.t = i3;
            }
        }

        public final void m() {
            GLES20.glDeleteShader(this.f);
            GLES20.glDeleteShader(this.g);
            GLES20.glDeleteProgram(this.h);
        }

        public final void n(int i2, UCarCommon.VisibleRegion visibleRegion) {
            synchronized (this.e) {
                try {
                    this.o = i2;
                    if (visibleRegion != null) {
                        this.p = visibleRegion.b();
                    } else {
                        this.p = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public TextureRender() {
            this.c = new float[16];
            this.d = new float[16];
            this.e = new Object();
            this.i = -1;
            this.o = 0;
            float[] fArr = v;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f5396a = asFloatBuffer;
            asFloatBuffer.put(fArr).position(0);
            float[] fArr2 = w;
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.b = asFloatBuffer2;
            asFloatBuffer2.put(fArr2).position(0);
        }
    }

    public static class VideoRenderer extends SurfaceProvider implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: a  reason: collision with root package name */
        public final Object f5397a;
        public final TextureRender b;
        public UCarGLSurfaceView c;
        public SurfaceTexture d;
        public Surface e;

        public VideoRenderer() {
            this.f5397a = new Object();
            this.b = new TextureRender();
        }

        public void b(int i, UCarCommon.VisibleRegion visibleRegion) {
            EasyLog.a("VideoRenderer", "updateDisplayMode, rotation: " + i + ", visibleRegion: " + visibleRegion);
            if (i == 0) {
                this.b.n(0, visibleRegion);
            } else if (i == 1) {
                this.b.n(-90, visibleRegion);
            } else if (i == 2) {
                this.b.n(-180, visibleRegion);
            } else {
                this.b.n(-270, visibleRegion);
            }
        }

        public void c() {
            EasyLog.a("VideoRenderer", "onSurfaceDestroyed");
            synchronized (this.f5397a) {
                try {
                    UCarGLSurfaceView uCarGLSurfaceView = this.c;
                    if (uCarGLSurfaceView != null) {
                        uCarGLSurfaceView.p();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            SurfaceTexture surfaceTexture = this.d;
            if (surfaceTexture != null) {
                try {
                    surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                    this.d.release();
                } catch (Exception e2) {
                    EasyLog.d("VideoRenderer", "video texture release failed", e2);
                }
                this.d = null;
            }
            Surface surface = this.e;
            if (surface != null) {
                try {
                    surface.release();
                } catch (Exception e3) {
                    EasyLog.d("VideoRenderer", "video surface release failed", e3);
                }
                this.e = null;
            }
        }

        public final void d(UCarGLSurfaceView uCarGLSurfaceView) {
            synchronized (this.f5397a) {
                this.c = uCarGLSurfaceView;
            }
        }

        public void onDrawFrame(GL10 gl10) {
            this.d.updateTexImage();
            this.b.h(gl10, this.d);
        }

        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this.f5397a) {
                try {
                    UCarGLSurfaceView uCarGLSurfaceView = this.c;
                    if (uCarGLSurfaceView != null) {
                        uCarGLSurfaceView.requestRender();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            EasyLog.e("VideoRenderer", "onSurfaceChanged, width:" + i + ",height:" + i2);
            gl10.glViewport(0, 0, i, i2);
            this.b.l(i, i2);
            synchronized (this.f5397a) {
                try {
                    UCarGLSurfaceView uCarGLSurfaceView = this.c;
                    if (uCarGLSurfaceView != null) {
                        uCarGLSurfaceView.n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            EasyLog.a("VideoRenderer", "onSurfaceCreated");
            try {
                this.b.k();
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.b.i());
                this.d = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this);
                this.e = new Surface(this.d);
                synchronized (this.f5397a) {
                    UCarGLSurfaceView uCarGLSurfaceView = this.c;
                    if (uCarGLSurfaceView != null) {
                        uCarGLSurfaceView.o();
                    }
                }
            } catch (RuntimeException e2) {
                EasyLog.f("VideoRenderer", "onSurfaceCreated failed", e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public UCarGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static String j(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return "0x" + Integer.toHexString(i);
        }
    }

    public void a(int i, UCarCommon.VisibleRegion visibleRegion) {
        this.f5393a.b(i, visibleRegion);
    }

    public SurfaceProvider getSurfaceProvider() {
        return this.f5393a;
    }

    public final /* synthetic */ void k(SurfaceProvider.Callback callback) {
        callback.a(this.f5393a, getWidth(), getHeight());
    }

    public final /* synthetic */ void l(SurfaceProvider.Callback callback) {
        callback.c(this.f5393a);
    }

    public final /* synthetic */ void m(SurfaceProvider.Callback callback) {
        callback.b(this.f5393a);
    }

    public final void n() {
        EasyLog.a("UCarGLSurfaceView", "notifySurfaceChanged");
        synchronized (this.d) {
            this.c.forEach(new z(this));
        }
    }

    public final void o() {
        EasyLog.a("UCarGLSurfaceView", "notifySurfaceCreated");
        synchronized (this.d) {
            this.c.forEach(new x(this));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        EasyLog.a("UCarGLSurfaceView", "onAttachedToWindow");
        this.f5393a.d(this);
        UCarAdapter.R0().a2(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UCarAdapter.R0().B2(this);
        this.f5393a.d((UCarGLSurfaceView) null);
        EasyLog.a("UCarGLSurfaceView", "onDetachedFromWindow");
    }

    public void onPause() {
        super.onPause();
        EasyLog.a("UCarGLSurfaceView", "onPause");
    }

    public void onResume() {
        super.onResume();
        EasyLog.a("UCarGLSurfaceView", "onResume");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        EasyLog.a("UCarGLSurfaceView", "onTouchEvent, action:" + motionEvent.getAction());
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        int[] iArr2 = new int[pointerCount];
        int[] iArr3 = new int[pointerCount];
        for (int i = 0; i < pointerCount; i++) {
            iArr[i] = motionEvent.getPointerId(i);
            iArr2[i] = (int) motionEvent.getX(i);
            iArr3[i] = (int) motionEvent.getY(i);
        }
        UCarAdapter.R0().n2(action, pointerCount, iArr, iArr2, iArr3);
        return true;
    }

    public final void p() {
        EasyLog.a("UCarGLSurfaceView", "notifySurfaceDestroyed");
        synchronized (this.d) {
            this.c.forEach(new y(this));
        }
    }

    public UCarGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 2;
        this.c = new ArrayList();
        this.d = new Object();
        setEGLContextClientVersion(2);
        VideoRenderer videoRenderer = new VideoRenderer();
        this.f5393a = videoRenderer;
        videoRenderer.d(this);
        setEGLContextFactory(new GLSurfaceView.EGLContextFactory() {
            public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            }

            public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
                UCarGLSurfaceView.this.f5393a.c();
                if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                    EasyLog.d("EGLContextFactory", "display: " + eGLDisplay + " context: " + eGLContext, new RuntimeException("eglDestroyContext failed: " + UCarGLSurfaceView.j(egl10.eglGetError())));
                }
            }
        });
        setRenderer(videoRenderer);
        setRenderMode(0);
        getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                EasyLog.e("UCarGLSurfaceView", "surfaceChanged, format: " + i + ", width: " + i2 + ", height: " + i3);
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                EasyLog.e("UCarGLSurfaceView", "surfaceCreated");
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                EasyLog.e("UCarGLSurfaceView", "surfaceDestroyed");
            }
        });
    }
}
