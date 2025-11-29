package androidx.browser.browseractions;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Deprecated
@RestrictTo
public final class BrowserServiceFileProvider extends FileProvider {
    public static Object b = new Object();

    public static class FileCleanupTask extends AsyncTask<Void, Void, Void> {
        public static final long b;
        public static final long c;
        public static final long d;

        /* renamed from: a  reason: collision with root package name */
        public final Context f403a;

        static {
            TimeUnit timeUnit = TimeUnit.DAYS;
            b = timeUnit.toMillis(7);
            c = timeUnit.toMillis(7);
            d = timeUnit.toMillis(1);
        }

        public FileCleanupTask(Context context) {
            this.f403a = context.getApplicationContext();
        }

        public static boolean b(File file) {
            return file.getName().endsWith("..png");
        }

        public static boolean c(SharedPreferences sharedPreferences) {
            return System.currentTimeMillis() > sharedPreferences.getLong("last_cleanup_time", System.currentTimeMillis()) + c;
        }

        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            SharedPreferences sharedPreferences = this.f403a.getSharedPreferences(this.f403a.getPackageName() + ".image_provider", 0);
            if (!c(sharedPreferences)) {
                return null;
            }
            synchronized (BrowserServiceFileProvider.b) {
                try {
                    File file = new File(this.f403a.getFilesDir(), "image_provider");
                    if (!file.exists()) {
                        return null;
                    }
                    File[] listFiles = file.listFiles();
                    long currentTimeMillis = System.currentTimeMillis() - b;
                    boolean z = true;
                    for (File file2 : listFiles) {
                        if (b(file2)) {
                            if (file2.lastModified() < currentTimeMillis && !file2.delete()) {
                                Log.e("BrowserServiceFP", "Fail to delete image: " + file2.getAbsoluteFile());
                                z = false;
                            }
                        }
                    }
                    long currentTimeMillis2 = z ? System.currentTimeMillis() : (System.currentTimeMillis() - c) + d;
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong("last_cleanup_time", currentTimeMillis2);
                    edit.apply();
                    return null;
                } finally {
                }
            }
        }
    }

    public static class FileSaveTask extends AsyncTask<String, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final Context f404a;
        public final String b;
        public final Bitmap c;
        public final Uri d;
        public final ResolvableFuture e;

        /* renamed from: a */
        public Void doInBackground(String... strArr) {
            d();
            return null;
        }

        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            new FileCleanupTask(this.f404a).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }

        public final void c(File file) {
            FileOutputStream fileOutputStream;
            AtomicFile atomicFile = new AtomicFile(file);
            try {
                fileOutputStream = atomicFile.d();
                try {
                    this.c.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.close();
                    atomicFile.b(fileOutputStream);
                    this.e.o(this.d);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
                atomicFile.a(fileOutputStream);
                this.e.p(e);
            }
        }

        public final void d() {
            File file = new File(this.f404a.getFilesDir(), "image_provider");
            synchronized (BrowserServiceFileProvider.b) {
                try {
                    if (file.exists() || file.mkdir()) {
                        File file2 = new File(file, this.b + ".png");
                        if (file2.exists()) {
                            this.e.o(this.d);
                        } else {
                            c(file2);
                        }
                        file2.setLastModified(System.currentTimeMillis());
                        return;
                    }
                    this.e.p(new IOException("Could not create file directory."));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static ListenableFuture i(final ContentResolver contentResolver, final Uri uri) {
        final ResolvableFuture r = ResolvableFuture.r();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                    if (openFileDescriptor == null) {
                        r.p(new FileNotFoundException());
                        return;
                    }
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                    if (decodeFileDescriptor == null) {
                        r.p(new IOException("File could not be decoded."));
                    } else {
                        r.o(decodeFileDescriptor);
                    }
                } catch (IOException e) {
                    r.p(e);
                }
            }
        });
        return r;
    }
}
