package com.here.sdk.mapview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import com.here.sdk.core.errors.InstantiationErrorException;
import com.here.sdk.mapview.MapImage;
import java.io.ByteArrayOutputStream;

public class MapImageFactory {
    private MapImageFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static MapImage fromBitmap(@NonNull Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
            try {
                return new MapImage(byteArrayOutputStream.toByteArray());
            } catch (MapImage.InstantiationException unused) {
            }
        }
        return null;
    }

    public static MapImage fromFile(@NonNull String str, int i, int i2) throws InstantiationErrorException {
        return new MapImage(str, (long) i, (long) i2);
    }

    public static MapImage fromResource(Resources resources, int i) {
        return fromBitmap(BitmapFactory.decodeResource(resources, i));
    }

    public static MapImage makeMapImage(@NonNull String str) throws MapImage.InstantiationException {
        return null;
    }

    public static MapImage makeMapImage(@NonNull byte[] bArr) throws MapImage.InstantiationException {
        return new MapImage(bArr);
    }

    public static MapImage makeMapImage(@NonNull byte[] bArr, int i, int i2) throws MapImage.InstantiationException {
        return new MapImage(bArr, i, i2);
    }

    public static MapImage makeMapImage(@NonNull String str, int i, int i2) throws MapImage.InstantiationException {
        return new MapImage(str, i, i2);
    }

    public static MapImage makeMapImage(Resources resources, int i) throws MapImage.InstantiationException {
        return fromBitmap(BitmapFactory.decodeResource(resources, i));
    }

    public static MapImage makeMapImage(@NonNull Bitmap bitmap) {
        return fromBitmap(bitmap);
    }
}
