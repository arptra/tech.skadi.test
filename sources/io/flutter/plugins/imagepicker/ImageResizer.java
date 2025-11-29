package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.SizeFCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class ImageResizer {
    private final Context context;
    private final ExifDataCopier exifDataCopier;

    public ImageResizer(@NonNull Context context2, @NonNull ExifDataCopier exifDataCopier2) {
        this.context = context2;
        this.exifDataCopier = exifDataCopier2;
    }

    private int calculateSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private SizeFCompat calculateTargetSize(double d, double d2, @Nullable Double d3, @Nullable Double d4) {
        double d5 = d;
        double d6 = d2;
        double d7 = d5 / d6;
        boolean z = false;
        boolean z2 = d3 != null;
        boolean z3 = d4 != null;
        double min = z2 ? Math.min(d5, (double) Math.round(d3.doubleValue())) : d5;
        double min2 = z3 ? Math.min(d6, (double) Math.round(d4.doubleValue())) : d6;
        boolean z4 = z2 && d3.doubleValue() < d5;
        if (z3 && d4.doubleValue() < d6) {
            z = true;
        }
        if (z4 || z) {
            double d8 = min2 * d7;
            double d9 = min / d7;
            if (d9 > min2) {
                min = (double) Math.round(d8);
            } else {
                min2 = (double) Math.round(d9);
            }
        }
        return new SizeFCompat((float) min, (float) min2);
    }

    private void copyExif(String str, String str2) {
        try {
            this.exifDataCopier.copyExif(new ExifInterface(str), new ExifInterface(str2));
        } catch (Exception e) {
            Log.e("ImageResizer", "Error preserving Exif data on selected image: " + e);
        }
    }

    private File createFile(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File createImageOnExternalDirectory(String str, Bitmap bitmap, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(hasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        File createFile = createFile(this.context.getCacheDir(), str);
        FileOutputStream createOutputStream = createOutputStream(createFile);
        createOutputStream.write(byteArrayOutputStream.toByteArray());
        createOutputStream.close();
        return createFile;
    }

    private FileOutputStream createOutputStream(File file) throws IOException {
        return new FileOutputStream(file);
    }

    private Bitmap createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }

    private Bitmap decodeFile(String str, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    private File resizedImage(Bitmap bitmap, Double d, Double d2, int i, String str) throws IOException {
        Bitmap createScaledBitmap = createScaledBitmap(bitmap, d.intValue(), d2.intValue(), false);
        return createImageOnExternalDirectory("/scaled_" + str, createScaledBitmap, i);
    }

    @VisibleForTesting
    public SizeFCompat readFileDimensions(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        decodeFile(str, options);
        return new SizeFCompat((float) options.outWidth, (float) options.outHeight);
    }

    public String resizeImageIfNeeded(String str, @Nullable Double d, @Nullable Double d2, int i) {
        SizeFCompat readFileDimensions = readFileDimensions(str);
        if (readFileDimensions.b() == -1.0f || readFileDimensions.a() == -1.0f) {
            return str;
        }
        if (d == null && d2 == null && i >= 100) {
            return str;
        }
        try {
            String[] split = str.split("/");
            String str2 = split[split.length - 1];
            double a2 = (double) readFileDimensions.a();
            SizeFCompat calculateTargetSize = calculateTargetSize((double) readFileDimensions.b(), a2, d, d2);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = calculateSampleSize(options, (int) calculateTargetSize.b(), (int) calculateTargetSize.a());
            Bitmap decodeFile = decodeFile(str, options);
            if (decodeFile == null) {
                return str;
            }
            File resizedImage = resizedImage(decodeFile, Double.valueOf((double) calculateTargetSize.b()), Double.valueOf((double) calculateTargetSize.a()), i, str2);
            copyExif(str, resizedImage.getPath());
            return resizedImage.getPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
