package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.luck.picture.lib.R;

public class RemindDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f9415a;
    public final TextView b;
    public OnDialogClickListener c;

    public interface OnDialogClickListener {
        void onClick(View view);
    }

    public RemindDialog(Context context, String str) {
        super(context, R.style.Picture_Theme_Dialog);
        setContentView(R.layout.ps_remind_dialog);
        TextView textView = (TextView) findViewById(R.id.btnOk);
        this.f9415a = textView;
        TextView textView2 = (TextView) findViewById(R.id.tv_content);
        this.b = textView2;
        textView2.setText(str);
        textView.setOnClickListener(this);
        b();
    }

    public static RemindDialog a(Context context, String str) {
        return new RemindDialog(context, str);
    }

    public final void b() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        getWindow().setWindowAnimations(R.style.PictureThemeDialogWindowStyle);
        getWindow().setAttributes(attributes);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnOk) {
            OnDialogClickListener onDialogClickListener = this.c;
            if (onDialogClickListener != null) {
                onDialogClickListener.onClick(view);
            } else {
                dismiss();
            }
        }
    }
}
