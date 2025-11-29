package com.upuphone.xr.sapp.vu;

import android.util.Log;
import android.widget.EditText;
import com.upuphone.xr.sapp.vu.arspace.OnInputTextListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\n\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000e\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/upuphone/xr/sapp/vu/ArSpaceStarterActivity$setupEditText$2$1", "Lcom/upuphone/xr/sapp/vu/arspace/OnInputTextListener;", "", "id", "text", "", "onTextChange", "(Ljava/lang/String;Ljava/lang/String;)V", "", "selectionStart", "selectionEnd", "onSelectionChange", "(Ljava/lang/String;II)V", "action", "onAction", "(Ljava/lang/String;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceStarterActivity$setupEditText$2$1 implements OnInputTextListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f8021a;

    public void onAction(String str, int i) {
        Log.d("ArSpaceStarterActivity", "onAction: " + i);
    }

    public void onSelectionChange(String str, int i, int i2) {
        Log.d("ArSpaceStarterActivity", "onSelectionChange: " + i + ", " + i2);
    }

    public void onTextChange(String str, String str2) {
        EditText editText = this.f8021a;
        if (str2 == null) {
            str2 = "";
        }
        editText.setText(str2);
    }
}
