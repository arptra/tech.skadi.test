package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.luck.picture.lib.R;

public class PictureCommonDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public OnDialogEventListener f9414a;

    public interface OnDialogEventListener {
        void a();
    }

    public PictureCommonDialog(Context context, String str, String str2) {
        super(context, R.style.Picture_Theme_Dialog);
        setContentView(R.layout.ps_common_dialog);
        ((TextView) findViewById(R.id.tvTitle)).setText(str);
        ((TextView) findViewById(R.id.tv_content)).setText(str2);
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_commit)).setOnClickListener(this);
        a();
    }

    public static PictureCommonDialog c(Context context, String str, String str2) {
        PictureCommonDialog pictureCommonDialog = new PictureCommonDialog(context, str, str2);
        pictureCommonDialog.show();
        return pictureCommonDialog;
    }

    public final void a() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        getWindow().setWindowAnimations(R.style.PictureThemeDialogWindowStyle);
        getWindow().setAttributes(attributes);
    }

    public void b(OnDialogEventListener onDialogEventListener) {
        this.f9414a = onDialogEventListener;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_cancel) {
            dismiss();
        } else if (id == R.id.btn_commit) {
            dismiss();
            OnDialogEventListener onDialogEventListener = this.f9414a;
            if (onDialogEventListener != null) {
                onDialogEventListener.a();
            }
        }
    }
}
