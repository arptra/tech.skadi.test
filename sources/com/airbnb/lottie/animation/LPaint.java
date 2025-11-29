package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;
import io.netty.handler.codec.http2.Http2CodecUtil;

public class LPaint extends Paint {
    public LPaint() {
    }

    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 30) {
            setColor((MiscUtils.clamp(i, 0, 255) << 24) | (getColor() & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND));
            return;
        }
        super.setAlpha(MiscUtils.clamp(i, 0, 255));
    }

    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public LPaint(int i) {
        super(i);
    }

    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
