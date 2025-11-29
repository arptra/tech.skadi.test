package com.upuphone.ar.navi.lite.map;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import java.util.ArrayList;

public class PathOverlay extends Overlay implements IOverlay {
    public static final String s = ("NAVI-" + PathOverlay.class.getSimpleName());
    public Path l;
    public Paint m;
    public ArrayList n;
    public Point o;
    public Point p;
    public float q;
    public float r;

    public void a(Canvas canvas) {
        this.l.reset();
        this.p.x = ((Point) this.n.get(0)).x;
        this.p.y = ((Point) this.n.get(0)).y;
        Path path = this.l;
        Point point = this.p;
        path.moveTo((float) point.x, (float) point.y);
        for (int i = 1; i < this.n.size(); i++) {
            if (i < (this.n.size() * 2) / 7 || i > (this.n.size() * 4) / 7) {
                this.m.setAlpha((((i + 10) * 20) / this.n.size()) + 3);
            } else {
                this.m.setAlpha((((i + 10) * 40) / this.n.size()) + 40);
            }
            this.m.setStrokeWidth(b(i));
            Point point2 = (Point) this.n.get(i);
            this.o = point2;
            this.l.lineTo((float) point2.x, (float) point2.y);
            Point point3 = this.p;
            Point point4 = this.o;
            point3.x = point4.x;
            point3.y = point4.y;
            canvas.drawPath(this.l, this.m);
        }
    }

    public float b(int i) {
        float f = this.q;
        return f - (((f - this.r) * ((float) i)) / ((float) this.n.size()));
    }
}
