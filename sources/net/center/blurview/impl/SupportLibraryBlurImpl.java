package net.center.blurview.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class SupportLibraryBlurImpl implements BlurImpl {
    public static Boolean e;

    /* renamed from: a  reason: collision with root package name */
    public RenderScript f4129a;
    public ScriptIntrinsicBlur b;
    public Allocation c;
    public Allocation d;

    public static boolean c(Context context) {
        if (e == null && context != null) {
            e = Boolean.valueOf((context.getApplicationInfo().flags & 2) != 0);
        }
        return e.equals(Boolean.TRUE);
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.c.copyFrom(bitmap);
        this.b.setInput(this.c);
        this.b.forEach(this.d);
        this.d.copyTo(bitmap2);
    }

    public boolean b(Context context, Bitmap bitmap, float f) {
        if (this.f4129a == null) {
            try {
                RenderScript create = RenderScript.create(context);
                this.f4129a = create;
                this.b = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            } catch (RSRuntimeException e2) {
                if (!c(context)) {
                    release();
                    return false;
                }
                throw e2;
            }
        }
        this.b.setRadius(f);
        Allocation createFromBitmap = Allocation.createFromBitmap(this.f4129a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.c = createFromBitmap;
        this.d = Allocation.createTyped(this.f4129a, createFromBitmap.getType());
        return true;
    }

    public void release() {
        Allocation allocation = this.c;
        if (allocation != null) {
            allocation.destroy();
            this.c = null;
        }
        Allocation allocation2 = this.d;
        if (allocation2 != null) {
            allocation2.destroy();
            this.d = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
            this.b = null;
        }
        RenderScript renderScript = this.f4129a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f4129a = null;
        }
    }
}
