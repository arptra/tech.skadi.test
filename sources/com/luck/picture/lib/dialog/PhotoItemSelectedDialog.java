package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.luck.picture.lib.R;
import com.luck.picture.lib.interfaces.OnItemClickListener;
import com.luck.picture.lib.utils.DensityUtil;

public class PhotoItemSelectedDialog extends DialogFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9413a = true;
    public OnItemClickListener b;
    public OnDismissListener c;

    public interface OnDismissListener {
        void a(boolean z, DialogInterface dialogInterface);
    }

    public static PhotoItemSelectedDialog j0() {
        return new PhotoItemSelectedDialog();
    }

    public final void i0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(DensityUtil.e(getContext()), -2);
            window.setGravity(80);
            window.setWindowAnimations(R.style.PictureThemeDialogFragmentAnim);
        }
    }

    public void k0(OnDismissListener onDismissListener) {
        this.c = onDismissListener;
    }

    public void l0(OnItemClickListener onItemClickListener) {
        this.b = onItemClickListener;
    }

    public void onClick(View view) {
        int id = view.getId();
        OnItemClickListener onItemClickListener = this.b;
        if (onItemClickListener != null) {
            if (id == R.id.ps_tv_photo) {
                onItemClickListener.a(view, 0);
                this.f9413a = false;
            } else if (id == R.id.ps_tv_video) {
                onItemClickListener.a(view, 1);
                this.f9413a = false;
            }
        }
        dismissAllowingStateLoss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setBackgroundDrawableResource(17170445);
            }
        }
        return layoutInflater.inflate(R.layout.ps_dialog_camera_selected, viewGroup);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OnDismissListener onDismissListener = this.c;
        if (onDismissListener != null) {
            onDismissListener.a(this.f9413a, dialogInterface);
        }
    }

    public void onStart() {
        super.onStart();
        i0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.ps_tv_video)).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.ps_tv_photo)).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.ps_tv_cancel)).setOnClickListener(this);
    }

    public void show(FragmentManager fragmentManager, String str) {
        FragmentTransaction s = fragmentManager.s();
        s.e(this, str);
        s.k();
    }
}
