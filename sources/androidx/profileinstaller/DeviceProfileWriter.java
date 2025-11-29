package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.profileinstaller.ProfileInstaller;
import com.honey.account.b0.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

@RequiresApi
@RestrictTo
public class DeviceProfileWriter {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f1707a;
    public final Executor b;
    public final ProfileInstaller.DiagnosticsCallback c;
    public final byte[] d;
    public final File e;
    public final String f;
    public final String g;
    public final String h;
    public boolean i = false;
    public DexProfileData[] j;
    public byte[] k;

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, String str2, String str3, File file) {
        this.f1707a = assetManager;
        this.b = executor;
        this.c = diagnosticsCallback;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.e = file;
        this.d = d();
    }

    public static byte[] d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 34) {
            return null;
        }
        switch (i2) {
            case 29:
            case 30:
                return ProfileVersion.b;
            case 31:
            case 32:
            case 33:
            case 34:
                return ProfileVersion.f1715a;
            default:
                return null;
        }
    }

    public static boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 34) {
            return false;
        }
        switch (i2) {
            case 31:
            case 32:
            case 33:
            case 34:
                return true;
            default:
                return false;
        }
    }

    public final DeviceProfileWriter b(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        InputStream h2;
        try {
            h2 = h(this.f1707a, this.h);
            if (h2 != null) {
                this.j = ProfileTranscoder.q(h2, ProfileTranscoder.o(h2, ProfileTranscoder.b), bArr, dexProfileDataArr);
                h2.close();
                return this;
            }
            if (h2 != null) {
                h2.close();
            }
            return null;
        } catch (FileNotFoundException e2) {
            this.c.a(9, e2);
        } catch (IOException e3) {
            this.c.a(7, e3);
        } catch (IllegalStateException e4) {
            this.j = null;
            this.c.a(8, e4);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public final void c() {
        if (!this.i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.e.exists()) {
            try {
                this.e.createNewFile();
            } catch (IOException unused) {
                l(4, (Object) null);
                return false;
            }
        } else if (!this.e.canWrite()) {
            l(4, (Object) null);
            return false;
        }
        this.i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.g);
        } catch (FileNotFoundException e2) {
            this.c.a(6, e2);
            return null;
        } catch (IOException e3) {
            this.c.a(7, e3);
            return null;
        }
    }

    public final /* synthetic */ void g(int i2, Object obj) {
        this.c.a(i2, obj);
    }

    public final InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e2) {
            String message = e2.getMessage();
            if (message != null && message.contains("compressed")) {
                this.c.b(5, (Object) null);
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r0 = b(r0, r2.d);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.profileinstaller.DeviceProfileWriter i() {
        /*
            r2 = this;
            r2.c()
            byte[] r0 = r2.d
            if (r0 != 0) goto L_0x0008
            return r2
        L_0x0008:
            android.content.res.AssetManager r0 = r2.f1707a
            java.io.InputStream r0 = r2.f(r0)
            if (r0 == 0) goto L_0x0016
            androidx.profileinstaller.DexProfileData[] r0 = r2.j(r0)
            r2.j = r0
        L_0x0016:
            androidx.profileinstaller.DexProfileData[] r0 = r2.j
            if (r0 == 0) goto L_0x0029
            boolean r1 = k()
            if (r1 == 0) goto L_0x0029
            byte[] r1 = r2.d
            androidx.profileinstaller.DeviceProfileWriter r0 = r2.b(r0, r1)
            if (r0 == 0) goto L_0x0029
            return r0
        L_0x0029:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.DeviceProfileWriter.i():androidx.profileinstaller.DeviceProfileWriter");
    }

    public final DexProfileData[] j(InputStream inputStream) {
        try {
            DexProfileData[] w = ProfileTranscoder.w(inputStream, ProfileTranscoder.o(inputStream, ProfileTranscoder.f1711a), this.f);
            try {
                inputStream.close();
                return w;
            } catch (IOException e2) {
                this.c.a(7, e2);
                return w;
            }
        } catch (IOException e3) {
            this.c.a(7, e3);
            inputStream.close();
            return null;
        } catch (IllegalStateException e4) {
            this.c.a(8, e4);
            try {
                inputStream.close();
            } catch (IOException e5) {
                this.c.a(7, e5);
            }
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                this.c.a(7, e6);
            }
            throw th;
        }
    }

    public final void l(int i2, Object obj) {
        this.b.execute(new a(this, i2, obj));
    }

    public DeviceProfileWriter m() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.j;
        byte[] bArr = this.d;
        if (!(dexProfileDataArr == null || bArr == null)) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                ProfileTranscoder.E(byteArrayOutputStream, bArr);
                if (!ProfileTranscoder.B(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                    this.c.a(5, (Object) null);
                    this.j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.j = null;
            } catch (IOException e2) {
                this.c.a(7, e2);
            } catch (IllegalStateException e3) {
                this.c.a(8, e3);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return this;
        throw th;
    }

    public boolean n() {
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr = this.k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            fileOutputStream = new FileOutputStream(this.e);
            Encoding.l(byteArrayInputStream, fileOutputStream);
            l(1, (Object) null);
            fileOutputStream.close();
            byteArrayInputStream.close();
            this.k = null;
            this.j = null;
            return true;
        } catch (FileNotFoundException e2) {
            l(6, e2);
            this.k = null;
            this.j = null;
            return false;
        } catch (IOException e3) {
            l(7, e3);
            this.k = null;
            this.j = null;
            return false;
        } catch (Throwable th) {
            this.k = null;
            this.j = null;
            throw th;
        }
        throw th;
        throw th;
    }
}
