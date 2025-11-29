package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

public class MockView extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f592a = new Paint();
    public Paint b = new Paint();
    public Paint c = new Paint();
    public boolean d = true;
    public boolean e = true;
    public String f = null;
    public Rect g = new Rect();
    public int h = Color.argb(255, 0, 0, 0);
    public int i = Color.argb(255, 200, 200, 200);
    public int j = Color.argb(255, 50, 50, 50);
    public int k = 4;

    public MockView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MockView_mock_label) {
                    this.f = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.d = obtainStyledAttributes.getBoolean(index, this.d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.h = obtainStyledAttributes.getColor(index, this.h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.j = obtainStyledAttributes.getColor(index, this.j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.i = obtainStyledAttributes.getColor(index, this.i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.e = obtainStyledAttributes.getBoolean(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f == null) {
            try {
                this.f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f592a.setColor(this.h);
        this.f592a.setAntiAlias(true);
        this.b.setColor(this.i);
        this.b.setAntiAlias(true);
        this.c.setColor(this.j);
        this.k = Math.round(((float) this.k) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.d) {
            width--;
            height--;
            float f2 = (float) width;
            float f3 = (float) height;
            Canvas canvas2 = canvas;
            float f4 = f2;
            canvas2.drawLine(0.0f, 0.0f, f4, f3, this.f592a);
            canvas2.drawLine(0.0f, f3, f4, 0.0f, this.f592a);
            canvas2.drawLine(0.0f, 0.0f, f4, 0.0f, this.f592a);
            float f5 = f2;
            float f6 = f3;
            canvas2.drawLine(f5, 0.0f, f4, f6, this.f592a);
            float f7 = f3;
            canvas2.drawLine(f5, f7, 0.0f, f6, this.f592a);
            canvas2.drawLine(0.0f, f7, 0.0f, 0.0f, this.f592a);
        }
        String str = this.f;
        if (str != null && this.e) {
            this.b.getTextBounds(str, 0, str.length(), this.g);
            float width2 = ((float) (width - this.g.width())) / 2.0f;
            float height2 = (((float) (height - this.g.height())) / 2.0f) + ((float) this.g.height());
            this.g.offset((int) width2, (int) height2);
            Rect rect = this.g;
            int i2 = rect.left;
            int i3 = this.k;
            rect.set(i2 - i3, rect.top - i3, rect.right + i3, rect.bottom + i3);
            canvas.drawRect(this.g, this.c);
            canvas.drawText(this.f, width2, height2, this.b);
        }
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
