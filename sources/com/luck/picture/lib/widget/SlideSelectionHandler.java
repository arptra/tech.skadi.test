package com.luck.picture.lib.widget;

import com.luck.picture.lib.widget.SlideSelectTouchListener;
import java.util.HashSet;
import java.util.Set;

public class SlideSelectionHandler implements SlideSelectTouchListener.OnAdvancedSlideSelectListener {

    /* renamed from: a  reason: collision with root package name */
    public final ISelectionHandler f9488a;
    public ISelectionStartFinishedListener b = null;
    public HashSet c;

    public interface ISelectionHandler {
        void a(int i, int i2, boolean z, boolean z2);

        Set getSelection();
    }

    public interface ISelectionStartFinishedListener {
        void a(int i);

        void b(int i, boolean z);
    }

    public SlideSelectionHandler(ISelectionHandler iSelectionHandler) {
        this.f9488a = iSelectionHandler;
    }

    public void a(int i) {
        this.c = null;
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.b;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.a(i);
        }
    }

    public void b(int i) {
        this.c = new HashSet();
        Set selection = this.f9488a.getSelection();
        if (selection != null) {
            this.c.addAll(selection);
        }
        boolean contains = this.c.contains(Integer.valueOf(i));
        this.f9488a.a(i, i, !this.c.contains(Integer.valueOf(i)), true);
        ISelectionStartFinishedListener iSelectionStartFinishedListener = this.b;
        if (iSelectionStartFinishedListener != null) {
            iSelectionStartFinishedListener.b(i, contains);
        }
    }

    public void c(int i, int i2, boolean z) {
        while (i <= i2) {
            d(i, i, z != this.c.contains(Integer.valueOf(i)));
            i++;
        }
    }

    public final void d(int i, int i2, boolean z) {
        this.f9488a.a(i, i2, z, false);
    }
}
