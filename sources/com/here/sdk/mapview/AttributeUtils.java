package com.here.sdk.mapview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.here.sdk.core.Color;
import com.here.sdk.mapview.MapScene;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AttributeUtils {
    private static final String LOG_TAG = "AttributeUtils";

    private static Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static MapScene.LoadSceneCallback getCallback(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        if (!context.isRestricted()) {
            String string = context.getTheme().obtainStyledAttributes(attributeSet, StyleableAttributes.mapView, 0, 0).getString(StyleableAttributes.onLoadScene);
            if (string == null || string.isEmpty()) {
                return null;
            }
            try {
                return new a(getActivity(context).getClass().getMethod(string, new Class[]{MapError.class}), context, string);
            } catch (NoSuchMethodException unused) {
                throw new IllegalStateException("Could not find a method " + string + "(MapError) in activity " + getActivity(context));
            }
        } else {
            throw new IllegalStateException("The on_load_scene attribute cannot be used within a restricted context");
        }
    }

    public static MapScheme getMapScheme(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, StyleableAttributes.mapView, 0, 0);
        int i = StyleableAttributes.mapScheme;
        if (!obtainStyledAttributes.hasValue(i)) {
            return null;
        }
        int i2 = obtainStyledAttributes.getInt(i, 0);
        switch (i2) {
            case 0:
                return MapScheme.NORMAL_DAY;
            case 1:
                return MapScheme.NORMAL_NIGHT;
            case 2:
                return MapScheme.SATELLITE;
            case 3:
                return MapScheme.HYBRID_DAY;
            case 4:
                return MapScheme.HYBRID_NIGHT;
            case 5:
                return MapScheme.LITE_DAY;
            case 6:
                return MapScheme.LITE_NIGHT;
            case 7:
                return MapScheme.LITE_HYBRID_DAY;
            case 8:
                return MapScheme.LITE_HYBRID_NIGHT;
            case 9:
                return MapScheme.LOGISTICS_DAY;
            default:
                Log.e(LOG_TAG, "Invalid map scheme value " + i2);
                return null;
        }
    }

    public static MapViewOptions getOptions(Context context, AttributeSet attributeSet) {
        MapViewOptions mapViewOptions = null;
        if (!(context == null || attributeSet == null)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, StyleableAttributes.mapView, 0, 0);
            int i = StyleableAttributes.projection;
            if (obtainStyledAttributes.hasValue(i)) {
                mapViewOptions = new MapViewOptions();
                mapViewOptions.projection = obtainStyledAttributes.getInt(i, 0) == 1 ? MapProjection.WEB_MERCATOR : MapProjection.GLOBE;
            }
            int i2 = StyleableAttributes.initialBackgroundColor;
            if (obtainStyledAttributes.hasValue(i2)) {
                if (mapViewOptions == null) {
                    mapViewOptions = new MapViewOptions();
                }
                mapViewOptions.initialBackgroundColor = Color.valueOf(obtainStyledAttributes.getColor(i2, MapView.DEFAULT_BACKGROUND_COLOR.toArgb()));
            }
            int i3 = StyleableAttributes.renderMode;
            if (obtainStyledAttributes.hasValue(i3)) {
                if (mapViewOptions == null) {
                    mapViewOptions = new MapViewOptions();
                }
                mapViewOptions.renderMode = obtainStyledAttributes.getInt(i3, 0) == 1 ? MapRenderMode.TEXTURE : MapRenderMode.SURFACE;
            }
        }
        return mapViewOptions;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getCallback$0(Method method, Context context, String str, MapError mapError) {
        try {
            method.invoke(context, new Object[]{mapError});
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(String.format("Could not execute non public method '%s' of the activity", new Object[]{str}), e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException(String.format("Could not execute method '%s' of the activity", new Object[]{str}), e2);
        }
    }
}
