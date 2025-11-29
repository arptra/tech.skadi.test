package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    public int[] m;
    public int[] n;
    public int o;
    public CursorToStringConverter p;
    public ViewBinder q;
    public String[] r;

    public interface CursorToStringConverter {
        CharSequence convertToString(Cursor cursor);
    }

    public interface ViewBinder {
        boolean a(View view, Cursor cursor, int i);
    }

    public void a(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.q;
        int[] iArr = this.n;
        int length = iArr.length;
        int[] iArr2 = this.m;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                if (viewBinder != null ? viewBinder.a(findViewById, cursor, iArr2[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        i((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        h((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        CursorToStringConverter cursorToStringConverter = this.p;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i = this.o;
        return i > -1 ? cursor.getString(i) : super.convertToString(cursor);
    }

    public Cursor f(Cursor cursor) {
        g(cursor, this.r);
        return super.f(cursor);
    }

    public final void g(Cursor cursor, String[] strArr) {
        if (cursor != null) {
            int length = strArr.length;
            int[] iArr = this.m;
            if (iArr == null || iArr.length != length) {
                this.m = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.m[i] = cursor.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.m = null;
    }

    public void h(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void i(TextView textView, String str) {
        textView.setText(str);
    }
}
