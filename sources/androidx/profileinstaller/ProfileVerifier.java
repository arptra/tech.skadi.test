package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import com.here.posclient.PositionEstimate;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class ProfileVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final ResolvableFuture f1712a = ResolvableFuture.r();
    public static final Object b = new Object();
    public static CompilationStatus c = null;

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    @RestrictTo
    public static class Cache {

        /* renamed from: a  reason: collision with root package name */
        public final int f1713a;
        public final int b;
        public final long c;
        public final long d;

        public Cache(int i, int i2, long j, long j2) {
            this.f1713a = i;
            this.b = i2;
            this.c = j;
            this.d = j2;
        }

        public static Cache a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f1713a);
                dataOutputStream.writeInt(this.b);
                dataOutputStream.writeLong(this.c);
                dataOutputStream.writeLong(this.d);
                dataOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Cache)) {
                return false;
            }
            Cache cache = (Cache) obj;
            return this.b == cache.b && this.c == cache.c && this.f1713a == cache.f1713a && this.d == cache.d;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.f1713a), Long.valueOf(this.d)});
        }
    }

    public static class CompilationStatus {

        /* renamed from: a  reason: collision with root package name */
        public final int f1714a;
        public final boolean b;
        public final boolean c;

        @RestrictTo
        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        public CompilationStatus(int i, boolean z, boolean z2) {
            this.f1714a = i;
            this.c = z2;
            this.b = z;
        }
    }

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static CompilationStatus b(int i, boolean z, boolean z2) {
        CompilationStatus compilationStatus = new CompilationStatus(i, z, z2);
        c = compilationStatus;
        f1712a.o(compilationStatus);
        return c;
    }

    public static CompilationStatus c(Context context, boolean z) {
        boolean z2;
        boolean z3;
        Cache cache;
        CompilationStatus compilationStatus;
        if (!z && (compilationStatus = c) != null) {
            return compilationStatus;
        }
        synchronized (b) {
            if (!z) {
                try {
                    CompilationStatus compilationStatus2 = c;
                    if (compilationStatus2 != null) {
                        return compilationStatus2;
                    }
                } catch (IOException unused) {
                    return b(131072, z2, z3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i = 0;
            if (Build.VERSION.SDK_INT == 30) {
                CompilationStatus b2 = b(PositionEstimate.Value.BUILDING_NAME, false, false);
                return b2;
            }
            File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
            long length = file.length();
            z2 = file.exists() && length > 0;
            File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
            long length2 = file2.length();
            z3 = file2.exists() && length2 > 0;
            try {
                long a2 = a(context);
                File file3 = new File(context.getFilesDir(), "profileInstalled");
                Cache a3 = file3.exists() ? Cache.a(file3) : null;
                if (a3 != null && a3.c == a2) {
                    int i2 = a3.b;
                    if (i2 != 2) {
                        i = i2;
                        if (z && z3 && i != 1) {
                            i = 2;
                        }
                        if (a3 != null && a3.b == 2 && i == 1 && length < a3.d) {
                            i = 3;
                        }
                        cache = new Cache(1, i, a2, length2);
                        if (a3 == null || !a3.equals(cache)) {
                            cache.b(file3);
                        }
                        CompilationStatus b3 = b(i, z2, z3);
                        return b3;
                    }
                }
                if (z2) {
                    i = 1;
                } else if (z3) {
                    i = 2;
                }
                i = 2;
                i = 3;
                cache = new Cache(1, i, a2, length2);
                try {
                    cache.b(file3);
                } catch (IOException unused2) {
                    i = 196608;
                }
                CompilationStatus b32 = b(i, z2, z3);
                return b32;
            } catch (PackageManager.NameNotFoundException unused3) {
                return b(65536, z2, z3);
            }
        }
    }
}
