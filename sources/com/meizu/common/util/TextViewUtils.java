package com.meizu.common.util;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class TextViewUtils {
    private static final AdaptiveCallback DEFAULT_CALLBACK = new AdaptiveCallback() {
        public void measure(TextView textView, int i, int i2) {
            textView.measure(i, i2);
        }

        public void setTextSize(TextView textView, int i, float f) {
            textView.setTextSize(i, f);
        }
    };

    public interface AdaptiveCallback {
        void measure(TextView textView, int i, int i2);

        void setTextSize(TextView textView, int i, float f);
    }

    public static void adaptiveTextSizeIfNeed(@NonNull TextView textView, int i) {
        adaptiveTextSizeIfNeed(textView, i, DEFAULT_CALLBACK);
    }

    private static int getLineCount(@NonNull TextView textView, int i, @NonNull AdaptiveCallback adaptiveCallback) {
        int lineCount;
        adaptiveCallback.measure(textView, View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Layout layout = textView.getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0) {
            return lineCount;
        }
        throw new IllegalStateException();
    }

    public static void adaptiveTextSizeIfNeed(@NonNull TextView textView, int i, @NonNull AdaptiveCallback adaptiveCallback) {
        float textSize = textView.getTextSize();
        int maxLines = textView.getMaxLines();
        if (maxLines > 0) {
            textView.setMaxLines(Integer.MAX_VALUE);
            float f = textSize;
            while (f > 1.0f) {
                try {
                    adaptiveCallback.setTextSize(textView, 0, f);
                    if (getLineCount(textView, i, adaptiveCallback) <= maxLines) {
                        textView.setMaxLines(maxLines);
                        return;
                    }
                    f -= 1.0f;
                } catch (Exception unused) {
                }
            }
            adaptiveCallback.setTextSize(textView, 0, textSize);
            textView.setMaxLines(maxLines);
        }
    }
}
