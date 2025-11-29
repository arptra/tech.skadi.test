package com.meizu.common.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import com.meizu.common.R;
import com.meizu.common.util.ResourceUtils;

public class CompleteToast extends Toast {
    public CompleteToast(Context context, String str) {
        super(context);
        init(context, str, (Drawable) null);
    }

    private void init(Context context, CharSequence charSequence, Drawable drawable) {
        View inflate = LayoutInflater.from(ResourceUtils.makeFlymeDefalutThemeContext(context)).inflate(R.layout.mc_toast_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.toast_text);
        Drawable b = AppCompatResources.b(context, R.drawable.mz_complete_toast_bg);
        if (b != null) {
            b.setTint(context.getColor(R.color.fd_sys_color_surface_container_lowest_default));
        }
        inflate.setBackground(b);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_complete);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        setView(inflate);
        setGravity(17, 0, 0);
        textView.setText(charSequence);
    }

    public static CompleteToast makeText(Context context, String str, int i) {
        CompleteToast completeToast = new CompleteToast(context, str);
        completeToast.setDuration(i);
        return completeToast;
    }

    public CompleteToast(Context context, String str, Drawable drawable) {
        super(context);
        init(context, str, drawable);
    }

    public static CompleteToast makeText(Context context, int i, int i2) {
        CompleteToast completeToast = new CompleteToast(context, i);
        completeToast.setDuration(i2);
        return completeToast;
    }

    public CompleteToast(Context context, int i) {
        super(context);
        init(context, context.getResources().getText(i), (Drawable) null);
    }

    public static CompleteToast makeText(Context context, String str, Drawable drawable, int i) {
        CompleteToast completeToast = new CompleteToast(context, str, drawable);
        completeToast.setDuration(i);
        return completeToast;
    }
}
