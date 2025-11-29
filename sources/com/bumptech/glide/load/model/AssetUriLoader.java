package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {
    public static final int c = 22;

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f2544a;
    public final AssetFetcherFactory b;

    public interface AssetFetcherFactory<Data> {
        DataFetcher a(AssetManager assetManager, String str);
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, AssetFetcherFactory<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f2545a;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.f2545a = assetManager;
        }

        public DataFetcher a(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f2545a, this);
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final AssetManager f2546a;

        public StreamFactory(AssetManager assetManager) {
            this.f2546a = assetManager;
        }

        public DataFetcher a(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        public ModelLoader c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f2546a, this);
        }
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory assetFetcherFactory) {
        this.f2544a = assetManager;
        this.b = assetFetcherFactory;
    }

    /* renamed from: c */
    public ModelLoader.LoadData a(Uri uri, int i, int i2, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), this.b.a(this.f2544a, uri.toString().substring(c)));
    }

    /* renamed from: d */
    public boolean b(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
