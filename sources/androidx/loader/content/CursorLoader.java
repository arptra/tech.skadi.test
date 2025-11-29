package androidx.loader.content;

import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
    public final Loader.ForceLoadContentObserver p;
    public Uri q;
    public String[] r;
    public String s;
    public String[] t;
    public String u;
    public Cursor v;
    public CancellationSignal w;

    /* renamed from: H */
    public void f(Cursor cursor) {
        if (!k()) {
            Cursor cursor2 = this.v;
            this.v = cursor;
            if (l()) {
                super.f(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    /* renamed from: I */
    public Cursor E() {
        Cursor b;
        synchronized (this) {
            if (!D()) {
                this.w = new CancellationSignal();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            b = ContentResolverCompat.b(i().getContentResolver(), this.q, this.r, this.s, this.t, this.u, this.w);
            if (b != null) {
                b.getCount();
                b.registerContentObserver(this.p);
            }
            synchronized (this) {
                this.w = null;
            }
            return b;
        } catch (RuntimeException e) {
            b.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
                this.w = null;
                throw th;
            }
        }
    }

    /* renamed from: J */
    public void F(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.r));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.t));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.v);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.h);
    }

    public void q() {
        super.q();
        s();
        Cursor cursor = this.v;
        if (cursor != null && !cursor.isClosed()) {
            this.v.close();
        }
        this.v = null;
    }

    public void r() {
        Cursor cursor = this.v;
        if (cursor != null) {
            f(cursor);
        }
        if (x() || this.v == null) {
            h();
        }
    }

    public void s() {
        b();
    }

    public void z() {
        super.z();
        synchronized (this) {
            try {
                CancellationSignal cancellationSignal = this.w;
                if (cancellationSignal != null) {
                    cancellationSignal.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
