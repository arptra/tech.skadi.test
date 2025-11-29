package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi
public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    public int a(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return c(ByteBufferUtil.g(byteBuffer), arrayPool);
    }

    public ImageHeaderParser.ImageType b(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public int c(InputStream inputStream, ArrayPool arrayPool) {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    public ImageHeaderParser.ImageType d(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
