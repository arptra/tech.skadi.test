package flyme.support.v7.app.palette;

import java.util.ArrayList;
import java.util.List;

public final class ColorManager {
    private static ColorManager instance;
    private final List<ColorChangeListener> listeners = new ArrayList();

    private ColorManager() {
    }

    public static synchronized ColorManager getInstance() {
        ColorManager colorManager;
        synchronized (ColorManager.class) {
            try {
                if (instance == null) {
                    instance = new ColorManager();
                }
                colorManager = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return colorManager;
    }

    public void addListener(ColorChangeListener colorChangeListener) {
        this.listeners.add(colorChangeListener);
    }

    public void setCurrentColor(int i) {
        for (ColorChangeListener onColorChanged : this.listeners) {
            onColorChanged.onColorChanged(i);
        }
    }

    public void setCurrentLight(float f) {
        for (ColorChangeListener onLightChange : this.listeners) {
            onLightChange.onLightChange(f);
        }
    }

    public void setCurrentSaturation(float f) {
        for (ColorChangeListener onSaturationChange : this.listeners) {
            onSaturationChange.onSaturationChange(f);
        }
    }
}
