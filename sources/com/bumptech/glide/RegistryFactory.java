package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.tracing.Trace;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.DirectResourceLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.ResourceUriLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.util.GlideSuppliers;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

final class RegistryFactory {
    public static Registry a(Glide glide, List list, AppGlideModule appGlideModule) {
        BitmapPool f = glide.f();
        ArrayPool e = glide.e();
        Context applicationContext = glide.i().getApplicationContext();
        GlideExperiments g = glide.i().g();
        Registry registry = new Registry();
        b(applicationContext, registry, f, e, g);
        c(applicationContext, glide, registry, list, appGlideModule);
        return registry;
    }

    public static void b(Context context, Registry registry, BitmapPool bitmapPool, ArrayPool arrayPool, GlideExperiments glideExperiments) {
        ResourceDecoder resourceDecoder;
        ResourceDecoder resourceDecoder2;
        Class<BitmapDrawable> cls;
        Registry registry2;
        Context context2 = context;
        Registry registry3 = registry;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        registry3.o(new DefaultImageHeaderParser());
        registry3.o(new ExifInterfaceImageHeaderParser());
        Resources resources = context.getResources();
        List g = registry.g();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, g, bitmapPool2, arrayPool2);
        ResourceDecoder m = VideoDecoder.m(bitmapPool);
        Downsampler downsampler = new Downsampler(registry.g(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
        if (glideExperiments.a(GlideBuilder.EnableImageDecoderForBitmaps.class)) {
            resourceDecoder2 = new InputStreamBitmapImageDecoderResourceDecoder();
            resourceDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        } else {
            resourceDecoder = new ByteBufferBitmapDecoder(downsampler);
            resourceDecoder2 = new StreamBitmapDecoder(downsampler, arrayPool2);
        }
        Class<InputStream> cls2 = InputStream.class;
        Class<Drawable> cls3 = Drawable.class;
        registry3.e("Animation", cls2, cls3, AnimatedImageDecoder.f(g, arrayPool2));
        Class<ByteBuffer> cls4 = ByteBuffer.class;
        registry3.e("Animation", cls4, cls3, AnimatedImageDecoder.a(g, arrayPool2));
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool2);
        ResourceDrawableDecoder resourceDrawableDecoder2 = resourceDrawableDecoder;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        Class<Drawable> cls5 = cls3;
        String str = "Animation";
        Class<Bitmap> cls6 = Bitmap.class;
        registry3.a(cls4, new ByteBufferEncoder()).a(cls2, new StreamEncoder(arrayPool2)).e("Bitmap", cls4, cls6, resourceDecoder).e("Bitmap", cls2, cls6, resourceDecoder2);
        Class<ParcelFileDescriptor> cls7 = ParcelFileDescriptor.class;
        if (ParcelFileDescriptorRewinder.c()) {
            registry3.e("Bitmap", cls7, cls6, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        Class<AssetFileDescriptor> cls8 = AssetFileDescriptor.class;
        registry3.e("Bitmap", cls8, cls6, VideoDecoder.c(bitmapPool));
        Class<AssetFileDescriptor> cls9 = cls8;
        Class<BitmapDrawable> cls10 = BitmapDrawable.class;
        Registry b = registry3.e("Bitmap", cls7, cls6, m).d(cls6, cls6, UnitModelLoader.Factory.a()).e("Bitmap", cls6, cls6, new UnitBitmapDecoder()).b(cls6, bitmapEncoder).e("BitmapDrawable", cls4, cls10, new BitmapDrawableDecoder(resources, resourceDecoder)).e("BitmapDrawable", cls2, cls10, new BitmapDrawableDecoder(resources, resourceDecoder2)).e("BitmapDrawable", cls7, cls10, new BitmapDrawableDecoder(resources, m)).b(cls10, new BitmapDrawableEncoder(bitmapPool2, bitmapEncoder));
        Class<ParcelFileDescriptor> cls11 = cls7;
        ArrayPool arrayPool3 = arrayPool;
        StreamGifDecoder streamGifDecoder = new StreamGifDecoder(g, byteBufferGifDecoder, arrayPool3);
        Class<GifDrawable> cls12 = GifDrawable.class;
        String str2 = str;
        Class<GifDecoder> cls13 = GifDecoder.class;
        Registry e = b.e(str2, cls2, cls12, streamGifDecoder).e(str2, cls4, cls12, byteBufferGifDecoder).b(cls12, new GifDrawableEncoder()).d(cls13, cls13, UnitModelLoader.Factory.a()).e("Bitmap", cls13, cls6, new GifFrameResourceDecoder(bitmapPool2));
        Class<Uri> cls14 = Uri.class;
        ResourceDrawableDecoder resourceDrawableDecoder3 = resourceDrawableDecoder2;
        Class<Drawable> cls15 = cls5;
        Class<File> cls16 = File.class;
        e.c(cls14, cls15, resourceDrawableDecoder3).c(cls14, cls6, new ResourceBitmapDecoder(resourceDrawableDecoder3, bitmapPool2)).p(new ByteBufferRewinder.Factory()).d(cls16, cls4, new ByteBufferFileLoader.Factory()).d(cls16, cls2, new FileLoader.StreamFactory()).c(cls16, cls16, new FileDecoder()).d(cls16, cls11, new FileLoader.FileDescriptorFactory()).d(cls16, cls16, UnitModelLoader.Factory.a()).p(new InputStreamRewinder.Factory(arrayPool3));
        if (ParcelFileDescriptorRewinder.c()) {
            cls = cls10;
            registry2 = registry;
            registry2.p(new ParcelFileDescriptorRewinder.Factory());
        } else {
            cls = cls10;
            registry2 = registry;
        }
        ModelLoaderFactory g2 = DirectResourceLoader.g(context);
        ModelLoaderFactory c = DirectResourceLoader.c(context);
        ModelLoaderFactory e2 = DirectResourceLoader.e(context);
        Class cls17 = Integer.TYPE;
        Class<GifDrawable> cls18 = cls12;
        Class<Integer> cls19 = Integer.class;
        Class<AssetFileDescriptor> cls20 = cls9;
        registry2.d(cls17, cls2, g2).d(cls19, cls2, g2).d(cls17, cls20, c).d(cls19, cls20, c).d(cls17, cls15, e2).d(cls19, cls15, e2).d(cls14, cls2, ResourceUriLoader.f(context)).d(cls14, cls20, ResourceUriLoader.e(context));
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        Class<BitmapDrawable> cls21 = cls;
        registry2.d(cls19, cls14, uriFactory).d(cls17, cls14, uriFactory).d(cls19, cls20, assetFileDescriptorFactory).d(cls17, cls20, assetFileDescriptorFactory).d(cls19, cls2, streamFactory).d(cls17, cls2, streamFactory);
        Class<String> cls22 = String.class;
        Context context3 = context;
        registry2.d(cls22, cls2, new DataUrlLoader.StreamFactory()).d(cls14, cls2, new DataUrlLoader.StreamFactory()).d(cls22, cls2, new StringLoader.StreamFactory()).d(cls22, cls11, new StringLoader.FileDescriptorFactory()).d(cls22, cls20, new StringLoader.AssetFileDescriptorFactory()).d(cls14, cls2, new AssetUriLoader.StreamFactory(context.getAssets())).d(cls14, cls20, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).d(cls14, cls2, new MediaStoreImageThumbLoader.Factory(context3)).d(cls14, cls2, new MediaStoreVideoThumbLoader.Factory(context3));
        registry2.d(cls14, cls2, new QMediaStoreUriLoader.InputStreamFactory(context3));
        registry2.d(cls14, cls11, new QMediaStoreUriLoader.FileDescriptorFactory(context3));
        ContentResolver contentResolver2 = contentResolver;
        Class<GlideUrl> cls23 = GlideUrl.class;
        Class<byte[]> cls24 = byte[].class;
        Class<BitmapDrawable> cls25 = cls21;
        Registry q = registry2.d(cls14, cls2, new UriLoader.StreamFactory(contentResolver2)).d(cls14, cls11, new UriLoader.FileDescriptorFactory(contentResolver2)).d(cls14, cls20, new UriLoader.AssetFileDescriptorFactory(contentResolver2)).d(cls14, cls2, new UrlUriLoader.StreamFactory()).d(URL.class, cls2, new UrlLoader.StreamFactory()).d(cls14, cls16, new MediaStoreFileLoader.Factory(context3)).d(cls23, cls2, new HttpGlideUrlLoader.Factory()).d(cls24, cls4, new ByteArrayLoader.ByteBufferFactory()).d(cls24, cls2, new ByteArrayLoader.StreamFactory()).d(cls14, cls14, UnitModelLoader.Factory.a()).d(cls15, cls15, UnitModelLoader.Factory.a()).c(cls15, cls15, new UnitDrawableDecoder()).q(cls6, cls25, new BitmapDrawableTranscoder(resources));
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        q.q(cls6, cls24, bitmapBytesTranscoder2).q(cls15, cls24, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).q(cls18, cls24, gifDrawableBytesTranscoder2);
        ResourceDecoder d = VideoDecoder.d(bitmapPool);
        registry2.c(cls4, cls6, d);
        registry2.c(cls4, cls25, new BitmapDrawableDecoder(resources, d));
    }

    public static void c(Context context, Glide glide, Registry registry, List list, AppGlideModule appGlideModule) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GlideModule glideModule = (GlideModule) it.next();
            try {
                glideModule.b(context, glide, registry);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule.getClass().getName(), e);
            }
        }
        if (appGlideModule != null) {
            appGlideModule.b(context, glide, registry);
        }
    }

    public static GlideSuppliers.GlideSupplier d(final Glide glide, final List list, final AppGlideModule appGlideModule) {
        return new GlideSuppliers.GlideSupplier<Registry>() {

            /* renamed from: a  reason: collision with root package name */
            public boolean f2426a;

            /* renamed from: a */
            public Registry get() {
                if (!this.f2426a) {
                    Trace.c("Glide registry");
                    this.f2426a = true;
                    try {
                        return RegistryFactory.a(Glide.this, list, appGlideModule);
                    } finally {
                        this.f2426a = false;
                        Trace.f();
                    }
                } else {
                    throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
                }
            }
        };
    }
}
