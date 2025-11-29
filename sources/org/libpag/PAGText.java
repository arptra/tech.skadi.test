package org.libpag;

import android.graphics.RectF;

public class PAGText {
    public boolean applyFill = true;
    public boolean applyStroke = false;
    public int backgroundAlpha;
    public int backgroundColor;
    public float baselineShift = 0.0f;
    public boolean boxText = false;
    public RectF boxTextRect = new RectF();
    public boolean fauxBold = false;
    public boolean fauxItalic = false;
    public int fillColor = 0;
    public float firstBaseLine = 0.0f;
    public String fontFamily = "";
    public float fontSize = 24.0f;
    public String fontStyle = "";
    public int justification = 0;
    public float leading = 0.0f;
    public int strokeColor = 0;
    public boolean strokeOverFill = true;
    public float strokeWidth = 1.0f;
    public String text = "";
    public float tracking = 0.0f;

    public static class Justification {
        public static final int Center = 1;
        public static final int FullJustifyLastLineCenter = 5;
        public static final int FullJustifyLastLineFull = 6;
        public static final int FullJustifyLastLineLeft = 3;
        public static final int FullJustifyLastLineRight = 4;
        public static final int Left = 0;
        public static final int Right = 2;
    }
}
