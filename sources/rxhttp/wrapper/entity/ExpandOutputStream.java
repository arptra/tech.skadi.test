package rxhttp.wrapper.entity;

import android.content.Context;
import android.net.Uri;
import com.geetest.sdk.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class ExpandOutputStream<T> extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3552a;
    public final OutputStream b;

    public ExpandOutputStream(Object obj, OutputStream outputStream) {
        this.f3552a = obj;
        this.b = outputStream;
    }

    public static ExpandOutputStream b(Context context, Uri uri, boolean z) {
        return new ExpandOutputStream(uri, context.getContentResolver().openOutputStream(uri, z ? "wa" : w.f));
    }

    public static ExpandOutputStream c(File file, boolean z) {
        return new ExpandOutputStream(file.getAbsolutePath(), new FileOutputStream(file, z));
    }

    public Object a() {
        return this.f3552a;
    }

    public void close() {
        this.b.close();
    }

    public void flush() {
        this.b.flush();
    }

    public void write(int i) {
        this.b.write(i);
    }

    public void write(byte[] bArr) {
        this.b.write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.b.write(bArr, i, i2);
    }
}
