package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;
import org.apache.commons.lang3.StringUtils;

@RestrictTo
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    public static CharSequence b(Context context, ClipData.Item item, int i) {
        if ((i & 1) == 0) {
            return item.coerceToStyledText(context);
        }
        CharSequence coerceToText = item.coerceToText(context);
        return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
    }

    public static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    public ContentInfoCompat a(View view, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + contentInfoCompat);
        }
        if (contentInfoCompat.e() == 2) {
            return contentInfoCompat;
        }
        ClipData c = contentInfoCompat.c();
        int d = contentInfoCompat.d();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z = false;
        for (int i = 0; i < c.getItemCount(); i++) {
            CharSequence b = b(context, c.getItemAt(i), d);
            if (b != null) {
                if (!z) {
                    c(editable, b);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), StringUtils.LF);
                    editable.insert(Selection.getSelectionEnd(editable), b);
                }
            }
        }
        return null;
    }
}
