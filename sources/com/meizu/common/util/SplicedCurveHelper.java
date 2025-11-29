package com.meizu.common.util;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.ArrayList;

public class SplicedCurveHelper {
    private static final int CORNER_RADIU = 100;
    private Path mLenPath;
    private Paint mPaint;
    private int mPeakY;
    private ArrayList<CurveSection> mSections = new ArrayList<>();
    private int mValleyY;

    public static class CurveSection {
        public int mColor;
        public Point[] mPoints;

        public CurveSection(Point[] pointArr, int i) {
            this.mPoints = pointArr;
            this.mColor = i;
        }

        public int getColor() {
            return this.mColor;
        }

        public Point[] getPoints() {
            return this.mPoints;
        }

        public void setColor(int i) {
            this.mColor = i;
        }

        public void setPoints(Point[] pointArr) {
            this.mPoints = pointArr;
        }
    }

    public SplicedCurveHelper() {
        init();
    }

    private void addSection2Path(CurveSection curveSection) {
        if (curveSection != null && curveSection.mPoints.length != 0) {
            int i = 0;
            while (true) {
                Point[] pointArr = curveSection.mPoints;
                if (i < pointArr.length) {
                    Path path = this.mLenPath;
                    Point point = pointArr[i];
                    path.lineTo((float) point.x, (float) point.y);
                    int i2 = curveSection.mPoints[i].y;
                    if (i2 > this.mPeakY) {
                        this.mPeakY = i2;
                    }
                    if (i2 < this.mValleyY) {
                        this.mValleyY = i2;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void drawSplitPath(Canvas canvas, Point point, Point point2, int i) {
        canvas.save();
        int i2 = point.x;
        int i3 = point2.x;
        if (i2 >= i3) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        canvas.clipRect(new Rect(i2, this.mValleyY, i3, this.mPeakY));
        this.mPaint.setColor(i);
        canvas.drawPath(this.mLenPath, this.mPaint);
        canvas.restore();
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-65536);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(14.0f);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setPathEffect(new CornerPathEffect(100.0f));
    }

    private void setOriginPath() {
        ArrayList<CurveSection> arrayList = this.mSections;
        if (arrayList != null && arrayList.size() != 0) {
            if (this.mLenPath == null) {
                this.mLenPath = new Path();
            }
            this.mLenPath.reset();
            for (int i = 0; i < this.mSections.size(); i++) {
                CurveSection curveSection = this.mSections.get(i);
                if (curveSection != null) {
                    int i2 = 0;
                    while (true) {
                        Point[] pointArr = curveSection.mPoints;
                        if (i2 >= pointArr.length) {
                            break;
                        }
                        if (i == 0 && i2 == 0) {
                            Path path = this.mLenPath;
                            Point point = pointArr[i2];
                            path.moveTo((float) point.x, (float) point.y);
                        } else {
                            Path path2 = this.mLenPath;
                            Point point2 = pointArr[i2];
                            path2.lineTo((float) point2.x, (float) point2.y);
                        }
                        int i3 = curveSection.mPoints[i2].y;
                        if (i3 > this.mPeakY) {
                            this.mPeakY = i3;
                        }
                        if (i3 < this.mValleyY) {
                            this.mValleyY = i3;
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public void addCurveSection(CurveSection curveSection) {
        if (curveSection != null) {
            this.mSections.add(curveSection);
            if (this.mSections.size() == 0) {
                setOriginPath();
            } else {
                addSection2Path(curveSection);
            }
        }
    }

    public void drawCurve(Canvas canvas) {
        ArrayList<CurveSection> arrayList = this.mSections;
        if (arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < this.mSections.size(); i++) {
                if (i == 0) {
                    drawSplitPath(canvas, this.mSections.get(i).mPoints[0], this.mSections.get(i).mPoints[this.mSections.get(i).mPoints.length - 1], this.mSections.get(i).mColor);
                } else {
                    int i2 = i - 1;
                    drawSplitPath(canvas, this.mSections.get(i2).mPoints[this.mSections.get(i2).mPoints.length - 1], this.mSections.get(i).mPoints[this.mSections.get(i2).mPoints.length - 1], this.mSections.get(i).mColor);
                }
            }
        }
    }

    public void setCurveSections(ArrayList<CurveSection> arrayList) {
        this.mSections = arrayList;
        setOriginPath();
    }

    public void setCurveStroke(int i) {
        Paint paint;
        if (i > 0 && (paint = this.mPaint) != null) {
            paint.setStrokeWidth((float) i);
        }
    }
}
