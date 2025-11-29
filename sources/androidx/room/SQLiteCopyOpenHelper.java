package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u0015J\u001f\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010 J\u0017\u0010#\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010%R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010&R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010'R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010(R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010\u000e\u001a\u00020\u00018\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001d\u0010/R\u0016\u00102\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u0004\u0018\u00010\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00108\u001a\u0002068VX\u0004¢\u0006\u0006\u001a\u0004\b*\u00107R\u0014\u0010:\u001a\u0002068VX\u0004¢\u0006\u0006\u001a\u0004\b9\u00107¨\u0006;"}, d2 = {"Landroidx/room/SQLiteCopyOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "Landroid/content/Context;", "context", "", "copyFromAssetPath", "Ljava/io/File;", "copyFromFile", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "copyFromInputStream", "", "databaseVersion", "delegate", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILandroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "", "enabled", "", "setWriteAheadLoggingEnabled", "(Z)V", "close", "()V", "Landroidx/room/DatabaseConfiguration;", "databaseConfiguration", "d", "(Landroidx/room/DatabaseConfiguration;)V", "writable", "g", "destinationFile", "a", "(Ljava/io/File;Z)V", "databaseFile", "c", "b", "(Ljava/io/File;)Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroid/content/Context;", "Ljava/lang/String;", "Ljava/io/File;", "Ljava/util/concurrent/Callable;", "e", "I", "f", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DatabaseConfiguration;", "h", "Z", "verified", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "l0", "readableDatabase", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1760a;
    public final String b;
    public final File c;
    public final Callable d;
    public final int e;
    public final SupportSQLiteOpenHelper f;
    public DatabaseConfiguration g;
    public boolean h;

    public SQLiteCopyOpenHelper(Context context, String str, File file, Callable callable, int i, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "delegate");
        this.f1760a = context;
        this.b = str;
        this.c = file;
        this.d = callable;
        this.e = i;
        this.f = supportSQLiteOpenHelper;
    }

    public SupportSQLiteDatabase I() {
        if (!this.h) {
            g(true);
            this.h = true;
        }
        return getDelegate().I();
    }

    public final void a(File file, boolean z) {
        ReadableByteChannel readableByteChannel;
        if (this.b != null) {
            readableByteChannel = Channels.newChannel(this.f1760a.getAssets().open(this.b));
            Intrinsics.checkNotNullExpressionValue(readableByteChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.c != null) {
            readableByteChannel = new FileInputStream(this.c).getChannel();
            Intrinsics.checkNotNullExpressionValue(readableByteChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable callable = this.d;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel((InputStream) callable.call());
                    Intrinsics.checkNotNullExpressionValue(readableByteChannel, "newChannel(inputStream)");
                } catch (Exception e2) {
                    throw new IOException("inputStreamCallable exception on call", e2);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", DiskFileUpload.postfix, this.f1760a.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "output");
        FileUtil.a(readableByteChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            Intrinsics.checkNotNullExpressionValue(createTempFile, "intermediateFile");
            c(createTempFile, z);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    public final SupportSQLiteOpenHelper b(File file) {
        try {
            int d2 = DBUtil.d(file);
            return new FrameworkSQLiteOpenHelperFactory().a(SupportSQLiteOpenHelper.Configuration.f.a(this.f1760a).d(file.getAbsolutePath()).c(new SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(d2, RangesKt.coerceAtLeast(d2, 1))).b());
        } catch (IOException e2) {
            throw new RuntimeException("Malformed database file, unable to read version.", e2);
        }
    }

    public final void c(File file, boolean z) {
        SupportSQLiteDatabase supportSQLiteDatabase;
        DatabaseConfiguration databaseConfiguration = this.g;
        if (databaseConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
            databaseConfiguration = null;
        }
        if (databaseConfiguration.q != null) {
            SupportSQLiteOpenHelper b2 = b(file);
            if (z) {
                try {
                    supportSQLiteDatabase = b2.I();
                } catch (Throwable th) {
                    CloseableKt.closeFinally(b2, th);
                    throw th;
                }
            } else {
                supportSQLiteDatabase = b2.l0();
            }
            DatabaseConfiguration databaseConfiguration2 = this.g;
            if (databaseConfiguration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                databaseConfiguration2 = null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration2.q;
            Intrinsics.checkNotNull(prepackagedDatabaseCallback);
            prepackagedDatabaseCallback.a(supportSQLiteDatabase);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(b2, (Throwable) null);
        }
    }

    public synchronized void close() {
        getDelegate().close();
        this.h = false;
    }

    public final void d(DatabaseConfiguration databaseConfiguration) {
        Intrinsics.checkNotNullParameter(databaseConfiguration, "databaseConfiguration");
        this.g = databaseConfiguration;
    }

    public final void g(boolean z) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.f1760a.getDatabasePath(databaseName);
            DatabaseConfiguration databaseConfiguration = this.g;
            DatabaseConfiguration databaseConfiguration2 = null;
            if (databaseConfiguration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                databaseConfiguration = null;
            }
            ProcessLock processLock = new ProcessLock(databaseName, this.f1760a.getFilesDir(), databaseConfiguration.t);
            try {
                ProcessLock.c(processLock, false, 1, (Object) null);
                if (!databasePath.exists()) {
                    Intrinsics.checkNotNullExpressionValue(databasePath, "databaseFile");
                    a(databasePath, z);
                    processLock.d();
                    return;
                }
                try {
                    Intrinsics.checkNotNullExpressionValue(databasePath, "databaseFile");
                    int d2 = DBUtil.d(databasePath);
                    if (d2 == this.e) {
                        processLock.d();
                        return;
                    }
                    DatabaseConfiguration databaseConfiguration3 = this.g;
                    if (databaseConfiguration3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                    } else {
                        databaseConfiguration2 = databaseConfiguration3;
                    }
                    if (databaseConfiguration2.a(d2, this.e)) {
                        processLock.d();
                        return;
                    }
                    if (this.f1760a.deleteDatabase(databaseName)) {
                        try {
                            a(databasePath, z);
                        } catch (IOException e2) {
                            Log.w("ROOM", "Unable to copy database file.", e2);
                        }
                    } else {
                        Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                    }
                    processLock.d();
                } catch (IOException e3) {
                    Log.w("ROOM", "Unable to read database version.", e3);
                    processLock.d();
                }
            } catch (IOException e4) {
                throw new RuntimeException("Unable to copy database file.", e4);
            } catch (Throwable th) {
                processLock.d();
                throw th;
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.f;
    }

    public SupportSQLiteDatabase l0() {
        if (!this.h) {
            g(false);
            this.h = true;
        }
        return getDelegate().l0();
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        getDelegate().setWriteAheadLoggingEnabled(z);
    }
}
