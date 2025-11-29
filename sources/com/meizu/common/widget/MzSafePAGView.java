package com.meizu.common.widget;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.util.Log;
import org.libpag.PAGView;

public class MzSafePAGView extends PAGView {
    public MzSafePAGView(Context context) {
        super(context);
    }

    public boolean flush() {
        try {
            return super.flush();
        } catch (Exception e) {
            Log.w("MzSafePAGView", "flush has an error:" + e);
            return false;
        }
    }

    public MzSafePAGView(Context context, EGLContext eGLContext) {
        super(context, eGLContext);
    }

    public MzSafePAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MzSafePAGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
